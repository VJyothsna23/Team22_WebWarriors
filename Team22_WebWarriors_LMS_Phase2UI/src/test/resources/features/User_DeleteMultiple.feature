@LMS
Feature: LMS TC: 0002 Delete Multiple User feature
Background: Admin is on dashboard page after Login and clicks user on the navigation bar
Given Admin login and Admin clicks User on the navigation bar
When Admin is on "Manage User" Page
Then Admin clicks any checkbox in the data table
And Admin should see common delete option enabled under header Manage Program

Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert
When Admin clicks <YES> button on the alert
Then Admin should land on Manage User page and can see the selected user is deleted from the data table
#
Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert
When Admin clicks <No> button on the alert
Then Admin should land on Manage User page and can see the selected user is not deleted from the data table
#
Scenario: Validate multiple program deletion by selecting multiple check boxes and click yes
Given Admin clicks delete button under header after selecting multiple checkboxes in the data table
When Admin is on Confirm Deletion alert
Then Admin clicks <YES> button on the alert
And Admin should land on Manage User page and can see the selected users are deleted from the data table

Scenario: Validate multiple program deletion by selecting multiple check boxes and click no
Given Admin clicks delete button under header after selecting multiple checkboxes in the data table
When Admin is on Confirm Deletion alert
Then Admin clicks <No> button on the alert
And Admin should land on Manage User page and can see the selected users are not deleted from the data table
