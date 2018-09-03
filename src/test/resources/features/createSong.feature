Feature:
  As kafka administrator
  I want to create a new song
  so that users can play new songs

  Scenario Outline: Create a new song
    Given I have access to Kafka Service
    When I create a new song with "<id>", "<album>", "<artist>", "<name>" and "<genre>" the song-feed topic
    Then I can play the song
    Examples:
    | id  | album                   | artist      | name                    | genre |
    | 13L | Never mind the bollocks | Sex pistols | Anarchy in the uk       | Punk  |
    | 14L | The beatles             | The beatles | Happiness is a warn gun | Rock  |
    | 15L | American idiot          | Green day   | Jesus of suburbia       | Punk  |
