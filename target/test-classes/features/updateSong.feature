Feature:
  As kafka administrator
  I want to update an existing song
  so that i can change some attributes of that song

  Scenario Outline: Update song
    Given I have access to the Kafka Service
    And the song with "<id>" exists
    When I change the attributes "<album>", "<artist>", "<name>" and "<genre>"
    Then I will see the update song with the same "<id>"
    Examples:
      | id | album                  | artist       | name                      | genre   |
      | 1  | London Calling         | the Clash    | London Calling            | Punk    |
      | 10 | Fear Of A Black Planet | Public Enemy | Welcome to the Terrordome | Hip Hop |
      | 15 | Nimrod                 | Green day    | Nice guys finish last     | Punk    |
