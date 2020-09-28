@brokenimagesDe  @regressionDe
Feature: Product Details  Broken Image validation

@pdRegression2De
Scenario: Verify Product Detail Regression 2
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
	Then I verify the Performance tab is selected by default
	And I click on Performance Tab on product detail page
	Then I verify the Performance section is displayed and the tab is active
	And I click on characteristics tab on product detail page for German Site
	Then I verify the characteristics section is displayed and the tab is active for German Site
	And I click on Literature tab on product detail page for German Site
	Then I verify the Literature section is displayed and the tab is active for German Site
	And I click on Managers tab on product detail page
	Then I verify the Managers section is displayed and the tab is active
	And I click on Investment Risks tab on product detail page
	Then I verify the Investment Risks section is displayed and the tab is active
	And I click on Holdings tab on product detail page
	Then I verify the Holdings section is displayed and the tab is active
	And I click on Distributions tab on product detail page for German Site
	Then I verify the Distributions section is displayed the tab is active for German Site	
	
	Then I verify that the Watchlist header Icon is displayed
	And I click on Add to Watchlist for the shareclass
	Then I verify that Watchlist has the 1 number of Fund added
	Then I verify the fund name and shareclass detail on watchlist
	Then I verify the watchlist has View Detail and Clear List buttons for German site
	And I change the shareclass
	And I click on Add to Watchlist for the shareclass
	Then I verify that Watchlist has the 2 number of Fund added
	And I click on Add to Watchlist for the shareclass
	And I click on Clear List option for German site
	Then I verify that a message indicate that there is no product currently in watchlist
	And I click on Add to Watchlist for the shareclass	
	And I click on View Detail button from Watchlist header for German site
	And I wait for the complete page load
	Then I verify the product list page is displayed
	Then I verify watchlist only filter is selected
	And I click on Clear List option for German site
	
	And I click on Literature tab on product detail page for German site
	Then I verify the Literature section is displayed and the tab is active for German site
	Then I verify the "Antragsformular" section is displayed in literature tab
	Then I verify the Initial Application Form is displayed for German Site
	And  I click on the Initial Application Form link for German site
	Then I verify the Initial Application Form model window is displayed
	Then I verify the fields on the Initial Application Form model window
	And I click on the close button on the Initial Application Form model window
	And I click on Literature tab on product detail page for German site
	And  I click on the Initial Application Form link for German site
	Then I verify the Next button got disabled in model window for German site
	And I select the share class in model window
	Then I verify the Next button got enabled in model window for German site
	And I click on Clear All button in model window for German site
	Then I verify the Next button got disabled in model window for German site
	And I click on Select All button in model window for German site
	Then I verify all the shareclass got selected
	Then I verify the Next button got enabled in model window for German site
	And I click on the Next button in model window for German site
	Then I verify the user is naigated to step Two of the model window
	Then I verify the message on the Step Two of the model window for German site
	Then I verify the Back and Next button on Step Two of the model window for German site
	And I click on Back button on Step Two of the model window for German site
	Then I verify the user is navigated to the Step one of the model window
	And I click on the Next button in model window for German site
	And I click on Generate button on Step Two of the model window for German site
	Then I verify the user is naigated to step Three of the model window
	Then I verify the message on the on the Step Three of the model window
	Then I verify the Download button is displayed on Step Three of the model window for German site
	And I click on the Close button in Step of Three the model window
	
	
	Then I verify the "Antragsformular" section is displayed in literature tab
	Then I verify the Redemption Form is displayed for German site
	And  I click on the Redemption Form link for German site
	Then I verify the Initial Application Form model window is displayed
	Then I verify the fields on the Initial Application Form model window
	And I click on the close button on the Initial Application Form model window
	And I click on Literature tab on product detail page for German site
	And  I click on the Redemption Form link for German site
	Then I verify the Next button got disabled in model window for German site
	And I select the share class in model window
	Then I verify the Next button got enabled in model window for German site
	And I click on Clear All button in model window for German site
	Then I verify the Next button got disabled in model window for German site
	And I click on Select All button in model window for German site
	Then I verify all the shareclass got selected
	Then I verify the Next button got enabled in model window for German site 
	And I click on the Next button in model window for German site
	Then I verify the user is naigated to step Two of the model window
	Then I verify the message on the Step Two of the model window Redemption form for German site
	Then I verify the Back and Next button on Step Two of the model window for German site
	And I click on Back button on Step Two of the model window for German site
	Then I verify the user is navigated to the Step one of the model window
	And I click on the Next button in model window for German site
	And I click on Generate button on Step Two of the model window for German site
	Then I verify the user is naigated to step Three of the model window
	Then I verify the message on the on the Step Three of the model window
	Then I verify the Download button is displayed on Step Three of the model window for German site
	And I click on the Close button in Step of Three the model window
	
	
	Then I verify the "Antragsformular" section is displayed in literature tab
	Then I verify the SubSequent Application Form is displayed for German site
	And  I click on the Subsequent Application Form link for German site
	Then I verify the Initial Application Form model window is displayed
	Then I verify the fields on the Initial Application Form model window
	And I click on the close button on the Initial Application Form model window
	And I click on Literature tab on product detail page for German site
	And  I click on the Subsequent Application Form link for German site
	Then I verify the Next button got disabled in model window for German site
	And I select the share class in model window
	Then I verify the Next button got enabled in model window for German site
	And I click on Clear All button in model window for German site
	Then I verify the Next button got disabled in model window for German site
	And I click on Select All button in model window for German site
	Then I verify all the shareclass got selected
	Then I verify the Next button got enabled in model window for German site
	And I click on the Next button in model window for German site
	Then I verify the user is naigated to step Two of the model window
	Then I verify the message on the Step Two of the model window Subsequent form for German site
	Then I verify the Back and Next button on Step Two of the model window for German site
	And I click on Back button on Step Two of the model window for German site
	Then I verify the user is navigated to the Step one of the model window
	And I click on the Next button in model window for German site
	And I click on Generate button on Step Two of the model window for German site
	Then I verify the user is naigated to step Three of the model window
	Then I verify the message on the on the Step Three of the model window
	Then I verify the Download button is displayed on Step Three of the model window for German site
	And I click on the Close button in Step of Three the model window
	