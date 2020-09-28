@productlist @au @failedrun @plau
Feature: C2467:Product list overview page validation for Australia

Scenario: C2467: Verify Product List overview for Australia
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	Then I verify the product list page is displayed  
	Then I verify Overview tab is displayed
	Then I verify the Performance tab is displayed  
	#Then I verify the shareclass column is displayed in overview tab
	Then I verify the AssetType column is displayed in overview tab
	Then I verify the LastPriceExitPrice column is displayed in overview tab
	Then I verify the Entry Price column is displayed in overview tab
	Then I verify the Exit Price column is displayed in overview tab
	Then I verify the APIR code ASX Ticker column is displayed in overview tab	