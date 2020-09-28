@globalsearchde @KIIDSearchde @de
Feature: Validate KIID search link

Scenario: Validate KIID search link
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I Enter "usag" in the global search
	And I press the Enter key on the Search component
	And I wait for the complete page load
	Then I verify search result is displayed
	And I select the Resource Tab
	Then I verify "KIID" link is returning to search result page
	And I wait for the complete page load	
	And I click on "Dokumententyp" filter
	Then I verify "KIID" checkbox is prefiltered
	
