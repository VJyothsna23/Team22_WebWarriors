@LMS1 @ProgramModule_Pagination
Feature: Pagination

  Background: Admin is on Manage Program Page after logged in
    Given Admin logins into the application and is on the manage program pages

  @Pagination_01
  Scenario: Verify Next and Last page link
    Given Manage program data table consists of more than 2 pages
    Then Admin should be able to see "Next" and "Last" icons to be enabled

  @Pagination_02
  Scenario: Verify Next Page link functionality
    Given Manage program data table consists of more than 2 pages
    When Admin clicks "Next" icon
    Then Admin is navigated to Page 2

  @Pagination_03
  Scenario: Verify Last Page link functionality
    Given Manage program data table consists of more than 2 pages
    When Admin clicks "Last" icon
    Then Admin is navigated to Last page with "Next" page link disabled

  @Pagination_04
  Scenario: Verify Previous and Start page link activation
    Given Manage program data table consists of more than 3 pages
    When Admin navigates to page 2
    Then Admin should be able to see "Previous" and "First" icons to be enabled

  @Pagination_05
  Scenario: Verify previous page link
    Given Manage program data table consists of more than 3 pages
    When Admin navigates to Page 2 clicks on "Previous" icon
    Then Admin is navigated to Page 1

  @Pagination_06
  Scenario: Verify First Page link
    Given Manage program data table consists of more than 3 pages
    When Admin is on the Last page and clicks first icon
    Then Admin is navigated to First page with "Previous" page link disabled
