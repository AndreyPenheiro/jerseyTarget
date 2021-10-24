Feature: Test Household Essentials feature is working

  Scenario: Click on Household Essentials
    Given a user is on the Categories drop down
    When user clicks on the Household Essentials
    And user clicks on Explore all
    Then user is navigated to Household Essentials page
