package Response_Parsing;

import io.restassured.RestAssured;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Response_To_Map_Simple_Array {

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

        System.out.println("###############################################################");
        List res_store = given()
                .get("https://run.mocky.io/v3/e25a0c19-d183-4bea-85c0-60845a3bcea5")
                //.as(Map.class);
                .as(List.class);

        System.out.println(res_store);
        Iterator it = res_store.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        List<String> names = (List<String>) res_store.get(2);
        System.out.println(names.get(1));

        System.out.println("###############################################################");
        given()
                .body(List_Payload)
                .log()
                .all()
                .get();

    }

}
