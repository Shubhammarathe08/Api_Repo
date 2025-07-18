package Validation;

public class ValidateJsonSchema {
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
