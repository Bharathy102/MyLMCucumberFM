@pdBrokenImages @brokenimages @productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau @aa  @sg
Feature: C2237 Product Details  Broken Image validation

Scenario: C2237 Verify Product Detail Broken Images.
	Given I launch the publisher site
	And I wait for the complete page load
	When I verify the Title of Lunched Site
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	Then I verify Overview tab is displayed
	And I wait for the complete page load
	Then I Verify the Broken Images
	And I click on the Perfomance Tab
	And I wait for the complete page load
	Then I verify the Discrete Rolling Tab is displayed
	Then I Verify the Broken Images
	And I click the Calander Tab
	And I wait for the complete page load
	Then I Verify the Broken Images
	And I click the Annualised Tab
	And I wait for the complete page load
	Then I Verify the Broken Images
	And I click the Cumulative Tab
	And I wait for the complete page load
	Then I Verify the Broken Images
	And I Close the browser