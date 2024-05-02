@LMS @Batch_Edit
Feature: Testing the Edit Batch feature of LMS application

  Background: Admin is on Edit Batch Details window
    Given Admin enters the url and logs in to the LMS application
    When Admin navigates to Manage Batch page

  @BE1
  Scenario: Validate row level edit icon
  	When Admin clicks on Edit icon corresponding to a batch
 		Then Admin should see a popup open for Batch details to edit
  
  @BE2
  Scenario: Validate if the fields are updated
    When Admin updates the fields with valid values and clicks save
    Then The updated batch details should appear on the data table

  @BE3
  Scenario: Validate if the update throws error with invalid values
    When Admin updates the batch fields with invalid values and clicks save
    Then Error message should appear for Edit Batch

	# Expected to Fail 
  @BE4 
  Scenario: Check if you get error message when mandatory fields are erased
    When Erase data from mandatory field in edit batch
    Then Error message should appear while editing Batch
  
  # Expected to Fail 
  @BE5  
  Scenario: Check if description field is optional in update
    When Erase data from description field
    Then The updated batch description should appear on the data table
