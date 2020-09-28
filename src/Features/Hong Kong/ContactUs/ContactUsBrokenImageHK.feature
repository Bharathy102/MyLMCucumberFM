@contactus @brokenimageshk @contactushk @nonprodhk @hk
Feature: C2304: ContactUs brokenimage validation 

Scenario: C2304: Verify the Broken Images for ContactUs page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	And I Verify Contact Us Menu Header is available in home page
	And I click on Contact Us Header in home page
	And I wait for the complete page load 
	Then I verify the broken Images for ContactUs
	And I Close the browser