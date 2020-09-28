@marketinsightswz @swz @nonprodswz
Feature: C2260 Market Insights filters validation
@mifilterswz
Scenario: C2260 Verify Market Insights filters
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
  Then I verify Filter is available or not in the Market Insight page
	And I click on the filter button
	Then I verify that filter is expanded
	And I verify that Affiliate filter section is available or not for de site
	And I verify that Featured filter section is available or not for de site
	And I verify that Content Type filter section is available or not for de site
	And I Verify the Combination of Different Filters Selection
	Then I Verify the selected Filter Options added to the Top of Expandable Area
	Then I verify that filter Buble is Displayed
	And I Verify the DeSelection of Filters
	And I Verify the Clear All Filters Selection
	And I wait for the complete page load
	And I verify that the filter Close button click
	Then I Click List Tab to Verify Filter in List View Selection
	And I Verify Filter in List View Selection
	And I click on the filter button
	Then I verify that filter is expanded
	And I verify that Affiliate filter section is available or not for de site
	And I verify that Featured filter section is available or not for de site
	And I verify that Content Type filter section is available or not for de site
	And I Verify the Combination of Different Filters Selection
	Then I Verify the selected Filter Options added to the Top of Expandable Area
	Then I verify that filter Buble is Displayed
	And I Verify the DeSelection of Filters
	And I Verify the Clear All Filters Selection
	And I verify that the filter Close button click