@productlistde @de @C1904de @watchlistde @C1904
Feature: C1904:ProductList watchlist validation

Scenario: Verify ProductList watchlist functionality
  	Given I launch the publisher site 
	  And I wait for the complete page load 
	  And I select Opt In for Cookie Policy in the SpeedBump 
	  And I select User Role in the SpeedBump 
	  And I select Accept for Terms and Conditions in the SpeedBump
	  And I click on the products header for German Site
	  And I refresh the page
	  And I wait for the complete page load
	  Then I verify the product list page is displayed
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