Feature: Login functionality

Scenario: Successful login in OrangeHRM

  Given user is on orangeHRM login page
  When user enters credentials in orangeHRM
  Then user should login successfully in orangeHRM