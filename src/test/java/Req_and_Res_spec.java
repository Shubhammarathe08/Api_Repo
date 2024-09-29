import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;

public class Req_and_Res_spec {

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
        ResponseSpecification res_spec = expect()
                .statusCode(200)
                .time(Matchers.lessThan(5000l))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();




        given()
                .spec(req_spec)
                .body(body)
        .when()
                .post()
        .then()
                .spec(res_spec);














    }
}
