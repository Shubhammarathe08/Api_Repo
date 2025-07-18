package Http_Methods;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;

public class GetExample {

    public static void main(String[] args) throws FileNotFoundException {


                ValidatableResponse r =given() // return type RequestSpecification
                        .when().get().then();
                   r.assertThat();
                   r.statusCode(200);// validate status code
                   r.extract().response();//ResponseOptions
                   r.extract().time();// response time
        r.extract().body().asString();
        JsonPath js = JsonPath.from(r.extract().body().asString());
        JsonPath js1 = JsonPath.from(given().when().get("").getBody().asString());

        Response r1 =given() // return type RequestSpecification
                .when().get();
        r1.getHeader("");
        Assert.assertEquals("","");




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
