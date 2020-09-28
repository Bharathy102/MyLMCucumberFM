@contactus @contactusch @chdistributor @nonprodch
Feature: C1895: Contact Us validation 

Scenario: C1895: Validation of Contact Us page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load  
	And I Verify Contact Us Menu Header is available in home page for selected distributor
	And I click on Contact Us Header in home page for selected distributor
	And I wait for the complete page load 
	And I Close the browser