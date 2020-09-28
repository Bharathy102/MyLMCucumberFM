@productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau  @aa @sg @testpd
Feature: C2284 ProductDetail Three Year Risk Stastics
@pdPerfThreeYr
Scenario: C2284 Verify ProductDetail Three Year Risk Stastics
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	#Then I click on the productlist page fund name navigation check for Overview tab
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I click on Performance Tab on product detail page
	And I wait for the complete page load
	Then I verify the Performance Tab is displayed on product detail page
	And I Scroll down the page
	Then I verify the Three-Year Risk Statistics Performance table is displayed with header
	Then I verify the AsOf date is displayed on "three-year-risk three-year-risk-wgmdr" table
	Then I verify the Three-Year Risk Statistics Data is displayed in table