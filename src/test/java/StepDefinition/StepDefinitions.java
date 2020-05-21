package StepDefinition;
import Resources.EndPoints;
import Resources.IRestResponse;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Rates;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class StepDefinitions extends Utils {

    private static IRestResponse<Rates> ratesResponse;
    private static IRestResponse<Rates> invalidRate;
    private static IRestResponse<Rates> specificDateRate;

    @Given("Rates API for Latest Foreign Exchange rates is available")
    public void ratesAPIForLatestForeignExchangeRatesIsAvailable() throws IOException {
        assertNotNull(getGlobalValue("baseUrl"));
    }
    @When("a valid GET request is sent")
    public void aValidGETRequestIsSent() {
        ratesResponse = EndPoints.getLatestRates();
    }

    @Then("the API call returns success code {int}")
    public void the_API_call_returns_success_code(int code) {
        assertEquals("Status code did not match",ratesResponse.getStatusCode(),code);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        if(expectedValue.contains(".")){
            assertEquals(String.format("Mismatch between Actual:'%s' and Expected:'%s' ", keyValue, expectedValue), expectedValue, getJsonPath((Response) ratesResponse, keyValue));
        }else{
            assertEquals(String.format("Mismatch between Actual:'%s' and Expected:'%s' ",keyValue,expectedValue),expectedValue,getJsonPath((Response) specificDateRate,keyValue));
        }
    }

    @When("an invalid GET request is sent")
    public void anInvalidGETRequestIsSent() {
        invalidRate = EndPoints.getInvalidRatesUrl();

    }

    @Then("the invalid API call returns a failure in response")
    public void theAPICallReturnsAFailureInResponse() {
        Assert.assertEquals(invalidRate.getStatusCode(), 400);
    }



    @Given("Rates API for Specific date Foreign Exchange rates is available")
    public void ratesAPIForSpecificDateForeignExchangeRatesIsAvailable() throws IOException {
        assertNotNull(getGlobalValue("baseUrl"));
    }
    @When("a valid GET request is sent for Specific date")
    public void aValidGETRequestIsSentForSpecificDate() {
        specificDateRate = EndPoints.getSpecificDateRates();
    }

    @Then("the API call returns success code {int} for Specific Date")
    public void the_API_call_returns_success_code_for_SpecificDate(int code) {
        assertEquals("Status code did not match",specificDateRate.getStatusCode(),code);
    }

}
