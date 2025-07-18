package Response_Parsing;

import io.restassured.common.mapper.TypeRef;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Response_To_Map_TypeRef_Simple_Array {

    public static void main(String[] args){
        //TypeRef >> to define user defined generic
        // new TypeRef<>(){} -> abstract

        System.out.println("###############################################################");
        List<Map<String,String>> res_store = given()
                .get("https://mocki.io/v1/bbb8663e-33bf-4f6b-8748-0dbe077cd086")
                //.as(Map.class);
                .as(new TypeRef<List<Map<String, String>>>() {
                });

        System.out.println(res_store);

    }

}
