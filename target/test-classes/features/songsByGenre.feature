Feature: Songs by genre
  As a User
  I want to filter songs by its genre
  so that i can know the songs that belongs to a specific genre

  Scenario Outline:
    Given I want to see the songs of a genre
    When I make a REST request to see the songs of a "<genre>"
    Then the system response with "200" status code
    And the system returns one json with all the songs of that genre
    Examples:
    | genre     |
    | Punk      |
    | Hip Hop   |

  Scenario:
    Given I want to see the songs of a genre
    When I make a REST request to see the songs of an invalid "rock" genre
    Then the system response with "404" status code
