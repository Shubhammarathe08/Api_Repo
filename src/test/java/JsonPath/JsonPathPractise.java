package JsonPath;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonPathPractise {

    public static void main(String[] args){

        String file_path
                = "C:\\Users\\Lenovo\\Java_Projects\\Api_Automation" +
                  "\\src\\test\\java\\TestData\\Complex_Array_People.json";
        File  Complex_Array_People = new File(file_path);
        JsonPath js_p1 = new JsonPath(Complex_Array_People);

        String file_path1
                = "C:\\Users\\Lenovo\\Java_Projects\\Api_Automation" +
                "\\src\\test\\java\\TestData\\Complex_Object_People_Address.json";
        File  Complex_Object_People_Address = new File(file_path1);
        JsonPath js_p2 = new JsonPath(Complex_Object_People_Address);

        String file_path2
                = "C:\\Users\\Lenovo\\Java_Projects\\Api_Automation" +
                "\\src\\test\\java\\TestData\\Complex_Array_Of_Array.json";
        File  Complex_Array_Of_Array = new File(file_path2);
        JsonPath js_p3 = new JsonPath(Complex_Array_Of_Array);


//--------------------------- Complex_Array_People --------------------------------------
        System.out.println(js_p1.getInt("[0].id")); //get simple int value from key
        System.out.println(js_p1.getString("[0].name")); //get simple string value from key

        System.out.println(js_p1.get("$").toString());//if we don't know what tye of object is
        System.out.println(js_p1.get("[0]").toString());//get object from array

        // get list of objects inside array
        List<Object> obj_list = new ArrayList<>();

        for(int i=0; i<js_p1.getList("$").size(); i++){
            System.out.println(js_p1.get("["+i+"]").toString());
        }

        System.out.println(js_p1.get("id").toString());// get all matching keys : values

        List<Integer> ids = js_p1.getList("id");//lit of all matching elements
        System.out.println(ids+" >> ids");

        List<Integer> names = js_p1.getList("name");//lit of all matching elements
        System.out.println(names+" >> names");

        //use filters find findAll
        List<Object> filtered_obj = js_p1.getList("findAll{it.id<=5}");
        System.out.println(  "filtered_obj >>"+filtered_obj);

        List<String> filtered_obj_names = js_p1.getList("findAll{it.id>=5}.name");
        System.out.println(  "filtered_obj_names >>"+filtered_obj_names);

        List<String> filtered_obj_emails = js_p1.getList("findAll{it.gender == 'male'}.email");
        System.out.println(  "filtered_obj_emails >>"+filtered_obj_emails);

        List<Integer> filtered_obj_and_combo = js_p1.getList("findAll{it.gender == 'female' " +
                "& " +
                "it.status == 'active'}.id");
        System.out.println(  "filtered_obj_and_combo >>"+filtered_obj_and_combo);

        List<Integer> filtered_obj_or_combo = js_p1.getList("findAll{it.id <5 " +
                "|" +
                "it.status == 'inactive'}.id");
        System.out.println(  "filtered_obj_or_combo >>"+filtered_obj_or_combo);

        System.out.println("/////////////////////////////////////////////////////////////////////////////");
//---------------------------  Complex_Object_People_Address  --------------------------------------
        System.out.println();

        System.out.println( js_p2.getString("$"));
        System.out.println( js_p2.getString("data"));
        System.out.println( js_p2.getString("data[0].name"));
        System.out.println( js_p2.getString("data[3].addresses.city"));
        System.out.println( js_p2.getString("data[4].addresses.city"));

        //get all state of address object
        System.out.println( js_p2.getString("data.addresses.city") +" >> data.addresses.city");
        System.out.println( js_p2.getString("addresses.city")+" >> addresses.city ");
        System.out.println( js_p2.getString("data.city")+" >> city");

        //use filters find findAll
        System.out.println( " data.find{it.city} >>"+js_p2.getString("data.find{it.city}"));
        System.out.println(
                " data.find{combo} >>"
                        +js_p2.getString("data.find{it.city != 'bhopal' & it.gender == 'female' }.name")
        );

        System.out.println("/////////////////////////////////////////////////////////////////////////////");
//---------------------------  Complex_Array_Of_Array --------------------------------------

        System.out.println();
        System.out.println(js_p3.get().toString());// whole response

        System.out.println(js_p3.getString("[0].name")+" >>[0].name");
        System.out.println(js_p3.getString("[1][2]")+" >>[1][2]");

        List<Object> array_of_array = js_p3.getList("$");
        int array_of_array_size = js_p3.getList("$").size();

        System.out.println(array_of_array_size);
        for(int i=0; i<array_of_array_size; i++){
            System.out.println(js_p3.get("["+i+"]").toString());
        }

        List<Object> a_o_a_oth = (List<Object>) js_p3.getList("$").get(1);
        System.out.println(a_o_a_oth);







    }
}
