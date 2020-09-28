@productlist @uk @dk @sw @au @fn @nr @nl @lu @pluk @plau  @aa  @sg
Feature: C2361:ProductList Social Share availability validation

Scenario: Verify ProductList Social Share availability validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I click on Key Actions options 
	Then I verify the Facebook option is displayed in KeyActions menu
	Then I verify the Twitter option is displayed in KeyActions menu
	Then I verify the LinkedIn option is displayed in KeyActions menu