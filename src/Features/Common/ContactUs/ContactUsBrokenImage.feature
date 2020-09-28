@contactus @brokenimages @uk @cy @dk @sw @au @fn @nr @nl @ml @lu @gr @is @aa @nonproduk @sg @nonprodau
Feature: C2304: ContactUs brokenimage validation 

Scenario: C2304: Verify the Broken Images for ContactUs page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	And I click on Contact Us Header in home page
	And I wait for the complete page load 
	Then I verify the broken Images for ContactUs
	And I Close the browser