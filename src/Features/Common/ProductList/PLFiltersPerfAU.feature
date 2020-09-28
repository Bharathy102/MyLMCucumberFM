@productlist @au @failedrun @plau
Feature: 2525:ProductList filters validation on Performance Tab for Australia Site

Scenario: Verify ProductList filters on Performance Tab for Australia site
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
	Then I verify the filter icon is displayed
	And I click on filter icon to expand the filters
	Then I verify the filters are expanded
	#Then I verify the Distribution Type filters are displayed
	Then I verify the Asset Class filters are dsiplayed
	Then I verify the Investment Manager filters are displayed
	Then I verify the watchlist filters are displayed
	#Then I verify the Domicile filters are displayed
	#Then I verify the Currency filters are displayed
	#Then I verify the Share Class filters are displayed
	Then I verify the Vehicle Type filters are displayed
	Then I verify the Vehicle filter options
	And I select "ETF" checkbox in "checkbox-group product-type" filter
	#Then I verify the results are based on ETF filter selected
	#Clear off the ETF filter checkbox
	And I select "ETF" checkbox in "checkbox-group product-type" filter
	And I select "Managed Fund" checkbox in "checkbox-group product-type" filter
	#Then I verify the results are based on Managed Fund filter selected
	#Clear off the Managed Fund filter checkbox
	#And I select "Managed Fund" checkbox in "checkbox-group product-type" filter
	#And I select "Distributing" checkbox in "checkbox-group distribution-type" filter
	Then I verify the funnel count is changed to 1
	Then I verify the chip is displayed for the selected filter
	And I select "Fixed Income" checkbox in "checkbox-group asset-classes" filter
	Then I verify the funnel count is changed to 2
	Then I verify the chip is displayed for the selected filter
	#PL Annualised Tab
	#Then I verify the filtered results on "annualized-table" tab based on the "Fixed Income" selected filters from "asset-class-fields" on "3" position	
	#PL Annualised Tab
	And I click on Cucumlative Tab in Performance section
	#Then I verify the filtered results on "cumulative-table" tab based on the "Fixed Income" selected filters from "asset-class-fields" on "3" position
	#PL Cumulative Tab
	And I click on Calender Tab on Performance section
	#Then I verify the filtered results on "discrete-table" tab based on the "Fixed Income" selected filters from "asset-class-fields" on "3" position
	And I click on Discrete Rolling Tab on Performance section
	#Then I verify the filtered results on "discrete-table" tab based on the "Fixed Income" selected filters from "asset-class-fields" on "3" position	