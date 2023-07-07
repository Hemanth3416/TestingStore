@login
Feature: Login Functionality

  @login1
  Scenario: Login with Valid Credentials
    Given User Navigates to Login Page
    When User Enters the Valid Email "avtest@gmail.com" into Email Field
    And User Enters the Valid Password "Avtest@1234" into Password Field
    And User Clicks on Login button
    Then User should Successfully Logged In

  @login2
  Scenario: Login with Invalid Credentials
    Given User Navigates to Login Page
    When User Enters the Invalid Email Address into Email Field
    And User Enters the Invalid Password into Password Field
    And User Clicks on Login button
    Then User should get a Proper Warning Message about Credentials Mismatch

  @login3
  Scenario: Login with Valid Email and Invalid Password
    Given User Navigates to Login Page
    When User Enters the Valid Email "avtest@gmail.com" into Email Field
    And User Enters the Invalid Password into Password Field
    And User Clicks on Login button
    Then User should get a Proper Warning Message about Credentials Mismatch

  @login4
  Scenario: Login with Invalid Email and Valid Password
    Given User Navigates to Login Page
    When User Enters the Invalid Email Address into Email Field
    And User Enters the Valid Password "Avtest@1234" into Password Field
    And User Clicks on Login button
    Then User should get a Proper Warning Message about Credentials Mismatch

  @login5
  Scenario: Login without Providing any Credentials
    Given User Navigates to Login Page
    When User dont Enter the Valid Email into Email Field
    And User dont Enter the Valid Password into Password Field
    And User Clicks on Login button
    Then User should get a Proper Warning Message about Credentials Mismatch
