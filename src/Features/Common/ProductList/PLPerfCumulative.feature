@productlist @uk @dk @sw @au @fn @nr @nl @lu @pluk @plau  @aa  @sg
Feature: C1992:ProductList Cumulative tab validation
@plPerfCum
Scenario: C1992:Verify ProductList Cumulative tab
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
	And I refresh the page
	And I wait for the complete page load 
	And I click on Cucumlative Tab in Performance section
	And I wait for the complete page load 
	#PL Discrete Rolling Tab
	Then I verify the Inception date is displayed as per country local on "cumulative-table" table
	Then I verify the As Of Date is displayed as per country local on "cumulative-table" table
	Then I verify the data for the first fund on "cumulative-table" of product list page 
	And I click on the fund name of the first fund on "cumulative-table" of product list page
	Then I verify the product detail page is displayed
	And I wait for the complete page load
	Then I verify the ShareClass inception date is as per the country's local
	Then I verify the AsOfDate is as per country's local
	Then I verify the Share Class on the detail page