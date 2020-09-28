@literature @sg @C3506
Feature: Literature Page - Authorised Funds Watchlist validation 
@C3506
Scenario: Verify the Literature page -  Authorised Funds Watchlist validation 
	  Given I launch the publisher site 
	  And I wait for the complete page load 
	  And I select Opt In for Cookie Policy in the SpeedBump 
	  And I select User Role in the SpeedBump 
	  And I select Accept for Terms and Conditions in the SpeedBump 
	  Then I Verify Literature Menu Header is available in home page
	  And I click Literature header
    And I wait for the complete page load
	  And  I click on "Authorised" section link
	  And I wait for the complete page load
	  And I click on "authorised" to link button
	  And I wait for the complete page load
    Then I verify "recognised" link is displayed on the page
    Then I verify the product list page is displayed
    Then I verify Overview tab is displayed

    Then I verify that the Watchlist header Icon is displayed
	  And I wait for the complete page load
   	Then I verify that a message indicate that there is no product currently in watchlist
   	And I wait for the complete page load
    And I click on the Add to Watchlist button on "overview-table" tab
    And I wait for the complete page load
    Then I verify that Watchlist has the 1 number of Fund added
    And I click on the Add to Watchlist button on "overview-table" tab
    And I wait for the complete page load
    Then I verify the watchlist has View Detail and Clear List buttons    
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
    And I click on Clear List option
  
