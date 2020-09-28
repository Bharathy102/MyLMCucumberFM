@productdetailDe @de
Feature: C2287 ProductDetail Performance Disclosure

@pdDisclosureDe
Scenario: C2287 ProductDetail Performance Disclosure
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
	And I wait for the complete page load
	And I verify the Disclosure Section is displayed
	And I Close the browser
	