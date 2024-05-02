@LMS1 @ProgramModule_Navigation
Feature: Pagination

  Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
    Given Admin logins into the application and is on the manage program pages

  @Navigation_01
  Scenario: Batch link on navigation bar
    When Admin clicks on "Batch" link on Manage Program page
    Then Admin is re-directed to "Batch" page

  @Navigation_02
  Scenario: User link on navigation bar
    When Admin clicks on "User" link on Manage Program page
    Then Admin is re-directed to "User" page

  @Navigation_03
  Scenario: Logout link on navigation bar
    When Admin clicks on "Logout" link on Manage Program page
    Then Admin is re-directed to "Login" page
