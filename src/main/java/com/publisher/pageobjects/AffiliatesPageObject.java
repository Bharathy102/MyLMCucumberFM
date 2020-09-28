package com.publisher.pageobjects;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AffiliatesPageObject {

	static AffiliatesPageObject affiliates;
	private WebDriver driver;
	protected String contentPath;
	protected String pageTitle;
	
	private AffiliatesPageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static AffiliatesPageObject affiliatesPageObject(WebDriver driver) throws IOException {
		affiliates=null;
		affiliates=new AffiliatesPageObject(driver);
			return affiliates; 
	}
	
	

	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div/div[11]/div/h3/span")
	private WebElement ourAffiliatesTitle;

	public WebElement getAffiliatesTitle() {
		return ourAffiliatesTitle;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-brandywine')]")
	private WebElement brandywineLogo;

	public WebElement getBrandywineLogo() {
		return brandywineLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-clarion-partners')]")
	private WebElement clarionPartnersLogo;

	public WebElement getClarionPartnersLogo() {
		return clarionPartnersLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-clearbridge-investments')]")
	private WebElement clearbridgeInvestmentLogo;

	public WebElement getClearBridgeInvestmentLogo() {
		return clearbridgeInvestmentLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-entrustpermal') or contains(@src, 'logo-entrustglobal')]")
	private WebElement entrustpermalLogo;

	public WebElement getEntrustPermalLogo() {
		return entrustpermalLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-martin-currie')]")
	private WebElement martincurrieLogo;

	public WebElement getEnMartinCurrieLogo() {
		return martincurrieLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-qs-investors')]")
	private WebElement qsInvestorsLogo;

	public WebElement getQsInvestorsLogo() {
		return qsInvestorsLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-rare-infrastructure')]")
	private WebElement rareInfrastructureLogo;

	public WebElement getRareInfrastructureLogo() {
		return rareInfrastructureLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'associates')]")
	private WebElement royceAndAssociatesLogo;

	public WebElement getRoyceandAssociatesLogo() {
		return royceAndAssociatesLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-western-asset')]")
	private WebElement westernAssetLogo;

	public WebElement getWesternAssetLogo() {
		return westernAssetLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-brandywine-global') or contains(@style,'brandywine-global')]")
	private WebElement brandywineGlobalPageLogo;

	public WebElement getBrandywineGlobalPageLogo() {
		return brandywineGlobalPageLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-clarion-partners')]")
	private WebElement clarionpartnerspageLogo;

	public WebElement getClarionPartnersPageLogo() {
		return clarionpartnerspageLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-clearbridge-investments')]")
	private WebElement clearbridgeInvestmentpageLogo;

	public WebElement getClearBridgeInvestmentPageLogo() {
		return clearbridgeInvestmentpageLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-entrustpermal') or contains(@src,'logo-entrustglobal')]")
	private WebElement entrustpermalPageLogo;

	public WebElement getEnTrustPermalPageLogo() {
		return entrustpermalPageLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-martin-currie') or contains(@src,'logo-martin-currie-horizontal-600.jpg')]")
	private WebElement martincurriePageLogo;

	public WebElement getMartinCurriePageLogo() {
		return martincurriePageLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-qs-investors') or contains(@src, 'logo-qs-investors.svg')]") 
	private WebElement qsinvestorsPageLogo;

	public WebElement getQsInvestorsPageLogo() {
		return qsinvestorsPageLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-rare') or contains(@src, 'logo-rare-infrastructure-home.png') or contains(@src,'logo-rare.jpg')]")
	private WebElement rarePageLogo;

	public WebElement getRarePageLogo() {
		return rarePageLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-western-asset')]")
	private WebElement westernassetPageLogo;

	public WebElement getWesternAssetPageLogo() {
		return westernassetPageLogo;
	}

	@FindBy(xpath = "//*[contains(@src,'logo-royce-and-associate')]")
	private WebElement royceandassociatesPageLogo;

	public WebElement getRoyceandAssociatesPageLogo() {
		return royceandassociatesPageLogo;
	}
	
	
	@FindBy(xpath = "//*[contains(@src,'logo-rare-infrastructure-home.png')]")
	private WebElement rareInfrastructurePageLogoCY;

	public WebElement getRareInfrastructurePageLogoCY() {
		return rareInfrastructurePageLogoCY;
	}
	
}
