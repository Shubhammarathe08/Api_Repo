package JsonPath;
import io.restassured.path.json.JsonPath;
import java.io.File;
import java.util.List;
import java.util.Map;

public class SimpleObjectJsonPath {

    public static void main(String[] args){
        String body_path = "C:\\Users\\shubh\\IdeaProjects\\Api_Repo\\src\\test\\java\\TestData\\JsonPath_SimpleObject.json";
        File body = new File(body_path);
        JsonPath js = new JsonPath(body);
        //get Map/Object - can contain only key and value
        // value can be any object/another object/string,int etc...
        Map<String, Object> obj = js.getMap("$");
        System.out.println(obj);

        //use JsonPath $ for root and key for direct key
        System.out.println(js.get("$").toString());
        // specific key
        System.out.println(js.get("id").toString());
        System.out.println(js.get("name").toString());
        //filter find , findAll doesn't work, returns null -for single object
        String res = js.get("find { it.age < 15 }.name"); // doesn't work -gives null
        List<String> res1 = js.getList("find { it.age < 15 }.name"); // doesn't work -gives null
        System.out.println(res);
        System.out.println(res1);
        //use this for filteration
        if(js.getDouble("age")<15){
            System.out.println( js.get("name").toString() );
        }
    }
//----------------------------------------------------------------------------------------------
}
