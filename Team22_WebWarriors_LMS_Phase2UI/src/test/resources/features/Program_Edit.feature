@LMS @Program_Edit
Feature: Testing the Edit Program Details window of LMS application

  Background: Admin is on Edit Program Details window
    Given Admin is on Manage Program page and clicks on Edit button corresponding to a Progarm

  @PE1
  Scenario: Validate Edit Program Feature
    Then Admin should see a popup open for Program details to edit

  @PE2
  Scenario: Validate Edit Program Name
    When Admin edits the Name column and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program

  @PE3
  Scenario: Validate Edit Program description
    When Admin edits the Description column and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program

  @PE4
  Scenario: Validate Change Program Status
    When Admin changes the Status and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program

  @PE5
  Scenario: Validate invalid values on the text column
    When Admin enters only numbers or special char in name and desc column
    Then Admin gets a Error message alert

  
  
  
  
  @BE2
  Scenario: Validate if Admin is able to Edit a Batch with valid data in all the fields
    When Admin updates all the fields with valid data and clicks save button
    Then Admin should see the successful message and see the updated Batch details in the data table

  @BE3
  Scenario: Validate if Admin is able to Edit Batch with valid data in mandatory fields and missing optional filed
    When Admin updates mandatory field values with valid data leaving Description field empty and clicks save button
    Then Admin should see the successful message and see the updated Batch details in the data table

  @BE4
  Scenario Outline: Validate if Admin is able to Edit Batch with missing mandatory fileds
    When Admin updates with valid data in optional field leaving "<Mandatory field>" empty and clicks save button
    Then Admin should see the error message for Edit Batch

    Examples: 
      | Mandatory field   |
      | Name              |
      | Program Name      |
      | Status            |
      | Number of Classes |

  @BE5
  Scenario: Validate if Admin is able to Edit Batch with invalid data
    When Admin updates with invalid data from the Excel sheet and clicks save button
    Then Admin should see the error message for Edit Batch

  @BE6
  Scenario: Validate the Cancel button in Edit Batch Details window
    When Admin updates with valid data in all the fields and clicks Cancel button
    Then Admin should not be able to edit a Batch

  @BE7
  Scenario: Validate the Close button in Edit Batch Details window
    When Admin updates with valid data in all the fields and clicks Close button
    Then Admin should not be able to edit a Batch

  @BE8
  Scenario: Validate the Program Name Dropdown in Edit Batch Details window
    When Admin clicks on the Program Name dropdown inside Edit Batch Details window
    Then Admin should be able to see all the existing program names listed in the dropdown for edit Batch

  @BE9
  Scenario: Validate if the Program Name Dropdown is a single select dropdown
    When Admin clicks on the Program Name dropdown inside Edit Batch Details window
    Then Admin should not be able to select multiple program names from the list for edit Batch

  @BE10
  Scenario Outline: Validate the Status radio buttons
    When Admin clicks on "<Radio button>" for Edit Batch
    Then Admin should be able to see "<Other button>" disabled for Edit Batch

    Examples: 
      | Radio button | Other button |
      | ACTIVE       | INACTIVE     |
      | INACTIVE     | ACTIVE       |
