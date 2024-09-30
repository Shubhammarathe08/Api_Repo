import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Request_Response_Specification {
    String base_url = "https://restful-booker.herokuapp.com/";
    String base_path = "booking";
    RequestSpecification req_spec;
    ResponseSpecification res_spec;

    @BeforeTest
    public void setUp() {
        req_spec = given()
                .baseUri(base_url)
                .basePath(base_path)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .log().all();
        res_spec = expect()
                .statusCode(200)
                .time(Matchers.lessThan(5000l))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }

    @AfterTest
    public void tearDown() {
           System.out.println("Test finished >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }


    @Test(priority = 1)
    public void req_res_spec() {
        String body = "{\n" +
                "    \"firstname\" : \"Dost\",\n" +
                "    \"lastname\" : \"jigari\",\n" +
                "    \"totalprice\" : 500,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-01-01\",\n" +
                "        \"checkout\" : \"2022-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        given()
                .spec(req_spec)
                .body(body)
       .when()
                .post()
       .then()
                .spec(res_spec);
    }



    @Test(priority = 2)
    public void req_res_spec1() {
        String body = "{\n" +
                "    \"firstname\" : \"Dushman\",\n" +
                "    \"lastname\" : \"jaani\",\n" +
                "    \"totalprice\" : 500,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-01-01\",\n" +
                "        \"checkout\" : \"2022-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        given()
                .spec(req_spec)
                .body(body)
        .when()
                .post()
        .then()
                .spec(res_spec);
    }
}
