@marketinsights @uk @au @nonproduk @nonprodau  @aa  @sg
Feature: C1946 Market Insights Sorting validation
@marSort
Scenario: C1946 Verify Sorting Check in MarketInsights
	Given I launch the publisher site
	And I wait for the complete page load
	When I verify the Title of Lunched Site
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load
	And I Verify Market Insights Menu Header is available in home page
	And I wait for the complete page load
  Then I Click Market Insights header
  And I wait for the complete page load
  And I click SoryBy DropDown Link
	And I verify Ascending By Date is available or not in SortBy DropDown
	And I verify Ascending By title is available or not in SortBy DropDown
	And I verify Descending By Date is available or not in SortBy DropDown
	And I verify Descending By title is available or not in SortBy DropDown
	And I Click and Verify Descending By title Selection page is lunched
	And I Click and Verify Descending By Date Selection page is lunched
	And I Click and Verify Ascending By title Selection page is lunched
	And I Click and Verify Ascending By Date Selection page is lunched
	And I refresh the page
	And I wait for the complete page load
	When I Verify Sorting using List tap
	And I Click and Verify Descending By title Selection page is lunched
	And I Click and Verify Descending By Date Selection page is lunched
	And I Click and Verify Ascending By title Selection page is lunched
	And I Click and Verify Ascending By Date Selection page is lunched	