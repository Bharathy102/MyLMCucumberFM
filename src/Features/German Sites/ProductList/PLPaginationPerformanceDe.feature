@productlistde @de @perfpaginationde
Feature: C1947:ProductList Pagination validation on Performance tab

Scenario: Verify ProductList Pagination on Performance tab
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I wait for the complete page load
	Then I verify the product list page is displayed
	Then I verify the Performance tab is displayed
	And I click on the Perfomance Tab
	Then I wait for the complete page load  
	Then I verify the pagination info on top of product list component on "tab-discrete" tab for German Site
	Then I verify that default rows per page is displayed with 4 index
	Then I verify the dropdown contains 10 25 50 and 100 in Performance section
	Then I verify that I can click on the Next button on Performance section
  Then I verify that I can click on the Previous button on Performance section
	And I set the Rows per page dropdown to "10"
	And I scroll to top of page
	Then I verify that I can click on the Next button on Performance section
  Then I verify that I can click on the Previous button on Performance section
  And I set the Rows per page dropdown to "50"
	Then I verify that I can click on the Next button on Performance section
  Then I verify that I can click on the Previous button on Performance section
  And I set the Rows per page dropdown to "100"
	Then I verify that I can click on the Next button on Performance section
  Then I verify that I can click on the Previous button on Performance section