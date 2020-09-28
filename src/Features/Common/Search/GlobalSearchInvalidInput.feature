@globalsearch @uk @cy @dk @sw @au @fn @nr @nl @ml @lu @gr @is @nonproduk @nonprodau  @aa  @sg  @C2301
Feature: C2301: Validation of global search with invalid input

Scenario: C2301: Global Search with Invalid Input
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	Then I Verify Global Search Icon is available in home page 
	#And I click on global search icon
	When I type "INVALIDINPUTVALIDATION" in the Search input box
	And I press the Enter key on the Search component
  Then I verify the "No Results Found" message is displayed in all tab
  And I click on Product Tab
  Then I verify the "No Results Found" message is displayed in Products tab
  And I click on Resources Tab
  Then I verify the "No Results Found" message is displayed in Resources tab
  And I click on Perspectives Tab
  Then I verify the "No Results Found" message is displayed in Perspectives tab
  And I clear the search Text
  And I Hit enter without entering any text
  And I click on All Tab
  Then I verify the "No Results Found" message is displayed in all tab
  And I click on Product Tab
  Then I verify the "No Results Found" message is displayed in Products tab
  And I click on Resources Tab
  Then I verify the "No Results Found" message is displayed in Resources tab
  And I click on Perspectives Tab
  Then I verify the "No Results Found" message is displayed in Perspectives tab   
    