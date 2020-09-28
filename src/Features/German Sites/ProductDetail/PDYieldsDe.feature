@productdetailDe @de @tes
Feature: C2366:Product Yields section validation

@PdYieldsDe
Scenario: C2366:Product Yields section validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed
	Then I click on the productlist page fund name navigation check from overview tab
	And I wait for the complete page load
	Then I verify the Performance Tab is displayed on product detail page
	Then I verify the Yields table is displayed if authored
	Then I verify the Yields header is displayed for German Site
	Then I verify the Yields AsOfDate is displayed for German Site
	Then I verify the AsOf date is displayed on "yields characteristics yields" table for German Site