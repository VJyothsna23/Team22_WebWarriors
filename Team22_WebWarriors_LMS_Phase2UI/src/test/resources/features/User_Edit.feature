@LMS @UE
Feature: Edit new user

  Background: Admin is on Manage User page
    Given Admin is on Manage User page in EditUSer Module

  @UE_1
  Scenario: Validate row level edit icon
    When Admin clicks on the edit icon in userpage
    Then A new pop up with User details appears

  @UE_2
  Scenario: Check if the fields are updated with valid data
    When Update the fields with valid data and click submit in userpage
    Then Admin gets message "User Updated Successfully" and see the updated values in data table

  @UE_3
  Scenario: Check if the fields are updated with invalid values in userpage
    When Update the fields with invalid values and click submit in userpage
    Then Admin should get Error message

  @UE_4
  Scenario: Check if the mandatory fields are updated with valid data
    When Update the mandatory fields with valid values and click submit in userpage
    Then Admin gets message "User updated Successfully " and see the updated values in data table

  @UE_5
  Scenario: Check if the optional fields are updated with valid data
    When Update the optional fields with valid values and click submit in userpage
    Then Admin gets message "User updated Successfully " and see the updated values in data table

  @UE_6
  Scenario: Validate invalid values in the text fields
    When Admin enters only numbers or special char in the text fields in userpage
    Then Admin should get Error message

  @UE_7
  Scenario: Validate Cancel button on Edit popup
    When Admin clicks Cancel button on edit popup
    Then Admin can see the User details popup disappears and can see nothing changed for particular User
