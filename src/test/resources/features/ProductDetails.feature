Feature: Product Details Page Features
  User should be able see product name, price, description, images, review and other details


  Background:
    Given Launch the application url
    When Select application language based on configuration
    And User clicks on search icon
    When User enters "Saucepans" product name in Searchbox
    And User click on Search Button
    And Click on first item on search result page

  Scenario: Product name on Product details page
    Then Verify product name is not empty on Product details page

  Scenario: Product price on Product details page
    Then Verify product price is not empty on Product details page
    Then Verify product price is in Euro on Product details page


  Scenario: Product review on Product details page
    Then Verify product review is not empty on Product details page

  Scenario: Add to cart button on Product details page
    Then Verify Add To Cart button is displayed on product details page


  Scenario: Product image on Product details page
    Then Verify product image is not broken on Product details page
    Then Verify product image gallery is not broken on Product details page


  Scenario: Product description on Product details page
    Then Verify product specification is not empty on Product details page
    Then Verify product description is not empty on Product details page
    Then Verify product characteristics is not empty on Product details page
    Then Verify product Care and use is not empty on Product details page


  Scenario: Add to Favorites without Login on Product Details Page
    And Click on Add to Favorites button on Product details page
    Then Verify Tooltip message on Product details page
