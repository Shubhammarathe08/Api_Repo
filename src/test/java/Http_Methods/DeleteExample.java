package Http_Methods;

import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class DeleteExample {

    public static void main(String[] args){
        String base_url = "https://restful-booker.herokuapp.com";
        String base_path = "/{base_path}/{id}";

        HashMap<String, Object> h_map = new HashMap<>();
        h_map.put("base_path","booking");
        h_map.put("id",1);

        given().contentType(ContentType.JSON)
                .baseUri(base_url)
                .basePath(base_path)
                .pathParams(h_map)
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .log().all()
                   .when()
                       .delete()
                   .then()
                        .statusCode(201)
                        .log().all();
    }
}
