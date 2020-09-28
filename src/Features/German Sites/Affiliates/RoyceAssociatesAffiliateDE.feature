@affiliatesde @de @C2561
Feature: C2561: Our Affiliates section Royce Associates validation in Home page


Scenario: C2561: Verify the Royce Associates Affiliate in Home Page
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	And I Scroll down the page
	And I wait for the complete page load 
	And I click Royce Associates affiliate in home page
	And I wait for the complete page load 	
	Then I verify Royce Associates logo 	
	Then I verify the broken links in Royce Associates Affiliate page
	And I wait for the complete page load 
	Then I validate broken Image in Royce Associates page