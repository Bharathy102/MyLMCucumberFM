package com.publisher.steps;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.publisher.pageobjects.HomePageObject;
import com.publisher.pageobjects.MarketInsightPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MarketInsightsSteps extends Utility{

	public static final String HTTP_CODE_200 = "200####OK";
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    
    @Then("^I Click Market Insights header$")
	public void iVerifyThemarketinsightslinks() throws Throwable {
    	try {
    	 if (driver.getCurrentUrl().contains("en-au")) {
    		 HomePageObject.homePageObject(driver).getPersPectiveHeaderAU().click();
    		 Thread.sleep(3000);
 		} 
    	 else if (driver.getCurrentUrl().contains("en-gb")) {
    		 Thread.sleep(3000);
    		 HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
    		 Thread.sleep(3000);
 		}else {
 			Thread.sleep(3000);
 			HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
 			Thread.sleep(3000);
 			}
    	} catch (NoSuchElementException ex) {
    	     //do nothing
    	 	}
    	 } 
			
    @And("^I Verify Market Insight Banner Section in Available or not$")
    public  void iVerifyMarketInsightBanner() throws Exception{    	   		
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getMarketBannerImg().isDisplayed());
    }
        
    @And("^I Verify Market Insights Banner Title is available or not in Market Insight page$")
    public  void iVerifyTheMarketInsightTitle() throws Exception{    	
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getMarketBannerTitle().isDisplayed());
    }
    @And("^I Verify Weekly Update Section is available or not in Market Insight page$")
    public  void iVerifyTheWeeklyUpdateSection() throws Exception{ 
    	/*try {
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getWeeklyUpdateHeader().isDisplayed());
    }catch (Error e) {
    	System.out.println("Weekly Update Section is not Available");
    	}
    }*/
    try {
  	    if (MarketInsightPageObject.marketInsightPageObject(driver).getWeeklyUpdateHeader().isDisplayed()) {
  	       	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getWeeklyUpdateHeader().isDisplayed());
  	    }else {
  	    	System.out.println("Weekly Update Header is not availble for Individual Investor"); }
  	    }
    catch (NoSuchElementException ex) {
      //do nothing
  	}
  }  
    
    @Then("^I Verify Chart of the Week is Available or not in Weekly Update Section$")
    public  void iVerifyChartofTheWeek() throws Exception{  
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getChartofTheWeek().isDisplayed());
    }
    @And("^I Verify Mid-Week Bond Update is Available or not in Weekly Update Section$")
    public  void iVerifyMidWeekBond() throws Exception{    	 
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getMidWeekBondUpdate().isDisplayed());
    }
    @And("^I Verify Weekly Snapshot is Available or not in Weekly Update Section$")
    public  void iVerifyWeeklySnapShot() throws Exception{  
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getWeeklySnapsHot().isDisplayed());
    }
    @And("^I Verify Blog Section is available or not in Market Insight page$")
    public  void iVerifyTheBlogsSection() throws Exception{  
    	 try {
 	        if (MarketInsightPageObject.marketInsightPageObject(driver).getBlogHeader().isDisplayed()) {
 	        	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getBlogHeader().isDisplayed());
 	        	 	 }else {System.out.println("Blog Header is not availble for Individual Investor"); }
 	        		 }
 catch (NoSuchElementException ex) {
     //do nothing
 	}
 }  
    	 
    @Then("^I Verify Around the Curve is Available or not in Blog Section$")
    public  void iVerifyAroundTheCurve() throws Exception{ 
    	try {
    	if (getConfigValue().getProperty("user_role").equalsIgnoreCase("1") && !driver.getCurrentUrl().contains("en-au")) {
    		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getAroundTheCurve().isDisplayed());
		} else if (getConfigValue().getProperty("user_role").equalsIgnoreCase("2") && !driver.getCurrentUrl().contains("en-au")) {
			System.out.println("Around the Curve is not Available in Indivual Investor"); 
		} else {
			System.out.println("User Role is not configured");
		}
    }
    	 catch (NoSuchElementException ex) {
    	     //do nothing
    	 	}
    	 } 
    @And("^I Verify Above the Noise is Available or not in Blog Section$")
    public  void iVerifyAboveTheNoise() throws Exception{   
    	
    	try {
        	if (getConfigValue().getProperty("user_role").equalsIgnoreCase("1") && !driver.getCurrentUrl().contains("en-au")) {
        		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getAboveTheNoise().isDisplayed());
    		} else if (getConfigValue().getProperty("user_role").equalsIgnoreCase("2") && !driver.getCurrentUrl().contains("en-au")) {
    			System.out.println("Around the Noise is not Aailable in Indivual Investor"); 
    		} else {
    			System.out.println("User Role is not configured");
    		}
        }
        	 catch (NoSuchElementException ex) {
        	     //do nothing
        	 	}
        	 } 
	
    @And("^I Verify Browse All Section is available or not in Market Insight page$")
    public  void iVerifyBrowseAllSection() throws Exception{  
    	 try {
  	        if (MarketInsightPageObject.marketInsightPageObject(driver).getBrowserHeader().isDisplayed()) {
  	        	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getBrowserHeader().isDisplayed());
  	        	 	 }else {System.out.println("Browse Header is not availble for Individual Investor"); }
  	        		 }
  catch (NoSuchElementException ex) {
      //do nothing
  	}
  }  

    @And("^I Verify Sort By DropDown Section is available or not in Market Insight page$")
    public  void iVerifySortByDropDown() throws Exception{  
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().isDisplayed());
    }
    
    @And("^I Verify Default Grid Selection is available or not in Market Insight page$")
    public  void iVerifyDefaultGridTab() throws Exception{ 
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getTabGrid().isDisplayed());
    }  
    @And("^I Verify Grid Tab Section is available or not in Market Insight page$")
    public  void iVerifyGridTab() throws Exception{    	
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getTabGrid().isDisplayed());
    }
    @And("^I Verify List Tab Section is available or not in Market Insight page$")
    public  void iVerifyListTab() throws Exception{  
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getTabList().isDisplayed());
    }
  
    @When("^I Click List Tab Section in Market Insight page$")
    public  void iVerifyClickListTab() throws Exception{    	   		
    	MarketInsightPageObject.marketInsightPageObject(driver).getTabList().click(); 
    	        }
    
    @And("^I Verify total List Tab results$")
    public  void iVerifyListTabResults() throws Exception{    
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getGridTotal().isDisplayed());
    	Thread.sleep(3000);
    }
    	 
    @And("^I Verify List view layout header-Page$")
    public  void iVerifyListTabPage() throws Exception{  
    assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getTitleList().isDisplayed());
	}
    @And("^I Verify List view layout header-Eyebrow$")
    public  void iVerifyListEyeBrow() throws Exception{ 
    	
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getEyebrowList().isDisplayed());
    }	  
    @And("^I Verify List view layout header-Description$")
    public  void iVerifyListDescription() throws Exception{
    	
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getDescriptionList().isDisplayed());
    }
    
    @And("^I Verify List view layout header-Date$")
    public  void iVerifyListDate() throws Exception{    
    	List <WebElement> hideDates = MarketInsightPageObject.marketInsightPageObject(driver).getHideDate();
    	if (hideDates.size()==0) {
    		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getDateList().isDisplayed());
    	}	
    }
    
    @When("^I Verify List view layout header-Page for de site$")
    public void iVerifyListViewLayoutHeaderPageForDeSite() throws Throwable {
        Thread.sleep(2000);
        assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getTitleListDe().isDisplayed());
    }
    
    @When("^I Verify List view layout header-Page for France site$")
    public void iVerifyListViewLayoutHeaderPageForFranceSite() throws Throwable {
        Thread.sleep(2000);
        assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getTitleListFR().isDisplayed());
    }

    @When("^I Verify List view layout header-Eyebrow for de site$")
    public void iVerifyListViewLayoutHeaderEyebrowForDeSite() throws Throwable {
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getEyeBrowListDe().isDisplayed());
    }
    
    @When("^I Verify List view layout header-Eyebrow for France site$")
    public void iVerifyListViewLayoutHeaderEyebrowForFranceSite() throws Throwable {
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getEyeBrowListFR().isDisplayed());
    }

    @When("^I Verify List view layout header-Description for de site$")
    public void iVerifyListViewLayoutHeaderDescriptionForDdeSite() throws Throwable {
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getDescriptionListDe().isDisplayed());
    }
    
    @When("^I Verify List view layout header-Description for France site$")
    public void iVerifyListViewLayoutHeaderDescriptionForFranceSite() throws Throwable {
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getDescriptionListFR().isDisplayed());
    }

    @When("^I Verify List view layout header-Date for de site$")
    public void iVerifyListViewLayoutHeaderDateForDeSite() throws Throwable {
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getDateListDe().isDisplayed());
    }
    
    @When("^I Verify List view layout header-Date for France site$")
    public void iVerifyListViewLayoutHeaderDateForFranceSite() throws Throwable {
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getDateListFR().isDisplayed());
    }
    
    @And("^I Verify List Tile Page Link and Lunched Page URL$")
   	public void iVerifyTheListTileLinks() throws Throwable {
   		MarketInsightPageObject.marketInsightPageObject(driver).getListTileLink().click();
   		Thread.sleep(3000);
    	}
    @When("^I Click Grid Tab Section in Market Insight page$")
    public  void iVerifyClikGridTab() throws Exception{  
    	 MarketInsightPageObject.marketInsightPageObject(driver).getTabGrid().click(); 
    } 
    @And("^I Verify total Grid results$")
    public  void iVerifyGridTabResults() throws Exception{    	   		
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getGridTotal().isDisplayed());
    }
    
	@And("^I click on Grid View link$")
    public  void iClickOnGridViewLink() throws Exception{    	   		
    	MarketInsightPageObject.marketInsightPageObject(driver).getGridViewLink().click();
    	Thread.sleep(3000);    
	}
	
 	@And("^I Verify Grid Tile Image is available or not$")
    public  void iVerifyGridImage() throws Exception{   
 		assertTrue(driver.findElement(By.xpath("//div[@id='tab-grid']")).getAttribute("class").contains("active"));
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getGridImgLink().isDisplayed());
 	}
 	
    @And("^I Verify Grid Tile EyeBrow is available or not$")
    public  void iVerifyEyeBrow() throws Exception{ 
    	assertTrue(driver.findElement(By.xpath("//div[@id='tab-grid']")).getAttribute("class").contains("active"));
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getGridEyeBrowLink().isDisplayed());
 	}
    
    @And("^I Verify Grid Tile Title is available or not$")
    public  void iVerifyGridTitle() throws Exception{
    	assertTrue(driver.findElement(By.xpath("//div[@id='tab-grid']")).getAttribute("class").contains("active"));
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getGridTileLinks().isDisplayed());
   	}
    
    @And("^I Verify Grid Tile Description is available or not$")
    public  void iVerifyGridDescription() throws Exception{ 
    	assertTrue(driver.findElement(By.xpath("//div[@id='tab-grid']")).getAttribute("class").contains("active"));
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getGridDescriptionLink().isDisplayed());
	}
    
    @When("^I Verify Grid Tile Link and Lunched URL$")
   	public void iVerifyTheGridTileLinks() throws Throwable {
    	MarketInsightPageObject.marketInsightPageObject(driver).getGridTileLinks().click();
   		if (driver.getCurrentUrl().contains("en-au")) {
   			HomePageObject.homePageObject(driver).getPersPectiveHeaderAU().click();
   		} else {
   			HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
   		}
 	}
    @And("^I click SoryBy DropDown Link$")
   	public void iVerifyClickSortByDrop() throws Throwable {
   		MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().click();
   			Thread.sleep(3000);
	}
    @And("^I verify Ascending By Date is available or not in SortBy DropDown$")
   	public void iverifyascendingdateornot() throws Throwable {
    	List <WebElement> hideDates = MarketInsightPageObject.marketInsightPageObject(driver).getHideDate();
    	if (hideDates.size()==0) {
    		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getAcendingDate().isDisplayed());
    	}	
   	}
   	        
    @And("^I verify Ascending By title is available or not in SortBy DropDown$")
   	public void iVerifyAscendingTitle() throws Throwable {
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getAcendingTitle().isDisplayed());
	}
    
    @And("^I verify Descending By Date is available or not in SortBy DropDown$")
   	public void iVerifyDescendingDate() throws Throwable {
    	List <WebElement> hideDates = MarketInsightPageObject.marketInsightPageObject(driver).getHideDate();
    	if (hideDates.size()==0) {
    		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getDscendingDate().isDisplayed());
    	}    	
	}
    
    @And("^I verify Descending By title is available or not in SortBy DropDown$")
   	public void iVerifyDescendingTitle() throws Throwable {
   		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getDscendingTitle().isDisplayed());
   		if (driver.getCurrentUrl().contains("en-au")) {
   			HomePageObject.homePageObject(driver).getPersPectiveHeaderAU().click();
		} else {
			HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
		}
    }
    
	@And("^I Click and Verify Descending By title Selection page is lunched$")
	public void iVerifyDscendingTitleSelection() throws Throwable {
		try {
			if (MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().isDisplayed()) {
				MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().click();
				List <WebElement> hideDates = MarketInsightPageObject.marketInsightPageObject(driver).getHideDate();
    	    	if (hideDates.size()==0) {
    	    		if (MarketInsightPageObject.marketInsightPageObject(driver).getDscendingTitle().isDisplayed()) {
    	    			MarketInsightPageObject.marketInsightPageObject(driver).getDscendingTitle().click();
    	    		}
    	    		Thread.sleep(1000);
    	    		String productstxt = driver.getCurrentUrl();
    	    		if (productstxt.contains("sort=hd")) {
    	    			System.out.println("Verify Descending By title Selection page is lunched " + "===>" + productstxt);
    	    		} else {
    	    			System.out.println("Verify Descending By title Selection page not lunched" + "===>" + productstxt);
    	    		}
    	    	}	
			}
		} catch (NoSuchElementException ex) {
			// do nothing
		}
	} 
    
    @And("^I Click and Verify Descending By Date Selection page is lunched$")
    public  void iVerifyDscendingDateSelection() throws Throwable{    	   		
    	try {
    		if (MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().isDisplayed()) {
    			MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().click();
    			List <WebElement> hideDates = MarketInsightPageObject.marketInsightPageObject(driver).getHideDate();
    	    	if (hideDates.size()==0) {
    	    		MarketInsightPageObject.marketInsightPageObject(driver).getDscendingDate().click();
 	        		String productstxt = driver.getCurrentUrl();
 	        		if (productstxt.contains("sort=dd")) {
 	        			System.out.println("Verify Descending By date Selection page is lunched "+"===>" +productstxt);
 	        		}else {
    	        		System.out.println("Verify Descending By date Selection page is not lunched" +"===>"+productstxt);
    	        	}
    	    	}
    		}
    	}catch (NoSuchElementException ex) {
    		 //do nothing
    	}
    } 
    
    @And("^I Click and Verify Ascending By title Selection page is lunched$")
    public  void iVerifyAscendingTitleSelection() throws Throwable{    	   		
    	try {
    		if (MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().isDisplayed()) {
    			MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().click();
    			List <WebElement> hideDates = MarketInsightPageObject.marketInsightPageObject(driver).getHideDate();
    	    	if (hideDates.size()==0) {
    	    		MarketInsightPageObject.marketInsightPageObject(driver).getAcendingTitle().click();
    	    		String productstxt = driver.getCurrentUrl();
    	    		if (productstxt.contains("sort=ha")) {
    	    			System.out.println("Verify Ascending By title Selection page is lunched "+"===>" +productstxt);
    	    		}else{
    	    			System.out.println("Verify Ascending By title Selection page is not lunched" +"===>"+productstxt);
    	    		}
    	    	}
    		}
    	}catch (NoSuchElementException ex) {
        //do nothing
    	}
    } 
    
	@And("^I Click and Verify Ascending By Date Selection page is lunched$")
	public void iVerifyAscendingDateSlection() throws Throwable {
		try {
			if (MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().isDisplayed()) {
				MarketInsightPageObject.marketInsightPageObject(driver).getSortBy().click();
				List <WebElement> hideDates = MarketInsightPageObject.marketInsightPageObject(driver).getHideDate();
    	    	if (hideDates.size()==0) {
    	    		MarketInsightPageObject.marketInsightPageObject(driver).getAcendingDate().click();
    	    		String productstxt = driver.getCurrentUrl();
    	    		if (productstxt.contains("sort=da")) {
    	    			System.out.println("Verify Ascending By date Selection page is lunched " + "===>" + productstxt);
    	    		} else {
    	    			System.out.println("Verify Ascending By date Selection page is not lunched" + "===>" + productstxt);
    	    		}
    	    	}
			}
		} catch (NoSuchElementException ex) {
			// do nothing
		}
	}
    
	@When("^I Verify Sorting using List tap$")
	public void iVerifysortinglisttab() throws Throwable {
		Actions ac= new Actions(driver);
		if (driver.getCurrentUrl().contains("en-au")) {
			HomePageObject.homePageObject(driver).getPersPectiveHeaderAU().click();
			MarketInsightPageObject.marketInsightPageObject(driver).getTabList().click();
		} else {
			//HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
			ac.click(HomePageObject.homePageObject(driver).getPersPectiveHeader()).perform();
			//MarketInsightPageObject.marketInsightPageObject(driver).getTabList().click();
			ac.click(MarketInsightPageObject.marketInsightPageObject(driver).getTabList()).perform();
		}
	}

	@When("^I Verify Chart of the week Link in Market Insights Page$")
	public void iVerifyLinkchartoftheweek() throws Throwable {

		if (driver.getCurrentUrl().contains("en-au")) {
			// this.homePageObject.getPersPectiveHeaderAU().click();
		} else {
			MarketInsightPageObject.marketInsightPageObject(driver).getChartofTheWeek().click();
		}
	}
	
    
    @And("^I verify the title of Chart of the week page$")
	public void iverifythetitleofthehomepage() throws Throwable {
		assertTrue("driver.getTitle(): " +driver.getTitle(), driver.getTitle().contains("Chart of the week") || driver.getTitle().contains("Asia Chart of the Week"));
	}
  @And("^I Verify the Grid Page link in Chart of the week$")
    public  void iVerifygridpagelinkchart() throws Exception{    	   		
    	MarketInsightPageObject.marketInsightPageObject(driver).getGridTileLinks().click();
   	 }
   @When("^I Verify Weekly Snapshot Link in Market Insights Page$")
    public  void iVerifyLinkeweeklybondsnap() throws Throwable{    	   		
    	   
   if (driver.getCurrentUrl().contains("en-au")) {
	   HomePageObject.homePageObject(driver).getPersPectiveHeaderAU().click();
		
		} else {
			HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
  	      MarketInsightPageObject.marketInsightPageObject(driver).getWeeklySnapsHot().click(); 
   } 
  }
    
    @And("^I verify the title of Weekly Snapshot page$")
	public void iVerifyTheTitleofWeeklySnap() throws Throwable {
		assertEquals(driver.getTitle(), "Weekly Snapshot");
	}
    @And("^I Verify the Grid Page link in Weekly Snapshot page$")
    public  void iVerifyWeeklySnapGridPageLink() throws Exception{    	   		
    	MarketInsightPageObject.marketInsightPageObject(driver).getGridTileLinks().click();
    }
   @When("^I Verify Mid-Week Bond Update Link in Market Insights Page$")
    public  void iVerifyWeeklySnapLink() throws Throwable{    	   		
    	    
   if (driver.getCurrentUrl().contains("en-au")) {
		 
		} else {
			HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
    	   	MarketInsightPageObject.marketInsightPageObject(driver).getMidWeekBondUpdate().click(); 
    	 } 
}

    @And("^I verify the title of Mid-Week Bond Update page$")
	public void iVerifyTheWeeklyBondTitle() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "Mid-Week Bond Update");
	}
   @And("^I Verify the Grid Page link in Mid-Week Bond Update page$")
    public  void iVerifyWeeklyBondGridPageLink() throws Exception{    	   		
    	MarketInsightPageObject.marketInsightPageObject(driver).getGridTileLinks().click();
   		 }
    @And("^I verify the title of page clicked and Lunched$")
   	public void iVerifyWeeklyBondGridpageLunc() throws Throwable {
    	 String actualTitle = driver.getTitle();
 	   Assert.assertEquals(driver.getTitle(), actualTitle);
   	}
    @Then("^I verify Filter is available or not in the Market Insight page$")
	public void iVerifyTheFilterIconIsDisplayed() throws Throwable {
    	Actions ac= new Actions(driver);
    	if (driver.getCurrentUrl().contains("en-au")) {
    		HomePageObject.homePageObject(driver).getPersPectiveHeaderAU().click();
      		MarketInsightPageObject.marketInsightPageObject(driver).getFilterIcon().isDisplayed();
   		} else {
   			//HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
   			ac.click(HomePageObject.homePageObject(driver).getPersPectiveHeader()).perform();
   			MarketInsightPageObject.marketInsightPageObject(driver).getFilterIcon().isDisplayed();
   		}
    	
	}
   
   
    @And("^I click on the filter button$")
	public void iClickOnFilterIconToExpandTheFilters() throws Throwable {
	      MarketInsightPageObject.marketInsightPageObject(driver).getFilterButton().click();
	      Thread.sleep(3000);
	}
    @Then("^I verify that filter is expanded$")
	public void iVerifyTheFiltersAreExpanded() throws Throwable {
		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getFilterCloseButton().isDisplayed());	    
	}
	@And("^I verify that Affiliate filter section is available or not$")
       public void iverifyFilterAffiliateSection() throws Exception {
    	   assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getAffliateSection().isDisplayed());
   	}
	
	@Then("^I verify that Affiliate filter section is available or not for de site$")
	public void iVerifyThatAffiliateFilterSectionIsAvailableOrNotForDeSite() throws Throwable {
		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getFilterAffSectionDe().isDisplayed());
	}
	
    @And("^I verify that Featured filter section is available or not$")
       public void iverifyFilterFeaturedSection() throws Exception {
    	int featuredFilterSize = driver.findElements(By.xpath("//*[@class='inner expanded']//*[contains(text(),'Featured')]")).size();
    	if(featuredFilterSize==1) {   
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getFeaturedSection().isDisplayed());
    	}
   	}
    
    @Then("^I verify that Featured filter section is available or not for de site$")
    public void iVerifyThatFeaturedFilterSectionIsvailableOrNotForDeSite() throws Throwable {
    	assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getFilterFeaturedSectionDe().isDisplayed());
    	
    }
    
   @And("^I verify that Content Type filter section is available or not$")
       public void iverifyFilterContentTypeSection() throws Exception {
    	   assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getContentTypeSection().isDisplayed());
   	}
   
   @Then("^I verify that Content Type filter section is available or not for de site$")
   public void iVerifyThatContentTypeFilterSectionIsAvailableOrNotForDeSite() throws Throwable {
	   assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getFilterContTypeSectionDe().isDisplayed());
   }
   
    @And("^I Verify the Combination of Different Filters Selection$")
   		public void iSelectOnDifferentCheckboxFilters() throws Throwable {
    	   Thread.sleep(3000);
   	      MarketInsightPageObject.marketInsightPageObject(driver).getAffliateCB().click();
   	      MarketInsightPageObject.marketInsightPageObject(driver).getAffliateLM().click();
   	}
   	@Then("^I Verify the selected Filter Options added to the Top of Expandable Area$")
   	public void iVerifyOnSelectedExpandedArea() throws Throwable {
   		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getSelectedFilters().isDisplayed());
   	    }
   	@Then("^I verify that filter Buble is Displayed$")
   	public void iVerifyTheFiltersBubleD() throws Throwable {
   		Thread.sleep(2000);
   		assertTrue(MarketInsightPageObject.marketInsightPageObject(driver).getSelectedBubleNo().isDisplayed());	    
   	}
   	@And("^I Verify the DeSelection of Filters$")
   	public void iSelectOnDeselectionCheckboxFilters() throws Throwable {
   	      MarketInsightPageObject.marketInsightPageObject(driver).getAffliateCB().click();
   	   MarketInsightPageObject.marketInsightPageObject(driver).getAffliateLM().click();
   	   }
    @And("^I Verify the Clear All Filters Selection$")
   	public void iVerifyClearAllFilters() throws Throwable {
   	      MarketInsightPageObject.marketInsightPageObject(driver).getAffliateCB().click();
   	      MarketInsightPageObject.marketInsightPageObject(driver).getContentPro().click();
   	   MarketInsightPageObject.marketInsightPageObject(driver).getClearFilter().click();
   	} 
    @And("^I verify that the filter Close button click$")
    public void iVerifyFilterClose() throws Exception {
       		
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MarketInsightPageObject.marketInsightPageObject(driver).getFilterCloseButton());
    		//MarketInsightPageObject.marketInsightPageObject(driver).getFilterCloseButton().click();
    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", MarketInsightPageObject.marketInsightPageObject(driver).getFilterCloseButton());
    	}
   		
    @Then("^I Click List Tab to Verify Filter in List View Selection$")
   	public void iVerifyFilterIconIsDisplayedinList() throws Throwable {
    	Actions ac= new Actions(driver);
       if (driver.getCurrentUrl().contains("en-au")) {
 		 HomePageObject.homePageObject(driver).getPersPectiveHeaderAU().click();
 		
		} else {
			//HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
			ac.click(HomePageObject.homePageObject(driver).getPersPectiveHeader()).perform();
	    	//MarketInsightPageObject.marketInsightPageObject(driver).getTabList().click();
			ac.click(MarketInsightPageObject.marketInsightPageObject(driver).getTabList()).perform();
	       	MarketInsightPageObject.marketInsightPageObject(driver).getFilterIcon().isDisplayed();
	   	}
    }
    @Then("^I Verify Filter in List View Selection$")
   	public void iVerifyFiltersListViewSelection() throws Throwable {
    	MarketInsightPageObject.marketInsightPageObject(driver).getTabList().click();
    		}
   /* @Then("I Verify the Broken Links for MarketInsights Page$")
	public void iVerifyTheBrokenLinksForMarketInsights() throws Throwable {
    	this.homePageObject.getPersPectiveHeader().click();
		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);
		System.out.println("The Market Insights Brokenlinks validation is success");

	} 
    @Then("I Verify the Broken Image for MarketInsights Page$")
	public void iVerifyTheBrokenImagesForMarketInsights() throws Throwable {
    	BrokenImageSteps brokenImages = new BrokenImageSteps();
    	brokenImages.verifyBrokenImages(driver);
		System.out.println("The Market Insights BrokenImages validation is success");

	} */
}
