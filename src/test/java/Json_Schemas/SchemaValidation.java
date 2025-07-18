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
        .when().get("https://mocki.io/v1/bbb8663e-33bf-4f6b-8748-0dbe077cd086")
        .then().log().all();

       File json_file = new File("C:\\Users\\shubh\\IdeaProjects\\Api_Repo\\src\\test\\java\\TestData\\Complex_Object_People_Address_Schema.json");

       File temp = new File("C:\\Users\\shubh\\IdeaProjects\\Api_Repo\\src\\test\\java\\TestData\\Complex_Object_People_Address_Schema_Txt.txt");

       //can be anywhere, just give file OR string json schema
        val_res.body(JsonSchemaValidator.matchesJsonSchema(json_file));
        val_res.body(JsonSchemaValidator.matchesJsonSchema(temp));
        // file must be under java/test/resources
        val_res.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Complex_Object_People_Address_Schema_Txt.txt"));
        val_res.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Complex_Object_People_Address_Schema.json"));
       // val_res.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("\\src\\test\\java\\TestData\\Complex_Object_People_Address_Schema.json"));
        // schema >> definition , structure , blueprint
        // can ignore / un-imp fields or can be empty

            /*
    1. validatable response - compare schema.json file in class path
    .then()
    .assertThat()
    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("user_schema.json"));

    2. validatable response - compare schema.json directly with
    .then()
    .body(JsonSchemaValidator.matchesJsonSchema(schema));
    */



    }
}
