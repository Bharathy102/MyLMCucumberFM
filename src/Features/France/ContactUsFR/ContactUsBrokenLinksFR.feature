@contactusfr @brokenlinksfr @fr @nonprodfr
Feature: C2303: Contact Us brokenlinks validation  

Scenario: C2303: Verify the brokenlinks in Contact Us
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on Contact Us Header in home page
	And I wait for the complete page load 
	Then I verify the broken links for ContactUs page
	And I Close the browser