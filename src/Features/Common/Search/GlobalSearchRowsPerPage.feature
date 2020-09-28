@globalsearch @uk @cy @dk @sw @au @fn @nr @nl @ml @lu @gr @is @nonproduk @nonprodau  @aa  @sg @C2371
Feature: C2371: Validation of search result based rows per page

Scenario: C2371: To test Search results paging
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	Then I Verify Global Search Icon is available in home page 
	#And I click on global search icon
	And I wait for the complete page load
  When I type "factsheet" in the Search input box
 	And I press the Enter key on the Search component
 	And I wait for the complete page load
 	And I Scroll down the page
  And I wait for the complete page load
  Then I verify that I can click on the Next button
  And I wait for the complete page load
  Then I verify that I can click on the Previous button
  And I wait for the complete page load
	And I set the Search Rows per page dropdown to "10"
	Then I verify that I can click on the Next button
	And I wait for the complete page load
  Then I verify that I can click on the Previous button
  And I wait for the complete page load
 	And I set the Search Rows per page dropdown to "50"
	Then I verify that I can click on the Next button
	And I wait for the complete page load
  Then I verify that I can click on the Previous button
  And I wait for the complete page load
  And I set the Search Rows per page dropdown to "100"
	Then I verify that I can click on the Next button
	And I wait for the complete page load
  Then I verify that I can click on the Previous button
  And I wait for the complete page load