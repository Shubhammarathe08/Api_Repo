package JsonPath;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ComplexObjectJsonPath {
    public static void main(String[] args){
        String body_path = "C:\\Users\\shubh\\IdeaProjects\\Api_Repo\\src\\test\\java\\TestData\\JsonPath_ComplexObject.json";
        File complex_body = new File(body_path);
        JsonPath js = new JsonPath(complex_body);
        // get Map/Object - can contain only key and value
        // value can be any | another object, array, string, int etc...
        Map<String, Object> obj = js.getMap("$");
        System.out.println(obj);

        // use JsonPath $ for root and key for direct-key
        System.out.println(js.get("$").toString());

        // find in specific-key | for first matched value from all values
        System.out.println(js.get("key_4.find{ it.id > 200 }").toString());

        // find in specific-key | for first matched value get specific value from all values
        System.out.println(js.get("key_4.find{ it.id > 200 }.name").toString());

        // find in whole object | for first matched value and get specific value fron
        System.out.println(js.getList("findAll{ it.id > 200 }").toString());

    }
//----------------------------------------------------------------------------------------------
}
