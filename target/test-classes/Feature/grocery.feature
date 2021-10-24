Feature: Test Grocery feature is working

  Scenario: Click on Grocery
    Given  User is on the Categories drop down
    When User clicks on the Grocery
    And User clicks on explore all
    Then User is navigated to Grocery page
