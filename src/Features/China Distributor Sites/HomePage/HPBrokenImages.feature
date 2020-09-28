@brokenimages @homepage @chdistributor @nonprodch
Feature: C2563 HomePage Broken Image validation for China distributed sites

Scenario: C2563 Verify HomePage Broken Images for China distributed sites
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load 
	Then I Verify the Broken Images
	And I Close the browser