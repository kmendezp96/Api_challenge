Feature:
  As kafka administrator
  I want to update an existing song
  so that i can change some attributes of that song

  Scenario Outline: Update song
    Given I have access to Kafka Service
    And the song with "<id>" exists
    When I change the attributes album: "<album>", artist: "<artist>", name: "<name>" and genre: "<genre>" to song with id: "<id>"
    Then I can search the song with id: "<id>"
    Examples:
      | id | album                  | artist       | name                      | genre   |
      | 1  | London Calling         | the Clash    | Spanish Bombs             | Punk    |
      | 10 | Fear Of A Black Planet | Public Enemy | Welcome to the Terrordome | Hip Hop |
      | 15 | Nimrod                 | Green day    | Nice guys finish last     | Punk    |
