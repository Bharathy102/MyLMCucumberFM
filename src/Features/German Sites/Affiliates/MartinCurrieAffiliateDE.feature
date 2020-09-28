@affiliatesde @de @C2569de 
Feature: C2569:  Our Affiliates section Martin Currie validation in Home page

Scenario: C2569: Verify the Martin Currie Affiliate in Home Page
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	#And I Scroll down the page
	#And I wait for the complete page load 
	And I click Martin Currie affiliate in home page
	And I wait for the complete page load 
	Then I verify Martin Currie logo 
	Then I verify the broken links in Martin Currie Affiliate page
	And I wait for the complete page load 	
	Then I validate broken Image in Martin Currie page