@productdetail @nl @aa  @aa  @sg
Feature: C2468 ProductDetail Investment Risk - Netherlands

Scenario: C2468 Verify ProductDetail Investment Risk-Rewards Details
	Given I launch the publisher site 
	And I wait for the complete page load
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	Then I click on the productlist page fund name navigation check for Overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I wait for the complete page load
	And I click on the Investment Risk tab
	And I wait for the complete page load
	Then I verify the Investment Risk table is displayed with header
	Then I verify the Investment Risk Rewards Image is displayed
	And I Close the browser