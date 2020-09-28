@literature @sg @3514
Feature: Literature Page - Authorised Funds Pagination validation 

Scenario: Verify the Literature page -  Authorised Funds Pagination validation 
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

    Then I verify the pagination info on top of product list component on "overview-table" tab
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
  
