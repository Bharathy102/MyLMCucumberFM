@aboutusde @brokenimagesde @de @nonprodde
Feature: C2306: About Us brokenimage validation 

Scenario: C2306: Verify the Broken Images for AboutUs page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	And I click on About us in home page
	And I wait for the complete page load 
	And I click on Leadership
	And I wait for the complete page load 
	Then I verify the broken Images for Leadership page
	And I wait for the complete page load  
	And I click on About us in home page 
	And I wait for the complete page load 
	And I click on Our Affiliates
	And I wait for the complete page load 
	Then I verify the broken Images for Affiliates
	And I click on About us in home page 
	And I click Annual Report
	And I wait for the complete page load 
	Then I verify the broken Images for Annual Reports