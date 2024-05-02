@LMS
Feature: LMS TC: 0003 User Assign Student feature
Background: Admin is on dashboard page after Login and clicks User on the navigation bar
Given Admin login and Admin clicks User on the navigation bar
When Admin is on Manage User Page
Then Admin clicks "Assign Staff" button

Scenario: Validate Assign Staff Popup window
Given Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window

Scenario: Validate input fields and their text boxes in Assign Staff form 
Given Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.

Scenario: Validate Dropdown in Assign Staff Form
Given Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name in Assign Staff

Scenario: Validate radio button in Assign Staff Form
Given Admin should see two radio button for Status in Assign Staff

Scenario: Empty Form Submission
Given Admin gets a Error message alert for Assign Staff

Scenario: Validate Save button on Assign Staff form
Then Admin gets a message "Successfully Staff Assigned" alert in Assign Staff

Scenario: Validate the Assign Staff form page without giving Student Email id
Then Admin gets a Error message alert as "Student Email id is required" in Assign Staff


Scenario: Validate the Assign Staff form page without selecting batch
Then Admin gets a Error message alert as Batch is required in Assign Staff 

Scenario: Validate Cancel/Close(X) icon on Assign Staff form
Then Assign Staff popup window should be closed without saving

Scenario: Validate Cancel button on Assign Staff form
Then Admin can see the Assign Staff popup disappears without assigning 






