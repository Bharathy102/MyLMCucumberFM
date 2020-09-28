@literature @sg @C3507
Feature: Literature Page - Authorised Funds KeyActions validation 

@C3507
Scenario: Verify the Literature page -  Authorised Funds KeyActions validation 
	  Given I launch the publisher site 
	  And I wait for the complete page load 
	  And I select Opt In for Cookie Policy in the SpeedBump 
	  And I select User Role in the SpeedBump 
	  And I select Accept for Terms and Conditions in the SpeedBump 
	  Then I Verify Literature Menu Header is available in home page
	  And I click Literature header
    And I wait for the complete page load
	  And  I click on "Authorised" section link
	  And I click on "authorised" to link button
	  And I wait for the complete page load
    Then I verify "recognised" link is displayed on the page
    Then I verify the product list page is displayed
    Then I verify Overview tab is displayed

		And I click on Key Actions options 
		Then I verify the print option is displayed in KeyActions menu
		Then I verify the DownLoad Excel is displayed in KeyActions menu
		Then I verify the Email Share option is displayed in KeyActions menu
		And I click on Email share link from KeyActions menu
		Then I verify the email model window is displayed
		Then I verify the email fields on email window 
