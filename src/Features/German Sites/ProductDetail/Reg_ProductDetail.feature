@brokenimagesDe  @regressionDe
Feature: Product Details  Broken Image validation

@pdRegression1De
Scenario: Verify Product Detail Regression 1
	Given I launch the publisher site
	And I wait for the complete page load
	When I verify the Title of Lunched Site
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I wait for the complete page load
	And I verify the product list page is displayed
	Then I click on the productlist page fund name navigation check for Overview tab
	And I wait for the complete page load
	
	#ProductList to Product detail validation
	Then I verify the product detail page is Navigated
	Then I verify the Disclosure Section is displayed
	
		
	
	#Performance tab
	And I click on Performance Tab on product detail page
	Then I verify the Performance Tab is displayed on product detail page
	
	#Discrete Rolling tab
	And I click on Rolling tab under Performance section for German site
	Then I verify the Rolling Month table is displayed with header for German site
	Then I verify the AsOf date is displayed on "annual-discrete annual-discrete" table
	Then I verify the Header dates on Rolling 12 Month table
	Then I verify the shareclass Data is displayed on Discrete table
	Then I verify the Benchmark Data is displayed on Rolling table
	Then I verify the Benchmark header is displayed as Benchmark on "annual-discrete annual-discrete" table for German site
	
	#Annualised Tab
	And I click on Annualised tab under Performance section for German site
	Then I verify the Annualised Performance table is displayed with header for German site
	Then I verify the AsOf date is Annualised displayed on table
	Then I verify the Header dates on Annualised Performance table for German site
	Then I verify the shareclass Data is displayed on Annualised table
	Then I verify the Benchmark Data is displayed on Annualised Table
	Then I verify the Benchmark header is displayed as Benchmark on "annualised-performance annualised-performance" table for German site
	
	#Calendar Tab
	And I click on Calendar tab under Performance section for German site
	Then I verify the Calendar Performance table is displayed with header for German site
	Then I verify the AsOf date is displayed on "calendar-performance calendar-performance-kjuip" table
	Then I verify the Header dates on Calendar Performance table
	Then I verify the shareclass Data is displayed on Calendar Table
	Then I verify the Benchmark Data is displayed on Calendar Table	
  Then I verify the Benchmark header is displayed as Benchmark on "calendar-performance calendar-performance" table for German site
  
  #Cumulative Tab
  And I click on Cumulative tab under Performance section
	Then I verify the "cumulative-performance cumulative-performance-jewqu" Performance table is displayed with header
	Then I verify the AsOf date is displayed on "cumulative-performance cumulative-performance-jewqu" table
	Then I verify the Header dates on Cumulative Performance table
	Then I verify the shareclass Data is displayed on Cumulative table
	Then I verify the Benchmark Data is displayed on Cumulative Table
	Then I verify the Benchmark header is displayed as Benchmark on "cumulative-performance cumulative-performance" table for German site
	
	#Daily Stats component
	Then I verify the "daily-statistics characteristics daily-statistics-wdddy" Performance table is displayed with header "Tägliche Statistik" for German Site
	Then I verify the AsOf date is displayed on "daily-statistics characteristics daily-statistics-wdddy" table
	Then I verify the Daily Statistics Data is displayed in table
	
	#Charges component
	Then I verify the "charges charges-characteristics charges" Performance table is displayed with header "Kosten" for German Site
	Then I verify the AsOf date is displayed on "charges charges-characteristics charges" table for German Site
	Then I verify the Charge Section Data is displayed in table
	
	#FundCode component
	Then I verify the "fund-codes fund-codes" Performance table is displayed with header "Fondsinformationen" for German Site
	Then I verify the AsOf date is displayed on "fund-codes fund-codes" table for German Site
	Then I verify the Fund Codes Section Data is displayed in table
	
	#FundFact component
	Then I verify the "fund-facts fund-facts-characteristics fund-facts" Performance table is displayed with header "Fondsdaten" for German Site
	Then I verify the Fund Facts Section Data is displayed in table
	
	#3Year risk component
	Then I verify the Three-Year Risk Statistics Performance table is displayed with header for German Site
	Then I verify the AsOf date is displayed on "three-year-risk three-year-risk-wgmdr" table for German Site
	Then I verify the Three-Year Risk Statistics Data is displayed in table
	
	#Yields component
	Then I verify the Yields table is displayed if authored
	Then I verify the Yields header is displayed for German Site
	Then I verify the Yields AsOfDate is displayed for German Site
	Then I verify the AsOf date is displayed on "yields characteristics yields" table for German Site
	
	#Investment Risk tab
	And I click on Investment Risks tab on product detail page
	Then I verify the Investment Risks section is displayed and the tab is active
	Then I verify the Risk Reward Profile component is displayed on product detail page
	
	#Distribuion tab
	And I click on the distribution tab
	Then I verify the Distributions table is displayed with header
	Then I verify the distribution table header Dividend / Reinvest Date is displayed
	Then I verify the distribution table header Payable date is displayed
	Then I verify the distribution table header Reinvest Price is displayed
	Then I verify the distribution table header Ordinary Incom is displayed
	Then I verify the Distributions Section Data is displayed in table
	Then I verify the distribution table View Full Table is displayed
	Then I verify the distribution table View Full Table Search Icon is displayed
	And I click the View Full Table
	And I wait for the complete page load
	Then I verify the View Full Table distribution header is displayed
	Then I verify the View Full Table header Dividend / Reinvest Date is displayed
	Then I verify the View Full Table header Payable date is displayed
	Then I verify the View Full Table header Reinvest Price is displayed
	Then I verify the View Full Table header Ordinary Incom is displayed
	Then I verify the View Full Table Close Icon is displayed
	Then I verify the View Full Table View Full Table Search Icon is displayed
	And I click the close icon to close View Full Table
	
		#Social share
	And I click on more options button
	Then I verify the print option is displayed in KeyActions menu on product detail page
	Then I verify the Email Share option is displayed in KeyActions menu in product detail page
	And I click on Email share link from KeyActions menu in product detail page
	Then I verify the email model window is displayed in product detail page
	Then I verify the email fields on email window in product detail page
	And I click on close button on email form in product detail page	
	
	Then I verify the Facebook option is displayed in KeyActions menu
	Then I verify the Twitter option is displayed in KeyActions menu
	Then I verify the LinkedIn option is displayed in KeyActions menu
	
	Then I Verify the Broken Links	
	Then I Verify the Broken Images
	And I Close the browser