@LMS @LoginPage
Feature: Testing the Login Page of LMS application

  Background: User is on the LMS Login page
    Given User enters LMS application url

  @LP1
  Scenario: To validate Login with valid user name and Password
    When User enters valid Admin credentials and clicks on Login button
    Then User should be able to Login successfully

  @LP2
  Scenario Outline: To validate Login with invalid user name and or Password
    When User enters "<Username type>" username, "<Password type>" password and clicks on Login button
    Then User should be able to see the error message

    Examples: 
      | Username type | Password type |
      | valid         | invalid       |
      | invalid       | valid         |
      | invalid       | invalid       |
