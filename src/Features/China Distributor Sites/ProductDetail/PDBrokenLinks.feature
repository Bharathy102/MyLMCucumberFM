@pdBrokenLinks @brokenlinks @productdetail @chdistributor
Feature: C2238 Product Details  Broken Links validation

 
Scenario: C2238 Verify Product Detail Broken Links.
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View
	And I wait for the complete page load 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load 
	And I click on the products header for selected distributor
	And I wait for the complete page load
	Then I Verify the Broken Links
	And I Close the browser