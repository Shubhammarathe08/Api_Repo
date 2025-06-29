package ComplexJson2MapPojo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class ResponseValidationComplexJson2 {

    public static void main(String[] args){

        Response res = RestAssured.given()
                .when().get("https://mocki.io/v1/a24a83f7-24f1-4573-9d89-8bf0978178fd");

        String body = res.asString();
         try{
             JsonObject j_obj = JsonParser.parseString(body).getAsJsonObject();
             System.out.println(j_obj);
         }
         catch(Exception e){
             JsonArray j_arr = JsonParser.parseString(body).getAsJsonArray();
             System.out.println(j_arr);
         }

        JsonObject j_obj = JsonParser.parseString(body).getAsJsonObject();
        System.out.println(j_obj);

        System.out.println(j_obj.keySet());
        System.out.println(j_obj.get("BankAccounts"));
        System.out.println(j_obj.get("employees"));

        // [] Array/list  {} object/Map

        JsonArray j_obj1 = j_obj.get("employees").getAsJsonArray();
        System.out.println(j_obj1.get(0).getAsJsonObject().get("firstName"));




    }
}
