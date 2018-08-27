Feature: List of instances
  As a user
  I want to see the list with all the kafka instances
  so that I can know which instances the system has

  Scenario:
    Given  I want to see the list of intances
    When I go to /instances
    Then I see the list with all the instances

  Scenario:
    Given At least one instance exists
    And that instance has a provided "storeName"
    When I go to /instances/"storeName"
    Then I see the list of the instances that the provided store has
