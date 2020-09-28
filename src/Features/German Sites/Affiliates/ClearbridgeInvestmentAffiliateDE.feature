@affiliatesde @de @C2558
Feature: C2558: Our Affiliates section Clearbridge Investment validation in Home page

Scenario: C2558: Verify the ClearBridge Investment Affiliate in Home Page
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I wait for the complete page load  
	#And I Scroll down the page until "Our Affiliates" is visible 
	And I click on ClearBridge Investment affiliate in home page
	And I wait for the complete page load 	
	Then I verify the ClearBridge Investment logo
	Then I verify the broken links in ClearBridge Investment Affiliate page
	And I wait for the complete page load 
	Then I validate broken Image in ClearBridge Investment page