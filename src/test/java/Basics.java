

// import Other_Package.StaticImportExample;
import Other_Package.MethodChaining;
import io.restassured.response.Response;
//static import
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Other_Package.StaticImportExample.*;

import static io.restassured.RestAssured.*;

public class Basics {
    public static void main(String[] args){
        //Response res = (Response) given() .when() .then();

        // no need to specify class/object to use methods of Static import class
       printSomething();
       returnSum(2,44);

       //method chaining,on single object, w/o need to store o/p
        MethodChaining m = new MethodChaining();
        m.m1().m2(2,22).m3(" Shubham ");

        //other example of method chaining
        List<String> li = new ArrayList<>(Arrays.asList("ss","nn","ok","No","oh","rr"));
       li =  li.stream()//return stream
                .map( ip -> ip+" Wow!!! ")//return stream
                      .collect(Collectors.toList());//terminal op can return other class
       System.out.println(li);
    }
}
