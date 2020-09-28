@affiliatesde @de @C2391de
Feature: C2391: Our Affiliates Brandywine validation in Home page 

Scenario: C2391:Verify the Brandywine Affiliate in Home Page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	#And I Scroll down the page until "Our Affiliates" is visible
	And I wait for the complete page load  
	And I click on Brandywine affiliate in home page
	And I wait for the complete page load  
	Then I verify the Brandywine logo
	Then I verify the broken links in Brandywine Affiliate page
	And I wait for the complete page load  
	Then I validate broken Image in Brandywine affiliate page 