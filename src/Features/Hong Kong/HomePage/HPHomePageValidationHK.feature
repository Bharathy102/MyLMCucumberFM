@homepagehk @nonprodhk @hk
Feature: C1969 Global Home Page Functionality for Hong Kong sites
	As an author I want to verify the the home page in publisher site

Scenario: C1969 Verify the Header in Home Page for Hong Kong sites
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load
	And I Verify Contact Us Menu Header is available in home page
	And I Verify Global Search Icon is available in home page
	When I Verify Country Dropdown is available in home page
	And I Verify Watchlist Icon is available in home page
	And I Close the browser	