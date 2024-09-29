package Http_Methods;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PatchExample {

    public static void main(String[] args){
        String base_url = "https://restful-booker.herokuapp.com";
        String base_path = "/{path}/{id}";
        String patch_body = "{\n" +
                "    \"firstname\" : \"patch kro\",\n" +
                "    \"lastname\" : \"sachhi mucchi\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .baseUri(base_url)
                .basePath(base_path)
                .pathParam("path", "booking")
                .pathParam("id", 1)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body(patch_body)
                .log().all()
        .when()
                .patch()
        .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
}
