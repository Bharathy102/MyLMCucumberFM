package com.publisher.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.publisher.steps.CommonMethods;


public class SearchPageObject {

	static SearchPageObject search;
	private WebDriver driver;
	
	private SearchPageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static SearchPageObject searchPageObject(WebDriver driver) throws IOException {
		search=null;
		search=new SearchPageObject(driver);
		return search; 
	}

	@FindBy(xpath = "//*[@id='desktopSearchTrigger']")
	private WebElement globalsearchicon;

	public WebElement getGlobalsearchicon() {
		return globalsearchicon;

	}

	@FindBy(xpath = "//*[@id='desktopSearch']/div/input")
	private WebElement globalsearchinput;

	public WebElement getGlobalsearchinput() {
		return globalsearchinput;

	}
	
	@FindBy(xpath = "//a[@href='#tab-resources']/span")
	private WebElement resoruceTabresultsCount;

	public WebElement getresoruceTabresultsCount() {
		return resoruceTabresultsCount;

	}

	@FindBy(xpath = "//*[@id='tab-search-results']")
	private WebElement entrustSearchresult;

	public WebElement getEntrustSearchresult() {
		return entrustSearchresult;

	}

	@FindBy(xpath = "//*[contains(@data-interaction-label,'entrust')]")
	private WebElement entrustPermalSearchresult;

	public WebElement getEntrustPermalSearchresult() {
		return entrustPermalSearchresult;

	}
	@FindBy(xpath = "//div[@class='fund-codes fund-codes-pfcnt']//tr[4]//td[2]")
	private WebElement sedolValue;

	public WebElement getSedolValue() {
		return sedolValue;
	}
	@FindBy(xpath = "//div[@class='fund-codes fund-codes-pfcnt']//tr[3]//td[2]")
	private WebElement sedoValue;

	public WebElement getSedoValue() {
		return sedoValue;
	}
	//div[@class='fund-codes fund-codes-pfcnt']//tr[3]//td[2]
	@FindBy(xpath = "//div[@class='fund-codes fund-codes-pfcnt']//td[2]")
	private WebElement iSINlValue;

	public WebElement getISINlValue() {
		return iSINlValue;

	}
	
	

	@FindBy(xpath = "//*[@id=\"desktopSearch\"]/div/div/a")
	private WebElement advancedGlobalSearch;

	public WebElement getAdvancedGlobalSearch() {
		return advancedGlobalSearch;
	}
	
	@FindBy(xpath = "//*[@id='desktopSearch']//a[contains(text(),'Advanced')]")
	private WebElement searchAdvancedTab;

	public WebElement getSearchAdvancedTab() {
		return searchAdvancedTab;

	}
	@FindBy(xpath = "//*[contains(@href,'#tab-all')]")
	private WebElement tabAll;

	public WebElement getTabAll() {
		return tabAll;
	}

	@FindBy(xpath = "//*[@class='tab-pane active']//a")
	private WebElement isinProducts;

	public WebElement getISINProducts() {
		return isinProducts;
	}
	@FindBy(xpath = "//*[@class='tab-pane active']//h3")
	private WebElement noISINProducts;

	public WebElement getNOISINProducts() {
		return noISINProducts;
	}
	
	@FindBy(xpath = "//*[@class='lm-icons ico-single-arrow-right']")
	private WebElement nextButton;

	public WebElement getNextButton() {
		return nextButton;

	}

	@FindBy(xpath = "//*[@class='lm-icons ico-single-arrow-left']")
	private WebElement previousButton;

	public WebElement getPreviousButton() {
		return previousButton;

	}

	public List<WebElement> getSearchPaginationOptions() {
		return this.driver.findElements(By.xpath("//*[@class='per-page']//option"));
	}
	
	@FindBy(xpath = "//*[@class='no-results-header']")
	private WebElement noResultSearch;

	public WebElement getNoResultSearch() {
		return noResultSearch;

	}
	
	
	@FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[1]/legend")
	private WebElement affiliateFilter;

	public WebElement getAffiliateFilter() {
		return affiliateFilter;

	}
	
	
	@FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[2]/legend")
	private WebElement assetClassFilter;

	public WebElement getAssetClassFilter() {
		return assetClassFilter;

	}
	
	
	@FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[3]/legend")
	private WebElement productTypeFilter;

	public WebElement getProductTypeFilter() {
		return productTypeFilter;

	}
	
	@FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[4]/legend")
	private WebElement perspectiveTypeFilter;

	public WebElement getPerspectiveTypeFilter() {
		return perspectiveTypeFilter;

	}
	
	
	@FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[5]/legend")
	private WebElement documentTypeFilter;

	public WebElement getDocumentTypeFilter() {
		return documentTypeFilter;

	}

	
	@FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[6]/legend")
	private WebElement mostRecentFilter;

	public WebElement getMostRecentFilter() {
		return mostRecentFilter;

	}
	
	@FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[1]/div/label[1]")
	private WebElement firstCheckboxAffiliate;

	public WebElement getFirstCheckboxAffiliate() {
		return firstCheckboxAffiliate;

	}
	
	
	@FindBy(xpath = "//*[@id='tab-all']//*[@class='no-results-header']/h3")
	private WebElement noResultfoundMessageAllTab;

	public WebElement getNoResultfoundMessageAllTab() {
		return noResultfoundMessageAllTab;

	}
	
	@FindBy(xpath = "//*[@id='tab-products']//*[@class='no-results-header']/h3")
	private WebElement noResultfoundMessageProductTab;

	public WebElement getNoResultfoundMessageProductTab() {
		return noResultfoundMessageProductTab;

	}
	
	@FindBy(xpath = "//*[@id='tab-resources']//*[@class='no-results-header']/h3")
	private WebElement noResultfoundMessageResourcesTab;

	public WebElement getNoResultfoundMessageResourcesTab() {
		return noResultfoundMessageResourcesTab;

	}
	
	
	@FindBy(xpath = "//*[@id='tab-perspectives']//*[@class='no-results-header']/h3")
	private WebElement noResultfoundMessagePerspectiveTab;

	public WebElement getNoResultfoundMessagePerspectiveTAb() {
		return noResultfoundMessagePerspectiveTab;

	}
	
	@FindBy(xpath = "//*[@href='#tab-all']")
	private WebElement allTabSearchResult;

	public WebElement getAllTabSearchResult() {
		return allTabSearchResult;
	}
	
	@FindBy(xpath = "//*[@href='#tab-products']")
	private WebElement productsTabSearchResult;

	public WebElement getProductsTabSearchResult() {
		return productsTabSearchResult;
	}
	
	@FindBy(xpath = "//*[@href='#tab-resources']")
	private WebElement resourcesTabSearchResult;

	public WebElement getResourcesTabSearchResult() {
		return resourcesTabSearchResult;
	
	}	
	
	
	@FindBy(xpath = "//*[@href='#tab-perspectives']")
	private WebElement perspectivesTabSearchResult;

	public WebElement getPerspectivesTabSearchResult() {
		return perspectivesTabSearchResult;
	
	}	
	
	@FindBy(xpath = "//*[@class='ico-close']")
	private WebElement searchClear;

	public WebElement getSearchClear() {
		return searchClear;
	
	}	
	
	
	@FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[2]/div/label[2]")
	private WebElement secondCheckboxAssetClass;

	public WebElement getSecondCheckboxAssetClass() {
		return secondCheckboxAssetClass;
	
	}	
	
	@FindBy(xpath = "//*[@class='clear-filter']")
	private WebElement clearFilterSearchs;

	public WebElement getclearFilterSearchs() {
		return clearFilterSearchs;
	
	}	
	
	
	@FindBy(xpath = "//*[@class='result-title']//*[@data-interaction-location='listing']")
	private WebElement searchResults;

	public WebElement getSearchResults() {
		return searchResults;
	
	}	
	
	
	
	@FindBy(xpath = "//*[@id=\"pnlqc_0\"]/div/div[1]/div/h4")
	private WebElement performanceSearchResultPage;

	public WebElement getPerformanceSearchResultPage() {
		return performanceSearchResultPage;
	
	}	
	
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/div/div[3]/ul/li[3]/a")
	private WebElement resourceTabSearch;

	public WebElement getResourceTabSearch() {
		return resourceTabSearch;
	
	}
	
	 @FindBy(xpath = "//*[@id='filterTriggerSearch']")
	    private WebElement filterIcon;
	    @FindBy(xpath = "//*[@id='closeFilterSearch']")
	    private WebElement filterCloseButton;
	    public WebElement getfilterCloseButton() {
			return filterCloseButton;
		
		}
	    @FindBy(xpath = "//*[@class='clear-filter']")
	    private WebElement clearFilterButton;
	    @FindBy(xpath = "//*[@class='filter-selections-page']")
	    private WebElement filterSelectionTiles;
	    @FindBy(xpath = "//*[@class='number-bubble']")
	    private WebElement filterNumberBubble;
	    @FindBy(xpath = "//*[@class='inner expanded']//*[contains(text(),'Affiliate')]")
	    private WebElement affliateSection;
	    @FindBy(xpath = "//*[@class='inner expanded']//*[contains(text(),'Perspective Type')]")
	    private WebElement perspectiveSection;
	    @FindBy(xpath = "//*[@class='inner expanded']//*[contains(text(),'Most Recent')]")
	    private WebElement mostrecentSection;
	    @FindBy(xpath = "//*[@class='inner expanded']//*[contains(text(),'Asset Class')]")
	    private WebElement assetClassSection;
	    @FindBy(xpath = "//*[@class='inner expanded']//*[contains(text(),'Document Type')]")
	    private WebElement documentTypeSection;
	    @FindBy(xpath = "//*[@class='inner expanded']//*[contains(text(),'Product Type')]")
	    private WebElement productTypeSection;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[1]/div/label[1]")
	    private WebElement affliateCheckBWG;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[1]/div/label[2]")
	    private WebElement affliateCheckCBI;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[1]/div/label[3]")
	    private WebElement affliateCheckLM;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[1]/div/label[4]")
	    private WebElement affliateCheckMC;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[1]/div/label[5]")
	    private WebElement affliateCheckQSI;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[1]/div/label[6]")
	    private WebElement affliateCheckWA;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[2]/div/label[1]")
	    private WebElement assetClassCheckFI;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[2]/div/label[2]")
	    private WebElement assetClassCheckMF;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[3]/div/label")
	    private WebElement productTypeCheckMFG;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[4]/div/label[1]")
	    private WebElement perspectiveTypeCheckB;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[4]/div/label[2]")
	    private WebElement perspectiveTypeChecCOW;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[4]/div/label[3]")
	    private WebElement perspectiveTypeChecCOM;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[5]/div/label[1]")
	    private WebElement documentTypeCheckFactSheet;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[5]/div/label[2]")
	    private WebElement documentTypeCheckAnnualReport;
	    @FindBy(xpath = "//*[@id=\"filterMenuSearchResults\"]/div/div/fieldset[6]/div/label[1]")
	    private WebElement mostRecentCheckMost;
	    
		public WebElement getAffliateSection() throws Exception {
			return CommonMethods.visibleElementWait(affliateSection);
		}
		public WebElement getPerspectiveSection() throws Exception {
			return CommonMethods.visibleElementWait(perspectiveSection);
		}
		public WebElement getMostRecentSection() throws Exception {
			return CommonMethods.visibleElementWait(mostrecentSection);
		}
		public WebElement getAssetClasseSection() throws Exception {
			return CommonMethods.visibleElementWait(assetClassSection);
		}
		public WebElement getDocumentTypeSection() throws Exception {
			return CommonMethods.visibleElementWait(documentTypeSection);
		}
		public WebElement getProductTypeSection() throws Exception {
			return CommonMethods.visibleElementWait(productTypeSection);
		}
		public WebElement getClearFilter() throws Exception {
			return CommonMethods.clickableElementWait(clearFilterButton);
		}
		public WebElement getSelectedFilters() throws Exception {
			return CommonMethods.clickableElementWait(filterSelectionTiles);
		}
		public WebElement getSelectedBubleNo() throws Exception {
			return CommonMethods.clickableElementWait(filterNumberBubble);
		}
		
		public WebElement getAffliateBWG() throws Exception {
			return CommonMethods.clickableElementWait(affliateCheckBWG);
		}
		public WebElement getAffliateCBI() throws Exception {
			return CommonMethods.clickableElementWait(affliateCheckCBI);
		}
		public WebElement getAffliateLM() throws Exception {
			return CommonMethods.clickableElementWait(affliateCheckLM);
		}
		public WebElement getAffliateMC() throws Exception {
			return CommonMethods.clickableElementWait(affliateCheckMC);
		}
		public WebElement getAffliateQAI() throws Exception {
			return CommonMethods.clickableElementWait(affliateCheckQSI);
		}
		public WebElement getAffliateWA() throws Exception {
			return CommonMethods.clickableElementWait(affliateCheckWA);
		}
		public WebElement getAssetClassFI() throws Exception {
			return CommonMethods.clickableElementWait(assetClassCheckFI);
		}
		public WebElement getAssetClassMF() throws Exception {
			return CommonMethods.clickableElementWait(assetClassCheckMF);
		}
		public WebElement getPerspectiveMFG() throws Exception {
			return CommonMethods.clickableElementWait(productTypeCheckMFG);
		}
		public WebElement getPerspectiveBlog() throws Exception {
			return CommonMethods.clickableElementWait(perspectiveTypeCheckB);
		}
		public WebElement getPerspectiveCOW() throws Exception {
			return CommonMethods.clickableElementWait(perspectiveTypeChecCOW);
		}
		public WebElement getPerspectiveCOM() throws Exception {
			return CommonMethods.clickableElementWait(perspectiveTypeChecCOM);
		}
		public WebElement getDocumentFactSheet() throws Exception {
			return CommonMethods.clickableElementWait(documentTypeCheckFactSheet);
		}
		public WebElement getDocumentAnnual() throws Exception {
			return CommonMethods.clickableElementWait(documentTypeCheckAnnualReport);
		}
		public WebElement getMostRecent() throws Exception {
			return CommonMethods.clickableElementWait(mostRecentCheckMost);
		}

		public WebElement getFilterOptions(String option) throws Exception {
			return this.driver.findElement(By.xpath("//div[@id='filterMenuSearchResults']//legend[contains(text(),'"+option+"')]"));
		}
		
		public WebElement getAffiliateOptions(String option) throws Exception {
			return this.driver.findElement(By.xpath("//div[@id='affiliateFactGroup']//input[@value='"+option+"']//ancestor::label"));
		}
		

		public WebElement getAssetClassOptions(String option) throws Exception {
			return this.driver.findElement(By.xpath("//div[@id='assetClass']//input[@value='"+option+"']//ancestor::label"));
		}
		
		public WebElement getProductTypeOptions(String option) throws Exception {
			return this.driver.findElement(By.xpath("//div[@id='productType']//input[@value='"+option+"']//ancestor::label"));
		}
		
		public WebElement getPerspectiveTypeOptions(String option) throws Exception {
			return this.driver.findElement(By.xpath("//div[@id='perspectiveType']//input[@value='"+option+"']//ancestor::label"));
		}
		
		public WebElement getDocumentTypeOptions(String option) throws Exception {
			return this.driver.findElement(By.xpath("//div[@id='documentType']//input[@value='"+option+"']"));
		}
		
		public WebElement getMostRecentOptions(String option) throws Exception {
			return this.driver.findElement(By.xpath("//div[@id='mostRecent']//input[@data-interaction-label='"+option+"']//ancestor::label"));
		}
}
		
