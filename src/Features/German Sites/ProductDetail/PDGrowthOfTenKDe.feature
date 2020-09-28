@productdetailDe @de
Feature: C2281:Product detail Growth of 10K validation 

@pd10kDe
Scenario: C2281:Product detail Growth of 10K validation

	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
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
	Then I verify the Performance Tab is displayed on product detail page
	And I click on GrowthOf10K tab under Performance section for German site
	Then I verify the GrowthOf10K Header is displayed for German site
	Then I verify the AsOFDate text in GrowthOf10k Header for German site
	Then I verify Exluding Sales Charges in GrowthOf10k Header for German site
	Then I verify the Range Filters on GrowthOf10K chart for German site
	Then I verify the currency displayed in chart title matches share class currency
	Then I verify the AsOfDate format is based on country's local for GrowthOf10k
		