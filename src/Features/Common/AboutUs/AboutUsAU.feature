@aboutus1 @au @nonprodau
Feature: C2526: About Us validation for Australia site

Scenario: C2526: Verify the About Us page for Australia site
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	#And I wait for the complete page load 
	And I click on About us in home page
	And I wait for the complete page load 
	And I click on Leadership
	And I wait for the complete page load	 
	Then I verify Leadership Image Lists 
	And I click on About us in home page 
	And I wait for the complete page load 
	And I click on Our Affiliates
	And I wait for the complete page load  	
	Then I verify Affiliates Grids
	#And I wait for the complete page load
	And I click on About us in home page
	And I wait for the complete page load
	And I click on Who We Are tile from About Us page
	And I wait for the complete page load
	Then I verify Affiliates Grids 	
	And I click on About us in home page
	And I wait for the complete page load	
	And I click on AU Leadership Team from About Us page
	And I wait for the complete page load
	Then I verify Leadership Image Lists for Australia Team
	And I click on About us in home page
	And I wait for the complete page load 
	Then I verify Key Facts section is present in About Us page	
	#And I click on About us in home page
	#And I wait for the complete page load
	