package com.publisher.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.publisher.pageobjects.ProductListPage;
import com.publisher.pageobjects.SearchPageObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class GlobalSearchSteps extends Utility{

	private static final String CLASS = "class";
	private static final String DISABLED = "disabled";
	public static final String ACTIVE = "active";

	@And("^I click on global search icon$")
	public void iClickOnGlobalSearchIcon() throws Throwable {
		//This step is not required due to latest change
		//this.robustDriver.clickableElementWait(SearchPageObject.searchPageObject(driver).getGlobalsearchicon());
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", SearchPageObject.searchPageObject(driver).getGlobalsearchicon());
		//SearchPageObject.searchPageObject(driver).getGlobalsearchicon().click();

	}

	@And("^I Enter \"(.*)\" in the global search$")
	public void iEnterGlobalSearch(String ent) throws Throwable {

		CommonMethods.visibleElement(SearchPageObject.searchPageObject(driver).getGlobalsearchinput());
		SearchPageObject.searchPageObject(driver).getGlobalsearchinput().clear();
		SearchPageObject.searchPageObject(driver).getGlobalsearchinput().click();
		Thread.sleep(3000);
		SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys(ent);
		Thread.sleep(3000);
		//this.robustDriver.clickableElementWait(SearchPageObject.searchPageObject(driver).getAdvancedGlobalSearch());
		SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys(Keys.ENTER);

	}

	@Then("^I verify search result is displaying or not")
	public void iVerifySearchResultIsDisplayingOrNot() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getEntrustSearchresult().isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getEntrustPermalSearchresult().isDisplayed());

	}
	@Then("^I verify search result is displayed")
	public void iVerifySearchResultPageIsDisplayingOrNot() throws Throwable {
		String str= "Search results";
		assertEquals(driver.getTitle(),str);
	
	}
	
	@Then("^I verify the ISIN value is displayed in Product detail page$")
	public void iVerifyTheISINPageValidation() throws Throwable {
		if (driver.getCurrentUrl().contains("en-gb")) {
			String message = "IE00BDR6ZM86";
			assertTrue(SearchPageObject.searchPageObject(driver).getISINlValue().isDisplayed());
			String isinValue = SearchPageObject.searchPageObject(driver).getISINlValue().getText();
			assertEquals(message,isinValue);
		}else if (driver.getCurrentUrl().contains("en-fi")) {
			String message = "IE00BMMV5V01";
			assertTrue(SearchPageObject.searchPageObject(driver).getISINlValue().isDisplayed());
			String isinValue = SearchPageObject.searchPageObject(driver).getISINlValue().getText();
			assertEquals(message,isinValue);
		}else if (driver.getCurrentUrl().contains("en-nl")) {
			String message = "IE00BXRTLD08";
			assertTrue(SearchPageObject.searchPageObject(driver).getISINlValue().isDisplayed());
			String isinValue = SearchPageObject.searchPageObject(driver).getISINlValue().getText();
			assertEquals(message,isinValue);
		} else if (driver.getCurrentUrl().contains("en-dk")) {
			String message = "IE00BF3ZD858";
			assertTrue(SearchPageObject.searchPageObject(driver).getISINlValue().isDisplayed());
			String isinValue = SearchPageObject.searchPageObject(driver).getISINlValue().getText();
			assertEquals(message,isinValue);
		}else if (driver.getCurrentUrl().contains("en-no")) {
			String message = "IE00BXRTL637";
			assertTrue(SearchPageObject.searchPageObject(driver).getISINlValue().isDisplayed());
			String isinValue = SearchPageObject.searchPageObject(driver).getISINlValue().getText();
			assertEquals(message,isinValue);
		}else if (driver.getCurrentUrl().contains("en-lu")) {
			String message = "IE00BSBN5Q47";
			assertTrue(SearchPageObject.searchPageObject(driver).getISINlValue().isDisplayed());
			String isinValue = SearchPageObject.searchPageObject(driver).getISINlValue().getText();
			assertEquals(message,isinValue);		
		}else if (driver.getCurrentUrl().contains("en-sg")) {
			String message = "IE00B59BT671";
			assertTrue(SearchPageObject.searchPageObject(driver).getISINlValue().isDisplayed());
			String isinValue = SearchPageObject.searchPageObject(driver).getISINlValue().getText();
			assertEquals(message,isinValue);
		}else if (driver.getCurrentUrl().contains("en-aa")) {
			String message = "IE00BMMV5V01";
			assertTrue(SearchPageObject.searchPageObject(driver).getISINlValue().isDisplayed());
			String isinValue = SearchPageObject.searchPageObject(driver).getISINlValue().getText();
			assertEquals(message,isinValue);	
		} else {
			System.out.println( "No Results Found for the Given Country");			
		}
	}
	
	@Then("^I verify the SEDOL value is displayed in Product detail page$")
	public void iVerifyTheSEDOLPageValidation() throws Throwable {
		if (driver.getCurrentUrl().contains("en-gb")) {
		String message = "BDR6ZM8";
		assertTrue(SearchPageObject.searchPageObject(driver).getSedolValue().isDisplayed());
		String sedolValue = SearchPageObject.searchPageObject(driver).getSedolValue().getText();
		assertEquals(message,sedolValue);
		}else if (driver.getCurrentUrl().contains("en-fi")) {
			String message = "BMMV5V0";
			assertTrue(SearchPageObject.searchPageObject(driver).getSedolValue().isDisplayed());
			String sedolValue = SearchPageObject.searchPageObject(driver).getSedolValue().getText();
			assertEquals(message,sedolValue);
		}else if (driver.getCurrentUrl().contains("en-nl")) {
			String message = "BXRTLD0";
			assertTrue(SearchPageObject.searchPageObject(driver).getSedolValue().isDisplayed());
			String sedolValue = SearchPageObject.searchPageObject(driver).getSedolValue().getText();
			assertEquals(message,sedolValue);
		} else if (driver.getCurrentUrl().contains("en-dk")) {
			String message = "BF3ZD85";
			assertTrue(SearchPageObject.searchPageObject(driver).getSedoValue().isDisplayed());
			String sedolValue = SearchPageObject.searchPageObject(driver).getSedoValue().getText();
			assertEquals(message,sedolValue);
		}else if (driver.getCurrentUrl().contains("en-no")) {
			String message = "BXRTL63";
			assertTrue(SearchPageObject.searchPageObject(driver).getSedolValue().isDisplayed());
			String sedolValue = SearchPageObject.searchPageObject(driver).getSedolValue().getText();
			assertEquals(message,sedolValue);
		}else if (driver.getCurrentUrl().contains("en-au")) {
			String fundNameUI = ProductListPage.productListPage(driver).getFundNameTitle().getText();
			String fundNameExpected = "Legg Mason Martin Currie Equity Income Fund";
			assertEquals(fundNameUI,fundNameExpected);
		}else if (driver.getCurrentUrl().contains("en-sg")) {
			String message = "B59BT67";
			assertTrue(SearchPageObject.searchPageObject(driver).getSedolValue().isDisplayed());
			String sedolValue = SearchPageObject.searchPageObject(driver).getSedolValue().getText();
			assertEquals(message,sedolValue);
		}else if (driver.getCurrentUrl().contains("en-aa")) {
			String message = "BMMV5V0";
			assertTrue(SearchPageObject.searchPageObject(driver).getSedolValue().isDisplayed());
			String sedolValue = SearchPageObject.searchPageObject(driver).getSedolValue().getText();
			assertEquals(message,sedolValue);	
		} else {
			System.out.println( "No Results Found for the Given Country");			
		}
	}	

	@Then("^I verify Advanced Tab is present or not")
	public void iVerifyAdvancedTabIsPresentOrNot() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getAdvancedGlobalSearch().isDisplayed());

	}
	@Then("^I verify Advanced Tab is present in while search")
	public void iVerifyAdvancedTabIsPresentOrNotinSearch() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getSearchAdvancedTab().isDisplayed());

	}

	@And("^I select Entrustpermal from the search result")
	public void iSelectEntrustpermalFromTheSearchResult() throws Throwable {
		SearchPageObject.searchPageObject(driver).getEntrustPermalSearchresult().click();

	}
	@And("^I select products from the search results")
	public void iSelectISINFromTheSearchResult() throws Throwable {
		if (SearchPageObject.searchPageObject(driver).getISINProducts().isDisplayed()) {
			SearchPageObject.searchPageObject(driver).getISINProducts().click();
		}else {
			String notFound = SearchPageObject.searchPageObject(driver).getNOISINProducts().getText();
			assertEquals(notFound,"No Results Found");
			System.out.println( "No Results Found for the Given Country");
		}  
	}

	@Then("^I verify the search result page for entrust permal")
	public void iVerifyTheSearchResultPageForEntrustPermal() throws Throwable {

		List<WebElement> searchResultTab = this.driver.findElements(By.xpath("//*[@data-interaction-type='tab']"));
		System.out.println("The Total No of available Tabs in Search Result Page:" + searchResultTab.size());

		for (int i = 0; i < searchResultTab.size(); i++) {
			searchResultTab = this.driver.findElements(By.xpath("//*[@data-interaction-type='tab']"));
			String tabtitle = searchResultTab.get(i).getText();
			System.out.println("The " + tabtitle + " Tab is Available");
			boolean title = searchResultTab.get(i).isDisplayed();
			System.out.println("The " + tabtitle + " Tab is display:" + title);

			searchResultTab.get(i).click();
			Thread.sleep(5000);
		}
	}

	@Then("^I verify the \"([^\"]*)\" message is displayed in all tab$")
	public void iVerifyTheNoResultMessageValidation(String message) throws Throwable {
		Thread.sleep(3000);
		String noResultsMessage = SearchPageObject.searchPageObject(driver).getNoResultfoundMessageAllTab().getText();
		assertTrue(noResultsMessage.contains(message));

	}

	@And("^I click on Product Tab$")
	public void iClickOnProductTab() throws Throwable {

		SearchPageObject.searchPageObject(driver).getProductsTabSearchResult().click();

	}

	@And("^I select any of the product$")
	public void iSelectAnyOfTheProduct() throws Throwable {

		SearchPageObject.searchPageObject(driver).getSearchResults().click();

	}

	@And("^I select the Resource Tab$")
	public void iSelectTheResourceTab() throws Throwable {

		//SearchPageObject.searchPageObject(driver).getResourceTabSearch().click();
		SearchPageObject.searchPageObject(driver).getResourcesTabSearchResult().click();

	}
	


	@And("^I select the Perspectives Tab$")
	public void ISelectThePerspectivesTab() throws Throwable {

		SearchPageObject.searchPageObject(driver).getPerspectivesTabSearchResult().click();

	}

	@And("^I validate appropriate product page is displaying in the same window$")
	public void iValidateAppropriateProductPageIsDisplayingInTheSameWindow() throws Throwable {

		String textPerformance = SearchPageObject.searchPageObject(driver).getPerformanceSearchResultPage().getText();
		assertEquals(textPerformance, "Performance");
	}

	@Then("^I verify the \"([^\"]*)\" message is displayed in Products tab$")
	public void iVerifyTheNoResultMessageInProductTab(String message) throws Throwable {
		Thread.sleep(3000);
		String noResultsMessage = SearchPageObject.searchPageObject(driver).getNoResultfoundMessageProductTab().getText();
		assertTrue(noResultsMessage.contains(message));

	}

	@And("^I click on Resources Tab$")
	public void iClickOnResourcesTab() throws Throwable {

		SearchPageObject.searchPageObject(driver).getResourcesTabSearchResult().click();

	}

	@Then("^I verify the \"([^\"]*)\" message is displayed in Resources tab$")
	public void iVerifyTheNoResultMessageInResourcesTab(String message) throws Throwable {
		Thread.sleep(3000);
		String noResultsMessage = SearchPageObject.searchPageObject(driver).getNoResultfoundMessageResourcesTab().getText();
		assertTrue(noResultsMessage.contains(message));

	}

	@And("^I click on Perspectives Tab$")
	public void iClickOnPerspectivesTab() throws Throwable {

		SearchPageObject.searchPageObject(driver).getPerspectivesTabSearchResult().click();

	}

	@Then("^I verify the \"([^\"]*)\" message is displayed in Perspectives tab$")
	public void iVerifyTheNoResultMessageInPerspectivesTab(String message) throws Throwable {
		Thread.sleep(3000);
		String noResultsMessage = SearchPageObject.searchPageObject(driver).getNoResultfoundMessagePerspectiveTAb().getText();
		assertTrue(noResultsMessage.contains(message));

	}

	@And("^I clear the search Text$")
	public void iClearTheSearchText() throws Throwable {

		SearchPageObject.searchPageObject(driver).getGlobalsearchinput().clear();

	}

	@And("^I Hit enter without entering any text$")
	public void iHitEnterWithoutEnteringAnyText() throws Throwable {
		Thread.sleep(3000);	
		SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}

	@And("^I click on All Tab$")
	public void iClickOnAllTab() throws Throwable {

		SearchPageObject.searchPageObject(driver).getAllTabSearchResult().click();
		Thread.sleep(3000);

	}

	@And("^I click the Advanced$")
	public void iClickTheAdvanced() throws Throwable {

		SearchPageObject.searchPageObject(driver).getAdvancedGlobalSearch().click();

	}
	@And("^I verify that the filter is expanded or not$")
    public void iVerifyFilterClose() throws Exception {
       		if(SearchPageObject.searchPageObject(driver).getfilterCloseButton().isDisplayed()) {
    		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SearchPageObject.searchPageObject(driver).getfilterCloseButton());
       			SearchPageObject.searchPageObject(driver).getfilterCloseButton().click();
       		}else {
       			
       		}
    		
    	}
	@And("^I verify the Affiliate filters are displayed$")
	public void iVerifyTheAffiliateFiltersAreDisplayed() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateFilter().isDisplayed());

	}

	@And("^I verify the Asset Class are displayed$")
	public void iVerifyTheAssetClassAreDisplayed() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getAssetClassFilter().isDisplayed());

	}

	@And("^I verify the Product Type filters are displayed$")
	public void iVerifyTheProductTypeFiltersAreDsiplayed() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getProductTypeFilter().isDisplayed());

	}

	@And("^I verify the Document Type are displayed$")
	public void iVerifyTheDocumentTypeAreDisplayed() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeFilter().isDisplayed());

	}

	@And("^I verify the Perspective Type filters are displayed$")
	public void IVerifyThePerspectiveTypeFiltersAreDisplayed() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getPerspectiveTypeFilter().isDisplayed());

	}

	@And("^I verify the Most Recent are displayed$")
	public void iVerifyTheMostRecentAreDisplayed() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getMostRecentFilter().isDisplayed());

	}

	@And("^I select first Affiliate filter checkbox$")
	public void iSelectFirstAffiliateFilterCheckbox() throws Throwable {

		SearchPageObject.searchPageObject(driver).getFirstCheckboxAffiliate().click();

	}

	@And("^I select the second Assert Class filter checkbox$")
	public void iSelectTheSecondAssertClassFilterCheckbox() throws Throwable {

		SearchPageObject.searchPageObject(driver).getSecondCheckboxAssetClass().click();

	}

	@And("^I click on Clear All Filters$")
	public void iClickOnClearAllFilters() throws Throwable {

		assertTrue(SearchPageObject.searchPageObject(driver).getclearFilterSearchs().isDisplayed());
		SearchPageObject.searchPageObject(driver).getclearFilterSearchs().click();

	}
	
	@Then("^I click on \"([^\"]*)\" filter$")
	public void iClickOnFilter(String filter) throws Throwable {
	   Thread.sleep(2000);
	   SearchPageObject.searchPageObject(driver).getFilterOptions(filter).click();
	}

	@Then("^I verify Affiliate check boxes are available$")
	public void iVerifyAffiliateCheckBoxesAreAvailable() throws Throwable {
		 Thread.sleep(5000);
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("brandywine-global").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("clarion-partners").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("clearbridge-investments").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("entrustpermal").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("legg-mason").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("martin-currie").isDisplayed());
		 //assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("Martin Currie").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("qs-investors").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("rare-infrastructure").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("royce-and-associates").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAffiliateOptions("western-asset-management").isDisplayed());
	}

	@Then("^I verify Asset class check boxes are available$")
	public void iVerifyAssetClassCheckBoxesAreAvailable() throws Throwable {
		 Thread.sleep(5000);
		 //assertTrue(SearchPageObject.searchPageObject(driver).getAssetClassOptions("absolute-return").isDisplayed());
		 //assertTrue(SearchPageObject.searchPageObject(driver).getAssetClassOptions("alternatives").isDisplayed());
		// assertTrue(SearchPageObject.searchPageObject(driver).getAssetClassOptions("asset-allocation").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAssetClassOptions("equity").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAssetClassOptions("fixed-income").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAssetClassOptions("money-funds").isDisplayed());
		 assertTrue(SearchPageObject.searchPageObject(driver).getAssetClassOptions("multi-strategy").isDisplayed());
		 //assertTrue(SearchPageObject.searchPageObject(driver).getAssetClassOptions("equity").isDisplayed());
		
	}

	@Then("^I verify Product type check boxes are available$")
	public void iVerifyProductTypeCheckBoxesAreAvailable() throws Throwable {
		Thread.sleep(2000);
		assertTrue(SearchPageObject.searchPageObject(driver).getProductTypeOptions("mutual-funds").isDisplayed());
	}

	@Then("^I verify Perspective type check boxes are available$")
	public void iVerifyPerspectiveTypeCheckBoxesAreAvailable() throws Throwable {
		Thread.sleep(5000);
		//assertTrue(SearchPageObject.searchPageObject(driver).getPerspectiveTypeOptions("blog").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getPerspectiveTypeOptions("cotw").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getPerspectiveTypeOptions("commentary").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getPerspectiveTypeOptions("insight").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getPerspectiveTypeOptions("mwbu").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getPerspectiveTypeOptions("outlook").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getPerspectiveTypeOptions("snapshot").isDisplayed());
	}

	@Then("^I verify Document type check boxes are available$")
	public void iVerifyDocumentTypeCheckBoxesAreAvailable() throws Throwable {
		Thread.sleep(5000);
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("Prospectus&Supplement").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("KIID").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("FactSheet").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("AnnualReport").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("SemiAnnualReport").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("PressRelease").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("MarketCommentary").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("ProductCommentary").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("Q&A").isDisplayed());
		assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions("Letter&Notices").isDisplayed());
	}

	@Then("^I verify Most Recent check boxes are available$")
	public void iVerifyMostRecentCheckBoxesAreAvailable() throws Throwable {
		Thread.sleep(5000);
		assertTrue(SearchPageObject.searchPageObject(driver).getMostRecentOptions("most-recent").isDisplayed());
	}
	
	@Then("^I select \"([^\"]*)\" in Affiliate filter$")
	public void iSelectInAffiliateFilter(String option) throws Throwable {
		Thread.sleep(5000);
		SearchPageObject.searchPageObject(driver).getAffiliateOptions(option).click();
	}

	@Then("^I select \"([^\"]*)\" in Asset Class filter$")
	public void iSelectInAssetClassFilter(String option) throws Throwable {
		Thread.sleep(5000);
		SearchPageObject.searchPageObject(driver).getAssetClassOptions(option).click();
	}
	
	@Then("^I verify the chip is correctly displayed for the selected filters$")
	public void iVerifyTheChipIsCorrectlyDisplayedForTheSelectedFilters() throws Throwable {
		Thread.sleep(5000);int count=0;
		List<WebElement> chips = this.driver.findElements(By.xpath("//div[@class='filter-selections-page']//div[@class='selection']"));
		 List<WebElement> checBoxes = this.driver.findElements(By.xpath("//div[@id='filterMenuSearchResults']//input"));
		 
		 for (WebElement x : checBoxes) {
			if(x.isSelected())
				count=count+1;
		}
		 assertEquals(count, chips.size());
		
		
	}
		

	@Then("^I verify filter chips are removed and all checkboxes are unselected$")
	public void iVerifyFilterChipsAreRemovedAndAllCheckboxesAreUnselected() throws Throwable {
	   Thread.sleep(6000);
	   List<WebElement> chips = this.driver.findElements(By.xpath("//div[@class='filter-selections-page']//div[@class='selection']"));
	   assertEquals(0, chips.size());
	   
	}

	 @Then("^I verify \"([^\"]*)\" link is returning to search result page$")
	    public void iVerifySomethingLinkIsReturningToSearchResultPage(String documentType) throws Throwable {
	      String currentURL=driver.getCurrentUrl();
	      driver.get(currentURL+"&dt=" + documentType);
	      Thread.sleep(2000);
	      String count=SearchPageObject.searchPageObject(driver).getresoruceTabresultsCount().getText();
	      assertTrue(count!="0");
	      driver.navigate().refresh();
	    }

	    @Then("^I verify \"([^\"]*)\" checkbox is prefiltered$")
	    public void iVerifySomethingCheckboxIsPrefiltered(String dcoumentType) throws Throwable {
	    	System.out.println(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions(dcoumentType).getAttribute("data-interaction-type"));
	    	assertTrue(SearchPageObject.searchPageObject(driver).getDocumentTypeOptions(dcoumentType).getAttribute("data-interaction-type").equalsIgnoreCase("clear"));
	    }

}
