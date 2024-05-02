@LMS @Program_Edit
Feature: Testing the Edit Program feature of LMS application

  Background: Admin is on Edit Program Details window
    Given Admin enters the url and logs in to the LMS application
    When Admin navigates to Manage Program page

  @PE1
  Scenario: Validate Edit Feature
  	When Admin clicks on Edit button corresponding to a Progarm
    Then Admin should see a popup open for Program details to edit

  @PE2
  Scenario: Validate Edit Program Name
    When Admin edits the Program Name column and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program

  @PE3
  Scenario: Validate Edit Program description
    When Admin edits the Program Description column and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program

  @PE4
  Scenario: Validate Save button on Edit popup
    When Admin clicks Save button on edit program popup
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program

  @PE5
  Scenario Outline: Validate invalid values on the text column
    When Admin enters "<invalid values>" for the "<column name>"
    Then Admin gets a Error message alert near the text "<field>" for Edit Program

    Examples: 
      | invalid values     | column name | filed       |
      | Numeric values     | Name        | Name        |
      | Special Characters | Name        | Name        |
      | Numeric values     | Description | Description |
      | Special Characters | Description | Description |

  @PE6
  Scenario: Validate Cancel button on Edit popup
    When Admin clicks Cancel button on edit program popup
    Then Admin can see the Edit Program details popup disappear and can see nothing changed for particular program

  @PE7
  Scenario: Validate Change Program Status
    When Admin changes the Program Status and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program
    
