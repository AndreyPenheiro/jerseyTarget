Feature: Test same day delivery feature is working

  Scenario: Click on same day delivery
    Given a user is on the Grocery Page
    When user clicks on the same day delivery feature
    And User enters items name to search
    Then User click on the search button