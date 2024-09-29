package ResponseExtraction;

import io.restassured.path.json.JsonPath;

import java.util.List;

public class JsonPathExtraction {

    public static void main(String[] args){
        //$ root node
        //. child node
        //[] array node
        //{} object
        //[] array

        String get_josn_obj = "{\n" +
                "    \"firstname\": \"Susan\",\n" +
                "    \"lastname\": \"Smith\",\n" +
                "    \"totalprice\": 171,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2016-08-06\",\n" +
                "        \"checkout\": \"2020-09-29\"\n" +
                "    }\n" +
                "}";

        String simple_1_d_json_arr = "[\n" +
                "     10,\n" +
                "    \"Hello\",\n" +
                "    true,\n" +
                "    10.5\n" +
                "]";
        String simple_2_d_json_arr = "[\n" +
                "  [\n" +
                " 10,\n" +
                "    \"Hello\",\n" +
                "    true,\n" +
                "      10.5\n" +
                "  ],  \n" +
                "[\n" +
                " 20,\n" +
                "    \"Bello\",\n" +
                "    false,\n" +
                "      20.5\n" +
                " ]\n" +
                "\n" +
                "]";

        JsonPath js = new JsonPath(get_josn_obj);
        System.out.println(js.getString("$"));


        System.out.println(js.getString("firstname"));//string
        System.out.println(js.getInt("totalprice"));//int
        System.out.println(js.getBoolean("depositpaid"));//boolean
        System.out.println(js.getString("bookingdates.checkin"));

        Object obj = js.get("$");//object

        JsonPath js_arr = new JsonPath(simple_1_d_json_arr);
        System.out.println(js_arr.getString("$"));
        System.out.println(js_arr.getString("[0]"));
        System.out.println(js_arr.getList("$").size());

        JsonPath js_arr_1 = new JsonPath(simple_2_d_json_arr);
        System.out.println(js_arr_1.getString("$"));
        System.out.println(js_arr_1.getString("[0]"));
        System.out.println(js_arr_1.getString("[1][2]"));
        System.out.println(js_arr_1.getList("$").size());

        List<Object> li_1 = (List<Object>) js_arr_1.getList("$").get(0);
        List<Object> li_2 = (List<Object>) js_arr_1.getList("$").get(1);
        System.out.println(li_1);
        System.out.println(li_2);







    }
}
