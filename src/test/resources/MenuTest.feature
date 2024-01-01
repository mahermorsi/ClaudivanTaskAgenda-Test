Feature: testing submenu popup
  Background:
    Given i am on week page
    And I click on top left menu icon

  Scenario: navigating to late events page
    When I click on Late events
    Then I should be navigated to late events page

  Scenario: check if dark screen mode is applicable
    When I click on Colors and event types
    And I click on Dark mode
    And I click on Disabled button
    Then Dark mode should be disabled

  Scenario: navigating to All events
    When I click on All events
    Then I should be navigated to All events page