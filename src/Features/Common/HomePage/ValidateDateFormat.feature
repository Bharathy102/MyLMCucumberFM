@C2135
Feature: C2135: Verify country url 

Scenario: C2135: Verify country url in correct format 
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load
	And I click on the products header
	Then I verify product list date format and syntax
	Then I click on the productlist page fund name navigation check from overview tab
	Then I verify the ShareClass inception date is as per the country's local
	Then I verify the AsOfDate is as per country's local
	Then I verify Product detail dates contains slash
	