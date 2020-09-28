@contactus @brokenimages @contactusch @chdistributor @nonprodch
Feature: C2304: ContactUs brokenimage validation 

Scenario: C2304: Verify the Broken Images for ContactUs page 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load  
	And I Verify Contact Us Menu Header is available in home page for selected distributor
	And I click on Contact Us Header in home page for selected distributor
	And I wait for the complete page load 
	Then I verify the broken Images for ContactUs for selected distributor
	And I Close the browser