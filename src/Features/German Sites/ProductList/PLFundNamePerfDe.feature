@productlistde @de
Feature: C1845:ProductList Fund Name check on Performance Tab

Scenario: Verify ProductList Fund Name check on Performance Tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I wait for the complete page load
	Then I verify the Performance tab is displayed 
	And I click on the Perfomance Tab
	And I refresh the page
	And I wait for the complete page load 
	And I click on the fund name of the first fund on "tab-performance" of product list page
	
	Then I verify the product detail page is displayed