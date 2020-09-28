@marketinsights @uk @nonproduk @aa @sg
Feature: C2266 Market Insights Chart Of the Week validation

Scenario: C2266 Verify MarketInsights Chart OfThe Week Section
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
  When I Verify Chart of the week Link in Market Insights Page
	And I verify the title of Chart of the week page
	And I Verify total Grid results
	And I click on Grid View link 
	And I Verify Grid Tile Image is available or not
	And I Verify Grid Tile EyeBrow is available or not
	And I Verify Grid Tile Title is available or not
	And I Verify Grid Tile Description is available or not
	And I Verify the Grid Page link in Chart of the week
	And I verify the title of page clicked and Lunched