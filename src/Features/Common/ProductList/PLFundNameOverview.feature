@productlist @uk @dk @sw @au @fn @nr @nl @lu @pluk @plau  @aa @sg
Feature: C1897:ProductList Fund Name check on Overview Tab

Scenario: Verify ProductList Fund Name check on Overview Tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I click on the fund name of the first fund on "overview-table" of product list page
	And I wait for the complete page load
	Then I verify the fund detail page is displayed