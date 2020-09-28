@pdSubForm @productdetail @uk @dk @sw @fn @nr @nl @lu @pduk @aa  @sg
Feature: C1996:Product detail Literature - Subsequent Application Form validation

Scenario: C1996:Product detail Literature - Subsequent Application Form validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	#Then I click on the productlist page fund name navigation check from overview tab
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load 
	And I click on Literature tab on product detail page
	Then I verify the Literature section is displayed and the tab is active 
	Then I verify the "Forms & Applications" section is displayed in literature tab
	Then I verify the SubSequent Application Form is displayed
	And  I click on the Subsequent Application Form link
	Then I verify the Initial Application Form model window is displayed
	Then I verify the fields on the Initial Application Form model window
	And I click on the close button on the Initial Application Form model window
	And I click on Literature tab on product detail page
	And  I click on the Subsequent Application Form link
	Then I verify the Next button got disabled in model window
	#And I select the share class in model window
	And I select the share class "Class A SGD Accumulating (Hedged)" in model window
	Then I verify the Next button got enabled in model window
	And I click on Clear All button in model window
	Then I verify the Next button got disabled in model window
	And I click on Select All button in model window
	Then I verify all the shareclass got selected
	Then I verify the Next button got enabled in model window 
	And I click on the Next button in model window
	Then I verify the user is naigated to step Two of the model window
	Then I verify the message on the Step Two of the model window
	Then I verify the Back and Next button on Step Two of the model window
	And I click on Back button on Step Two of the model window
	Then I verify the user is navigated to the Step one of the model window
	And I click on next button in model window
	And I click on Generate button on Step Two of the model window
	Then I verify the user is naigated to step Three of the model window
	Then I verify the message on the on the Step Three of the model window
	Then I verify the Download button is displayed on Step Three of the model window
	And I click on the Close button in Step of Three the model window