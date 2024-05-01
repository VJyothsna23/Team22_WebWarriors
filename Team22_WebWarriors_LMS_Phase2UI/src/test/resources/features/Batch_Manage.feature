@LMS @Batch_Manage
Feature: Testing the Manage Batch Page of LMS application

  Background: Admin is on Manage Batch Page after login
    Given User logs in to the LMS application as Admin and clicks on Batch link from the header

  @BM1
  Scenario: Validate LMS text in the Manage Batch Page
    Then Admin should be able to see the LMS text displayed on the header inside Manage Batch Page

  @BM2
  Scenario Outline: Validate the links from the header menu in the Manage Batch Page
    When Admin clicks on "<link>" from the header inside the Manage Batch Page
    Then Admin should be redirected to the "<Page>"

    Examples: 
      | link    | Page                |
      | Program | Manage Program Page |
      | Batch   | Manage Batch Page   |
      | User    | Manage User Page    |
      | Logout  | Login Page          |

  @BM3
  Scenario Outline: Validate the Add, Edit, Delete buttons in the Manage Batch Page
    When Admin clicks  "<button>" from the header inside the Manage Batch Page
    Then Admin should be redirected to the "<window>" in batch page

    Examples: 
      | button        | window              |
      | Add New Batch | Add Batch Details   |
      | Edit Batch    | Edit Batch Details  |
      | Delete Batch  | Delete Confirmation |

  @BM4
  Scenario Outline: Validate data table in the Manage Batch Page
    Then Admin should see the data table on Manage Batch page With following "<Column Headers>"

    Examples: 
      | Column Headers    |
      | Check box         |
      | Batch Name        |
      | Batch Description |
      | Batch Status      |
      | No Of Classes     |
      | Program Name      |
      | Edit Delete       |
      | Sort icon         |

  #@BM5
  #Scenario Outline: Validate data elements for all the records inside the Manage Batch Page
    #Then Admin should see the following "<fields>" of data table in Manage Batch page for all the records
#
    #Examples: 
      #| fields      |
      #| Check box   |
      #| Edit icon   |
      #| Delete icon |
#
  #@BM6
  #Scenario Outline: Validate the Search bar with valid input in the Manage Batch Page
    #When Admin searches with an existing "<Column Name>" value in the search bar inside the Manage Batch Page
    #Then Admin should be able to see the corresponding entry displayed
#
    #Examples: 
      #| Column Name       |
      #| Batch Name        |
      #| Batch Description |
#
  @BM7
  Scenario: Validate the Search bar with invalid input in the Manage Batch Page
    When Admin searches with Non existing value in the search bar inside the Manage Batch Page
    Then Admin should be able to see the error message

  @BM8
  Scenario: Validate the Search bar with unsupported column value as input in the Manage Batch Page
    When Admin searches with existing value from unsupported columns in the search bar inside the Manage Batch Page
    Then Admin should be able to see the error message

  @BM9
  Scenario: Validate the Delete Multiple Batches button for multiple entries
    When Admin selects the checkboxes corresponding to more than one Batch Name and clicks on Delete Batches button
    Then Admin should be able to see the Delete Confirmation window
#
  #@BM10
  #Scenario: Validate the Delete Multiple Batches button for one entry
    #When Admin selects the checkbox corresponding to one Batch Name and clicks on Delete Batches button
    #Then Admin should be able to see the Delete Confirmation window
#
  #@BM11
  #Scenario: Validate the Delete Multiple Batches button without selecting any Batch
    #Then Admin should be able to see the disabled Delete Batches button when none of the checkboxes are selected
#
  #@BM12
  #Scenario: Validate the check box to select all the batches at once
    #When Admin selects the checkbox next to the Batch Name in the data table header
    #Then Admin should be able to select all the batches at once
#
  #@BM13
  #Scenario: Validate the Number of entries displayed Text in the Manage Batch Page
    #Then Admin should be able to see the text "<Showing x to y of z entries>" below the table in the Manage Batch Page.
#
  #@BM14
  #Scenario: Validate the Total Batches Text in the Manage Batch Page footer
    #Then Admin should be able to see the text "<In total there are z batches>" in the Manage Batch Page footer
#
  #@BM15
  #Scenario: Validate sort function in data table for descending order
    #When Admin click on Batch name column header to sort
    #Then Admin should see data table sorted in descending order
#
  #@BM16
  #Scenario: Verify sort function in data table for ascending order
    #When Admin double clicks on Batch name column header to sort
    #Then Admin should see data table sorted in ascending order
