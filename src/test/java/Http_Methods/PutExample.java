package Http_Methods;

import static io.restassured.RestAssured.given;

public class PutExample {

public static void main(String[] args){
    String base_url = "https://restful-booker.herokuapp.com";
    String base_path = "/{path}/{id}";
    String payload = "{\n" +
            "    \"firstname\" : \"Baba Baba\",\n" +
            "    \"lastname\" : \"Black sheep\",\n" +
            "    \"totalprice\" : 222,\n" +
            "    \"depositpaid\" : false,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    given()
            .baseUri(base_url)
            .basePath(base_path)
            .pathParam("path","booking")
            .pathParam("id",1)
            .header("Content-Type","application/json")
            .header("Accept","application/json")
            .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
            .body(payload)
            .log().all()
    .when()
            .put()
    .then()
            .log().all();

}


}
