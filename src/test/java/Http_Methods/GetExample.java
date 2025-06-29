package Http_Methods;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetExample {

    public static void main(String[] args){

        Response res =
                given() // return type RequestSpecification
                                       .log().all().
                 when() // return type RequestSpecification
                  .get("https://restful-booker.herokuapp.com/booking/4");

        System.out.println(res);
        res.getStatusCode();
        res.headers();
        res.time();
        res.body();


//
//      String res_body =  given() // return type RequestSpecification
//                .log().all().
//        when() // return type RequestSpecification
//                .get("https://restful-booker.herokuapp.com/booking/4").
//        then() // return type validatable response
//                .log()
//                .all()
//                .assertThat()
//                .statusCode(200) //status cdoe
//                .extract()
//                .response()
//                .body()
//                .toString();
//      System.out.println(res_body);


//        //https://api.instantwebtools.net/v1/airlines
//        ValidatableResponse res = RestAssured.given()
//                .baseUri("https://api.instantwebtools.net")
//                .basePath("/v1/airlines")
//                .log()
//                .all().
//        when().
//               get().
//        then().
//                log()
//                .all()
//                .assertThat()
//                .statusCode(200);
//        String body = res.toString();
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        System.out.println(body);









    }
}
