@productlistde @de
Feature: C2360: ProductList Key Actions Email Share validation

Scenario: ProductList Key Actions email share
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I click on the products header for German Site
	And I refresh the page
	And I wait for the complete page load
	And I click on Key Actions options 
	Then I verify the Email Share option is displayed in KeyActions menu
	And I click on Email share link from KeyActions menu
	Then I verify the email model window is displayed
	Then I verify the email fields on email window