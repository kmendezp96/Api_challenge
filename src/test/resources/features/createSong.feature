Feature:
  As kafka administrator
  I want to create a new song
  so that users can play new songs

Scenario Outline: Create a new song
  Given I have access to Kafka Service
  When I create a new song : "<string1>", "<string2>", "<string3>", "<string4>", "<string5>" in the song-feed topic
  Then I can play the song: "<string1>"
  Examples:
  | string1 |  string2 | string3 | string4 | string5 |
  |"13L"|"Beatles" | "Beatles" | "Yesterday" | "rock" |