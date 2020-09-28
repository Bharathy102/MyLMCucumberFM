@productdetailswz @swz
Feature: C2278:Product detail Calendar Performance validation

@pdPerfCalendarswz
Scenario: C2278:Product detail Calendar Performance validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed
	And I wait for the complete page load
	Then I click on the "Legg Mason Brandywine Global Opportunistic Fixed Income Fund" in the productlist page under overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I wait for the complete page load
	And I click on Performance Tab on product detail page
	Then I verify the Performance Tab is displayed on product detail page
	And I click on Calendar tab under Performance section for German site
	Then I verify the Calendar Performance table is displayed with header for German site
	Then I verify the AsOf date is displayed on "calendar-performance calendar-performance-kjuip" table
	Then I verify the Header dates on Calendar Performance table
	Then I verify the shareclass Data is displayed on Calendar Table
	Then I verify the Benchmark Data is displayed on Calendar Table	
  Then I verify the Benchmark header is displayed as Benchmark on "calendar-performance calendar-performance" table for German site