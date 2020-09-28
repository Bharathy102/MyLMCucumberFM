@affiliatesde @de @regresisonde @plperfregression
Feature: ProductList Performance Regression - KeyActions, SocialShare, Filters, Pagination, Watchlist, Sections

Scenario: ProductList Performance Regression - KeyActions, SocialShare, Filters, Pagination, Watchlist, Sections
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I wait for the complete page load
	Then 	I verify the product list page is displayed 
	
	And I click on the Perfomance Tab
	And I wait for the complete page load 
	And I click on Key Actions options 
	Then I verify the DownLoad Excel is displayed in KeyActions menu
	Then I verify the print option is displayed in KeyActions menu
	Then I verify the Facebook option is displayed in KeyActions menu
	Then I verify the Twitter option is displayed in KeyActions menu
	Then I verify the LinkedIn option is displayed in KeyActions menu 
	
	And I click on Discrete Rolling Tab on Performance section
	Then I verify the columns on Discrete Rolling tab on Performance section
	Then I verify the tooltip for Performance Discrete columns
	
	Then I verify the Inception date is displayed as per country local on "discrete-table" table
	Then I verify the As Of Date is displayed as per country local on "discrete-table" table for German Site
	Then I verify the data for the first fund on "discrete-table" of product list page 
	And I click on the fund name of the first fund on "discrete-table" of product list page
	Then I verify the product detail page is displayed
	And I wait for the complete page load
	Then I verify the Share Class on the detail page
	
	And I click on browser back button
	And I wait for the complete page load
	
	And I click on Calender Tab on Performance section
	Then I verify the tooltip for Performance Calender columns
	Then I verify the columns on Calendar tab on Performance section
	
	Then I verify the Inception date is displayed as per country local on "calendar-table" table
	Then I verify the As Of Date is displayed as per country local on "calendar-table" table for German Site
	Then I verify the data for the first fund on "calendar-table" of product list page 
	And I click on the fund name of the first fund on "calendar-table" of product list page
	Then I verify the product detail page is displayed
	And I wait for the complete page load
	Then I verify the Share Class on the detail page
	
	And I click on browser back button
	And I wait for the complete page load
	
	And I click on Annualised Tab on Performance section	
	Then I verify the tooltip for Performance Annualised columns
	Then I verify the columns on Annualised tab on Performance section for German Site
	
	Then I verify the Inception date is displayed as per country local on "annualized-table" table
	Then I verify the As Of Date is displayed as per country local on "annualized-table" table for German Site
	Then I verify the data for the first fund on "annualized-table" of product list page 
	And I click on the fund name of the first fund on "annualized-table" of product list page
	And I wait for the complete page load 
	Then I verify the product detail page is displayed
	And I wait for the complete page load 
	Then I verify the Share Class on the detail page
	
	And I click on browser back button
	And I wait for the complete page load
	
	And I click on Cucumlative Tab in Performance section	
	Then I verify the tooltip for Performance Cucumlative columns	
	Then I verify the columns on Cumulative tab on Performance section for German Site
	
	Then I verify the Inception date is displayed as per country local on "cumulative-table" table
	Then I verify the As Of Date is displayed as per country local on "cumulative-table" table for German Site
	Then I verify the data for the first fund on "cumulative-table" of product list page 
	And I click on the fund name of the first fund on "cumulative-table" of product list page
	Then I verify the product detail page is displayed
	And I wait for the complete page load
	Then I verify the Share Class on the detail page
	
	And I click on browser back button
	And I wait for the complete page load
	
	And I click on the Perfomance Tab
	And I click on Discrete Rolling Tab on Performance section
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
	