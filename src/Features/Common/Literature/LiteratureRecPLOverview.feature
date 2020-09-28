@literature @sg @3508
Feature: Literature Page - Recognised Funds Overview validation 

@C3508
Scenario: Verify the Literature page -  Recognised Funds Overview validation 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump 
	Then I Verify Literature Menu Header is available in home page
	And I click Literature header
  And I wait for the complete page load
	And  I click on "Recognised" section link
	And I wait for the complete page load
	And I click on "recognised" to link button
	And I wait for the complete page load
  Then I verify "authorised" link is displayed on the page
  Then I verify the product list page is displayed
  Then I verify Overview tab is displayed
  Then I verify the pagination info on top of product list component on "overview-table" tab  
  And I click on filter icon to expand the filters
  Then I verify the shareclass column is displayed in overview tab

	Then I verify the NAV column is displayed in overview tab
	Then I verify the AssetType column is displayed in overview tab
	Then I verify the Distribution Type column is displayed in overview tab
		
	Then I verify the Domicile column is displayed in overview tab
	Then I verify the ISIN column is displayed in overview tab
	Then I verify the Key Actions is displayed in overview tab
	Then I verify the WatchList column is displayed for overview tab
  
