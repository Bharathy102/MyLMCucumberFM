@productdetailhk @pdEmailSharehk @hk
Feature: C1994:Product detail Email Share functionality validation

Scenario: C1994:Product detail Email Share validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	Then I click on the "lm-cb-us-aggressive-growth" in the productlist page under overview tab
	And I wait for the complete page load
	And I click on more options button 
	Then I verify the Email Share option is displayed in KeyActions menu in product detail page
	And I click on Email share link from KeyActions menu in product detail page
	Then I verify the email model window is displayed in product detail page
	Then I verify the email fields on email window in product detail page	 