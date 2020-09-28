@productlist @sg
Feature: C2550:Product list overview page validation for Singapore

Scenario: Verify Product List overview for Singapore
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the product overview header on Singapore
	And I wait for the complete page load
	Then I verify the Authorised section on Product Overveiw page
	And I click on Authorised section on Product Overveiw page
	Then I verify the link to Authorised under authorised section
	And  I click on link to Authorised button
	And I wait for the complete page load
	Then I verify the product list page is displayed  
	Then I verify Overview tab is displayed
	Then I verify the Performance tab is displayed
