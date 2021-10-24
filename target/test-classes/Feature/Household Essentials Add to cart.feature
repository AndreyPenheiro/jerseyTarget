Feature: Test Household Essentials Add to cart feature is working

  Scenario: Click on Add to cart
    Given User is on the Household Essentials page
    When user search item by name or code
    And user click on Add For Pickup
    Then User click on continue shopping