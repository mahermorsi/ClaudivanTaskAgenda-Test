Feature: Adding/ remove Events
  Background:
    Given i am on week page


    Scenario: verify adding a new event
      When i click on plus icon
      And i click on today button
      And i fill event name
      And i click save
      Then validate the event is added

      Scenario: Add time event
        When i ckick on 4 Thu , 11:00 rectangle
        And i click new event
        And i fill event 'name'
        And i click save
        Then event 'name' should be displayed and the same rectangle