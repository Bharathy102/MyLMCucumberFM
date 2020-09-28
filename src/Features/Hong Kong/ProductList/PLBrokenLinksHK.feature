@productlisthk @brokenlinkshk @hk
Feature: C2309: ProductList Broken Links validation

Scenario: Verify ProductList Broken Links on Overview tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load
	And I click on the products header
	And I wait for the complete page load
	And I verify the broken links on overview tab