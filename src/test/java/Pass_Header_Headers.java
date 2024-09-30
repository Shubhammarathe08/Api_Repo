import io.restassured.RestAssured;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Pass_Header_Headers {

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


                // 1. one by one
                //      .header("Content-Type","application/json")
                //       .header("Accept","application/json")
                //       .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")

                // 2. Headers >>
                // a. pass multiple headers directly
                //      .headers("Content-Type","application/json",
                //                "Accept","application/json",
               //                 "Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")

              // a. pass multiple headers directly
              //        HashMap<String, String> h_map = new HashMap<>();
        //        h_map.put("Content-Type","application/json");
        //        h_map.put("Accept","application/json");
        //        h_map.put("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=");
        //
        //        .headers(h_map)


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
