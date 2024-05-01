@ProgramModuleADD
Feature: Add New Program
Background: Logged on the LMS portal as Admin 
 Given Admin logins into the application and is on the manage program page 
 When Admin clicks <A New Program> button

  @AddProgram_01
  Scenario: Validate Program Details Popup window
    Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
       		
 @AddProgram_02 		
Scenario: Validate input fields and their text boxes in Program details form 
Then Admin should see two input fields and their respective text boxes in the program details window

@AddProgram_03
Scenario: Validate radio button for Program Status 
	Then Admin should see two radio button for Program Status

@AddProgram_04
Scenario: Empty form submission
	Given Admin is on "Program Details" Popup window
	When 	Admin clicks <Save>button without entering any data
	Then Admin gets a Error message alert 
				
@AddProgram_05
Scenario: Enter only Program Name
Given Admin is on "Program Details" Popup window
When Admin enters only<Program Name> in text box and clicks Save button
Then Admin gets a message alert 'Description is required'
	
@AddProgram_06
Scenario: Enter only Program Description
Given Admin is on "Program Details" Popup window
 	When Admin enters only<Program description> in text box and clicks Save button
 	Then Admin gets a message alert 'Name is required' in program name field
 	
@AddProgram_07
Scenario: Select Status only
Given Admin is on "Program Details" Popup window	
When Admin selects only Status and clicks Save button
Then Admin gets a message alert 'Name and Description required' in program desc and prog name field
		
@AddProgram_08
Scenario Outline: Validate invalid values on the text column
Given Admin is on "Program Details" Popup window	
When 	Admin enters "<invalid values>" for the "<column name>" for Add Program
Then Admin gets a Error message alert near the text "<field>" for Add Program

Examples:
 | invalid values     | column name | field       |
 | Numeric values     | Name        | Name        |
 | Special Characters | Name        | Name        |
 | Numeric values     | Description | Description |
 | Special Characters | Description | Description |


	
@AddProgram_09
Scenario: Validate Cancel/Close(X) icon on Program Details form
Given Admin is on "Program Details" Popup window
When 	Admin clicks Cancel or Close Icon on Program Details form in add program
Then Program Details popup window should be closed without saving
			
@AddProgram_10			
Scenario Outline: Validate Save button on Program Details form
Given Admin is on "Program Details" Popup window
	When 	Enter valid "<ProgramName>" and "<ProgramDescription>" ,status and click Save button in add program 
	Then 	Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table
	
Examples:

|ProgramName| ProgramDescription|
|QAShar004   | Team22            |
|QAShar005   | Team22            |
|QAShar006   | Team22            |
	
	

@AddProgram_11	
Scenario: Validate Cancel button on Program Details form
Given	 Admin is on "Program Details" Popup window
	When Admin clicks <Cancel>button 	
	Then Admin can see the Program details popup disappears without creating any program

	
	









	

  