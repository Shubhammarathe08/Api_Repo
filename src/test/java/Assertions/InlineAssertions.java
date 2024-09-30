package Assertions;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class InlineAssertions {

    public static void main(String[] args){

       Response rs =  given()
               .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
        .when()
                .post("https://restful-booker.herokuapp.com/auth")
        .then()
                .extract().response();

        System.out.println(rs.jsonPath().getString("$")    );
        Assert.assertNotNull(rs.jsonPath().getString("token"));

        rs.then().body("token", Matchers.notNullValue());
        rs.then().body("token.length()", Matchers.equalTo(15));
        rs.then().body("token", Matchers.contains("a"));
        rs.then().body("token.length()", Matchers.is(10));
        rs.then().body("token.length()", Matchers.hasLength(10));

    }
}
