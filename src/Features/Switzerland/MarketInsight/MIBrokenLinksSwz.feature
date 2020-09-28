@mibrokenlinkswz @marketinsightswz @swz @nonprodswz
Feature: C2267 Market Insights Broken Links Validation

Scenario: C2267: Verify Market Insights Broken Links
	Given I launch the publisher site
	And I wait for the complete page load
	When I verify the Title of Lunched Site
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load
	And I Verify Market Insights Menu Header is available in home page
	And I wait for the complete page load
  Then I Click Market Insights header
  And I wait for the complete page load
  Then I Verify the Broken Links