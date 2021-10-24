Feature: Test order pick up feature is working

  Scenario:  Scenario: Click on order pick up
    Given User is on the Grocery Page
    When user clicks on the order pick up
    And user enters items name to search
    Then user click on the Search button
