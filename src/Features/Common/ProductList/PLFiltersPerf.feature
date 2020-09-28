@productlist @uk @dk @sw @fn @nr @nl @lu @pluk  @aa @sg1
Feature: C1948:ProductList filters validation on Performance Tab

Scenario: Verify ProductList filters on Performance Tab 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	Then I verify the product list page is displayed
	And I click on the Perfomance Tab
	And I wait for the complete page load 
	#PL Discrete Rolling Tab
	Then I verify the filter icon is displayed
	And I click on filter icon to expand the filters
	Then I verify the filters are expanded
	Then I verify the Share Class filters are displayed
	Then I verify the Asset Class filters are dsiplayed
	Then I verify the Currency filters are displayed
	Then I verify the Investment Manager filters are displayed
	Then I verify the Domicile filters are displayed
	Then I verify the watchlist filters are displayed
	Then I verify the Distribution Type filters are displayed 
	And I select first Share Class filter checkbox
	#And I select the first Currency filter checkbox
	#Below steps fails due to open defect#AI-2000
	Then I verify the filtered results on "discrete-table" tab based on the "share-classes-fields" and "A" selected filters on "2" position
	#Then I verify the filtered results on "discrete-table" tab based on the "currency-fields" and "USD" selected filters on "3" position
	#PL Calendar Tab
	And I click on Calender Tab on Performance section
	Then I verify the filtered results on "calendar-table" tab based on the "share-classes-fields" and "A" selected filters on "2" position
	#Then I verify the filtered results on "calendar-table" tab based on the "currency-fields" and "USD" selected filters on "3" position
	#PL Annualised Tab
	And I click on Annualised Tab on Performance section
	Then I verify the filtered results on "annualized-table" tab based on the "share-classes-fields" and "A" selected filters on "2" position
	#Then I verify the filtered results on "annualized-table" tab based on the "currency-fields" and "USD" selected filters on "3" position
	#PL Cumulative Tab
	And I click on Cucumlative Tab in Performance section
	Then I verify the filtered results on "cumulative-table" tab based on the "share-classes-fields" and "A" selected filters on "2" position
	#Then I verify the filtered results on "cumulative-table" tab based on the "currency-fields" and "USD" selected filters on "3" position	