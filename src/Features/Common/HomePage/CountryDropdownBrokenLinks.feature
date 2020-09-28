@brokenlinks @homepage @uk @cy @dk @sw @au @fn @nr @nl @ml @lu @gr @is @aa @sg @nonproduk @nonprodau
Feature: C2564: Country dropdown brokenlinks validation 

Scenario: C2564: Verify the country dropdown in Home Page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	Then I verify Country dropdown icon is present or not
	Then I verify the list of countries available in country dropdown menu list 
	Then I verify the broken links for Country Dropdown
	And I Close the browser
	