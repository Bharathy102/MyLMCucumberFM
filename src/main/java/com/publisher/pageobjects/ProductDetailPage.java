package com.publisher.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.publisher.steps.CommonMethods;

public class ProductDetailPage {
	
	private static ProductDetailPage pdetail;
	private WebDriver driver;

	
	private ProductDetailPage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static ProductDetailPage productDetailPage(WebDriver driver) throws IOException {
		pdetail=null;
		pdetail=new ProductDetailPage(driver);
			return pdetail; 
	}
	
	
	public static final String CLASS = "class";
    public static final String ACTIVE = "active";
	
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Performance')]")
    private WebElement performanceTab;
    
    @FindBy(xpath = "//a[contains(.,'Discrete') or contains(.,'Rolling')]")
    private WebElement rollingTab;
    
    @FindBy(xpath = "//a[contains(.,'Angaben zu einzelnen Jahren')]")
    private WebElement rollingTabDe;

    public WebElement getRollingTabDe() {
		return rollingTabDe;
	}

    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Characteristics')]")
    private WebElement characteristicsTab;
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Eigenschaften')]")
    private WebElement characteristicsTabDe;
    
    public WebElement getCharacteristicsTabDe() {
		return characteristicsTabDe;
	}

    @FindBy(xpath = "//a[@href='#rxyxv_0']")
    private WebElement annualDiscreteTab;

    @FindBy(xpath = "//a[contains(.,'Annualised') or contains(.,'Annualized')]")
    private WebElement annualizedTab;
    
    @FindBy(xpath = "//a[contains(.,' 累积表现')]")
    private WebElement cummulativeTabch;
    
    public WebElement getcummulativeTabch() {
		return cummulativeTabch;
	}
    
    @FindBy(xpath = "//a[contains(text(),'基金表現')]")
    private WebElement performanceTabch;
    
    public WebElement getperformanceTabch() {
		return performanceTabch;
	}
    
    @FindBy(xpath = "//a[contains(.,'年化表现')]")
    private WebElement annulaisedTabch;
    
    public WebElement getannulaisedTabch() {
		return annulaisedTabch;
	}
    
    @FindBy(xpath = "//a[contains(.,'历年表现')]")
    private WebElement calendarTabch;
    
    public WebElement getcalendarTabch() {
		return calendarTabch;
	}
    
    @FindBy(xpath = "//a[contains(.,'Annualisiert')]")
    private WebElement annualizedTabDe;
    
    public WebElement getAnnualizedTabDe() {
		return annualizedTabDe;
	}

    @FindBy(xpath = "//a[contains(.,'Calendar')]")
    private WebElement calendarTab;
    
    @FindBy(xpath = "//a[contains(.,'Kalenderjahr')]")
    private WebElement calendarTabDe;
    
    public WebElement getCalendarTabDe() {
		return calendarTabDe;
    }

    @FindBy(xpath = "//a[contains(.,'Cumulative')]")
    private WebElement cumulativeTab;
    
    @FindBy(xpath = "//a[contains(.,'Kumuliert')]")
    private WebElement cumulativeTabDe;
    
    public WebElement getCumulativeTabDe() {
		return cumulativeTabDe;
	}

    @FindBy(xpath = "//a[@href='#ymwek_0']")
    private WebElement sectorTab;

    @FindBy(xpath = "//a[@href='#ymwek_1']")
    private WebElement marketCapTab;

    @FindBy(xpath = "//a[@href='#ymwek_2']")
    private WebElement countryTab;
    
    @FindBy(xpath = "//a[@href='#ymwek_3']")
    private WebElement assetTab;
    
    public WebElement getPerformanceTab() {
        return CommonMethods.clickableElement(performanceTab);
    }
    
    public WebElement getRollingTab() {
        return CommonMethods.clickableElement(rollingTab);
    }
    
    @FindBy(xpath = "//*[contains(@class,'annual-discrete')]")
    private WebElement rollingComponent;
    
    public WebElement getRollingComponent() {
        return CommonMethods.clickableElement(rollingComponent);
    }
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Literature') or contains(text(),'Literatur')]")
    private WebElement literatureTab;
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Literatur')]")
    private WebElement literatureTabDe;
    
    public WebElement getLiteratureTabDe() {
		return literatureTabDe;
	}
    
    public WebElement getLiteratureTab() {
        return CommonMethods.clickableElement(literatureTab);
    }
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Managers') or contains(text(),'Fondsmanager')]")
    private WebElement managerTab;
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Fondsmanager')]")
    private WebElement managerTabDe;
    
    public WebElement getManagerTabDe() {
		return managerTabDe;
	}
    
    public WebElement getManagerTab() {
        return CommonMethods.clickableElement(managerTab);
    }
    
    @FindBy(xpath = "//a[@href='#pnlqc_4']")
    private WebElement investmentRiskTab;
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Risikohinweise')]")
    private WebElement investmentRiskTabDe;
    
    public WebElement getInvestmentRiskTabDe() {
		return investmentRiskTabDe;
	}
    
    public WebElement getInvestmentRiskTab() {
        return CommonMethods.clickableElement(investmentRiskTab);
    }
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Holdings') or contains(text(),'Positionen')]")
    private WebElement holdingsTab;
    
    public WebElement getHoldingsTab() {
        return CommonMethods.clickableElement(holdingsTab);
    }
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Positionen')]")
    private WebElement holdingsTabDe;
    
    public WebElement getHoldingsTabDe() {
		return holdingsTabDe;
	}
    
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(.,'Distributions')]")
    private WebElement distributionsTab;
    
    public WebElement getDistributionsTab() {
        return CommonMethods.clickableElement(distributionsTab);
    }
       
    @FindBy(xpath = "//*[@id='pnlqc_anchorNav']//a[contains(text(),'Ausschüttungen')]")
    private WebElement distributionsTabDe;
    
    public WebElement getDistributionsTabDe() {
		return distributionsTabDe;
	}
    
    //@FindBy(xpath = "//div[@class='annual-discrete annual-discrete-mjela']//h4")
    @FindBy(xpath = "//*[contains(@class,'annual-discrete')]//h4")
    
    private WebElement rollingComponentHeader;
    
    public WebElement getRollingComponentHeader() {
        return CommonMethods.clickableElement(rollingComponentHeader);
    }
    
    @FindBy(xpath = "//div[@class='cumulative-performance cumulative-performance-jewqu']")
    private WebElement cumulativePerfComponent;
    
    public WebElement getCumulativePerfComponent(String tableId) {
        return driver.findElement(By.xpath("//div[contains(@class,'"+tableId+"')]"));
    }
    
    @FindBy(xpath = "//div[@class='cumulative-performance cumulative-performance-jewqu']//h4")
    private WebElement cumulativeComponentHeader;
    
    public WebElement getCumulativeComponentHeader() {
        return CommonMethods.clickableElement(cumulativeComponentHeader);
    }
    
    @FindBy(xpath = "//div[@class='calendar-performance calendar-performance-kjuip']")
    private WebElement calendarPerfComponent;
    
    public WebElement getCalendarPerfComponent() {
        return CommonMethods.clickableElement(calendarPerfComponent);
    }
    
    @FindBy(xpath = "//div[@class='calendar-performance calendar-performance-kjuip']//h4")
    private WebElement calendarComponentHeader;
    
    public WebElement getCalendarComponentHeader() {
        return CommonMethods.clickableElement(calendarComponentHeader);
    }
    
    @FindBy(xpath = "//div[contains(@class,'annualised-performance annualised-performance-byeny')]")
    private WebElement annualisedComponent;
    
    public WebElement getAnnualisedPerfComponent() {
        return CommonMethods.clickableElement(annualisedComponent);
    }
    
    @FindBy(xpath = "//div[contains(@class,'annualised-performance annualised-performance-byeny')]//h4")
    private WebElement annualisedComponentHeader;
    
    public WebElement getAnnualisedComponentHeader() {
        return CommonMethods.clickableElement(annualisedComponentHeader);
    }
    
    @FindBy(xpath = "//div[contains(@class,'annualised-performance annualised-performance-byeny')]//span[2]")
    private WebElement annualisedAsofDate;
    
    public WebElement getAnnualisedAsOfDate() {
        return annualisedAsofDate;
    }
    
    public WebElement getAsOfDate(String tableClass) {
        return driver.findElement(By.xpath("(//div[contains(@class,'"+tableClass+"')]//span[2])[1]"));
    }
    
    @FindBy(xpath = "//button[@data-target='#moreActions_nlcrx']")
    private WebElement moreActionButton;
    
    public WebElement getMoreActionButton() {
        return CommonMethods.clickableElement(moreActionButton);
    }
        
	@FindBy(css = "a.ico-print")
	private WebElement pdPrintLink;
	
    public WebElement getPDPrintLink() {
        return pdPrintLink;
    } 
    
	@FindBy(css = "a.ico-email")
	private WebElement pdEmailShareLink;
	
    public WebElement getPDEmailShare() {
        return pdEmailShareLink;
    }
    
    @FindBy(xpath = "//div[@id='global-nav']//select[@id='role-selector']")
	private WebElement userRoleSelectMenu;
	
    public WebElement getUserRoleSelectMenu() {
        return userRoleSelectMenu;
    }
    
  	@FindBy(xpath = "//div[@id='global-nav']/select/option")
	private List <WebElement> userRoleSelectOptions;
	
    public List <WebElement> getUserRoleSelectOptions() {
        return userRoleSelectOptions;
    }
    
  	@FindBy(xpath = "(//*[@class='share-selector']//*[@class='share-dropdown']/button)[1]")
	private WebElement pdShareClassName;
	
    public WebElement getPdShareClassname() {
        return pdShareClassName;
    }
    
  	@FindBy(xpath = "//*[@class='col-12 footer-static-content']")
	private WebElement footerDisclosure;
	
    public WebElement getFooterDisclosure() {
        return footerDisclosure;
    }   
    
  	@FindBy(xpath = "//*[@class='disclosure parbase']")
	private WebElement productDisclosure;
	
    public WebElement getProductDisclosure() {
        return productDisclosure;
    }  
    
  	@FindBy(xpath = "//*[@class='disclosure parbase']//*[@class='disclosure-div disclosure-text-']")
	private WebElement productDisclosureText;
	
    public WebElement getProductDisclosureText() {
        return productDisclosureText;
    }  
    
  	@FindBy(xpath = "//*[@class='daily-statistics']/p[@class='primary-id']/span[1]")
	private WebElement isinLabel;
	
    public WebElement getIsinLabel() {
        return isinLabel;
    }  
  
  	@FindBy(xpath = "//*[@class='daily-statistics']/p[@class='primary-id']/span[2]")
	private WebElement isinValue;
	
    public WebElement getIsinValue() {
        return isinValue;
    }  
    
  	@FindBy(xpath = "//*[@class='daily-statistics']/p[@class='inception-date']/span[1]")
	private WebElement inceptionDateLabel;
	
    public WebElement getInceptionDateLabel() {
        return inceptionDateLabel;
    } 
    
  	@FindBy(xpath = "//*[@class='daily-statistics']/p[@class='inception-date']/span[2]")
	private WebElement inceptionDateValue;
	
    public WebElement getInceptionDateValue() {
        return inceptionDateValue;
    } 
    
  	@FindBy(xpath = "//*[@class='daily-statistics']/p[@class='aum']/span[1]")
	private WebElement aumLabel;
	
    public WebElement getAumLabel() {
        return aumLabel;
    }
    
  	@FindBy(xpath = "//*[@class='daily-statistics']/p[@class='aum']/span[2]")
	private WebElement aumDate;
	
    public WebElement getAumDate() {
        return aumDate;
    }
    
  	@FindBy(xpath = "//*[@class='daily-statistics']/p[@class='aum']/span[3]")
	private WebElement aumValue;
	
    public WebElement getAumValue() {
        return aumValue;
    }
    
  	@FindBy(xpath = "(//*[@id='overview-table']/tbody/tr/td[1]/a)[21]")
	private WebElement fundNamePl;
	
    public WebElement getFundNamePl() {
        return fundNamePl;
    }
    
  	@FindBy(xpath = "(//*[@id='overview-table']/tbody/tr/td[2])[21]")
	private WebElement shareClassPl;
	
    public WebElement getShareClassPl() {
        return shareClassPl;
    }
    
  	@FindBy(xpath = "(//*[@id='overview-table']/tbody/tr/td[4])[21]")
	private WebElement assetTypePl;
	
    public WebElement getAssetTypePl() {
        return assetTypePl;
    }
    
	@FindBy(xpath = "(//*[@id='overview-table']/tbody/tr/td[3])[21]")
	private WebElement assetTypePlAU;
	
    public WebElement getAssetTypePlAU() {
        return assetTypePlAU;
    }
    
  	@FindBy(xpath = "(//*[contains(@class,'product-summary')]//*[@class='lead'])[1]")
	private WebElement assetTypePD;
	
    public WebElement getAssetTypePD() {
        return assetTypePD;
    }
    
   	@FindBy(xpath = "//*[@class='characteristics']/p[@class='lead']")
	private WebElement fundAIMPD;
	
    public WebElement getFundAIMPD() {
        return fundAIMPD;
    }
    
   	@FindBy(xpath = "//*[contains(@class,'fund-managers')]/p[contains(@class,'lead')]")
	private WebElement fundManagerPD;
	
    public WebElement getFundManagerPD() {
        return fundManagerPD;
    }
    
   	@FindBy(xpath = "//*[contains(@class,'risk-reward-profile')]")
	private WebElement riskRewardProfile;
	
    public WebElement getRiskRewardProfile() {
        return riskRewardProfile;
    }
             
    public WebElement getCharacteristicsTab() {
        return CommonMethods.clickableElement(characteristicsTab);
    }

    public WebElement getCumulativeTab() {
        return cumulativeTab;
    }

    public WebElement getSectorTab() {
        return CommonMethods.clickableElement(sectorTab);
    }

    public WebElement getMarketCapTab() throws Exception {
        return CommonMethods.clickableElementWait(marketCapTab);
    }

    public WebElement getCountryTab() {
        return CommonMethods.clickableElement(countryTab);
    }

    public WebElement getAssetTab() {
        return CommonMethods.clickableElement(assetTab);
    }

    public WebElement getAnnualizedTab() {
        return annualizedTab;
    }

    public WebElement getCalendarTab() {
        return CommonMethods.clickableElement(calendarTab);
    }
    
    public WebElement getCumulativeTabPD() {
        return CommonMethods.clickableElement(calendarTab);
    }
    
  	@FindBy(xpath = "//*[@id='rvlin_anchorNav']//li/a")
	private List <WebElement> perfHeaders;
   	
    public List <WebElement> getPerfHeaders(){
        return perfHeaders;
    }
    
    //Literature
        
   	@FindBy(xpath = "//div[@class='document-wrapper']/h4")
	private List <WebElement> literatureColumns;
   	
    public List <WebElement> getLiteratureColumns(){
        return literatureColumns;
    }
    
   	@FindBy(xpath = "//div[@class='document-wrapper']")
	private WebElement literatureLink;
   	
    public WebElement getLiteratureLink(){
        return literatureLink;
    }
    
   	@FindBy(xpath = "//div[@class='document-wrapper']//a[text()='Initial Application Form']")
	private WebElement initialAppFormLink;
   	
    public WebElement getInitialAppFormLink(){
        return initialAppFormLink;
    }
    
    @FindBy(xpath = "//div[@class='document-wrapper']//a[text()='Erstmaliges Antragsformular']")
	private WebElement initialAppFormLinkDe;
    
    public WebElement getInitialAppFormLinkDe() {
		return initialAppFormLinkDe;
	}
    
   	@FindBy(xpath = "//div[@class='document-wrapper']//a[contains(text(),'Subsequent')]")
	private WebElement subseqAppFormLink;
   	
    public WebElement getSubseqAppFormLink(){
        return subseqAppFormLink;
    }
    
    @FindBy(xpath = "//div[@class='document-wrapper']//a[contains(text(),'Nachfolgendes Antragsformular')]")
	private WebElement subseqAppFormLinkDe;
    
    public WebElement getSubseqAppFormLinkDe() {
		return subseqAppFormLinkDe;
	}
    
   	@FindBy(xpath = "//div[@class='document-wrapper']//a[text()='Redemption Form']")
	private WebElement redemptionFormLink;
   	
    public WebElement getRedemptionFormLink(){
        return redemptionFormLink;
    }
    
    @FindBy(xpath = "//div[@class='document-wrapper']//a[text()='Verkaufsformular']")
	private WebElement redemptionFormLinkDe;
    
    public WebElement getRedemptionFormLinkDe() {
		return redemptionFormLinkDe;
	}
    
    
   	@FindBy(xpath = "//div[@class='document-wrapper']//a[contains(text(),'Exchange')]")
	private WebElement exchangeFormLink;
   	
    public WebElement getExchangeFormLink(){
        return exchangeFormLink;
    }
    
  	@FindBy(xpath = "//*[@id='dynamicFormsModal']")
	private WebElement dynamicFormModel;
   	
    public WebElement getDynamicFormModel(){
    	return dynamicFormModel;
    }  
         
  	@FindBy(xpath = "//*[@class='document-menu collapse show']//*[text()='Open']")
	private WebElement formOpenModel;
   	
    public WebElement getFormOpenModel(){
    	return CommonMethods.visibleElement(formOpenModel);
    }
    
  	@FindBy(xpath = "//*[@class='document-menu collapse show']//*[text()='Email']")
	private WebElement formEmaillink;
   	
    public WebElement getFormEmailLink(){
    	return CommonMethods.visibleElement(formEmaillink);
    }
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Select All')]")
    private WebElement selectAllLink;
    
    public WebElement getSelectAllLink() {
    	return selectAllLink;
    }
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Alle auswählen')]")
    private WebElement selectAllLinkDe;
    
    public WebElement getSelectAllLinkDe() {
		return selectAllLinkDe;
	}
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Clear All')]")
    private WebElement clearAllLink;
    
    public WebElement getClearAllLink() {
    	return clearAllLink;
    }
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Alle löschen')]")
    private WebElement clearAllLinkDe;
    
    public WebElement getClearAllLinkDe() {
		return clearAllLinkDe;
	}
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Next')]")
    private WebElement nextButton;
    
    public WebElement getNextButton() {
    	return nextButton;
    }
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Weiter')]")
    private WebElement nextButtonDe;
    
    public WebElement getNextButtonDe() {
		return nextButtonDe;
	}
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Next') and contains(@class, 'disabled')]")
    private WebElement nextButtonDisabled;
    
    public WebElement getNextButtonDisabled() {
    	return nextButtonDisabled;
    }
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Weiter') and contains(@class, 'disabled')]")
    private WebElement nextButtonDisabledDe;
    
    public WebElement getNextButtonDisabledDe() {
		return nextButtonDisabledDe;
	}
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Back')]")
    private WebElement backButton;
    
    public WebElement getBackButton() {
    	return backButton;
    }
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Zurück')]")
    private WebElement backButtonDe;
    
    public WebElement getBackButtonDe() {
		return backButtonDe;
	}
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Generate')]")
    private WebElement generateButton;
    
    public WebElement getGenerateButton() {
    	return generateButton;
    }
    
    @FindBy(xpath = "//*[@class='step-footer']//a[contains(., 'Generieren')]")
    private WebElement generateButtonDe;
    
    public WebElement getGenerateButtonDe() {
		return generateButtonDe;
	}
    
    @FindBy(xpath = "//*[contains(@class,'step-footer')]//a[contains(., 'Download')]")
    private WebElement downloadButton;
    
    public WebElement getDownloadButton() {
    	return downloadButton;
    }
    
    @FindBy(xpath = "//*[contains(@class,'step-footer')]//a[contains(., 'Herunterladen')]")
    private WebElement downloadButtonDe;
    
    public WebElement getDownloadButtonDe() {
		return downloadButtonDe;
	}
    
    @FindBy(xpath = "//*[@id='dynamicFormsModal']//*[@data-dismiss='modal']")
    private WebElement closeModal;
    
    public WebElement getCloseModal() {
    	return closeModal; 
    }
    
    @FindBy(xpath = "//*[@id='dynamicFormsModal']//*[@class='step step-1 active']")
    private WebElement stepOneActive;
    
    public WebElement getStepOneActive() {
    	return stepOneActive; 
    }
    
    @FindBy(xpath = "//*[@id='dynamicFormsModal']//*[@class='step step-2 active']")
    private WebElement stepTwoActive;
    
    public WebElement getStepTwoActive() {
    	return stepTwoActive; 
    }
    
    @FindBy(xpath = "//*[@id='dynamicFormsModal']//*[@class='step step-3 active']")
    private WebElement stepThreeActive;
    
    public WebElement getStepThreeActive() {
    	return stepThreeActive; 
    }

    @FindBy(xpath = "//*[@id='dynamicFormsModal']//*[@class='step step-1 active']/h4")
    private WebElement stepOneMessage;
    
    public WebElement geStepOneMessage() {
    	return stepOneMessage; 
    }
    
    @FindBy(xpath = "//*[@id='dynamicFormsModal']//*[@class='step step-2 active']/h4")
    private WebElement stepTwoMessage;
    
    public WebElement getStepTwoMessage() {
    	return stepTwoMessage; 
    }
    
    @FindBy(xpath = "//*[contains(@class, 'yields characteristics')]")
	private WebElement yieldsComponent;
	
    public WebElement getYieldsComponent() {
        return yieldsComponent;
    }
    
    @FindBy(xpath = "//*[contains(@class, 'yields characteristics')]//h4")
	private WebElement yieldsHeaderText;
	
    public WebElement getYieldsHeaderText() {
        return yieldsHeaderText;
    } 
    
    @FindBy(xpath = "//*[contains(@class, 'yields characteristics')]//span[@class='as-of-date']/span[1]")
	private WebElement yieldsAsOfText;
	
    public WebElement getYieldsAsOfText() {
        return yieldsAsOfText;
    }
    
    @FindBy(xpath = "//*[contains(@class, 'yields characteristics')]//span[@class='as-of-date']/span[2]")
	private WebElement yieldsAsOfDate;
	
    public WebElement getYieldsAsOfDate() {
        return yieldsAsOfDate;
    }
    
    public List<WebElement> getYieldsRows() {
        return driver.findElements(By.xpath("//*[contains(@class, 'yields characteristics')]//table/tbody/tr"));
    } 
    
    @FindBy(xpath = "//a[contains(.,'Growth of 10k') or contains(.,'GROWTH OF 10K')]")
    private WebElement growthOf10kTab;
    
    public WebElement getGrowthOf10kTab() {
        return growthOf10kTab;
    }
    
    @FindBy(xpath = "//a[contains(.,'Wachstum von 10.000')]")
    private WebElement growthOf10kTabDe;
    
    public WebElement getGrowthOf10kTabDe() {
		return growthOf10kTabDe;
	}
    
    @FindBy(xpath = "//a[contains(.,'NAV')]")
    private WebElement navTab;
    
    public WebElement getNavTab() {
        return navTab;
    }
    
    @FindBy(xpath = "//a[contains(.,'Anteilspreis')]")
    private WebElement navTabDe;
    
    public WebElement getNavTabDe() {
		return navTabDe;
	}
    
    @FindBy(xpath = "//div[contains(@class,'ten-k-performance')]//h4")
    private WebElement growthOf10KHeader;
    
    public WebElement getGrowthOf10KHeader() {
        return growthOf10KHeader;
    }
    
    @FindBy(xpath = "//div[contains(@class,'historic-nav')]//h4")
    private WebElement navHeader;
    
    public WebElement getNavHeader() {
        return navHeader;
    }
    
    @FindBy(xpath = "//div[contains(@class,'ten-k-performance')]")
    private WebElement growthOf10KComponent;
    
    public WebElement getGrowthOf10KComp() {
        return growthOf10KComponent;
    }
    
    @FindBy(xpath = "//div[contains(@class,'historic-nav')]")
    private WebElement navComponent;
    
    public WebElement getNavComponent() {
        return navComponent;
    }
    
    @FindBy(xpath = "//*[contains(@class, 'ten-k-performance')]//span[@class='as-of-date']/span[1]")
	private WebElement growth10KAsOfText;
	
    public WebElement getGrowth10KAsOfText() {
        return growth10KAsOfText;
    }
    
    @FindBy(xpath = "//*[contains(@class, 'historic-nav')]//span[@class='as-of-date']/span[1]")
	private WebElement navAsOfText;
	
    public WebElement getNavAsOfText() {
        return navAsOfText;
    }
    
    @FindBy(xpath = "//*[contains(@class, 'ten-k-performance')]//span[@class='as-of-date']/span[3]/span")
	private WebElement growth10KExcluding;
	
    public WebElement getGrowth10KExcluding() {
        return growth10KExcluding;
    }
    
    @FindBy(xpath = "//*[contains(@class, 'historic-nav')]//span[@class='as-of-date']/span[3]/span")
	private WebElement navExcluding;
	
    public WebElement getNavKExcluding() {
        return navExcluding;
    }
    
    @FindBy(xpath = "//*[contains(@class, 'ten-k-performance')]//span[@class='as-of-date']/span[3]")
  	private WebElement growth10KExcludingAU;
  	
    public WebElement getGrowth10KExcludingAU() {
        return growth10KExcludingAU;
    }
    
    @FindBy(xpath = "//*[contains(@class, 'ten-k-performance')]//span[@class='as-of-date']/span[2]")
	private WebElement growthOf10KAsOfDate;
	
    public WebElement getGrowthOf10KAsOfDate() {
        return growthOf10KAsOfDate;
    }
    
    @FindBy(xpath = "//*[contains(@class, 'historic-nav')]//span[@class='as-of-date']/span[2]")
 	private WebElement navAsOfDate;
 	
     public WebElement getNavAsOfDate() {
         return navAsOfDate;
     }
    
    @FindBy(xpath = "//*[contains(@class, 'ten-k-performance')]//div[@class='range-selector']/a")
	private List<WebElement> growth10KRangeFilters;
	
    public List<WebElement> getGrowth10KRangeFilters() {
        return growth10KRangeFilters;
    }  
    
    public WebElement getFundNamePLOverTab(String fundName) {
        return CommonMethods.clickableElement(driver.findElement(By.xpath("//td[@class='fund sorting_1']//a[text()='"+fundName+"']")));
    }
    
    public WebElement getFundNamechPLOverTab(String fundName) {
        return CommonMethods.clickableElement(driver.findElement(By.xpath("//td[@class='fund sorting_1']//a[contains(@href,'"+fundName+"')]")));
    }
    
    @FindBy(xpath = "//*[contains(@class, 'historic-nav')]//div[@class='range-selector']/a")
 	private List<WebElement> navRangeFilters;
 	
     public List<WebElement> getNavRangeFilters() {
         return navRangeFilters;
     } 
    
	@FindBy(xpath = "//*[@id='rvlin_anchorNav']//*[@class='scroll-trigger scroll-right ico-arrow-right active']")
	private WebElement rightArrow;
   	
    public WebElement getRightArrow(){
        return rightArrow;
    } 
    
    @FindBy(xpath = "(//tr/td[contains(text(),' - Inclusive of Sales Charge')])[1]")
   	private WebElement annualisedInclusiveOfSalesCharge;
       
       @FindBy(xpath = "(//tr/td[contains(text(),' - Inclusive of Sales Charge')])[2]")
     	private WebElement cumulativeInclusiveOfSalesCharge;
       
       @FindBy(xpath = "(//tr/td[contains(text(),' - Inclusive of Sales Charge')])[3]")
     	private WebElement calenderInclusiveOfSalesCharge;

       @FindBy(xpath = "(//tr/td[contains(text(),' - Inclusive of Sales Charge')])[4]")
     	private WebElement rollingInclusiveOfSalesCharge;
       
       @FindBy(xpath = "(//td[contains(text(),'Class A SGD ACC')])[1]")
    	private WebElement annualisedExclusiveOfSalesCharge;
       
       @FindBy(xpath = "(//td[contains(text(),'Class A SGD ACC')])[2]")
   		private WebElement cumulativeExclusiveOfSalesCharge;
       
       @FindBy(xpath = "(//td[contains(text(),'Class A SGD ACC')])[3]")
      	private WebElement calendarExclusiveOfSalesCharge;
       
       @FindBy(xpath = "(//td[contains(text(),'Benchmark')])[1]")
     	private WebElement annualisedBenchmark;
       
       public WebElement getAnnualisedBenchmark() {
    		return annualisedBenchmark;
      }
       
       @FindBy(xpath = "(//td[contains(text(),'Benchmark')])[2]")
    	private WebElement cumulativeBenchmark;
       
       public WebElement getCumulativeBenchmark() {
    		return cumulativeBenchmark;
      }
       
       @FindBy(xpath = "(//td[contains(text(),'Benchmark')])[3]")
   		private WebElement calendarBenchmark;
      
      public WebElement getCalendarBenchmark() {
   		return calendarBenchmark;
     }
       
       public WebElement getCalendarExclusiveOfSalesCharge() {
     		return calendarExclusiveOfSalesCharge;
       }
       
       public WebElement getCumulativeExclusiveOfSalesCharge() {
      		return cumulativeExclusiveOfSalesCharge;
      	}
       
   	
       public WebElement getAnnualisedExclusiveOfSalesCharge() {
   		return annualisedExclusiveOfSalesCharge;
   	}

   
   	public WebElement getAnnualisedInclusiveOfSalesCharge() {
   		return annualisedInclusiveOfSalesCharge;
   	}

   	public WebElement getCumulativeInclusiveOfSalesCharge() {
   		return cumulativeInclusiveOfSalesCharge;
   	}

   	public WebElement getCalenderInclusiveOfSalesCharge() {
   		return calenderInclusiveOfSalesCharge;
   	}

   	public WebElement getRollingInclusiveOfSalesCharge() {
   		return rollingInclusiveOfSalesCharge;
   	}

   	@FindBy(xpath = "//a[@class='open'][contains(@href,'exchange')]")
	private WebElement openIconExchangeForm;
    
    public WebElement getOpenIconExchangeForm() {
		return openIconExchangeForm;
	}
    
    @FindBy(xpath = "//a[@class='email'][contains(@data-interaction-label,'exchange')]")
	private WebElement emailIconExchangeForm;
    
    public WebElement getEmailIconExchangeForm() {
		return emailIconExchangeForm;
	}
   	
    @FindBy(xpath = "(//a[contains(.,'Annu')])[1]")
    private WebElement annualizedTabFR;
    
    public WebElement getAnnualizedTabFR() {
		return annualizedTabFR;
	}
    
    @FindBy(xpath = "//a[contains(.,'Calend')]")
    private WebElement calendarTabFR;
    
    public WebElement getCalendarTabFR() {
		return calendarTabFR;
    }
    
    @FindBy(xpath = "//a[contains(.,'Cumul')]")
    private WebElement cumulativeTabFR;
    
    public WebElement getCumulativeTabFR() {
		return cumulativeTabFR;
	}
    
}
