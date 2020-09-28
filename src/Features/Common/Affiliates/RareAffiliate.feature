@affiliates @uk @cy @dk @sw @brokenlinks @brokenimages @au @fn @nr @nl @ml @lu @gr @is @aa @sg @nonproduk @nonprodau
Feature: C2560: Our Affiliates section RARE validation in Home page


Scenario: C2560: Verify the RARE Affiliate in Home Page
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	#And I Scroll down the page
	And I click RARE affiliate in home page
	And I wait for the complete page load 
	Then I verify RARE logo 	
	Then I verify the broken links in RARE Affiliate page
	And I wait for the complete page load 	
	Then I validate broken Image in RARE page