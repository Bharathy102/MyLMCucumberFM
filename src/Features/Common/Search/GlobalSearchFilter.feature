@globalsearch @uk @cy @dk @sw @au @fn @nr @nl @ml @lu @gr @is @nonproduk @nonprodau @C2296
Feature: C2296 :Global Search filters validation

Scenario: C2296 : Verify Global search filter
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	Then I Verify Global Search Icon is available in home page
	#And I click on global search icon
	And I Enter "Brandywine" in the global search
	#Commented this step due to open defect LMG-1203
	#And I click the Advanced
	And I press the Enter key on the Search component
	And I wait for the complete page load
	
	And I click on "Affiliate" filter
	Then I verify Affiliate check boxes are available
	And I select "qs-investors" in Affiliate filter
	
	And I click on "Asset Class" filter
	Then I verify Asset class check boxes are available
	And I select "money-funds" in Asset Class filter
	
	#And I click on "Product Type" filter
	#Then I verify Product type check boxes are available
	
	And I click on "Perspective Type" filter
	Then I verify Perspective type check boxes are available
	
	And I click on "Document Type" filter
	Then I verify Document type check boxes are available
	
	#And I click on "Most Recent" filter
	#Then I verify Most Recent check boxes are available
	
	#Then I verify the Affiliate filters are displayed
	#Then I verify the Asset Class are displayed
	#Then I verify the Product Type filters are displayed
	#Then I verify the Document Type are displayed
	#Then I verify the Perspective Type filters are displayed
	#Then I verify the Most Recent are displayed
	#And I select first Affiliate filter checkbox
	
	#And I select "QS Investors" in Affiliate filter
	#Then I verify the funnel count is changed to 1
	Then I verify the chip is correctly displayed for the selected filters
	#And I select the second Assert Class filter checkbox
	
	#And I select "Money Funds" in Asset Class filter
	#Then I verify the funnel count is changed to 2
	#Then I verify the chip is displayed for the selected filter
	And I click on Clear All Filters
	#Then I verify that all filter checkboxes are clear, all filter chips are removed and the number bubble disappears
	Then I verify filter chips are removed and all checkboxes are unselected
	