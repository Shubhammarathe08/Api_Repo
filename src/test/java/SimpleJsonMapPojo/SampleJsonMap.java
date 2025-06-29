package SimpleJsonMapPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class SampleJsonMap {

    public static void main(String[] args){
      // list ? object
        List<Object> final_payload = new ArrayList<>();

        HashMap<String,Object>person_1  = new LinkedHashMap<>();
        person_1.put("id",1);
        person_1.put("name", "Aanand Iyer");
        person_1.put("email", "aanand_iyer@wilkinson-roob.example");
        person_1.put("gender", "female");
        person_1.put("status", true);
        person_1.put( "city", "bhopal" );
        final_payload.add(person_1);

        System.out.println(final_payload);//---------------------------------

        HashMap<String,Object>address1  = new LinkedHashMap<>();
        address1.put("state","maharashtra");
        address1.put("city","pune");

        HashMap<String,Object>address2  = new LinkedHashMap<>();
        address2.put("state","");
        address2.put("city","");

        List<Object> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);

        HashMap<String,Object>person_2  = new LinkedHashMap<>();
        person_2.put("firstname","rajesh");
        person_2.put("is_alive","true");
        person_2.put("addresses",addresses);

        final_payload.add(person_2);
        System.out.println(final_payload);//---------------------------

        List<String> names = new ArrayList<>();
        names.add("shubham");
        names.add("satyam");
        names.add("nilesh");
        names.add("rani");
        final_payload.add(names);
        System.out.println(final_payload);//---------------------------













    }
}
