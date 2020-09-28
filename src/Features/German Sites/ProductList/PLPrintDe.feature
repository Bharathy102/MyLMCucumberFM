@productlistde @de @C1903de
Feature: C1903:ProductList Print options validation on Overview Tab

Scenario: Verify ProductList Print options validation on Overview Tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I wait for the complete page load
	And I click on Key Actions options 
	Then I verify the print option is displayed in KeyActions menu