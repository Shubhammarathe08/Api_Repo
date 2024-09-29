import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class StaticVariableRestAssured {

    public static final String BASEURI = "";



    public static void main(String[] args){
        RestAssured.baseURI = "www.google.com";
        basePath = "/search";


    }
}
