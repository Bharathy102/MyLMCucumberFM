@affiliatesde @de @C2292de @affiliatere @regresisonde 
Feature: Our Affiliates section validation in Home page

Scenario: Verify the Our Affiliates section in Home Page
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
	Then I verify the Brandywine logo
	
	And I click on browser back button	
	And I Scroll down the page
	And I click Martin Currie affiliate in home page
	Then I verify Martin Currie logo 
	
	And I click on browser back button	
	And I Scroll down the page
	And I click EnTrust Permal affiliate in home page
	Then I verify the EnTrust Permal logo
	
	And I click on browser back button
	And I Scroll down the page
	And I click on ClearBridge Investment affiliate in home page
	Then I verify the ClearBridge Investment logo
	
	And I click on browser back button
	And I Scroll down the page
	And I click on Clarion Partners affiliate in home page
	Then I verify the Clarion Partners logo 
	
	And I click on browser back button
	And I Scroll down the page
	And I click Royce Associates affiliate in home page
	Then I verify Royce Associates logo 	
	
	And I click on browser back button
	And I Scroll down the page
	And I click RARE affiliate in home page
	Then I verify RARE logo
		
	And I click on browser back button
	And I Scroll down the page
  And I click QS Investors affiliate in home page
	Then I verify the QS Investors logo	
	
	And I click on browser back button
	And I Scroll down the page
	And I click Western Asset affiliate in home page
	Then I verify Western Asset logo
	And I Close the browser