Feature: As a customer
  I want to try login or Sign in


  Background:
    Given I am on home page

  @login
  Scenario: Log in page validation messages
    And I select member login button
    When I tried to login with no details
    Then I can see why my login failed

  @login
  Scenario: Login to my account
    And I select member login button
    When I enter my details
      | email | password |
      | test  | pwd      |
    Then I select login button

	
