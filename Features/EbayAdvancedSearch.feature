Feature: Ebay Advanced Search Page

  @P24
  Scenario: Ebay Logo on Advanced Search Page
    Given I am on Ebay Advanced Search Page
    When I click on Ebay Logo
    Then I am navigated to Ebay Home Page

  @P300 @setCookies
  Scenario: Advanced search an item
    Given I am on Ebay Advanced Search Page
    When I advanced Search an iterm
      | keyword   | exclude     | min | max |
      | iphone 11 | refurbished | 300 | 900 |
