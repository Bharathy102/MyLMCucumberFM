@productdetail @au @pdau
Feature: C2511:Product detail Performance data display for less than one year for Australian products

Scenario: C2511:Product detail Perf data display for less than one year for Australia
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	And I wait for the complete page load
	And I refresh the page
	And I wait for the complete page load
	Then I click on the "BetaShares Legg Mason Australian Bond Fund (managed fund) (ASX: BNDS)" from product list page for Australia
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I wait for the complete page load
	And I click on Performance Tab on product detail page
	And I refresh the page
	And I wait for the complete page load 
	Then I verify the Performance Tab is displayed on product detail page
	And I click on Annualised tab under Performance section
	Then I verify the Annualised Performance table is displayed with header
	Then I verify the shareclass Data is displayed on Annualized Table for Australia
	
	And I click on Calendar tab under Performance section
	Then I verify the Calendar Performance table is displayed with header
	Then I verify the shareclass Data is displayed on Calendar Table for Australia
	
	And I click on Rolling tab under Performance section
	Then I verify the Rolling Month table is displayed with header
	Then I verify the shareclass Data is displayed on Discrete Table for Australia
