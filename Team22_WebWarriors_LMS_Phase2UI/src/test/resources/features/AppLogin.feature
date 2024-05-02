 @Login
Feature: Testing the Login Page of LMS application

  Background: User is on the LMS Login page
    Given User enters LMS application url
    When Admin gives the correct LMS portal URL

  @LP1
  Scenario: Verify admin is able to land on home page
    Then Admin should land on the home page

  @LP2
  Scenario: Verify for broken link
    Then HTTP response >= 400. then the link is broken

  @LP3
  Scenario: Verify the text spelling in the page
    Then Admin should see correct spellings in all fields

  @LP4
  Scenario: Verify the company logo
    Then Admin should see logo on the left  side

  @LP5
  Scenario: Verify application name
    Then Admin should see  LMS - Learning Management System

  @LP6
  Scenario: Verify company name
    Then Admin should see company name below the app name

  @LP7
  Scenario: Validate sign in content
    Then Admin should see "Please login to LMS application"
