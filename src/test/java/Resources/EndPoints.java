package Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Rates;
public class EndPoints {

    private static final String BASE_URL = "https://api.ratesapi.io/api";

    public static IRestResponse<Rates> getLatestRates() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        Response response = request.get(Route.rates());
        return new RestResponse(Rates.class, response);
    }

    public static IRestResponse<Rates> getSpecificDateRates() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        Response response = request.get(Route.specificDaterates());
        return new RestResponse(Rates.class, response);
    }

    public static IRestResponse<Rates> getInvalidRatesUrl() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        Response response = request.get(Route.getInvalidrateurl());
        return new RestResponse(Rates.class, response);
    }

}
