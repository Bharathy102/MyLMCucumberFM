@productdetailhk @hk
Feature: C2277:Product detail Cumulative Performance validation

Scenario: C2277:Product detail Cumulative Performance validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load
	And I click on the products header
	And I wait for the complete page load
	Then I click on the "lm-cb-us-aggressive-growth" in the productlist page under overview tab
	And I wait for the complete page load
	And I click on Performance Tab on product detail page for selected distributor
	And I click on Cumulative tab under Performance section for selected distributor
	
	
	