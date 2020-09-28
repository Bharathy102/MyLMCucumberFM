@affiliatesde @de @C2559de
Feature: C2559: Our Affiliates section EnTrust Permal validation in Home page 

Scenario: C2559 Verify the EnTrust Permal Affiliate Home Page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump 
	#And I Scroll down the page
	And I wait for the complete page load 
	And I click EnTrust Permal affiliate in home page
	And I wait for the complete page load 
	Then I verify the EnTrust Permal logo
	Then I verify the broken links in EnTrust Permal Affiliate page
	And I wait for the complete page load 
	Then I validate broken Image in EnTrust Permal page