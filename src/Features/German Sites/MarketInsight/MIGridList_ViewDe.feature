@marketinsightsde @de @nonprodde
Feature: C2259 Market Insights Grid/List View validation

Scenario: C2259 Verify Grid/List View in MarketInsights
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
  And I Verify Sort By DropDown Section is available or not in Market Insight page
	And I Verify Default Grid Selection is available or not in Market Insight page
	And I Verify Grid Tab Section is available or not in Market Insight page
	And I Verify List Tab Section is available or not in Market Insight page
	When I Click List Tab Section in Market Insight page
	And I wait for the complete page load
	And I Verify total List Tab results
	And I wait for the complete page load
	And I Verify List view layout header-Page for de site
	And I Verify List view layout header-Eyebrow for de site
	And I Verify List view layout header-Description for de site
	And I Verify List view layout header-Date for de site
	And I Verify List Tile Page Link and Lunched Page URL
	And I wait for the complete page load
	Then I Click Market Insights header
	And I wait for the complete page load
	When I Click Grid Tab Section in Market Insight page
	And I wait for the complete page load
	And I Verify total Grid results
	And I wait for the complete page load
	And I Verify Grid Tile Image is available or not
	And I Verify Grid Tile EyeBrow is available or not
	And I Verify Grid Tile Title is available or not
	And I Verify Grid Tile Description is available or not
	When I Verify Grid Tile Link and Lunched URL