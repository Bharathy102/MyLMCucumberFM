@affiliates @uk @cy @dk @sw @brokenlinks @brokenimages @au @fn @nr @nl @ml @lu @gr @is @aa @sg @nonproduk @nonprodau @C2392
Feature: C2392:  Our Affiliates section QS Investors validation in Home page

Scenario: C2392: Verify the QS Investors Affiliate in Home Page
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load
	And I Scroll down the page
	And I click QS Investors affiliate in home page
	And I wait for the complete page load 	
	Then I verify the QS Investors logo	
	Then I verify the broken links in QS Investors Affiliate page
	And I wait for the complete page load 
	Then I validate broken Image in QS Investors page
	