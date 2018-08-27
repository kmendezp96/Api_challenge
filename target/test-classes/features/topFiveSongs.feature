Feature: Top five songs
  As a User
  I want to see the top five songs
  so that i can know the five more listened songs

  Scenario: See the top five more listened songs
    Given I want to see the top five songs
    When I go to /charts/top-five
    Then I see the list of five more listen songs
    And the system response a "200" status code
