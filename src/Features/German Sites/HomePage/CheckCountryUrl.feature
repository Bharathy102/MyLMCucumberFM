@countryurlde @de @nonprodde
Feature: C2131: Verify country url 

Scenario: C2131: Verifycountry url in correct format 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	Then I verify county url in correct format
	Then I click on About us in home page
	And I wait for the complete page load 
	Then I verify county url in correct format
	Then I click on Contact Us Header in home page
	And I wait for the complete page load 
	Then I verify county url in correct format
	Then I click Literature header
	And I wait for the complete page load 
	Then I verify county url in correct format