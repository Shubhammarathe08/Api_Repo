package ResponseExtraction;

import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class Extract_Time_And_Assert {

    public static void main(String[] args) {
        String base_url = "https://restful-booker.herokuapp.com/";
        String base_path = "booking";
        String body = "{\n" +
                "    \"firstname\" : \"Bhai\",\n" +
                "    \"lastname\" : \"sahab\",\n" +
                "    \"totalprice\" : 70,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-01-01\",\n" +
                "        \"checkout\" : \"2022-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

      ValidatableResponse val_res =   given()
                .baseUri(base_url)
                .basePath(base_path)
                .body(body).
        when().
                post().
        then();

      //time assertions
        val_res
                .assertThat().time(Matchers.lessThan(5000l));

        Long res_time_1 = val_res.extract().response().time();
        Long res_time_2 = val_res.extract().response().timeIn(TimeUnit.SECONDS);

        Long res_time_3 = val_res.extract().response().getTime();
        Long res_time_4 = val_res.extract().response().getTimeIn(TimeUnit.SECONDS);

        val_res.time(Matchers.lessThan(10000l));
        val_res.time(Matchers.lessThan(10000l))
                 .and()
                     .time(Matchers.greaterThan(2000l));
        val_res.time(Matchers.greaterThan(2000l));
        val_res.time(Matchers.equalTo(1000l));


    }
}
