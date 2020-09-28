@productlist @uk @dk @sw @au @fn @nr @nl @lu @pluk @rerun5 @plau  @aa  @sg
Feature: C1944:ProductList performance data capture

Scenario: Verify ProductList Performance data capture
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
	And I click on Discrete Rolling Tab on Performance section
	And I wait for the complete page load 
	#PL Discrete Rolling Tab
	And I set the Rows per page dropdown to "100"
	#Then I capture data from the "discrete" tab on the Performance section
	#PL Calendar Tab
	And I click on Calender Tab on Performance section
	And I wait for the complete page load 
	And I set the Rows per page dropdown to "100"
	#Then I capture data from the "calendar" tab on the Performance section
	#PL Annualised Tab
	And I click on Annualised Tab on Performance section
	And I wait for the complete page load 
	And I set the Rows per page dropdown to "100"
	#Then I capture data from the "annualized" tab on the Performance section
	#PL Cumulative Tab
	And I click on Cucumlative Tab in Performance section
	And I wait for the complete page load
	And I set the Rows per page dropdown to "100" 
	#Then I capture data from the "cumulative" tab on the Performance section	
