@LMS @Batch_Edit
Feature: Testing the Edit Batch window of LMS application

  Background: Admin is on Edit Batch Details window
    Given Admin is on Manage Batch page and clicks on Edit Batch button corresponding to a Batch

  @BE
  Scenario Outline: Validate the presence of fields for Edit Batch
    Then Admin should be able to see the "<field>" for Edit Batch

    Examples: 
      | field                          |
      | Name                           |
      | Description                    |
      | Program Name                   |
      | Dropdown arrow                 |
      | Deselect Program Name x button |
      | Status                         |
      | ACTIVE                         |
      | INACTIVE                       |
      | Number of Classes              |
      | Save                           |
      | Cancel                         |
      | close                          |

  @BE1
  Scenario: Validate the presence of selected Batch details
    Then Admin should be able to see all the fields with selected Batch details

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
