@affiliates @uk @cy @dk @sw @au @fn @nr @nl @ml @lu @gr @is @aa @sg @nonprodau
Feature: C2292: Our Affiliates section validation in Home page

Scenario: C2292: Verify the Our Affiliates section in Home Page
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	And I Scroll down the page
	And I wait for the complete page load 
	Then I verify all the affiliates are present or not
	And I Close the browser