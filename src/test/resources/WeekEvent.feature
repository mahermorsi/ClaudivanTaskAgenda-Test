Feature: Adding/ remove Events
  Background:
    Given i am on week page


    Scenario: verify adding a new event
      When i click on plus icon
      And i click on today button
      And i fill a event 'name'
      And i click save
      Then validate the event 'name' is added

    Scenario: change the first day of the week to Monday
      When i click on menu
      And i click on settings button
      And i click on first day of the week
      And i chose monday to be the first day of the week
      And click on back button
      Then verify that monday is the first day of the week
