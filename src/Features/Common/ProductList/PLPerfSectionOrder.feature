@productlist @au @plau  @sg
Feature: C2510:ProductList performance section sequence valiadation for Australia site

Scenario: Verify ProductList Sequence of tabs on performance for Australia site 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	Then I verify the product list page is displayed  
	And I click on the Perfomance Tab
	And I wait for the complete page load
	Then I verify the sequence of tabs on Performance section