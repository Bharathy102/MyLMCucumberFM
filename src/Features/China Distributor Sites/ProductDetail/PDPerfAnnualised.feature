@pdPerfAnnualized @productdetail @chdistributor
Feature: C2279:Product detail Annualised Performance validation

@pdAnnualisedPerf
Scenario: C2279:Product detail Annualised Performance validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I select Distributor View
	And I wait for the complete page load 	
	And I select Accept for Terms and Conditions in the SpeedBump for China
	And I wait for the complete page load
	And I click on the products header for selected distributor
	And I wait for the complete page load
	Then I click on the "lm-cb-us-aggressive-growth" in the productlist page under overview tab
	And I wait for the complete page load
	And I click on Performance Tab on product detail page for selected distributor
	And I click on Annualised tab under Performance section for selected distributor
	