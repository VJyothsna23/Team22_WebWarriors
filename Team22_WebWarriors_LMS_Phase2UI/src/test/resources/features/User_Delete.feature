Feature: LMS TC: 0001 User Delete feature
Background: Admin is on dashboard page after Login and clicks User on the navigation bar
Given Admin login and Admin clicks User on the navigation bar
When Admin is on "Manage User" Page
Then Admin clicks the delete icon


Scenario: Validate row level delete icon
Then Admin should see a alert open with heading "Confirm" along with <YES> and <NO> button for deletion

Scenario: Click Yes on deletion window
Given Admin is on Confirm Deletion alert and clicks yes option
Then Admin gets a message "Successful User Deleted" alert and do not see that user in the data table

Scenario: Click No on deletion window
Given Admin clicks  No option 
Then Admin can see the deletion alert disappears without deleting

Scenario: Validate Close(X) icon on Confirm Deletion alert
Given Admin clicks on close button
Then Admin can see the deletion alert disappears without deleting
