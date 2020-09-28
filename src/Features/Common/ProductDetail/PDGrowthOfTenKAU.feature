@productdetail @au @pdau
Feature: C2512:Product detail Growth of 10K - Excluding Sales Charge label
@10kAu
Scenario: C2512:Product detail Growth of 10K - Excluding Sales Charge label

	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	And I wait for the complete page load
	#Then I click on the productlist page fund name navigation check for Overview tab
	Then I click on the "Legg Mason Brandywine Global Fixed Income Fund" in the productlist page under overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I wait for the complete page load
	And I click on Performance Tab on product detail page
	And I click on GrowthOf10K tab under Performance section
	Then I verify Exluding Sales Charges in GrowthOf10k Header
	Then I verify the data ranges showing datas correctly		