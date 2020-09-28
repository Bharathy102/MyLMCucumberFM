@brokenimageshk @homepagehk @nonprodhk @hk
Feature: C2563 HomePage Broken Image validation for Hong Kong sites

Scenario: C2563 Verify HomePage Broken Images for Hong Kong sites
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	Then I Verify the Broken Images
	And I Close the browser