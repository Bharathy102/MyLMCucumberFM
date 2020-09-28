@productlistde @brokenlinksde
Feature: C2309: ProductList Broken Links validation

@plBrokenLinksDe
Scenario: Verify ProductList Broken Links on Overview tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I wait for the complete page load
	And I verify the broken links on overview tab
	And I click on the Perfomance Tab
	And I wait for the complete page load
	Then I verify the Discrete Rolling Tab is displayed for German site
	Then I Verify the Broken Links
	And I click the Calander Tab for German site
	And I wait for the complete page load
	Then I Verify the Broken Links
	And I click the Annualised Tab for German site
	And I wait for the complete page load
	Then I Verify the Broken Links
	And I click the Cumulative Tab for German site
	And I wait for the complete page load
	Then I Verify the Broken Links	