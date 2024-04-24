@LMS @Batch_Delete
Feature: Testing the Delete Batch and Delete Multiple Batches confirmation windows of LMS application

  Background: Admin is on Manage Batch Page after login
    Given User logs in to the LMS application as Admin and clicks on Batch link from the header

  @BD1
  Scenario Outline: Validate the presence of fields for Delete Batch
    When Admin clicks on Delete Batch button corresponding to a batch
    Then Admin should be able to see the "<field>" in Delete Batch confirmation window

    Examples: 
      | field             |
      | confirmation text |
      | No                |
      | Yes               |
      | close             |

  @BD2
  Scenario Outline: Validate the Yes button for Delete Batch
    When Admin clicks on Delete Batch button corresponding to a batch and clicks on Yes
    Then Admin should be able to see the success message for batch deletion

  @BD3
  Scenario Outline: Validate the No button for Delete Batch
    When Admin clicks on Delete Batch button corresponding to a batch and clicks on No
    Then Admin should be unable to delete the batch

  @BD4
  Scenario Outline: Validate the close button for Delete Batch
    When Admin clicks on Delete Batch button corresponding to a batch and clicks on close
    Then Admin should be unable to delete the batch

  @BD5
  Scenario Outline: Validate the presence of fields for Delete Multiple Batches
    When Admin clicks on Delete Multiple Batches button after selecting the check box next to a record
    Then Admin should be able to see the "<field>" in Delete Batches confirmation window

    Examples: 
      | field             |
      | confirmation text |
      | No                |
      | Yes               |
      | close             |

  @BD6
  Scenario Outline: Validate the Yes button for Delete Multiple Batches
    When Admin clicks on Delete Multiple Batches button after selecting a record and clicks on Yes
    Then Admin should be able to see the success message for batches deletion

  @BD7
  Scenario Outline: Validate the No button for Delete Multiple Batches
    When Admin clicks on Delete Multiple Batches button after selecting a record and clicks on No
    Then Admin should be unable to delete the batches

  @BD8
  Scenario Outline: Validate the close button for Delete Multiple Batches
    When Admin clicks on Delete Multiple Batches button after selecting a record and clicks on close
    Then Admin should be unable to delete the batches
