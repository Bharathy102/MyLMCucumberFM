@aboutus @brokenimages @aboutusch @chdistributor @nonprodch
Feature: C2306: About Us brokenimage validation 

Scenario: C2306: Verify the Broken Images for AboutUs page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load 
	And I click on About us in home page
	And I wait for the complete page load 
	Then I verify the broken Images for AboutUs page
	