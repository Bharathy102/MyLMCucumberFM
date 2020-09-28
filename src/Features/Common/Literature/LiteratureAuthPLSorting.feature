@literature @sg @C3505
Feature: Literature Page - Authorised Funds Sorting validation 
@C3506
Scenario: Verify the Literature page -  Authorised Funds Sorting validation 
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

	  And I click on the products header
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
	  And I sort by Domicile column
	  Then I verify the Domicile column is displayed as sorted 
	  And I sort by ISIN column
	  Then I verify the ISIN column is displayed as sorted  
