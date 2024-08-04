Feature: Ebay Home Page Scenarios

  @P1 @setCookies @Test @P2
  Scenario: Advanced Search Link
    Given I am on Ebay Home Page
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  @P2 
  Scenario: Search items count
    Given I am on Ebay Home Page for iphone search
    When I search for 'iphone 11'
    Then I validate atlease 1000 search itmes present

  @P3 @setCookies
  Scenario: Search items count2
    Given I am on Ebay Home Page for iphone search
    When I search for 'Toy Cars'
    Then I validate atlease 100 search itmes present

  @P240
  Scenario: Search an item in category
    Given I am on Ebay Home Page
    When I search for 'soap' in 'baby'


  @P500
  Scenario Outline: Home Page Links
    Given I am on Ebay Home Page
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and titile contains '<title>'

    Examples: 
      | link        | url                                                  | title       |
      | Electronics | https://www.ebay.com/b/Electronics/bn_7000259124     | Electronics |
      | Fashion     | https://www.ebay.com/b/Fashion/bn_7000259856         | Fashion     |
      | Sports      | https://www.ebay.com/b/Sporting-Goods/888/bn_1865031 | Sports      |
