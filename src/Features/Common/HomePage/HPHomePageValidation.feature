@homepage @uk @dk @sw @cy @au @fn @nr @nl @ml @lu @gr @is @sg @nonproduk @nonprodau
Feature: C1969 Global Home Page Functionality 
	As an author I want to verify the the home page in publisher site

Scenario: C1969 Verify the Header in Home Page 
	Given I launch the publisher site
	When I verify the Title of Lunched Site
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I Verify Franklin Templeton Logo in the home page
	And I Verify Products Menu Header is available in home page
	And I Verify Market Insights Menu Header is available in home page
	And I Verify Products Menu Header is available in home page
	And I Verify Literature Menu Header is available in home page
	And I Verify About Us Menu Header is available in home page
	And I Verify Contact Us Menu Header is available in home page
	And I Verify Global Search Icon is available in home page
	When I Verify Country Dropdown is available in home page
	And I Verify Watchlist Icon is available in home page
	And I Close the browser	