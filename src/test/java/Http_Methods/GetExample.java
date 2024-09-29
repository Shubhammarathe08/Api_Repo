package Http_Methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetExample {

    public static void main(String[] args){

        given()
                .log().all().
        when()
                .get("https://restful-booker.herokuapp.com/booking/4").
        then()
                .log()
                .all()
                .statusCode(200);








    }
}
