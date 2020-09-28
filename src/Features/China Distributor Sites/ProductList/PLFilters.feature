@productlist @chdistributor
Feature: C1901:ProductList filters validation on Overview Tab

Scenario: Verify ProductList filters on Overview Tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View 
	And I wait for the complete page load	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load 
	And I click on the products header for selected distributor
	And I wait for the complete page load
	Then I verify the filter icon is displayed
	And I click on filter icon to expand the filters
	Then I verify the filters are expanded
