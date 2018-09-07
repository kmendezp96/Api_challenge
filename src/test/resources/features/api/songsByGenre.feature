Feature: Songs by genre
  As a User
  I want to filter songs by its genre
  so that i can know the songs that belongs to a specific genre

  Scenario Outline: filter songs by genre - positive
    Given I can see the list of the instances that the provided store has
    When I make a request to see the songs of a "<genre>"
    Then the system response with an "200" status code
    And the system returns all the songs of that genre
    Examples:
      | genre     |
      | punk      |
      | hip%20hop |

  Scenario Outline: filter songs by genre - negative
    Given I can see the list of the instances that the provided store has
    When I make a request to see the songs of a "<genre>"
    Then the system response with an "500" status code
    Examples:
      | genre     |
      | punk      |
      | hip%20hop   |