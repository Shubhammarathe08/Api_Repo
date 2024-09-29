package ResponseExtraction;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class ResponseVsValidatableResponse {

    // Response - gives what we need
    // ValidatableResponse - validates by comparing response with passed values

    public static void main(String[] args){
        String base_url  = "https://restful-booker.herokuapp.com/";
        String base_path = "booking";
        String body = "{\n" +
                "    \"firstname\" : \"Bhai\",\n" +
                "    \"lastname\" : \"Errrrrrrrr\",\n" +
                "    \"totalprice\" : 200,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-01-01\",\n" +
                "        \"checkout\" : \"2022-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        RequestSpecification req_spec = given()
                .baseUri(base_url)
                .basePath(base_path)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .log().all();

        ResponseSpecification res_spec = expect().statusCode(200)
                .time(Matchers.lessThan(5000l));


        // Response
        Response res1 = given(req_spec)
                .body(body)
                .when().post();
        res1.body().asPrettyString();
        res1.time();// in millisecond
        res1.timeIn(TimeUnit.SECONDS); //can define time unit
        res1.statusCode();
        res1.headers();

        System.out.println("////////////////////////////////////////////////////////////////");

        Response res2 = given(req_spec)
                .body(body)
                .when().post()
                .then().extract().response();
        res2.body().asPrettyString();
        res2.time();
        res2.statusCode();
        res2.headers();

        System.out.println("////////////////////////////////////////////////////////////////");

        // Validate Response
        ValidatableResponse v_res1 = given(req_spec)
                .body(body)
                .when().post()
                .then().log().all();
        v_res1.extract().body().asPrettyString();
        String get_value =
                v_res1.extract().body().jsonPath().getString("booking.firstname");
        System.out.println("get_value >>"+get_value);
        v_res1.statusCode(200);
        v_res1.header("Content-Type", "application/json; charset=utf-8");

        System.out.println("////////////////////////////////////////////////////////////////");


        ValidatableResponse v_res2 = given(req_spec)
                .body(body)
                .when().post()
                .then().log().all()
                .spec(res_spec);

        v_res2.extract().body().asPrettyString();
        String get_value1 =
                v_res2.extract().body().jsonPath().getString("bookingid");
        System.out.println("get_value1 >>"+get_value1);
        v_res2.statusCode(200);
        v_res2.header("Content-Type", "application/json; charset=utf-8");









    }
}
