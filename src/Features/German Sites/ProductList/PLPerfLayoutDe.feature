@productlistde @de @pllayoutde @C1944de
Feature: C1944:ProductList performance layout validation

Scenario: Verify ProductList Performance Layout
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I refresh the page
	And I wait for the complete page load
	Then I verify the product list page is displayed  
	And I click on the Perfomance Tab
	And I wait for the complete page load 
	#PL Discrete Rolling Tab
	And I click on Discrete Rolling Tab on Performance section
	Then I verify the columns on Discrete Rolling tab on Performance section
	#PL Calendar Tab
	And I click on Calender Tab on Performance section
#	And I wait for the complete page load 
	Then I verify the columns on Calendar tab on Performance section
	#PL Annualised Tab
	And I click on Annualised Tab on Performance section
#	And I wait for the complete page load 
	Then I verify the columns on Annualised tab on Performance section for German Site
	#PL Cumulative Tab
	And I click on Cucumlative Tab in Performance section
	#And I wait for the complete page load 
	Then I verify the columns on Cumulative tab on Performance section for German Site