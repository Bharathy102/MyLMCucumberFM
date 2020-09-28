@productlistde @de @plperfAnnualisedde1
Feature: C1953:ProductList Annualised tab validation

Scenario: Verify ProductList Annualised tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I wait for the complete page load
	Then I verify the product list page is displayed  
	And I click on the Perfomance Tab
	And I refresh the page
	And I wait for the complete page load 
	And I click on Annualised Tab on Performance section
	And I wait for the complete page load 
	#PL Annualised Tab
	Then I verify the Inception date is displayed as per country local on "annualized-table" table
	Then I verify the As Of Date is displayed as per country local on "annualized-table" table for German Site
	Then I verify the data for the first fund on "annualized-table" of product list page 
	And I click on the fund name of the first fund on "annualized-table" of product list page
	And I wait for the complete page load 
	Then I verify the product detail page is displayed
	And I wait for the complete page load 
	Then I verify the Share Class on the detail page