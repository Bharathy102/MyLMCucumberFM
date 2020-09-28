@pdnav @productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau @aa @sg
Feature: C2280:Product detail Net Asset value(NAV) validation 

Scenario: C2281:Product detail Net Asset value(NAV) validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I verify the product list page is displayed
	And I wait for the complete page load
	And I refresh the page
	And I wait for the complete page load	
	#And I select Accept for Terms and Conditions in the SpeedBump
	#Then I click on the productlist page fund name navigation check for Overview tab
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	#And I wait for the complete page load
	And I click on Performance Tab on product detail page
	Then I verify the Performance Tab is displayed on product detail page
	And I click on NAV tab under Performance section
	Then I verify the NAV Header is displayed
	Then I verify the AsOFDate text in NAV Header
	Then I verify Exluding Sales Charges in NAV Header
	Then I verify the Range Filters on NAV chart
	Then I verify the currency displayed in chart title matches share class currency
	Then I verify the AsOfDate format is based on country's local for NAV chart		