@productlist @brokenlinks  @chdistributor
Feature: C2309: ProductList Broken Links validation

Scenario: Verify ProductList Broken Links on Overview tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View
	And I wait for the complete page load 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load
	And I click on the products header for selected distributor
	And I wait for the complete page load
	And I verify the broken links on overview tab