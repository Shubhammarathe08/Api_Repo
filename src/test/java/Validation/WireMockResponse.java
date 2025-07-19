package Validation;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static io.restassured.RestAssured.*;

public class WireMockResponse {

    static final String HOST = "localhost";
    static final int PORT = 8080;
    WireMockServer server = new WireMockServer(PORT);
    static final String ENDPOINT = "/complex_json/array";

    @BeforeClass
    public void setup_server () {
        // Start WireMock
        server.start();
        WireMock.configureFor(HOST, PORT);

        // Build mock response
        ResponseDefinitionBuilder mock_res = new ResponseDefinitionBuilder()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBodyFile("Complex_Array_Of_Array.json");

        WireMock.stubFor(WireMock.get(ENDPOINT).willReturn(mock_res));
        System.out.println("Mocked endpoint: " + ENDPOINT);
    }

    @Test
    public void sample_test () {
        String endpoint = "http://" + HOST + ":" + PORT + ENDPOINT;
        System.out.println("Endpoint: " + endpoint);

        ValidatableResponse response = given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all();

        String body = response.extract().body().asString();
        JsonPath js = new JsonPath(body);
        int root_len = js.getList("$").size();
        System.out.println(root_len);

        List<Object> root = js.getList("$");
        System.out.println(root);

        List<Object> list_1_obj = js.getList("[0]");
        System.out.println(list_1_obj);

        String status = js.get("[0][0].status");
        System.out.println(status);
    }

    @AfterClass
    public void teardown_server() {
        if (server != null && server.isRunning()) {
            server.stop();
            System.out.println("WireMock server stopped.");
        }
    }
}
