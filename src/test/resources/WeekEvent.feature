Feature: Adding/ remove Events
  Background:
    Given i am on week page


    Scenario: verify adding a new event
      When I click on plus icon
      And I click on today button
      And I fill in event Name 'maher'
      And I click save
      Then validate the event 'maher' is added

    Scenario: change the first day of the week to Monday
      When I click on menu
      And I click on settings button
      And I click on first day of the week
      And I chose monday to be the first day of the week
      And click on back button
      Then verify that monday is the first day of the week
