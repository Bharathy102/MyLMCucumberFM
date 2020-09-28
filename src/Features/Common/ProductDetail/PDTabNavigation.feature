@productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau  @aa @sg
Feature: C2365:Product detail Tabs navigation validation
@pdTabNAv
Scenario: C2365:Product detail Tabs Navigation validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I verify the product list page is displayed
	And I wait for the complete page load
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load 
	And I click on Performance Tab on product detail page
	Then I verify the Performance section is displayed and the tab is active
	And I click on characteristics tab on product detail page
	Then I verify the characteristics section is displayed and the tab is active
	And I click on Literature tab on product detail page
	Then I verify the Literature section is displayed and the tab is active
	And I click on Managers tab on product detail page
	Then I verify the Managers section is displayed and the tab is active
	And I click on Investment Risks tab on product detail page
	Then I verify the Investment Risks section is displayed and the tab is active
	And I click on Holdings tab on product detail page
	Then I verify the Holdings section is displayed and the tab is active
	And I click on Distributions tab on product detail page
	Then I verify the Distributions section is displayed the tab is active	