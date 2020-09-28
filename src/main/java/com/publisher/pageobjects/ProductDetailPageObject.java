package com.publisher.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.publisher.steps.CommonMethods;

public class ProductDetailPageObject {

	public static final String CLASS = "class";
	public static final String ACTIVE = "active";

	static ProductDetailPageObject productDetailObject;
	private WebDriver driver;
	
	private ProductDetailPageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static ProductDetailPageObject productDetailPageObject(WebDriver driver) throws IOException {
		productDetailObject=null;
		productDetailObject=new ProductDetailPageObject(driver);
			return productDetailObject; 
	}

	@FindBy(xpath = "(//*[@id='tab-performance']//tbody/tr/td[1]/a)[1]")
	private WebElement fundNamewithOutDataLink;

	public WebElement getFundNameWithOudDataLink() throws Exception {
		return fundNamewithOutDataLink;
	}

	@FindBy(xpath = "(//*[@id='tab-performance']//tbody/tr/td[1]/a)[1]")
	private WebElement fundNameWithOutDataText;

	public WebElement getFundNameWithOudDataText() throws Exception {
		return fundNameWithOutDataText;
	}

	@FindBy(xpath = "(//*[@id='tab-performance']//tbody/tr/td[1]/a)[6]")
	private WebElement fundNameLink;

	public WebElement getFundNameLink() throws Exception {
		return fundNameLink;
	}

	@FindBy(xpath = "(//*[@id='tab-performance']//tbody/tr/td[1]/a)[6]")
	private WebElement fundNameText;

	public WebElement getFundNameText() throws Exception {
		return fundNameText;
	}
	
	@FindBy(xpath = "(//*[@id='tab-overview']//tbody/tr/td[1]/a)[4]")
	private WebElement fundNamePLoverview;

	public WebElement getFundNamePLoverview() throws Exception {
		return fundNamePLoverview;
	}
	public WebElement getFundNameTextAU(String fundName) throws Exception {
		return driver.findElement(By.xpath("//*[@id='tab-overview']//a[text()='"+ fundName +"']"));
	}	

	@FindBy(xpath = "//*[@class='nav-item']//a[contains(text(),'Performance')]")
	private WebElement performanceSubTab;

	public WebElement getPerformanceSubTab() throws Exception {
		return performanceSubTab;
	}

	@FindBy(xpath = "//*[@id='pnlqc_anchorNav']//*[contains(text(),'Distributions')]")
	private WebElement distributionsTab;

	public WebElement getDistributionsTab() throws Exception {
		return distributionsTab;
	}
	
	@FindBy(xpath = "//*[@id='pnlqc_anchorNav']//*[contains(text(),'Ausschüttungen')]")
	private WebElement distributionsTabDe;
	
	public WebElement getDistributionsTabDe() {
		return distributionsTabDe;
	}

	@FindBy(xpath = "//*[@id='pnlqc_anchorNav']//*[contains(text(),'Investment Risks')]")
	private WebElement investmentRiskTab;

	public WebElement getInvestmentRiskTab() throws Exception {
		return investmentRiskTab;
	}
	
	@FindBy(xpath = "//div[contains(@class,'distributions distributions')]//h4")
	private WebElement distributionsTableHeader;
	    
	public WebElement getDistributionsTableHeader() {
	    return distributionsTableHeader;
	}
	    
	@FindBy(xpath = "//div[contains(@class,'distributions distributions')]//span")
	private WebElement distributionsAsofDate;
	    
	public WebElement getDistributionsAsOfDate() {
	    return distributionsAsofDate;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'distributions distributions')]/table/tbody/tr)[1]")
	private List <WebElement> distributionsTableRows;
	    
	public List <WebElement> getDistributionsTableRows() {
	    return distributionsTableRows;
	}
	
	
	/*@FindBy(xpath = "//*[@id='pqjjd']//*[contains(text(),'Distributions')]")
	private WebElement distributionsTabHeader;

	public WebElement getDistributionsTableHeader() throws Exception {
		return distributionsTabHeader;
	}*/

	// *[@class='product-charts']//*[contains(text(),'Distributions')]
	
	@FindBy(xpath = "//*[@class='product-charts']//*[contains(text(),'Distributions')]")
	private WebElement distributionsHeader;

	public WebElement getDistributionsHeader() throws Exception {
		return distributionsHeader;
	}

	@FindBy(xpath = "//*[@class='product-charts']//*[contains(text(),'Distributions data is not available for selected share class')]")
	private WebElement distributionsWithOutData;

	public WebElement getDistributionsWithOutData() throws Exception {
		return distributionsWithOutData;
	}

	@FindBy(xpath = "//*[@id='pqjjd']//*[contains(text(),'Ex-dividend/Reinvest date')]")
	private WebElement dividendReinvestDate;

	public WebElement getDividendReinvestDate() throws Exception {
		return dividendReinvestDate;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'distributions-chart')])[1]//th[contains(text(),'Ex-Dividende/Wiederanlage-Datum')]")
	private WebElement dividendReinvestDateDe;
	
	public WebElement getDividendReinvestDateDe() {
		return dividendReinvestDateDe;
	}

	@FindBy(xpath = "//*[@id='pqjjd']//*[contains(text(),'Payable date')]")
	private WebElement payableDate;

	public WebElement getPayAbleDate() throws Exception {
		return payableDate;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'distributions-chart')])[1]//th[contains(text(),'Zahlungstermin')]")
	private WebElement payableDateDe;
	
	public WebElement getPayableDateDe() {
		return payableDateDe;
	}

	@FindBy(xpath = "//*[@id='pqjjd']//*[contains(text(),'Reinvest price')]")
	private WebElement reinvestprice;

	public WebElement getReinvestprice() throws Exception {
		return reinvestprice;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'distributions-chart')])[1]//th[contains(text(),'Wiederanlagepreis')]")
	private WebElement reinvestpriceDe;
	
	public WebElement getReinvestpriceDe() {
		return reinvestpriceDe;
	}

	@FindBy(xpath = "//*[@id='pqjjd']//*[contains(text(),'Ordinary income')]")
	private WebElement ordinaryIncom;
	
	public WebElement getOrdinaryIncom() throws Exception {
		return ordinaryIncom;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'distributions-chart')])[1]//th[contains(text(),'Ordinary income')]")
	private WebElement ordinaryIncomDe;
	
	public WebElement getOrdinaryIncomDe() {
		return ordinaryIncomDe;
	}

	@FindBy(xpath = "//*[@data-target='#distributionsModal']")
	private WebElement viewFullTable;

	public WebElement getViewFullTable() {
		return CommonMethods.clickableElement(viewFullTable);
	}

	@FindBy(xpath = "//*[@data-target='#distributionsModal']//*[@class='ico-search']")
	private WebElement viewFullTableIcon;

	public WebElement getViewFullTableIcon() {
		return CommonMethods.clickableElement(viewFullTableIcon);
	}

	@FindBy(xpath = "//*[@id='kgavl']//*[@class='disclosure-text']")
	private WebElement disclaimer;

	public WebElement getDisclaimer() throws Exception {
		return disclaimer;
	}
	@FindBy(xpath = "//*[@class='disclosure-text']")
	private WebElement disclosure;

	public WebElement getDisclosure() throws Exception {
		return disclosure;
	}
	@FindBy(xpath = "//*[@id='distributionsModal']//*[@class='modal-header']")
	private WebElement distributionsModelbHeader;

	public WebElement getDistributionsModelHeader() throws Exception {
		return distributionsModelbHeader;
	}

	@FindBy(xpath = "//*[@id='distributionsModal']//*[contains(text(),'Ex-dividend/Reinvest date')]")
	private WebElement dividendModelReinvestDate;

	public WebElement getDividendModelReinvestDate() throws Exception {
		return dividendModelReinvestDate;
	}
	
	@FindBy(xpath = "//*[@id='distributionsModal']//*[contains(text(),'Ex-Dividende/Wiederanlage-Datum')]")
	private WebElement dividendModelReinvestDateDe;
	
	public WebElement getDividendModelReinvestDateDe() {
		return dividendModelReinvestDateDe;
	}

	@FindBy(xpath = "//*[@id='distributionsModal']//*[contains(text(),'Payable date')]")
	private WebElement payableModelDate;

	public WebElement getPayAbleModelDate() throws Exception {
		return payableModelDate;
	}
	
	@FindBy(xpath = "//*[@id='distributionsModal']//*[contains(text(),'Zahlungstermin')]")
	private WebElement payableModelDateDe;
	
	public WebElement getPayableModelDateDe() {
		return payableModelDateDe;
	}

	@FindBy(xpath = "//*[@id='distributionsModal']//*[contains(text(),'Reinvest price')]")
	private WebElement reinvestModelprice;

	public WebElement getReinvestModelprice() throws Exception {
		return reinvestModelprice;
	}
	
	@FindBy(xpath = "//*[@id='distributionsModal']//*[contains(text(),'Wiederanlagepreis')]")
	private WebElement reinvestModelpriceDe;
	
	public WebElement getReinvestModelpriceDe() {
		return reinvestModelpriceDe;
	}

	@FindBy(xpath = "//*[@id='distributionsModal']//*[contains(text(),'Ordinary income')]")
	private WebElement ordinaryModelIncom;

	public WebElement getOrdinaryModelIncom() throws Exception {
		return ordinaryModelIncom;
	}
	
	@FindBy(xpath = "//*[@id='distributionsModal']//*[contains(text(),'Ordinary income')]")
	private WebElement ordinaryModelIncomDe;
	
	public WebElement getOrdinaryModelIncomDe() {
		return ordinaryModelIncomDe;
	}

	@FindBy(xpath = "//section[contains(@class,'product-summary-comp')]//h1")
	private WebElement fundNameTitle;

	public WebElement getFundNameTitle() throws Exception {
		return fundNameTitle;
	}
	
	@FindBy(xpath = "//*[@class='product-charts']//*[contains(text(),'Ausschüttungen')]")
	private WebElement distributionsHeaderDe;
	
	public WebElement getDistributionsHeaderDe() {
		return distributionsHeaderDe;
	}
	
	@FindBy(xpath = "//*[@class='product-charts']//*[contains(text(),'Ausschüttungsdaten sind für ausgewählte Anteilsklasse nicht verfügbar')]")
	private WebElement distributionsWithOutDataDe;

	public WebElement getDistributionsWithOutDataDe() {
		return distributionsWithOutDataDe;
	}

	@FindBy(xpath = "//*[@id='distributionsModal']//*[@class='close']")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return CommonMethods.clickableElement(closeButton);
	}

	@FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Annualised')]")
	private WebElement performanceAnnualisedTab;

	public WebElement getPerformanceAnnualisedTab() throws Exception {
		return performanceAnnualisedTab;
	}
	
	@FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Annualisiert')]")
	private WebElement performanceAnnualisedTabDe;
	
	public WebElement getPerformanceAnnualisedTabDe() {
		return performanceAnnualisedTabDe;
	}

	@FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Cumulative')]")
	private WebElement performanceCumulativeTab;

	public WebElement getPerformanceCumulativeTab() throws Exception {
		return performanceCumulativeTab;
	}
	
	@FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Kumuliert')]")
	private WebElement performanceCumulativeTabDe;
	
	public WebElement getPerformanceCumulativeTabDe() {
		return performanceCumulativeTabDe;
	}

	@FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Calendar')]")
	private WebElement performanceCalenderTab;

	public WebElement getPerformanceCalenderTab() throws Exception {
		return performanceCalenderTab;
	}
	
	@FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Kalenderjahr')]")
	private WebElement performanceCalenderTabDe;
	
	public WebElement getPerformanceCalenderTabDe() {
		return performanceCalenderTabDe;
	}
	
	@FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Discrete Rolling')]")
	private WebElement performanceDiscreteRollingTab;

	public WebElement getPerformanceDiscreteRollingTab() throws Exception {
		return performanceDiscreteRollingTab;
	}
	
	@FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Rollierend')]")
	private WebElement performanceDiscreteRollingTabDe;
	
	public WebElement getPerformanceDiscreteRollingTabDe() {
		return performanceDiscreteRollingTabDe;
	}
	
	@FindBy(xpath = "//*[contains(text(),'Daily Statistics')]")
	private WebElement dailyStatistics;
	public WebElement getDailyStatistics() throws Exception {
		return dailyStatistics;
	}
	@FindBy(xpath = "//*[contains(text(),'Fund Facts')]")
	private WebElement fundFacts;
	public WebElement getFundFacts() throws Exception {
		return dailyStatistics;
	}
	@FindBy(xpath = "//*[contains(text(),'Fund codes')]")
	private WebElement fundCodes;
	public WebElement getFundCodes() throws Exception {
		return fundCodes;
	}
	@FindBy(xpath = "//*[contains(text(),'Three-Year risk')]")
	private WebElement threeYearRisk;
	public WebElement getthreeYearRisk() throws Exception {
		return threeYearRisk;
	}
	
	@FindBy(xpath = "//div[@class='fund-facts fund-facts-characteristics fund-facts-pdpaj']//h4")
    private WebElement fundFactsHeader;
    
    public WebElement getFundFactsHeader() {
        return fundFactsHeader;
    }
    @FindBy(xpath = "//div[@class='fund-codes fund-codes-pfcnt']//h4")
    private WebElement fundCodesHeader;
    
    public WebElement getFundCodesHeader() {
        return fundCodesHeader;
    }
    
    @FindBy(xpath = "//div[contains(@class,'daily-statistics characteristics daily-statistics-wdddy')]//h4")
    private WebElement dailyStatisticsHeader;
    
    public WebElement getDailyStatisticsHeader() {
        return dailyStatisticsHeader;
    }
    
    @FindBy(xpath = "//div[contains(@class,'daily-statistics characteristics daily-statistics-wdddy')]//span[2]")
    private WebElement dailyStatisticsAsofDate;
    
    public WebElement getDailyStatisticsAsOfDate() {
        return dailyStatisticsAsofDate;
    }
	@FindBy(xpath = "//div[@class='charges charges-characteristics charges-flghs']//h4")
    private WebElement chargesHeader;
    
    public WebElement getChargesHeader() {
        return chargesHeader;
    }
    @FindBy(xpath = "//div[@class='risk-reward-profile risk-reward-profile-akinr nethEng']//h4")
    private WebElement riskRewardsHeader;
    
    public WebElement getRiskRewardsHeader() {
        return riskRewardsHeader;
    }
    
    @FindBy(xpath = "//div[@class='risk-reward-profile risk-reward-profile-akinr nethEng']//img")
    private WebElement riskRewardImage;
    
    public WebElement getRiskRewardImage() {
        return riskRewardImage;
    }
    
  
	@FindBy(xpath = "//div[contains(@class,'three-year-risk three-year-risk-wgmdr')]//h4")
    private WebElement threeYearRiskHeader;
    
    public WebElement getThreeYearRiskHeader() {
        return threeYearRiskHeader;
    }
    
    @FindBy(xpath = "//div[contains(@class,'three-year-risk three-year-risk-wgmdr')]//span[2]")
    private WebElement threeYearRiskAsofDate;
    
    public WebElement getThreeYearRiskAsOfDate() {
        return threeYearRiskAsofDate;
    }
	@FindBy(xpath = "//*[text()='Key Actions']")
	private WebElement keyActionButton;
	
    public WebElement getKeyActionButton() {
        return CommonMethods.clickableElement(keyActionButton);
    }
    
    public WebElement getPerfComponentHeader(String componentId) {
        return driver.findElement(By.xpath("//div[contains(@class,'"+componentId+"')]//h4"));
    }
    
    @FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Performance glissante')]")
	private WebElement performanceDiscreteRollingTabFR;
    
    public WebElement getPerformanceDiscreteRollingTabFR() {
		return performanceDiscreteRollingTabFR;
	}
    
    @FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Calendaire')]")
	private WebElement performanceCalenderTabFR;
    
    public WebElement getPerformanceCalenderTabFR() {
		return performanceCalenderTabFR;
	}
    
    @FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Annualis')]")
	private WebElement performanceAnnualisedTabFR;
    
    public WebElement getPerformanceAnnualisedTabFR() {
		return performanceAnnualisedTabFR;
	}
    
    @FindBy(xpath = "//*[@id='tab-performance']//*[contains(text(),'Cumul')]")
	private WebElement performanceCumulativeTabFR;
    
    public WebElement getPerformanceCumulativeTabFR() {
		return performanceCumulativeTabFR;
	}
   	
   }


