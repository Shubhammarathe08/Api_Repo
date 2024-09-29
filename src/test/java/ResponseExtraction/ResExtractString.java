package ResponseExtraction;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResExtractString {

    public static void main(String[] args){

        String base_url  = "https://restful-booker.herokuapp.com";
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        String base_path = "/{b_path}/{id}";
        String body = ""; //not needed in Get Request

        Map<String,Object> h_m = new HashMap<>();
        h_m.put("b_path","booking");
        h_m.put("id","2");

       String res_body =  given()
                .contentType(ContentType.JSON)
                .baseUri(base_url)
                .basePath(base_path)
                .pathParams(h_m)
                .when()
                    .get()
                .then()
              //  .extract().body().asString();
               .extract().body().asPrettyString();

       System.out.println(res_body);


    }
}
