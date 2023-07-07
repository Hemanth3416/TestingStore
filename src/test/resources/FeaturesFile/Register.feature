@register
Feature: Registration Functionality

  @register1
  Scenario: User Creates an Account only with Mandatory Fields
    Given User Navigates to Register Account Page
    When User Enters the Details into the below Fields
      | firstname | Hemanth                    |
      | lastname  | Kumar                      |
      | email     | avtestcucumber21@gmail.com |
      | telephone |                 9876543210 |
      | password  |                      12345 |
    And User Selects the Privacy Policy
    And User Clicks on Continue button
    Then User Account Successfully Created

  @register2
  Scenario: User Creates an Account with all Fields
    Given User Navigates to Register Account Page
    When User Enters the Details into the below Fields
      | firstname | Hemanth                    |
      | lastname  | Kumar                      |
      | email     | avtestcucumber22@gmail.com |
      | telephone |                 9876543210 |
      | password  |                      12345 |
    And User Selects the Yes for Newsletter
    And User Selects the Privacy Policy
    And User Clicks on Continue button
    Then User Account Successfully Created

  @register3
  Scenario: User Creates a Duplicate Account with all Fields
    Given User Navigates to Register Account Page
    When User Enters the Details into the below Fields
      | firstname | Hemanth                  |
      | lastname  | Kumar                    |
      | email     | avtestcucumber@gmail.com |
      | telephone |               9876543210 |
      | password  |                    12345 |
    And User Selects the Yes for Newsletter
    And User Selects the Privacy Policy
    And User Clicks on Continue button
    Then User getting Proper Warning Dupilicate Email

  @register4
  Scenario: User Creates an Account without Filling all Fields
    Given User Navigates to Register Account Page
    When User dont Enter the Details into the Fields
    And User Clicks on Continue button
    Then User getting Proper Warning Messages for Every Mandatory Fields
