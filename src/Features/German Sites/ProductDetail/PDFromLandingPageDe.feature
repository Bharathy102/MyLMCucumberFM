@productdetailDe @de
Feature: C2242:Product list to product detail navigation

@pdLandingPageDe
Scenario: C2242:Product list to product detail navigation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed
	Then I click on the productlist page fund name navigation check from overview tab
	And I wait for the complete page load 
	Then I verify the Asset Type on product detail page on German Site
	Then I verify the Fund Name is displayed
	Then I verify the Share Class name is displayed
	Then I verify the Share Class name matches with the Share Class of the product List page
	Then I verify the Asset Type on product detail page on German Site
	Then I verify the Shareclass dropdown is displayed and clickable
	Then I verify the watchlist icon in product summary component
	Then I verify AIM title and details should be displayed
	Then I verify Fund Managers and details should be displayed
	Then I verify the Disclosure is displayed if available
	Then I verify the Product Stats ISIN, Share Class Inception Date, AUM, Asofdate for German site
	Then I verify the ShareClass inception date is as per the country's local
	Then I verify the AsOfDate is as per country's local
	And I change the shareclass
	Then I verify the Product Stats ISIN value is changed	 