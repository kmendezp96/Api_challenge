Feature:
  As kafka administrator
  I want to create a new song
  so that users can play new songs

  Scenario: Create a new song
    Given I have access to Kafka Service
    When I create a new song in the song-feed topic
    Then I can play the song