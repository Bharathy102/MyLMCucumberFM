@aboutusfr @fr @nonprodfr
Feature: C1962: About Us validation 

Scenario: C1962: Verify the About Us page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on About us in home page
	And I wait for the complete page load 
	And I click Annual Report
	And I wait for the complete page load 
	Then I verify the broken links for Annual Reports