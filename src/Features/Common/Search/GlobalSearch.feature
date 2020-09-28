@globalsearch @uk @cy @dk @sw @au @fn @nr @nl @ml @lu @gr @is @nonproduk @nonprodau @C2236
Feature: C2236: Global Search validation
	
Scenario: C2236: Validation of Global Search in Home page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	Then I Verify Global Search Icon is available in home page 
	#And I click on global search icon
	And I Enter "entrust" in the global search
	Then I verify search result is displaying or not
	#Then I verify Advanced Tab is present or not
	#And I select Entrustpermal from the search result
	Then I verify the search result page for entrust permal
	And I click on Product Tab
	And I wait for the complete page load
	And I select the Resource Tab
	And I select the Perspectives Tab
	
	