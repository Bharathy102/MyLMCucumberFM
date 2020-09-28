@globalsearch @de
Feature: C2236: Global Search validation

@searchGerman
Scenario: C2236: Validation of Global Search in Home page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	Then I Verify Global Search Icon is available in home page 
	And I click on global search icon
	And I Enter "entrust" in the global search
	And I press the Enter key on the Search component
	#Then I verify search result is displaying or not
	#Then I verify Advanced Tab is present or not
	#And I select Entrustpermal from the search result
	Then I verify the search result page for entrust permal
	And I click on Product Tab
	And I wait for the complete page load
	And I select the Resource Tab
	And I select the Perspectives Tab
	
	And I refresh the page
	When I type "invalidInput" in the Search input box
	And I press the Enter key on the Search component
	And I click on All Tab
  Then I verify the "Keine Ergebniss gefunden" message is displayed in all tab
  And I click on Product Tab
  Then I verify the "Keine Ergebniss gefunden" message is displayed in Products tab
  And I click on Resources Tab
  Then I verify the "Keine Ergebniss gefunden" message is displayed in Resources tab
  And I click on Perspectives Tab
  Then I verify the "Keine Ergebniss gefunden" message is displayed in Perspectives tab
  And I clear the search Text
  And I Hit enter without entering any text
  And I click on All Tab
  Then I verify the "Keine Ergebniss gefunden" message is displayed in all tab
  And I click on Product Tab
  Then I verify the "Keine Ergebniss gefunden" message is displayed in Products tab
  And I click on Resources Tab
  Then I verify the "Keine Ergebniss gefunden" message is displayed in Resources tab
  And I click on Perspectives Tab
  Then I verify the "Keine Ergebniss gefunden" message is displayed in Perspectives tab
  
  And I refresh the page
  When I type "products" in the Search input box
  	And I press the Enter key on the Search component
  	And I wait for the complete page load
  	And I Scroll down the page
  	And I wait for the complete page load
  	Then I verify that I can click on the Next button
  	And I wait for the complete page load
  	Then I verify that I can click on the Previous button
  	And I wait for the complete page load
	And I set the Search Rows per page dropdown to "10"
	Then I verify that I can click on the Next button
	And I wait for the complete page load
  	Then I verify that I can click on the Previous button
  	And I wait for the complete page load
 	And I set the Search Rows per page dropdown to "50"
	Then I verify that I can click on the Next button
	And I wait for the complete page load
  	Then I verify that I can click on the Previous button
  	And I wait for the complete page load
  	And I set the Search Rows per page dropdown to "100"
	Then I verify that I can click on the Next button
	And I wait for the complete page load
  	Then I verify that I can click on the Previous button
  	And I wait for the complete page load
  	
  	And I refresh the page
  	And I type ISIN Value in the Search input box
  And I press the Enter key on the Search component
  And I wait for the complete page load
	Then I verify search result is displayed
  And I click on Product Tab
  And I select products from the search results
  Then I verify the ISIN value is displayed in Product detail page
  And I wait for the complete page load
	And I click on global search icon
	And I wait for the complete page load
  And I type SEDOL Value in the Search input box
  And I press the Enter key on the Search component
  And I wait for the complete page load
	Then I verify search result is displayed
  And I click on Product Tab
  And I select products from the search results
  Then I verify the SEDOL value is displayed in Product detail page
  And I wait for the complete page load
  
  And I refresh the page
  And I click on global search icon
  And I Enter "Brandywine" in the global search
	#And I click the Advanced
	And I press the Enter key on the Search component
	And I wait for the complete page load
	
	And I click on "Tochtergesellschaften" filter
	Then I verify Affiliate check boxes are available
	And I select "qs-investors" in Affiliate filter
	
	And I click on "Anlageklasse" filter
	Then I verify Asset class check boxes are available
	And I select "money-funds" in Asset Class filter
	
	And I click on "Produkttyp" filter
	Then I verify Product type check boxes are available
	
	And I click on "Perspektiventyp" filter
	Then I verify Perspective type check boxes are available
	
	And I click on "Dokumententyp" filter
	Then I verify Document type check boxes are available
	
	And I click on "Jüngste" filter
	Then I verify Most Recent check boxes are available
	
	Then I verify the chip is correctly displayed for the selected filters
	#Then I verify the chip is displayed for the selected filter
	And I click on Clear All Filters
	#Then I verify that all filter checkboxes are clear, all filter chips are removed and the number bubble disappears
	Then I verify filter chips are removed and all checkboxes are unselected
	