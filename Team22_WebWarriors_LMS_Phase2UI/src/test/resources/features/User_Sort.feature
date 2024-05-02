@LMS @US
Feature: Sort user

  Background: 
    Given Admin logins into the application and clicks User from the navigationbar

  @US_1
  Scenario: Sort user by id
    When Admin clicks on ID sort icon
    Then Admin should see User details are sorted by Id in ascendingorder
    When Admin clicks on ID sort icon again
    Then Admin should see User details  are sorted by Id  in descendingorder

  @US_2
  Scenario: Sort user by name
    When Admin clicks on name sort icon
    Then Admin should see User details are sorted by name in ascendingorder
    When Admin clicks on name sort icon again
    Then Admin should see User details  are sorted by name  in descendingorder

  @US_3
  Scenario: Sort user by Location
    When Admin clicks on Location sort icon
    Then Admin should see User details are sorted by Location in ascendingorder
    When Admin clicks on Location sort icon again
    Then Admin should see User details  are sorted by Location  in descendingorder

  @US_4
  Scenario: Sort user by Phone number
    When Admin clicks on Phone number sort icon
    Then Admin should see User details are sorted by Phone number in ascendingorder
    When Admin clicks on phone number sort icon again
    Then Admin should see User details  are sorted by Phone number  in descendingorder
