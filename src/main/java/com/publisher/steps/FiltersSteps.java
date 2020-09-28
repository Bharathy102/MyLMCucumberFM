package com.publisher.steps;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.publisher.pageobjects.FiltersPage;
import com.publisher.pageobjects.ProductListPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class FiltersSteps extends Utility{
	
	
    private static final String CLASS = "class";
    private static final String DISABLED = "disabled";
    private static final String PAGEINFO = "Showing 1-25 of";
    private String emptyWatchListMsg = "Products & Share Classes added to your watchlist will be shown here";

	private static String fundNameProductList;
	private static String fundName;
	private static String shareClass;
	private static String domicileFilterName;
	private static String selectedShareClassFilter;
	
	
	@Then("^I verify the filter icon is displayed$")
	public void iVerifyTheFilterIconIsDisplayed() throws Throwable {
		if((!(getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1")))) {
		ProductListPage.productListPage(driver).getFilterButton().isDisplayed();	 
		}else{
			System.out.println("Not applicable for selected distributor");
        }
	}

	@Then("^I click on filter icon to expand the filters$")
	public void iClickOnFilterIconToExpandTheFilters() throws Throwable {
		if((!(getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1")))) {
		ProductListPage.productListPage(driver).getFilterButton().click();	 
		}else{
			System.out.println("Not applicable for selected distributor");
        }
	}

	@Then("^I verify the filters are expanded$")
	public void iVerifyTheFiltersAreExpanded() throws Throwable {
		if((!(getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1")))) {
		assertTrue(ProductListPage.productListPage(driver).isFilterAreaOpen());
		}else{
			System.out.println("Not applicable for selected distributor");
        }
	}

	@Then("^I verify the Share Class filters are displayed$")
	public void iVerifyTheShareClassFiltersAreDisplayed() throws Throwable {
		Thread.sleep(30000);
		assertTrue(FiltersPage.filtersPage(driver).getShareFilterCheckBox().isDisplayed());
	}
	
	@Then("^I verify the Vehicle Type filters are displayed$")
	public void iVerifyTheVehicleTypeFiltersAreDisplayed() throws Throwable {
		Thread.sleep(30000);
		assertTrue(FiltersPage.filtersPage(driver).getVehicleTypeCheckBox().isDisplayed());
	}
	
	@Then("^I verify the Vehicle filter options$")
	public void iVerifyTheVehicleTypeFiltersOptions() throws Throwable {
		Thread.sleep(30000);
		assertTrue(FiltersPage.filtersPage(driver).getVehicleTypeOptions().get(0).getText().contains("ETF"));
		assertTrue(FiltersPage.filtersPage(driver).getVehicleTypeOptions().get(1).getText().contains("Managed Fund"));
	}	

	@Then("^I verify the Asset Class filters are dsiplayed$")
	public void iVerifyTheAssetClassFiltersAreDsiplayed() throws Throwable {
		assertTrue(FiltersPage.filtersPage(driver).getAssetFilterCheckBox().isDisplayed());	    
	}

	@Then("^I verify the Currency filters are displayed$")
	public void iVerifyTheCurrencyFiltersAreDisplayed() throws Throwable {
	   	assertTrue(FiltersPage.filtersPage(driver).getCurrencyFilterCheckBox().isDisplayed());
	}

	@Then("^I verify the Investment Manager filters are displayed$")
	public void iVerifyTheInvestmentManagerFiltersAreDisplayed() throws Throwable {
		assertTrue(FiltersPage.filtersPage(driver).getInvManagerCheckbox().isDisplayed());	    
	}

	@Then("^I verify the Domicile filters are displayed$")
	public void iVerifyTheDomicileFiltersAreDisplayeded() throws Throwable {
	    assertTrue(FiltersPage.filtersPage(driver).getDomicileCheckBox().isDisplayed());
	}

	@Then("^I verify the watchlist filters are displayed$")
	public void iVerifyTheWatchlistFiltersAreDisplayed() throws Throwable {
	    assertTrue(ProductListPage.productListPage(driver).getWatchlistFilter().isDisplayed());	    
	}

	@Then("^I verify the Distribution Type filters are displayed$")
	public void iVerifyTheDistributionTypeFiltersAreDisplayed() throws Throwable {
	   	assertTrue(FiltersPage.filtersPage(driver).getDistTypeFilterCheckbox().isDisplayed());		
	}
	
	@And("^I select \"([^\"]*)\" checkbox in \"([^\"]*)\" filter$")
	public void iVerifyTheDistributionTypeFiltersAreDisplayed(String filterCheckbox, String filterType) throws Throwable {
		Thread.sleep(5000);
		FiltersPage.filtersPage(driver).getCheckboxFilterType(filterType, filterCheckbox).click();
	}
	
	
	@And("^I verify the results are based on ETF filter selected$")
	public void iVerifyTheETFFilteredResults() throws Throwable {
		Thread.sleep(5000);
		//FiltersPage.filtersPage(driver).getCheckboxFilterType().click();
	}

	@Then("^I select first Share Class filter checkbox$")
	public void iSelectFirstShareClassFilterCheckbox() throws Throwable {
		FiltersPage.filtersPage(driver).getShareFilterCheckBox().click();
		selectedShareClassFilter = FiltersPage.filtersPage(driver).getSelectedShareFilters().getText();
	}

	@Then("^I verify the funnel count is changed to (\\d+)$")
	public void iVerifyTheFunnelCountIsChangedTo(int count) throws Throwable {
		assertEquals(count, Integer.parseInt(FiltersPage.filtersPage(driver).getFilterNumberBubble().getText()));    
	}
	
	@Then("^I verify the chip is displayed for the selected filter$")
	public void iVerifyTheChipIsDisplayedForTheSelectedFilter() throws Throwable {
        List<WebElement> chips = FiltersPage.filtersPage(driver).getSelectionChips();
        for (WebElement chip : chips) {
        	System.out.println("Selected chips is displayed as :" + chip.getText());
            assertTrue(chip.isDisplayed());
        }	   	    
	}

	@Then("^I select the first Assert Class filter checkbox$")
	public void iSelectTheFirstAssertClassFilterCheckbox() throws Throwable {
	   	FiltersPage.filtersPage(driver).getAssetCheckBox().click();
	}
	
	@Then("^I select the first Distribution Type filter checkbox$")
	public void iSelectTheFirstDistributionFilterCheckbox() throws Throwable {
	   	FiltersPage.filtersPage(driver).getDistTypeFilterCheckbox().click();
	}
	
	@Then("^I select the first Currency filter checkbox$")
	public void iSelectTheFirstCurrencyFilterCheckbox() throws Throwable {
	   	FiltersPage.filtersPage(driver).getCurrencyFilterCheckBox().click();
	}
	
	@Then("^I select the \"([^\"]*)\" Currency filter checkbox for German Site$")
	public void iSelectTheFirstCurrencyFilterCheckboxDe(String filterName) throws Throwable {
	   	FiltersPage.filtersPage(driver).getCurrencyFilterCheckBoxDe(filterName).click();
	}
	
	@Then("^I select the first Investment Manager filter checkbox$")
	public void iSelectTheFirstInvestmentManagerFilterCheckbox() throws Throwable {
	   	FiltersPage.filtersPage(driver).getInvManagerCheckbox().click();
	}
	
	@Then("^I select the first Domicile filter checkbox$")
	public void iSelectTheFirstDomicileFilterCheckbox() throws Throwable {
	   	FiltersPage.filtersPage(driver).getDomicileCheckBox().click();
	   	domicileFilterName = FiltersPage.filtersPage(driver).getDomicileFilterName().getText();
	   	System.out.println("domicileFilterName: " + domicileFilterName);
	}
	
	@Then("^I select the Watchlist Only filter checkbox$")
	public void iSelectTheFirstWatchlistFilterCheckbox() throws Throwable {
	   	FiltersPage.filtersPage(driver).getAssetCheckBox().click();
	}	
	
	@Then("^I verify the filtered results on \"([^\"]*)\" tab based on the \"([^\"]*)\" and \"([^\"]*)\" selected Domicile filters on \"([^\"]*)\" position$")
	public void iVerifyTheDomicileFilteredResults(String TabName, String filterName, String filterType, String ColumnPosition) throws Throwable {
	    ((JavascriptExecutor)driver).executeScript("scroll(0, 250);");
		List <WebElement> shareClassColumns = driver.findElements(By.xpath("//*[@id='" + TabName + "']//tbody/tr/td["+ColumnPosition+"]"));		
		for(int i = 0; i< shareClassColumns.size(); i++) {
			String ShareClassText = shareClassColumns.get(i).getText();
						assertTrue(ShareClassText.startsWith(domicileFilterName) || ShareClassText.contains(domicileFilterName));			
		}	
	}
	
	@Then("^I verify the filtered results on \"([^\"]*)\" tab based on the \"([^\"]*)\" selected filters from \"([^\"]*)\" on \"([^\"]*)\" position$")
	public void iVerifyTheFilteredResultsAU(String TabName, String filterName, String filterType, String ColumnPosition) throws Throwable {
		String filterNameText = driver.findElement(By.xpath("//*[@class='"+filterType+"']//input[@data-name='"+filterName+"']//following-sibling::span[2]")).getText();
		((JavascriptExecutor)driver).executeScript("scroll(0, 250);");
		List <WebElement> shareClassColumns = driver.findElements(By.xpath("//*[@id='" + TabName + "']//tbody/tr/td["+ColumnPosition+"]"));		
		for(int i = 0; i< shareClassColumns.size(); i++) {
			String ShareClassText = shareClassColumns.get(i).getText();
						assertTrue(ShareClassText.startsWith(filterNameText) || ShareClassText.contains(filterNameText));			
		}	
	}	
	
	@Then("^I verify the filtered results on \"([^\"]*)\" tab based on the \"([^\"]*)\" and \"([^\"]*)\" selected filters on \"([^\"]*)\" position$")
	public void iVerifyTheFilteredResults(String TabName, String filterName, String filterText, String ColumnPosition) throws Throwable {
		String filterNameText = driver.findElement(By.xpath("//*[@class='"+filterName+"']//input[@data-name='"+filterText+"']/following-sibling::span[1]")).getText();
		((JavascriptExecutor)driver).executeScript("scroll(0, 250);");
		List <WebElement> shareClassColumns = driver.findElements(By.xpath("//*[@id='" + TabName + "']//tbody//span[text()='"+filterText+"']/parent::td"));
		for(int i = 1; i< shareClassColumns.size(); i++) {
			String ShareClassText = shareClassColumns.get(i).getText();
			assertTrue("ShareClassText: "+ ShareClassText + "filterNameText: " + filterNameText , ShareClassText.startsWith(filterNameText) || ShareClassText.contains(filterNameText));			
		}	
	}	
	
	@Then("^I verify the filtered results on \"([^\"]*)\" tab based on the \"([^\"]*)\" and \"([^\"]*)\" selected filters on \"([^\"]*)\" position for German Site$")
	public void iVerifyTheFilteredResultsDe(String TabName, String filterName, String filterText, String ColumnPosition) throws Throwable {
		String filterNameText = driver.findElement(By.xpath("//*[@class='"+filterName+"']//input[@data-interaction-detail='"+filterText+"']/following-sibling::span[1]")).getText();
		((JavascriptExecutor)driver).executeScript("scroll(0, 250);");
		List <WebElement> shareClassColumns = driver.findElements(By.xpath("//*[@id='" + TabName + "']//tbody//span[text()='"+filterText+"']/parent::td"));
		for(int i = 1; i< shareClassColumns.size(); i++) {
			String ShareClassText = shareClassColumns.get(i).getText();
			assertTrue("ShareClassText: "+ ShareClassText + "filterNameText: " + filterNameText , ShareClassText.startsWith(filterNameText) || ShareClassText.contains(filterNameText));			
		}	
	}	

	@Then("^I click on ClearAll filter button$")
	public void iClickOnClearallFilterButton() throws Throwable {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", FiltersPage.filtersPage(driver).getClearFilterButton());
		assertTrue(FiltersPage.filtersPage(driver).getClearFilterButton().isDisplayed());
		FiltersPage.filtersPage(driver).getClearFilterButton().click();	    
	}

	@Then("^I verify the selected filter checkbox are unchecked$")
	public void iVerifyTheSelectedFilterCheckboxAreUnchecked() throws Throwable {
		assertTrue(FiltersPage.filtersPage(driver).getShareFilterCheckBox().getAttribute("data-interation-type").contains("filter"));
		assertTrue(FiltersPage.filtersPage(driver).getAssetCheckBox().getAttribute("data-interation-type").contains("filter")); 	    
	}

	@Then("^I verify the Funnel count is removed$")
	public void iVerifyTheFunnelCountIsRemoved() throws Throwable {
		assertEquals("", FiltersPage.filtersPage(driver).getFilterNumberBubble().getText());	    
	}

	@Then("^I verify the chips are removed$")
	public void iVerifyTheChipsAreRemoved() throws Throwable {	   
		assertEquals(0,driver.findElements(By.xpath("//*[@class='filter-selections']//*[@class='selection']")).size());
	}

	@Then("^I click on the filter close button$")
	public void iClickOnFilterCloseButton() throws Throwable {
		 FiltersPage.filtersPage(driver).getFilterCloseButton().click();	    
	}

	@Then("^I verify the filters are not expanded$")
	public void iVerifyTheFiltersAreNotExpanded() throws Throwable {
	    assertFalse(ProductListPage.productListPage(driver).isFilterAreaOpen());    
	}
	
	@Then("^I uncheck the selected share class filter$")
	public void i_uncheck_the_first_selected_filter() throws Throwable {
		FiltersPage.filtersPage(driver).getShareFilterCheckBox().click();
	}

	@Then("^I verify the \"([^\"]*)\" message is displayed$")
	public void iVerifyNoResultsDisplayedMessage(String message) throws Throwable {
		String noResultsMessage = FiltersPage.filtersPage(driver).getNoResultsHeader().getText();
	    assertTrue(noResultsMessage.contains(message));
	}	
	
	@Then("^I verify that all filter checkboxes are clear, all filter chips are removed and the number bubble disappears$")
	public void iVerifyFiltersChipsAndFunelCountAfterClearAllFilters() throws Throwable {
		assertFalse(FiltersPage.filtersPage(driver).getFilterNumberBubble().isDisplayed());
		assertEquals(0, driver.findElements(By.xpath("//*[@class='filter-selections']//*[@class='selection']")).size());
	}	
	
	@And("^I select \"([^\"]*)\" filter as \"([^\"]*)\" in the product list page$")
    public void iSelectFilterFromFilterType(String filterType, String filterName) throws Throwable {
    	WebElement filter = FiltersPage.filtersPage(driver).getFilterChkBxFromFilterType(filterType, filterName);
    	filter.click();
    }
	
	@Then("^I select first \"([^\"]*)\" filter checkbox$")
	public void iSelectFirstFilterCheckboxFromFilterType(String filterType) throws Throwable {
		FiltersPage.filtersPage(driver).getFirstFilterChbxFromFilterType(filterType).click();
		selectedShareClassFilter = FiltersPage.filtersPage(driver).getSelectedShareFilters().getText();
	}
	
	/*@Then("^I verify the filtered results on \"([^\"]*)\" tab based on the \"([^\"]*)\" and \"([^\"]*)\" selected Domicile filters on \"([^\"]*)\" position$")
	public void iVerifyTheDomicileFilteredResults(String TabName, String filterName, String filterType, String ColumnPosition) throws Throwable {
	    ((JavascriptExecutor)driver).executeScript("scroll(0, 250);");
		List <WebElement> shareClassColumns = driver.findElements(By.xpath("//*[@id='" + TabName + "']//tbody/tr/td["+ColumnPosition+"]"));		
		for(int i = 0; i< shareClassColumns.size(); i++) {
			String ShareClassText = shareClassColumns.get(i).getText();
						assertTrue(ShareClassText.startsWith(domicileFilterName) || ShareClassText.contains(domicileFilterName));			
		}	
	} */
	
}