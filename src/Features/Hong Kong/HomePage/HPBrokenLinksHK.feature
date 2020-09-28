@brokenlinkshk @homepagehk @nonprodhk @hk
Feature: C2293 HomePage Broken Links validation for Hong Kong sites

Scenario: C2293 Verify HomePage Broken Links for Hong Kong sites
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	Then I Verify the Broken Links
	And I Close the browser