@productdetail @uk @dk @sw @fn @nr @nl @lu @pduk  @aa @sg
Feature: C2291:Risk Reward Profile section validation on product detail page
@pdRiskReward
Scenario: C2291:Risk Reward Profile section validation on product detail page
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
	And I click on Investment Risks tab on product detail page
	Then I verify the Investment Risks section is displayed and the tab is active
	Then I verify the Risk Reward Profile component is displayed on product detail page