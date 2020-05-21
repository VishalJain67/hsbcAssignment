Feature: Validating Rates API
  Description: As a User, I want to be able to have an automated testing framework available which covers different scenarios for the Rates API
  So that I can make sure that the API’s are fit for purpose in the use of the exchange rate for financial reasons

  @LatestForeignExchangeRates
  Scenario: Verify whether Rates API for Latest Foreign Exchange rates returns success status in the response when a VALID GET request is sent
    Given Rates API for Latest Foreign Exchange rates is available
    When a valid GET request is sent
    Then the API call returns success code 200
    And "base" in response body is "EUR"

  @LatestForeignExchangeRates
  Scenario Outline: Verify Rates are populated in the response for Rates API for Latest Foreign Exchange rates
    Given Rates API for Latest Foreign Exchange rates is available
    When a valid GET request is sent
    Then the API call returns success code 200
    And "<rate>" in response body is "<values>"
    Examples:
      | rate | values   |
      | GBP  | 0.8972   |
      | HKD  | 11.2301  |
      | IDR  | 13281.14 |
      | PLN  | 4.0838   |
      | DKK  | 7.4405   |
      | LVL  | 0.7093   |
      | INR  | 66.21    |
      | CHF  | 1.4743   |
      | MXN  | 18.4995  |
      | CZK  | 26.258   |



  @LatestForeignExchangeRates
  Scenario: Verify whether Rates API for Latest Foreign Exchange rates returns failure status in the response when a INVALID GET request is sent
    Given Rates API for Latest Foreign Exchange rates is available
    When an invalid GET request is sent
    Then the invalid API call returns a failure in response


  @DateSpecificForeignExchangeRates
  Scenario: Verify whether Rates API for Specific date Foreign Exchange rates returns success status in the response when a VALID GET request is sent
    Given Rates API for Latest Foreign Exchange rates is available
    When a valid GET request is sent for Specific date
    Then the API call returns success code 200 for Specific Date
    And "base" in response body is "EUR"

  @DateSpecificForeignExchangeRates
  Scenario Outline: Verify Rates are populated in the response for Rates API for Specific date Foreign Exchange rates
    Given Rates API for Latest Foreign Exchange rates is available
    When a valid GET request is sent for Specific date
    Then the API call returns success code 200 for Specific Date
    And "<rate>" in response body is "<values>"
    Examples:
      | rate | values   |
      | GBP  | 0.8972   |
      | HKD  | 11.2301  |
      | IDR  | 13281.14 |
      | PLN  | 4.0838   |
      | DKK  | 7.4405   |
      | LVL  | 0.7093   |
      | INR  | 66.21    |
      | CHF  | 1.4743   |
      | MXN  | 18.4995  |
      | CZK  | 26.258   |

  @DateSpecificForeignExchangeRates
  Scenario Outline: Verify that the response matches for the current date if a future date is provided in the url for Rates API for Specific date Foreign Exchange rates
    Given Rates API for Latest Foreign Exchange rates is available
    When a valid GET request is sent for Specific date
    Then the API call returns success code 200 for Specific Date
    And "date" in response body is "<latest date>"
    Examples:
      | latest date |
      |  2010-05-20 |
