@contactusswz @coverage @swz @nonprodswz
Feature: C1899: Contact Us General Enquiry page validation 
@genswz
Scenario: C1899: Contact Us General Enquiry page validation
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
	And I click on Submit button
	And I wait for the complete page load 
	Then I verify the Alert message "Füllen Sie dieses Feld aus." on "firstName" field
	Then I verify the dropdown values in Company Type
	And I Enter "Avanti" in the First Name General Enquiries field
	And I Enter "Automation" in the Last Name field 
	And I Enter "Leggmason" in the company field 
	And I Select Company Type as Investment Manager 
	And I Enter "Test Engineer" in the Job title field 
	And I Enter "test" in the email field
	And I Enter "This is a QA Test Kindly Ignore" in the message field
	And I click on Submit button
	And I wait for the complete page load 
	Then I verify the Alert message "Please fill valid email id." on "email" field
	And I Close the browser
	
	