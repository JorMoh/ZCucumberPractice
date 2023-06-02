Feature: Amazon Search
Az an Amazon user,
I want to search things on the website,
so that I find what I am looking for.

@amazonSearchTest
Scenario Outline: Search multiple items
Given I am on Amazon website homepage
And I enter a search item "<Test Data>" in the search field
When I click on the search button
Then I should see the search item "<Test Data>" on the results page

Examples:
|   Test Data  |
|    Chanel    |
|     Dior     |
|   Versace    |
|Tommy Hilfiger|

 