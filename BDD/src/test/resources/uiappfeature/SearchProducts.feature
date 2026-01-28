Feature: search functionality
  Scenario: Search on homepage
    Given user is at the landing page
    When user searches "mobile" in text box
    Then mobile search results should display