@brokenlinks @homepage @chdistributor @nonprodch
Feature: C2293 HomePage Broken Links validation for China distributed sites

Scenario: C2293 Verify HomePage Broken Links for China distributed sites
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load 
	Then I Verify the Broken Links
	And I Close the browser