@component:ui
@version:Release-2
@issue:ETSY-104
@runThis
@wip
Feature: Find jobs based on jobtitle, keywords or company name
  As a user
  I want to be able to find relevant jobs
  So that I can apply a filter based on location and date posted

  Scenario Outline: Find a job and apply filters
    Given I am on the jobs page
    When I search a '<job>' from jobs page
    And I apply a filter on '<location>'
    Then I should see '<job>' description on the results page

    Examples:
      | job             |location|
      | test automation |Melbourne|