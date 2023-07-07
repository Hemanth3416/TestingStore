@search
Feature: Search Functionality

  @search1
  Scenario: Searching for Valid Product
    Given User Opens the Application
    When User Enters Valid Product "HP" into Search Box Field
    And User Clicks on the Search button
    Then User Should get Valid Product Displayed in Search Results

  @search2
  Scenario: User Searching for Invalid Product
    Given User Opens the Application
    When User Enters Invalid Product "Honda" into Search Box Field
    And User Clicks on the Search button
    Then User Should get Message about no Product Matching

  @search3
  Scenario: User Searching without any Product
    Given User Opens the Application
    When User dont Enter any Product Name into Search Box Field
    And User Clicks on the Search button
    Then User Should get Message about no Product Matching
