@literature @sg @C3502
Feature: Literature Page - Recognised Fund Section validation 
@C3502
Scenario: Verify the Literature page - Recognised Fund Section validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump 
	Then I Verify Literature Menu Header is available in home page
	And I click Literature header
	And I wait for the complete page load
	Then I verify "Authorised" Section is displayed on the page
	Then I verify "Recognised" Section is displayed on the page
	And  I click on "Recognised" section link
	Then I verify "recognised" link is displayed on the page
	#And  I click on "Authorised" section link
  Then I verify all literature subsections and verify broken links
  And I click on "recognised" to link button
  And I wait for the complete page load
  Then I verify "authorised" link is displayed on the page