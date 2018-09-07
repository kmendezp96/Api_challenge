Feature: Top five songs
  As a User
  I want to see the top five songs
  so that i can know the five more listened songs

  Scenario: See the top five more listened songs
    Given I can see the list of the instances that the provided store has
    When I go to /charts/top-five
    Then the system response with an "200" status code
    And I see the list of five more listen songs