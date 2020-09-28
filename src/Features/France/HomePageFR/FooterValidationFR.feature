@homepagefr @footervalfr @fr @nonprodfr
Feature: C1973: Footer link validation
	
Scenario: C1973: Verify the footer link in Home Page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	And I Scroll down the page
	And I wait for the complete page load 
	Then I verify country footer is present or not 
	Then I verify the available footer links
	Then I verify copyrights footer validation	
	Then I verify twitter footer link validation 
	Then I verify linkedln footer link validation
	Then I verify youtube footer link validation
	And I Close the browser