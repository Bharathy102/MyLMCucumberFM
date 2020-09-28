@productdetailDe @de
Feature: C2286 ProductDetail Daily Stastics

@pdDailyStatsDe
Scenario: C2286 Verify ProductDetail Daily Stastics
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed
	Then I click on the productlist page fund name navigation check for Overview tab
	And I wait for the complete page load
	Then I verify the product detail page is Navigated
	And I click on Performance Tab on product detail page
	And I wait for the complete page load
	Then I verify the Performance Tab is displayed on product detail page
	And I Scroll down the page
	Then I verify the "daily-statistics characteristics daily-statistics-wdddy" Performance table is displayed with header "Tägliche Statistik" for German Site
	Then I verify the AsOf date is displayed on "daily-statistics characteristics daily-statistics-wdddy" table
	Then I verify the Daily Statistics Data is displayed in table