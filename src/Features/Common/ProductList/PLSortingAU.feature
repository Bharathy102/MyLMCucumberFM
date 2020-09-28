@productlist @au @tst2 @plau
Feature: C1898:ProductList sorting functionality validation for Australia

Scenario: Verify ProductList Sorting functionality for Australia
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	Then I verify the Fund Name column is displayed as sorted by default
	And I sort by ShareClass column
	Then I verify the Share class column is displayed as sorted
	#And I sort by "NAV" column
	#Then I verify the "NAV" column is displayed as sorted
	And I sort by "Entry Price" column
	Then I verify the "Entry Price" column is displayed as sorted
	And I sort by "Exit Price" column
	Then I verify the "Exit Price" column is displayed as sorted
	And I sort by "Asset Type" column
	Then I verify the "Asset Type" column is displayed as sorted
	And I sort by "apirValue" column
	Then I verify the "apirValue" column is displayed as sorted      