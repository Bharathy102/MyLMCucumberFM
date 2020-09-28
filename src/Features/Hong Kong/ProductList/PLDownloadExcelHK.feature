@productlisthk @hk
Feature: C1902: ProductList Key Actions Download Excel option validation

Scenario: Verify ProductList Key Actions Download Excel option
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I click on Key Actions options 
	Then I verify the DownLoad Excel is displayed in KeyActions menu