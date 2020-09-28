@brokenimageswz @productdetailswz @swz
Feature: Product Details  Broken Image validation

@pdBrokenImageswz
Scenario: Verify Product Detail Broken Images.
	Given I launch the publisher site
	And I wait for the complete page load
	When I verify the Title of Lunched Site
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I wait for the complete page load
	And I verify the product list page is displayed
	Then I verify Overview tab is displayed
	Then I Verify the Broken Images
	And I click on the Perfomance Tab
	And I wait for the complete page load
	Then I verify the Discrete Rolling Tab is displayed for German site
	Then I Verify the Broken Images
	And I click the Calander Tab for German site
	And I wait for the complete page load
	Then I Verify the Broken Images
	And I click the Annualised Tab for German site
	And I wait for the complete page load
	Then I Verify the Broken Images
	And I click the Cumulative Tab for German site
	And I wait for the complete page load
	Then I Verify the Broken Images
	Then I click on the productlist page fund name navigation check for Performance tab
	And I wait for the complete page load
	Then I Verify the Broken Images
	And I Close the browser