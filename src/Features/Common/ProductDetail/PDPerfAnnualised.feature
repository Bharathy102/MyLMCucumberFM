@pdPerfAnnualized @productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau @aa  @sg
Feature: C2279:Product detail Annualised Performance validation

@pdAnnualisedPerf
Scenario: C2279:Product detail Annualised Performance validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	And I wait for the complete page load
	#Then I click on the productlist page fund name navigation check for Overview tab
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I click on Performance Tab on product detail page
	Then I verify the Performance Tab is displayed on product detail page
	And I click on Annualised tab under Performance section
	Then I verify the Annualised Performance table is displayed with header
	Then I verify Annualised datas are not having brackets for negative values
	Then I verify the AsOf date is Annualised displayed on table
	Then I verify the Header dates on Annualised Performance table
	Then I verify the shareclass Data is displayed on Annualised table
	Then I verify the Benchmark Data is displayed on Annualised Table	