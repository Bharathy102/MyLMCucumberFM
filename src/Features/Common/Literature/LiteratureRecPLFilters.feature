@literature @sg @C3509
Feature: Literature Page - Recognised Funds Filters validation 
@C3509
Scenario: Verify the Literature page -  Recognised Funds Filters validation 
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
  
		Then I verify the filter icon is displayed
	  And I click on filter icon to expand the filters
	  Then I verify the filters are expanded
  	Then I verify the Share Class filters are displayed
  	Then I verify the Distribution Type filters are displayed 
  	Then I verify the Asset Class filters are dsiplayed
	  Then I verify the Currency filters are displayed
	  Then I verify the Investment Manager filters are displayed
	  Then I verify the Domicile filters are displayed
	  Then I verify the watchlist filters are displayed
	  
	  And I select first Share Class filter checkbox
	  Then I verify the funnel count is changed to 1
	  Then I verify the chip is displayed for the selected filter
	  And I select the first Assert Class filter checkbox
	  Then I verify the funnel count is changed to 2
	  Then I verify the chip is displayed for the selected filter
	  Then I verify the filtered results on "tab-overview" tab based on the "share-classes-fields" and "A" selected filters on "2" position
	  Then I verify the filtered results on "tab-overview" tab based on the "asset-class-fields" and "Equity" selected filters on "4" position
	  #Clear off the filter
	  And I select first Share Class filter checkbox
	  Then I verify the funnel count is changed to 1
	  #Clear off the filter
	  And I select the first Assert Class filter checkbox
	  And I select the first Distribution Type filter checkbox
	  Then I verify the filtered results on "tab-overview" tab based on the "checkbox-group distribution-type" and "Accumulating" selected filters on "5" position
	  And I select the first Distribution Type filter checkbox
	  And I select the first Currency filter checkbox
	  Then I verify the filtered results on "tab-overview" tab based on the "currency-fields" and "SGD" selected filters on "3" position
	  And I select the first Currency filter checkbox
	  And I select the first Investment Manager filter checkbox
	  And I select the first Investment Manager filter checkbox
	  And I select the first Domicile filter checkbox
	  Then I verify the filtered results on "tab-overview" tab based on the "checkbox-group domiciles" and "Singapore" selected filters on "8" position
	  And I Scroll down the page
	  And  I click on ClearAll filter button
	  Then I verify that all filter checkboxes are clear, all filter chips are removed and the number bubble disappears
	  And I select the watchlist filter
	  And I click on the filter close button
	  Then I verify the funnel count is changed to 1
	  Then I verify the chip is displayed for the selected filter
	  Then I verify the filters are not expanded
  
