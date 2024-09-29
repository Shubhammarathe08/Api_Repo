package Http_Methods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Get_Baseuri_Basepath_Pathparam_Examples {
    public static void main(String[] args){
        String base_url  = "https://restful-booker.herokuapp.com";
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        String base_path = "/{b_path}/{id}";
        basePath = "/{b_path}/{id}";
        String body = ""; //not needed in Get Request

                //1. basic pass full endpoint directly
                // get("https://restful-booker.herokuapp.com/booking/4")
                //2.pass url and parameter from Get
                //.get(base_url+"/{path}/{id}","booking",2)
                //3. pass params from pathParam
                    // .pathParam("path","booking")
                    //.pathParam("id",4)
                //3. passing Map in pathParams()
                    // Map<String,Object> h_m = new HashMap<>();
                    //        h_m.put("b_path","booking");
                    //        h_m.put("id","2");
                    //                .pathParams(h_m)

        given()
                .pathParam("b_path","booking")
                .pathParam("id","2")
                .log().all().
        when()
                .get().
        then()
                .log()
                .all();

    }
}
