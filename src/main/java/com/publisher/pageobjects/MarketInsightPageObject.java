package com.publisher.pageobjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.publisher.steps.CommonMethods;

public class MarketInsightPageObject {
	
	private static MarketInsightPageObject market;
	private WebDriver driver;
	
	private MarketInsightPageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static MarketInsightPageObject marketInsightPageObject(WebDriver driver) throws IOException {
		market=null;
		market=new MarketInsightPageObject(driver);
		return market; 
	}
	
	@FindBy(xpath = "//div[contains(@data-desktop-bg,'background-image')]")
	private WebElement marketBanner;
    @FindBy(xpath = "//div[contains(@class,'hero-title')]//h1")
    private WebElement marketBannerTitle;
    @FindBy(xpath = "//*[@class='headline-wrapper fa  ico-none']//h3")
    private WebElement weeklyUpdateHeader;
    @FindBy(xpath = "//*[contains(@href,'chart-of-the-week.html')]")
    private WebElement chartOfWeek;
    @FindBy(xpath = "//*[contains(@href,'mid-week-bond-update.html')]")
    private WebElement midWeekBond;
    @FindBy(xpath = "//*[contains(@href,'weekly-snapshot.html')]")
    private WebElement weeklySnapShot;
    @FindBy(xpath = "//*[@class='headline-wrapper fa  ico-none']//h3[contains(text(),'Blogs')]")
    private WebElement blogHeader;
   	@FindBy(xpath = "//*[contains(@href,'around-the-curve.html')]")
    private WebElement aroundCruve;
   	@FindBy(xpath = "//*[contains(@href,'above-the-noise.html')]")
    private WebElement aboveNoise;
    @FindBy(xpath = "//*[@class='list-filter']//h2[contains(text(),'Browse All')]")
    private WebElement browseHeader;
    @FindBy(xpath = "//*[@id='sortTrigger']")
    private WebElement sortBy;
    @FindBy(xpath = "//*[@data-interaction-label='ascending'][@data-interaction-detail='date']")
    private WebElement ascendingDate;
    @FindBy(xpath = "//*[@data-interaction-label='descending'][@data-interaction-detail='date']")
    private WebElement descendingDate;
    @FindBy(xpath = "//*[@data-interaction-label='ascending'][@data-interaction-detail='title']")
    private WebElement ascendingTitle;
    @FindBy(xpath = "//*[@data-interaction-label='descending'][@data-interaction-detail='title']")
    private WebElement descendingTitle;
    @FindBy(xpath = "//*[contains(@href,'#tab-list')]")
    private WebElement tabList;
    @FindBy(xpath = "//*[contains(@href,'#tab-grid')]")
    private WebElement tabGrid;
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Page')]")
    private WebElement pageList;
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Title')]")
    private WebElement titleList;
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Eyebrow')]")
    private WebElement eyeBrowList;
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Description')]")
    private WebElement descriptionList;
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Date')]")
    private WebElement dateList;
    @FindBy(xpath = "//*[@class='wrapper']//*[contains(@class,'card-header no-headline')]")
    private WebElement gridImg;
    
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Titel')]")
    private WebElement titleListDe;
    
    public WebElement getTitleListDe() {
		return titleListDe;
	}
    
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Thema')]")
    private WebElement eyeBrowListDe;
    
    public WebElement getEyeBrowListDe() {
		return eyeBrowListDe;
	}
    
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Beschreibung')]")
    private WebElement descriptionListDe;
    
    public WebElement getDescriptionListDe() {
		return descriptionListDe;
	}
    
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Datum')]")
    private WebElement dateListDe;
    
    public WebElement getDateListDe() {
		return dateListDe;
	}
    
    @FindBy(xpath="//a[@href='#tab-grid']")
    private WebElement gridViewLink;
    
    @FindBy(xpath = "//div[@id='tab-grid']//*[@class='card-text']//p")
    private WebElement gridEyeBrow;
    @FindBy(xpath = "//div[@id='tab-grid']//*[@class='card-text']//h5")
    private WebElement gridTitle;
    @FindBy(xpath = "//div[@id='tab-grid']//*[@class='card-text']//*[@class='card-text']")
    private WebElement gridDescription;
    @FindBy(xpath = "//div[@id='tab-grid']//*[@class='card-title featured']")
    private WebElement gridFeature;
    @FindBy(xpath = "//*[@class='tab-pane active']//*[@class='grid-total']")
    private WebElement gridTotal;
    @FindBy(xpath = "//*[@class='tab-content']//*[@class='card-grid']")
    private WebElement gridArticals;
    @FindBy(xpath = "//*[@class='tab-content']//*[@class='card-grid']//a")
    private WebElement gridTileLink;
    @FindBy(xpath = "//div[@id='tab-list']//tbody//a")
    private WebElement listTileLink;
    @FindBy(xpath = "//*[@id='filterTriggerTeasers']")
    private WebElement filterIcon;
    @FindBy(xpath = "//*[@id='closeFilterTeasers']")
    private WebElement filterCloseButton;
    @FindBy(xpath = "//*[@class='clear-filter']")
    private WebElement clearFilterButton;
    @FindBy(xpath = "//*[@class='filter-selections-page']")
    private WebElement filterSelectionTiles;
    @FindBy(xpath = "//*[@class='number-bubble']")
    private WebElement filterNumberBubble;
    @FindBy(xpath = "//*[@class='inner expanded']//*[contains(text(),'Affiliate')]")
    private WebElement affliateSection;
    @FindBy(xpath = "//*[@class='inner expanded']//*[contains(text(),'Featured')]")
    private WebElement featuredSection;
    @FindBy(xpath = "//*[@class='inner expanded']//*[contains(text(),'Content Type')]")
    private WebElement contentTypeSection;
    @FindBy(xpath = "//*[@id=\"filterMenuTeasers\"]/div/div/fieldset[1]/div/label[1]")
    private WebElement affliateCheckCB;
    @FindBy(xpath = "//*[@id=\"filterMenuTeasers\"]/div/div/fieldset[1]/div/label[2]")
    private WebElement affliateCheckLM;
    @FindBy(xpath = "//*[@id=\"filterMenuTeasers\"]/div/div/fieldset[2]/div/label[1]")
    private WebElement contentTypeCheckPR;
    @FindBy(xpath = "//*[@id=\"filterMenuTeasers\"]/div/div/fieldset[2]/div/label[2]")
    private WebElement contentTypeCheckPE;
    @FindBy(xpath = "//*[@id=\"filterMenuTeasers\"]/div/div/fieldset[3]/div/label")
    private WebElement featuredCheck;
    
    @FindBy(xpath = "//fieldset[@data-sequence-type='affiliate']")
    private WebElement filterAffSectionDe;
    
    @FindBy(xpath = "//fieldset[@data-sequence-type='featured']")
    private WebElement filterFeaturedSectionDe;
    
    @FindBy(xpath = "//fieldset[@data-sequence-type='content-type']")
    private WebElement filterContTypeSectionDe;
    
    public WebElement getFilterContTypeSectionDe() {
		return filterContTypeSectionDe;
	}
    
    public WebElement getFilterFeaturedSectionDe() {
		return filterFeaturedSectionDe;
	}
    
    public WebElement getFilterAffSectionDe() {
		return filterAffSectionDe;
	}
    
	public WebElement getAffliateSection() throws Exception {
		return CommonMethods.visibleElementWait(affliateSection);
	}
	public WebElement getFeaturedSection() throws Exception {
		return CommonMethods.visibleElementWait(featuredSection);
	}
	public WebElement getContentTypeSection() throws Exception {
		return CommonMethods.visibleElementWait(contentTypeSection);
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
	public WebElement getAffliateCB() throws Exception {
		return CommonMethods.clickableElementWait(affliateCheckCB);
	}
	public WebElement getAffliateLM() throws Exception {
		return CommonMethods.clickableElementWait(affliateCheckLM);
	}
	public WebElement getContentPro() throws Exception {
		return CommonMethods.clickableElementWait(contentTypeCheckPR);
	}
	public WebElement getContentPers() throws Exception {
		return CommonMethods.clickableElementWait(contentTypeCheckPR);
	}
	public WebElement getFeature() throws Exception {
		return CommonMethods.clickableElementWait(featuredCheck);
	}
	public WebElement getBlogHeader() {
		return blogHeader;
	}
	public WebElement getBrowserHeader() {
		return browseHeader;
	}
	public WebElement getWeeklyUpdateHeader() {
		return weeklyUpdateHeader;
	}
	public WebElement getGridTotal() throws Exception {
		return CommonMethods.visibleElementWait(gridTotal);
	}
	public WebElement getPageList() throws Exception {
		return CommonMethods.visibleElementWait(pageList);
	}
	public WebElement getTitleList() throws Exception {
		return CommonMethods.visibleElementWait(titleList);
	}
	public WebElement getEyebrowList() throws Exception {
		return CommonMethods.visibleElementWait(eyeBrowList);
	}
	public WebElement getDescriptionList() throws Exception {
		return CommonMethods.visibleElementWait(descriptionList);
	}
	public WebElement getDateList() throws Exception {
		return CommonMethods.visibleElementWait(dateList);
	}
	public WebElement getMarketBannerTitle() throws Exception {
		return CommonMethods.visibleElementWait(marketBannerTitle);
	}
	public WebElement getTabList() throws Exception {
		return CommonMethods.clickableElementWait(tabList);
	}
	public WebElement getTabGrid() throws Exception {
		return CommonMethods.clickableElementWait(tabGrid);
	}
	public WebElement getFilterIcon() throws Exception {
		return CommonMethods.clickableElementWait(filterIcon);
	}
	public WebElement getMarketBannerImg() throws Exception {
		return CommonMethods.visibleElementWait(marketBanner);
	}
	public WebElement getChartofTheWeek() throws Exception {
		return CommonMethods.clickableElementWait(chartOfWeek);
	}
	public WebElement getMidWeekBondUpdate() throws Exception {
		return CommonMethods.clickableElementWait(midWeekBond);
	}
	public WebElement getWeeklySnapsHot() throws Exception {
		return CommonMethods.clickableElementWait(weeklySnapShot);
	}
	public WebElement getAroundTheCurve() throws Exception {
		return CommonMethods.clickableElementWait(aroundCruve);
	}
	public WebElement getAboveTheNoise() throws Exception {
		return CommonMethods.clickableElementWait(aboveNoise);
	}
	public WebElement getSortBy() throws Exception {
		return CommonMethods.clickableElementWait(sortBy);
	}
	public WebElement getFilterButton() throws Exception {
		return CommonMethods.clickableElementWait(filterIcon);
	}
	public WebElement getFilterCloseButton() throws Exception {
		return CommonMethods.clickableElementWait(filterCloseButton);
	}
	public WebElement getAcendingDate() throws Exception {
		return CommonMethods.clickableElementWait(ascendingDate);
	}
	public WebElement getDscendingDate() throws Exception {
		return CommonMethods.clickableElementWait(descendingDate);
	}
	public WebElement getAcendingTitle() throws Exception {
		return CommonMethods.clickableElementWait(ascendingTitle);
	}
	public WebElement getDscendingTitle() throws Exception {
		return CommonMethods.clickableElementWait(descendingTitle);
	}
	public WebElement getListTileLink() throws Exception {
		return CommonMethods.clickableElementWait(listTileLink);
	}
	public WebElement getGridTileLinks() throws Exception {
		return CommonMethods.clickableElementWait(gridTileLink);
	}
	public WebElement getGridImgLink() throws Exception {
		return CommonMethods.clickableElementWait(gridImg);
	}
	
	public WebElement getGridViewLink() throws Exception {
		return CommonMethods.clickableElementWait(gridViewLink);
	}	
	
	public WebElement getGridEyeBrowLink() throws Exception {
		return CommonMethods.clickableElementWait(gridEyeBrow);
	}
	public WebElement getGridDescriptionLink() throws Exception {
		return CommonMethods.clickableElementWait(gridDescription);
	}
	public WebElement getGridTitleLinks() throws Exception {
		return CommonMethods.clickableElementWait(gridTitle);
	}
	public WebElement getGridFeature() throws Exception {
		return CommonMethods.clickableElementWait(gridFeature);
	}
	
	public List<WebElement> getHideDate() throws Exception {
		return driver.findElements(By.xpath("//*[contains(@class, 'teasers-wrapper hide-date')]"));
	}
	
	@FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Titre')]")
    private WebElement titleListFR;
	
	public WebElement getTitleListFR() {
		return titleListFR;
	}
	
	@FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Thèmatique')]")
    private WebElement eyeBrowListFR;
    
    public WebElement getEyeBrowListFR() {
		return eyeBrowListFR;
	}
    
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Description')]")
    private WebElement descriptionListFR;
    
    public WebElement getDescriptionListFR() {
		return descriptionListFR;
	}
    
    @FindBy(xpath = "//div[@id='tab-list']//table//span[contains(text(),'Date')]")
    private WebElement dateListFR;
    
    public WebElement getDateListFR() {
		return dateListFR;
	}
}
