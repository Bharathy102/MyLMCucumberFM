@productdetailDe @de
Feature: C2276:Product detail Rolling 12 Month Performance validation

@pdPerfRollingDe
Scenario: C2276:Product detail Rolling 12 Month Performance validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed
  And I wait for the complete page load
	Then I click on the "Legg Mason Brandywine Global Opportunistic Fixed Income Fund" in the productlist page under overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I wait for the complete page load
	And I click on Performance Tab on product detail page
	And I wait for the complete page load
	Then I verify the Performance Tab is displayed on product detail page
	And I click on Rolling tab under Performance section for German site
	Then I verify the Rolling Month table is displayed with header for German site
	Then I verify the AsOf date is displayed on "annual-discrete annual-discrete" table
	Then I verify the Header dates on Rolling 12 Month table
	Then I verify the shareclass Data is displayed on Discrete table
	Then I verify the Benchmark Data is displayed on Rolling table
	Then I verify the Benchmark header is displayed as Benchmark on "annual-discrete annual-discrete" table for German site