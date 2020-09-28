@productlistde @de @C1951de
Feature: C1951:ProductList Key Actions print option validation

Scenario: ProductList Key Actions print option
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I wait for the complete page load
	And I click on the Perfomance Tab
	And I wait for the complete page load
	And I click on Key Actions options 
	Then I verify the print option is displayed in KeyActions menu