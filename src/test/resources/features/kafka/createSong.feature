Feature:
  As kafka administrator
  I want to create a new song
  so that users can play new songs

  Scenario Outline: Create a new song
    Given I have access to Kafka Service
    When I create a new song with id: "<id>", album: "<album>", artist: "<artist>", name: "<name>" and genre: "<genre>" in the song-feed topic
    Then I can see the song with id: "<id2>"
    Examples:
      | id  | album                   | artist      | name                    | genre | id2 |
      | 13L | Never mind the bollocks | Sex pistols | Anarchy in the uk       | Punk  |  13 |
      | 14L | The beatles             | The beatles | Happiness is a warn gun | Rock  |  14 |
      | 15L | American idiot          | Green day   | Jesus of suburbia       | Punk  |  15 |
