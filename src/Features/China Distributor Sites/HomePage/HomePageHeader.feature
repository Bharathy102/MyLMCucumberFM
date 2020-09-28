@homepage  @homepage @chdistributor @nonprodch
Feature: C001: Global Home Page Functionality for China distributed sites
	As an author I want to verify the the home page in publisher site

Scenario: C001: Verify the Header in Home Page for China distributed sites
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load 
	And I Verify Contact Us Menu Header is available in home page for selected distributor
	And I Verify Global Search Icon is available in home page
	Then I Verify Country Dropdown is available in home page
	And I verify Language selector is available in home page
	And I verify Role selector is available in home page
	And I Verify Watchlist Icon is available in home page
	And I wait for the complete page load
	And I Close the browser