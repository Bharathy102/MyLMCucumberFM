@aboutus @brokenlinks @aboutusch @chdistributor @nonprodch
Feature: C2305: About Us brokenlinks validation 
	
Scenario: C2305: Verify the brokenlinks for About Us Page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load 
	And I click on About us in home page
	And I wait for the complete page load 
	Then I verify the broken links for AboutUs page
	