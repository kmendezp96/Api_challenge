Feature: Songs by id
  As a User
  I want to filter a song by it's id
  so that i can search an specific song

  Scenario Outline: Filter songs by id - positive
    Given I can see the list of the instances that the provided store has
    When I go to /song/"<id>"
    Then the system response with an "200" status code
    Then I see a json with the specified song
    Examples:
    | id |
    | 1  |
    | 4  |
    | 12 |

  Scenario: Filter songs by id invalid id - negative
    Given I can see the list of the instances that the provided store has
    When I go to /song/"<id>"
    Then the system response with an "404" status code
