@component:ui
@version:Release-2
@issue:ETSY-103
@runThis
Feature: Use the Like functionality to stay in touch
  In order to keep in touch
  As a LinkedIn user
  I want to use the like option

  Scenario: Like to stay in touch
    Given I am on the home page
    When I click on likes
    Then I should like until I have no more options