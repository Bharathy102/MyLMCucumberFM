package com.publisher.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.publisher.pageobjects.HomePageObject;
import com.publisher.pageobjects.ProductListPage;
import com.publisher.pageobjects.SpeedBumpPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ProductListSteps extends Utility{

	
    private static final String CLASS = "class";
    private static final String DISABLED = "disabled";
    private static final String PAGEINFO = "Showing 1-";
    private static final String PAGEINFODE = "Fonds anzeigen";
    private static final int PAGECOUNT = 100;
    private String EMPTY_WATCHLIST_MSG = "Products & Share Classes added to your watchlist will be shown here";
    private String EMPTY_WATCHLIST_MSG_DE = "Produkte und Anteilsklassen, die Sie Ihrer Beobachtungsliste hinzugefügt haben, werden hier gezeigt";    

	public static String fundNameProductList;
	private static String fundName;
	private static String shareClass;
	int rowSize;
	static String timestamp;
	
	@And("^I click on the products header$")
	public void iClickOnProductsHeader() throws Throwable {
		Thread.sleep(10000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",HomePageObject.homePageObject(driver).getProductsHeader());
		//HomePageObject.homePageObject(driver).getProductsHeader().click();
	}
	
	 @And("^I click on the products header for selected distributor$")
	    public void iClickOnTheProductsHeaderForSelectedDistributor() throws Throwable {
		 Thread.sleep(10000);
			
			
			 if (!getConfigValue().getProperty("distributor_view").isEmpty()) {
				 
				 if(driver.getCurrentUrl().contains("zh-cn") && (!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
					 String targetelementurl = HomePageObject.homePageObject(driver).getProductsHeaderch().getAttribute("href");
				    	driver.get(targetelementurl);
						Thread.sleep(3000);
						}
					else{
						System.out.println("Product link does not exist");
						}
					
				} else {
					System.out.println("distributorView is not configured");
				}	
			
	    }
	
	@And("^I click on the products header for German Site$")
	public void iClickOnProductsHeaderDE() throws Throwable {
		Thread.sleep(10000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",HomePageObject.homePageObject(driver).getProductsHeaderDe());
		//HomePageObject.homePageObject(driver).getProductsHeader().click();
	}
	
	@Then("^I verify the Inclusive of Sales Charge and At Nav should be displayed$")
	public void iverifytheInclusiveofSalesChargeandAtNav() throws Throwable {
		Thread.sleep(3000);
		
		assertTrue(ProductListPage.productListPage(driver).getAtNAVRow().isDisplayed());
		assertTrue(ProductListPage.productListPage(driver).getInclusiveOfSalesChargeRow().isDisplayed());
	    
	}
	
	@And("^I verify the product list page is displayed$")
	public void iVerifyProductListPageIsDisplayed() throws Throwable {
	    assertTrue(ProductListPage.productListPage(driver).getProductListComponent().isDisplayed());
	}
	
	@Then("^I verify Overview tab is displayed$")
	public void iVerifyOverviewTabIsDisplayed() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getOverviewTab().isDisplayed()); 	   
	}
	
	@Then("^I verify the As Of Dates are displayed as per country local on Overview table$")
	public void iVerifyTheAsOfDatesAreDisplayedAsPerCountryLocalOnOverviewTable() throws Throwable {
	    Thread.sleep(2000);
	    List<WebElement> asOfDates = driver.findElements(By.xpath("//*[@id='tab-overview']//td/span[text()='As of']/parent::td"));
	    for (WebElement x : asOfDates) {
	    	String asOfDateUi = x.getText();		
			String[] currentUrl  = driver.getCurrentUrl().split("/");
			verifyLocaleFormattedDate(asOfDateUi, currentUrl[3]);
		}
	}
	
	@And("^I click on the Perfomance Tab$")
	public void iClickOnThePerformanceTav() throws Throwable {
		Thread.sleep(3000);
		//if (!driver.getCurrentUrl().contains("en-gb")) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", ProductListPage.productListPage(driver).getPerformanceTab());
			//ProductListPage.productListPage(driver).getPerformanceTab().click();
			Thread.sleep(3000);
		//}	
	}

	@Then("^I verify the Performance tab is displayed$")
	public void iVerifyThePerformanceTabIsDisplayed() throws Throwable {
		if (!driver.getCurrentUrl().contains("en-gb")) {
			assertTrue(ProductListPage.productListPage(driver).getPerformanceTab().isDisplayed());
		}	
	}
	
	@Then("^I verify the sequence of tabs on Performance section$")
	public void iVerifySequenceOfTabsOnPerf() throws Throwable {
		List <WebElement> tabLinks = ProductListPage.productListPage(driver).getPerformanceTabLinks();
		assertEquals(tabLinks.get(0).getText(), "DISCRETE ROLLING");
		assertEquals(tabLinks.get(1).getText(), "CALENDAR");
		assertTrue(tabLinks.get(2).getText().contains("ANNUALISED"));
		assertEquals(tabLinks.get(3).getText(), "CUMULATIVE");		
	}

	@Then("^I verify the shareclass column is displayed in overview tab$")
	public void iVerifyShareclassIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getShareClassColumn().isDisplayed());	   
	}
	
	@Then("^I verify the FundName column is displayed in overview tab$")
	public void iVerifyFundNameColumnInOverviewTab() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getFundNameColumnOv().isDisplayed());	   
	}

	@Then("^I verify the Distribution column is displayed in overview tab$")
	public void iVerifyDistributionIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getDistTypeColumn().isDisplayed());	    
	}

	@Then("^I verify the NAV column is displayed in overview tab$")
	public void iVerifyNavIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getNavColumn().isDisplayed());	    
	}

	@Then("^I verify the AssetType column is displayed in overview tab$")
	public void iVerifyAssetTypeIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getAssetTypeColumn().isDisplayed());	    
	}

	@Then("^I verify the Distribution Type column is displayed in overview tab$")
	public void iVerifyDistributionTypeIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getDistTypeColumn().isDisplayed());	   
	}

	@Then("^I verify the Ccy column is displayed in overview tab$")
	public void iVerifyCcyIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getCcyColumn().isDisplayed());	    
	}

	@Then("^I verify the As Of column is displayed in overview tab$")
	public void iVerifyAsOfIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getAsOfColumn().isDisplayed());	    
	}

	@Then("^I verify the Domicile column is displayed in overview tab$")
	public void iVerifyDomicileIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getDomicileColumn().isDisplayed());	    
	}

	@Then("^I verify the ISIN column is displayed in overview tab$")
	public void iVerifyISINIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getIsinColumn().isDisplayed());	   
	}

	@Then("^I verify the Key Actions is displayed in overview tab$")
	public void iVerifyKeyActionsIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getkeyActionsColumn().isDisplayed());	   
	}

	@Then("^I verify the WatchList column is displayed for overview tab$")
	public void iVerifyWatchListIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getWatchListColumn().isDisplayed());	    
	}
	
	@Then("^I verify the LastPriceExitPrice column is displayed in overview tab$")
	public void iVerifyLastPriceExitPriceInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getLastPriceColumn().isDisplayed());	    
	}
	
	@Then("^I verify the Entry Price column is displayed in overview tab$")
	public void iVerifyEntryPriceIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getEntryPriceColumn().isDisplayed());	    
	}
	
	@Then("^I verify the Exit Price column is displayed in overview tab$")
	public void iVerifyExitPriceIsDisplayedInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getExitPriceColumn().isDisplayed());	    
	}
	
	@Then("^I verify the APIR code ASX Ticker column is displayed in overview tab$")
	public void iVerifyAPIRCodeASXTickerInOverview() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getAPIRCodeColumn().isDisplayed());	    
	}

	@Then("^I click on the fund name of the first fund on \"([^\"]*)\" of product list page$")
	public void iClickOnFundNameOnProductListPage(String tabName) throws Throwable {
		//WebElement fundNameHeader = driver.findElement(By.xpath("(//*[@data-interaction-detail='Fund Name'])[1]"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fundNameHeader);
		Thread.sleep(3000);
	 	fundName = ProductListPage.productListPage(driver).getFundNameText(tabName).getText();
	 	if (!driver.getCurrentUrl().contains("en-au")) {
	 		shareClass = ProductListPage.productListPage(driver).getShareClassText(tabName).getText();
	 	}else {
	 		System.out.println("No Shareclass is displayed for Product List Australia");
	 	}
	 	//((JavascriptExecutor)driver).executeScript("arguments[0].click();",ProductListPage.productListPage(driver).getFundNameLink(tabName));
	 	ProductListPage.productListPage(driver).getFundNameLink(tabName).click();	    
	}

	@Then("^I verify the product detail page is displayed$")
	public void iVerifyTheProductDetailPageIsDisplayed() throws Throwable {
		if (driver.getCurrentUrl().contains("en-se")) {
			Thread.sleep(5000);
		}		
		String fundNameProductDetial = ProductListPage.productListPage(driver).getFundNameTitle().getText();
		assertEquals(fundName, fundNameProductDetial);
	}
	
	@Then("^I verify the Fund Name column is displayed as sorted by default$")
	public void iVerifyFundNameColumnSortedDefault() throws Throwable {
		String sortValue = ProductListPage.productListPage(driver).getFundNameColumn().getAttribute("aria-sort");
		assertEquals(sortValue, "ascending");
	}

	@Then("^I sort by ShareClass column$")
	public void iSortByShareClassColumn() throws Throwable {
		if (!driver.getCurrentUrl().contains("en-au")) {
			ProductListPage.productListPage(driver).getShareClassColumn().click();
		}else {
			System.out.println("Shareclass column is not authored for Australia product list page:" + driver.getCurrentUrl());
		}
	}

	@Then("^I verify the Share class column is displayed as sorted$")
	public void i_verify_the_Share_class_column_is_displayed_as_sorted() throws Throwable {
		if (!driver.getCurrentUrl().contains("en-au")) {
			String shareClassSortValue = ProductListPage.productListPage(driver).getFundNameColumn().getAttribute("aria-sort");
			assertEquals(shareClassSortValue, "ascending");
		}else {
			System.out.println("Shareclass column is not authored for Australia product list page:" + driver.getCurrentUrl());
		}
	}

	@Then("^I sort by Nav column$")
	public void iSortByNavColumn() throws Throwable {
		ProductListPage.productListPage(driver).getNavColumn().click();
	}

	@Then("^I verify the Nav column is displayed as sorted$")
	public void iVerifyTheNavColumnIsDisplayedAsSorted() throws Throwable {
		String navSortValue = ProductListPage.productListPage(driver).getNavColumn().getAttribute("aria-sort");
		assertEquals(navSortValue, "ascending");
	}
	
	@Then("^I sort by \"([^\"]*)\" column$")
	public void iSortByNavColumn(String columnName) throws Throwable {
		ProductListPage.productListPage(driver).getPlAuColumn(columnName).click();
	}

	@Then("^I verify the \"([^\"]*)\" column is displayed as sorted$")
	public void iVerifyTheNavColumnIsDisplayedAsSorted(String columnName) throws Throwable {
		String navSortValue = ProductListPage.productListPage(driver).getPlAuColumn(columnName).getAttribute("aria-sort");
		assertEquals(navSortValue, "ascending");
	}

	@Then("^I sort by AssetType column$")
	public void iSortByAssetTypeColumn() throws Throwable {
		ProductListPage.productListPage(driver).getAssetTypeColumn().click();
	}

	@Then("^I verify the AssetType column is displayed as sorted$")
	public void iVerifyTheAssettypeColumnIsDisplayedAsSorted() throws Throwable {
		String assetTypeSortValue = ProductListPage.productListPage(driver).getAssetTypeColumn().getAttribute("aria-sort");
		assertEquals(assetTypeSortValue, "ascending");
	}

	@Then("^I sort by Distribution Type column$")
	public void iSortByDistributionTypeColumn() throws Throwable {
		ProductListPage.productListPage(driver).getDistTypeColumn().click();
	}

	@Then("^I verify the Distribution Type column is displayed as sorted$")
	public void iVerifyTheDistTypeColumnIsDisplayed() throws Throwable {
		String distTypeSortValue = ProductListPage.productListPage(driver).getDistTypeColumn().getAttribute("aria-sort");
		assertEquals(distTypeSortValue, "ascending");
	}

	@Then("^I sort by Ccy column$")
	public void iSortByCcyColumn() throws Throwable {
		ProductListPage.productListPage(driver).getCcyColumn().click();
	}

	@Then("^I verify the Ccy column is displayed as sorted$")
	public void iVerifyTheCcyColumnIsDisplayedAsSorted() throws Throwable {
		String ccySortValue = ProductListPage.productListPage(driver).getCcyColumn().getAttribute("aria-sort");
		assertEquals(ccySortValue, "ascending");	
	}

	@Then("^I sort by AsOf column$")
	public void iSortByAsOfColumn() throws Throwable {
		ProductListPage.productListPage(driver).getAsOfColumn().click();
	}

	@Then("^I verify the AsOf column is displayed as sorted$")
	public void iVerifyTheAsofColumnIsDisplayedAsSorted() throws Throwable {
		String asOfSortValue = ProductListPage.productListPage(driver).getAsOfColumn().getAttribute("aria-sort");
		assertEquals(asOfSortValue, "ascending");
	}

	@Then("^I sort by Domicile column$")
	public void iSortByDomicileColumn() throws Throwable {
		ProductListPage.productListPage(driver).getDomicileColumn().click();
	}

	@Then("^I verify the Domicile column is displayed as sorted$")
	public void iVerifyTheDomicileColumnIsDisplayedAsSorted() throws Throwable {
		String domicileSortValue = ProductListPage.productListPage(driver).getDomicileColumn().getAttribute("aria-sort");
		assertEquals(domicileSortValue, "ascending");
	}

	@Then("^I sort by ISIN column$")
	public void iSortByISISNColumn() throws Throwable {
		ProductListPage.productListPage(driver).getIsinColumn().click();	
	}

	@Then("^I verify the ISIN column is displayed as sorted$")
	public void IVerifyTheIsinColumnIsDisplayedAsSorted() throws Throwable {
		String isinSortValue = ProductListPage.productListPage(driver).getIsinColumn().getAttribute("aria-sort");
		assertEquals(isinSortValue, "ascending");
	}
	
	@Then("^I verify the pagination info on top of product list component on \"([^\"]*)\" tab$")
	public void iVerifyTheTopPaginationInfo(String tabName) throws Throwable {
		String infoText = ProductListPage.productListPage(driver).getTopPageInfo(tabName).getText();
		assertTrue(infoText.contains(PAGEINFO));
		assertTrue(infoText.contains("Funds"));
		System.out.println("infoText: " + infoText);
		String [] numbers = infoText.split(" ");
		//System.out.println("Funds: " + numbers[3]);
		String [] range = numbers[1].split("-");
		System.out.println("range: " + range[1]);
		int fundCount = Integer.parseInt(range[1]);
		int totalFund = ProductListPage.productListPage(driver).getTotalFunds(tabName).size();
		assertEquals(fundCount, totalFund);
	}
	
	@Then("^I verify the pagination info on top of product list component on \"([^\"]*)\" tab for German Site$")
	public void iVerifyTheTopPaginationInfoDe(String tabName) throws Throwable {
		String infoText = ProductListPage.productListPage(driver).getTopPageInfo(tabName).getText();
		assertTrue("inforText:" + infoText, infoText.contains(PAGEINFODE));
		System.out.println("infoText: " + infoText);
		String [] numbers = infoText.split(" ");
		//System.out.println("Funds: " + numbers[3]);
		String [] range = numbers[0].split("-");
		System.out.println("range: " + range[1]);
		int fundCount = Integer.parseInt(range[1]);
		int totalFundCount = Integer.parseInt(numbers[2]);
		int totalFund = ProductListPage.productListPage(driver).getTotalFunds(tabName).size();
		assertEquals(fundCount, totalFund);
		
		//Verify total number of funds in PL page
		System.out.println("Total fund count: " +totalFundCount);
		int totalFundlinks = 0;
		String paginationArrow = ProductListPage.productListPage(driver).getPaginationNextArrow(tabName).getAttribute("class");
		do {
			totalFundlinks = totalFundlinks + ProductListPage.productListPage(driver).getTotalFunds(tabName).size();			
			paginationArrow = ProductListPage.productListPage(driver).getPaginationNextArrow(tabName).getAttribute("class");		
			if (!paginationArrow.contains("disabled")) {
				ProductListPage.productListPage(driver).getPaginationNextArrow(tabName).click();
    			Thread.sleep(3000);
			}else {
				break;
			}
		}while (!paginationArrow.contains("disabled"));
		System.out.println("totalFundCount: " + totalFundCount);
		System.out.println("totalFundlinks: " + totalFundlinks);
		assertEquals(totalFundCount, totalFundlinks);
	} 
	
	
	@Then("^I verify the pagination info on top of product list component in performance tab$")
	public void iVerifyTheTopPaginationInfoInPerTab() throws Throwable {
		String infoText = ProductListPage.productListPage(driver).getTopPageInfoDiscrete().getText();
		assertTrue(infoText.contains(PAGEINFO));		
	}
	
	@Then("^I verify the pagination info on top of product list component in performance tab for German Site$")
	public void iVerifyTheTopPaginationInfoInPerTabDe() throws Throwable {
		String infoText = ProductListPage.productListPage(driver).getTopPageInfoDiscrete().getText();
		assertTrue(infoText.contains(PAGEINFODE));		
	}

	@Then("^I verify that default rows per page is displayed with (\\d+) index$")
	public void IVerifyThatDefaultRowsPerPageIsDisplayed(int index) throws Throwable {
		WebElement selectOptions = driver.findElement(By.xpath("(//*[@class='form-control form-control-sm'])[" + index + "]"));
		Select select = new Select(selectOptions);
		
		if (driver.getCurrentUrl().contains("en-au")) {
			assertTrue(select.getFirstSelectedOption().getText().contains("All"));
		}else {
			assertTrue(select.getFirstSelectedOption().getText().contains("25"));
		}
			
	}

	@Then("^I verify the dropdown contains 10 25 50 and 100 in Overview section$")
	public void iVerifyTheDropDownList() throws Throwable {
		List<WebElement> paginationOptions = ProductListPage.productListPage(driver).getPaginationOptions();
		String[] expectedPageNumbers = new String[] {"10","25", "50", "100"};
		for (int i=0; i<4; i++) {
			assertTrue(paginationOptions.get(i).getText().contains(expectedPageNumbers[i]));			
		}	
	 }
	
	 @Then("^I verify the dropdown contains 10 25 50 100 and \"([^\"]*)\" in Overview section$")
	    public void iVerifyTheDropdownContains102550100AndSomethingInOverviewSection(String filterOption) throws Throwable {
		 List<WebElement> paginationOptions = ProductListPage.productListPage(driver).getPaginationOptions();
			String[] expectedPageNumbers = new String[] {"10","25", "50", "100",filterOption};
			for (int i=0; i<5; i++) {
				assertTrue(paginationOptions.get(i).getText().contains(expectedPageNumbers[i]));			
			}	
	    }
	 @Then("^I verify the dropdown contains 10 25 50 100 and \"([^\"]*)\" in Performance section$")
	    public void iVerifyTheDropdownContains102550100AndSomethingInPerformanceSection(String filterOption) throws Throwable {
		 List<WebElement> perfPaginationOptions = ProductListPage.productListPage(driver).getPerfPaginationOptions();
			String[] expectedPageNumbers = new String[] {"10","25", "50", "100",filterOption};
			for (int i=0; i<5; i++) {
				assertTrue(perfPaginationOptions.get(i).getText().contains(expectedPageNumbers[i]));			
			}	
	    
	    }
	@Then("^I verify the dropdown contains 10 25 50 and 100 in Performance section$")
	public void iVerifyTheDropDownListInPerfSection() throws Throwable {
		List<WebElement> perfPaginationOptions = ProductListPage.productListPage(driver).getPerfPaginationOptions();
		String[] expectedPerfPageNumbers = new String[] {"10","25", "50", "100"};
		for (int i=0; i<4; i++) {
			assertTrue(perfPaginationOptions.get(i).getText().contains(expectedPerfPageNumbers[i]));			
		}	
	 }
	
	@Then("^I verify that I can click on the Next button$")
	public void IVerifyThatICanClickOnTheNextButton() throws Throwable {
		Thread.sleep(6000);
        WebElement next = ProductListPage.productListPage(driver).getNextButton();
        WebElement nextContainer = ProductListPage.productListPage(driver).getNextButtonContainer();
        if (!nextContainer.getAttribute(CLASS).contains(DISABLED)) {
        	((JavascriptExecutor)driver).executeScript("arguments[0].click();", next);
        	//next.click();
        }else if(nextContainer.getAttribute(CLASS).contains(DISABLED)) {
            System.out.println("The Next Button is Disabled");
            System.out.println("The Next Button is Disabled");
        } else {
        	System.out.println("Clicking Issue With Next Button");
        }
	}
	
	
	
	 @Then("^I verify that I can not click on the Next button on \"([^\"]*)\" tab$")
	    public void iVerifyThatICanNotClickOnTheNextButtonOnSomethingTab(String tabName) throws Throwable {
		 Thread.sleep(6000);
	        if(tabName.contains("Overview")) {
	        	WebElement nextContainer = ProductListPage.productListPage(driver).getNextButtonContainer();
		        assertTrue(nextContainer.getAttribute(CLASS).contains(DISABLED));
	        }else{
	        	 WebElement nextContainer = ProductListPage.productListPage(driver).getNextButtonContainerPerf();
	        	 assertTrue(nextContainer.getAttribute(CLASS).contains(DISABLED));
	        }
	        
	    }
	 @Then("^I verify that I can not click on the Previous button on \"([^\"]*)\" tab$")
	    public void iVerifyThatICanNotClickOnThePreviousButtonOnSomethingTab(String tabName) throws Throwable {
		 Thread.sleep(6000);
		 if(tabName.contains("Overview")) {
			 	WebElement previousContainer = ProductListPage.productListPage(driver).getPreviousButtonContainer();
		        assertTrue(previousContainer.getAttribute(CLASS).contains(DISABLED));
	        }else{
	        	WebElement previousContainer = ProductListPage.productListPage(driver).getPreviousButtonContainerPerf();
	        	 assertTrue(previousContainer.getAttribute(CLASS).contains(DISABLED));
	        }
	       
	    }
	 
	@Then("^I verify that I can click on the Previous button$")
	public void IVerifyThePreviousButtonOverviewSection() throws Throwable {
		Thread.sleep(6000);
        WebElement previous = ProductListPage.productListPage(driver).getPreviousButton();
        WebElement previousContainer = ProductListPage.productListPage(driver).getPreviousButtonContainer();
        if (!previousContainer.getAttribute(CLASS).contains(DISABLED)) {
        	((JavascriptExecutor)driver).executeScript("arguments[0].click();", previous);
        	//previous.click();
        }else if(previousContainer.getAttribute(CLASS).contains(DISABLED)) {
            System.out.println("The Previous Button is Disabled");
            System.out.println("The Previous Button is Disabled");
        } else {
        	System.out.println("Clicking Issue With Previous Button");
        }
	}
	
	@Then("^I verify that I can click on the Next button on Performance section$")
	public void IVerifyTheNextButtonPerfSection() throws Throwable {
		Thread.sleep(5000);
        WebElement next = ProductListPage.productListPage(driver).getNextButtonPerfTab();
        WebElement nextContainer = ProductListPage.productListPage(driver).getNextButtonContainerPerf();
        if (!nextContainer.getAttribute(CLASS).contains(DISABLED)) {
            next.click();
        }
	}

	@Then("^I verify that I can click on the Previous button on Performance section$")
	public void IVerifyThePreviousButtonPerfSection() throws Throwable {
		Thread.sleep(5000);
        WebElement previous = ProductListPage.productListPage(driver).getPreviousButtonPerf();
        WebElement previousContainer = ProductListPage.productListPage(driver).getPreviousButtonContainerPerf();
        if (!previousContainer.getAttribute(CLASS).contains(DISABLED)) {
            previous.click();
        }
	}

	@Then("^I set the Rows per page dropdown to \"([^\"]*)\"$")
	public void ISetTheRowsPerPageDropdownTo(String pageSize) throws Throwable {
        List<WebElement> paginationOptions = ProductListPage.productListPage(driver).getPaginationOptions();
        WebElement option = paginationOptions.stream().filter(o -> o.getText().equals(pageSize))
                .collect(Collectors.toList()).get(0);
        option.click();
	}  
       
    @Then("^I verify that the Watchlist header Icon is displayed$")
    public void iVerifyThatTheWatchlistHeaderIconIsDisplayed() throws Throwable {
		assertTrue(SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().isDisplayed());
    }	

    @Then("^I verify that a message indicate that there is no product currently in watchlist$")
    public void iVerifyThatAMessageThatIsNoProductInWatchlist() throws Throwable {
    	Thread.sleep(3000);
    	SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();
    	Thread.sleep(15000);
        String noItemMessage = ProductListPage.productListPage(driver).getWatchlistNoItem().getText();
        System.out.println();
        Thread.sleep(3000);
        if (driver.getCurrentUrl().contains("de-de")) {
        	assertEquals(EMPTY_WATCHLIST_MSG_DE, noItemMessage);
        }else {
        	assertEquals(EMPTY_WATCHLIST_MSG, noItemMessage);
        }
        Thread.sleep(3000);
    }

    @Then("^I verify that Add to Watchlist button is displayed for the shareclass$")
    public void iVerifyAddToWatchlistButtonIsDisplayed() throws Throwable {
    	assertTrue(ProductListPage.productListPage(driver).getAddToWatchlistButton().isDisplayed());
 
    }
    
    @Then("^I click on the Add to Watchlist button on \"([^\"]*)\" tab$")
    public void iClickOnTheAddToWatchlistButton(String tabName) throws Throwable {
    	Thread.sleep(3000);
    	fundName = ProductListPage.productListPage(driver).getFundNameText(tabName).getText();
    	shareClass = ProductListPage.productListPage(driver).getShareClassText(tabName).getText();
    	ProductListPage.productListPage(driver).getAddToWatchlistButton().click();
    }
    
    @Then("^I click on the Add to Watchlist button on \"([^\"]*)\" tab for German site$")
    public void iClickOnTheAddToWatchlistButtonDe(String tabName) throws Throwable {
    	Thread.sleep(3000);
    	fundName = ProductListPage.productListPage(driver).getFundNameText(tabName).getText();
    	shareClass = ProductListPage.productListPage(driver).getShareClassText(tabName).getText();
    	ProductListPage.productListPage(driver).getAddToWatchlistBtnDe().click();
    	Thread.sleep(3000);
    }

    @Then("^I verify that Watchlist has the (\\d+) number of Fund added$")
    public void iVerifyThatWatchlistHasTheCorrectNumberOfFundAdded(int fundCount) throws Throwable {
    	if (!driver.getCurrentUrl().contains("en-au")) {
    		Thread.sleep(3000);
    		List<WebElement> numOfFund = driver.findElements(By.xpath("//*[@class='item']//*[@class='title']"));
    		assertEquals(fundCount, numOfFund.size());
    	}else {
    		System.out.println("Australian products has only one share class");
    	}
    }
   
    @Then("^I click on the Watchlist header icon$")
    public void iClickOnTheWatchlistHeaderIcon() throws Throwable {
    	SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();       
    }

    @Then("^I verify the watchlist has View Detail and Clear List buttons$")
    public void iVerifyWatchlistViewDetailAndClearListButtons() throws Throwable {
    	Thread.sleep(3000);
    	SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click(); 
    	Thread.sleep(5000);
    	assertTrue(ProductListPage.productListPage(driver).getViewDetailsButton().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getClearListButton().isDisplayed());
    }
    

    @Then("^I verify the watchlist has View Detail and Clear List buttons for German site$")
    public void iVerifyWatchlistViewDetailAndClearListButtonsDE() throws Throwable {
    	Thread.sleep(3000);
    	SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click(); 
    	assertTrue(ProductListPage.productListPage(driver).getViewDetailsButtonDe().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getClearListButtonDe().isDisplayed());
    }

    @Then("^I verify that the Watchlist has the correct fund added$")
    public void iVerifyTheWatchlistHasTheCorrectFund() throws Throwable {
    	SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();
        String addedItem = ProductListPage.productListPage(driver).getWatchlistItemFund().getText();
        assertEquals(fundName, addedItem);
    }

    @Then("^I verify that the Watchlist has the correct shareclass added$")
    public void iVerifyTheWatchlistHasCorrectShareclass() throws Throwable {
    	SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();
    	//Commented below code as it is out of scope now
        //String addedItem = ProductListPage.productListPage(driver).getWatchlistShareClass().getText();  
        //assertEquals(shareClass, addedItem);
    }

    @Then("^I expand the filter icon$")
    public void iExpandTheFilterIcon() throws Throwable {
    	// To move away the cursor from watchlist window to make filter icon visible
    	ProductListPage.productListPage(driver).getOverviewTab().click();
    	Thread.sleep(3000);
    	ProductListPage.productListPage(driver).getFilterButton().click();
    }

    @Then("^I select the watchlist filter$")
    public void iSelectTheWatchlistFilter() throws Throwable {
       Thread.sleep(3000);
       ProductListPage.productListPage(driver).getWatchlistFilter().click();
    }

    @Then("^I verify the only watchlist products are displayed$")
    public void iVerifyTheOnlyWatchlistProductsAreDisplayed() throws Throwable {
    	 List<WebElement> fundRowLinks = driver.findElements(By.xpath("//*[@id='overview-table']/thead/tr"));
    	assertEquals(fundRowLinks.size(), 1);
    }

    @Then("^I click on fund link from Watchlist view$")
    public void iClickOnFundLinkFromWatchlistView() throws Throwable {
    	SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();
    	Thread.sleep(3000);
    	ProductListPage.productListPage(driver).getWatchlistItemFund().click();
    }

    @Then("^I verify the fund detail page is displayed$")
    public void iVerifyTheFundDetailPageIsDisplayed() throws Throwable {
    	Thread.sleep(15000);
    	String actualFundName = ProductListPage.productListPage(driver).getFundNameTitle().getText();
    	assertEquals(fundName, actualFundName);
    }
    
    //Key Actions
    
    @And("^I click on Key Actions options$")
    public void iClickOnKeyActionsOptions() throws Throwable {
    	if((!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
    	Thread.sleep(3000);
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();", ProductListPage.productListPage(driver).getKeyActionButton());
    	//ProductListPage.productListPage(driver).getKeyActionButton().click();
    	}else{
			System.out.println("Not applicable for selected distributor");
        }
    }

    @Then("^I verify the print option is displayed in KeyActions menu$")
    public void iVerifyThePrintOptionIsDisplayedInKeyactionsMenu() throws Throwable {
    	Thread.sleep(5000);
    	assertTrue(ProductListPage.productListPage(driver).getPrintLink().isDisplayed());
    }
    
    @Then("^I verify the Email Share option is displayed in KeyActions menu$")
    public void iVerifyTheEmailShareOptionIsDisplayed() throws Throwable {
    	Thread.sleep(3000);
    	assertTrue(ProductListPage.productListPage(driver).getEmailShare().isDisplayed());     
    }
    
    @Then("^I click on Email share link from KeyActions menu$")
    public void iClickOnEmailShareLinkFromKeyactionsMenu() throws Throwable {
    	
    	ProductListPage.productListPage(driver).getEmailShare().click();
    }

    @Then("^I verify the email model window is displayed$")
    public void iVerifyTheEmailModelWindowIsDisplayed() throws Throwable {
    	Thread.sleep(3000);
    	assertTrue(ProductListPage.productListPage(driver).getGmailModelWindow().isDisplayed());
    }

    @Then("^I verify the email fields on email window$")
    public void iVerifyTheEmailFieldsOnEmailWindow() throws Throwable {
    	assertTrue(ProductListPage.productListPage(driver).getToEmailInputField().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getFromEmailInputField().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getSubjectInputtField().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getMessageInputField().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getSubmitButton().isDisplayed());
    	ProductListPage.productListPage(driver).getEmailCloseButton().click();    	
    	Thread.sleep(3000);
    }
    
    @Then("^I verify the To Email field in the email window$")
    public void iVerifyTheMandatoryFieldsInTheEmailWindow() throws Throwable {
    	if((!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
    	ProductListPage.productListPage(driver).getSubmitButton().click(); 
    	}else{
			System.out.println("Not applicable for selected distributor");
        }
    }
    
    @Then("^I verify the DownLoad Excel is displayed in KeyActions menu$")
    public void iVerifyTheDownLoadExcelIsDisplayed() throws Throwable {
    	if((!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
    	assertTrue(ProductListPage.productListPage(driver).getDownloadExcelLink().isDisplayed());
    	}else{
			System.out.println("Not applicable for selected distributor");
        }
    }
    
    @Then("^I verify the Facebook option is displayed in KeyActions menu$")
    public void iVerifyTheFacebookOptionIsPresentonPL() throws Throwable {
    	Thread.sleep(3000);
    	try {
    		if (ProductListPage.productListPage(driver).getFacebookLinkPL().isEnabled()){
    			assertTrue(ProductListPage.productListPage(driver).getFacebookLinkPL().getAttribute("href").contains("products"));
    		}    			
    	}catch (Exception ex){
    		System.out.println("Facebook option is not authored");
    	}	
    }

    @Then("^I verify the Twitter option is displayed in KeyActions menu$")
    public void iVerifyTheTweeterOptionIsPresentonPL() throws Throwable {
    	Thread.sleep(3000);
    	try {
    		if (ProductListPage.productListPage(driver).getTwitterLinkPL().isDisplayed()){
    			assertTrue(ProductListPage.productListPage(driver).getTwitterLinkPL().getAttribute("href").contains("products"));
    		}      		
    	}catch (Exception ex){
    		System.out.println("Twitter option is not authored");
    	}  
    }

    @Then("^I verify the LinkedIn option is displayed in KeyActions menu$")
    public void iVerifyTheLinkedInOptionIsPresentonPL() throws Throwable {
    	Thread.sleep(3000);
    	try {
    		if (ProductListPage.productListPage(driver).getLinkedInLinkPL().isDisplayed()){
    			assertTrue(ProductListPage.productListPage(driver).getLinkedInLinkPL().getAttribute("href").contains("products"));
    		}      		
    	}catch (Exception ex){
    		System.out.println("LinkedIn option is not authored");
    	} 
    }
    
    /* Tooltip */    
    
    
    @Then("^I verify the tooltip for Overview columns$")
    public void iVerifyTheTooltipForOverviewColumns() throws Throwable {
    	 List<WebElement> toolTipOverview = driver.findElements(By.xpath("//th[@aria-controls='overview-table']/span/i[@class='lm-icons ico-info']"));
    	 System.out.println("Tooltip for Overview section:");
    	 verifyToolTip(toolTipOverview);     	 
    }
    
    @Then("^I verify the tooltip for Performance Discrete columns$")
    public void iVerifyTheTooltipForPerfDiscreteColumns() throws Throwable {
    	 List<WebElement> toolTipDiscrete = driver.findElements(By.xpath("//th[@aria-controls='discrete-table']/span/i[@class='lm-icons ico-info']"));
    	 System.out.println("Tooltip for Performance Discrete Rolling section:");
    	 verifyToolTip(toolTipDiscrete);     	 
    }
    
    @Then("^I verify the tooltip for Performance Calender columns$")
    public void iVerifyTheTooltipForPerfCalendarColumns() throws Throwable {
    	 List<WebElement> toolTipCalendar = driver.findElements(By.xpath("//th[@aria-controls='calendar-table']/span/i[@class='lm-icons ico-info']"));
    	 System.out.println("Tooltip for Performance Calender section:");
    	 verifyToolTip(toolTipCalendar);     	 
    }
    
    @Then("^I verify the tooltip for Performance Annualised columns$")
    public void iVerifyTheTooltipForPerfAnnualisedColumns() throws Throwable {
    	 List<WebElement> toolTipAnnualised = driver.findElements(By.xpath("//th[@aria-controls='annualized-table']/span/i[@class='lm-icons ico-info']"));
    	 System.out.println("Tooltip for Performance Annualised section:");
    	 verifyToolTip(toolTipAnnualised);     	 
    }
    
    @Then("^I verify the tooltip for Performance Cucumlative columns$")
    public void iVerifyTheTooltipForPerfCumulativeColumns() throws Throwable {
     	 List<WebElement> toolTipCumulative = driver.findElements(By.xpath("//th[@aria-controls='cumulative-table']/span/i[@class='lm-icons ico-info']"));
    	 System.out.println("Tooltip for Performance Cucumlative section:");
    	 verifyToolTip(toolTipCumulative);     	 
    }
    
    @Then("^I click on Discrete Rolling Tab on Performance section$")
    public void iClickOnDiscreteRollingTabOnPerformance() throws Throwable {
    	ProductListPage.productListPage(driver).getDiscreteRollingTab().click();
    }

    @Then("^I click on Calender Tab on Performance section$")
    public void iClickOnCalenderTabOnPerformance() throws Throwable {
    	ProductListPage.productListPage(driver).getCalendarTab().click();	
    }

    @Then("^I click on Annualised Tab on Performance section$")
    public void iClickOnAnnualisedTabOnPerformance() throws Throwable {
        ProductListPage.productListPage(driver).getAannualisedTab().click();
    }

    @Then("^I click on Cucumlative Tab in Performance section$")
    public void iClickOnCucumlativeTabInPerformance() throws Throwable {
    	ProductListPage.productListPage(driver).getCumulativeTab().click();
    }
    
	public void verifyToolTip(List<WebElement> toolTipIcons) throws IOException {
		for (int i = 0; i < toolTipIcons.size(); i++) {
				if (toolTipIcons.get(i).isDisplayed()) {
				assertNotNull(toolTipIcons.get(i).getAttribute("data-original-title"));
				System.out.println(toolTipIcons.get(i).getAttribute("data-original-title"));
			}	
		}
	}
	
	@Then("^I click on KeyActions button$")
	public void iClickOnKeyactionsButton() throws Throwable {
		ProductListPage.productListPage(driver).getKeyActionLink().click();		
	}

	@Then("^I verify the KeyActions model window is opened$")
	public void iVerifyTheKeyactionsModelWindowIsOpened() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getKeyActionsPopupDisplay().isDisplayed());
	}

	@Then("^I verify the the link in KeyActions window$")
	public void iVerifyTheKeyactionTitleAndTheLink() throws Throwable {
		Thread.sleep(5000);
		assertTrue(ProductListPage.productListPage(driver).getkeyActionLink().isDisplayed());
		String url = ProductListPage.productListPage(driver).getkeyActionLink().getAttribute("href");
		String message = BrokenLinksVerificationSteps.verifyBrokenLink(url);
		System.out.println(url + " : " + message);
		assertEquals(message, BrokenLinksVerificationSteps.HTTP_CODE_200);
	}
	
	@And("^I click on close button on KeyActions window$")
	public void iClickOnCloseButtonOnKeyActionsWindow() throws Throwable {
		ProductListPage.productListPage(driver).getKeyAcnCloseButton().click();		
	}
	
	@Then("^I verify the KeyActions model window is closed$")
	public void iVerifyKeyActionsModelIsClosed() throws Throwable {
		assertFalse(ProductListPage.productListPage(driver).getKeyActionsPopupDisplay().isDisplayed());		
	}
	
	@Then("^I verify the broken links on overview tab$")
	public void iVerifyBrokenLinksOnOverviewTab() throws Throwable {
		
		if(!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1")){
			
		
		
		List<WebElement> paginationOptions = ProductListPage.productListPage(driver).getPaginationOptions();
        WebElement option = paginationOptions.stream().filter(o -> o.getText().equals("100"))
        		.collect(Collectors.toList()).get(0);
        option.click();
        
		WebElement next = ProductListPage.productListPage(driver).getNextButton();
        WebElement nextContainer = ProductListPage.productListPage(driver).getNextButtonContainer();
        int fundCount = 0;
            
		while (!nextContainer.getAttribute(CLASS).contains(DISABLED)) {
	
			List<WebElement> links = driver.findElements(By.xpath("//*[@id='overview-table']/tbody/tr/td[1]/a"));
			Iterator<WebElement> it = links.iterator();
			while (it.hasNext()) {
				String url = it.next().getAttribute("href");
				String message = null;
				try {

					message = BrokenLinksVerificationSteps.verifyBrokenLink(url);
					fundCount++;
					System.out.println(fundCount + " : " + url + " : " + message);
					if (!message.contains(BrokenLinksVerificationSteps.HTTP_CODE_200)) {
						DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
						String txt = dateFormat.format(new Date()).toString();
						txt = txt.replaceAll(":", "");
						File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+ "\\target\\Screenshots\\" + txt + ".png"));
						Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\target\\Screenshots\\" + txt + ".png");
					}
				} catch (NoSuchElementException e) {
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			next.click();
			Thread.sleep(5000);
		}
		
	}
	}
	
	@Then("^I verify the columns on Discrete Rolling tab on Performance section$")
	public void iVerifyTheColumnsOnDiscreteRollingTab() throws Throwable {
		Thread.sleep(5000);
		ProductListPage.productListPage(driver).getPerfFundHeader("discrete-table_wrapper").isDisplayed();
		if (!driver.getCurrentUrl().contains("en-au")){
			ProductListPage.productListPage(driver).getPerfShareHeader("discrete-table_wrapper").isDisplayed();
		} else {
			System.out.println("Share Class Column is not authored for Australia Product List page: " + driver.getCurrentUrl());
		}
		ProductListPage.productListPage(driver).getPerfIncDateHeader("discrete-table_wrapper").isDisplayed();
		if (driver.getCurrentUrl().contains("en-au")){
			ProductListPage.productListPage(driver).getPerfAPIRCodeColumn("discrete-table_wrapper").isDisplayed();
		} else {
			ProductListPage.productListPage(driver).getPerfIsinHeader("discrete-table_wrapper").isDisplayed();
		}
		ProductListPage.productListPage(driver).getPerfIncDateHeader("discrete-table_wrapper").isDisplayed();
		ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "1 Year").isDisplayed();
		ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "2 Year").isDisplayed();
		ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "3 Year").isDisplayed();
		ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "4 Year").isDisplayed();
		ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "5 Year").isDisplayed();
		
		String uiAsOfDate = driver.findElement(By.xpath("//*[@id='discrete-table']/tbody/tr[2]/td[9]")).getText();
		System.out.println("Product List Discrete headers with AsOfDate: " + uiAsOfDate + "are: ");
		String uiOneYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "1 Year").getText();
		System.out.println(uiOneYearDiscHeader + ", ");
		assertTrue(ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "1 Year").isDisplayed());
		//String calcOneYearDiscHeader = calcDiscHeaderDate(uiAsOfDate, 1);
		//assertEquals(uiOneYearDiscHeader, calcOneYearDiscHeader);
		
		String uiTwoYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "2 Year").getText();
		System.out.println(uiTwoYearDiscHeader + ", ");
		assertTrue(ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "2 Year").isDisplayed());
		//String calcTwoYearDiscHeader = calcDiscHeaderDate(uiAsOfDate, 2);
		//assertEquals(uiTwoYearDiscHeader, calcTwoYearDiscHeader);
		
		String uiOThreeYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "3 Year").getText();
		System.out.println(uiOThreeYearDiscHeader + ", ");
		assertTrue(ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "3 Year").isDisplayed());
		//String calcThreeYearDiscHeader = calcDiscHeaderDate(uiAsOfDate, 3);
		//assertEquals(uiOThreeYearDiscHeader, calcThreeYearDiscHeader);		
		
		String uiFourYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "4 Year").getText();
		System.out.println(uiFourYearDiscHeader + ", ");
		assertTrue(ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "4 Year").isDisplayed());
		//String calcFourYearDiscHeader = calcDiscHeaderDate(uiAsOfDate, 4);
		//assertEquals(uiFourYearDiscHeader, calcFourYearDiscHeader);		

		String uiFiveYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "5 Year").getText();
		System.out.println(uiFiveYearDiscHeader + ", ");
		assertTrue(ProductListPage.productListPage(driver).getDiscreteYearHeader("discrete-table_wrapper", "5 Year").isDisplayed());
		//String calcFiveYearDiscHeader = calcDiscHeaderDate(uiAsOfDate, 5);
		//assertEquals(uiFiveYearDiscHeader, calcFiveYearDiscHeader);		
	}

	@Then("^I verify the columns on Calendar tab on Performance section$")
	public void iVerifyTheColumnsOnCalendarTab() throws Throwable {
		Thread.sleep(5000);
		ProductListPage.productListPage(driver).getPerfFundHeader("calendar-table_wrapper").isDisplayed();
		if (!driver.getCurrentUrl().contains("en-au")){
			ProductListPage.productListPage(driver).getPerfShareHeader("calendar-table_wrapper").isDisplayed();
		} else {
			System.out.println("Share Class Column is not authored for Australia Product List page: " + driver.getCurrentUrl());
		}	
		ProductListPage.productListPage(driver).getPerfIncDateHeader("calendar-table_wrapper").isDisplayed();		
		if (driver.getCurrentUrl().contains("en-au")){
			ProductListPage.productListPage(driver).getPerfAPIRCodeColumn("calendar-table_wrapper").isDisplayed();
		} else {
			ProductListPage.productListPage(driver).getPerfIsinHeader("calendar-table_wrapper").isDisplayed();
		}	
		
		ProductListPage.productListPage(driver).getPerfIncDateHeader("calendar-table_wrapper").isDisplayed();
		String uiAsOfDate = null;
		if (driver.getCurrentUrl().contains("en-au")){
			uiAsOfDate = driver.findElement(By.xpath("//*[@id='calendar-table_wrapper']//tbody/tr[2]/td[8]")).getText();
		}else {
			uiAsOfDate = driver.findElement(By.xpath("//*[@id='calendar-table_wrapper']//tbody/tr[2]/td[9]")).getText();
		}
		String uiOneYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("calendar-table_wrapper", "1 Yeare").getText();
		String calcOneYearDiscHeader = ProductListSteps.calcCalendarHeader(uiAsOfDate, 0);
		assertEquals(uiOneYearDiscHeader, calcOneYearDiscHeader);
		
		String uiTwoYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("calendar-table_wrapper", "2 Year").getText();
		String calcTwoYearDiscHeader = ProductListSteps.calcCalendarHeader(uiAsOfDate, 1);
		assertEquals(uiTwoYearDiscHeader, calcTwoYearDiscHeader);
		
		String uiThreeYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("calendar-table_wrapper", "3 Year").getText();
		String calcThreeYearDiscHeader = ProductListSteps.calcCalendarHeader(uiAsOfDate, 2);
		assertEquals(uiThreeYearDiscHeader, calcThreeYearDiscHeader);
		
		String uiFourYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("calendar-table_wrapper", "4 Year").getText();
		String calcFourYearDiscHeader = ProductListSteps.calcCalendarHeader(uiAsOfDate, 3);
		assertEquals(uiFourYearDiscHeader, calcFourYearDiscHeader);
		
		String uiFiveYearDiscHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("calendar-table_wrapper", "5 Year").getText();
		String calcFiveYearDiscHeader = ProductListSteps.calcCalendarHeader(uiAsOfDate, 4);
		assertEquals(uiFiveYearDiscHeader, calcFiveYearDiscHeader);		
	
	}

	@Then("^I verify the columns on Annualised tab on Performance section$")
	public void iVerifyTheColumnsOnAnnualisedTab() throws Throwable {
		Thread.sleep(5000);
		ProductListPage.productListPage(driver).getPerfFundHeader("annualized-table_wrapper").isDisplayed();
		if (!driver.getCurrentUrl().contains("en-au")){
			ProductListPage.productListPage(driver).getPerfShareHeader("annualized-table_wrapper").isDisplayed();
		} else {
			System.out.println("Share Class Column is not authored for Australia Product List page: " + driver.getCurrentUrl());
		}		
		ProductListPage.productListPage(driver).getPerfIncDateHeader("annualized-table_wrapper").isDisplayed();
		if (driver.getCurrentUrl().contains("en-au")){
			ProductListPage.productListPage(driver).getPerfAPIRCodeColumn("annualized-table_wrapper").isDisplayed();
		} else {
			ProductListPage.productListPage(driver).getPerfIsinHeader("annualized-table_wrapper").isDisplayed();
		}			
		ProductListPage.productListPage(driver).getPerfIncDateHeader("annualized-table_wrapper").isDisplayed();
		
		String uiOneYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("annualized-table_wrapper", "1 Year").getText();
		assertEquals(uiOneYearAnnualHeader, "1 Year");
		
		String uiThreeYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("annualized-table_wrapper", "3 Year").getText();
		assertEquals(uiThreeYearAnnualHeader, "3 Year");
		
		String uiFiveYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("annualized-table_wrapper", "5 Year").getText();
		assertEquals(uiFiveYearAnnualHeader, "5 Year");
		
		String uiTenYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("annualized-table_wrapper", "10 Year").getText();
		assertEquals(uiTenYearAnnualHeader, "10 Year");
		
	}
	
	@Then("^I verify the columns on Annualised tab on Performance section for German Site$")
	public void iVerifyTheColumnsOnAnnualisedTabDe() throws Throwable {
		Thread.sleep(5000);
		ProductListPage.productListPage(driver).getPerfFundHeader("annualized-table_wrapper").isDisplayed();
		ProductListPage.productListPage(driver).getPerfShareHeader("annualized-table_wrapper").isDisplayed();			
		ProductListPage.productListPage(driver).getPerfIncDateHeader("annualized-table_wrapper").isDisplayed();		
		ProductListPage.productListPage(driver).getPerfIncDateHeader("annualized-table_wrapper").isDisplayed();
		
		String uiOneYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("annualized-table_wrapper", "1 Year").getText();
		assertEquals(uiOneYearAnnualHeader, "1 Jahr");
		
		String uiThreeYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("annualized-table_wrapper", "3 Year").getText();
		assertEquals(uiThreeYearAnnualHeader, "3 Jahre");
		
		String uiFiveYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("annualized-table_wrapper", "5 Year").getText();
		assertEquals(uiFiveYearAnnualHeader, "5 Jahre");
		
		String uiTenYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("annualized-table_wrapper", "10 Year").getText();
		assertEquals(uiTenYearAnnualHeader, "10 Jahre");
		
	}
	
	@Then("^I verify the columns on Cumulative tab on Performance section$")
	public void iVerifyTheColumnsOnCumulativeTab() throws Throwable {
		Thread.sleep(5000);
		ProductListPage.productListPage(driver).getPerfFundHeader("cumulative-table_wrapper").isDisplayed();
		if (!driver.getCurrentUrl().contains("en-au")){
			ProductListPage.productListPage(driver).getPerfShareHeader("cumulative-table_wrapper").isDisplayed();
		} else {
			System.out.println("Share Class Column is not authored for Australia Product List page: " + driver.getCurrentUrl());
		}		
		ProductListPage.productListPage(driver).getPerfIncDateHeader("cumulative-table_wrapper").isDisplayed();
		if (driver.getCurrentUrl().contains("en-au")){
			ProductListPage.productListPage(driver).getPerfAPIRCodeColumn("cumulative-table_wrapper").isDisplayed();
		} else {
			ProductListPage.productListPage(driver).getPerfIsinHeader("cumulative-table_wrapper").isDisplayed();
		}
		ProductListPage.productListPage(driver).getPerfIncDateHeader("cumulative-table_wrapper").isDisplayed();
		
		String uiOneYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("cumulative-table_wrapper", "1 Year").getText();
		assertEquals(uiOneYearAnnualHeader, "1 Year");
		
		String uiThreeYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("cumulative-table_wrapper", "3 Year").getText();
		assertEquals(uiThreeYearAnnualHeader, "3 Year");
		
		String uiFiveYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("cumulative-table_wrapper", "5 Year").getText();
		assertEquals(uiFiveYearAnnualHeader, "5 Year");
		
		String uiTenYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("cumulative-table_wrapper", "10 Year").getText();
		assertEquals(uiTenYearAnnualHeader, "10 Year");
	}
	
	@Then("^I verify the columns on Cumulative tab on Performance section for German Site$")
	public void iVerifyTheColumnsOnCumulativeTabDe() throws Throwable {
		Thread.sleep(5000);
		ProductListPage.productListPage(driver).getPerfFundHeader("cumulative-table_wrapper").isDisplayed();
		
		ProductListPage.productListPage(driver).getPerfShareHeader("cumulative-table_wrapper").isDisplayed();
		
		ProductListPage.productListPage(driver).getPerfIncDateHeader("cumulative-table_wrapper").isDisplayed();
		
		ProductListPage.productListPage(driver).getPerfIsinHeader("cumulative-table_wrapper").isDisplayed();		

		//TODO Add validation for Asof column
		String uiOneYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("cumulative-table_wrapper", "1 Year").getText();
		assertEquals(uiOneYearAnnualHeader, "1 Jahr");
		
		String uiThreeYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("cumulative-table_wrapper", "3 Year").getText();
		assertEquals(uiThreeYearAnnualHeader, "3 Jahre");
		
		String uiFiveYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("cumulative-table_wrapper", "5 Year").getText();
		assertEquals(uiFiveYearAnnualHeader, "5 Jahre");
		
		String uiTenYearAnnualHeader = ProductListPage.productListPage(driver).getDiscreteYearHeader("cumulative-table_wrapper", "10 Year").getText();
		assertEquals(uiTenYearAnnualHeader, "10 Jahre");
	}
	

	@Then("^I verify the Inception date is displayed as per country local on \"([^\"]*)\" table$")
	public void iVerifyTheInceptionDateBasedOnLocal(String tableId) throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getPerfIncDateData(tableId).size() > 0);
		for (int i = 0; i <ProductListPage.productListPage(driver).getPerfIncDateData(tableId).size(); i ++)
		{
			String inceptionDate = null;
			if (driver.getCurrentUrl().contains("en-au")) {
				inceptionDate = ProductListPage.productListPage(driver).getPerfIncDateDataAU(tableId).get(i).getText();
			} else {
				inceptionDate = ProductListPage.productListPage(driver).getPerfIncDateData(tableId).get(i).getText();
			}
			String[] currentUrl  = driver.getCurrentUrl().split("/");
			verifyLocaleFormattedDate(inceptionDate, currentUrl[3]);		
		}	
	}
	
	@Then("^I verify the As Of Date is displayed as per country local on \"([^\"]*)\" table$")
	public void iVerifyAsofDateEachShareClassBasedOnLocal(String tableId) throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getPerfAsOfDateData(tableId).size() > 0);
		for (int i = 0; i < ProductListPage.productListPage(driver).getPerfAsOfDateData(tableId).size(); i++)
		{
			String asOfDate = null;
			if (driver.getCurrentUrl().contains("en-au")){
				asOfDate = ProductListPage.productListPage(driver).getPerfAsOfDateDataAU(tableId).get(i).getText();
			} else {
				asOfDate = ProductListPage.productListPage(driver).getPerfAsOfDateData(tableId).get(i).getText();
			}
			String[] currentUrl  = driver.getCurrentUrl().split("/");
			verifyLocaleFormattedDate(asOfDate, currentUrl[3]);			
		}	
	}
	
	@Then("^I verify the As Of Date is displayed as per country local on \"([^\"]*)\" table for German Site$")
	public void iVerifyAsofDateEachShareClassBasedOnLocalDe(String tableId) throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getPerfAsOfDateDataDe(tableId).size() > 0);
		for (int i = 0; i < ProductListPage.productListPage(driver).getPerfAsOfDateDataDe(tableId).size(); i++)
		{
			String asOfDate = null;
			asOfDate = ProductListPage.productListPage(driver).getPerfAsOfDateDataDe(tableId).get(i).getText();
			String[] currentUrl  = driver.getCurrentUrl().split("/");
			verifyLocaleFormattedDate(asOfDate, currentUrl[3]);			
		}	
	}
	
	@Then("^I verify the data for the first fund on \"([^\"]*)\" of product list page$")
	public void iVerifyTheFirStFundData(String tableId) throws Throwable {
		List <WebElement> tableData = driver.findElements(By.xpath("(//*[@id='"+tableId+"']//tr[1])[2]/td"));
		for (int i = 3; i< 8; i++) {
			String fundData = tableData.get(i).getText();
			if(!fundData.contentEquals("-")){
				assertNotNull(fundData);
			}				
		}	
	}
	
	@Then("^I verify the Share Class on the detail page$")
	public void iVerifyTheShareclassOnDetailPage() throws Throwable {
		Thread.sleep(3000);
		String shareClassProductDetail = ProductListPage.productListPage(driver).getSelectedSharedClass().getText();
		System.out.println("verify the Share Class on the detail page  :"+ shareClassProductDetail);
		if (driver.getCurrentUrl().contains("en-au"))
		{
			assertTrue(shareClassProductDetail.contains("Class A"));
		}else {
			if(shareClassProductDetail.contains(shareClass))
			{
				System.out.println( "Shared class is maching");
			}else {
				System.out.println( "Shared class is not maching");
			}
		}		
	}
	
	public static String calcDiscHeaderDate(String asOfdateText, int yearValue)
	{	
		if (driver.getCurrentUrl().contains("en-gb") || driver.getCurrentUrl().contains("en-au") || driver.getCurrentUrl().contains("en-dk") || driver.getCurrentUrl().contains("en-nl") || driver.getCurrentUrl().contains("en-fi") || driver.getCurrentUrl().contains("de-de")) {
			LocalDate startDate = LocalDate.parse(asOfdateText, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusYears(-yearValue).plusDays(1);
			String startDate01 = startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate endDate2 = LocalDate.parse(startDate01, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusYears(1).plusDays(-1);
			String endDate02 = endDate2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String expectedDiscHeader = startDate01 + " - " + endDate02;
			return expectedDiscHeader;
		}else if (driver.getCurrentUrl().contains("en-se")) {
			LocalDate startDate = LocalDate.parse(asOfdateText, DateTimeFormatter.ofPattern("yyyy/MM/dd")).plusYears(-yearValue).plusDays(1);
			String startDate01 = startDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			LocalDate endDate2 = LocalDate.parse(startDate01, DateTimeFormatter.ofPattern("yyyy/MM/dd")).plusYears(1).plusDays(-1);
			String endDate02 = endDate2.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			String expectedDiscHeader = startDate01 + " - " + endDate02;
			return expectedDiscHeader;
		}else{	
			LocalDate startDate = LocalDate.parse(asOfdateText, DateTimeFormatter.ofPattern("MM/dd/yyyy")).plusYears(-yearValue).plusDays(1);
			String startDate01 = startDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			LocalDate endDate2 = LocalDate.parse(startDate01, DateTimeFormatter.ofPattern("MM/dd/yyyy")).plusYears(1).plusDays(-1);
			String endDate02 = endDate2.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			String expectedDiscHeader = startDate01 + " - " + endDate02;
			return expectedDiscHeader;
		}
	}
	public static String calcCalendarHeader(String asOfdateText, int yearValue)
	{	
		int startDate = LocalDate.parse(asOfdateText, DateTimeFormatter.ofPattern("dd/MM/yyyy")).getYear();		
		int startDateheader = startDate - yearValue;			
		String startDateheaderText = String.valueOf(startDateheader);		
		return startDateheaderText;		
	}
	

	@Then("^I capture data from the \"([^\"]*)\" tab on the Performance section$")
	public void iCaptureDataFromDiscreteRollingTab(String tableId) throws Throwable {
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//*[@id='"+ tableId +"-table_info']")).getText());
		String[] fundInfoText = (driver.findElement(By.xpath("//*[@id='"+ tableId +"-table_info']")).getText()).split(" ");
		System.out.println("Result count"  + fundInfoText[3]);
		int result = Integer.parseInt(fundInfoText[3].replaceAll("[^0-9]+", ""));
		int nextCount = result / PAGECOUNT;
		
		List <WebElement> allRows = driver.findElements(By.xpath("//*[@id='tab-"+tableId+"']//tr"));
		int rowSize = allRows.size();		
		System.out.println(rowSize);		
		String sheetName = "INPUT";	
		String FolderPath = System.getProperty("user.dir") + "\\src\\main\\testData\\ProductListData";
		String filePath = System.getProperty("user.dir") + "\\src\\main\\testData\\ProductListData\\Landing_Data_Input.xlsx";
							
        System.out.println(filePath);
       	File file = new File(filePath);
        
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet1 = wb.getSheet(sheetName);
        
       	int excelrow = 0;
		int headerRow = 0;
		this.readHeadersContent(sheet1, allRows, excelrow, tableId);
		excelrow = excelrow + 1;
		this.readTableData(sheet1, allRows, excelrow, "//*[@id='"+tableId+"-table']");
		
		for (int clickNext = 1; clickNext <= nextCount; clickNext++) {
			headerRow = headerRow + 1;
			excelrow = ((rowSize - 1) * clickNext);
			driver.findElement(By.xpath("//*[@id='"+tableId+"-table_next']/a")).click();
			this.readTableData(sheet1, allRows, excelrow, "//*[@id='"+tableId+"-table']");
		}
		saveWorkBook(wb, createFile(FolderPath, sheetName, tableId));	
	}
	
	public void readHeadersContent(XSSFSheet workSheet, List<WebElement> allRows, int excelrow, String tableId) {		
			List<WebElement> allCells = driver.findElements(By.xpath("//*[@id='"+tableId+"-table']//thead/tr/th"));	
			if (allCells.size() >= 1) {
				XSSFRow excelRow = workSheet.createRow(excelrow);
				for (int j = 0; j < allCells.size(); j++) {
					WebElement webCell = allCells.get(j);
					String text = webCell.getText();
					if (text.length() >= 1) {
						Cell excelCell = excelRow.createCell(j);
						excelCell.setCellValue(webCell.getText());
					}
				}
			}
			excelrow = excelrow + 1;
	}

	
	public void readTableData(XSSFSheet workSheet, List<WebElement> allRows, int excelrow, String xpath) {
		WebElement overviewTable = driver.findElement(By.xpath(xpath));
		List<WebElement> allRows_i = overviewTable.findElements(By.tagName("tr"));
		rowSize = allRows_i.size();
		for (int i = 0; i < rowSize; i++) {
			WebElement webRow = allRows_i.get(i);
			List<WebElement> allCells = webRow.findElements(By.tagName("td"));	
			if (allCells.size() >= 1) {
				XSSFRow excelRow = workSheet.createRow(excelrow);
				for (int j = 0; j < allCells.size(); j++) {
					WebElement webCell = allCells.get(j);
					String text = webCell.getText();
					if (text.length() >= 1) {
						Cell excelCell = excelRow.createCell(j);
						excelCell.setCellValue(webCell.getText());
					}
				}
			}
			excelrow = excelrow + 1;
		}
	}

	public static File createFile(String folderPath, String Sheetname, String tableId) {
		timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		return Paths.get(folderPath, "ProdcutList_" +tableId + "_"+ timestamp + ".xlsx").toFile();
	}

	public static void saveWorkBook(XSSFWorkbook wb, File fileToWrite) throws FileNotFoundException, IOException {
		try (FileOutputStream outputStream = new FileOutputStream(fileToWrite)) {
			wb.write(outputStream);
		}
	}
	
	public static void verifyLocaleFormattedDate(String dateString, String country) {
		DateFormat uiDateFormat = null;
		if (country.contains("en")) {			
			if (driver.getCurrentUrl().contains("en-se")) {
				uiDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
			} else if (driver.getCurrentUrl().contains("en-aa")) {
				uiDateFormat = new SimpleDateFormat("MM/dd/YYYY", Locale.ENGLISH);
			}else{
				uiDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
			}					
		} else if (country.contains("de")) {
			if (driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch"))  {
				uiDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.GERMANY);
			}
		}else if (country.contains("fr")) {
			if (driver.getCurrentUrl().contains("fr-fr"))  {
				uiDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.GERMANY);
			}
		try {
			uiDateFormat.parse(dateString);
		} catch (ParseException e) {
			assertTrue(String.format("Date '%s' is not in" + country + "format", dateString), false);
		}	
		}
	}
	
	@And("^I click on the product overview header on Singapore$")
	public void iClickOnTheProductOverviewHeaderOnSingapore() throws Throwable {
		Thread.sleep(5000);
		HomePageObject.homePageObject(driver).getProductsHeaderSG().click();
	}

	@Then("^I verify the Authorised section on Product Overveiw page$")
	public void iVerifyTheAuthorisedSectionOnPLSG() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getAuthorisedSection().isDisplayed());
	}

	@And("^I click on Authorised section on Product Overveiw page$")
	public void iClickTheAuthorisedSectionPLSG() throws Throwable {
		ProductListPage.productListPage(driver).getAuthorisedSection().click();
	}

	
	@Then("^I verify the link to Recognised under authorised section$")
	public void iVerifyTheRecognisedLinkPLSG() throws Throwable {
		assertTrue(ProductListPage.productListPage(driver).getRecognisedLink().isDisplayed());
	}

	@And("^I click on \"([^\"]*)\" to link button$")
	public void iClickOnLinkToAuthorisedButton(String buttonLink) throws Throwable {
		ProductListPage.productListPage(driver).getAuthorisedLink(buttonLink).click();
	}
	
	@Then("^I verify \"([^\"]*)\" link is displayed on the page$")
	public void iVerifyTheLinkIsPresent(String linkName) throws Throwable {
		assertTrue(linkName + " link is not displayed", ProductListPage.productListPage(driver).getLink(linkName).isDisplayed());
	}
	
	@Then("^I verify \"([^\"]*)\" Section is displayed on the page$")
	public void iVerifyTheSectionIsPresent(String sectionName) throws Throwable {
		assertTrue(sectionName + " Section is not displayed", ProductListPage.productListPage(driver).getSectionName(sectionName).isDisplayed());
	}

	@Then("^I click on \"([^\"]*)\" section link$")
	public void iClickOnSectionLink(String sectionName) throws Throwable {
		ProductListPage.productListPage(driver).getSectionName(sectionName).click();
		Thread.sleep(3000);	 
	}
	
	@Then("^I click on the Overview Tab$")
	public void iClickOnOverviewTab() throws Throwable {
		ProductListPage.productListPage(driver).getOverviewTab().click();
		Thread.sleep(3000);	 
	}
	

	@Then("^I click on the \"([^\"]*)\" in the productlist page under Performance tab$")
	public void iClickOnTheInTheProductlistPageUnderPerformanceTab(String fund) throws Throwable {
	    Thread.sleep(2000);
	    ProductListSteps.fundNameProductList=fund;
	    ProductListPage.productListPage(driver).getFundNamePLPerTab(fund).click();
	}
	
	@And("^I click on the products header for France Site$")
	public void iClickOnProductsHeaderFR() throws Throwable {
		Thread.sleep(10000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",HomePageObject.homePageObject(driver).getProductsHeaderFR());
	}
}