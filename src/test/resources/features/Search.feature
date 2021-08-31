@search
Feature: feature to test search functionality of PwC Digital Pulse website

  Scenario: Validate the search result
    Given I navigate to the PwC Digital Pulse website
    When I click on the Magnifying Glass icon to perform a search
    And I enter the text "Single Page Applications"
    And I submit the search
    Then I am taken to the search results page
    And I am presented with at least one search result