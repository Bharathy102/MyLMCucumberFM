@affiliates @uk @cy @dk @sw @brokenlinks @brokenimages @au @fn @nr @nl @ml @lu @gr @is @aa @sg @nonproduk @nonprodau
Feature: C2557: Our Affiliates section Clarion Partners validation in Home page

Scenario: C2557: Verify the ClarionPartners Affiliate in Home Page
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I wait for the complete page load  
	#And I Scroll down the page until "Our Affiliates" is visible
	And I wait for the complete page load  
	And I click on Clarion Partners affiliate in home page
	And I wait for the complete page load 
	Then I verify the Clarion Partners logo 
	Then I verify the broken links in Clarion Partners Affiliate page
	And I wait for the complete page load 	
	Then I verify broken Image in Clarion Partners page