@brokenlinks @homepage @uk @cy @dk @sw @au @au @fn @nr @nl @ml @lu @gr @is @aa @sg @nonproduk @nonprodau
Feature: C2293 HomePage Broken Links validation

Scenario: C2293 Verify HomePage Broken Links
	Given I launch the publisher site
	And I wait for the complete page load
	When I verify the Title of Lunched Site
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load
	And I Verify Franklin Templeton Logo in the home page
	Then I Verify the Broken Links
	And I Close the browser