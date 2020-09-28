@pdExchanForm @productdetail @uk @dk @sw @fn @nr @nl @lu @pduk @aa  @sg 
Feature: C1997:Product detail Literature - Exchange form validation

Scenario: C1997:Product detail Literature - Exchange form validation
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load 
	And I click on the products header
	And I wait for the complete page load
	And I verify the product list page is displayed
	#Then I click on the productlist page fund name navigation check from overview tab
	Then I click on the "Legg Mason Brandywine Global Enhanced Absolute Return Fund" in the productlist page under overview tab
	And I wait for the complete page load 
	And I click on Literature tab on product detail page
	Then I verify the Literature section is displayed and the tab is active 
	Then I verify the "Forms & Applications" section is displayed in literature tab
	Then I verify the Exchange Form is displayed
	And  I click on the Exchange Form link
	Then I verify Open icon is displayed after clicking Exchange form
	#Then I verify Email icon is displayed after clicking Exchange form
	And I click on Open icon of Exchange form
	And I switch to the second window
	Then I verify the Exchange form is opened
	
	#Email option is not authored
	#And I switch to the first window
	#And I click on Email icon of Exchange form
	#Then I verify the email model window is displayed in product detail page
	#Then I verify the email fields on email window in product detail page
	#And I click on close button on email form in product detail page