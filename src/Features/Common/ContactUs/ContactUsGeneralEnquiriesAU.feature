@contactus @au @nonprodau @C4335
Feature: C1899: Contact Us validation for AU site

Scenario: C1899: Validation of Contact Us page for AU site
	Given I launch the publisher site 
	And I wait for the complete page load 
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load  
	And I Verify Contact Us Menu Header is available in home page 
	And I click on Contact Us Header in home page
	And I wait for the complete page load 	
	Then I verify the General Enquiries fields are present or not
	Then I verify the General Enquiries component contains a WAI-ARIA attribute for DDA / ADA Compliance
	And I click on Submit button
	Then I verify the Alert message "Please fill out this field." on "sender-email" field
	And I Enter "test" in the email field
	And I Enter "This is a QA Test Kindly Ignore" in the message field
	And I click on Submit button
	And I wait for the complete page load
	Then I verify the Alert message "Please fill valid email id." on "fromEmail1" field
	And I Close the browser	