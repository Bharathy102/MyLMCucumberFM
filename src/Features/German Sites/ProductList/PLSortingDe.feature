@productlistde @de @C1898de
Feature: C1898:ProductList sorting functionality validation

Scenario: Verify ProductList Sorting functionality
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I wait for the complete page load
	Then I verify the Fund Name column is displayed as sorted by default
	And I sort by ShareClass column
	Then I verify the Share class column is displayed as sorted
	And I sort by Nav column
	Then I verify the Nav column is displayed as sorted 
	And I sort by AssetType column
	Then I verify the AssetType column is displayed as sorted
	And I sort by Distribution Type column
	Then I verify the Distribution Type column is displayed as sorted
	And I sort by Ccy column
	Then I verify the Ccy column is displayed as sorted
	And I sort by AsOf column
	Then I verify the AsOf column is displayed as sorted
	And I sort by Domicile column
	Then I verify the Domicile column is displayed as sorted 
	And I sort by ISIN column
	Then I verify the ISIN column is displayed as sorted     