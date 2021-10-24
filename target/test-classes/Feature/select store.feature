Feature: Test Select store feature is working

  Scenario: Click on You're shopping(current state name)
    Given a user is on the home page
    When user clicks on You're shopping
    And user enters the zip code or city,state
    Then User clicks on look up