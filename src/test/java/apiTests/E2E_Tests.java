package apiTests;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Map;
public class E2E_Tests {



    public static void main(String[] args) {
        String baseUrl = "https://api.ratesapi.io/api";
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given();
        Response response;
        String jsonString;

        response = httpRequest.get("/latest");
        Assert.assertEquals(response.getStatusCode(), 200);

        response = httpRequest.get("/latest");
        jsonString = response.asString();
        Map<String, String> rates = JsonPath.from(jsonString).get("rates");
        Assert.assertTrue(rates.size() > 0);

        /*String gbp = rates.get(0).get("GBP");
        Assert.assertEquals(gbp, 0.89153);*/

        response = httpRequest.get("/");
        Assert.assertEquals(response.getStatusCode(), 400);



        response = httpRequest.get("/2010-01-12");
        Assert.assertEquals(response.getStatusCode(), 200);

        response = httpRequest.get("/2010-01-12");
        String jsonString2 = response.asString();
        Map<String, String> rates2 = JsonPath.from(jsonString).get("rates");
      /*  String gbp2 = rates.get(0).get("GBP");
        Assert.assertEquals(gbp, 0.8972);*/

        response = httpRequest.get("/2020-12-12");
        Assert.assertEquals(response.getStatusCode(), 200);


    }
}
