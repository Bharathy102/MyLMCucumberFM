Feature: C2394:Product detail Inclusive of Sales validation

Scenario: C2394: Product Detail - Performance validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	#And I select Opt In for Cookie Policy in the SpeedBump 
	#And I select User Role in the SpeedBump 
	#And I select Accept for Terms and Conditions in the SpeedBump
	#And I wait for the complete page load 
	#And I click on the products header
	#And I verify the product list page is displayed
	#And I click on the Perfomance Tab
	#And I wait for the complete page load
	#Then I verify the Performance tab is displayed
	#Then I click on the productlist page fund name navigation check for Performance tab
	#And I wait for the complete page load
	#Then I verify the product detail page is Navigated
	#And I wait for the complete page load
	And I click on Performance Tab on product detail page
	And I wait for the complete page load
	Then I verify the Performance Tab is displayed on product detail page
	And I click on Annualised tab under Performance section
	Then I verify Annualised Exclusive sales of charge to be present
	Then I verify Annualised Inclusive of Sales data to be present
	Then I verify Annualised Benchmark to be present
	Then I click on Cumulative tab under in Product Detail under Performance
	Then I verify Cumulative Exclusive sales of charge to be present
	Then I verify Cumulative Inclusive of Sales data to be present
	Then I verify Cumulative Benchmark to be present
	
