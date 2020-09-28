@brokenlinkfr @productdetailfr @fr
Feature: C2238 Product Details  Broken Links validation

@pdBrokenLinksfr
Scenario: C2238 Verify Product Detail Broken Links.
	Given I launch the publisher site
	And I wait for the complete page load
	When I verify the Title of Lunched Site
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for France Site
	And I wait for the complete page load
	And I verify the product list page is displayed
	Then I verify Overview tab is displayed
	And I wait for the complete page load
	Then I click on the productlist page fund name navigation check for Overview tab
	And I wait for the complete page load
	Then I Verify the Broken Links	
	And I Close the browser