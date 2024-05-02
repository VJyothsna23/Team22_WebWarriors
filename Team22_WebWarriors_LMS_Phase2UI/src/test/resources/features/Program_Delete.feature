@LMS @Program_Delete
Feature: Testing the Delete Program feature of LMS application

  Background: Admin is on Manage Program Page after clicking Program on the navigation bar
    Given Admin enters the url and logs in to the LMS application
    When Admin is on Manage Program page after clicking Program on the navigation bar

  @PD1
  Scenario: Validate details for Confirm Deletion form
    When Admin clicks Delete program button on the data table for any row
    Then Admin should see an alert open with heading "Confirm" along with <YES> and <NO> button for program deletion
		
  @PD2
  Scenario: Validate confirmation text for Confirm Deletion form
    When Admin clicks Delete program button on the data table for any row
    Then Admin should see a message "Are you sure you want to delete <Program name>?" for program deletion

  @PD3
  Scenario: Click No on deletion window
    When Admin clicks <NO> button on the alert after clicking on Delete program button
    Then Admin can see the deletion alert disappears without deleting program

  @PD4
  Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
    When Admin clicks Cancel or Close Icon on Deletion alert after clicking on Delete program button
    Then Admin can see the deletion alert disappears without deleting program
    
  @PD5
  Scenario: Validate Common Delete button enabled after clicking on any checkbox
    When Admin clicks any checkbox in the data table
    Then Admin should see common delete option enabled under header Manage Program

  @PD6
  Scenario: Validate multiple program deletion by selecting Single checkbox with No selection
    When Admin clicks <NO> button on the alert after selecting Single checkbox
    Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table

  @PD7
  Scenario: Validate multiple program deletion by selecting multiple check boxes with No selection
    When Admin clicks <NO> button on the alert after selecting multiple checkboxes
    Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table
    
  @PD8
  Scenario: Click Yes on deletion window for Delete Program Feature
    When Admin clicks <YES> button on the alert after clicking on Delete program button
    Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table

  @PD9
  Scenario: Validate multiple program deletion by selecting Single checkbox with YES selection
    When Admin clicks <YES> button on the alert after selecting Single checkbox
    Then Admin should land on Manage Program page and can see the selected program is deleted from the data table
    
  # Expected to Fail
  @PD10
  Scenario: Validate multiple program deletion by selecting multiple check boxes with YES selection
    When Admin clicks <YES> button on the alert after selecting multiple checkboxes
    Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table