@au @productlistau @C4447 @sprint78
Feature: ProductList Pagination validation on Overview tab

Scenario: Verify ProductList Pagination on Overview Tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	Then I verify the product list page is displayed
	Then I verify that default rows per page is displayed with 2 index
	Then I verify the dropdown contains 10 25 50 100 and "All" in Overview section
	Then I verify that I can not click on the Next button on "Overview" tab
  Then I verify that I can not click on the Previous button on "Overview" tab
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