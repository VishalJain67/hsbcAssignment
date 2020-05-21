package StepDefinition;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    StepDefinitions sd = new StepDefinitions();

    @Before("@LatestForeignExchangeRates")
    public void beforeScenarioLatestRate() throws IOException {
        sd.ratesAPIForLatestForeignExchangeRatesIsAvailable();
        sd.aValidGETRequestIsSent();
        sd.the_API_call_returns_success_code(200);
    }

    @Before("@DateSpecificForeignExchangeRates")
    public void beforeScenarioSpecificDate() throws IOException {
        sd.ratesAPIForSpecificDateForeignExchangeRatesIsAvailable();
        sd.aValidGETRequestIsSentForSpecificDate();
        sd.the_API_call_returns_success_code_for_SpecificDate(200);
    }
}
