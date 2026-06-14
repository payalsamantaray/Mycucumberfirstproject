Feature: Login functionality

Scenario Outline: Successful login

    Given user is on login page for data driven test
    When user enters username "<Username>"
    And user enters password "<Password>"
    And click on login button
    Then Dashboard page should open

Examples:

| Username       | Password      |
| standard_user | secret_sauce |
| payal         | secret_sauce |
