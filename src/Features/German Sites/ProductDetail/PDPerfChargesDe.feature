@productdetailDe @de
Feature: C2283 ProductDetail Performance Charges

@pdChargesDe
Scenario: C2283 ProductDetail Performance Charges
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed	
	Then I click on the productlist page fund name navigation check for Overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I click on Performance Tab on product detail page
	And I wait for the complete page load
	Then I verify the Performance Tab is displayed on product detail page
	Then I verify the "charges charges-characteristics charges" Performance table is displayed with header "Kosten" for German Site
	Then I verify the AsOf date is displayed on "charges charges-characteristics charges" table for German Site
	Then I verify the Charge Section Data is displayed in table
	And I Close the browser