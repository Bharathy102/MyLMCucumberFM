@globalsearch @uk @dk @sw @au @fn @nr @nl @lu @nonproduk @nonprodau  @aa  @sg @C2440
Feature: C2440: Validation of ISIN / SEDOL
	
Scenario: C2440: Validation of ISIN / SEDOL Search Results 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	Then I Verify Global Search Icon is available in home page 
	#And I click on global search icon
	And I wait for the complete page load
  And I type ISIN Value in the Search input box
  And I press the Enter key on the Search component
  And I wait for the complete page load
	Then I verify search result is displayed
  And I click on Product Tab
  And I select products from the search results
  Then I verify the ISIN value is displayed in Product detail page
  And I wait for the complete page load
 	Then I Verify Global Search Icon is available in home page 
	#And I click on global search icon
	And I wait for the complete page load
  And I type SEDOL Value in the Search input box
  And I press the Enter key on the Search component
  And I wait for the complete page load
	Then I verify search result is displayed
  And I click on Product Tab
  And I select products from the search results
  Then I verify the SEDOL value is displayed in Product detail page
  And I wait for the complete page load
  	