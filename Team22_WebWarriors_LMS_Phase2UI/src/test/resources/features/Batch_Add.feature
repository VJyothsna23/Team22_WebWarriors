@LMS @Batch_Add
Feature: Testing the Add New Batch window of LMS application

  Background: Admin is on Add Batch Details window
    Given Admin enters the url and logs in to the LMS application
    When Admin is on Manage Batch page after clicking Batch on the navigation bar

  @BA1
  Scenario Outline: Validate the presence of fields for Add Batch
    Then Admin should be able to see the "<field>" for Add Batch as "<type>"

    Examples: 
      | field             | type         |
      | Name              | text box     |
      | Description       | text box     |
      | Program Name      | drop down    |
      | Status            | radio button |
      | Number of Classes | text box     |

  @BA2
  Scenario: Validate if description is optional field
    When Admin enters all the fields except description with valid values and clicks save for Add Batch
    Then The newly added batch should be present in the data table in Manage Batch page

  @BA3
  Scenario: Validate if program details are added in data table
    When Admin enters valid data in all the fields and clicks save button for Add Batch
    Then The newly added batch should be present in the data table in Manage Batch page

  @BA4
  Scenario Outline: Validate error messages for invalid fields
    When Admin enters "<invalid values>" for the field while creating a Batch
    Then Admin should see the error message for Add Batch

    Examples: 
      | invalid values     |
	    | Numeric values     |
      | Special Characters | 
      | Numeric values     |
      | Special Characters |

  @BA5
  Scenario: Validate error messages for mandatory fields
    When Admin leaves empty values for the Mandatory fields while creating a Batch
    Then Admin should see the error messages for Add Batch
