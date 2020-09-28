@homepage @au @nonprodau
Feature: C2523: Global Home Page Functionality for Australia site 
	As an author I want to verify the the home page in publisher site for Australia
@logoau
Scenario: C2523 : Verify the Header in Home Page for Australia 
	Given I launch the publisher site
	And I wait for the complete page load
	And I select Opt In for Cookie Policy in the SpeedBump 
	And I select User Role in the SpeedBump 
	And I select Accept for Terms and Conditions in the SpeedBump 
	And I wait for the complete page load
	#Then I verify the homepage has only one H1 tag
	Then I verify hreflang and the default conditions in the page
	Then I verify the logo is from the path "/content/dam/leggmason-global/master-logos/"
	And I Verify Franklin Templeton Logo in the home page
	Then I Verify About Us Menu Header is available in home page
	Then I Verify Contact Us Menu Header is available in home page
	Then I Verify Global Search Icon is available in home page
	Then I Verify Country Dropdown is available in home page
	Then I Verify Watchlist Icon is available in home page
	Then I Verify Products Menu Header is available in home page
	Then I Verify Products Menu URL is available or not
	And I wait for the complete page load
	Then I Verify Market Insights Menu Header is available in home page
	Then I Verify Market Insights Menu URL is available or not
	And I wait for the complete page load
	Then I Verify News and Updates Header is available in home page
	And I wait for the complete page load
	Then I Verify News and Updates URL is available or not
	Then I Verify Invest with Us Header is available in home page
	And I wait for the complete page load
	Then I Verify Invest with Us URL is available or not
	And I wait for the complete page load
	Then I Verify About Us Menu URL is available or not
	Then I Verify Contact Us Menu URL is available or not
	And I wait for the complete page load
	And I Close the browser