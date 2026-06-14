Feature: Rediff Registration

  Scenario: Enter user details

    Given user is on registration page

    When Enter the following data
      | Payal | payal123@gmail.com | pass123 | 10 | APR | 2009 |


      Then Registartion successfully.