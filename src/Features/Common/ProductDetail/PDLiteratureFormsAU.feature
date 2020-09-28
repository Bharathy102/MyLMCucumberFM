@productdetail @au @pdau
Feature: C2571:Product detail Literature - Initial Application Form validation Australia

Scenario: C2571:Product detail Literature - Initial Application Form validation for Australia
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	Then I click on the productlist page fund name navigation check from overview tab
	And I wait for the complete page load 
	And I click on Literature tab on product detail page
	Then I verify the Literature section is displayed and the tab is active 
	Then I verify the "Forms & Applications" section is displayed in literature tab
	Then I verify the "Product Literature" section is displayed in literature tab
	Then I verify the "Regulatory Documents" section is displayed in literature tab
	Then I verify the "Featured Documents" section is displayed in literature tab	