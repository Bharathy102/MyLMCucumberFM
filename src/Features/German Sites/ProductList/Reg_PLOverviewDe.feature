@affiliatesde @de @regresisonde @ploverregressionde
Feature: ProductList Overview Regression - KeyActions, SocialShare, Filters, Pagination, Watchlist, Overview Columns

Scenario: ProductList Overview Regression - KeyActions, SocialShare, Filters, Pagination, Watchlist, Overview Columns
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I wait for the complete page load
	Then I verify Overview tab is displayed
	Then I verify the tooltip for Overview columns
	
	#Verify KeyActions on overview tab
	And I click on Key Actions options 
	Then I verify the print option is displayed in KeyActions menu
	Then I verify the DownLoad Excel is displayed in KeyActions menu
	Then I verify the print option is displayed in KeyActions menu
	Then I verify the Facebook option is displayed in KeyActions menu
	Then I verify the Twitter option is displayed in KeyActions menu
	Then I verify the LinkedIn option is displayed in KeyActions menu
	Then I verify the Email Share option is displayed in KeyActions menu
	And I click on Email share link from KeyActions menu
	Then I verify the email model window is displayed
	Then I verify the email fields on email window
	
	#Verify Column Sorting on Overview tab
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
	
	#Verify watchlist functionality on overview tab
	Then I verify that the Watchlist header Icon is displayed
	Then I verify that a message indicate that there is no product currently in watchlist
  And I click on the Add to Watchlist button on "overview-table" tab for German site
  Then I verify that Watchlist has the 1 number of Fund added
  And I click on the Add to Watchlist button on "overview-table" tab for German site
  And I wait for the complete page load
  Then I verify the watchlist has View Detail and Clear List buttons for German site   
  Then I verify that Watchlist has the 2 number of Fund added
  Then I verify that the Watchlist has the correct shareclass added
  And I expand the filter icon
  And I Scroll down the page
  And I select the watchlist filter
  Then I verify the only watchlist products are displayed
  And I scroll to top of page
  And I click on fund link from Watchlist view
  And I wait for the complete page load
  Then I verify the fund detail page is displayed
  And I click on Clear List option for German site
  Then I verify that a message indicate that there is no product currently in watchlist
  And I wait for the complete page load
  And I click on browser back button
  And I click on browser back button
	And I wait for the complete page load
  
  #Verify Pagination on overiew tab
  And I click on the Overview Tab
  Then I verify the pagination info on top of product list component on "tab-overview" tab for German Site
	Then I verify that default rows per page is displayed with 2 index
	Then I verify the dropdown contains 10 25 50 and 100 in Overview section 
	Then I verify that I can click on the Next button
  Then I verify that I can click on the Previous button
	And I set the Rows per page dropdown to "10"
	And I scroll to top of page
  Then I verify that I can click on the Next button
  Then I verify that I can click on the Previous button
  And I set the Rows per page dropdown to "50"
  Then I verify that I can click on the Next button
  Then I verify that I can click on the Previous button
  And I set the Rows per page dropdown to "100"
  Then I verify that I can click on the Next button
  Then I verify that I can click on the Previous button  
  
  