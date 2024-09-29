package Http_Methods;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class PostExample {

    public static void main(String[] args){

      String base_url  = "https://restful-booker.herokuapp.com";
      String base_path = "/booking";
      String body = "{\n" +
              "    \"firstname\" : \"First\",\n" +
              "    \"lastname\" : \"Booking\",\n" +
              "    \"totalprice\" : 111,\n" +
              "    \"depositpaid\" : true,\n" +
              "    \"bookingdates\" : {\n" +
              "        \"checkin\" : \"2018-01-01\",\n" +
              "        \"checkout\" : \"2019-01-01\"\n" +
              "    },\n" +
              "    \"additionalneeds\" : \"Breakfast\"\n" +
              "}";

        ValidatableResponse v_res =  given()
                  .baseUri(base_url)
                  .basePath(base_path)
                  .header("Content-Type","application/json")
                  .header("Accept","application/json")
                  .body(body)
                  .log().all()
          .when()
                  .post()

          .then()
                  .log()
                  .all();

        v_res
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .time(Matchers.lessThan(5000l));

        JsonPath js = v_res.extract().response().jsonPath();

        System.out.println(js.getString("booking.bookingdates.checkin"));

       Map<String, Object> bookingdates_obj = js.get("booking.bookingdates");
        System.out.println(bookingdates_obj);

        Map<String, Object> root_node_obj = js.get("$");
        System.out.println(root_node_obj);




    }

}
