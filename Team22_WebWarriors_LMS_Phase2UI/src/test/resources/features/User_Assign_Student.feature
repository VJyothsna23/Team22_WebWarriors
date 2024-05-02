Feature: LMS TC: 0003 User Assign Student feature
Background: Admin is on dashboard page after Login and clicks User on the navigation bar
Given Admin login and Admin clicks User on the navigation bar
When Admin is on "Manage User" Page
Then Admin clicks on "Assign Student" button

Scenario: Validate Assign Student Popup window
Given Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window

Scenario: Validate input fields and their text boxes in Assign Student form 
Given Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.


Scenario: Validate Dropdown in Assign Student Form
Given Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name

Scenario: Validate radio button in Assign Student Form
Given Admin should see two radio button for Status

Scenario: Empty Form Submission
When Admin clicks "Save" button without entering any data
Then Admin gets a Error message alert 

############################## Invalid scenario
#Scenario: Validate the Assign Student form page without giving Student Email id
#When Admin clicks "Save" button without entering Student Email id
#Then Admin gets a Error message alert as "Student Email id is required"

#Scenario: Validate the Assign Student form page without selecting Program
#When Admin clicks "Save" button without selecting program
#Then Admin gets a Error message alert as "Program is required"
#
#Scenario: Validate the Assign Student form page without giving Status
#When Admin clicks "Save" button without selecting batch
#Then Admin gets a Error message alert as "Status is required"
#
#Scenario: Validate Cancel/Close(X) icon on Assign Student form
#When Admin clicks Cancel/Close(X) Icon on Assign Student form
#Then Assign Student popup window should be closed without saving
######################################

#Scenario: Validate Save button on Assign Student form
#When Enter all the required fields with valid values and click Save button
#Then Admin gets a message "Successfully Student Assigned" alert 
#

Scenario: Validate Cancel button on Assign Student form
When Admin clicks <Cancel> button 
Then Admin can see the Assign Student popup disappears without assigning 

#
#
#
#
