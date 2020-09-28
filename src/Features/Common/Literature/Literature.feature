@literature @brokenlinks @uk @cy @dk @sw @fn @nr @nl @ml @lu @gr @is @sg @nonproduk @aa 
Feature: Literature Page Menu Header & Broken Link validation 

Scenario: Verify the Literature page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump 
	Then I Verify Literature Menu Header is available in home page
	And I click Literature header
	Then I verify the broken links for Literature page
