@LMS @Batch_Add
Feature: Testing the Add New Batch window of LMS application

  Background: Admin is on Add Batch Details window
    Given Admin is on Manage Batch page and clicks on Add New Batch button

  @BA1
  Scenario Outline: Validate the presence of fields for Add Batch
    Then Admin should be able to see the "<field>" for Add Batch

    Examples: 
      | field             |
      | Name              |
      | Description       |
      | Program Name      |
      | Dropdown arrow    |
      | Status            |
      | ACTIVE            |
      | INACTIVE          |
      | Number of Classes |
      | Save              |
      | Cancel            |
      | close             |

  @BA2
  Scenario: Validate if Admin is able to Add New Batch with valid data in all the fields
    When Admin enters valid data in all the fields and clicks save button for Add Batch
    Then Admin should see the successful batch creation message and see the updated total number of batches in the footer

  @BA3
  Scenario: Validate if Admin is able to Add New Batch with valid data in mandatory fields and missing optional filed
    When Admin enters valid data in all the mandatory fields leaving optional field empty and clicks save button for Add Batch
    Then Admin should see the successful batch creation message and see the updated total number of batches in the footer

  @BA4
  Scenario Outline: Validate if Admin is able to Add New Batch with missing mandatory fileds
    When Admin enters valid data in optional field leaving "<Mandatory field>" empty and clicks save button for Add Batch
    Then Admin should see the error message for Add Batch

    Examples: 
      | Mandatory field   |
      | Name              |
      | Program Name      |
      | Status            |
      | Number of Classes |

  @BA5
  Scenario: Validate if Admin is able to Add New Batch with invalid data
    When Admin enters invalid data from the Excel sheet and clicks save button for Add Batch
    Then Admin should see the error message for Add Batch and see the same total number of batches in the footer

  @BA6
  Scenario: Validate the Cancel button in Add Batch Details window
    When Admin enters valid data in all the fields and clicks Cancel button
    Then Admin should not be able to create a new batch

  @BA7
  Scenario: Validate the Close button in Add Batch Details window
    When Admin enters valid data in all the fields and clicks Close button
    Then Admin should not be able to create a new batch

  @BA8
  Scenario: Validate the Program Name Dropdown in Add Batch Details window
    When Admin clicks on the Program Name dropdown inside Add Batch Details window for Add Batch
    Then Admin should be able to see all the existing program names listed in the dropdown for Add Batch

  @BA9
  Scenario: Validate if the Program Name Dropdown is a single select dropdown
    When Admin clicks on the Program Name dropdown inside Add Batch Details window
    Then Admin should not be able to select multiple program names from the list for add batch

  @BA10
  Scenario: Validate the successful Batch creation
    When Admin enters valid data in all the fields and clicks Save button
    Then Admin should be able to see the created batch with the given batch details added to the data table

  @BA11
  Scenario Outline: Validate the Status radio buttons
    When Admin clicks on "<Radio button>" for Add Batch
    Then Admin should be able to see "<Other button>" disabled for Add Batch

    Examples: 
      | Radio button | Other button |
      | ACTIVE       | INACTIVE     |
      | INACTIVE     | ACTIVE       |
