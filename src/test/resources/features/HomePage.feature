Feature: Home Page Features
         User should be able to launch url, able to Change Language, Navigation to different pages and footer details


  Background:
    Given Launch the application url
    When Select application language based on configuration

  Scenario: Logo on Home page
    Then Verify logo is present on home page

  Scenario: Page title in English
    When User select the "English" Language
    Then Verify page title as "Beka Cookware"

  Scenario: Page title in Dutch
    When User select the "Dutch" Language
    Then Verify page title as "Beka Cookware"

  Scenario: Application is in Dutch Language
    When User select the "Dutch" Language
    Then Verify application is in "Dutch" Language

  Scenario: Application is in English Language
    When User select the "English" Language
    Then Verify application is in "English" Language


  Scenario: Application is in French Language
    When User select the "French" Language
    Then Verify application is in "French" Language

  Scenario: Application is in Deutsch Language
    When User select the "Deutsch" Language
    Then Verify application is in "Deutsch" Language

  Scenario: Navigation on homepage
    Then Verify all Main menu and sub menus are working


  Scenario: Footers on homepage
    Then Verify all footer items are working