Feature: Search Product
  User should be able to Search available product and an error message for not available product


  Background:
    Given Launch the application url
    When Select application language based on configuration


  Scenario Outline: Search with valid product name
    And User clicks on search icon
    When User enters "<productname>" product name in Searchbox
    And User click on Search Button
    Then Verify user should navigates to search page
    Then Verify result count on search result page should be displayed
    Examples:
      | productname  |
      | Plate	       |
      | Pan |
      | Fraying	     |


  Scenario: An error message in english when product is not available into system
    And User select the "English" Language
    And User clicks on search icon
    When User enters "ABCD" product name in Searchbox
    And User click on Search Button
    Then Verify No Record Found error message in "English" language on search result page should be displayed


  Scenario: An error message in Dutch when product is not available into system
    And User select the "Dutch" Language
    And User clicks on search icon
    When User enters "Indra" product name in Searchbox
    And User click on Search Button
    Then Verify No Record Found error message in "Dutch" language on search result page should be displayed


  Scenario: Image on Search result page are not broken for First page
    And User clicks on search icon
    When User enters "Cooker" product name in Searchbox
    And User click on Search Button
    Then Verify image of all products on search result page are not broken


  Scenario: Description of products on Search result page are not empty for First page
    And User clicks on search icon
    When User enters "Plates" product name in Searchbox
    And User click on Search Button
    Then Verify description of all products on search result page are not empty


  Scenario: Each product name are hyperlink on search result page for First page
    And User clicks on search icon
    When User enters "Saucepans" product name in Searchbox
    And User click on Search Button
    Then Verify each product name is hyperlink on search result page


  Scenario: Search another product from Search result page
    And User clicks on search icon
    When User enters "Tea and coffee" product name in Searchbox
    And User click on Search Button
    Then User enters again valid product name as "Chef"
    And User click on Search Button on Search Result Page
    Then Verify search result page with "Chef" details should be displayed

