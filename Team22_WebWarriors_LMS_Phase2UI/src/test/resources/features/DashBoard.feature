@LMS @LoginPage
Feature: Testing the Login Page of LMS application

  Background: Admin gives the correct LMS portal URL
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button

  @LP1
  Scenario: Verify after login  admin lands on manage program as dashboard page
    Then Admin should see manage program as header

  @LP2
  Scenario: Verify the response time
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  @LP3
  Scenario: Verify broken link
    Then HTTP response >= 400. Then the link is broken

  @LP4
  Scenario: Verify LMS title
    Then Admin should see "LMS -Learning management system  as title"

  @LP5
  Scenario: Verify  LMS title alignment
    Then LMS title should be on the top left corner of page

  @LP6
  Scenario: Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text

  @LP7
  Scenario: Validate LMS title has correct spelling ang space
    Then Admin should see correct spelling and space in LMS title

  @LP8
  Scenario: Validate alignment for navigation bar
    Then Admin should see the navigation bar text on the top right side

  @LP9
  Scenario: Validate navigation bar order  1st Program
    Then Admin should see program in the 1st place

  @LP10
  Scenario: Validate navigation bar order  2nd Batch
    Then Admin should see batch in the 2nd place

  @LP11
  Scenario: Validate navigation bar order 3rd User
    Then Admin should see user in the  3rd place

  @LP12
  Scenario: Validate navigation bar order 4th Logout
    Then Admin should see logout in the 4th place
