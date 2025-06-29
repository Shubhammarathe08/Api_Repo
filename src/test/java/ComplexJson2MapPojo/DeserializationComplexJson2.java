package ComplexJson2MapPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class DeserializationComplexJson2 {


    static String response = "{\n" +
            "  \"companyName\": \"XYZ Ltd\",\n" +
            "  \"Street\": \"Arifac Avenue\",\n" +
            "  \"City\": \"RK Puram, Delhi\",\n" +
            "  \"State\": \"New Delhi\",\n" +
            "  \"pin_code\": 110066,\n" +
            "  \"BankAccounts\": [\"HDFC\", \"SBI\", \"AXIS\"],\n" +
            "  \"employees\": [\n" +
            "    {\n" +
            "      \"firstName\": \"Suresh\",\n" +
            "      \"lastName\": \"Mehra\",\n" +
            "      \"gender\": \"Male\",\n" +
            "      \"age\": 35,\n" +
            "      \"salary\": 10000.56,\n" +
            "      \"Address\": {\n" +
            "        \"Street\": \"Park Avenue\",\n" +
            "        \"City\": \"Vijaywada\",\n" +
            "        \"State\": \"Andhra Pradesh\",\n" +
            "        \"pin_code\": 530012\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"firstName\": \"Ashish\",\n" +
            "      \"lastName\": \"Das\",\n" +
            "      \"gender\": \"Male\",\n" +
            "      \"age\": 39,\n" +
            "      \"salary\": 55000,\n" +
            "      \"Address\": {\n" +
            "        \"Street\": \"Plot 8\",\n" +
            "        \"City\": \"Dwarka\",\n" +
            "        \"State\": \"New Delhi\",\n" +
            "        \"pin_code\": 110066\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";

    public static void main(String[] args) {

        Response res = RestAssured.given()
                .when().get("https://mocki.io/v1/a24a83f7-24f1-4573-9d89-8bf0978178fd");

        //https://mocki.io/fake-json-api
        //https://mocki.io/v1/a24a83f7-24f1-4573-9d89-8bf0978178fd

        // List temp1 = res.as(List.class);
        // System.out.println(temp1);

        //Cannot deserialize value of type `java.util.ArrayList<java.lang.Object>`
        // from Object value (token `JsonToken.START_OBJECT`)
        // response is MAP >> how can we deserialize to List ?

        Object obj = res.as(Object.class);

        if (obj instanceof List) {
            List temp1 = res.as(List.class);
            System.out.println(temp1);
            System.out.println(temp1.size());
        } else if (obj instanceof Map) {
            Map temp1 = res.as(Map.class);
            System.out.println(temp1);
            System.out.println(temp1.keySet());
        }

        ComplexJson2Pojo resposne_obj = res.as(ComplexJson2Pojo.class);
        System.out.println(resposne_obj);
        System.out.println(resposne_obj.getBankAccounts());


    }
}
