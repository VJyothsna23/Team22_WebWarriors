@LMS @UManage
Feature: User page validation

  Background: 
    Given Admin logins into the application 
    When Admin clicks User from navigation bar
  
   @UM_1
  Scenario: Validate landing in User page
      Then Admin should see the Manage User in the URL

   @UM_2
  Scenario: Validate the heading
       Then  Admin should see a heading with text Manage user on the page

  @UM_3
  Scenario: Validate the text and pagination icon below the data table
   
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table in the user page

   # x- starting record number on that page
   #y-ending record number on that page
   #z-Total number of records"

   @UM_4
   Scenario: Validate data table headers in the User Page
          Then Admin Should see the data table with column names Id, Name, location, Phone Number, Edit/Delete

 
   @UM_5
   Scenario: Validating the default state of Delete button
        Then  Admin should see a Delete button on the top left hand side as Disabled in the user page

  @UM_6
 Scenario: Validate "Add New user" button in User Page
       Then Admin should be able to see the "+ Add New User" button above the data table in the user page

   @UM_7
  Scenario: Validate "Assign staff"  button in User page
       Then Admin should be able to see the "+ Assign staff" button above the data table in the user page

  @UM_8
 Scenario: Validate " Assign Student"  button in User page
       Then Admin should be able to see the "+ Assign Student" button above the data table in the user page

   @UM_9
 Scenario: Validate search box in User page
       Then Admin should be able to see the search text box above the data table in the user page

  @UM_10
  Scenario: Validate number of data rows in the data table
       Then Admin should see five  records displayed on the data table

   @UM_11
  Scenario: Verify Check box on the data table
        Then Each row in the data table should have a checkbox in the user page

  @UM_12
  Scenario: Verify edit icon on the data table
      Then Each row in the data table should have a edit icon that is enabled in the user page

   @UM_13
  Scenario: Verify  delete icon on the data table
    Then Each row in the data table should have a delete icon that is enabled in the user page

  @UM_14
  Scenario: search user by name
   
    When Admin enters user name into search box.
    Then Admin should see user displayed with the entered name

 @UM_15
  Scenario: Validating the Search with unrelated keyword
  
   When Admin enters the keywords not present in the data table on the Search box
   Then Admin should see zero entries on the data table
