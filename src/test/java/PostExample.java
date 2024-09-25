


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class PostExample {

    public static void main(String[] args){

      String base_url  = "https://restful-booker.herokuapp.com/";
      String base_path = "booking";
      String body = "{\n" +
              "    \"firstname\" : \"Shubham\",\n" +
              "    \"lastname\" : \"Marathe\",\n" +
              "    \"totalprice\" : 200,\n" +
              "    \"depositpaid\" : false,\n" +
              "    \"bookingdates\" : {\n" +
              "        \"checkin\" : \"2022-01-01\",\n" +
              "        \"checkout\" : \"2022-01-01\"\n" +
              "    },\n" +
              "    \"additionalneeds\" : \"Lunch\"\n" +
              "}";

//        RequestSpecification req_spec = given().body(body);
//        req_spec.log().all();
//        req_spec.baseUri(base_url)
//                .basePath(base_path)
//                .contentType(ContentType.JSON);
//        req_spec.when().post();
//        Response res = req_spec.when().post();
//        ValidatableResponse v_res = res.then();
//        v_res.statusCode(200);
//        v_res.log().all();

        given().baseUri(base_url).basePath(base_path)
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                //hit request with method
                .when().post()
                //get response and validate
                .then().statusCode(200)
                .log().all();




    }

}
