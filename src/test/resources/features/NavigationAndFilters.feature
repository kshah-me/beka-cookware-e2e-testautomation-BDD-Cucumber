Feature: Navigation & Categories
  User should be able to search available Products and an error message in case product is not available


  Background:
    Given Launch the application url
    When Select application language based on configuration

  Scenario: User navigate to Main menu tabs
    When User click on About Beka Menu button
    Then Verify About Beka page should be displayed
    When User click on Find a store Menu button
    Then Verify Find a store page should be displayed
    When User click on Best Sellers Menu button
    Then Verify Best Sellers page should be displayed

  Scenario: User navigate to side menu tabs
    When User click on Outlet button
    Then Verify Outlet page should be displayed
    When User click on Inspiration button
    Then Verify Inspiration page should be displayed
    When User click on Profile button
    Then Verify Login page should be displayed
    And Navigate back to original page
    When User click on wishlist button
    Then Verify wishlist page should be displayed
    When User click on Add Cart button
    Then Verify Cart page should be displayed


  Scenario: No broken images and missing product name under Product grid
    When User hover on Product tab
    Then Verify all images under product grid are not broken
    Then Verify product names under product grid are not missing



  Scenario: No broken images and missing product name under Collections grid
    When User hover on Collections tab
    Then Verify all images under collection grid are not broken
    Then Verify product names under collection grid are not missing


  Scenario: Navigate to Filter page
    And Click on Skillets product
    Then Verify Product filter page displayed


  Scenario: Apply the multiple filter and verify updated result page
    When User hover on Product tab
    And Click on Frying pan product
    And Get the Initial Count Before Filter
    And Select Aluminium as Material filter
    Then Verify result has been updated
    And Select Heat Source & Dishwasher filter as Electric
    Then Verify result has been updated



  Scenario: Apply the multiple filter and verify no record displayed
    When User hover on Product tab
    And Click on Sets product
    And Get the Initial Count Before Filter
    And Select Aluminium as Material filter
    Then Verify result has been updated
    And Select Heat Source & Dishwasher filter as Electric
    Then Verify result has been updated
    And Enter max price as 10
    Then Verify a message should be displayed