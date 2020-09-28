@brokenimagesfr @marketinsightfr @fr @nonprodfr
Feature: C2268 Market Insights Broken Images validation
@mibrokenimagesfr
Scenario: C2268 Verify Market Insights Broken Images
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
  Then I Verify the Broken Images