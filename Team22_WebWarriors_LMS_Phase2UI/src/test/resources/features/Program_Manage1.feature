@ManageProgram
Feature: Manage Program Validation

  Background: Logged on the LMS portal
  Given Admin logins into the application and is on the dashboard page

  @ManageProgram_01
  Scenario: Validate landing in Program page
    When Admin clicks Program on the navigation bar
    Then Admin should see URL with "Manage Program"

  @ManageProgram_02
  Scenario: Validate the heading
    When Admin clicks Program on the navigation bar
    Then Admin should see a heading with text "Manage Program" on the page
    
#yet to implement
  @ManageProgram_03
  Scenario: Validate the text and pagination icon below the data table
    
    When Admin clicks Program on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.

  #x- starting record number on that page
  #y-ending record number on that page
  #z-Total number of records"
  
  @ManageProgram_04
  Scenario: Validate the footer
   
    When Admin clicks Program on the navigation bar
    Then Admin should see the footer as "In total there are z programs".

  #z- Total number of records"
 
  @ManageProgram_05
  Scenario: Validating the default state of Delete button
    
    When Admin clicks Program on the navigation bar
    Then Admin should see a Delete button on the top left hand side as Disabled

  @ManageProgram_06
  Scenario: Validate Add New Program
    
    When Admin clicks Program on the navigation bar
    Then Admin should see a "+A New Program" button on the program page above the data table

  @ManageProgram_07
  Scenario: Validate that number of records (rows of data in the table) displayed
    
    When Admin clicks Program on the navigation bar
    Then Admin should see the number of records (rows of data in the table) displayed on the page are 5

  @ManageProgram_08
  Scenario: Verify data table on the Program page
    
    When Admin clicks Program on the navigation bar
    Then Admin should see data table on the Manage Program Page with following column headers (Program Name, Program Description, Program Status, Edit,Delete)

  @ManageProgram_09
  Scenario: Verify Sort arrow icon on the data table
    
    When Admin clicks Program on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

  @ManageProgram_10
  Scenario: Verify Check box on the data table
    
    When Admin clicks Program on the navigation bar
    Then Admin should see check box on the left side in all rows of the data table

  @ManageProgram_11
  Scenario: Verify Edit buttons
    
    When Admin clicks Program on the navigation bar
    Then Admin should see the Edit buttons on each row of the data table
    
   @ManageProgram_12
  Scenario: Verify Delete buttons
    
    When Admin clicks Program on the navigation bar
    Then Admin should see the Delete buttons on each row of the data table

  @ManageProgram_13
  Scenario: Verify Search bar on the Program page
    
    When Admin clicks Program on the navigation bar
    Then Admin should see Search bar with text as "Search..."
