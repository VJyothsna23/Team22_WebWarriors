@LMS2 @Program_Sort
Feature: Testing the Sorting(Data Ordering) feature of LMS application

  Background: Admin is on Manage Program Page after clicking Program on the navigation bar
  	Given Admin enters the url and logs in to the LMS application
    When Admin is on Manage Program page after clicking Program on the navigation bar

  @PS1
  Scenario: Validates Sort icon for program name column - ascending order
  	When Admin clicks the sort icon of program name column once
    Then The data get sorted on the table based on the program name column values in ascending order

  @PS2
  Scenario: Validates Sort icon for program name column - descending order
    When Admin clicks the sort icon of program name column twice
    Then The data get sorted on the table based on the program name column values in descending order

  @PS3
  Scenario: Validates Sort icon for program Description column - ascending order
    When Admin clicks the sort icon of program Desc column once
    Then The data get sorted on the table based on the program description column values in ascending order

  @PS4
  Scenario: Validates Sort icon for program Description column - descending order
    When Admin clicks the sort icon of program Desc column twice
    Then The data get sorted on the table based on the program description column values in descending order

  @PS5
  Scenario: Validates Sort icon for program Status column - ascending order
    When Admin clicks the sort icon of program Status column once
    Then The data get sorted on the table based on the program status column values in ascending order
   
  @PS6
  Scenario: Validates Sort icon for program Status column - descending order
    When Admin clicks the sort icon of program Status column twice
    Then The data get sorted on the table based on the program status column values in descending order
 