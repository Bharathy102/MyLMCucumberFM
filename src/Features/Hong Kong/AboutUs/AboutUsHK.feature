@aboutushk @nonprodhk @hk
Feature: C1962: About Us validation 

Scenario: C1962: Verify the About Us page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on About us in home page
	And I wait for the complete page load 
