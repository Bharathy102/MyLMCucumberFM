@productdetail @uk @dk @sw @au @fn @nr @nl @lu @pduk @pdau  @aa @sg @DDAtest @C4296
Feature: C1928:Product detail Sections validations
@pdSecCheck
Scenario: C1928:Product detail Sections Checks
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I verify the product list page is displayed
	And I refresh the page
	And I wait for the complete page load
	#Then I click on the productlist page fund name navigation check for Performance tab
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load 
	Then I verify SVG images id removed for DDA/ADA compliance
	Then I verify the user role menu is displayed
	Then I verify the user role has a dropdown with Investment professional/Individual investor options.
	Then I Verify Franklin Templeton Logo in Product Detail page
	And I Verify Market Insights Menu Header is available in home page
	And I Verify Products Menu Header is available in home page
	And I Verify Literature Menu Header is available in home page
	And I Verify About Us Menu Header is available in home page
	And I Verify Contact Us Menu Header is available in home page
	And I Verify Global Search Icon is available in home page
	Then I verify Country dropdown icon is present or not
	Then I verify that the Watchlist header Icon is displayed
	Then I verify that a message indicate that there is no product currently in watchlist
	Then I verify the Fund Name is displayed
	Then I verify the Share Class name is displayed
	Then I verify the Shareclass dropdown is displayed and clickable
	Then I verify the watchlist icon in product summary component
	Then I verify the Disclosure is displayed if available
	#Then I verify the Product Stats ISIN, Share Class Inception Date, AUM, Asofdate
	Then I verify the ShareClass inception date is as per the country's local
	Then I verify the AsOfDate is as per country's local
	Then I verify the product detail tabs availability
	And I Scroll down the page
	Then I verify country footer is present or not 
	Then I verify the available footer links
	Then I verify copyrights footer validation	
	Then I verify twitter footer link validation 
	Then I verify linkedln footer link validation 
	Then I verify youtube footer link validation
	Then I verify the footer disclosure
	Then I verify the Account Access option	