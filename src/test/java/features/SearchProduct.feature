Feature: Search Product on Amazon

  Background:
    Given user is on home page

  Scenario Outline: Search a product on Amazon and verify the results
    When user enter product <product> in search box
    And user click on search button
    Then user verify the results contains the text <result>

    Examples:
      | product | result       |
      | iphone  | Apple iPhone |
