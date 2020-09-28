@productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau  @aa @sg @C2366
Feature: C2366:Product Yields section validation
@pdYields
Scenario: C2366:Product Yields section validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	#Then I click on the productlist page fund name navigation check from overview tab
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load
	And I click on Performance Tab on product detail page
	And I wait for the complete page load
	Then I verify the Performance Tab is displayed on product detail page
	Then I verify the Yields table is displayed if authored
	Then I verify the Yields header is displayed
	Then I verify the Yields AsOfDate is displayed
	Then I verify the Yields AsOfdate is based on country's local