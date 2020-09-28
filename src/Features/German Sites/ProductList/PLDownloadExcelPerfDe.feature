@productlistde @de @C1950
Feature: C1950: ProductList Key Actions Download Excel option validation for Performance tab

Scenario: Verify ProductList Key Actions Download Excel option for Performance tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I wait for the complete page load
	And I click on the Perfomance Tab
	And I wait for the complete page load 
	And I click on Key Actions options 
	Then I verify the DownLoad Excel is displayed in KeyActions menu 