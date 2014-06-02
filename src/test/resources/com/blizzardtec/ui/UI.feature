Feature: UI

  Scenario: Good Login
    Given the username is "test" and the password is "password"
    When the login button is clicked
    Then the welcome page is shown

  Scenario: Bad Login
    Given the username is "test" and the password is "incorrect"
    When the login button is clicked
    Then an error should be shown
