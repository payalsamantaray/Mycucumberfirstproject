Feature: Login functionality

Scenario: Successful login

    Given  user is on login page
    When  user enters username and password in sauce demo
    Then  user should login successfully in sauce demo
