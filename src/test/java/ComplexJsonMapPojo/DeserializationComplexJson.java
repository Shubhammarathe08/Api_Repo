package ComplexJsonMapPojo;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class DeserializationComplexJson {


    static String response = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"first_name\": \"Claire\",\n" +
            "    \"last_name\": \"Dennerley\",\n" +
            "    \"email\": \"cdennerley0@uol.com.br\",\n" +
            "    \"gender\": \"Genderfluid\",\n" +
            "    \"mobile\": [\n" +
            "      \"1232432432\",\n" +
            "      \"324324324\"\n" +
            "    ],\n" +
            "    \"skills\": {\n" +
            "      \"name\": \"Testing\",\n" +
            "      \"proficiency\": \"Medium\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"first_name\": \"Cloe\",\n" +
            "    \"last_name\": \"Stuehmeyer\",\n" +
            "    \"email\": \"cstuehmeyer1@yellowpages.com\",\n" +
            "    \"gender\": \"Female\",\n" +
            "    \"skills\": [\n" +
            "      {\n" +
            "        \"name\": \"Testing\",\n" +
            "        \"proficiency\": \"Medium\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Java\",\n" +
            "        \"proficiency\": \"Medium\",\n" +
            "        \"certifications\": [\n" +
            "          \"OCJP 11\",\n" +
            "          \"OCJP 12\"\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]\n";
    public static void main(String[] args){

        Response res = RestAssured.given()
                .when().get("https://mocki.io/v1/f2ba73d6-00aa-4242-9283-a0f0bcec73ca");

        //https://mocki.io/fake-json-api
        //https://mocki.io/v1/f2ba73d6-00aa-4242-9283-a0f0bcec73ca

         // Map temp = res.as(Map.class);
        //  System.out.println(temp);

        // Cannot deserialize value of type `java.util.LinkedHashMap<java.lang.Object,java.lang.Object>`
        // from Array value (token `JsonToken.START_ARRAY`)
        // response is LIST >> how can we deserialize to Object ?

        Object obj = res.as(Object.class);

        if(obj instanceof  List){
            List temp1 = res.as(List.class);
            System.out.println(temp1);
            System.out.println(temp1.size());
        }
        else if(obj instanceof  Map){
            Map temp1 = res.as(Map.class);
            System.out.println(temp1);
            System.out.println(temp1.keySet());
        }


    }
}
