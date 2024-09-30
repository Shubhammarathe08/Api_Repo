package Response_Parsing;

import io.restassured.common.mapper.TypeRef;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Response_To_Map_TypeRef_Simple_Object {

    public static void main(String[] args){

        //TypeRef >> to define user defined generic
        // new TypeRef<>(){} -> abstract

        System.out.println("###############################################################");
        Map<String,String> res_store = given()
                .get("https://run.mocky.io/v3/4c35f356-4fe3-4ce9-abbc-325e69982af4")
                //.as(Map.class);
                .as(new TypeRef<Map<String, String>>() {
                });

        System.out.println(res_store);


    }
}
