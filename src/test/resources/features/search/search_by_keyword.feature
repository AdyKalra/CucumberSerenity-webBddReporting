@component:ui
@version:Release-2
@issue:ETSY-102
@runThis
Feature: Search by keyword
  In order for people to find what they are looking for more efficiently
  As a LinkedIn user
  I want people to be able to search for people by names , company , jobs etc..

  Scenario Outline: Search for people by names
    Given I want to see my own profile
    When I search for '<name>'
    Then I should see only my profile with a tag 'You'
  Examples:
  | name |
  | Aditya Kalra (Ady) |


  Scenario Outline: Search for many company , jobs etc.. by keyword
    Given I would like to search about a company
    When I search for '<company>'
    Then I should see only items related to '<company>'
    Examples:
      | company |
      | LinkedIn |
      | Google   |
