@LMS @Batch_Delete
Feature: Testing the Delete Batch and Delete Multiple Batches confirmation windows of LMS application

  Background: Admin is on Manage Batch Page after clicking Batch on the navigation bar
    Given Admin is in Home Page enter valid credentials  and clicks login button
    When Admin is on Manage Batch page after clicking Batch on the navigation bar

  @BD1
  Scenario: Validate row level delete icon
    When Admin clicks the delete icon
    Then Alert appears with yes and No option

  @BD2
  Scenario: Validate accept alert
    When Admin clicks <Yes> button on the alert after clicking on Delete program button
    Then Batch deleted alert pops and batch is no more available in data table

  @BD3
  Scenario: Validate reject alert
    When Admin clicks <NO> button on the alert after clicking on Delete program button
    Then Batch is still listed in data table
 