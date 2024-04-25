@LMS @Program_Edit
Feature: Testing the Edit Program Details window of LMS application

  Background: Admin is on Edit Program Details window
    Given Admin is on Manage Program page and clicks on Edit button corresponding to a Progarm

  @PE1
  Scenario: Validate Edit Feature
    Then Admin should see a popup open for Program details to edit

  @PE2
  Scenario: Validate Edit Program Name
    When Admin edits the Program Name column and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program

  @PE3
  Scenario: Validate Edit Program description
    When Admin edits the Program Description column and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program

#	@PE4 - To be implemented 
  Scenario: Validate Change Program Status
    When Admin changes the Program Status and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program
	
	@PE5
  Scenario: Validate Save button on Edit popup
    When Admin clicks Save button on edit program popup
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program

  #@PE6
  #Scenario Outline: Validate invalid values on the text column
    #When Admin enters "<invalid values>" for the "<column name>"
    #Then Admin gets a Error message alert for Edit Program
#
    #Examples: 
      #| invalid values     | column name |
      #| Numeric values     | Name        |
      #| Special Characters | Name        |
      #| Numeric values     | Description |
      #| Special Characters | Description |
#
  #@PE7
  #Scenario: Validate Cancel button on Edit popup
    #When Admin clicks Cancel button on edit program popup
    #Then Admin can see the Edit Program details popup disappear and can see nothing changed for particular program
 
