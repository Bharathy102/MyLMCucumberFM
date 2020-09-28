@productdetailDe @de
Feature: C1998:Product detail Literature - Redemption form validation

@pdLitRedForm
Scenario: C1998:Product detail Literature - Redemption form validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed
	Then I click on the "Legg Mason Brandywine Global Opportunistic Fixed Income Fund" in the productlist page under overview tab
	And I wait for the complete page load 
	And I click on Literature tab on product detail page for German site
	Then I verify the Literature section is displayed and the tab is active for German site
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