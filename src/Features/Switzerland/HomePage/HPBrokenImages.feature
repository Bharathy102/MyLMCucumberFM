@hpbrokenimageswz @homepageswz @swz @nonprodswz
Feature: C2563 HomePage Broken Image validation

Scenario: C2563 Verify HomePage Broken Images
	Given I launch the publisher site
	And I wait for the complete page load
	When I verify the Title of Lunched Site
	And I select Opt In for Cookie Policy in the SpeedBump
	And I select User Role in the SpeedBump
	And I select Accept for Terms and Conditions in the SpeedBump
	And I wait for the complete page load
	And I Verify Franklin Templeton Logo in the home page
	Then I Verify the Broken Images
	And I Close the browser