Feature: Songs by id
  As a User
  I want to filter a song by it's id
  so that i can search an specific song

  Scenario Outline: Filter songs by id - positive
    Given I want to see a song with an specific id
    When I go to /song/"<id>"
    Then the system response with an "200" status code
    Then I see a json with the specified song
    Examples:
    | id |
    | 1  |
    | 4  |
    | 12 |

  Scenario: Filter songs by id - negative
    Given I want to see a song with an specific id
    When I go to /song/"<id>" with an invalid id
    Then the system response with an "404" status code
