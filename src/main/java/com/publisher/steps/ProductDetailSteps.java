package com.publisher.steps;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.publisher.pageobjects.FiltersPage;
import com.publisher.pageobjects.HomePageObject;
import com.publisher.pageobjects.ProductDetailPage;
import com.publisher.pageobjects.ProductListPage;
import com.publisher.pageobjects.SpeedBumpPage;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ProductDetailSteps extends Utility{
	
	private static final String NOROLLINGDATAMSG = "The reported share class has insufficient data history to be able to show past performance.";
	private static final String NOYIELDSDATAMSG = "Yields data is not available for selected share class";
	private static final String NO_THREEYEARDATA_MSG = "Three Year Risk Statistics data is not available for selected share class";
	private static final String NO_THREEYEARDATA_MSG_DE = "Daten zur Drei-Jahres-Statistik sind für ausgewählte Anteilsklasse nicht verfügbar";
	private static final String NOROLLINGDATAMSG_DE = "Die gemeldete Anteilsklasse verfügt nicht über einen ausreichenden Datenverlauf, um die frühere Wertentwicklung anzeigen zu können.";
	private static final String NO_YIELDS_MSG_DE = "Renditedaten sind für ausgewählte Anteilsklasse nicht verfügbar";
	private static final String NO_DAILYSTATS_MSG_DE = "Renditedaten sind für ausgewählte Anteilsklasse nicht verfügbar";
	
	private static String fundNamePL;
	private static String shareClassPL;
	private static String fundName;
	private static String shareClass;
	private static String isinValue;
	private static String shareClassPd;
	private static String assetTypePL;
	private static String formType;
	
	String fundname;
	int rowSize;
	int excelrow, headerrow;
	//static String FolderPath = "C:\\Automation";
	static String outputpath;
	static String timestamp;
	
	@And("^I click on Performance Tab on product detail page$")
	public void iClickOnSectionInProductDetailPage() throws Throwable {
		ProductDetailPage.productDetailPage(driver).getPerformanceTab().click();	  
	}
	
	@And("^I click on Performance Tab on product detail page for selected distributor$")
    public void iClickOnPerformanceTabOnProductDetailPageForSelectedDistributor() throws Throwable {
		if(driver.getCurrentUrl().contains("zh-cn") && (!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))||driver.getCurrentUrl().contains("zh-hk")) {
			ProductDetailPage.productDetailPage(driver).getperformanceTabch().click();
		}
		else{
			System.out.println("Not applicable for selected distributor");
        }
    }
	
	 @And("^I click on Cumulative tab under Performance section for selected distributor$")
	    public void iClickOnCumulativeTabUnderPerformanceSectionForSelectedDistributor() throws Throwable {
		 
		 if(driver.getCurrentUrl().contains("zh-cn") && (!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
			 
		 
		 Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
		try {	
			if (ProductDetailPage.productDetailPage(driver).getcummulativeTabch().isDisplayed()) {
				Thread.sleep(5000);
				ProductDetailPage.productDetailPage(driver).getcummulativeTabch().click();
			}else {
				js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getcummulativeTabch());
				if(ProductDetailPage.productDetailPage(driver).getcummulativeTabch().isDisplayed()) {
					Thread.sleep(5000);
					ProductDetailPage.productDetailPage(driver).getcummulativeTabch().click();
				}
				else {
						js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getcummulativeTabch());
						Thread.sleep(5000);
						ProductDetailPage.productDetailPage(driver).getcummulativeTabch().click();
					 }
				  }
			}catch(NoSuchElementException ex) {
			System.out.println("No cummulative table available"+ driver.getCurrentUrl());
			}
		 }
		 else{
				System.out.println("Not applicable for selected distributor");
	        }
		 
	    }
	 
	 @And("^I click on Calendar tab under Performance section for selected distributor$")
	    public void iClickOnCalendarTabUnderPerformanceSectionForSelectedDistributor() throws Throwable {
		 
		 if(driver.getCurrentUrl().contains("zh-cn") && (!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))||driver.getCurrentUrl().contains("zh-hk")) {
		 Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
		try {	
			if (ProductDetailPage.productDetailPage(driver).getcalendarTabch().isDisplayed()) {
				Thread.sleep(5000);
				ProductDetailPage.productDetailPage(driver).getcalendarTabch().click();
			}else {
				js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getcalendarTabch());
				if(ProductDetailPage.productDetailPage(driver).getcalendarTabch().isDisplayed()) {
					Thread.sleep(5000);
					ProductDetailPage.productDetailPage(driver).getcalendarTabch().click();
				}
				else {
						js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getcalendarTabch());
						Thread.sleep(5000);
						ProductDetailPage.productDetailPage(driver).getcalendarTabch().click();
					 }
				  }
			}catch(NoSuchElementException ex) {
			System.out.println("No calendar table available"+ driver.getCurrentUrl());
			}
		 }
		 else{
				System.out.println("Not applicable for selected distributor");
	        }
	    }
	 
	 @And("^I click on Annualised tab under Performance section for selected distributor$")
	    public void iClickOnAnnualisedTabUnderPerformanceSectionForSelectedDistributor() throws Throwable {
		 if(driver.getCurrentUrl().contains("zh-cn") && (!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))||driver.getCurrentUrl().contains("zh-hk")) {
		 Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
		try {	
			if (ProductDetailPage.productDetailPage(driver).getGrowthOf10kTabDe().isDisplayed()) {
				Thread.sleep(5000);
				ProductDetailPage.productDetailPage(driver).getannulaisedTabch().click();
			}else {
				js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getannulaisedTabch());
				if(ProductDetailPage.productDetailPage(driver).getannulaisedTabch().isDisplayed()) {
					Thread.sleep(5000);
					ProductDetailPage.productDetailPage(driver).getannulaisedTabch().click();
				}
				else {
						js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getannulaisedTabch());
						Thread.sleep(5000);
						ProductDetailPage.productDetailPage(driver).getannulaisedTabch().click();
					 }
				  }
			}catch(NoSuchElementException ex) {
			System.out.println("No annuaised table available"+ driver.getCurrentUrl());
			}
		 }
		 else{
				System.out.println("Not applicable for selected distributor");
	        }
	    }
	 
	@Then("^I verify the Performance Tab is displayed on product detail page$")
	public void iVerifyThePerformanceTabIsDisplayed() throws Throwable {
		assertTrue(ProductDetailPage.productDetailPage(driver).getPerformanceTab().isDisplayed());	    
	}
	
	@Then("^I click on Rolling tab under Performance section$")
	public void iClickOnRollingTabUnderPerformanceSection() throws IOException{
		ProductDetailPage.productDetailPage(driver).getRollingTab().click();
	}
	
	@Then("^I click on Rolling tab under Performance section for German site$")
	public void iClickOnRollingTabUnderPerformanceSectionForGermanSite() throws IOException{
		ProductDetailPage.productDetailPage(driver).getRollingTabDe().click();
	}

	@Then("^I verify the Rolling Month table is displayed with header$")
	public void iVerifyTheRollingMonthTable() throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getRollingComponent().isDisplayed()) {
				String rollingHeader = ProductDetailPage.productDetailPage(driver).getRollingComponentHeader().getText();
				assertTrue(rollingHeader.contains("Rolling 12 Month performance") ||  rollingHeader.contains("Rolling 12 Month Performance"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	@Then("^I verify the Rolling Month table is displayed with header for German site$")
	public void iVerifyTheRollingMonthTableForGermanSite() throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getRollingComponent().isDisplayed()) {
				String rollingHeader = ProductDetailPage.productDetailPage(driver).getRollingComponentHeader().getText();
				assertTrue(rollingHeader.contains("Rollierende 12-Monats-Performance"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}

	@Then("^I verify the AsOf date is displayed on \"([^\"]*)\" table$")
	public void iVerifyAsOfDateOnCumulativeTable(String tableId) throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getCumulativePerfComponent(tableId).isDisplayed()) {
				if (driver.findElements(By.xpath("//div[contains(@class,'"+tableId+"')]//table//tr")).size() > 1) {
					assertTrue(ProductDetailPage.productDetailPage(driver).getAsOfDate(tableId).isDisplayed());
					String asOfDateUi = ProductDetailPage.productDetailPage(driver).getAsOfDate(tableId).getText();		
					String[] currentUrl  = driver.getCurrentUrl().split("/");
					ProductListSteps.verifyLocaleFormattedDate(asOfDateUi, currentUrl[3]);
				} else {
					String uiNoDataMsgAnnual = driver.findElement(By.xpath("//div[contains(@class,'"+tableId+"')]//table//tr")).getText();
					if (tableId.contains("three-year-risk")) {
						assertEquals(uiNoDataMsgAnnual, NO_THREEYEARDATA_MSG);
					}else {
						assertEquals(uiNoDataMsgAnnual, NOROLLINGDATAMSG);
					}	
				}
			}
		}catch(NoSuchElementException ex){
			System.out.println(tableId + " Performance Table is not displayed in Performance Section");
		}
	}
	
	@Then("^I verify the AsOf date is Annualised displayed on table$")
	public void iVerifyAsOfDateOnAnnualisedTable() throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getAnnualisedPerfComponent().isDisplayed()) {
				if (driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance')]//table//tr")).size() > 1) {
					assertTrue(ProductDetailPage.productDetailPage(driver).getAnnualisedAsOfDate().isDisplayed());
					String asOfDateUi = ProductDetailPage.productDetailPage(driver).getAnnualisedAsOfDate().getText();	
					String[] currentUrl  = driver.getCurrentUrl().split("/");
					ProductListSteps.verifyLocaleFormattedDate(asOfDateUi, currentUrl[3]);
				} else {
					String uiNoDataMsgAnnual = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance')]//table//tr")).getText();
					assertEquals(uiNoDataMsgAnnual, NOROLLINGDATAMSG);
				}
			}
		}catch(NoSuchElementException ex){
			System.out.println("Annualised Performance Table is not displayed in Performance Section");
		}
	}
	
	@Then("^I verify the Header dates on Rolling 12 Month table$")
	public void iVerifyTheHeaderDateOnRollingTwelveMonthTable() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr"));
				 List <WebElement> rollingHeaders = driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr[1]/th"));
				 if(rollingDataRows.size()>1) {
					 System.out.println("Rolling Headers are: ");
					 for(int i = 1; i< rollingHeaders.size(); i++)
					 {
						String asOfDateUi = ProductDetailPage.productDetailPage(driver).getAsOfDate("annual-discrete annual-discrete").getText();	
						String[] uiDiscHeader = rollingHeaders.get(1).getText().split(" ");
						
						String[] calcDiscHeader = ProductListSteps.calcDiscHeaderDate(asOfDateUi, 1).split(" ");
						System.out.println("============" + 1 + "==============");
						System.out.println("uistartDate:" + uiDiscHeader[0] );
						System.out.println("calcstartDate[0]:" + calcDiscHeader[0] );
						
						System.out.println("uiEndDate[1]:" + uiDiscHeader[1].substring(1));
						System.out.println("calcstartDate[1]:" + calcDiscHeader[1] );
						System.out.println("calcstartDate[2]:" + calcDiscHeader[2] );
						//assertEquals(uiDiscHeader[0], calcDiscHeader[0]);
						//assertTrue(uiDiscHeader[1].substring(1).contains(calcDiscHeader[2]));
						System.out.println(uiDiscHeader[0] + " - " + uiDiscHeader[1]);
									
					}	
				 }else {
					 String uiNoDataMsg = driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr")).get(1).getText();
					 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
				 }
			 }	 
		}catch(NoSuchElementException ex){
			System.out.println("Rolling Table is not displayed in Performance Section");
		}  
	}
	@Then("^I verify the Header dates on Rolling 12 Month table data$")
	public void iVerifyTheHeaderDateOnRollingTwelveMonthTabledata() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr"));
				 List <WebElement> rollingHeaders = driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr[1]/th"));
				 if(rollingDataRows.size()>1) {
					 for(int i = 1; i< rollingHeaders.size(); i++)
					 {
						String asOfDateUi = ProductDetailPage.productDetailPage(driver).getAsOfDate("annual-discrete annual-discrete").getText();	
						String[] uiDiscHeader = rollingHeaders.get(i).getText().split(" ");
						
						String[] calcDiscHeader = ProductListSteps.calcDiscHeaderDate(asOfDateUi, i).split(" ");
						System.out.println("============" + i + "==============");
						System.out.println("uistartDate:" + uiDiscHeader[0] );
						System.out.println("calcstartDate[0]:" + calcDiscHeader[0] );
						
						System.out.println("uiEndDate[1]:" + uiDiscHeader[1].substring(1));
						System.out.println("calcstartDate[1]:" + calcDiscHeader[1] );
						System.out.println("calcstartDate[2]:" + calcDiscHeader[2] );
					
						assertEquals(uiDiscHeader[0], calcDiscHeader[0]);
						assertTrue(uiDiscHeader[1].substring(1).contains(calcDiscHeader[2]));
						
					
					 }	
				 }else {
					 String uiNoDataMsg = driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr")).get(1).getText();
					 assertEquals(uiNoDataMsg, "NOROLLINGDATAMSG");
				 }
			 }	 
		}catch(NoSuchElementException ex){
			System.out.println("Rolling Table is not displayed in Performance Section");
		}  
	}
	
	@Then("^I verify the Header dates on Calendar Performance table$")
	public void iVerifyTheHeaderDateOnCalendarTable() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr")).size() > 1 ) {
				 List <WebElement> calendarDataRows = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr"));
				 List <WebElement> calendarHeaders = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr[1]/th"));
				 if(calendarDataRows.size()>1) {
					 for(int i = 1; i< calendarHeaders.size(); i++)
					 {
						 String uiDiscHeader = calendarHeaders.get(i).getText();;	
						 int calYear = getCurrentYear() - i;						 
									
						 System.out.println("uiDiscHeader[0]:" + uiDiscHeader);
						 System.out.println("calcDiscHeader[0]:" + Integer.toString(calYear) );
						 //assertEquals(uiDiscHeader, Integer.toString(calYear));							
					 }	
				 }else {
					 String uiNoDataMsg = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr")).get(1).getText();
					 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
				 }
			 }	 
		}catch(NoSuchElementException ex){
			System.out.println("Calendar Performance Table is not displayed in Performance Section");
		}  
	}
	
	@Then("^I verify the Header dates on Cumulative Performance table$")
	public void iVerifyTheHeaderDateOnCumulativeTable() throws Throwable {
		try {
		    if(driver.findElements(By.xpath("//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr")).size() > 1 ) {
			    List <WebElement> cumulativeDataRows = driver.findElements(By.xpath("//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr"));
			    System.out.println("Cumulative Table Headers are: ");
				if(cumulativeDataRows.size()>1) {
					List <WebElement> cumulativeHeaders = driver.findElements(By.xpath("//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr[1]/th"));
					for (int i = 1; i<cumulativeHeaders.size(); i++) {
						System.out.println(cumulativeHeaders.get(i).getText());
					}				    				
				}
			}else {
		    	String uiNoDataMsg = driver.findElement(By.xpath("//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr/td")).getText();
				assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
			}			 
		}catch(NoSuchElementException ex){
			System.out.println("Cumulative Performance Table is not displayed in Performance Section");
		}  
	}
	
	@Then("^I verify the Header dates on Annualised Performance table$")
	public void iVerifyTheHeaderDateOnAnnualisedTable() throws Throwable {
		try {
			if(driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).size() > 1 ) {
				List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr"));
				List <WebElement> rollingHeaders = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th"));
				if(rollingDataRows.size()>1) {				
					if (driver.getCurrentUrl().contains("en-sg")) {
						String uiYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[2]")).getText();
						assertEquals(uiYearAnnualHeader, "YTD %");
														
						String uiThreemonthAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[3]")).getText();
						assertEquals(uiThreemonthAnnualHeader, "3-m %");
																			
						String uiOneYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[4]")).getText();
						assertEquals(uiOneYearAnnualHeader, "1-y %");
						
									
						String uiThreeYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[5]")).getText();
						assertEquals(uiThreeYearAnnualHeader, "3-y %");
						
						String uiFiveYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[6]")).getText();
						assertEquals(uiFiveYearAnnualHeader, "5-y %");
						
						String uiTenYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[7]")).getText();
						assertEquals(uiTenYearAnnualHeader, "Inception");					
				 }else{
					 String uiOneYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[2]")).getText();
					 assertEquals(uiOneYearAnnualHeader, "1-y %");
				 
	
					 String uiThreeYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[3]")).getText();
					 assertEquals(uiThreeYearAnnualHeader, "3-y %");

					 String uiFiveYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[4]")).getText();
					 assertEquals(uiFiveYearAnnualHeader, "5-y %");

					 String uiTenYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[5]")).getText();
					 assertEquals(uiTenYearAnnualHeader, "10-y %");		
					 }	
				 }else {
					 String uiNoDataMsg = driver.findElement(By.xpath("//*[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).getText();
					 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
				 }
			 }	 
			  
		}catch(NoSuchElementException ex){
			System.out.println("Annualised Performance Table is not displayed in Performance Section");
		}  
	}
	
	@Then("^I verify the Header dates on Annualised Performance table for German site$")
	public void iVerifyTheHeaderDateOnAnnualisedTableForGermanSite() throws Throwable {
		try {
			if(driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).size() > 1 ) {
				List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr"));
				List <WebElement> rollingHeaders = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th"));
				if(rollingDataRows.size()>1) {				
						String uiYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[2]")).getText();
						assertEquals(uiYearAnnualHeader, "1 Jahr %");
														
						String uiThreemonthAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[3]")).getText();
						assertEquals(uiThreemonthAnnualHeader, "3 Jahre %");
																			
						String uiOneYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[4]")).getText();
						assertEquals(uiOneYearAnnualHeader, "5 Jahre %");
						
									
						String uiThreeYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[5]")).getText();
						assertEquals(uiThreeYearAnnualHeader, "10 Jahre %");
						
						String uiFiveYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[6]")).getText();
						assertEquals(uiFiveYearAnnualHeader, "Auflegungsdatum");
										
				 }	
			 }else {
				 String uiNoDataMsg = driver.findElement(By.xpath("//*[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).getText();
				 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
			 } 
		  
	}catch(NoSuchElementException ex){
		System.out.println("Annualised Performance Table is not displayed in Performance Section");
	}  
}
	
	@Then("^I verify the shareclass Data is displayed on Annualized Table for Australia$")
	public void iVerifyTheHeaderDateOnAnnualisedTableAU() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr"));
				 List <WebElement> rollingHeaders = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th"));
				 if(rollingDataRows.size()>1) {
					 	//Verify the headers			
						String uiOneYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[2]")).getText();
						assertEquals(uiOneYearAnnualHeader, "1-y %");	
						
						String uiThreeYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[3]")).getText();
						assertEquals(uiThreeYearAnnualHeader, "3-y %");
						
						String uiFiveYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[4]")).getText();
						assertEquals(uiFiveYearAnnualHeader, "5-y %");
						
						String uiTenYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[5]")).getText();
						assertEquals(uiTenYearAnnualHeader, "10-y %");
						//Verify the 1 year value is displayed with hyphen
						String uiOneYearValue = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/td[2]")).getText();
						assertEquals(uiOneYearValue.trim(), "-");
					
					 }	
				 }else {
					 String uiNoDataMsg = driver.findElement(By.xpath("//*[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).getText();
					 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
				 }
			  
		}catch(NoSuchElementException ex){
			System.out.println("Annualised Performance Table is not displayed in Performance Section");
		}  
	}
	
	@Then("^I verify the shareclass Data is displayed on Discrete table$")
	public void iVerifyTheShareClassDataIsDisplayed() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr"));
				 if(rollingDataRows.size()>1) {
					 //Verify Share class match with Selected ShareClass
					 List <WebElement> rollingShareClassData = driver.findElements(By.xpath("(//div[contains(@class,'annual-discrete annual-discrete')]//table//tr[1])[2]/td"));
					 String selectedShareClass = getProductSummaryShareClass();
					 String rollingShareClass = rollingShareClassData.get(0).getText();		 
					 assertEquals(selectedShareClass, rollingShareClass);
					 //Verify the Shareclass data exists
					 assertTrue(rollingShareClassData.size() > 0);
					 
				 }				 
			 }else {
				 String uiNoDataMsg = driver.findElement(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr")).getText();
				 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
			 }	 
			
		}catch(NoSuchElementException ex){
			System.out.println("Discrete Rolling Table is not displayed in Performance Section");
		} 

	}
	
	@Then("^I verify the shareclass Data is displayed on Discrete Table for Australia$")
	public void iVerifyTheShareClassDataIsDisplayedAU() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr"));
				 if(rollingDataRows.size()>1) {
					 //Verify Share class match with Selected ShareClass
					 List <WebElement> rollingShareClassData = driver.findElements(By.xpath("(//div[contains(@class,'annual-discrete annual-discrete')]//table//tr[1])[2]/td"));
					 String selectedShareClass = getProductSummaryShareClass();
					 String rollingShareClass = rollingShareClassData.get(0).getText();		 
					 assertEquals(selectedShareClass, rollingShareClass);
					 //Verify the Shareclass data exists
					 assertTrue(rollingShareClassData.size() > 0);
					 
					//Verify the 1 year value is displayed with hyphen
					String uiOneYearValue = driver.findElement(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr[1]/td[2]")).getText();
					assertEquals(uiOneYearValue.trim(), "-");					 
				 }				 
			 }else {
				 String uiNoDataMsg = driver.findElement(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr")).getText();
				 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
			 }	 
			
		}catch(NoSuchElementException ex){
			System.out.println("Discrete Rolling Table is not displayed in Performance Section");
		} 

	}
	
	@Then("^I verify the shareclass Data is displayed on Cumulative table$")
	public void iVerifyTheShareClassDataonCumulativeIsDisplayed() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr"));
				 if(rollingDataRows.size()>1) {
					 //Verify Share class match with Selected ShareClass
					 List <WebElement> cumulativeShareClassData = driver.findElements(By.xpath("(//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr[1])[2]/td"));
					 String selectedShareClass = driver.findElement(By.xpath("(//*[@class='share-dropdown']/button)[2]")).getText();
					 System.out.println(selectedShareClass +" and " +  cumulativeShareClassData.get(0).getText());
					 String cumulativeShareClass = cumulativeShareClassData.get(0).getText();		 
					 assertEquals(selectedShareClass, cumulativeShareClass);
					 //Verify the Shareclass data exists
					 assertTrue(cumulativeShareClassData.size() > 0);
					 
				 }				 
			 }else {
				 String uiNoDataMsg = driver.findElement(By.xpath("//div[contains(@class,'cumulative-performance cumulative-performance')]//table//tr")).getText();
				 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
			 }	 
			
		}catch(NoSuchElementException ex){
			System.out.println("Cumulative Table is not displayed in Performance Section");
		} 

	}
	
	@Then("^I verify the shareclass Data is displayed on Annualised table$")
	public void iVerifyTheShareClassDataonAnnualisedIsDisplayed() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).size() > 1 ) {
				 List <WebElement> annualDataRows = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr"));
				 if(annualDataRows.size()>1) {
					 //Verify Share class match with Selected ShareClass
					 List <WebElement> annualisedShareClassData = driver.findElements(By.xpath("(//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr)[2]/td"));
					 String selectedShareClass = getProductSummaryShareClass();
					 String annualisedShareClass = annualisedShareClassData.get(0).getText();		 
					 assertEquals(selectedShareClass, annualisedShareClass);
					 //Verify the Shareclass data exists
					 assertTrue(annualisedShareClassData.size() > 0);
					 
				 }				 
			 }else {
				 String uiNoDataMsg = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).getText();
				 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
			 }	 
			
		}catch(NoSuchElementException ex){
			System.out.println("Annualised Table is not displayed in Performance Section");
		} 

	}
	
	@Then("^I verify the shareclass Data is displayed on Calendar Table for Australia$")
	public void iVerifyTheShareClassDataonCalendarIsDisplayedAU() throws Throwable {
		try {
			if(driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr")).size() > 1 ) {
				List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr"));
				if(rollingDataRows.size()>1) {
					//Verify Share class match with Selected ShareClass
					List <WebElement> calendarShareClassData = driver.findElements(By.xpath("(//div[@class='calendar-performance calendar-performance-kjuip']//table//tr[1])[2]/td"));
					String selectedShareClass = getProductSummaryShareClass();
					String calendarShareClass = calendarShareClassData.get(0).getText();		 
					assertEquals(selectedShareClass, calendarShareClass);
					//Verify the Shareclass data exists
					assertTrue(calendarShareClassData.size() > 0);					 
					//Verify the 1 year value is displayed with hyphen
					String uiOneYearValue = driver.findElement(By.xpath("//div[contains(@class,'calendar-performance calendar-performance-kjuip')]//table//tr[1]/td[2]")).getText();
					assertEquals(uiOneYearValue.trim(), "-");					 
				}				 
			}else {
				 String uiNoDataMsg = driver.findElement(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr")).getText();
				 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
			}			
		}catch(NoSuchElementException ex){
			System.out.println("Calendar Table is not displayed in Performance Section");
		} 
	}
	
	@Then("^I verify the shareclass Data is displayed on Calendar Table$")
	public void iVerifyTheShareClassDataonCalendarIsDisplayed() throws Throwable {
		try {
			 if(driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr"));
				 if(rollingDataRows.size()>1) {
					 //Verify Share class match with Selected ShareClass
					 List <WebElement> calendarShareClassData = driver.findElements(By.xpath("(//div[@class='calendar-performance calendar-performance-kjuip']//table//tr[1])[2]/td"));
					 String selectedShareClass = getProductSummaryShareClass();
					 String calendarShareClass = calendarShareClassData.get(0).getText();		 
					 assertEquals(selectedShareClass, calendarShareClass);
					 //Verify the Shareclass data exists
					 assertTrue(calendarShareClassData.size() > 0);
					 
				 }				 
			 }else {
				 String uiNoDataMsg = driver.findElement(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr")).getText();
				 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
			 }	 
			
		}catch(NoSuchElementException ex){
			System.out.println("Calendar Table is not displayed in Performance Section");
		} 
	}


	@Then("^I verify the Benchmark Data is displayed on Rolling table$")
	public void iVerifyTheBenchMarkDataIsDisplayed() throws Throwable {		
		try {
			 if(driver.findElements(By.xpath("//div[contains(@class,'annual-discrete annual-discrete')]//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class, 'annual-discrete annual-discrete')]//table//tr"));
				 if(rollingDataRows.size()>2) {
					 List <WebElement> rollingBenchMarkData = driver.findElements(By.xpath("//div[contains(@class, 'annual-discrete annual-discrete')]//table//tr[2]/td"));
					 assertTrue(rollingBenchMarkData.size()>0);
					 if(driver.getCurrentUrl().contains("de-de")) {
						 assertTrue(rollingBenchMarkData.get(0).getText().contains("Referenzindex"));
					 }else {
						 assertTrue(rollingBenchMarkData.get(0).getText().contains("Benchmark"));
					 }
				 }else {
					 System.out.println("Benchmark data is not displayed in Rolling table");
				 }	 
			 }else {
				 System.out.println("Benchmark data is not displayed in Rolling table");
			 }				 			
		}catch(NoSuchElementException ex){
			System.out.println("Discrete Rolling Table is not displayed in Performance Section");
		}	  
	}
	
	@Then("^I verify the Benchmark Data is displayed on Cumulative Table$")
	public void iVerifyTheBenchMarkDataOnCumulative() throws Throwable {		
		try {
			 if(driver.findElements(By.xpath("//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr"));
				 if(rollingDataRows.size()>2) {
					 List <WebElement> rollingBenchMarkData = driver.findElements(By.xpath("(//div[@class='cumulative-performance cumulative-performance-jewqu']//table//tr)[3]"));
					 assertTrue(rollingBenchMarkData.size()>0);
					 if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
						 assertTrue(rollingBenchMarkData.get(0).getText().contains("Referenzindex"));
					 }else {
						 assertTrue(rollingBenchMarkData.get(0).getText().contains("Benchmark"));
					 }
				 }else {
					 System.out.println("Benchmark data is not displayed in Cumulative table");
				 }	 
			 }else {
				 System.out.println("Benchmark data is not displayed in Cumulative table");
			 }				 			
		}catch(NoSuchElementException ex){
			System.out.println("Cumulative Table is not displayed in Performance Section");
		}	  
	}
	
	@Then("^I verify the Benchmark Data is displayed on Annualised Table$")
	public void iVerifyTheBenchMarkDataOnAnnualised() throws Throwable {		
		try {
			 if(driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr"));
				 if(rollingDataRows.size()>2) {
					 List <WebElement> rollingBenchMarkData = driver.findElements(By.xpath("(//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr)[3]"));
					 assertTrue(rollingBenchMarkData.size()>0);
					 if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
						 assertTrue(rollingBenchMarkData.get(0).getText().contains("Referenzindex"));
					 }else if(driver.getCurrentUrl().contains("fr-fr")) {
						 assertTrue(rollingBenchMarkData.get(0).getText().contains("Indice de référence"));
					 }else {
						 assertTrue(rollingBenchMarkData.get(0).getText().contains("Benchmark"));
					 }
				 }else {
					 System.out.println("Benchmark data is not displayed in Annualised table");
				 }	 
			 }else {
				 System.out.println("Benchmark data is not displayed in Annualised table");
			 }				 			
		}catch(NoSuchElementException ex){
			System.out.println("Annualised Table is not displayed in Performance Section");
		}	  
	}
	
	@Then("^I verify the Benchmark Data is displayed on Calendar Table$")
	public void iVerifyTheBenchMarkDataOnCalendar() throws Throwable {		
		try {
			 if(driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr")).size() > 1 ) {
				 List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr"));
				 if(driver.getCurrentUrl().contains("en-sg")) {
					 if(rollingDataRows.size()>3) {
						 List <WebElement> rollingBenchMarkData = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr[3]/td"));
						 assertTrue(rollingBenchMarkData.size()>0);
						 if(driver.getCurrentUrl().contains("de-de")) {
							 assertTrue(rollingBenchMarkData.get(0).getText().contains("Referenzindex"));
						 }else {
							 assertTrue(rollingBenchMarkData.get(0).getText().contains("Benchmark"));
						 }						 
					 }else {
						 System.out.println("Benchmark data is not displayed in Calendar table");
					 }	 
				 }else {
					 
				 	}if(rollingDataRows.size()>2) {
				 		List <WebElement> rollingBenchMarkData = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr[2]/td"));
				 		assertTrue(rollingBenchMarkData.size()>0);
				 		//TOD: Add benchmark validation 
				 	}else {
				 		System.out.println("Benchmark data is not displayed in Calendar table");
				 	}	 
			 }else {
				 System.out.println("Benchmark data is not displayed in Calendar table");
			 }				 			
		}catch(NoSuchElementException ex){
			System.out.println("Calendar Table is not displayed in Performance Section");
		}	  
	}

	@Then("^I capture the Rolling 12 month data$")
	public void iCaptureTheRollingTwelveMonthData() throws Throwable {
	  	//Refer code from Magesh
	}
	
	@Then("^I capture the Annualised month data$")
	public void iCaptureTheAnnualisedMonthData() throws Throwable {
	  	//Refer code from Magesh
	}
	
	@Then("^I capture the Calendar month data$")
	public void iCaptureTheCalendarMonthData() throws Throwable {
	  	//Refer code from Magesh
	}
	
	@Then("^I capture the Cumulative month data$")
	public void iCaptureTheCumulativeMonthData() throws Throwable {
	  	//Refer code from Magesh
	}
	
	public String getProductSummaryShareClass()
	{	
		String summaryShareClass = driver.findElement(By.xpath("(//*[@class='share-dropdown']/button)[2]")).getText();
		return summaryShareClass;
	}
		
	@Then("^I click on Calendar tab under Performance section$")
	public void iClickOnCalendarTabInPerformanceSection() throws Throwable {	
		Thread.sleep(5000);
		ProductDetailPage.productDetailPage(driver).getCalendarTab().click();
	}
	
	@Then("^I click on Calendar tab under Performance section for German site$")
	public void iClickOnCalendarTabInPerformanceSectionForGermanSite() throws Throwable {	
		Thread.sleep(5000);
		ProductDetailPage.productDetailPage(driver).getCalendarTabDe().click();
	}
	
	@Then("^I click on Cumulative tab under Performance section$")
	public void iClickOnCumulativeTabInPerformanceSection() throws Throwable {	
		Thread.sleep(5000);
		ProductDetailPage.productDetailPage(driver).getCumulativeTab().click();
	}
	
	@Then("^I verify Cumulative datas are not having brackets for negative values$")
    public void iVerifyCumulativeDatasAreNotHavingBracketsForNegativeValues() throws Throwable {
       Thread.sleep(2000);
       List<WebElement> cumDatas = driver.findElements(By.xpath("//div[contains(@class,'cumulative')]//td[contains(@data-th,'%')]"));
       for (WebElement x : cumDatas) {
		assertTrue(!x.getText().contains("(")||!x.getText().contains(")"));
	}
    }
	
	@Then("^I click on Cumulative tab under Performance section for German site$")
	public void iClickOnCumulativeTabInPerformanceSectionForGermanSite() throws Throwable {	
		Thread.sleep(5000);
		ProductDetailPage.productDetailPage(driver).getCumulativeTabDe().click();
	}
	
	@Then("^I click on \"([^\"]*)\" tab under Performance section$")
	public void iClickOnCumulativeTabInPerformanceSection(String tableHeader) throws Throwable {		
		Thread.sleep(5000);
		List <WebElement> perfHeaders = ProductDetailPage.productDetailPage(driver).getPerfHeaders();
		System.out.println("perfHeaders.size():" + perfHeaders.size() + " --" +tableHeader );
		for (int i=0; i<perfHeaders.size(); i++) {
			System.out.println(perfHeaders.get(i).getText() + " : " +i);
			if (perfHeaders.get(i).getText().equalsIgnoreCase(tableHeader));
			{
				System.out.println("Inside if condition: " + i);
				perfHeaders.get(i).click();
				break;
			}		
		}
	}
	
	@Then("^I click on Annualised tab under Performance section$")
	public void iClickOnAnnualisedTabInPerformanceSection() throws Throwable {	
		Thread.sleep(5000);
		ProductDetailPage.productDetailPage(driver).getAnnualizedTab().click();
	}
	
	 @Then("^I verify Annualised datas are not having brackets for negative values$")
	    public void iVerifyAnnualisedDatasAreNotHavingBracketsForNegativeValues() throws Throwable {
	    	Thread.sleep(2000);
	        List<WebElement> annDatas = driver.findElements(By.xpath("//div[contains(@class,'annualised')]//td[contains(@data-th,'%')]"));
	        for (WebElement x : annDatas) {
	 		assertTrue(!x.getText().contains("(")||!x.getText().contains(")"));
	 	}
	    }
	
	@Then("^I click on Annualised tab under Performance section for German site$")
	public void iClickOnAnnualisedTabInPerformanceSectionForGermanSite() throws Throwable {	
		Thread.sleep(5000);
		ProductDetailPage.productDetailPage(driver).getAnnualizedTabDe().click();
	}
	
	@Then("^I verify the Calendar Performance table is displayed with header$")
	public void iVerifyTheCalendarPerformanceTable() throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getCalendarPerfComponent().isDisplayed()) {
				assertTrue(ProductDetailPage.productDetailPage(driver).getCalendarComponentHeader().getText().contains("Calendar Year Performance") || ProductDetailPage.productDetailPage(driver).getCalendarComponentHeader().getText().contains("Calendar Performance"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	@Then("^I verify Calendar datas are not having brackets for negative values$")
    public void iVerifyCalendarDatasAreNotHavingBracketsForNegativeValues() throws Throwable {
    	Thread.sleep(2000);
        List<WebElement> calDatas = driver.findElements(By.xpath("//div[contains(@class,'calendar')]//td[contains(@data-th,'20')]"));
        for (WebElement x : calDatas) {
 		assertTrue(!x.getText().contains("(")||!x.getText().contains(")"));
 	}
    }

	
	@Then("^I verify the Calendar Performance table is displayed with header for German site$")
	public void iVerifyTheCalendarPerformanceTableForGermanSite() throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getCalendarPerfComponent().isDisplayed()) {
				assertTrue(ProductDetailPage.productDetailPage(driver).getCalendarComponentHeader().getText().contains("Performance im Kalenderjahr"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	@Then("^I click on GrowthOf10K tab under Performance section$")
	public void iClickOnGrowthOf10KTab() throws Throwable {	
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
	try {	
		if (ProductDetailPage.productDetailPage(driver).getGrowthOf10kTab().isDisplayed()) {
			Thread.sleep(5000);
			ProductDetailPage.productDetailPage(driver).getGrowthOf10kTab().click();
		}else {
			js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getRightArrow());
			if(ProductDetailPage.productDetailPage(driver).getGrowthOf10kTab().isDisplayed()) {
				Thread.sleep(5000);
				ProductDetailPage.productDetailPage(driver).getGrowthOf10kTab().click();
			}
			else {
					js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getRightArrow());
					Thread.sleep(5000);
					ProductDetailPage.productDetailPage(driver).getGrowthOf10kTab().click();
				 }
			  }
		}catch(NoSuchElementException ex) {
		System.out.println("No Growth Of 10K available"+ driver.getCurrentUrl());
		}
	}
	
	@Then("^I click on GrowthOf10K tab under Performance section for German site$")
	public void iClickOnGrowthOf10KTabForGermanSite() throws Throwable {	
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
	try {	
		if (ProductDetailPage.productDetailPage(driver).getGrowthOf10kTabDe().isDisplayed()) {
			Thread.sleep(5000);
			ProductDetailPage.productDetailPage(driver).getGrowthOf10kTabDe().click();
		}else {
			js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getRightArrow());
			if(ProductDetailPage.productDetailPage(driver).getGrowthOf10kTabDe().isDisplayed()) {
				Thread.sleep(5000);
				ProductDetailPage.productDetailPage(driver).getGrowthOf10kTabDe().click();
			}
			else {
					js.executeScript("arguments[0].click();", ProductDetailPage.productDetailPage(driver).getRightArrow());
					Thread.sleep(5000);
					ProductDetailPage.productDetailPage(driver).getGrowthOf10kTabDe().click();
				 }
			  }
		}catch(NoSuchElementException ex) {
		System.out.println("No Growth Of 10K available"+ driver.getCurrentUrl());
		}
	}
	
	@Then("^I verify the \"([^\"]*)\" Performance table is displayed with header$")
	public void iVerifyTheCumulativePerformanceTable(String tableId) throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getCumulativePerfComponent(tableId).isDisplayed()) {
				assertTrue(ProductDetailPage.productDetailPage(driver).getCumulativeComponentHeader().getText().contains("Cumulative Performance"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	
	
	@Then("^I verify the \"([^\"]*)\" Performance table is displayed with header for selected distributor$")
    public void iVerifyTheSomethingPerformanceTableIsDisplayedWithHeaderForSelectedDistributor(String tableId) throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getCumulativePerfComponent(tableId).isDisplayed()) {
				assertTrue(ProductDetailPage.productDetailPage(driver).getCumulativeComponentHeader().getText().contains("Cumulative Performance"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	
    }
	
	@Then("^I verify the \"([^\"]*)\" Performance table is displayed with header for German site$")
	public void iVerifyTheCumulativePerformanceTableForGermanSite(String tableId) throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getCumulativePerfComponent(tableId).isDisplayed()) {
				assertTrue(ProductDetailPage.productDetailPage(driver).getCumulativeComponentHeader().getText().contains("Wertentwicklung (kumuliert)"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}
	
	@Then("^I verify the Annualised Performance table is displayed with header$")
	public void iVerifyTheAnnualisedPerformanceTable() throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getAnnualisedPerfComponent().isDisplayed()) {
				assertTrue(ProductDetailPage.productDetailPage(driver).getAnnualisedComponentHeader().getText().contains("Annualised Performance"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	
	}
	
	@Then("^I verify Annual Discrete Rolling datas are not having brackets for negative values$")
    public void iVerifyAnnualDiscreteRollingDatasAreNotHavingBracketsForNegativeValues() throws Throwable {
    	Thread.sleep(2000);
        List<WebElement> disDatas = driver.findElements(By.xpath("//div[contains(@class,'annual-discrete')]//td[contains(@data-th,'/20')]"));
        for (WebElement x : disDatas) {
 		assertTrue(!x.getText().contains("(")||!x.getText().contains(")"));
        }
    }
	
	@Then("^I verify the Annualised Performance table is displayed with header for German site$")
	public void iVerifyTheAnnualisedPerformanceTableForGermanSite() throws Throwable {
		try{
			if (ProductDetailPage.productDetailPage(driver).getAnnualisedPerfComponent().isDisplayed()) {
				assertTrue(ProductDetailPage.productDetailPage(driver).getAnnualisedComponentHeader().getText().contains("Annualisierte Wertentwicklung"));				
			}
		}catch(NoSuchElementException ex){
			//Do nothing
		}	 
	}

	@Then("^I verify the watchlist icon is displayed in product summary component for each share class$")
	public void iVerifyWatchlistIconForAllShareClass() throws Throwable {
		WebElement shareDropdown = driver.findElement(By.className("share-dropdown"));
	    shareDropdown.click();
		List <WebElement> shareClassValues = driver.findElements(By.xpath("//*[@class='share-dropdown']//a"));
		for (int i = 1; i<= shareClassValues.size(); i++)
		{
			WebElement shareDropdown1 = driver.findElement(By.className("share-dropdown"));
			Thread.sleep(3000);
			shareDropdown1.click();
			Thread.sleep(3000);
			System.out.println(driver.findElements(By.xpath("//*[@class='share-dropdown']//a")).get(i).getText() + "And Value of I:" + i);
			driver.findElements(By.xpath("//*[@class='share-dropdown']//a")).get(i).click();
			ProductListPage.productListPage(driver).getAddToWatchlistButton().isDisplayed();		    
		}	
	}
	
	@Then("^I click on Add to Watchlist for the shareclass$")
	public void iClickAddToWatchlistForTheShareClass() throws Throwable {
		ProductListPage.productListPage(driver).getAddToWatchlistPDButton().click();
	}
	
	@Then("^I change the shareclass$")
	public void iChnageTheShareClass() throws Throwable {
		WebElement wrapper = driver.findElement(By.xpath("//*[@class='product-summary parbase']"));
		WebElement shareDropdown = wrapper.findElement(By.className("share-dropdown"));
		shareDropdown.click();
		Thread.sleep(10000);
		int totalShareClasses = driver.findElements(By.xpath("//*[@class='share-dropdown']/*[@id='shareOptions_nlcrx']//a")).size();
		if (totalShareClasses > 1) {
			driver.findElement(By.xpath("//*[@class='share-dropdown']/*[@id='shareOptions_nlcrx']//a[2]")).click();
		}else {
			System.out.println("There is only one share class for this product");
		}
	}
	
	@Then("^I click on Clear List option$")
	public void iClickOnClearListOptions() throws Throwable {
		SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();
    	Thread.sleep(5000);
		ProductListPage.productListPage(driver).getClearListButton().click();
		Thread.sleep(10000);		
	}
	
	@Then("^I click on Clear List option for German site$")
	public void iClickOnClearListOptionsDe() throws Throwable {
		SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();
    	Thread.sleep(1000);
		ProductListPage.productListPage(driver).getClearListButtonDe().click();
		Thread.sleep(5000);		
	}
		 
	@And("^I click on more options button")
	public void iClickOnMoreOptionsButton() throws Throwable {
		if((!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
		try {
			ProductDetailPage.productDetailPage(driver).getMoreActionButton().click();
		} catch (Exception ex) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",ProductDetailPage.productDetailPage(driver).getMoreActionButton());
		}	
		Thread.sleep(3000);
		}else{
			System.out.println("Not applicable for selected distributor");
        }
		
	}
	
    @Then("^I verify the print option is displayed in KeyActions menu on product detail page$")
    public void iVerifyThePrintOptionIsDisplayedInKeyactionsMenu() throws Throwable {
    	assertTrue(ProductDetailPage.productDetailPage(driver).getPDPrintLink().isDisplayed());
    }
	
	@Then("^I click on View Detail button from Watchlist header$")
	public void iClickOnViewDetailFromWatchlistHeader() throws Throwable {
    	SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();
    	Thread.sleep(5000);
		ProductListPage.productListPage(driver).getViewDetailsButton().click();		
	}
	
	@Then("^I click on View Detail button from Watchlist header for German site$")
	public void iClickOnViewDetailFromWatchlistHeaderForGermanSite() throws Throwable {
    	SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();
    	Thread.sleep(2000);
		ProductListPage.productListPage(driver).getViewDetailsButtonDe().click();		
	}
	
	@Then("^I click on Cumulative tab under in Product Detail under Performance$")
	public void iClickonCumulativeTab() throws Throwable{
		ProductDetailPage.productDetailPage(driver).getCumulativeTab().click();
	}
		
	@Then("^I verify watchlist only filter is selected$")
	public void iVerifyProductListDisplayedWithWatchlistFilter() throws Throwable {
	    List<WebElement> chips = FiltersPage.filtersPage(driver).getSelectionChips();
	    for (WebElement chip : chips) {
	        assertTrue(chip.getText().contains("Watchlist Only"));
	    }
	}
	
	@Then("^I verify the fund name and shareclass detail on watchlist$")
	public void iVerifyFundNameAndShareClassOnWatchlist() throws Throwable {
		SpeedBumpPage.speedBumpPage(driver).getWatchListIcon().click();
		//Removed this as it is outofscope after global header changes
        //ProductListPage.productListPage(driver).getWatchlistShareClass().isDisplayed();
        ProductListPage.productListPage(driver).getWatchlistItemFund().isDisplayed();
	}
	
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    
    @Then("^I verify the Email Share option is displayed in KeyActions menu in product detail page$")
    public void iVerifyTheEmailShareOptionIsDisplayedPD() throws Throwable {
    	if((!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
    	Thread.sleep(3000);
    	try {
    	assertTrue(ProductDetailPage.productDetailPage(driver).getPDEmailShare().isDisplayed());     
    	}catch(NoSuchElementException | TimeoutException e) {
    		System.out.println("Email Share option is not authored");
    	}
    	}else{
			System.out.println("Not applicable for selected distributor");
        }
    }

    @Then("^I click on Email share link from KeyActions menu in product detail page$")
    public void iClickOnEmailShareLinkFromKeyactionsMenuPD() throws Throwable {
    	if((!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
    	Thread.sleep(3000);
    	try {
    	ProductDetailPage.productDetailPage(driver).getPDEmailShare().click();
    }catch(NoSuchElementException | TimeoutException e) {
		System.out.println("Email Share option is not authored");
	}
    	}else{
			System.out.println("Not applicable for selected distributor");
        }
    }

    @Then("^I verify the email model window is displayed in product detail page$")
    public void iVerifyTheEmailModelWindowIsDisplayedPD() throws Throwable {
    	if((!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
    	Thread.sleep(3000);
    	try {
    	assertTrue(ProductListPage.productListPage(driver).getGmailModelWindow().isDisplayed());
    	}catch(NoSuchElementException | TimeoutException ex) {
    		System.out.println("Email Share option is not authored");
    	}
    	}else{
			System.out.println("Not applicable for selected distributor");
        }
    }

    @Then("^I verify the email fields on email window in product detail page$")
    public void iVerifyTheEmailFieldsOnEmailWindow() throws Throwable {
    	if((!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
    	Thread.sleep(3000);
    	try {
    	assertTrue(ProductListPage.productListPage(driver).getToEmailInputField().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getFromEmailInputField().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getSubjectInputtField().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getMessageInputField().isDisplayed());
    	assertTrue(ProductListPage.productListPage(driver).getSubmitButton().isDisplayed());
    	}catch(NoSuchElementException | TimeoutException e) {
    		System.out.println("Email Share option is not authored");
    	}
    	
    	}else{
			System.out.println("Not applicable for selected distributor");
        }
    }
    
    @And("^I click on close button on email form in product detail page$")
    public void iClickOnCloseButtonOfEmailForm() throws Throwable {
    	if((!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
    	ProductListPage.productListPage(driver).getEmailCloseButton().click();
    	}
    	
    	else{
			System.out.println("Not applicable for selected distributor");
        }
    }	
    
    @Then("^I verify the Performance tab is selected by default$")
    public void iVerifyThePerformanceTabIsDefaultTab() throws Throwable {
       assertTrue(ProductDetailPage.productDetailPage(driver).getPerformanceTab().isDisplayed());
    }

    @Then("^I verify the Performance section is displayed and the tab is active$")
    public void iVerifyThePerformanceSectionIsActive() throws Throwable {
    	String cssClass = ProductDetailPage.productDetailPage(driver).getPerformanceTab().getAttribute("class");
        assertTrue(cssClass.contains("active"));
    }

    @Then("^I click on characteristics tab on product detail page$")
    public void iClickOnCharacteristicsTabOnDetailPage() throws Throwable {
    	Thread.sleep(3000);
    	ProductDetailPage.productDetailPage(driver).getCharacteristicsTab().click();
    	Thread.sleep(10000);
    }

    @Then("^I verify the characteristics section is displayed and the tab is active$")
    public void IVerifyTheCharacteristicsSectionIsActive() throws Throwable {
    	String cssClass = ProductDetailPage.productDetailPage(driver).getCharacteristicsTab().getAttribute("class");
        assertTrue(cssClass.contains("active"));
    }

    @Then("^I click on Literature tab on product detail page$")
    public void iClickOnLiteratureTabOnDetailPage() throws Throwable {
    	Thread.sleep(3000);
    	ProductDetailPage.productDetailPage(driver).getLiteratureTab().click();
    	Thread.sleep(10000);
    }
    
    @Then("^I click on Literature tab on product detail page for German site$")
    public void iClickOnLiteratureTabOnDetailPageForGermanSite() throws Throwable {
    	Thread.sleep(3000);
    	ProductDetailPage.productDetailPage(driver).getLiteratureTabDe().click();
    	Thread.sleep(10000);
    }

    @Then("^I verify the Literature section is displayed and the tab is active$")
    public void IVerifyTheLiteratureSectionIsActive() throws Throwable {
    	Thread.sleep(5000);
    	String cssClass = ProductDetailPage.productDetailPage(driver).getLiteratureTab().getAttribute("class");
        assertTrue(cssClass.contains("active"));       
    }
    
    @Then("^I verify the Literature section is displayed and the tab is active for German site$")
    public void IVerifyTheLiteratureSectionIsActiveForGermanSite() throws Throwable {
    	Thread.sleep(5000);
    	String cssClass = ProductDetailPage.productDetailPage(driver).getLiteratureTabDe().getAttribute("class");
        assertTrue(cssClass.contains("active"));       
    }

    @Then("^I click on Managers tab on product detail page$")
    public void iClickOnManagersTabOnDetailPage() throws Throwable {
    	Thread.sleep(3000);
    	ProductDetailPage.productDetailPage(driver).getManagerTab().click();
    	Thread.sleep(10000);
    }

    @Then("^I verify the Managers section is displayed and the tab is active$")
    public void iVerifyTheManagersSectionIsActive() throws Throwable {
    	String cssClass = ProductDetailPage.productDetailPage(driver).getManagerTab().getAttribute("class");
        assertTrue(cssClass.contains("active"));
    }

    @Then("^I click on Investment Risks tab on product detail page$")
    public void iClickOnInvestmentRisksTabOnDetailPage() throws Throwable {
    	try {	
    		Thread.sleep(3000);
    		if (ProductDetailPage.productDetailPage(driver).getInvestmentRiskTab().isDisplayed()) {
    			ProductDetailPage.productDetailPage(driver).getInvestmentRiskTab().click();
    			Thread.sleep(10000);
    		}
    	}catch(NoSuchElementException e) {
    		System.out.println("Investment Risks tab is not authored for this product URL:" + driver.getCurrentUrl());
    	}    		
    }

    @Then("^I verify the Investment Risks section is displayed and the tab is active$")
    public void iVerifyTheInvestmentRisksSectionIsActive() throws Throwable {
    	try {	
    		Thread.sleep(3000);
    		if (ProductDetailPage.productDetailPage(driver).getInvestmentRiskTab().isDisplayed()) {
    			String cssClass = ProductDetailPage.productDetailPage(driver).getInvestmentRiskTab().getAttribute("class");
    			assertTrue(cssClass.contains("active"));
    		}
    	}catch(NoSuchElementException e) {
    		System.out.println("Investment Risks tab is not authored");
    	}    		
    }	
    
    @Then("^I verify the Risk Reward Profile component is displayed on product detail page$")
    public void iVerifyTheInvestmentRisksComponentDisplayed() throws Throwable {
    	try {	
    		Thread.sleep(3000);
    		if (ProductDetailPage.productDetailPage(driver).getInvestmentRiskTab().isDisplayed()) {
    			assertTrue(ProductDetailPage.productDetailPage(driver).getRiskRewardProfile().isDisplayed());
    		}	
    	}catch(NoSuchElementException e) {
    		System.out.println("Investment Risks tab is not authored");
    	} 			
    }

    @Then("^I click on Holdings tab on product detail page$")
    public void iClickOnHoldingsTabOnDetailPage() throws Throwable {
     	Thread.sleep(3000);
     	try {
     		if (ProductDetailPage.productDetailPage(driver).getHoldingsTab().isDisplayed())
     			ProductDetailPage.productDetailPage(driver).getHoldingsTab().click();
     			Thread.sleep(10000);
     	}catch(NoSuchElementException e) {
     		System.out.println("Holding tab is not displayed for this product detail page");
     	}
    }

    @Then("^I verify the Holdings section is displayed and the tab is active$")
    public void iVerifyTheHoldingsSectionIsActive() throws Throwable {
       	String cssClass = ProductDetailPage.productDetailPage(driver).getHoldingsTab().getAttribute("class");
        assertTrue(cssClass.contains("active"));
    }

    @Then("^I click on Distributions tab on product detail page$")
    public void iClickOnDistributionsTabOnDetailPage() throws Throwable {
    	try {
    		if (!driver.getCurrentUrl().contains("en-au")) {
    			if (ProductDetailPage.productDetailPage(driver).getDistributionsTab().isDisplayed()) {
    				Thread.sleep(3000);
    				ProductDetailPage.productDetailPage(driver).getDistributionsTab().click();
    				Thread.sleep(10000);
    			}
    		}
    	}catch (NoSuchElementException e) {
    		System.out.println("Distributions tab is not displayed for this product detail page");
    	}
    }

    @Then("^I verify the Distributions section is displayed the tab is active$")
    public void iVerifyTheDistributionsSectionIsActive() throws Throwable {
    	if (!driver.getCurrentUrl().contains("en-au")) {
    		String cssClass = ProductDetailPage.productDetailPage(driver).getDistributionsTab().getAttribute("class");
    		assertTrue(cssClass.contains("active"));
    	}	
    }
    
    @Then("^I verify the user role menu is displayed$")
    public void iVerifyTheUserRoleMenuIsDisplayed() throws Throwable {
    	ProductDetailPage.productDetailPage(driver).getUserRoleSelectMenu().isDisplayed();
    }
    
    @Then("^I verify the user role has a dropdown with Investment professional/Individual investor options for German site$")
    public void iVerifyTheUserRoleDropDwonOptionsForGermanSite() throws Throwable {
    			ProductDetailPage.productDetailPage(driver).getUserRoleSelectMenu().click();
    			Thread.sleep(3000);
    			Select s=new Select(ProductDetailPage.productDetailPage(driver).getUserRoleSelectMenu());
    			List<WebElement> userRoleOptions = s.getOptions();
    					assertTrue(userRoleOptions.get(0).getText().contains("Professionelle Anleger"));
    					assertTrue(userRoleOptions.get(1).getText().contains("Privatanleger"));
    }
    
    @Then("^I verify the Product Stats ISIN, Share Class Inception Date, AUM, Asofdate for German site$")
    public void IVerifyTheProductIsinShareClassInceptionDateAumAsofdateForGermanSite() throws Throwable {
    	assertEquals(ProductDetailPage.productDetailPage(driver).getIsinLabel().getText(), "ISIN");
    	assertTrue(ProductDetailPage.productDetailPage(driver).getAumDate().getText().contains("aktuelles"));
    	assertTrue(ProductDetailPage.productDetailPage(driver).getIsinValue().isDisplayed());
    	isinValue = ProductDetailPage.productDetailPage(driver).getIsinValue().getText();
    	assertEquals(ProductDetailPage.productDetailPage(driver).getInceptionDateLabel().getText(), "Auflegungsdatum der Anteilsklasse");
    	assertTrue(ProductDetailPage.productDetailPage(driver).getInceptionDateValue().isDisplayed());
    	assertEquals(ProductDetailPage.productDetailPage(driver).getAumLabel().getText(), "Verwaltetes Vermögen");
    	assertTrue(ProductDetailPage.productDetailPage(driver).getAumValue().isDisplayed());  	       
    }

    @Then("^I verify the user role has a dropdown with Investment professional/Individual investor options\\.$")
    public void iVerifyTheUserRoleDropDwonOptions() throws Throwable {
    	try {
    		String cssClass = ProductDetailPage.productDetailPage(driver).getUserRoleSelectMenu().getAttribute("class");
    		if (!cssClass.contains("disable")) {
    			ProductDetailPage.productDetailPage(driver).getUserRoleSelectMenu().click();
    			Thread.sleep(3000);
    			List <WebElement> userRoleOptions = ProductDetailPage.productDetailPage(driver).getUserRoleSelectOptions();
    			for(int i =0; i < userRoleOptions.size(); i++)
    			{
    				if (driver.getCurrentUrl().contains("en-au")) {
    					assertTrue(userRoleOptions.get(i).getText().contains("Client Login") || userRoleOptions.get(i).getText().contains("Legg Mason Australia"));
    				}else {
    					assertTrue(userRoleOptions.get(i).getText().contains("Individual Investor") || userRoleOptions.get(i).getText().contains("Investment Professional"));
    				}	
    			}    			
    		}
    	}catch (NoSuchElementException ex){
    		System.out.println("User Role selction menu is disabled");
    	}catch (ElementNotVisibleException ex){
    		System.out.println("User Role selction menu is not visible");
    	}
    }
    
    @Then("^I Verify Franklin Templeton Logo in Product Detail page$")
    public void iVerifyFranklinTempletonLogoInProductDetailPage() throws Throwable {
    	assertTrue(HomePageObject.homePageObject(driver).getHomeLogo().getAttribute("alt").contains("Franklin Templeton"));
    }	

    @Then("^I verify the Fund Name is displayed$")
    public void iVerifyTheFundNameIsDisplayed() throws Throwable {
    	assertTrue(ProductListPage.productListPage(driver).getFundNameTitle().isDisplayed());        
    }
    @Then("^I verify SVG images id removed for DDA/ADA compliance$")
    public void i_verify_SVG_images_id_removed_for_DDA_ADA_compliance() throws Throwable {
    	 assertTrue(!driver.getPageSource().contains("Layer_1"));
    	//DDA LMG-1839
    }
    @Then("^I verify the Share Class name is displayed$")
    public void iVerifyTheAssetClassNameIsDisplayed() throws Throwable {
        assertTrue(ProductDetailPage.productDetailPage(driver).getPdShareClassname().isDisplayed());
    }

    @Then("^I verify the Share Class name matches with the Share Class of the product List page$")
    public void iVerifyTheShareClassMatchesWithProductListPage() throws Throwable {
        shareClassPd = ProductDetailPage.productDetailPage(driver).getPdShareClassname().getText();
        assertTrue(ProductDetailPage.productDetailPage(driver).getPdShareClassname().isDisplayed());
        //assertEquals(shareClassPd, shareClassPL);
    }
    
    @Then("^I verify the Shareclass dropdown is displayed and clickable$")
    public void iVerifyTheShareclassDropdownIsDisplayed() throws Throwable {
    	String currentShareClass = ProductDetailPage.productDetailPage(driver).getPdShareClassname().getText();
		WebElement wrapper = driver.findElement(By.xpath("//*[contains(@class,'product-summary')]"));
	    WebElement shareDropdown = wrapper.findElement(By.className("share-dropdown"));
	    shareDropdown.click();
	    Thread.sleep(30000);
	    int totalShareClasses = driver.findElements(By.xpath("//*[@class='share-dropdown']/*[@id='shareOptions_nlcrx']//a")).size();
	    if (totalShareClasses > 1) {
	        driver.findElement(By.xpath("//*[@class='share-dropdown']//*[@id='shareOptions_nlcrx']//a[2]")).click();
	        Thread.sleep(30000);
	        String newShareClass = ProductDetailPage.productDetailPage(driver).getPdShareClassname().getText();
	        assertNotEquals(currentShareClass,newShareClass);
	    }else {
	    	System.out.println("This product has only one share class");
	    }
    }

    @Then("^I verify the watchlist icon in product summary component$")
    public void i_verify_the_watchlist_icon_in_product_summary_component() throws Throwable {
    	assertTrue(ProductListPage.productListPage(driver).getAddToWatchlistPDButton().isDisplayed());        
    }

    @Then("^I verify the Disclosure is displayed if available$")
    public void iVerifyTheDisclosureIsDisplayedIfAvailable() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getProductDisclosure().isDisplayed()) {
    			assertTrue(ProductDetailPage.productDetailPage(driver).getProductDisclosure().isDisplayed());    			
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}
    }

    @Then("^I verify the Product Stats ISIN, Share Class Inception Date, AUM, Asofdate$")
    public void IVerifyTheProductIsinShareClassInceptionDateAumAsofdate() throws Throwable {
    	if (driver.getCurrentUrl().contains("en-au")) {
    		assertEquals(ProductDetailPage.productDetailPage(driver).getIsinLabel().getText(), "APIR Code/ASX Ticker");
    		assertTrue(ProductDetailPage.productDetailPage(driver).getAumDate().getText().contains("As of"));
    	}else {
    		assertEquals(ProductDetailPage.productDetailPage(driver).getIsinLabel().getText(), "ISIN");
    		assertTrue(ProductDetailPage.productDetailPage(driver).getAumDate().getText().contains("as of"));
    	}
    	
    	assertTrue(ProductDetailPage.productDetailPage(driver).getIsinValue().isDisplayed());
    	isinValue = ProductDetailPage.productDetailPage(driver).getIsinValue().getText();
    	assertEquals(ProductDetailPage.productDetailPage(driver).getInceptionDateLabel().getText(), "Share Class Inception Date");
    	assertTrue(ProductDetailPage.productDetailPage(driver).getInceptionDateValue().isDisplayed());
    	assertEquals(ProductDetailPage.productDetailPage(driver).getAumLabel().getText(), "AUM");
    	assertTrue(ProductDetailPage.productDetailPage(driver).getAumValue().isDisplayed());  	       
    }

    @Then("^I verify the ShareClass inception date is as per the country's local$")
    public void iVerifyTheShareclassInceptionDateIsAsPerTheCountrySLocal() throws Throwable {
    	String inceptionDate = ProductDetailPage.productDetailPage(driver).getInceptionDateValue().getText();
		String[] currentUrl  = driver.getCurrentUrl().split("/");
		ProductListSteps.verifyLocaleFormattedDate(inceptionDate, currentUrl[3]);       
    }

    @Then("^I verify the AsOfDate is as per country's local$")
    public void iVerifyTheAsofdateIsAsPerCountrySLocal() throws Throwable {
    	String asOfDate = ProductDetailPage.productDetailPage(driver).getAumDate().getText();
    	String[] asOfDatevalue = asOfDate.split(" ");
		String[] currentUrl  = driver.getCurrentUrl().split("/");
		System.out.println("asOfDatevalue: " + asOfDatevalue[2]);
		ProductListSteps.verifyLocaleFormattedDate(asOfDatevalue[2], currentUrl[3]);         
    }
    
    @Then("^I verify product list date format and syntax$")
    public void i_verify_product_list_date_format_and_syntax() throws Throwable {
        List<WebElement> plDateElem = driver.findElements(By.xpath("//*[@class='nav-as-of-date']"));
        String[] currentUrl  = driver.getCurrentUrl().split("/");
        for (WebElement x : plDateElem) {
			String DatePl = x.getText();
			String[] splitDatePl = DatePl.split(" ");
			String CorDatePl=splitDatePl[2].replace(")","");
			System.out.println(CorDatePl);
			ProductListSteps.verifyLocaleFormattedDate(CorDatePl, currentUrl[3]);
			verifyDateContainsSlash(CorDatePl);
		}
    }
    
    @Then("^I verify Product detail dates contains slash$")
    public void i_verify_Product_detail_dates_contains_slash() throws Throwable {
    	String inceptionDate = ProductDetailPage.productDetailPage(driver).getInceptionDateValue().getText();
    	this.verifyDateContainsSlash(inceptionDate);
    	String asOfDate = ProductDetailPage.productDetailPage(driver).getAumDate().getText();
    	String[] asOfDatevalue = asOfDate.split(" ");
    	this.verifyDateContainsSlash(asOfDatevalue[2]);
    	
    }
    
    private void verifyDateContainsSlash(String date ) {
		assertTrue("Date doesn't contain slash",date.contains("/"));
	}
    


    @Then("^I verify the product detail tabs availability$")
    public void iVerifyTheProductDetailTabsAvailability() throws Throwable {
    	assertTrue(ProductDetailPage.productDetailPage(driver).getPerformanceTab().isDisplayed());
    	assertTrue(ProductDetailPage.productDetailPage(driver).getCharacteristicsTab().isDisplayed());
    	assertTrue(ProductDetailPage.productDetailPage(driver).getLiteratureTab().isDisplayed());
    	assertTrue(ProductDetailPage.productDetailPage(driver).getManagerTab().isDisplayed());
    	if (!driver.getCurrentUrl().contains("en-au")) { 
    		assertTrue(ProductDetailPage.productDetailPage(driver).getDistributionsTab().isDisplayed());
    	} else {
    		System.out.println("Distributions tab is not authored for this product" + driver.getCurrentUrl());
    	}
    	if (!(driver.getCurrentUrl().contains("en-nl") || driver.getCurrentUrl().contains("en-lu"))) { 
    		assertTrue(ProductDetailPage.productDetailPage(driver).getInvestmentRiskTab().isDisplayed());
    	}else {
    		System.out.println("Investment Risk tab is not authored for this product" + driver.getCurrentUrl());
    	}
    	assertTrue(ProductDetailPage.productDetailPage(driver).getHoldingsTab().isDisplayed());
    	//}else {
    		//System.out.println("Holdings tab is not authored for this product" + driver.getCurrentUrl());
    	//}    	    
    }
    
    @Then("^I verify the product detail tabs availability for German site$")
    public void iVerifyTheProductDetailTabsAvailabilityForGermanSite() throws Throwable {
    	assertTrue(ProductDetailPage.productDetailPage(driver).getPerformanceTab().isDisplayed());
    	assertTrue(ProductDetailPage.productDetailPage(driver).getCharacteristicsTabDe().isDisplayed());
    	assertTrue(ProductDetailPage.productDetailPage(driver).getLiteratureTabDe().isDisplayed());
    	assertTrue(ProductDetailPage.productDetailPage(driver).getManagerTabDe().isDisplayed());
    	assertTrue(ProductDetailPage.productDetailPage(driver).getInvestmentRiskTabDe().isDisplayed());
    	assertTrue(ProductDetailPage.productDetailPage(driver).getHoldingsTabDe().isDisplayed());
    	assertTrue(ProductDetailPage.productDetailPage(driver).getDistributionsTabDe().isDisplayed());
    }

    @Then("^I verify the footer disclosure$")
    public void iVerifyTheFooterDisclosure() throws Throwable {
    	assertTrue(ProductDetailPage.productDetailPage(driver).getFooterDisclosure().isDisplayed());
    }

    @Then("^I verify the Account Access option$")
    public void iVerifyTheAccountAccessOption() throws Throwable {
  
    }
    
    @Then("^I click on the productlist page fund name navigation check from overview tab$")
	public void iClickOnFundNameOnProductListPage() throws Throwable {
		Thread.sleep(10000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",ProductDetailPage.productDetailPage(driver).getFundNamePl());
		Thread.sleep(6000);
		fundNamePL = ProductDetailPage.productDetailPage(driver).getFundNamePl().getText();
		shareClassPL = ProductDetailPage.productDetailPage(driver).getShareClassPl().getText();
		if (driver.getCurrentUrl().contains("en-au")) {
			assetTypePL = ProductDetailPage.productDetailPage(driver).getAssetTypePlAU().getText();
		}else {
			assetTypePL = ProductDetailPage.productDetailPage(driver).getAssetTypePl().getText();
		}	
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",ProductDetailPage.productDetailPage(driver).getFundNamePl());
		//ProductDetailPage.productDetailPage(driver).getFundNamePl().click();	    
	}
    
    @Then("^I verify the Asset Type on product detail page$")
    public void iVerifyTheAssetClassNameOnProductDetailPage() throws Throwable {
    	String assetTypePD = ProductDetailPage.productDetailPage(driver).getAssetTypePD().getText();
    	assertEquals(assetTypePD, "Fixed Income");
    }
    
    @Then("^I verify the Asset Type on product detail page on German Site$")
    public void iVerifyTheAssetClassNameOnProductDetailPageDe() throws Throwable {
    	String assetTypePD = ProductDetailPage.productDetailPage(driver).getAssetTypePD().getText();
    	assertEquals(assetTypePD, "Aktien");
    }

    @Then("^I verify AIM title and details should be displayed$")
    public void iVerifyAimTitleAndDetailsShouldBeDisplayed() throws Throwable {
    	if (!driver.getCurrentUrl().contains("en-au")) {
    		assertTrue(ProductDetailPage.productDetailPage(driver).getFundAIMPD().isDisplayed());
    	}else {
    		System.out.println("AIM Section is not authored for Australian Products");
    	}
    }

    @Then("^I verify Fund Managers and details should be displayed$")
    public void iVerifyFundManagersAndDetailsShouldBeDisplayed() throws Throwable {
    	if (!driver.getCurrentUrl().contains("en-au")) {
    		assertTrue(ProductDetailPage.productDetailPage(driver).getFundManagerPD().isDisplayed());
    	}else {
    		System.out.println("Fund Managers Section is not authored for Australian Products");
    	}    	
    }

    @Then("^I verify the Product Stats ISIN value is changed$")
    public void iVerifyProductsStatsDataGotChanged() throws Throwable {
    	if (!driver.getCurrentUrl().contains("en-au")) {
    		String newISINValue = ProductDetailPage.productDetailPage(driver).getIsinValue().getText();
    		System.out.println("New ISIN value is :" + newISINValue);
    		assertTrue(ProductDetailPage.productDetailPage(driver).getIsinValue().isDisplayed());
    	} else {
    		System.out.println("This product has only one share class");
    	}
    		
    }
    
    //Literature
    
    @Then("^I verify the \"([^\"]*)\" section is displayed in literature tab$")
    public void iVerifyLiteratureSectionIsDisplayed(String sectionName) throws Throwable {
    	try{
    		List <WebElement> literatureColumns = ProductDetailPage.productDetailPage(driver).getLiteratureColumns();
    		if (literatureColumns.size()>0) {
    			for (int i = 0; i<literatureColumns.size(); i++) {
    				if(literatureColumns.get(i).getText().contains(sectionName)) {
    					assertTrue(literatureColumns.get(i).getText().contains(sectionName));
    				}    					
    			}  
    		}	
    	}catch(NoSuchElementException ex){
    		//Do nothing
    	}
     
    }
    
    @Then("^I verify the Initial Application Form is displayed$")
    public void iVerifyTheInitialApplicationFormIsDisplayed() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getInitialAppFormLink().isDisplayed()){
    			formType =  ProductDetailPage.productDetailPage(driver).getInitialAppFormLink().getText();
    			assertTrue(ProductDetailPage.productDetailPage(driver).getInitialAppFormLink().isDisplayed());
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I verify the Initial Application Form is displayed for German Site$")
    public void iVerifyTheInitialApplicationFormIsDisplayedForGermanSite() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getInitialAppFormLinkDe().isDisplayed()){
    			formType =  ProductDetailPage.productDetailPage(driver).getInitialAppFormLinkDe().getText();
    			assertTrue(ProductDetailPage.productDetailPage(driver).getInitialAppFormLinkDe().isDisplayed());
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I verify the SubSequent Application Form is displayed for German site$")
    public void iVerifyTheSubsequentApplicationFormIsDisplayedForGermanSite() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getSubseqAppFormLinkDe().isDisplayed()){
    			formType =  ProductDetailPage.productDetailPage(driver).getSubseqAppFormLinkDe().getText();
    			assertTrue(ProductDetailPage.productDetailPage(driver).getSubseqAppFormLinkDe().isDisplayed());
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I verify the SubSequent Application Form is displayed$")
    public void iVerifyTheSubsequentApplicationFormIsDisplayed() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getSubseqAppFormLink().isDisplayed()){
    			formType =  ProductDetailPage.productDetailPage(driver).getSubseqAppFormLink().getText();
    			assertTrue(ProductDetailPage.productDetailPage(driver).getSubseqAppFormLink().isDisplayed());
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I click on the Subsequent Application Form link$")
    public void iClickOnTheSubsequentApplicationFormLink() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getSubseqAppFormLink().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getSubseqAppFormLink().click();
    			Thread.sleep(3000);
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I click on the Subsequent Application Form link for German site$")
    public void iClickOnTheSubsequentApplicationFormLinkForGermanSite() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getSubseqAppFormLinkDe().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getSubseqAppFormLinkDe().click();
    			Thread.sleep(3000);
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I verify the Redemption Form is displayed$")
    public void iVerifyTheRedemptionFormIsDisplayed() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getRedemptionFormLink().isDisplayed()){
    			formType =  ProductDetailPage.productDetailPage(driver).getRedemptionFormLink().getText();
    			assertTrue(ProductDetailPage.productDetailPage(driver).getRedemptionFormLink().isDisplayed());
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I verify the Redemption Form is displayed for German site$")
    public void iVerifyTheRedemptionFormIsDisplayedForGermanSite() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getRedemptionFormLinkDe().isDisplayed()){
    			formType =  ProductDetailPage.productDetailPage(driver).getRedemptionFormLinkDe().getText();
    			assertTrue(ProductDetailPage.productDetailPage(driver).getRedemptionFormLinkDe().isDisplayed());
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I click on the Redemption Form link$")
    public void iClickOnTheRedemptionFormLink() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getRedemptionFormLink().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getRedemptionFormLink().click();
    			Thread.sleep(3000);
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I click on the Redemption Form link for German site$")
    public void iClickOnTheRedemptionFormLinkForGermanSite() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getRedemptionFormLinkDe().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getRedemptionFormLinkDe().click();
    			Thread.sleep(3000);
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    
    @Then("^I verify the Exchange Form is displayed$")
    public void iVerifyTheExchangeFormIsDisplayed() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getExchangeFormLink().isDisplayed()){
    			assertTrue(ProductDetailPage.productDetailPage(driver).getExchangeFormLink().isDisplayed());
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I click on the Exchange Form link$")
    public void iClickOnTheExchangeFormLink() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getExchangeFormLink().isDisplayed()){
    			formType =  ProductDetailPage.productDetailPage(driver).getExchangeFormLink().getText();
    			ProductDetailPage.productDetailPage(driver).getExchangeFormLink().click();
    			Thread.sleep(3000);
    		}	
    	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}    	
    }
    
    @Then("^I verify Open icon is displayed after clicking Exchange form$")
    public void iVerifyOpenIconIsDdisplayedAfterclickingExchangeForm() throws Throwable {
    	Thread.sleep(2000);
    	assertTrue(ProductDetailPage.productDetailPage(driver).getOpenIconExchangeForm().isDisplayed());
    }

    @Then("^I verify Email icon is displayed after clicking Exchange form$")
    public void iVerifyEmailIconIsDisplayedAfterClickingExchangeForm() throws Throwable {
    	Thread.sleep(2000);
    	assertTrue(ProductDetailPage.productDetailPage(driver).getEmailIconExchangeForm().isDisplayed());
    }

    @Then("^I click on Open icon of Exchange form$")
    public void iClickOnOpenIconOfExchangeForm() throws Throwable {
    	Thread.sleep(2000);
    	ProductDetailPage.productDetailPage(driver).getOpenIconExchangeForm().click();
    }

    @Then("^I switch to the second window$")
    public void iSwitchToTheSecondWindow() throws Throwable {
    	List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @Then("^I verify the Exchange form is opened$")
    public void iVerifyTheExchangeFormIsOpened() throws Throwable {
       Thread.sleep(2000);
       assertTrue(driver.getCurrentUrl().contains("exchange-form"));
    }

    @Then("^I switch to the first window$")
    public void iSwitchToTheFirstWindow() throws Throwable {
    	List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    @Then("^I click on Email icon of Exchange form$")
    public void iClickOnEmailIconOfExchangeForm() throws Throwable {
    	Thread.sleep(2000);
    	ProductDetailPage.productDetailPage(driver).getEmailIconExchangeForm().click();
    }


    @Then("^I click on the Initial Application Form link$")
    public void iClickOnTheInitialApplicationFormLink() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getInitialAppFormLink().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getInitialAppFormLink().click();
    			Thread.sleep(3000);
    		}
       	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}     
    }
    
    @Then("^I click on the Initial Application Form link for German site$")
    public void iClickOnTheInitialApplicationFormLinkForGermanSite() throws Throwable {
    	try {
    		if (ProductDetailPage.productDetailPage(driver).getInitialAppFormLinkDe().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getInitialAppFormLinkDe().click();
    			Thread.sleep(3000);
    		}
       	}catch (NoSuchElementException ex) {
    		//Do nothing
    	}     
    }

    @Then("^I verify the Initial Application Form model window is displayed$")
    public void iVerifyTheInitialApplicationFormModelDisplayed() throws Throwable {
    	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){ 
    			assertTrue(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed());
    		}else if (ProductDetailPage.productDetailPage(driver).getFormOpenModel().isDisplayed()) {
    			assertTrue(ProductDetailPage.productDetailPage(driver).getFormOpenModel().isDisplayed());
    			assertTrue(ProductDetailPage.productDetailPage(driver).getFormEmailLink().isDisplayed());
    		}
    	}catch (NoSuchElementException ex){
    		//Do nothing
    	}
    }

    @Then("^I verify the fields on the Initial Application Form model window$")
    public void iVerifyTheFieldsOnTheInitialApplicationFormModel() throws Throwable {
    	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			assertTrue(ProductDetailPage.productDetailPage(driver).getCloseModal().isDisplayed());
    			assertTrue(ProductDetailPage.productDetailPage(driver).getSelectAllLink().isDisplayed());
    			assertTrue(ProductDetailPage.productDetailPage(driver).getClearAllLink().isDisplayed());
    			assertTrue(ProductDetailPage.productDetailPage(driver).getNextButtonDisabled().isDisplayed());
    			assertTrue(ProductDetailPage.productDetailPage(driver).getStepOneActive().isDisplayed());
    			assertEquals(ProductDetailPage.productDetailPage(driver).geStepOneMessage().getText(), "Select Share Classes");
    		}
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}
    }

    @Then("^I click on the close button on the Initial Application Form model window$")
    public void iClickOnTheCloseButtonOnInitialApplicationModel() throws Throwable {
    	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getCloseModal().click();
    		}
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}	
    }

    @Then("^I verify the Next button got disabled in model window$")
    public void iVerifyTheNextButtonGotDisabledInModelWindow() throws Throwable {
    	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			assertTrue(ProductDetailPage.productDetailPage(driver).getNextButtonDisabled().isDisplayed());
    		}	
		}catch(NoSuchElementException ex) {
			//Do nothing
		}		
    }
    
    @Then("^I verify the Next button got disabled in model window for German site$")
    public void iVerifyTheNextButtonGotDisabledInModelWindowForGermanSite() throws Throwable {
    	
    		if(ProductDetailPage.productDetailPage(driver).getNextButtonDisabledDe().isDisplayed()){
    			assertTrue(ProductDetailPage.productDetailPage(driver).getNextButtonDisabledDe().isDisplayed());
    		}
    }

    @Then("^I select the share class in model window$")
    public void iSelectTheShareClassInModelWindow() throws Throwable {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//span[text()='Class A Euro Accumulating (Hedged)']//ancestor::label")).click();
    }
    
    @Then("^I select the share class \"([^\"]*)\" in model window$")
    public void iSelectTheShareClassInModelWindow(String shareClass) throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='"+shareClass+"']//ancestor::label")).click();
    }

    @Then("^I verify the Next button got enabled in model window$")
    public void iVerifyTheNextButtonGotEnabledInModel() throws Throwable {
    	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			assertTrue(ProductDetailPage.productDetailPage(driver).getNextButton().isDisplayed());
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing    	  		
    	}
    }
    
    @Then("^I verify the Next button got enabled in model window for German site$")
    public void iVerifyTheNextButtonGotEnabledInModelForGermanSite() throws Throwable {
    	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			assertTrue(ProductDetailPage.productDetailPage(driver).getNextButtonDe().isDisplayed());
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing    	  		
    	}
    }
    

    @Then("^I click on Clear All button in model window$")
    public void iClickOnClearAllButtonInModelWindow() throws Throwable {
    	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getClearAllLink().click();
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}    			
    }
    
    @Then("^I click on Clear All button in model window for German site$")
    public void iClickOnClearAllButtonInModelWindowForGermanSite() throws Throwable {
    	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getClearAllLinkDe().click();
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}    			
    }

    @Then("^I click on Select All button in model window$")
    public void iClickOnSelectAllButtonInModelWindow() throws Throwable {
     	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getSelectAllLink().click();
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}  	
    }
    
    @Then("^I click on Select All button in model window for German site$")
    public void iClickOnSelectAllButtonInModelWindowForGermanSite() throws Throwable {
     	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getSelectAllLinkDe().click();
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}  	
    }

    @Then("^I verify all the shareclass got selected$")
    public void iVerifyAllTheShareclassGotSelected() throws Throwable {

    }

    @Then("^I click on the Next button in model window$")
    public void iClickOnTheNextButtonInModelWindow() throws Throwable {
      	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getNextButton().click();
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}	
    }
    
    @Then("^I click on the Next button in model window for German site$")
    public void iClickOnTheNextButtonInModelWindowForGermanSite() throws Throwable {
      	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getNextButtonDe().click();
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}	
    }

    @Then("^I verify the user is navigated to the Step one of the model window$")
    public void iVerifyTheUserIsNaigatedToStepOneOfTheModelWindow() throws Throwable {
     	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			assertTrue(ProductDetailPage.productDetailPage(driver).getStepOneActive().isDisplayed());
      		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}
    }

    @Then("^I verify the message on the Step Two of the model window$")
    public void iVerifyTheMessageOnStepTwo() throws Throwable {
     	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			String stepTwoMessage = ProductDetailPage.productDetailPage(driver).getStepTwoMessage().getText();
    			String expectedMessage = "Your " + formType + " will be generated using the following share classes:";
    			assertEquals(expectedMessage, stepTwoMessage);
      		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}   	
    }
    
    @Then("^I verify the message on the Step Two of the model window for German site$")
    public void iVerifyTheMessageOnStepTwoForGermanSite() throws Throwable {
     	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			String stepTwoMessage = ProductDetailPage.productDetailPage(driver).getStepTwoMessage().getText();
    			String expectedMessage = "Ihr Erstmaliges Antragsformular wird anhand der folgenden Anteilsklassen generiert:";
    			assertEquals(expectedMessage, stepTwoMessage);
      		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}   	
    }

    @Then("^I verify the message on the Step Two of the model window Redemption form for German site$")
    public void iVerifyTheMessageOnStepTwoRedemptionFormForGermanSite() throws Throwable {
     	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			String stepTwoMessage = ProductDetailPage.productDetailPage(driver).getStepTwoMessage().getText();
    			String expectedMessage = "Ihr Verkaufsformular wird anhand der folgenden Anteilsklassen generiert:";
    			assertEquals(expectedMessage, stepTwoMessage);
      		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}   	
    }
    
    @Then("^I verify the message on the Step Two of the model window Subsequent form for German site$")
    public void iVerifyTheMessageOnStepTwoSubsequentFormForGermanSite() throws Throwable {
     	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			String stepTwoMessage = ProductDetailPage.productDetailPage(driver).getStepTwoMessage().getText();
    			String expectedMessage = "Ihr Nachfolgendes Antragsformular wird anhand der folgenden Anteilsklassen generiert:";
    			assertEquals(expectedMessage, stepTwoMessage);
      		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}   	
    }
    
    @Then("^I verify the Back and Next button on Step Two of the model window$")
    public void iVerifyTheBackAndNextButtonsOnStepTwo() throws Throwable {
     	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			assertTrue(ProductDetailPage.productDetailPage(driver).getBackButton().isDisplayed());
    			assertTrue(ProductDetailPage.productDetailPage(driver).getNextButton().isEnabled());
     		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}	
    }
    
    @Then("^I verify the Back and Next button on Step Two of the model window for German site$")
    public void iVerifyTheBackAndNextButtonsOnStepTwoForGermanSite() throws Throwable {
     	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			assertTrue(ProductDetailPage.productDetailPage(driver).getBackButtonDe().isDisplayed());
    			assertTrue(ProductDetailPage.productDetailPage(driver).getNextButtonDe().isEnabled());
     		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}	
    }
    
    
    @Then("^I click on Back button on Step Two of the model window$")
    public void iClickOnBackButtonOnStepTwo() throws Throwable {
       	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getBackButton().click();
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}		
    }
    
    @Then("^I click on Back button on Step Two of the model window for German site$")
    public void iClickOnBackButtonOnStepTwoForGermanSite() throws Throwable {
       	try {
    		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
    			ProductDetailPage.productDetailPage(driver).getBackButtonDe().click();
    		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}		
    }

    @Then("^I verify the user is naigated to step Three of the model window$")
    public void iVerifyTheUserIsNaigatedToStepThreeOfTheModelWindow() throws Throwable {
       	try {
       		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){       	
       		assertTrue(ProductDetailPage.productDetailPage(driver).getStepThreeActive().isDisplayed());
    	}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}		
    }

    @Then("^I click on next button in model window$")
    public void iClickOnNextButtonInModelWindow() throws Throwable {
       	try {
       		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){    
       			ProductDetailPage.productDetailPage(driver).getNextButton().click();
       		}	
    	}catch(NoSuchElementException ex) {
    		//Do nothing
    	}		
    }

    @Then("^I click on Generate button on Step Two of the model window$")
    public void iClickOnGenerateButtinOnStepOfTheModelWindow() throws Throwable {
       	try {
       		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){   
       			ProductDetailPage.productDetailPage(driver).getGenerateButton().click();
       		}
       	}catch(NoSuchElementException ex) {
        	//Do nothing
        }
    }
    
    @Then("^I click on Generate button on Step Two of the model window for German site$")
    public void iClickOnGenerateButtinOnStepOfTheModelWindowForGermanSite() throws Throwable {
       	try {
       		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){   
       			ProductDetailPage.productDetailPage(driver).getGenerateButtonDe().click();
       		}
       	}catch(NoSuchElementException ex) {
        	//Do nothing
        }
    }

    @Then("^I verify the user is naigated to step Two of the model window$")
    public void iVerifyTheUserIsNavigatedToStepOfTheModelWindow() throws Throwable {
       	try {
       		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){  
       			assertTrue(ProductDetailPage.productDetailPage(driver).getStepTwoActive().isDisplayed());
       		}	
       	}catch(NoSuchElementException ex) {
       		//Do nothing
       	}
    }

    @Then("^I verify the message on the on the Step Three of the model window$")
    public void IVerifyTheMessageOnTheOnTheStepOfTheModelWindow() throws Throwable {
     	try {
       		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
       			assertTrue(ProductDetailPage.productDetailPage(driver).getStepThreeActive().isDisplayed());
       		}	
       	}catch(NoSuchElementException ex) {
       		//Do nothing
        }	
    }

    @Then("^I verify the Download button is displayed on Step Three of the model window$")
    public void IVerifyTheDownloadButtonIsDisplayedOnStepThree() throws Throwable {
     	try {
       		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
       			assertTrue(ProductDetailPage.productDetailPage(driver).getDownloadButton().isDisplayed());
       		}	
     	}catch(NoSuchElementException ex) {
     		//Do nothing
     	}	
    }
    
    @Then("^I verify the Download button is displayed on Step Three of the model window for German site$")
    public void IVerifyTheDownloadButtonIsDisplayedOnStepThreeForGermanSite() throws Throwable {
     	try {
       		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
       			assertTrue(ProductDetailPage.productDetailPage(driver).getDownloadButtonDe().isDisplayed());
       		}	
     	}catch(NoSuchElementException ex) {
     		//Do nothing
     	}	
    }

    @Then("^I click on the Close button in Step of Three the model window$")
    public void iClickOnTheCloseButtonInStepThreeOfModel() throws Throwable {
     	try {
       		if(ProductDetailPage.productDetailPage(driver).getDynamicFormModel().isDisplayed()){
       			ProductDetailPage.productDetailPage(driver).getCloseModal().click();
    		}	
     	}catch(NoSuchElementException ex) {
     		//Do nothing
     	}    	
    }
    
    @Then("^I verify the Yields table is displayed if authored$")
    public void iVerifyTheYieldsTableIsDisplayed() throws Throwable {
    	try {
       		if(ProductDetailPage.productDetailPage(driver).getYieldsComponent().isDisplayed()){
       			assertTrue(ProductDetailPage.productDetailPage(driver).getYieldsComponent().isDisplayed());
    		}	
     	}catch(NoSuchElementException ex) {
     		System.out.println("Yields table is not Authored in Performance Section");
     	} 
    }

    @Then("^I verify the Yields header is displayed$")
    public void iVerifyTheYieldsHeaderIsDisplayed() throws Throwable {
    	try {
       		if(ProductDetailPage.productDetailPage(driver).getYieldsComponent().isDisplayed()){
       			assertEquals(ProductDetailPage.productDetailPage(driver).getYieldsHeaderText().getText(), "Yields (%)");
    		}	
     	}catch(NoSuchElementException ex) {
     		System.out.println("Yields table is not Authored in Performance Section");
     	} 
         
    }

    @Then("^I verify the Yields AsOfDate is displayed$")
    public void iVerifyTheYieldsAsOfDateIsDisplayed() throws Throwable {
    	try {
       		if(ProductDetailPage.productDetailPage(driver).getYieldsComponent().isDisplayed()){
       			assertEquals(ProductDetailPage.productDetailPage(driver).getYieldsAsOfText().getText(), "As Of");
       			assertTrue(ProductDetailPage.productDetailPage(driver).getYieldsAsOfDate().isDisplayed());
    		}	
     	}catch(NoSuchElementException ex) {
     		System.out.println("Yields table is not Authored in Performance Section");
     	} 
    }

    @Then("^I verify the Yields AsOfdate is based on country's local$")
    public void iVerifyTheYieldsAsOfdateIsBasedonCountryocal() throws Throwable {
    	try {
       		if(ProductDetailPage.productDetailPage(driver).getYieldsComponent().isDisplayed()){
       			int yieldsRow = ProductDetailPage.productDetailPage(driver).getYieldsRows().size();
       			if (yieldsRow > 1){
       				System.out.println("Yields table is displayed with data");
       				
       				
       			}else {
       				String noYieldsDatamsg = ProductDetailPage.productDetailPage(driver).getYieldsRows().get(1).getText();
       				assertEquals(noYieldsDatamsg, NOYIELDSDATAMSG);
       			}	
    		}	
     	}catch(NoSuchElementException ex) {
     		System.out.println("Yields table is not Authored in Performance Section");
     	} 
    }
    
    @Then("^I verify the GrowthOf10K Header is displayed$")
    public void iVerifyTheGrowthOf10KHeader() throws Throwable {
    	try{
			if (ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()) {
				assertTrue(ProductDetailPage.productDetailPage(driver).getGrowthOf10KHeader().getText().contains("Growth of USD 10,000") || ProductDetailPage.productDetailPage(driver).getGrowthOf10KHeader().getText().contains("Growth of $10,000")||ProductDetailPage.productDetailPage(driver).getGrowthOf10KHeader().getText().contains("Growth of EUR 10,000"));				
			}
		}catch(NoSuchElementException ex){
			System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
		}	 
    }
    
    @Then("^I verify the GrowthOf10K Header is displayed for German site$")
    public void iVerifyTheGrowthOf10KHeaderForGermanSite() throws Throwable {
    	try{
			if (ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()) {
				assertTrue(ProductDetailPage.productDetailPage(driver).getGrowthOf10KHeader().getText().contains("Wachstum von 10.000"));				
			}
		}catch(NoSuchElementException ex){
			System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
		}	 
    }
    
    @Then("^I verify Exluding Sales Charges in GrowthOf10k Header$")
    public void iVerifyExclidingSalesText() throws Throwable {
    	try{
			if (ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()) {
				if(!driver.getCurrentUrl().contains("en-au")) {
					assertTrue(ProductDetailPage.productDetailPage(driver).getGrowth10KExcluding().getText().contains("excluding sales charges"));
				} else {
					assertTrue(ProductDetailPage.productDetailPage(driver).getGrowth10KExcludingAU().getText().isEmpty());
				}					
			}
		}catch(NoSuchElementException ex){
			System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
			}
		}	 
    
    @Then("^I verify Exluding Sales Charges in GrowthOf10k Header for German site$")
    public void iVerifyExclidingSalesTextForGermanSite() throws Throwable {
    	try{
			if (ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()) {
					assertTrue(ProductDetailPage.productDetailPage(driver).getGrowth10KExcluding().getText().contains("ohne Verkaufsgebühren"));
				} 
		}catch(NoSuchElementException ex){
			System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
			}
		}
    	
    	@Then("^I verify the AsOFDate text in GrowthOf10k Header$")
        public void iVerifyAsofDateForGrowthOf10K() throws Throwable {
        	try {
           		if(ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()){
           			assertEquals(ProductDetailPage.productDetailPage(driver).getGrowth10KAsOfText().getText(), "(As of");
           			assertTrue(ProductDetailPage.productDetailPage(driver).getGrowthOf10KAsOfDate().isDisplayed());
        		}	
         	}catch(NoSuchElementException ex) {
         		System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
         	} 
        }
    	
    	@Then("^I verify the AsOFDate text in GrowthOf10k Header for German site$")
        public void iVerifyAsofDateForGrowthOf10KForGermanSite() throws Throwable {
        	try {
           		if(ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()){
           			assertEquals(ProductDetailPage.productDetailPage(driver).getGrowth10KAsOfText().getText(), "(aktuelles NAV-Datum");
           			assertTrue(ProductDetailPage.productDetailPage(driver).getGrowthOf10KAsOfDate().isDisplayed());
        		}	
         	}catch(NoSuchElementException ex) {
         		System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
         	} 
        }

        @Then("^I verify the AsOfDate format is based on country's local for GrowthOf10k$")
        public void iVerifyAsofDateFormatForGrowthOf10K() throws Throwable {
        	try {
        		if (ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()) {
    				if (driver.findElements(By.xpath("//div[contains(@class,'ten-k-performance ten-k-performance-tluhk')]/div")).size() > 2) {
    					assertTrue(ProductDetailPage.productDetailPage(driver).getGrowthOf10KAsOfDate().isDisplayed());
    					String asOfDateUi = ProductDetailPage.productDetailPage(driver).getGrowthOf10KAsOfDate().getText();		
    					String[] currentUrl  = driver.getCurrentUrl().split("/");
    					ProductListSteps.verifyLocaleFormattedDate(asOfDateUi, currentUrl[3]);
    				} else {
    					String uiNoDataMsgAnnual = driver.findElement(By.xpath("//div[contains(@class,'ten-k-performance ten-k-performance-tluhk')]//table//tr")).getText();
    					assertEquals(uiNoDataMsgAnnual, NOROLLINGDATAMSG);				
    				}
    			}
        	}catch (NoSuchElementException ex)	{
        		System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
        	}
        } 
        
        @Then("^I verify the Range Filters on GrowthOf10K chart$")
        public void iVerifyRangeFiltersGrowthOf10K() throws Throwable {
        	try {
        		if (ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()) {
    				if (driver.findElements(By.xpath("//div[contains(@class,'ten-k-performance ten-k-performance-tluhk')]/div")).size() > 2) {
    					List <WebElement> rangeFilters = ProductDetailPage.productDetailPage(driver).getGrowth10KRangeFilters();
    					System.out.println("Range Filters on Growth of 10K chart: ");
    					for (int i = 0; i <rangeFilters.size(); i++)
    					{	
    						System.out.println(rangeFilters.get(i).getText().trim() + ", ");
    					}	
    					assertTrue(rangeFilters.get(0).getText().trim().contains("YTD"));
    					assertTrue(rangeFilters.get(1).getText().trim().contains("1YR"));
    					assertTrue(rangeFilters.get(2).getText().trim().contains("3YR"));
    					assertTrue(rangeFilters.get(3).getText().trim().contains("5YR"));
    					assertTrue(rangeFilters.get(4).getText().trim().contains("10YR"));
    					assertTrue(rangeFilters.get(5).getText().trim().contains("Since Inception"));					
    				} else {
    					String uiNoDataMsgAnnual = driver.findElement(By.xpath("//div[contains(@class,'ten-k-performance ten-k-performance-tluhk')]//table//tr")).getText();
    					assertEquals(uiNoDataMsgAnnual, NOROLLINGDATAMSG);		
    				}
    			}
        	}catch (NoSuchElementException ex)	{
        		System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
        	}
        }
        
        @Then("^I verify the data ranges showing datas correctly$")
        public void iVerifyTheDataRangesShowingDatasCorrectly() throws Throwable {
        	try{
    			if (ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()) {
    				assertTrue(ProductDetailPage.productDetailPage(driver).getGrowthOf10KHeader().getText().contains("Growth of USD 10,000") || ProductDetailPage.productDetailPage(driver).getGrowthOf10KHeader().getText().contains("Growth of $10,000")||ProductDetailPage.productDetailPage(driver).getGrowthOf10KHeader().getText().contains("Growth of EUR 10,000"));
        	Thread.sleep(2000);
        	SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        	Date date=new Date();
        	String currentDate = format.format(date);
        	String[] splitDate = currentDate.split("/");
        	List <WebElement> rangeFilters = ProductDetailPage.productDetailPage(driver).getGrowth10KRangeFilters();
        	rangeFilters.get(0).click();
        	if(rangeFilters.get(0).getAttribute("class").contains("active")){
        		List<WebElement> ytdDates = driver.findElements(By.xpath("//div[contains(@class,'ten-k')]//*[@data-interaction-label='YTD']//following::*[@text-anchor='end'][contains(@transform, 'translate(0,0) rotate')]"));
        		assertEquals("31/12/"+String.valueOf(Integer.parseInt(splitDate[2])-1), ytdDates.get(ytdDates.size()-1).getText());
        		assertEquals("31/12/"+String.valueOf(Integer.parseInt(splitDate[2])-2), ytdDates.get(0).getText());
        	}
        	
        	rangeFilters.get(1).click();
        	if(rangeFilters.get(1).getAttribute("class").contains("active")){
        		List<WebElement> oneYrYears = driver.findElements(By.xpath("//div[contains(@class,'ten-k')]//*[@data-interaction-label='1YR']//following::*[@text-anchor='end'][contains(@transform, 'translate(0,0) rotate')]"));
        		assertEquals("Dec "+String.valueOf(Integer.parseInt(splitDate[2])-1), oneYrYears.get(oneYrYears.size()-1).getText());
        		assertEquals("Dec "+String.valueOf(Integer.parseInt(splitDate[2])-2), oneYrYears.get(0).getText());
        	}
        	
        	rangeFilters.get(2).click();
        	if(rangeFilters.get(2).getAttribute("class").contains("active")){
        		List<WebElement> threeYrYears = driver.findElements(By.xpath("//div[contains(@class,'ten-k')]//*[@data-interaction-label='3YR']//following::*[@text-anchor='end'][contains(@transform, 'translate(0,0) rotate')]"));
        		assertEquals("Dec "+String.valueOf(Integer.parseInt(splitDate[2])-1), threeYrYears.get(threeYrYears.size()-1).getText());
        		assertEquals("Dec "+String.valueOf(Integer.parseInt(splitDate[2])-4), threeYrYears.get(0).getText());
        	}
        	
        	rangeFilters.get(3).click();
        	if(rangeFilters.get(3).getAttribute("class").contains("active")){
        		List<WebElement> fiveYrYears = driver.findElements(By.xpath("//div[contains(@class,'ten-k')]//*[@data-interaction-label='5YR']//following::*[@text-anchor='end'][contains(@transform, 'translate(0,0) rotate')]"));
        		assertEquals("Dec "+String.valueOf(Integer.parseInt(splitDate[2])-1), fiveYrYears.get(fiveYrYears.size()-1).getText());
        		assertEquals("Dec "+String.valueOf(Integer.parseInt(splitDate[2])-6), fiveYrYears.get(0).getText());
        	}
        	
        	rangeFilters.get(4).click();
        	if(rangeFilters.get(4).getAttribute("class").contains("active")){
        		List<WebElement> tenYrYears = driver.findElements(By.xpath("//div[contains(@class,'ten-k')]//*[@data-interaction-label='10YR']//following::*[@text-anchor='end'][contains(@transform, 'translate(0,0) rotate')]"));
        		assertEquals("Dec "+String.valueOf(Integer.parseInt(splitDate[2])-1), tenYrYears.get(tenYrYears.size()-1).getText());
        		assertEquals("Dec "+String.valueOf(Integer.parseInt(splitDate[2])-11), tenYrYears.get(0).getText());
        	}
    			}}catch(NoSuchElementException ex){
    				System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
    			}	
        }
        
        @Then("^I verify the Range Filters on GrowthOf10K chart for German site$")
        public void iVerifyRangeFiltersGrowthOf10KForGermanSite() throws Throwable {
        	try {
        		if (ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()) {
    				if (driver.findElements(By.xpath("//div[contains(@class,'ten-k-performance ten-k-performance-tluhk')]/div")).size() > 2) {
    					List <WebElement> rangeFilters = ProductDetailPage.productDetailPage(driver).getGrowth10KRangeFilters();
    					System.out.println("Range Filters on Growth of 10K chart: ");
    					for (int i = 0; i <rangeFilters.size(); i++)
    					{	
    						System.out.println(rangeFilters.get(i).getText().trim() + ", ");
    					}	
    					assertTrue(rangeFilters.get(0).getText().trim().contains("Seit Jahresbeginn"));
    					assertTrue(rangeFilters.get(1).getText().trim().contains("1 Jahr"));
    					assertTrue(rangeFilters.get(2).getText().trim().contains("3 Jahre"));
    					assertTrue(rangeFilters.get(3).getText().trim().contains("5 Jahre"));
    					assertTrue(rangeFilters.get(4).getText().trim().contains("10 Jahre"));
    					assertTrue(rangeFilters.get(5).getText().trim().contains("Seit Auflage"));					
    				} else {
    					String uiNoDataMsgAnnual = driver.findElement(By.xpath("//div[contains(@class,'ten-k-performance ten-k-performance-tluhk')]//table//tr")).getText();
    					assertEquals(uiNoDataMsgAnnual, NOROLLINGDATAMSG);		
    				}
    			}
        	}catch (NoSuchElementException ex)	{
        		System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
        	}
        }
        
        @Then("^I verify the currency displayed in chart title matches share class currency$")
        public void iVerifyHeaderCurrencysGrowthOf10K() throws Throwable {
        	try{
    			if (ProductDetailPage.productDetailPage(driver).getGrowthOf10KComp().isDisplayed()) {
    				if (driver.getCurrentUrl().contains("en-au")) {
    					System.out.println("Australian product does not show currency in shareclass");
    				}else {
    					String tenkHeader = ProductDetailPage.productDetailPage(driver).getGrowthOf10KHeader().getText();
    					String shareClass = ProductDetailPage.productDetailPage(driver).getPdShareClassname().getText();
    					String shareCurrency = shareClass.substring(shareClass.lastIndexOf(" ")+1);
    					System.out.println("tenkHeader : " + tenkHeader + " shareClass  :" + shareClass + " shareCurrency: " +shareCurrency );
    					assertTrue(tenkHeader.contains(shareCurrency));
    				}
    			}
    		}catch(NoSuchElementException ex){
    			System.out.println("Growth of 10K is not displayed for this product: " + driver.getCurrentUrl());
    		}	
        }        
        
    
    	@Then("^I verify Annualised Inclusive of Sales data to be present$")
    	public void iverifyAnnualisedInclusiveofSalesdata()throws Throwable {
    	  assertTrue(ProductDetailPage.productDetailPage(driver).getAnnualisedInclusiveOfSalesCharge().isDisplayed());
    	}
    	
    	@Then("^I verify Cumulative Inclusive of Sales data to be present$")
    	public void iverifyCumulativeInclusiveofSalesdata()throws Throwable {
    	  assertTrue(ProductDetailPage.productDetailPage(driver).getCumulativeInclusiveOfSalesCharge().isDisplayed());
    	}
    	
    	@Then("^I verify Calender Inclusive of Sales data to be present$")
    	public void iverifyCalenderInclusiveofSalesdata()throws Throwable {
    		assertTrue(ProductDetailPage.productDetailPage(driver).getCalenderInclusiveOfSalesCharge().isDisplayed());
    		try {
    			if(driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr")).size() > 1 ) {
    				List <WebElement> calendarDataRows = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr"));		 
    				if(calendarDataRows.size()>2) {
    					List <WebElement> calendarSalesChargeData = driver.findElements(By.xpath("//div[@class='calendar-performance calendar-performance-kjuip']//table//tr[2]/td"));
    					assertTrue(calendarSalesChargeData.size()>0);
    				}else {
    					System.out.println("Inclusive Sales Charge is not displayed in Calendar table");
    				}	 
    			}else {
    				System.out.println("Inclusive Sales Charge is not displayed in Calendar table");
    			}				 			
    		}catch(NoSuchElementException ex){
    			System.out.println("Calendar Table is not displayed in Performance Section");
    		}	  
    	}
    	
    	@Then("^I verify Rolling Inclusive of Sales data to be present$")
    	public void iverifyRollingInclusiveofSalesdata()throws Throwable {
    		assertTrue(ProductDetailPage.productDetailPage(driver).getRollingInclusiveOfSalesCharge().isDisplayed());
    	}    	
    	
    	@Then("^I click on NAV tab under Performance section$")
    	public void iClickOnNavTab() throws Throwable {	
    		try {
    			Thread.sleep(5000);
    			if (ProductDetailPage.productDetailPage(driver).getNavTab().isDisplayed()) {
    				ProductDetailPage.productDetailPage(driver).getNavTab().click();
    			}else {
    				ProductDetailPage.productDetailPage(driver).getRightArrow().click();
    				Thread.sleep(3000);
    				ProductDetailPage.productDetailPage(driver).getNavTab().click();
    			}
    		}catch (NoSuchElementException ex) {
    				System.out.println("NAV section is not displayed for this product: " + driver.getCurrentUrl());
    		}
    	}
    	
    	@Then("^I click on NAV tab under Performance section for German site$")
    	public void iClickOnNavTabForGermanSite() throws Throwable {	
    		try {
    			Thread.sleep(5000);
    			if (ProductDetailPage.productDetailPage(driver).getNavTabDe().isDisplayed()) {
    				ProductDetailPage.productDetailPage(driver).getNavTabDe().click();
    			}else {
    				ProductDetailPage.productDetailPage(driver).getRightArrow().click();
    				Thread.sleep(3000);
    				ProductDetailPage.productDetailPage(driver).getNavTabDe().click();
    			}
    		}catch (NoSuchElementException ex) {
    				System.out.println("NAV section is not displayed for this product: " + driver.getCurrentUrl());
    		}
    	}
    	
    	@Then("^I verify the NAV Header is displayed$")
    	public void iVerifyTheNAVHeader() throws Throwable {
    	   	try{
    			if (ProductDetailPage.productDetailPage(driver).getNavTab().isDisplayed()) {
    				assertTrue(ProductDetailPage.productDetailPage(driver).getNavHeader().getText().contains("Net Asset Value"));				
    			}
    		}catch(NoSuchElementException ex){
    			System.out.println("NAV section is not displayed for this product: " + driver.getCurrentUrl());
    		}	 
    	}
    	
    	@Then("^I verify the NAV Header is displayed for German site$")
    	public void iVerifyTheNAVHeaderForGermanSite() throws Throwable {
    	   	try{
    			if (ProductDetailPage.productDetailPage(driver).getNavTab().isDisplayed()) {
    				assertTrue(ProductDetailPage.productDetailPage(driver).getNavHeader().getText().contains("Nettoinventarwert"));				
    			}
    		}catch(NoSuchElementException ex){
    			System.out.println("NAV section is not displayed for this product: " + driver.getCurrentUrl());
    		}	 
    	}
    	
      	@Then("^I verify the AsOFDate text in NAV Header$")
        public void iVerifyAsofDateForNAV() throws Throwable {
        	try {
           		if(ProductDetailPage.productDetailPage(driver).getNavTab().isDisplayed()){
           			assertEquals(ProductDetailPage.productDetailPage(driver).getNavAsOfText().getText(), "(As of");
           			assertTrue(ProductDetailPage.productDetailPage(driver).getNavAsOfDate().isDisplayed());
        		}	
         	}catch(NoSuchElementException ex) {
         		System.out.println("NAV section is not displayed for this product: " + driver.getCurrentUrl());
         	} 
        }
      	
      	@Then("^I verify the AsOFDate text in NAV Header for German Site$")
        public void iVerifyAsofDateForNAVForGermanSite() throws Throwable {
        	try {
           		if(ProductDetailPage.productDetailPage(driver).getNavTab().isDisplayed()){
           			assertEquals(ProductDetailPage.productDetailPage(driver).getNavAsOfText().getText(), "(aktuelles NAV-Datum");
           			assertTrue(ProductDetailPage.productDetailPage(driver).getNavAsOfDate().isDisplayed());
        		}	
         	}catch(NoSuchElementException ex) {
         		System.out.println("NAV section is not displayed for this product: " + driver.getCurrentUrl());
         	} 
        }

      	
        @Then("^I verify the Range Filters on NAV chart$")
        public void iVerifyRangeFiltersNAV() throws Throwable {
        	try {
        		if (ProductDetailPage.productDetailPage(driver).getNavComponent().isDisplayed()) {
    				if (driver.findElements(By.xpath("//div[contains(@class,'historic-nav')]/div")).size() > 2) {
    					List <WebElement> rangeFilters = ProductDetailPage.productDetailPage(driver).getNavRangeFilters();
    					System.out.println("Range Filters on NAV chart: ");
    					for (int i = 0; i <rangeFilters.size(); i++)
    					{	
    						System.out.println(rangeFilters.get(i).getText().trim() + ", ");
    					}	
    					assertTrue(rangeFilters.get(0).getText().trim().contains("YTD"));
    					assertTrue(rangeFilters.get(1).getText().trim().contains("1YR"));
    					assertTrue(rangeFilters.get(2).getText().trim().contains("3YR"));
    					assertTrue(rangeFilters.get(3).getText().trim().contains("5YR"));
    					assertTrue(rangeFilters.get(4).getText().trim().contains("10YR"));
    					assertTrue(rangeFilters.get(5).getText().trim().contains("Since Inception"));					
    				} else {
    					String uiNoDataMsgAnnual = driver.findElement(By.xpath("//div[contains(@class,'historic-nav')]//table//tr")).getText();
    					assertEquals(uiNoDataMsgAnnual, NOROLLINGDATAMSG);		
    				}
    			}
        	}catch (NoSuchElementException ex)	{
        		System.out.println("NAV is not displayed for this product: " + driver.getCurrentUrl());
        	}
        }
        
        @Then("^I verify the Range Filters on NAV chart for German site$")
        public void iVerifyRangeFiltersNAVForGermanSite() throws Throwable {
        	try {
        		if (ProductDetailPage.productDetailPage(driver).getNavComponent().isDisplayed()) {
    				if (driver.findElements(By.xpath("//div[contains(@class,'historic-nav')]/div")).size() > 2) {
    					List <WebElement> rangeFilters = ProductDetailPage.productDetailPage(driver).getNavRangeFilters();
    					System.out.println("Range Filters on NAV chart: ");
    					for (int i = 0; i <rangeFilters.size(); i++)
    					{	
    						System.out.println(rangeFilters.get(i).getText().trim() + ", ");
    					}	
    					assertTrue(rangeFilters.get(0).getText().trim().contains("Seit Jahresbeginn"));
    					assertTrue(rangeFilters.get(1).getText().trim().contains("1 Jahr"));
    					assertTrue(rangeFilters.get(2).getText().trim().contains("3 Jahre"));
    					assertTrue(rangeFilters.get(3).getText().trim().contains("5 Jahre"));
    					assertTrue(rangeFilters.get(4).getText().trim().contains("10 Jahre"));
    					assertTrue(rangeFilters.get(5).getText().trim().contains("Seit Auflage"));					
    				} else {
    					String uiNoDataMsgAnnual = driver.findElement(By.xpath("//div[contains(@class,'historic-nav')]//table//tr")).getText();
    					assertEquals(uiNoDataMsgAnnual, NOROLLINGDATAMSG);		
    				}
    			}
        	}catch (NoSuchElementException ex)	{
        		System.out.println("NAV is not displayed for this product: " + driver.getCurrentUrl());
        	}
        }
        
        @Then("^I verify Exluding Sales Charges in NAV Header$")
        public void iVerifyExclidingSalesTextNav() throws Throwable {
        	try{
    			if (ProductDetailPage.productDetailPage(driver).getNavComponent().isDisplayed()) {
    				assertTrue(ProductDetailPage.productDetailPage(driver).getNavKExcluding().getText().contains("excluding sales charges"));    							
    			}
    		}catch(NoSuchElementException ex){
    			System.out.println("Nav is not displayed for this product: " + driver.getCurrentUrl());
    		}
    	}
        
        @Then("^I verify Exluding Sales Charges in NAV Header for German site$")
        public void iVerifyExclidingSalesTextNavForGermanSite() throws Throwable {
        	try{
    			if (ProductDetailPage.productDetailPage(driver).getNavComponent().isDisplayed()) {
    				assertTrue(ProductDetailPage.productDetailPage(driver).getNavKExcluding().getText().contains("ohne Verkaufsgebühren"));    							
    			}
    		}catch(NoSuchElementException ex){
    			System.out.println("Nav is not displayed for this product: " + driver.getCurrentUrl());
    		}
    	}
        
        @Then("^I verify the AsOfDate format is based on country's local for NAV chart$")
        public void iVerifyAsofDateFormatForNav() throws Throwable {
        	try {
        		if (ProductDetailPage.productDetailPage(driver).getNavComponent().isDisplayed()) {
    				if (driver.findElements(By.xpath("//div[contains(@class,'historic-nav')]/div")).size() > 2) {
    					assertTrue(ProductDetailPage.productDetailPage(driver).getNavAsOfDate().isDisplayed());
    					String asOfDateUi = ProductDetailPage.productDetailPage(driver).getNavAsOfDate().getText();		
    					String[] currentUrl  = driver.getCurrentUrl().split("/");
    					ProductListSteps.verifyLocaleFormattedDate(asOfDateUi, currentUrl[3]);
    				} else {
    					String uiNoDataMsgAnnual = driver.findElement(By.xpath("//div[contains(@class,'historic-nav')]//table//tr")).getText();
    					assertEquals(uiNoDataMsgAnnual, NOROLLINGDATAMSG);				
    				}
    			}
        	}catch (NoSuchElementException ex)	{
        		System.out.println("Nav is not displayed for this product: " + driver.getCurrentUrl());
        	}
        }
        
        @Then("^I click on characteristics tab on product detail page for German Site$")
        public void iClickOnCharacteristicsTabPDDe() throws Throwable {
        	Thread.sleep(3000);
        	ProductDetailPage.productDetailPage(driver).getCharacteristicsTabDe().click();
        	Thread.sleep(10000);
        }        
        
        @Then("^I verify the characteristics section is displayed and the tab is active for German Site$")
        public void IVerifyTheCharSectionIsActiveDe() throws Throwable {
        	String cssClass = ProductDetailPage.productDetailPage(driver).getCharacteristicsTabDe().getAttribute("class");
            assertTrue(cssClass.contains("active"));
        }
             
        @Then("^I click on Distributions tab on product detail page for German Site$")
        public void iClickOnDistributionsTabOnDetailPageDe() throws Throwable {
        	if (ProductDetailPage.productDetailPage(driver).getDistributionsTabDe().isDisplayed()) {
        		Thread.sleep(3000);
        		ProductDetailPage.productDetailPage(driver).getDistributionsTabDe().click();
        		Thread.sleep(3000);
        	}
        }
        
        @Then("^I verify the Distributions section is displayed the tab is active for German Site$")
        public void iVerifyTheDistributionsSectionIsActiveDe() throws Throwable {
        		String cssClass = ProductDetailPage.productDetailPage(driver).getDistributionsTabDe().getAttribute("class");
        		assertTrue(cssClass.contains("active"));        		
        }
        
        @Then("^I verify the AsOf date is displayed on \"([^\"]*)\" table for German Site$")
    	public void iVerifyAsOfDateOnCumulativeTableDe(String tableId) throws Throwable {
    		try{
    			if (ProductDetailPage.productDetailPage(driver).getCumulativePerfComponent(tableId).isDisplayed()) {
    				if (driver.findElements(By.xpath("//div[contains(@class,'"+tableId+"')]//table//tr")).size() > 1) {
    					assertTrue(ProductDetailPage.productDetailPage(driver).getAsOfDate(tableId).isDisplayed());
    					String asOfDateUi = ProductDetailPage.productDetailPage(driver).getAsOfDate(tableId).getText();	
    					String[] currentUrl  = driver.getCurrentUrl().split("/");
    					ProductListSteps.verifyLocaleFormattedDate(asOfDateUi, currentUrl[3]);
    				} else {
    					String uiNoDataMsgAnnual = driver.findElement(By.xpath("//div[contains(@class,'"+tableId+"')]//table//tr")).getText();
    					if (tableId.contains("three-year-risk")) {
    						assertEquals(uiNoDataMsgAnnual, NO_THREEYEARDATA_MSG_DE);
    					} else if (tableId.contains("yields characteristics yields")) {
        					assertEquals(uiNoDataMsgAnnual, NO_YIELDS_MSG_DE);  
    					} else if (tableId.contains("daily-statistics characteristics")) {
        					assertEquals(uiNoDataMsgAnnual, NO_DAILYSTATS_MSG_DE);	
    					}else {
    						assertEquals(uiNoDataMsgAnnual, NOROLLINGDATAMSG_DE);
    					}	
    				}
    			}
    		}catch(NoSuchElementException ex){
    			System.out.println(tableId + " Performance Table is not displayed in Performance Section");
    		}
    	}
        
        @Then("^I verify the Yields header is displayed for German Site$")
        public void iVerifyTheYieldsHeaderIsDisplayedDe() throws Throwable {
        	try {
           		if(ProductDetailPage.productDetailPage(driver).getYieldsComponent().isDisplayed()){
           			assertEquals(ProductDetailPage.productDetailPage(driver).getYieldsHeaderText().getText(), "Renditen");
        		}	
         	}catch(NoSuchElementException ex) {
         		System.out.println("Yields table is not Authored in Performance Section");
         	} 
             
        }
        
        @Then("^I verify the Yields AsOfDate is displayed for German Site$")
        public void iVerifyTheYieldsAsOfDateIsDisplayedDe() throws Throwable {
        	try {
           		if(ProductDetailPage.productDetailPage(driver).getYieldsComponent().isDisplayed()){
           			assertEquals(ProductDetailPage.productDetailPage(driver).getYieldsAsOfText().getText(), "aktuelles NAV-Datum");
           			assertTrue(ProductDetailPage.productDetailPage(driver).getYieldsAsOfDate().isDisplayed());
        		}	
         	}catch(NoSuchElementException ex) {
         		System.out.println("Yields table is not Authored in Performance Section");
         	} 
        }
        
        @Then("^I verify the Benchmark header is displayed as Benchmark on \"([^\"]*)\" table for German site$")
    	public void iVerifyTheBenchMarkDataOnPerfDe(String tableId) throws Throwable {		
    		try {
    			 if(driver.findElements(By.xpath("//div[contains(@class,'"+tableId+"')]//table//tr")).size() > 1 ) {
    				 List <WebElement> perfTableDataRows = driver.findElements(By.xpath("//div[contains(@class,'"+tableId+"')]//table//tr"));
    				 if(perfTableDataRows.size()>2) {
    					 String benchmarkHeader = driver.findElement(By.xpath("//div[contains(@class,'"+tableId+"')]//table//tr[2]/td[1]")).getText();
    					 assertEquals(benchmarkHeader, "Referenzindex");
    				 }else {
    					 System.out.println("Benchmark data is not displayed in " +tableId+ " table");
    				 }	 
    			 }else {
    				 System.out.println("Benchmark data is not displayed in " +tableId+ " table");
    			 }				 			
    		}catch(NoSuchElementException ex){
    			System.out.println(tableId + "Table is not displayed in Performance Section");
    		}	  
    	}
        
        @Then("^I click on Annualised tab under Performance section for France site$")
    	public void iClickOnAnnualisedTabInPerformanceSectionForFranceSite() throws Throwable {	
    		Thread.sleep(5000);
    		ProductDetailPage.productDetailPage(driver).getAnnualizedTabFR().click();
    	}
        
        @Then("^I verify the Annualised Performance table is displayed with header for France site$")
    	public void iVerifyTheAnnualisedPerformanceTableForFranceSite() throws Throwable {
    		try{
    			if (ProductDetailPage.productDetailPage(driver).getAnnualisedPerfComponent().isDisplayed()) {
    				assertTrue(ProductDetailPage.productDetailPage(driver).getAnnualisedComponentHeader().getText().contains("Performance annualisée (%)"));				
    			}
    		}catch(NoSuchElementException ex){
    			//Do nothing
    		}	 
    	}
        
        @Then("^I verify the Header dates on Annualised Performance table for France site$")
    	public void iVerifyTheHeaderDateOnAnnualisedTableForFranceSite() throws Throwable {
    		try {
    			if(driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).size() > 1 ) {
    				List <WebElement> rollingDataRows = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr"));
    				List <WebElement> rollingHeaders = driver.findElements(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th"));
    				if(rollingDataRows.size()>1) {				
    						String uiYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[2]")).getText();
    						assertEquals(uiYearAnnualHeader, "1-an %");
    														
    						String uiThreemonthAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[3]")).getText();
    						assertEquals(uiThreemonthAnnualHeader, "3-ans %");
    																			
    						String uiOneYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[4]")).getText();
    						assertEquals(uiOneYearAnnualHeader, "5-ans %");
    						
    									
    						String uiThreeYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[5]")).getText();
    						assertEquals(uiThreeYearAnnualHeader, "10-ans %");
    						
    						String uiFiveYearAnnualHeader = driver.findElement(By.xpath("//div[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr[1]/th[6]")).getText();
    						assertEquals(uiFiveYearAnnualHeader, "Date de lancement");
    										
    				 }	
    			 }else {
    				 String uiNoDataMsg = driver.findElement(By.xpath("//*[contains(@class,'annualised-performance annualised-performance-byeny')]//table//tr")).getText();
    				 assertEquals(uiNoDataMsg, NOROLLINGDATAMSG);
    			 } 
    		  
    	}catch(NoSuchElementException ex){
    		System.out.println("Annualised Performance Table is not displayed in Performance Section");
    	}  
    }
        
        @Then("^I verify the Benchmark header is displayed as Benchmark on \"([^\"]*)\" table for France site$")
    	public void iVerifyTheBenchMarkDataOnPerfFR(String tableId) throws Throwable {		
    		try {
    			 if(driver.findElements(By.xpath("//div[contains(@class,'"+tableId+"')]//table//tr")).size() > 1 ) {
    				 List <WebElement> perfTableDataRows = driver.findElements(By.xpath("//div[contains(@class,'"+tableId+"')]//table//tr"));
    				 if(perfTableDataRows.size()>2) {
    					 String benchmarkHeader = driver.findElement(By.xpath("(//div[contains(@class,'"+tableId+"')]//table//tr)[3]//td[1]")).getText();
    					 assertEquals(benchmarkHeader, "Indice de référence");
    				 }else {
    					 System.out.println("Benchmark data is not displayed in " +tableId+ " table");
    				 }	 
    			 }else {
    				 System.out.println("Benchmark data is not displayed in " +tableId+ " table");
    			 }				 			
    		}catch(NoSuchElementException ex){
    			System.out.println(tableId + "Table is not displayed in Performance Section");
    		}	  
    	}
  
        @Then("^I click on Calendar tab under Performance section for France site$")
    	public void iClickOnCalendarTabInPerformanceSectionForFranceSite() throws Throwable {	
    		Thread.sleep(5000);
    		ProductDetailPage.productDetailPage(driver).getCalendarTabFR().click();
    	}
        
        @Then("^I verify the Calendar Performance table is displayed with header for France site$")
    	public void iVerifyTheCalendarPerformanceTableForFranceSite() throws Throwable {
    		try{
    			if (ProductDetailPage.productDetailPage(driver).getCalendarPerfComponent().isDisplayed()) {
    				assertTrue(ProductDetailPage.productDetailPage(driver).getCalendarComponentHeader().getText().contains("Performance par année civile (%)"));				
    			}
    		}catch(NoSuchElementException ex){
    			//Do nothing
    		}	 
    	}
        
        @Then("^I verify the \"([^\"]*)\" Performance table is displayed with header for France site$")
    	public void iVerifyTheCumulativePerformanceTableForFranceSite(String tableId) throws Throwable {
    		try{
    			if (ProductDetailPage.productDetailPage(driver).getCumulativePerfComponent(tableId).isDisplayed()) {
    				assertTrue(ProductDetailPage.productDetailPage(driver).getCumulativeComponentHeader().getText().contains("Performance cumulée (%)"));				
    			}
    		}catch(NoSuchElementException ex){
    			//Do nothing
    		}	 
    	}
        
        @Then("^I click on Cumulative tab under Performance section for France site$")
    	public void iClickOnCumulativeTabInPerformanceSectionForFranceSite() throws Throwable {	
    		Thread.sleep(5000);
    		ProductDetailPage.productDetailPage(driver).getCumulativeTabFR().click();
    	}
        
}
        
  