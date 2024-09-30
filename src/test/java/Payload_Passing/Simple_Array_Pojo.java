package Payload_Passing;

import io.restassured.RestAssured;

import java.util.*;

public class Simple_Array_Pojo {

    public static void main(String[] args){

        //for main Object
        List<Object> List_Payload =  new ArrayList<>();

        //for first Map Object
        Map<String,Object> person =  new LinkedHashMap<>();
        person.put("id",1);
        person.put("name","Aanand Iyer");
        person.put("email","aanand_iyer@wilkinson-roob.example");
        person.put("gender","female");
        person.put("status",true);
        person.put("city","bhopal");

        //for second Map Object
        Map<String,Object> person_address =  new LinkedHashMap<>();
        person_address.put("firstname","rajesh");
        person_address.put("is_alive","true");

        //sub map addresses
        List<Map<String,String>> addresses =   new ArrayList<>();

        Map<String,String> address_1 =  new LinkedHashMap<>();
        address_1.put("state","maharsahtra");
        address_1.put("city","pune");
        Map<String,String> address_2 =  new LinkedHashMap<>();
        address_2.put("state","");
        address_2.put("city","");


        //for third List Object
        List<String> sibling_names =  new ArrayList<>();
        sibling_names.addAll(Arrays.asList(    "shubham",
                "satyam",
                "nilesh",
                "rani"));

        //now add all elements to final payload
        List_Payload.add(person);
        addresses.add(address_1);
        addresses.add(address_2);
        person_address.put("addresses",addresses);
        List_Payload.add(person_address);
        List_Payload.add(sibling_names);

        System.out.println(List_Payload);

        RestAssured
                .given()
                .body(List_Payload)
                .log()
                .all()
                .get();

    }

}
