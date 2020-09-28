@pdBrokenLinks @brokenlinkshk @productdetailhk @hk
Feature: C2238 Product Details  Broken Links validation

Scenario: C2238 Verify Product Detail Broken Links
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	Then I Verify the Broken Links
	And I Close the browser