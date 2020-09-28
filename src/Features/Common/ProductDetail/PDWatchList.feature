@productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau  @aa @sg
Feature: C2244:Product detail Watchlist functionality validation

@pdWatchList
Scenario: C2244:Product detail Watchlist validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	#Then I click on the productlist page fund name navigation check for overview tab
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load 
	Then I verify that the Watchlist header Icon is displayed
	And I click on Add to Watchlist for the shareclass
	Then I verify that Watchlist has the 1 number of Fund added
	Then I verify the fund name and shareclass detail on watchlist
	Then I verify the watchlist has View Detail and Clear List buttons
	And I change the shareclass
	And I click on Add to Watchlist for the shareclass
	Then I verify that Watchlist has the 2 number of Fund added
	And I click on Add to Watchlist for the shareclass
	And I click on Clear List option
	Then I verify that a message indicate that there is no product currently in watchlist
	And I click on Add to Watchlist for the shareclass	
	And I click on View Detail button from Watchlist header
	And I wait for the complete page load
	Then I verify the product list page is displayed
	Then I verify watchlist only filter is selected
	And I click on Clear List option	
	