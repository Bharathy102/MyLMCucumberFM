@affiliatesde @de @C2292de @regresisonde @affiliatere
Feature: Our Affiliates broken image and links Home page

Scenario: Verify the Our Affiliates broken image and links Home page
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	And I Scroll down the page
	And I wait for the complete page load 
	Then I verify all the affiliates are present or not
	And I click on Brandywine affiliate in home page
	And I wait for the complete page load  
	Then I verify the broken links in Brandywine Affiliate page
	Then I validate broken Image in Brandywine affiliate page	
	
	And I Scroll down the page
	And I click Martin Currie affiliate in home page
	Then I verify the broken links in Martin Currie Affiliate page
	Then I validate broken Image in Martin Currie page 
	
	And I Scroll down the page
	And I click EnTrust Permal affiliate in home page
	Then I verify the broken links in EnTrust Permal Affiliate page
	Then I validate broken Image in EnTrust Permal page
		
	And I click on browser back button
	And I Scroll down the page
	And I click on ClearBridge Investment affiliate in home page
	Then I verify the broken links in ClearBridge Investment Affiliate page
	Then I validate broken Image in ClearBridge Investment page
	
	And I click on browser back button
	And I Scroll down the page
	And I click on Clarion Partners affiliate in home page
	Then I verify the broken links in Clarion Partners Affiliate page
	And I wait for the complete page load 	
	Then I verify broken Image in Clarion Partners page 
	
	And I click on browser back button
	And I Scroll down the page
	And I click Royce Associates affiliate in home page
	Then I verify the broken links in Royce Associates Affiliate page
	Then I validate broken Image in Royce Associates page
 		
	And I click on browser back button
	And I Scroll down the page
	And I click RARE affiliate in home page
	Then I verify the broken links in RARE Affiliate page
	Then I validate broken Image in RARE page

	And I click on browser back button
	And I Scroll down the page
  And I click QS Investors affiliate in home page
  Then I verify the broken links in QS Investors Affiliate page
	Then I validate broken Image in QS Investors page	
	
	And I click on browser back button
	And I Scroll down the page
	And I click Western Asset affiliate in home page
	Then I verify the broken links in Western Asset Affiliate page
	Then I validate broken Image in Western Asset page
	And I Close the browser