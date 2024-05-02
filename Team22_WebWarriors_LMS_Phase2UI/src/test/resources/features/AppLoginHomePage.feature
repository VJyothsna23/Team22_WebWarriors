@LMS
Feature: Testing the Login Page of LMS application

  Background: User is on the LMS Login page
    Given User enters LMS url application

  @LP1
  Scenario: Verify admin is able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should recieve 404 page not found error

  @LP2
  Scenario Outline: Validate login with valid credentials
    When Admin enter valid credentials from excel sheet "<Sheetname>" and <RowNumber>
    Then Admin should land on dashboard page

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  @LP3
  Scenario Outline: Validate login with Invalid credentials
    When Admin enter Invalid credentials from excel sheet "<Sheetname>" and <RowNumber>
    Then Error message please check username/password

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  @LP4
  Scenario Outline: Validate login credentials with null username
    When Admin enter password from excel sheet "<Sheetname>" and <RowNumber>
    Then Error message please check username

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         2 |

  @LP5
  Scenario Outline: Validate login credentials with null password
    When Admin enter user from excel sheet "<Sheetname>" and <RowNumber>
    Then Error message please check password

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         3 |

  @LP6
  Scenario Outline: verify login button action through keyboard
    When Admin enter valid credentials and click through keyboard from excel sheet "<Sheetname>" and <RowNumber>
    Then Admin Lands on Dashboard Page

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  @LP7
  Scenario Outline: verify login button action through mouse
    When Admin enter valid credentials and click through mouse from excel sheet "<Sheetname>" and <RowNumber>
    Then Admin should land on page dashboard

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |
