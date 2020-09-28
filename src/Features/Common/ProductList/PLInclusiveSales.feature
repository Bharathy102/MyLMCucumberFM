@productlist @sg
Feature: C2470: Load Adjusted Performance on Listing Page

Scenario: Verify the Load Adjusted Performance on Listing Page

	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header
	And I wait for the complete page load
	And I click on the Perfomance Tab
	And I wait for the complete page load 
	Then I verify the Inclusive of Sales Charge and At Nav should be displayed
	And I click on Calendar tab under Performance section
	And I wait for the complete page load 
	Then I verify the Inclusive of Sales Charge and At Nav should be displayed
	And I click on Annualised Tab on Performance section
	And I wait for the complete page load 
	Then I verify the Inclusive of Sales Charge and At Nav should be displayed
	And I click on Cucumlative Tab in Performance section
	And I wait for the complete page load 
	Then I verify the Inclusive of Sales Charge and At Nav should be displayed
	