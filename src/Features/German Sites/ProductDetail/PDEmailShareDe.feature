@productdetail @de
Feature: C1994:Product detail Email Share functionality validation

@pdEmailDe
Scenario: C1994:Product detail Email Share validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header for German Site
	And I verify the product list page is displayed
	And I click on the Perfomance Tab
	And I wait for the complete page load
	Then I verify the Performance tab is displayed
	Then I click on the "Legg Mason Brandywine Global Opportunistic Fixed Income Fund" in the productlist page under Performance tab
	And I wait for the complete page load 
	And I click on more options button 
	Then I verify the Email Share option is displayed in KeyActions menu in product detail page
	And I click on Email share link from KeyActions menu in product detail page
	Then I verify the email model window is displayed in product detail page
	Then I verify the email fields on email window in product detail page
	And I click on close button on email form in product detail page	 