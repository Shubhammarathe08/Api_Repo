package Json_Schemas;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SchemaValidation {

    public static void main(String[] args){

       ValidatableResponse val_res =  given().contentType(ContentType.JSON)
        .when().get("https://run.mocky.io/v3/0765f934-022b-4ec5-9aa4-d3d478f0a187")
        .then().log().all();

       File json_file = new File("C:\\Users\\Lenovo\\Java_Projects\\Api_Automation" +
               "\\src\\test\\java\\TestData\\Complex_Object_People_Address_Schema.json");

       File temp = new File("C:\\Users\\Lenovo\\Java_Projects\\Api_Automation" +
               "\\src\\test\\java\\Json_Schemas\\Complex_Object_People_Address_Schema.txt");

        val_res.body(JsonSchemaValidator.matchesJsonSchema(temp));



    }
}
