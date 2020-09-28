package com.publisher.pageobjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.publisher.steps.CommonMethods;


public class ProductListPage {
	
	
	public static final String CLASS = "class";
    public static final String ACTIVE = "active";
    private static ProductListPage productList;
	private WebDriver driver;
	
	private ProductListPage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static ProductListPage productListPage(WebDriver driver) throws IOException {
		productList=null;
		productList=new ProductListPage(driver);
			return productList; 
	}
    
	
	@FindBy(xpath = "//div[@class='product-list parbase']")
	private WebElement productListComponent;
    
   	public WebElement getProductListComponent() throws Exception {
		return productListComponent;       
    }
   	
	@FindBy(xpath = "//*[@data-tabname='overview']")
	private WebElement overviewTab;
    
   	public WebElement getOverviewTab() throws Exception {
		return overviewTab;       
    }
   	
	@FindBy(xpath = "//*[@data-tabname='performance']")
	private WebElement performanceTab;
    
   	public WebElement getPerformanceTab() throws Exception {
		return performanceTab;       
    }
   	
	@FindBy(xpath = "//*[@id='tab-performance']//ul//a")
	private List <WebElement> performanceTabLinks;
    
   	public List <WebElement> getPerformanceTabLinks() throws Exception {
		return performanceTabLinks;       
    }
   	
	@FindBy(xpath = "(//th[@class='fund sorting_asc'])[1]")
	private WebElement fundNameColumn;
    
   	public WebElement getFundNameColumn() throws Exception {
		return fundNameColumn;       
    }
   	
	@FindBy(xpath = "//*[@data-interaction-detail='Share Class']")
	private WebElement shareClassColumn;
    
   	public WebElement getShareClassColumn() throws Exception {
		return shareClassColumn;       
    }
   	
	@FindBy(xpath = "//*[@data-interaction-detail='Fund Name']")
	private WebElement fundNameColumnOv;
    
   	public WebElement getFundNameColumnOv() throws Exception {
		return fundNameColumn;       
    }
   	
	@FindBy(xpath = "//*[@data-interaction-detail='NAV']")
	private WebElement navColumn;
    
   	public WebElement getNavColumn() throws Exception {
		return navColumn;       
    }
   		  
   	public WebElement getPlAuColumn(String columnName) throws Exception {
		return this.driver.findElement(By.xpath("//*[@data-interaction-detail='"+columnName+"']"));       
    }
   	
	@FindBy(xpath = "//*[@data-interaction-detail='Asset Type']")
	private WebElement assetTypeColumn;
    
   	public WebElement getAssetTypeColumn() throws Exception {
		return assetTypeColumn;       
    }
   	
	@FindBy(xpath = "//*[@data-interaction-detail='Distribution Type']")
	private WebElement distTypeColumn;
    
   	public WebElement getDistTypeColumn() throws Exception {
		return distTypeColumn;       
    }
   	
	@FindBy(xpath = "//*[@data-interaction-detail='Ccy']")
	private WebElement ccyColumn;
    
   	public WebElement getCcyColumn() throws Exception {
		return ccyColumn;       
    }
   	
	@FindBy(xpath = "//*[@data-interaction-detail='As of']")
	private WebElement asOfColumn;
    
   	public WebElement getAsOfColumn() throws Exception {
		return asOfColumn;       
    }
   	
	@FindBy(xpath = "//*[@data-interaction-detail='Domicile']")
	private WebElement domicileColumn;
    
   	public WebElement getDomicileColumn() throws Exception {
		return CommonMethods.clickableElement(domicileColumn);       
    }
   	
	@FindBy(xpath = "//*[@data-interaction-detail='ISIN']")
	private WebElement isinColumn;
    
   	public WebElement getIsinColumn() throws Exception {
		return isinColumn;       
    }
   	
	@FindBy(xpath = "(//*[@class=\"watchlist ico-watchlist\"])[1]")
	private WebElement watchListColumn;
    
   	public WebElement getWatchListColumn() throws Exception {
		return watchListColumn;       
    }
   	
	@FindBy(xpath = "(//*[@data-target=\"#keyActionsModal\"])[1]")
	private WebElement keyActionsColumn;
    
   	public WebElement getkeyActionsColumn() throws Exception {
		return keyActionsColumn;       
    }
   	
	@FindBy(xpath = "(//*[contains(@aria-label,'Last Price')])[1]")
	private WebElement lastPriceColumn;
    
   	public WebElement getLastPriceColumn() throws Exception {
		return lastPriceColumn;       
    }
   	
	@FindBy(xpath = "(//*[contains(@aria-label,'Entry Price')])[1]")
	private WebElement entryPriceColumn;
    
   	public WebElement getEntryPriceColumn() throws Exception {
		return entryPriceColumn;       
    }
   	
	@FindBy(xpath = "(//*[contains(@aria-label,'Exit Price')])[1]")
	private WebElement exitPriceColumn;
    
   	public WebElement getExitPriceColumn() throws Exception {
		return exitPriceColumn;       
    }
   	
	@FindBy(xpath = "(//*[contains(@aria-label,'APIR Code/ASX Ticker')])[1]")
	private WebElement apirCodeColumn;
    
   	public WebElement getAPIRCodeColumn() throws Exception {
		return apirCodeColumn;       
    }
   	
   	public WebElement getFundNameLink(String tabName) throws Exception {
   		return this.driver.findElement(By.xpath("(//*[@id='"+ tabName +"']//tbody/tr/td[1])[1]/a"));      
    }
   	    
   	public WebElement getFundNameText(String tabName) throws Exception {
		return this.driver.findElement(By.xpath("(//*[@id='"+ tabName +"']//tbody/tr/td[1]/a)[1]"));    
    }
   	
	/*@FindBy(xpath = "(//*[@id='overview-table']/tbody/tr/td[2])[1]")
	private WebElement shareClassText;
    
   	public WebElement getShareClassText() throws Exception {
		return shareClassText;       
    } */
   	
 	public WebElement getShareClassText(String tabName) throws Exception {
		return this.driver.findElement(By.xpath("(//*[@id='"+ tabName +"']//tbody/tr/td[2])[1]"));    
    }
 	
	public List<WebElement> getTotalFunds(String tabName) {
    	return this.driver.findElements(By.xpath("//*[@id='"+tabName+"']//tbody/tr"));                
    }
   	
	@FindBy(xpath = "//section[contains(@class,'product-summary-comp')]//h1")
	private WebElement fundNameTitle;
    
   	public WebElement getFundNameTitle() throws Exception {
		return fundNameTitle;       
    }
   	
	@FindBy(xpath = "//a[span/@class='lm-icons ico-single-arrow-left']")
	private WebElement previousButton;
	
    public WebElement getPreviousButton() {
        return CommonMethods.clickableElement(previousButton);                
    }
    
	@FindBy(xpath = "//a[span/@class='lm-icons ico-single-arrow-right']")
	private WebElement nextButton;
	
    public WebElement getNextButton() {
        return nextButton;                
    }
    
	@FindBy(xpath = "(//a[span/@class='lm-icons ico-single-arrow-left'])[2]")
	private WebElement previousButtonPerf;
	
    public WebElement getPreviousButtonPerf() {
        return CommonMethods.clickableElement(previousButtonPerf);                
    }
    
	@FindBy(xpath = "(//a[span/@class='lm-icons ico-single-arrow-right'])[2]")
	private WebElement nextButtonPerfTab;
	
    public WebElement getNextButtonPerfTab() {
        return CommonMethods.clickableElement(nextButtonPerfTab);                
    }
     
	@FindBy(xpath = "//li[a/span/@class='lm-icons ico-single-arrow-left']")
	private WebElement previousButtonContainer;
	
    public WebElement getPreviousButtonContainer() throws InterruptedException {
        return CommonMethods.clickableElementWait(previousButtonContainer);                
    }
    
	@FindBy(xpath = "(//li[a/span/@class='lm-icons ico-single-arrow-left'])[2]")
	private WebElement previousButtonContainerPerf;
	
    public WebElement getPreviousButtonContainerPerf() throws InterruptedException {
        return CommonMethods.clickableElementWait(previousButtonContainerPerf);                
    }
    
	@FindBy(xpath = "//li[a/span/@class='lm-icons ico-single-arrow-right']")
	private WebElement nextButtonContainer;
	
    public WebElement getNextButtonContainer() throws InterruptedException {
        return CommonMethods.clickableElementWait(nextButtonContainer);                
    }
    
	@FindBy(xpath = "(//li[a/span/@class='lm-icons ico-single-arrow-right'])[2]")
	private WebElement nextButtonContainerPerf;
	
    public WebElement getNextButtonContainerPerf() throws InterruptedException {
        return CommonMethods.clickableElementWait(nextButtonContainerPerf);                
    }
	   
    public List<WebElement> getPaginationOptions() {
        return  this.driver.findElements(By.xpath("//*[@class='dataTables_length']//option"));
    }
    
    public List<WebElement> getPerfPaginationOptions() {
        return  this.driver.findElements(By.xpath("//*[@id='tab-performance']//option"));
    }
 
	public WebElement getTopPageInfo(String tabName) throws InterruptedException {
        return this.driver.findElement(By.xpath("//*[@id='"+tabName+"']//*[@class='dataTables_info']"));                
    }
	
	@FindBy(xpath = "(//*[@class='dataTables_info'])[2]")
	private WebElement topPageInfoDiscrete;
	   
	public WebElement getTopPageInfoDiscrete() throws InterruptedException {
        return topPageInfoDiscrete;                
    }
	
	/* Watchlist */	
	@FindBy(xpath = "(//*[@data-original-title='Add to Watchlist'])[1]")
    private WebElement addToWatchlistButton;
    
	public WebElement getAddToWatchlistButton() throws InterruptedException {
        return addToWatchlistButton;                
    }
	
    @FindBy(xpath = "//a[@class='watchlist ico-watchlist']")
    private WebElement addToWatchlistBtnDe;
    
	public WebElement getAddToWatchlistBtnDe() throws InterruptedException {
        return addToWatchlistBtnDe;                
    }
	
    @FindBy(xpath = "(//*[contains(@class,'btn btn-toggle ico-watchlist')])[1]")
    private WebElement addToWatchlistPDButton;
    
	public WebElement getAddToWatchlistPDButton() throws InterruptedException {
        return addToWatchlistPDButton;                
    }
	
    @FindBy(
            xpath = "//*[@class='item']//*[@class='title']"
    )
    private WebElement watchlistItemFund;
    
	public WebElement getWatchlistItemFund() throws InterruptedException {
        return watchlistItemFund;                
    }
	
    @FindBy(
            xpath = "//*[@class='item']//*[@class='share-class']"
    )
    private WebElement watchlistShareClass;
    
	public WebElement getWatchlistShareClass() throws InterruptedException {
        return watchlistShareClass;                
    }

    @FindBy(
            xpath = "//*[@class='watchlist-items-none']/p"
    )
    private WebElement watchlistNoItem;
    
	public WebElement getWatchlistNoItem() throws InterruptedException {
        return watchlistNoItem;                
    }

    @FindBy(
            xpath = "//*[text()='View Details']"
    )
    private WebElement viewDetailsButton;
    
	public WebElement getViewDetailsButton() throws InterruptedException {
        return viewDetailsButton;                
    }

	
    @FindBy(xpath = "//*[text()='Clear List']")
    private WebElement clearListButton;
    
	public WebElement getClearListButton() throws InterruptedException {
        return clearListButton;                
    }
	
	@FindBy(xpath = "//*[text()='Details anzeigen']")
    private WebElement viewDetailsButtonDe;
    
	public WebElement getViewDetailsButtonDe() throws InterruptedException {
        return viewDetailsButtonDe;                
    }
	
    @FindBy(xpath = "(//*[contains(text(),'Liste löschen')])[1]")
    private WebElement clearListButtonDe;
    
	public WebElement getClearListButtonDe() throws InterruptedException {
        return clearListButtonDe;                
    }

    @FindBy(xpath = "//*[@class='share-class']")
    private WebElement productShareclass;
    
	public WebElement getProductShareclass() throws InterruptedException {
        return productShareclass;                
    }
	
	
	
	/* Filters */
	@FindBy(xpath = "//*[@id='filterTrigger']")
	private WebElement filterButton;
	
    public WebElement getFilterButton() {
        return CommonMethods.clickableElement(filterButton);
    }     
   
    @FindBy(xpath = "//*[@class='checkbox-group watchlist']//label[@class='custom-control custom-checkbox'][1]")
	private WebElement watchlistFilter;
	
    public WebElement getWatchlistFilter() {
        return CommonMethods.clickableElement(watchlistFilter);
    }    
    
    /* KeyActions */
    
	@FindBy(xpath = "//*[@id='shareTrigger']")
	private WebElement keyActionButton;
	
    public WebElement getKeyActionButton() {
        return CommonMethods.clickableElement(keyActionButton);
    }  
    
	@FindBy(css = "a.print.ico-print")
	private WebElement printLink;
	
    public WebElement getPrintLink() {
        return printLink;
    } 
       
	@FindBy(css = "a.excel.ico-doc-table")
	private WebElement downloadExcelLink;
	
    public WebElement getDownloadExcelLink() {
        return CommonMethods.clickableElement(downloadExcelLink);
    } 
    
	@FindBy(css = "a.social-share.ico-facebook")
	private WebElement facebookLinkPL;
	
    public WebElement getFacebookLinkPL() {
        return facebookLinkPL;
    } 
    
	@FindBy(css = "a.social-share.ico-twitter")
	private WebElement twitterLinkPL;
	
    public WebElement getTwitterLinkPL() {
        return twitterLinkPL;
    } 
    
	@FindBy(css = "a.social-share.ico-linkedin")
	private WebElement linkedInLinkPL;
	
    public WebElement getLinkedInLinkPL() {
        return linkedInLinkPL;
    } 
    
	@FindBy(css = "a.share.ico-email")
	private WebElement emailShareLink;
	
    public WebElement getEmailShare() {
        return emailShareLink;
    }
    
	@FindBy(xpath = "//*[@class='modal-content']//form[@id='shareForm']")
	private WebElement emailModelWindow;
	
    public WebElement getGmailModelWindow() {
        return CommonMethods.clickableElement(emailModelWindow);
    }
    
	@FindBy(xpath = "//input[@id='recipientEmail']")
	private WebElement toEmailInputField;
	
    public WebElement getToEmailInputField() {
        return CommonMethods.clickableElement(toEmailInputField);
    }
    
	@FindBy(xpath = "//input[@id='fromEmail']")
	private WebElement getFromEmailInputField;
	
    public WebElement getFromEmailInputField() {
        return CommonMethods.clickableElement(getFromEmailInputField);
    }
    
	@FindBy(xpath = "//input[@id='subject']")
	private WebElement subjectInputtField;
	
    public WebElement getSubjectInputtField() {
        return CommonMethods.clickableElement(subjectInputtField);
    }

	@FindBy(xpath = "//*[@id='message']")
	private WebElement messageInputField;
	
    public WebElement getMessageInputField() {
        return CommonMethods.clickableElement(messageInputField);
    }
    
	@FindBy(xpath = "(//button[text()='Submit' or @type='submit'])[1]")
	private WebElement submitButton;
	
    public WebElement getSubmitButton() {
        return CommonMethods.clickableElement(submitButton);
    }
    
	@FindBy(xpath = "//*[@id='shareModal']//i[@class='lm-icons ico-close']")
	private WebElement emailCloseButton;
	
    public WebElement getEmailCloseButton() {
        return CommonMethods.clickableElement(emailCloseButton);
    }
  
    
    /* ToolTip */
    
	@FindBy(xpath = "//*[@id='tab-performance']//a[@data-tabname='calendar']")
	private WebElement calendarTab;
	
    public WebElement getCalendarTab() {
        return CommonMethods.clickableElement(calendarTab);
    }
    
	@FindBy(xpath = "//*[@id='tab-performance']//a[@data-tabname='discrete']")
	private WebElement discreteRollingTab;
	
    public WebElement getDiscreteRollingTab() {
        return CommonMethods.clickableElement(discreteRollingTab);
    }
    
	@FindBy(xpath = "//*[@id='tab-performance']//a[@data-tabname='annualized']")
	private WebElement annualisedTab;
	
    public WebElement getAannualisedTab() {
        return CommonMethods.clickableElement(annualisedTab);
    }
    
	@FindBy(xpath = "//*[@id='tab-performance']//a[@data-tabname='cumulative']")
	private WebElement cumulativeTab;
	
    public WebElement getCumulativeTab() {
        return CommonMethods.clickableElement(cumulativeTab);
    }  
    
    public boolean isFilterAreaOpen() throws Exception {
        return this.getFilterButton().getAttribute(CLASS).contains(ACTIVE);
    }
    
    @FindBy(xpath = "(//*[@data-target='#keyActionsModal'])[1]")
    private WebElement keyActionsLink;
    
    public WebElement getKeyActionLink() {
        return CommonMethods.clickableElement(keyActionsLink);
    } 
    
    @FindBy(xpath = "//*[@id='keyActionsModal']//h2")
    private WebElement keyActionsPopupDisplay;
    
    public WebElement getKeyActionsPopupDisplay() throws InterruptedException {
        return CommonMethods.visibleElementWait(keyActionsPopupDisplay);
    }
    
    @FindBy(xpath = "//*[@id='keyActionsModal']//a[1]")
    private WebElement keyActionUrl;
    
    public WebElement getkeyActionLink() throws InterruptedException {
        return CommonMethods.clickableElement(keyActionUrl);        
    }
    
    @FindBy(xpath = "(//i[@class=\"lm-icons ico-close\"])[4]")
    private WebElement keyAcnCloseButton;
    
    public WebElement getKeyAcnCloseButton() throws InterruptedException {
        return CommonMethods.clickableElement(keyAcnCloseButton);        
    }
            
    public WebElement getPerfFundHeader(String tableId) throws InterruptedException {
        return this.driver.findElement(By.xpath("(//*[@id='"+ tableId +"']//th[@data-interaction-detail='Fund Name'])[1]"));        
    }
    
    public WebElement getPerfShareHeader(String tableId) throws InterruptedException {
    	return this.driver.findElement(By.xpath("(//*[@id='"+ tableId +"']//th[@data-interaction-detail='Share Class'])[1]"));       
    }
            
    public WebElement getPerfIncDateHeader(String tableId) throws InterruptedException {
    	return this.driver.findElement(By.xpath("(//*[@id='"+ tableId +"']//th[@data-interaction-detail='Inception Date'])[1]"));        
    }
    
    public List<WebElement> getPerfIncDateData(String tableId) throws InterruptedException {
    	return this.driver.findElements(By.xpath("//*[@id='"+ tableId +"']//td[3]"));        
    }
    
    public List<WebElement> getPerfIncDateDataAU(String tableId) throws InterruptedException {
    	return this.driver.findElements(By.xpath("//*[@id='"+ tableId +"']//td[2]"));        
    }
         
    public WebElement getPerfIsinHeader(String tableId) throws InterruptedException {
    	return this.driver.findElement(By.xpath("(//*[@id='"+ tableId +"']//th[@data-interaction-detail='ISIN'])[1]"));       
    } 
    
    public WebElement getPerfAPIRCodeColumn(String tableId) throws InterruptedException {
    	return this.driver.findElement(By.xpath("(//*[@id='"+ tableId +"']//th[@data-interaction-detail='apirValue'])[1]"));       
    } 
    
    public WebElement getPerfAsOfHeader(String tableId) throws InterruptedException {
    	return this.driver.findElement(By.xpath("(//*[@id='"+ tableId +"']//th[@data-interaction-detail='As of'])[1]"));       
    }
    
    public List<WebElement> getPerfAsOfDateData(String tableId) throws InterruptedException {
    	return this.driver.findElements(By.xpath("(//*[@id='"+tableId+"']//td/span[text()='As of']/parent::td)[1]"));        
    }
    
    public List<WebElement> getPerfAsOfDateDataDe(String tableId) throws InterruptedException {
    	return this.driver.findElements(By.xpath("//*[@id='"+tableId+"']//td[9]"));        
    }    
    
    public List<WebElement> getPerfAsOfDateDataAU(String tableId) throws InterruptedException {
    	return this.driver.findElements(By.xpath("(//*[@id='"+tableId+"']//td/span[text()='As of']/parent::td)[1]"));        
    }
     
    public WebElement getDiscreteYearHeader(String tableId, String year) throws InterruptedException {
    	return this.driver.findElement(By.xpath("(//*[@id='"+ tableId +"']//th[@data-interaction-detail='"+ year +"'])[1]"));       
    }    
    
    @FindBy(xpath = "//div[@class='share-dropdown']//button")
    private WebElement selectedShareClass;
    
    public WebElement getSelectedShareClass() {
        return selectedShareClass;
    }
    
    @FindBy(xpath = "//*[contains(@aria-controls,'shareOptions')]")
    private WebElement selectedSharedClass;
    
    public WebElement getSelectedSharedClass() {
        return selectedShareClass;
    } 
        
	@FindBy(xpath = "(//*[@id='overview-table']/tbody/tr/td[1])[1]")
	private WebElement fundNameLink;
    
   	public WebElement getFundNameLink() throws Exception {
		return fundNameLink;       
    }
   	
	@FindBy(xpath = "(//*[@id='discrete-table']/tbody/tr/td[1]/a)[3]")
	private WebElement fundNameText;

	public WebElement getFundNameText() throws Exception {
		return fundNameText;
	}
			
	@FindBy(xpath = "//li[contains(text(),' At NAV')]")//*[@id='tab-performance']//li[contains(text(),' At NAV')] 
	private WebElement atNAVRow;

	@FindBy(xpath = "//*[@id='tab-performance']//li[contains(text(),' Inclusive of Sales Charge')] ")
	private WebElement inclusiveOfSalesChargeRow;

	public WebElement getAtNAVRow() {
		return atNAVRow;
	}

	public WebElement getInclusiveOfSalesChargeRow() {
		return inclusiveOfSalesChargeRow;
	}
	
	@FindBy(xpath = "//*[@id='ewmac_anchorNav']//a[contains(.,'Authorised')]")
	private WebElement authorisedSection;

	public WebElement getAuthorisedSection() throws Exception {
		return authorisedSection;
	}
	
	@FindBy(xpath = "//*[@id='ewmac_anchorNav']//a[contains(.,'Recognised')]") 
    
    private WebElement recognisedSection;

	public WebElement getRecognisedSection() throws Exception {
		return recognisedSection;
	}
	
	public WebElement getAuthorisedLink(String buttonLink) throws Exception {
		return this.driver.findElement(By.xpath("//a[@class='btn-comp btn '][contains(@href, '"+buttonLink+".html')]"));
	}
	
	@FindBy(xpath = "//a[@class='btn-comp btn '][contains(@href, 'recognised.html')]")
	private WebElement recognisedLink;

	public WebElement getRecognisedLink() throws Exception {
		return recognisedLink;
	}
	
	public WebElement getLink(String linkName) throws Exception {
		return this.driver.findElement(By.xpath("//a[contains(@href, '"+linkName+".html')]"));
	}
	
	public WebElement getSectionName(String sectionName) throws Exception {
		return this.driver.findElement(By.xpath("//*[contains(@id,'anchorNav')]//a[contains(.,'"+sectionName+"')]"));
	}
	
	public WebElement getPaginationNextArrow(String tabName) throws Exception {
		return this.driver.findElement(By.xpath("//*[@id='"+tabName+"']//ul[@class='pagination']/li[contains(@class, 'page-item next')]"));    
    }
	
	public WebElement getFundNamePLPerTab(String fund) throws Exception {
		return this.driver.findElement(By.xpath("//div[@id='tab-performance']//a[text()='"+fund+"']"));    
    }

}
