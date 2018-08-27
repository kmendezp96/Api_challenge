Feature: List of instances
  As a user
  I want to see the list with the kafka instances
  so that I can know which instances the system has

  Scenario: List with all the instances - Positive
    Given  I want to see the list of intances
    When I go to /instances
    Then I see the list with all the instances
    And the system response an "200" status code

  Scenario Outline: List with the instances of an specific provided store - Positive
    Given I want to see the list of intances that an specific provider has
    When I go to /instances/ "<storeName>"
    Then I see the list of the instances that the provided store has
    And the system response an "200" status code
    Examples:
    | storeName               |
    | all-songs               |
    | song-play-count         |
    | top-five-songs          |
    | top-five-songs-by-genre |

  Scenario: List with the instances of an non-existent provided store - Negative
    Given I want to see the list of intances that an specific provider has
    When I go to /instances/ "all-s0ngs"
    Then The systems returns an empty list of intances
    And the system response an "200" status code

