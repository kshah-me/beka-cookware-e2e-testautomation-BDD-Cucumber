Feature: Negative Cases
  An error message for Negative scenarios

  Background:
    Given Launch the application url
    When Select application language based on configuration


  Scenario: An error message on login page with invalid username
    And User click on Profile button
    And User enter invalid username "test.com"
    Then Verify an error message for invalid username


  Scenario: An error message on checkout page for invalid voucher code
    And User clicks on search icon
    And User enters "Tea and coffee" product name in Searchbox
    And User click on Search Button
    And Click on first item on search result page
    And Click on Add to Cart button
    And Click on Proceed to Checkout button
    And User enter invalid Voucher code "abc"
    And User click on Voucher code apply button
    Then Verify an error message for invalid Voucher code