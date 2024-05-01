@LMS @LoginPage
Feature: Testing the Login Page of LMS application

  Background: User is on the LMS Login page
    Given User enter LMS application url
    When Admin enter the correct LMS portal URL

  @LP1
  Scenario: Verify text field is present
    Then Admin should see two text field

  @LP2
  Scenario: Verify text on the first text field
    Then Admin should "User" in the first text field

  @LP3
  Scenario: Verify asterik next to user text
    Then Admin should see "*" symbol next to user text

  @LP4
  Scenario: Verify text on the second text field
    Then Admin should "Password" in the second text field

  @LP5
  Scenario: Verify asterik next to password text
    Then Admin should see "*" symbol next to password text

  @LP6
  Scenario: Verify the alignment input field for the login
    Then Admin should see input field on the centre of the page

  @LP7
  Scenario: verify Login is present
    Then Admin should see login button

  @LP8
  Scenario: Verify the alignment of the login button
    Then Admin should see login button on the centre of the page

  @LP9
  Scenario: Verify input descriptive test in user field
    Then Admin should see user in gray color

  @LP10
  Scenario: Verify input descriptive test in password field
    Then Admin should see password in gray color
