@productlistde @de @keyactionde
Feature: C1943:ProductList KeyActions validation

Scenario: Verify ProductList KeyActions
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I wait for the complete page load
	Then I verify the product list page is displayed
	And I click on KeyActions button
	Then I verify the KeyActions model window is opened
	And I wait for the complete page load 
	Then I verify the the link in KeyActions window
	And I wait for the complete page load 
	And I click on close button on KeyActions window	