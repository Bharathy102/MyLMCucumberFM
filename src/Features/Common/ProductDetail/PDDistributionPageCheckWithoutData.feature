@pdDistPageWithoutData @productdetail @uk @dk @sw @fn @nr @nl @lu  @pduk @pd1 @aa @sg
Feature: C1935 ProductDetail Distributions Page With out Data Check

Scenario: C1935 Verify ProductDetail Distributions Page With out Data Check
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	#Then I click on the productlist fund which doesn't have distribution data
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	Then I verify the Sub Performance tab is displayed
	And I click on the distribution tab
	And I wait for the complete page load
	Then I verify the distribution With out Data Table header is displayed
	Then I verify the distribution data is not available for Selected Share Class Fund is displayed
	And I Close the browser
	