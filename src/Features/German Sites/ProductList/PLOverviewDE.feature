@productlistde @de @plperfAnnualisedde
Feature: C1896:Product list overview page validation

Scenario: Verify Product List overview
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I wait for the complete page load
	Then I verify the product list page is displayed  
	Then I verify Overview tab is displayed
	Then I verify the Performance tab is displayed  
	Then I verify the FundName column is displayed in overview tab
	Then I verify the shareclass column is displayed in overview tab
	Then I verify the Distribution column is displayed in overview tab
	Then I verify the NAV column is displayed in overview tab
	Then I verify the AssetType column is displayed in overview tab
	Then I verify the Ccy column is displayed in overview tab
	Then I verify the As Of column is displayed in overview tab
	Then I verify the Domicile column is displayed in overview tab
	Then I verify the ISIN column is displayed in overview tab
	Then I verify the Key Actions is displayed in overview tab
	Then I verify the WatchList column is displayed for overview tab