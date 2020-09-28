@productdetailDe @de
Feature: C2366:Product Social Share options validation
@pdSocialShareDe
Scenario: C2366:Product Social Share options validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed
	Then I click on the productlist page fund name navigation check from overview tab
	And I wait for the complete page load
	And I click on more options button 
	Then I verify the Facebook option is displayed in KeyActions menu
	Then I verify the Twitter option is displayed in KeyActions menu
	Then I verify the LinkedIn option is displayed in KeyActions menu