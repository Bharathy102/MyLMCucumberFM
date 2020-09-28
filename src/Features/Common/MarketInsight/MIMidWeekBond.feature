@marketinsights @uk @nonproduk @aa @sg
Feature: C2275 Market Insights Mid-Week Bond Update validation

Scenario: C2275 Verify MarketInsights Mid Week Bond Update Section
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
  When I Verify Mid-Week Bond Update Link in Market Insights Page
	And I verify the title of Mid-Week Bond Update page
	And I Verify total Grid results
	And I Verify Grid Tile Image is available or not
	And I Verify Grid Tile EyeBrow is available or not
	And I Verify Grid Tile Title is available or not
	And I Verify Grid Tile Description is available or not
	And I Verify the Grid Page link in Mid-Week Bond Update page
	And I verify the title of page clicked and Lunched