@productlist @uk @dk @sw @au @fn @nr @nl @lu @pluk @plau  @aa  @sg
Feature: C1988:ProductList Key Actions Download Excel option validation

Scenario: Verify ProductList Key Actions Download Excel option
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	Then I verify Overview tab is displayed
	Then I verify the tooltip for Overview columns
	And I click on the Perfomance Tab
	And I click on Discrete Rolling Tab on Performance section
	Then I verify the tooltip for Performance Discrete columns
	And I click on Calender Tab on Performance section
	Then I verify the tooltip for Performance Calender columns
	And I click on Annualised Tab on Performance section
	Then I verify the tooltip for Performance Annualised columns
	And I click on Cucumlative Tab in Performance section
	Then I verify the tooltip for Performance Cucumlative columns	