@contactus @brokenlinks @contactusch @chdistributor @nonprodch
Feature: C2303: Contact Us brokenlinks validation  
	
Scenario: C2303: Verify the brokenlinks in Contact Us
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load  
	And I Verify Contact Us Menu Header is available in home page for selected distributor
	And I click on Contact Us Header in home page for selected distributor
	And I wait for the complete page load 
	Then I verify the broken links for ContactUs page for selected distributor
	And I Close the browser