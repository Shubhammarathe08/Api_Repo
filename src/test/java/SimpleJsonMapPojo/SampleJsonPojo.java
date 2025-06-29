package SimpleJsonMapPojo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SampleJsonPojo {

    public static void main(String[] args) throws JsonProcessingException {

        List<Object> elements = new ArrayList<>();
//------------------------------------------------------------------------------------
        SimpleJsonP1 p1 = new SimpleJsonP1();
        p1.setId(1);
        p1.setName("xxx");
        p1.setEmail("sss@gmail.com");
        p1.setGender("male");
        p1.setCity("rrr");
        p1.setStatus(false);
        elements.add(p1);
//------------------------------------------------------------------------------------
        SimpleJsonP2 p2 = new SimpleJsonP2();
        p2.setFirst_name("yyy");
        p2.setIs_alive(true);

        SimpleJsonAddr addr1 = new SimpleJsonAddr();
        addr1.setState("mmm");
        addr1.setCity("pune");

        SimpleJsonAddr addr2 = new SimpleJsonAddr();
        addr2.setState("");
        addr2.setCity("");

        ArrayList<SimpleJsonAddr> temp = new ArrayList<>();
        temp.add(addr1);
        temp.add(addr2);

        p2.setAddresses(temp);

        elements.add(p2);

//------------------------------------------------------------------------------------
        List<String> names = Arrays.asList("shubham","satyam","nilesh","rani");
        elements.add(names);

//-------------------------------------------------------------------------------------
        System.out.println(elements);

        ObjectMapper ob = new ObjectMapper();
        String str = ob.writerWithDefaultPrettyPrinter().writeValueAsString(elements);
        System.out.println(str);
    }

}
