Feature: Cart Details Page Features
  User should be able to launch url, able to Change Language, Navigation to different pages and footer details


  Background:
    Given Launch the application url
    When Select application language based on configuration
    And User clicks on search icon


  Scenario: Add product into cart page
    And User enters "Tea and coffee" product name in Searchbox
    And User click on Search Button
    And Click on first item on search result page
    And Click on Add to Cart button
    Then Verify product has been added to cart page
    And Click on close cart button
    Then Verify product count on cart icon is same


  Scenario: Product name and price are same in cart
    And User enters "Chef" product name in Searchbox
    And User click on Search Button
    And Click on first item on search result page
    And Click on Add to Cart button
    Then Verify product name is same on cart page
    Then Verify product price is same on cart page
    Then Verify Product suggestion under cart page
    Then Verify image of product suggested under cart page are not broken


  Scenario: Product free shipping and return days policies
    And User enters "pan" product name in Searchbox
    And User click on Search Button
    And Click on first item on search result page
    And Click on Add to Cart button
    Then Verify shipping details and return policy on cart page
    Then Verify delivery eligibility based on price


  Scenario: Product price increase as per count and total price in cart
    And User enters "Pann" product name in Searchbox
    And User click on Search Button
    And Click on first item on search result page
    And Click on Add to Cart button
    Then Increase the product count to 1
    Then Verify the total price


  Scenario: Product total price as zero in cart
    And User enters "Plate" product name in Searchbox
    And User click on Search Button
    And Click on first item on search result page
    And Click on Add to Cart button
    And Click on delete button against the product
    Then Verify the total price as zero


  Scenario: Max count of an Product in cart
    And User enters "Casserole" product name in Searchbox
    And User click on Search Button
    And Click on first item on search result page
    And Click on Add to Cart button
    Then Increase the product count to 10
    Then Verify the total price for 10 products