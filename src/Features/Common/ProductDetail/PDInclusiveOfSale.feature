@productdetail @sg  @aa 
Feature: C2469:Product detail Inclusive of Sales validation

Scenario: C2469:Product detail Inclusive Sales validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	Then I click on the productlist page fund name navigation check for Overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I wait for the complete page load
	And I click on Performance Tab on product detail page
	Then I verify the Performance Tab is displayed on product detail page
	And I click on Annualised tab under Performance section
	And I wait for the complete page load 
	Then I verify the Annualised Performance table is displayed with header
	Then I verify the AsOf date is Annualised displayed on table
	Then I verify the Header dates on Annualised Performance table
	Then I verify the shareclass Data is displayed on Annualised table
	Then I verify the Benchmark Data is displayed on Annualised Table
	Then I verify Annualised Inclusive of Sales data to be present
	Then I click on Cumulative tab under in Product Detail under Performance
	And I wait for the complete page load 
	Then I verify the "cumulative-performance cumulative-performance-jewqu" Performance table is displayed with header
	Then I verify the AsOf date is displayed on "cumulative-performance cumulative-performance-jewqu" table
	#Then I verify the Header dates on Cumulative Performance table
	Then I verify the shareclass Data is displayed on Cumulative table
	Then I verify the Benchmark Data is displayed on Cumulative Table
	Then I verify Cumulative Inclusive of Sales data to be present
	And I click on Calendar tab under Performance section
	And I wait for the complete page load 
	Then I verify the Calendar Performance table is displayed with header
	Then I verify the AsOf date is displayed on "calendar-performance calendar-performance-kjuip" table
	Then I verify the Header dates on Calendar Performance table
	Then I verify the shareclass Data is displayed on Calendar Table
	Then I verify the Benchmark Data is displayed on Calendar Table	
	Then I verify Calender Inclusive of Sales data to be present
	And I click on Rolling tab under Performance section
	And I wait for the complete page load 
	Then I verify the Rolling Month table is displayed with header
	Then I verify the AsOf date is displayed on "annual-discrete annual-discrete" table
	#Then I verify the Header dates on Rolling 12 Month table
	Then I verify the shareclass Data is displayed on Discrete table
	Then I verify the Benchmark Data is displayed on Rolling table
	Then I verify Rolling Inclusive of Sales data to be present
	
	
	