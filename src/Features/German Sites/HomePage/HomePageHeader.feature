@homepagede @homepageheaderde @de @nonprodde
Feature: C1893: Global Home Page Functionality 
	As an author I want to verify the the home page in publisher site

Scenario: C1893: Verify the Header in Home Page 
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
	And I Verify About Us Menu Header is available in home page
	And I Verify Contact Us Menu Header is available in home page
	And I Verify Global Search Icon is available in home page
	Then I Verify Country Dropdown is available in home page
	And I verify Language selector is available in home page
	And I verify Role selector is available in home page
	And I Verify Watchlist Icon is available in home page
	And I Verify Products Menu URL is available or not for German site
	And I wait for the complete page load
	And I Verify Market Insights Menu URL is available or not for German site
	And I wait for the complete page load
	And I Verify Press Room Menu URL is available or not for German site
	And I wait for the complete page load
	And I Verify Literature Menu URL is available or not for German site
	And I wait for the complete page load
	And I Verify About Us Menu URL is available or not for German site
	And I wait for the complete page load
	And I Verify Contact Us Menu URL is available or not for German site
	And I Close the browser