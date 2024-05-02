@LMS @Batch_Delete
Feature: Testing the Delete Batch and Delete Multiple Batches confirmation windows of LMS application

  Background: Admin is on Manage Batch Page after clicking Batch on the navigation bar
    Given Admin enters the url and logs in to the LMS application
    When Admin navigates to Manage Batch page

  #Delete Batch
  @BD1
  Scenario: Validate row level delete icon
    When Admin clicks Delete batch icon on the data table for any row
    Then Admin should see an alert open with heading "Confirm" along with <YES> and <NO> option for batch deletion

  @BD3
  Scenario: Validate reject alert
    When Admin clicks <NO> option on the alert after clicking on Delete batch icon
    Then Admin should see that the Batch is still listed in data table 
  
  @BD2
  Scenario: Validate accept alert
    When Admin clicks <YES> option on the alert after clicking on Delete batch icon
    Then Admin gets a message "Successful Batch Deleted" alert and able to see that batch is deleted in the data table

  #Delete Multiple Batches
  @BD4
  Scenario: Validate the delete icon below the header
    When None of the checkboxes in data table are selected in manage Batch Page
    Then Admin should see that the delete icon under the Manage Batch header is disabled

  @BD5
  Scenario: Check for single row delete
    When Admin clicks <YES> button on the alert after selecting Single checkbox for a batch row
    Then Admin should see the selected Batch is deleted from the data table

  @BD6
  Scenario: Check for multi row delete
    When Admin clicks <YES> button on the alert after selecting multiple checkboxes for batches
    Then Admin should see the selected Batches deleted from the data table
