@homepagede @de @nonprodde 
Feature: C1970: Country Dropdown validation in UK Site 

Scenario: C1970: Verify the country dropdown in Home Page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	Then I verify Country dropdown icon is present or not
	Then I verify the list of countries available in country dropdown menu list for German site
	Then I verify the country link has underline when mouse hover
	And I Close the browser