@productdetailDe @de
Feature: ProductDetail Distributions Page With Data Check

@pdDistrPgDataCheckDe
Scenario: Verify ProductDetail Distributions Page With Data Check
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
	And I refresh the page
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	#And I wait for the complete page load
	And I click on the distribution tab
	Then I verify the Distributions table is displayed with header
	Then I verify the distribution table header Dividend / Reinvest Date is displayed
	Then I verify the distribution table header Payable date is displayed
	Then I verify the distribution table header Reinvest Price is displayed
	Then I verify the distribution table header Ordinary Incom is displayed
	Then I verify the Distributions Section Data is displayed in table
	Then I verify the distribution table View Full Table is displayed
	Then I verify the distribution table View Full Table Search Icon is displayed
	And I click the View Full Table
	And I wait for the complete page load
	Then I verify the View Full Table distribution header is displayed
	Then I verify the View Full Table header Dividend / Reinvest Date is displayed
	Then I verify the View Full Table header Payable date is displayed
	Then I verify the View Full Table header Reinvest Price is displayed
	Then I verify the View Full Table header Ordinary Incom is displayed
	Then I verify the View Full Table Close Icon is displayed
	Then I verify the View Full Table View Full Table Search Icon is displayed
	And I click the close icon to close View Full Table
	And I Close the browser