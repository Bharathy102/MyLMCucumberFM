@productdetailDe @de
Feature: ProductDetail Distributions Page With out Data Check

@pdDistrPgWithoutData
Scenario: Verify ProductDetail Distributions Page With out Data Check
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed
	And I click on the Perfomance Tab
	And I refresh the page
	And I wait for the complete page load
	Then I verify the Performance tab is displayed
	Then I click on the productlist fund which doesn't have distribution data
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	Then I verify the Sub Performance tab is displayed
	And I click on the distribution tab
	And I wait for the complete page load
	Then I verify the distribution With out Data Table header is displayed for German site
	Then I verify the distribution data is not available for Selected Share Class Fund is displayed for German site
	And I Close the browser
	