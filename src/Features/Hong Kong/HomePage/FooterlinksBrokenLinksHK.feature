@brokenlinkshk @homepagehk @nonprodhk @hk
Feature: Footer link validation
	
Scenario: Verify the footer link in Home Page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load   
	And I Scroll down the page
	And I wait for the complete page load 
	Then I verify country footer is present or not 
	And I Close the browser