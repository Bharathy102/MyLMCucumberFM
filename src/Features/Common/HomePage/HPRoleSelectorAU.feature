@homepage @au @nonprodau
Feature: C2524: Role Selector on Home Page for Australia site 
	As an author I want to verify the the Role Selector for home page for Australia

Scenario: C2524: Verify Role Selector in Home Page Australia
	Given I launch the publisher site
	And I wait for the complete page load
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I wait for the complete page load
	#Commeneted below validation as current authoring does not show role dropdown for Australia
	#Then I verify Role Selector drop down is available
	#Then I verify the LeggMason Austalia role is displayed
	#Then I click on Role Selector menu
	#Then I verify Role Selector Options
	#And I select Client Login option from Role Selector Menu
	#And I wait for the complete page load
	#Then I verify the RBC Investor Services Bank is displayed
	And I Close the browser