package Payload_Passing;

import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Simple_Object_Pojo {

    public static void main(String[] args){

        //for main Object
        Map<String,Object> Obj_Payload =  new LinkedHashMap<>();

        //Students : list of objects
        List<Object> students = new ArrayList<>();

        //for child Objects of list
        Map<String, Object> student_child_1 =  new LinkedHashMap<>();
        student_child_1.put("id",123);
        student_child_1.put("name","ajay");
        student_child_1.put("age",15);
        student_child_1.put("alive",true);
        student_child_1.put("balance",3000);

        Map<String, Object> student_child_2 =  new LinkedHashMap<>();
        student_child_2.put("id",456);
        student_child_2.put("name","sumit");
        student_child_2.put("age",96);
        student_child_2.put("alive",false);
        student_child_2.put("balance",500000);

        Map<String, Object> student_child_3 =  new LinkedHashMap<>();
        student_child_3.put("id",789);
        student_child_3.put("name","menka");
        student_child_3.put("age",25);
        student_child_3.put("alive",true);
        student_child_3.put("balance",7000);

        students.add(student_child_1);
        students.add(student_child_2);
        students.add(student_child_3);

        // 2nd element Map of addresses
        Map<String,Object> addresses =  new LinkedHashMap<>();
        addresses.put("state","madhya pradesh");
        addresses.put("city","burhanpur");

        //list of expense
        List<Object> Expense = new ArrayList<>();

        //for child Objects of list
        Expense.add(10);
        Expense.add(20);
        Expense.add(30);
        Expense.add(40);
        Expense.add(50);
        Expense.add(60);

        //adding elements to final payload
     Obj_Payload.put("students",students);
     Obj_Payload.put("addresses",addresses);
     Obj_Payload.put("Expense",Expense);

     System.out.println(Obj_Payload);

        RestAssured
                .given()
                .body(Obj_Payload)
                .log()
                .all()
                .get();


    }
}
