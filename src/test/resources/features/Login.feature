Feature: User Login

  @Login @SmokeTest @RegressionTest
  Scenario Outline: Successful login with valid credentials
    Given User is on the login page
    When User enter the username "<username>" and the password "<password>"
    Then User should be redirected to the Products page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @Login @RegressionTest
  Scenario Outline: Failed login attempts with invalid credentials: "<testCredentials>"
    Given User is on the login page
    When User enter the username "<username>" and the password "<password>"
    Then User should see the error message "<expectedMessage>"
 
    Examples:
      |testCredentials | username      | password | expectedMessage                   |
      |Empty username  |               |          | Epic sadface: Username is required|
      |Empty password  | standard_user |          | Epic sadface: Password is required|
