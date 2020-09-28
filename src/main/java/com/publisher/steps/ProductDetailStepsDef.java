package com.publisher.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.publisher.pageobjects.ProductDetailPage;
import com.publisher.pageobjects.ProductDetailPageObject;
import com.publisher.pageobjects.ProductListPage;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ProductDetailStepsDef extends Utility{
	
	
    private static final String CLASS = "class";
    private static final String DISABLED = "disabled";
    private static final String PAGEINFO = "Showing 1-25 of";
    private String emptyWatchListMsg = "Products & Share Classes added to your watchlist will be shown here";
    private static final String NO_DISTRIIBUTION_MSG = "Distributions data is not available for selected share class"; 
    private static final String NO_3YEARDATA_MSG = "Three Year Risk Statistics data is not available for selected share class";
    
	private static String fundNameProductList;
	private static String fundName;
	private static String shareClass;
	
	
	@Then("^I click on the productlist page fund name navigation check for overview tab$")
	public void iClickOnOverViewFundNavigationCheckOnProductListPage() throws Throwable {
		fundNameProductList = ProductListPage.productListPage(driver).getFundNameLink().getText();
		ProductListPage.productListPage(driver).getFundNameLink().click();	    
	}
	
	@And("^I returning back to productlist page$")
	public void iReturnbackToProductListPage() throws Throwable {
		driver.navigate().back();	    
	}
	
	@Then("^I click on the productlist page fund name navigation check for Performance tab$")
	public void iClickOnFundNameOnProductListPage() throws Throwable {
		Thread.sleep(10000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//*[@id='tab-overview']//tbody/tr/td[1]/a)[6]")));
		Thread.sleep(6000);
		fundNameProductList = driver.findElement(By.xpath("(//*[@id='tab-overview']//tbody/tr/td[1]/a)[6]")).getText();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",ProductDetailPageObject.productDetailPageObject(driver).getFundNameLink());
		//ProductDetailPageObject.productDetailPageObject(driver).getFundNameLink().click();	       
	}
	
	@Then("^I click on the \"([^\"]*)\" from product list page for Australia$")
	public void iClickOnFundNameOnProductListPageAU(String fundName) throws Throwable {
		Thread.sleep(6000);
		fundNameProductList = ProductDetailPageObject.productDetailPageObject(driver).getFundNameTextAU(fundName).getText();
		ProductDetailPageObject.productDetailPageObject(driver).getFundNameTextAU(fundName).click();	  
	}
	
	@Then("^I click on the productlist fund which doesn't have distribution data$")
	public void iClickOnFundWithOutDistributionData() throws Throwable {
		Thread.sleep(10000);
		fundNameProductList = ProductDetailPageObject.productDetailPageObject(driver).getFundNameWithOudDataText().getText();
		ProductDetailPageObject.productDetailPageObject(driver).getFundNameWithOudDataLink().click();
	}	
	
	@Then("^I click on the \"([^\"]*)\" in the productlist page under overview tab$")
	public void iClickOnTheInTheProductlistPageUnderOverviewTab(String fundName) throws Throwable {
	    Thread.sleep(3000);
	    try {
	    if(driver.getCurrentUrl().contains("en-nl")||driver.getCurrentUrl().contains("en-lu")) {
	    	fundNameProductList = ProductDetailPage.productDetailPage(driver).getFundNamePLOverTab("EnTrust Global Alternative Income Strategy").getText();
		    ProductDetailPage.productDetailPage(driver).getFundNamePLOverTab("EnTrust Global Alternative Income Strategy").click();
	    }else if(driver.getCurrentUrl().contains("en-sg") || driver.getCurrentUrl().contains("en-au")) {
	    	fundNameProductList = ProductDetailPage.productDetailPage(driver).getFundNamePLOverTab("Legg Mason Brandywine Global Fixed Income Fund").getText();
		    ProductDetailPage.productDetailPage(driver).getFundNamePLOverTab("Legg Mason Brandywine Global Fixed Income Fund").click();
	    }
	    else if(driver.getCurrentUrl().contains("zh-cn") && (!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
	    	
	    	
	    	String fullurl=driver.getCurrentUrl();
	    	System.out.println(fullurl);
		    String baseUrl[]= fullurl.split(".html");
		    System.out.println(baseUrl[0]);
			String rUrl=baseUrl[0]+"/"+fundName+".html";
			System.out.println(rUrl);
			driver.get(rUrl);
			Thread.sleep(3000);
		    
	    } else if(driver.getCurrentUrl().contains("zh-cn") && (getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
	    	System.out.println("Product link does not applicable for selected distributor");
	    }else if(driver.getCurrentUrl().contains("zh-hk")) {
	    	fundNameProductList = driver.findElement(By.xpath("(//td[@class='fund sorting_1']//a)[1]")).getText();
	    	driver.findElement(By.xpath("(//td[@class='fund sorting_1']//a)[1]")).click();
	    }else {
	    fundNameProductList = ProductDetailPage.productDetailPage(driver).getFundNamePLOverTab(fundName).getText();
	    ProductDetailPage.productDetailPage(driver).getFundNamePLOverTab(fundName).click();
	    }
	    }catch(NoSuchElementException e) {
	    	fundNameProductList = ProductDetailPage.productDetailPage(driver).getFundNamePLOverTab(fundName).getText();
		    ProductDetailPage.productDetailPage(driver).getFundNamePLOverTab(fundName).click();
	    }
	}

	@Then("^I verify the product detail page is Navigated$")
	public void iVerifyTheProductDetailPageIsDisplayed() throws Throwable {
		Thread.sleep(8000);
		String fundNameProductDetial = ProductListPage.productListPage(driver).getFundNameTitle().getText();
		System.out.println("Detail page fundNameProductDetial:" + fundNameProductDetial);
		assertEquals(fundNameProductList, fundNameProductDetial);
	}
	
	@Then("^I verify the product detail page is Navigated from Performance tab$")
	public void iVerifyTheProductDetailPageIsDisplayedFromPerformanceTab() throws Throwable {
		Thread.sleep(8000);
		String fundNameProductDetial = ProductListPage.productListPage(driver).getFundNameTitle().getText();
		System.out.println("Detail page fundNameProductDetial:" + fundNameProductDetial);
		assertEquals(ProductListSteps.fundNameProductList, fundNameProductDetial);
	}
	
	@Then("^I click on the productlist page fund name navigation check for Overview tab$")
	public void iClickOnFundNameOnPLOverviewTab() throws Throwable {
		Thread.sleep(6000);
		fundNameProductList = ProductDetailPageObject.productDetailPageObject(driver).getFundNamePLoverview().getText();
		System.out.println("fundNameProductList: " + fundNameProductList);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ProductDetailPageObject.productDetailPageObject(driver).getFundNamePLoverview());
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ProductDetailPageObject.productDetailPageObject(driver).getFundNamePLoverview());
		//ProductDetailPageObject.productDetailPageObject(driver).getFundNamePLoverview().click();    
	}
	
	@Then("^I verify the Sub Performance tab is displayed$")
	public void iVerifyThePerformanceTabIsDisplayed() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getPerformanceSubTab().isDisplayed());    
	}
	
	@And("^I click on the distribution tab$")
	public void iClickTheDistributionsTab() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")) {
			ProductDetailPageObject.productDetailPageObject(driver).getDistributionsTabDe().click();
		}else {
			ProductDetailPageObject.productDetailPageObject(driver).getDistributionsTab().click();	    
		}   
	}
	
	@And("^I click on the Investment Risk tab$")
	public void iClickTheInvestmentRiskTab() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getInvestmentRiskTab().click();	    
	}
	
	@Then("^I verify the Investment Risk Rewards Image is displayed$")
	public void iVerifyTheInvestmentRiskImageIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getRiskRewardImage().isDisplayed()) {
				
					assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getRiskRewardImage().getAttribute("src").contains("images/risk-reward/netherlands-risk.gif"));
			}else {
				System.out.println("Risk Reward Image is not displayed");					
				}	
			}
		catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	@Then("^I verify the Investment Risk table is displayed with header$")
	public void iVerifyTheInvestmentRiskIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getRiskRewardsHeader().isDisplayed()) {
				
					assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getRiskRewardsHeader().getText().contains("Risk Reward Profile"));
			}else {
				System.out.println("Risk Reward Profile Header is not displayed");					
				}	
			}
		catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	@Then("^I verify the Distributions table is displayed with header$")
	public void iVerifyTheDistributionsIsDisplayed() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")) {
			try{
				if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsTableHeader().isDisplayed()) {
					
						assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDistributionsTableHeader().getText().contains("Ausschüttungen"));
				}else {
						String uiNoDataMsg = ProductDetailPageObject.productDetailPageObject(driver).getDistributionsTableRows().get(0).getText();
						assertEquals(uiNoDataMsg, "Ausschüttungsdaten sind für ausgewählte Anteilsklasse nicht verfügbar");					
					}	
				}
			catch(NoSuchElementException ex){
				//Do nothing
			}	 

			
		}else {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsTableHeader().isDisplayed()) {
				
					assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDistributionsTableHeader().getText().contains("Distributions"));
			}else {
					String uiNoDataMsg = ProductDetailPageObject.productDetailPageObject(driver).getDistributionsTableRows().get(0).getText();
					assertEquals(uiNoDataMsg, NO_DISTRIIBUTION_MSG);					
				}	
			}
		catch(NoSuchElementException ex){
			//Do nothing
		}	 
		}
	}
	
	@Then("^I verify the Distributions Section Data is displayed in table$")
	public void iVerifyTheDistributionsDataIsDisplayed() throws Throwable {
		try {			
			if(driver.findElements(By.xpath("//div[@class='product-charts']//div[contains(@class,'distributions distributions-chart distributions')]//table//tr")).size() > 1 ) {
				WebElement datatable = driver.findElement(By.xpath("//div[@class='product-charts']//div[contains(@class,'distributions distributions-chart distributions')]"));
					List<WebElement> rows_table = datatable.findElements(By.tagName("tr"));
					int rows_count = rows_table.size();
					for (int row=0; row<rows_count; row++){
						List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
						int columns_count = Columns_row.size();	   
						for (int column=0; column<columns_count; column++){
						String celtext = Columns_row.get(column).getText();
						System.out.println("Distributions Data is"+ "\t" +celtext);
						System.out.println("Distributions Data is"+ "\t" +celtext);
					}				  
				}		 
			}else {
				if (driver.findElements(By.xpath("//div[@class='product-charts']//div[contains(@class,'distributions distributions-chart distributions')]//table//tr")).size() > 0 ) { 
					String uiNoDataMsg = driver.findElements(By.xpath("//div[@class='product-charts']//div[contains(@class,'distributions distributions-chart distributions')]//table//tr")).get(0).getText();
					assertEquals(uiNoDataMsg, NO_DISTRIIBUTION_MSG);
				}else {
					System.out.println("Distributions table is not authored under Distributions section");
				}				
			}	 
		}catch(NoSuchElementException ex){
			System.out.println("Distributions Table is not displayed in Performance Section");
		}
	}
	
	@Then("^I verify the distribution table header is displayed$")
	public void iVerifyTheDistributionsTableHeaderIsDisplayed() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDistributionsTableHeader().isDisplayed());	    
	}
	
	@Then("^I verify the distribution With out Data Table header is displayed$")
	public void iVerifyTheDistributionsWithOutDataHeaderIsDisplayed() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDistributionsHeader().isDisplayed());	    
	}
	@Then("^I verify the distribution data is not available for Selected Share Class Fund is displayed$")
	public void iVerifyTheDistributionsWithOutDataIsDisplayed() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed());	    
	}
	@Then("^I verify the distribution table header Dividend / Reinvest Date is displayed$")
	public void iVerifyTheDistributionsDividendReinvestDateIsDisplayed() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")) {
			try{
				if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
					System.out.println("Distributions Data is not available");				
				}else {
					assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDividendReinvestDateDe().isDisplayed());
				}	
			}catch(NoSuchElementException ex){
				//Do nothing
			}
		}else {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");				
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDividendReinvestDate().isDisplayed());
			}	
		}catch(NoSuchElementException ex){
			//Do nothing
		}
		}
	}
	
	@Then("^I verify the distribution table header Payable date is displayed$")
	public void iVerifyTheDistributionsPayAbleDateIsDisplayed() throws Throwable {
			    
		if(driver.getCurrentUrl().contains("de-de")) {
			try{
				if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
					System.out.println("Distributions Data is not available");				
				}else {
					assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getPayableDateDe().isDisplayed());
				}	
			}catch(NoSuchElementException ex){
				//Do nothing
			}
		}else {	    
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");		
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getPayAbleDate().isDisplayed());
				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	
		}
	}
	@Then("^I verify the distribution table header Reinvest Price is displayed$")
	public void iVerifyTheDistributionsReinvestpriceIsDisplayed() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")) {
			 try{
					if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
						System.out.println("Distributions Data is not available");		
						}else {
						assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getReinvestpriceDe().isDisplayed());
					}
				}catch(NoSuchElementException ex){
					//Do nothing
				}
		 }else {   
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");		
				}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getReinvestprice().isDisplayed());
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}
		 }    
		 
	}
	@Then("^I verify the distribution table header Ordinary Incom is displayed$")
	public void iVerifyTheDistributionsOrdinaryIncomIsDisplayed() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")) {
			 try{
					if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
						System.out.println("Distributions Data is not available");		
						}else {
						assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getOrdinaryIncomDe().isDisplayed());
					}
				}catch(NoSuchElementException ex){
					//Do nothing
				}
		 }else {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");						
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getOrdinaryIncom().isDisplayed());
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}
	} 
		
	}
	@Then("^I verify the distribution table View Full Table is displayed$")
	public void iVerifyTheDistributionsViewFullTableIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");						
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getViewFullTable().isDisplayed());
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	@Then("^I verify the distribution table View Full Table Search Icon is displayed$")
	public void iVerifyTheDistributionsViewFullTableIconIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");						
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getViewFullTableIcon().isDisplayed());
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	@And("^I click the View Full Table$")
	public void iClickTheDistributionsViewFullTable() throws Throwable {
			    
		//try{
				/*
				 * if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				 * System.out.println("Distributions Data is not available"); }else {
				 */
						ProductDetailPageObject.productDetailPageObject(driver).getViewFullTable().isDisplayed();
						//((JavascriptExecutor)driver).executeScript("arguments[0].click();", ProductDetailPageObject.productDetailPageObject(driver).getViewFullTable());
							ProductDetailPageObject.productDetailPageObject(driver).getViewFullTable().click();	
					}
				//}catch(NoSuchElementException ex){
					//Do nothing
				//}	 
	
	@Then("^I verify the View Full Table distribution header is displayed$")
	public void iVerifyTheViewFullTableHeaderIsDisplayed() throws Throwable {
	try{
		if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
			System.out.println("Distributions Data is not available");						
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDistributionsModelHeader().isDisplayed());
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	@Then("^I verify the View Full Table header Dividend / Reinvest Date is displayed$")
	public void iVerifyTheViewFullDividendReinvestDateIsDisplayed() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")) {
			try{
				if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
					System.out.println("Distributions Data is not available");					
				}else {
					assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDividendModelReinvestDateDe().isDisplayed());	
				}
			}catch(NoSuchElementException ex){
				//Do nothing
			}
		}else {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");					
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDividendModelReinvestDate().isDisplayed());	
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
		} 
	}
	@Then("^I verify the View Full Table header Payable date is displayed$")
	public void iVerifyTheViewFullPayAbleDateIsDisplayed() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")) {
			try{
				if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
					System.out.println("Distributions Data is not available");						
				}else {
					assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getPayableModelDateDe().isDisplayed());
				}
			}catch(NoSuchElementException ex){
				//Do nothing
			}
		}else {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");						
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getPayAbleModelDate().isDisplayed());
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
		}	 
	}
	@Then("^I verify the View Full Table header Reinvest Price is displayed$")
	public void iVerifyTheViewFullReinvestpriceIsDisplayed() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")) {
			try{
				if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
					System.out.println("Distributions Data is not available");						
				}else {
					assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getReinvestModelpriceDe().isDisplayed());
				}
			}catch(NoSuchElementException ex){
				//Do nothing
			}
		}else {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");					
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getReinvestModelprice().isDisplayed());	
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
		}
	}
	@Then("^I verify the View Full Table header Ordinary Incom is displayed$")
	public void iVerifyTheViewFullOrdinaryIncomIsDisplayed() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")) {
			try{
				if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
					System.out.println("Distributions Data is not available");						
				}else {
					assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getOrdinaryModelIncomDe().isDisplayed());
				}
			}catch(NoSuchElementException ex){
				//Do nothing
			}
		}else {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");					
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getOrdinaryModelIncom().isDisplayed());	
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
		}
	}
	@Then("^I verify the View Full Table Close Icon is displayed$")
	public void iVerifyTheViewFullViewFullTableIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");					
			}else {
				ProductDetailPageObject.productDetailPageObject(driver).getCloseButton().isDisplayed();
					ProductDetailPageObject.productDetailPageObject(driver).getCloseButton().click();
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	@Then("^I verify the View Full Table View Full Table Search Icon is displayed$")
	public void iVerifyTheViewFullViewFullTableIconIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
				System.out.println("Distributions Data is not available");						
			}else {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getViewFullTableIcon().isDisplayed());
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	@And("^I click the close icon to close View Full Table$")
	public void iClickTheCloseViewFullTable() throws Throwable {
	try{
		if (ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutData().isDisplayed()) {
			System.out.println("Distributions Data is not available");						
			}else {
				ProductDetailPageObject.productDetailPageObject(driver).getViewFullTable().isDisplayed();
					ProductDetailPageObject.productDetailPageObject(driver).getViewFullTable().click();
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	@Then("^I verify the Discrete Rolling Tab is displayed$")
	public void iVerifyTheDiscreterollingTabIsDisplayed() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getPerformanceDiscreteRollingTab().isDisplayed());	    
	}
	@And("^I click the Calander Tab$")
	public void iClickTheCalanderTab() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getPerformanceCalenderTab().click();	    
	}
	@And("^I click the Annualised Tab$")
	public void iClickTheAnnualisedTab() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getPerformanceAnnualisedTab().click();	    
	}
	@And("^I click the Cumulative Tab$")
	public void iClickTheCumulativeTab() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getPerformanceCumulativeTab().click();	    
	}
	
	
	@Then("^I verify the Discrete Rolling Tab is displayed for German site$")
	public void iVerifyTheDiscreterollingTabIsDisplayedForGermanSite() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getPerformanceDiscreteRollingTabDe().isDisplayed());	    
	}
	@And("^I click the Calander Tab for German site$")
	public void iClickTheCalanderTabForGermanSite() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getPerformanceCalenderTabDe().click();	    
	}
	@And("^I click the Annualised Tab for German site$")
	public void iClickTheAnnualisedTabForGermanSite() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getPerformanceAnnualisedTabDe().click();	    
	}
	@And("^I click the Cumulative Tab for German site$")
	public void iClickTheCumulativeTabForGermanSite() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getPerformanceCumulativeTabDe().click();	    
	}
	
	@Then("^I verify the distribution With out Data Table header is displayed for German site$")
	public void iVerifyTheDistributionsWithOutDataHeaderIsDisplayedForGermanSite() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDistributionsHeaderDe().isDisplayed());	    
	}
	
	@Then("^I verify the distribution data is not available for Selected Share Class Fund is displayed for German site$")
	public void iVerifyTheDistributionsWithOutDataIsDisplayedForGermanSite() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDistributionsWithOutDataDe().isDisplayed());	    
	}
	
	@Then("^I verify the Disclimer is displayed$")
	public void iVerifyTheDisclimerIsDisplayed() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDisclaimer().isDisplayed());	    
	}
	@Then("^I verify the Disclosure Section is displayed$")
	public void iVerifyTheDisclosureIsDisplayed() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDisclosure().isDisplayed());	    
	}
	
	@Then("^I verify the Fund Facts table is displayed with header$")
	public void iVerifyTheFundFactsIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getFundFactsHeader().isDisplayed()) {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getFundFactsHeader().getText().contains("Fund Facts"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	@Then("^I verify the Fund Facts Section Data is displayed in table$")
	public void iVerifyTheFundFactsDataIsDisplayed() throws Throwable {
		try {
			if (ProductDetailPageObject.productDetailPageObject(driver).getFundFactsHeader().isDisplayed()) {
			    if(driver.findElements(By.xpath("//div[@class='fund-facts fund-facts-characteristics fund-facts-pdpaj']//table//tr")).size() > 1 ) {
			    	WebElement datatable = driver.findElement(By.xpath("//div[@class='fund-facts fund-facts-characteristics fund-facts-pdpaj']"));
					List<WebElement> rows_table = datatable.findElements(By.tagName("tr"));
					int rows_count = rows_table.size();
					for (int row=0; row<rows_count; row++){
						List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
						int columns_count = Columns_row.size();
						//  System.out.println("Three-Year Risk Statistics Data is"+row+" Value are "+columns_count);
					   
						for (int column=0; column<columns_count; column++){
							 String celtext = Columns_row.get(column).getText();
							 System.out.println("Fund Facts Data is"+ "\t" +celtext);
							 System.out.println("Fund Facts Data is"+ "\t" +celtext);
						}					 
					}		 
			    }else {
				String uiNoDataMsg = driver.findElements(By.xpath("//div[@class='fund-facts fund-facts-characteristics fund-facts-pdpaj']//table//tr")).get(1).getText();
				assertEquals(uiNoDataMsg, "NO_FundCodes_DATAMSG");
			    }	
			}	 			
		}catch(NoSuchElementException ex){
			System.out.println("Fund Codes Table is not displayed in Performance Section");
		} 
	}
	
	@Then("^I verify the Fund Codes table is displayed with header$")
	public void iVerifyTheFundCodeIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getFundCodesHeader().isDisplayed()) {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getFundCodesHeader().getText().contains("Fund codes"));				
			}
		}catch(NoSuchElementException ex){
			System.out.println("Fund Codes Table is not displayed in Performance Section");
		}	 
	}
	
	@Then("^I verify the Fund Codes Section Data is displayed in table$")
	public void iVerifyTheFundcodesDataIsDisplayed() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[@class='fund-codes fund-codes-pfcnt']//table//tr")).size() > 1 ) {
				 WebElement datatable = driver.findElement(By.xpath("//div[@class='fund-codes fund-codes-pfcnt']"));
					List<WebElement> rows_table = datatable.findElements(By.tagName("tr"));
					int rows_count = rows_table.size();
					 for (int row=0; row<rows_count; row++){
						 List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
					  int columns_count = Columns_row.size();
					 //  System.out.println("Three-Year Risk Statistics Data is"+row+" Value are "+columns_count);
					   
					  for (int column=0; column<columns_count; column++){
					  String celtext = Columns_row.get(column).getText();
						  System.out.println("Fund Codes Data is"+ "\t" +celtext);
						  System.out.println("Fund Codes Data is"+ "\t" +celtext);
					  }
					   
					 }		 
			 }else {
				 String uiNoDataMsg = driver.findElement(By.xpath("//div[@class='fund-codes fund-codes-pfcnt']//table//tr")).getText();
				 assertEquals(uiNoDataMsg, "NO_FundCodes_DATAMSG");
			}	 
			
		}catch(NoSuchElementException ex){
			System.out.println("Fund Codes Table is not displayed in Performance Section");
		} 

	}
	@Then("^I verify the Daily Statistics Performance table is displayed with header$")
	public void iVerifyTheDailyStatisticsIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getDailyStatisticsHeader().isDisplayed()) {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getDailyStatisticsHeader().getText().contains("Daily Statistics"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}

	@Then("^I verify the Daily Statistics Data is displayed in table$")
	public void iVerifyTheDailyStatisticsDataIsDisplayed() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[@class='daily-statistics characteristics daily-statistics-wdddy']//table//tr")).size() > 1 ) {
				 WebElement datatable = driver.findElement(By.xpath("//div[@class='daily-statistics characteristics daily-statistics-wdddy']"));
					List<WebElement> rows_table = datatable.findElements(By.tagName("tr"));
					int rows_count = rows_table.size();
					 for (int row=0; row<rows_count; row++){
						 List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
					  int columns_count = Columns_row.size();
					 //  System.out.println("Three-Year Risk Statistics Data is"+row+" Value are "+columns_count);
					   
					  for (int column=0; column<columns_count; column++){
					  String celtext = Columns_row.get(column).getText();
						  System.out.println("Daily Statistics Data is"+ "\t" +celtext);
						  System.out.println("Daily Statistics Data is"+ "\t" +celtext);
					  }
					   
					 }		 
			 }else {
				 String uiNoDataMsg = driver.findElement(By.xpath("//div[@class='daily-statistics characteristics daily-statistics-wdddy']//table//tr")).getText();
				 assertEquals(uiNoDataMsg, "NO_Daily Statistics_DATAMSG");
			 }	 
			
		}catch(NoSuchElementException ex){
			System.out.println("Daily Statistics Table is not displayed in Performance Section");
		} 

	}
	
	@Then("^I verify the Three-Year Risk Statistics Performance table is displayed with header$")
	public void iVerifyTheThreeYearRiskStasticsIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getThreeYearRiskHeader().isDisplayed()) {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getThreeYearRiskHeader().getText().contains("Three-Year risk statistics (Annualised)"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}

	@Then("^I verify the Three-Year Risk Statistics Data is displayed in table$")
	public void iVerifyTheThreeYearRiskDataIsDisplayed() throws Throwable {
		try {
		    if (ProductDetailPageObject.productDetailPageObject(driver).getThreeYearRiskHeader().isDisplayed()) {
		    	if(driver.findElements(By.xpath("//div[@class='three-year-risk three-year-risk-wgmdr']//table//tr")).size() > 1 ) {
				    WebElement datatable = driver.findElement(By.xpath("//div[@class='three-year-risk three-year-risk-wgmdr']"));
					List<WebElement> rows_table = datatable.findElements(By.tagName("tr"));
					int rows_count = rows_table.size();
					for (int row=0; row<rows_count; row++){
						List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
					    int columns_count = Columns_row.size();
        				 //  System.out.println("Three-Year Risk Statistics Data is"+row+" Value are "+columns_count);
					   
					    for (int column=0; column<columns_count; column++){
					    	String celtext = Columns_row.get(column).getText();
					    	System.out.println("Three-Year Risk Statistics Data is"+ "\t" +celtext);
					    	System.out.println("Three-Year Risk Statistics Data is"+ "\t" +celtext);
					    }					   
					}
		    	}else {
		    		String uiNoDataMsg = driver.findElement(By.xpath("//div[@class='three-year-risk three-year-risk-wgmdr']//table//tr")).getText();
		    		assertEquals(uiNoDataMsg, NO_3YEARDATA_MSG);
		    	}	 
		    }
		}catch(NoSuchElementException ex){
			System.out.println("Three-Year Risk Statistics Table is not displayed in Performance Section");
		} 
	}
	
	@Then("^I verify the Charges table is displayed with header$")
	public void iVerifyTheChargesIsDisplayed() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getChargesHeader().isDisplayed()) {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getChargesHeader().getText().contains("Charges"));				
			}
		}catch(NoSuchElementException ex){
			System.out.println("Charges table is not displayed in Performace Section");
		}	 
	}
	
	@Then("^I verify the Charge Section Data is displayed in table$")
	public void iVerifyTheChargesDataIsDisplayed() throws Throwable {
		try {
			if (ProductDetailPageObject.productDetailPageObject(driver).getChargesHeader().isDisplayed()) {
		
				if(driver.findElements(By.xpath("//div[@class='charges charges-characteristics charges-flghs']//table//tr")).size() > 1 ) {
					WebElement datatable = driver.findElement(By.xpath("//div[@class='charges charges-characteristics charges-flghs']"));
					List<WebElement> rows_table = datatable.findElements(By.tagName("tr"));
					int rows_count = rows_table.size();
					for (int row=0; row<rows_count; row++){
						List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
						int columns_count = Columns_row.size();
						//  System.out.println("Three-Year Risk Statistics Data is"+row+" Value are "+columns_count);
					   
						for (int column=0; column<columns_count; column++){
							String celtext = Columns_row.get(column).getText();
							System.out.println("Charges Data is"+ "\t" +celtext);
							System.out.println("Charges Data is"+ "\t" +celtext);
						}					   
					}
				 }else {
					 String uiNoDataMsg = driver.findElements(By.xpath("//div[@class='charges charges-characteristics charges-flghs']//table//tr")).get(1).getText();
					 assertEquals(uiNoDataMsg, "NO_Charge_DATAMSG");
				 }	 
			 }	 					
		}catch(NoSuchElementException ex){
			System.out.println("Charges Table is not displayed in Performance Section");
		} 

	}
	
	@And("^I click on Key Actions options in Product Details$")
	    public void iClickOnKeyActionsOptions() throws Throwable {
	    	ProductDetailPageObject.productDetailPageObject(driver).getKeyActionButton().click();
    }
	
	@Then("^I verify the Three-Year Risk Statistics Performance table is displayed with header for German Site$")
	public void iVerifyTheThreeYearRiskStasticsIsDisplayedDe() throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getThreeYearRiskHeader().isDisplayed()) {
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getThreeYearRiskHeader().getText().contains("Risikoangaben für 3 Jahre (auf Jahresbasis)"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	@Then("^I verify the \"([^\"]*)\" Performance table is displayed with header \"([^\"]*)\" for German Site$")
	public void iVerifyThePerfComponentsIsDisplayedDe(String componentId, String expHeaderText) throws Throwable {
		try{
			if (ProductDetailPageObject.productDetailPageObject(driver).getPerfComponentHeader(componentId).isDisplayed()) {
				System.out.println("Header:" + ProductDetailPageObject.productDetailPageObject(driver).getPerfComponentHeader(componentId).getText());
				assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getPerfComponentHeader(componentId).getText().contains(expHeaderText));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	@Then("^I verify the Three-Year Risk Statistics Data is displayed in table for German Site$")
	public void iVerifyTheThreeYearRiskDataIsDisplayedDe() throws Throwable {
		try {
		    if (ProductDetailPageObject.productDetailPageObject(driver).getThreeYearRiskHeader().isDisplayed()) {
		    	if(driver.findElements(By.xpath("//div[@class='three-year-risk three-year-risk-wgmdr']//table//tr")).size() > 1 ) {
				    WebElement datatable = driver.findElement(By.xpath("//div[@class='three-year-risk three-year-risk-wgmdr']"));
					List<WebElement> rows_table = datatable.findElements(By.tagName("tr"));
					int rows_count = rows_table.size();
					for (int row=0; row<rows_count; row++){
						List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
					    int columns_count = Columns_row.size();
        				 //  System.out.println("Three-Year Risk Statistics Data is"+row+" Value are "+columns_count);
					   
					    for (int column=0; column<columns_count; column++){
					    	String celtext = Columns_row.get(column).getText();
					    	System.out.println("Three-Year Risk Statistics Data is"+ "\t" +celtext);
					    	System.out.println("Three-Year Risk Statistics Data is"+ "\t" +celtext);
					    }					   
					}
		    	}else {
		    		String uiNoDataMsg = driver.findElement(By.xpath("//div[@class='three-year-risk three-year-risk-wgmdr']//table//tr")).getText();
		    		assertEquals(uiNoDataMsg, NO_3YEARDATA_MSG);
		    	}	 
		    }
		}catch(NoSuchElementException ex){
			System.out.println("Three-Year Risk Statistics Table is not displayed in Performance Section");
		} 
	}

	@Then("^I verify the Discrete Rolling Tab is displayed for France site$")
	public void iVerifyTheDiscreterollingTabIsDisplayedForFranceSite() throws Throwable {
		assertTrue(ProductDetailPageObject.productDetailPageObject(driver).getPerformanceDiscreteRollingTabFR().isDisplayed());	    
	}
	@And("^I click the Calander Tab for France site$")
	public void iClickTheCalanderTabForFranceSite() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getPerformanceCalenderTabFR().click();	    
	}
	@And("^I click the Annualised Tab for France site$")
	public void iClickTheAnnualisedTabForFranceSite() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getPerformanceAnnualisedTabFR().click();	    
	}
	@And("^I click the Cumulative Tab for France site$")
	public void iClickTheCumulativeTabForFranceSite() throws Throwable {
		ProductDetailPageObject.productDetailPageObject(driver).getPerformanceCumulativeTabFR().click();	    
	}
	
	
}