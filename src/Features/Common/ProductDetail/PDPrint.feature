@productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau  @aa @sg
Feature: C2245:Product detail Print option validation
@pdPrint
Scenario: C2245:Product detail Print option validation
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
	And I click on more options button 
	Then I verify the print option is displayed in KeyActions menu on product detail page