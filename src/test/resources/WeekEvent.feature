Feature: Adding/ remove Events
  Background:
    Given i am on week page
    When i click on plus icon
    And i click on today button
    And i fill a event 'name'
    And i click save


    Scenario: verify adding a new event
      Then validate the event 'name' is added

    Scenario: change the first day of the week to Monday
      When i click on menu
      And i click on settings button
      And i click on first day of the week
      And i chose monday to be the first day of the week
      And click on back button
      Then verify that monday is the first day of the week

    Scenario: delete a Event 'name'
      When i click on menu
      And i click on all events
      And i click on the event
      And click the delete button
      And click yes to delete that event
      Then verify the event is deleted

    Scenario: verify adding a new event at 4pm
      When i click on four pm
      And click new event
      And i fill a event 'party'
      And i click save
      Then the 'party' event will be added


