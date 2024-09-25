import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetExample {

    public static void main(String[] args){

        String base_url  = "https://restful-booker.herokuapp.com";
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        String base_path = "/{b_path}/{id}";
        String body = ""; //not needed in Get Request
//
//        RequestSpecification req_res = given();
//        req_res.contentType(ContentType.JSON);
//        req_res.baseUri(base_url);
//        req_res.basePath(base_path);
//        req_res.pathParam("id",1);
//        req_res.log().all();
//
//        Response res = req_res.get();
//        ValidatableResponse v_res = res.then().log().all();
//
//        v_res.statusCode(200);



//        given().contentType(ContentType.JSON)
//                .baseUri(base_url).basePath(base_path).pathParam("id",10)
//                .log().all()
//                   .when().get()
//                          .then().statusCode(200).log().all();


//given()
//        .contentType(ContentType.JSON)
//        .basePath(base_path)
//        .pathParam("id",2)
//        .log().all()
//                .when()
//                     .get(base_url)
//                .then()
//                     .statusCode(200).log().all();

//        given()
//                .contentType(ContentType.JSON)
//                .log().all()
//                .when()
//                .get(base_url+"/{path}/{id}","booking",2)
//                .then()
//                .statusCode(200).log().all();


//        given()
//                .contentType(ContentType.JSON)
//                .basePath(base_path)
//                .pathParam("path","booking")
//                .pathParam("id",4)
//                .log().all()
//                .when()
//                .get(base_url+"/{path}/{id}")
//                .then()
//                .statusCode(200).log().all();

 Map<String,Object> h_m = new HashMap<>();
        h_m.put("b_path","booking");
        h_m.put("id","2");

        given()
                .contentType(ContentType.JSON)
                .baseUri(base_url)
                .basePath(base_path)
                .pathParams(h_m)
                .log().all()
                .when()
                .get()
                .then()
                .statusCode(200).log().all();







    }
}
