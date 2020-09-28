package com.publisher.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPageObject {
	
	private static AboutUsPageObject aboutUs;
	private WebDriver driver;
	
	private AboutUsPageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static AboutUsPageObject aboutUsPageObject(WebDriver driver) throws IOException {
			aboutUs=null;
			aboutUs=new AboutUsPageObject(driver);
			return aboutUs; 
	}

	protected String contentPath;
	protected String pageTitle;

	@FindBy(xpath = "//*[contains(@href,'about-us.html') or contains(@href,'about-us0.html')]")
	private WebElement aboutUsHeader;
	
	@FindBy(xpath = "//a[contains(@href,'about-us.html') or contains(@href,'about-us0.html')]")
	private WebElement aboutUsHeaderCH;
	
	@FindBy(xpath = "//*[contains(@href,'ueber-uns.html')]")
	private WebElement aboutUsHeaderGermany;
	
	public WebElement getAboutUsHeaderGermany() {
		return aboutUsHeaderGermany;
	}
	
	public WebElement getaboutUsHeaderCH() {
		return aboutUsHeaderCH;
	}
	
	@FindBy(xpath = "//*[contains(@href,'about-us.html') or contains(@href,'about-us0.html')]")
	private WebElement aboutUsHeaderAA;

	@FindBy(xpath = "//*[contains(@href,'about-us/affiliates.html') or contains(@href,'about-us0/affiliates.html')]")
	private WebElement aboutUsAffiliate;

	@FindBy(xpath = "//*[contains(@href,'ueber-uns/tochtergesellschaften.html')]")
	private WebElement aboutUsAffiliateDe;
	
	public WebElement getAboutUsAffiliateDe() {
		return aboutUsAffiliateDe;
	}
	
	@FindBy(xpath = "//*[contains(@href,'about-us/people.html') or contains(@href,'about-us0/people.html')]")
	private WebElement aboutUsPeople;
	
	@FindBy(xpath = "//*[contains(@href,'ueber-uns/unser-vorstand.html')]")
	private WebElement aboutUsPeopleDe;
	
	public WebElement getAboutUsPeopleDe() {
		return aboutUsPeopleDe;
	}
	
	@FindBy(xpath = "//*[contains(@href,'about-us/our-people.html') or contains(@href,'about-us0/our-people.html') or contains(@href, 'about-us/people.html')]")
	private WebElement aboutUsPeopleAU;
	
	@FindBy(xpath = "//*[contains(@href,'about-us0/our-people.html') or contains(@href,'about-us/our-people.html') or contains(@href, 'about-us0/people.html')]")
	private WebElement aboutUsPeopleLU;

	@FindBy(xpath = "//*[contains(@href,'annual-report')]")
	private WebElement aboutUsReport;

	@FindBy(xpath = "//*[contains(@data-component-path,'about-us/jcr:content/par/section_container_1148156544/hero')]")
	private WebElement aboutUsMarketInsight;

	@FindBy(xpath = "//*[contains(@href,'joseph-a-sullivan.html')]")
	private WebElement leadershipSullivan;

	@FindBy(xpath = "//*[contains(@href,'peter-h-nachtwey.html')]")
	private WebElement leadershipPeterNachtwey;

	@FindBy(xpath = "//*[contains(@href,'terence-johnson.html')]")
	private WebElement leadershipJohnson;

	@FindBy(xpath = "//*[contains(@href,'thomas-merchant.html')]")
	private WebElement leadershipThomasMerchant;

	@FindBy(xpath = "//*[contains(@href,'thomas-k-hoops.html')]")
	private WebElement leadershipThomasHoops;

	@FindBy(xpath = "//*[contains(@href,'ursula-schliessler.html')]")
	private WebElement leadershipUrsula;

	@FindBy(xpath = "//*[contains(@href,'frances-cashman.html')]")
	private WebElement leadershipFrancesCashman;

	@FindBy(xpath = "//*[contains(@href,'john-kenney.html')]")
	private WebElement leadershipJohnKenney;

	@FindBy(xpath = "//*[contains(@href,'patricia-lattin.html')]")
	private WebElement leadershipPatricia;

	@FindBy(xpath = "//*[contains(@src,'headshot-joe-sullivan.jpg')]")
	private WebElement josephSullivanImage;

	@FindBy(xpath = "//*[contains(@src,'headshot-peter-nachtwey.jpg')]")
	private WebElement peterNachtweyImage;

	@FindBy(xpath = "//*[contains(@src,'headshot-terry-johnson.jpg')]")
	private WebElement terenceJohnsonImage;

	@FindBy(xpath = "//*[contains(@src,'headshot-tom-merchant.jpg')]")
	private WebElement thomasMerchantImage;

	@FindBy(xpath = "//*[contains(@src,'headshot-tom-hoops.jpg')]")
	private WebElement thomasHoopsImage;

	@FindBy(xpath = "//*[contains(@src,'headshot-ursula-schliessler.jpg')]")
	private WebElement ursulaSchliesslerImage;

	@FindBy(xpath = "//*[contains(@src,'headshot-fran-cashman.jpg')]")
	private WebElement francesCashmanImage;

	@FindBy(xpath = "//*[contains(@src,'headshot-john-kenney.jpg')]")
	private WebElement johnKenneyImage;

	@FindBy(xpath = "//*[contains(@src,'headshot-patty-lattin.jpg')]")
	private WebElement patriciaLattinImage;

	@FindBy(xpath = "//*[contains(@style,'2flogo-brandywine-global-gray-card.png')]")
	private WebElement brandywineGlobalGrid;

	@FindBy(xpath = "//*[contains(@style,'2flogo-clarion-partners-gray-card.png')]")
	private WebElement clarionPartnersGrid;

	@FindBy(xpath = "//*[contains(@style,'2flogo-clearbridge-investments-gray-card.png')]")
	private WebElement clearBridgeInvestmentGrid;

	@FindBy(xpath = "//*[contains(@style,'2flogo-entrustpermal-gray-card.png')]")
	private WebElement enTrustPermalGrid;

	@FindBy(xpath = "//*[contains(@style,'2flogo-martin-currie-gray-card.png')]")
	private WebElement martinCurrieGrid;

	@FindBy(xpath = "//*[contains(@style,'2flogo-qs-investors-gray-card.png')]")
	private WebElement qsInvestorGrid;

	@FindBy(xpath = "//*[contains(@style,'2flogo-rare-infrastructure-gray-card.png')]")
	private WebElement rareInfrastructureGrid;

	@FindBy(xpath = "//*[contains(@style,'2flogo-royce-and-associates-gray-card.png')]")
	private WebElement royceAndAssociatesGrid;

	@FindBy(xpath = "//*[contains(@style,'2flogo-western-asset-gray-card.png')]")
	private WebElement westernAssetGrid;

	public WebElement getAboutUsHeader() {
		return aboutUsHeader;
	}
	
	public WebElement getAboutUsHeaderAA() {
		return aboutUsHeaderAA;
	}

	public WebElement getAboutUsAffiliate() {
		return aboutUsAffiliate;
	}

	public WebElement getAboutUsPeople() {
		return aboutUsPeople;
	}
	
	public WebElement getAboutUsPeopleAU() {
		return aboutUsPeopleAU;
	}
	
	public WebElement getAboutUsPeopleLU() {
		return aboutUsPeopleLU;
	}

	public WebElement getAboutUsReport() {
		return aboutUsReport;
	}

	public WebElement getAboutUsMarketInsight() {
		return aboutUsMarketInsight;

	}

	public WebElement getLeadershipSullivan() {
		return leadershipSullivan;

	}

	public WebElement getLeadershipPeterNachtwey() {
		return leadershipPeterNachtwey;

	}

	public WebElement getLeadershipJohnson() {
		return leadershipJohnson;

	}

	public WebElement getlLeadershipThomasMerchant() {
		return leadershipThomasMerchant;

	}

	public WebElement getLeadershipThomasHoops() {
		return leadershipThomasHoops;

	}

	public WebElement getLeadershipUrsula() {
		return leadershipUrsula;

	}

	public WebElement getLeadershipFrancesCashman() {
		return leadershipFrancesCashman;

	}

	public WebElement getLeadershipJohnKenney() {
		return leadershipJohnKenney;

	}

	public WebElement getLeadershipPatricia() {
		return leadershipPatricia;

	}

	public WebElement getJosephSullivanImage() {
		return josephSullivanImage;

	}

	public WebElement getPeterNachtweyImage() {
		return peterNachtweyImage;

	}

	public WebElement getTerenceJohnsonImage() {
		return terenceJohnsonImage;

	}

	public WebElement getThomasMerchantImage() {
		return thomasMerchantImage;

	}

	public WebElement getthomasHoopsImage() {
		return thomasHoopsImage;

	}

	public WebElement getUrsulaSchliesslerImage() {
		return ursulaSchliesslerImage;

	}

	public WebElement getFrancesCashmanImage() {
		return francesCashmanImage;

	}

	public WebElement getJohnKenneyImage() {
		return johnKenneyImage;

	}

	public WebElement getPatriciaLattinImage() {
		return patriciaLattinImage;

	}

	public WebElement getBrandywineGlobalGrid() {
		return brandywineGlobalGrid;

	}

	public WebElement getClarionPartnersGrid() {
		return clarionPartnersGrid;
	}

	public WebElement getClearBridgeInvestmentGrid() {
		return clearBridgeInvestmentGrid;
	}

	public WebElement getEnTrustPermalGrid() {
		return enTrustPermalGrid;
	}

	public WebElement getMartinCurrieGrid() {
		return martinCurrieGrid;
	}

	public WebElement getQsInvestorGrid() {
		return qsInvestorGrid;
	}

	public WebElement getRareInfrastructureGrid() {
		return rareInfrastructureGrid;
	}

	public WebElement getRoyceAndAssociatesGrid() {
		return royceAndAssociatesGrid;
	}

	public WebElement getWesternAssetGrid() {
		return westernAssetGrid;
	}
	
	@FindBy(xpath = "//*[contains(@href,'/about-us/who-we-are.html')]")
	private WebElement whoWeAreAUAboutUs;
	
	public WebElement getWhoWeAreAUAboutUs() {
		return whoWeAreAUAboutUs;
	}
	
	@FindBy(xpath = "//*[contains(@href,'/about-us/au-leadership-team.html')]")
	private WebElement auLeadershipTeamAboutUs;
	
	public WebElement getAULeadershipTeamAboutUs() {
		return auLeadershipTeamAboutUs;
	}
	
	@FindBy(xpath = "(//*[contains(@class,'section-container')]//div[@class='headline parbase']//h3)[1]")
	private WebElement keyFactsAboutUsAU;
	
	public WebElement getKeyFactsAboutUsAU() {
		return keyFactsAboutUsAU;
	}
	
	@FindBy(xpath = "//a[contains(@href,'notre-societe.html')]")
	private WebElement aboutUsHeaderFR;
	
	public WebElement getAboutUsHeaderFR() {
		return aboutUsHeaderFR;
	}
	

}
