import io.restassured.RestAssured;
import io.restassured.config.*;
import io.restassured.config.RestAssuredConfig;
import org.apache.http.Header;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class MultipleHeadsers {

    public static void main(String[] args){

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking/{id}";
        String payload = "{\n" +
                "    \"firstname\" : \"Nina\",\n" +
                "    \"lastname\" : \"Black\",\n" +
                "    \"totalprice\" : 555,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

//        given()
//                .pathParam("id",1)
//                .header("Content-Type","application/json")
//                .header("Accept","application/json")
//                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
//                .body(payload).log().all()
//                .when().put()
//                .then().log().all();

//        given()
//                .pathParam("id",1)
//                .headers("Content-Type","application/json",
//                        "Accept","application/json",
//                        "Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
//                .body(payload).log().all()
//                .when().put()
//                .then().log().all();

        HashMap<String, String> h_map = new HashMap<>();
        h_map.put("Content-Type","application/json");
        h_map.put("Accept","application/json");
        h_map.put("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=");

        given()
                .pathParam("id",1)
                .headers(h_map)
                .body(payload).log().all()
                .when().put()
                .then().log().all();

    }
}
