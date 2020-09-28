@pdNavCheck @productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau @aa @sg
Feature: C1927:Product detail navigation check

Scenario: C1927:Product detail navigation check
	Given I launch the publisher site
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	#Then I click on the productlist page fund name navigation check from overview tab
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load 
	Then I verify the Fund Name is displayed
	Then I verify the Share Class name matches with the Share Class of the product List page
	And I refresh the page
	And I wait for the complete page load
	And I click on the products header
	And I refresh the page
  And I wait for the complete page load
	Then I click on the "EnTrust Global Alternative Income Strategy" in the productlist page under overview tab
	And I wait for the complete page load
	Then I verify the Fund Name is displayed
