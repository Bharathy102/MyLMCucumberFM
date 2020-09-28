@pdBrokenImages @brokenimages @productdetail @chdistributor
Feature: C2237 Product Details  Broken Image validation

Scenario: C2237 Verify Product Detail Broken Images.
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View
	And I wait for the complete page load 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load 
	And I click on the products header for selected distributor
	And I wait for the complete page load
	Then I Verify the Broken Images
	And I Close the browser