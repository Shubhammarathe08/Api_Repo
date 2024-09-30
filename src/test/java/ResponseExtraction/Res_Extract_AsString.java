package ResponseExtraction;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class Res_Extract_AsString {

    public static void main(String[] args){


        RestAssured.baseURI = "https://reqres.in/api";
        basePath = " /{users}?{page}=2";

      ValidatableResponse val_res =  given()
                .pathParam("users","users")
                .queryParam("page","2")
                .log().all().
        when()
                .get().
        then()
                .log()
                .all()
                .statusCode(200);


        System.out.println("/////////////////////////////////////////////////////////");


      String body = val_res.extract().response().body().asPrettyString();
      System.out.println(body);

    }
}
