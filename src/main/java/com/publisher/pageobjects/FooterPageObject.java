package com.publisher.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPageObject {

	protected String contentPath;
	protected String pageTitle;
	private static FooterPageObject footer;
	private WebDriver driver;
	
	private FooterPageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static FooterPageObject footerPageObject(WebDriver driver) throws IOException {
		footer=null;
		footer=new FooterPageObject(driver);
			return footer; 
	}

	@FindBy(xpath = "//*[contains(@class,'nav-item country')]/span")
	private WebElement countryFooter;

	@FindBy(xpath = "//*[contains(@href,'privacy-policy.html')]")
	private WebElement privacyPolicy;

	@FindBy(xpath = "//*[contains(@href,'cookie-policy.html')]")
	private WebElement cookiePolicy;

	@FindBy(xpath = "//*[contains(@href,'terms-and-conditions.html')]")
	private WebElement termsandConditions;

	@FindBy(xpath = "//*[contains(@href,'stewardship-policy.html')]")
	private WebElement stewardShip;

	@FindBy(xpath = "//*[contains(@href,'treating-customers-fairly.html')]")
	private WebElement treatingcutomerFairly;

	@FindBy(xpath = "//*[contains(@href,'modern-slavery-statement.pdf')]")
	private WebElement modernSlavery;

	@FindBy(xpath = "//*[class='nav-item']|//*[contains(@href,'/letters-and-notices/terms-of-business-platform-users.pdf')]")
	private WebElement termsofBusiness;

	@FindBy(xpath = "//*[@class='navbar-nav ml-auto list-inline copyright']/li")
	private WebElement copyrights;

	@FindBy(xpath = "//*[contains(@href,'https://twitter.com/leggmason')]")
	private WebElement twitter;

	@FindBy(xpath = "//*[contains(@href,'http://www.linkedin.com/company/leggmason')]")
	private WebElement linkedln;

	@FindBy(xpath = "//*[contains(@href,'http://www.youtube.com/user/leggmason')]")
	private WebElement youTube;

	@FindBy(xpath = "//*[contains(@href,'glossary.html')]")
	private WebElement glossary;

	public WebElement getCountryFooter() {
		return countryFooter;
	}

	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}

	public WebElement getCookiePolicy() {
		return cookiePolicy;
	}

	public WebElement getTermsandConditions() {
		return termsandConditions;
	}

	public WebElement getStewardship() {
		return stewardShip;
	}

	public WebElement getTreatingCutomerFairly() {
		return treatingcutomerFairly;
	}

	public WebElement getModernSlavery() {
		return modernSlavery;
	}

	public WebElement getTermsofBusiness() {
		return termsofBusiness;
	}

	public WebElement getCopyRights() {
		return copyrights;
	}

	public WebElement getTwitter() {
		return twitter;
	}

	public WebElement getLinkedln() {
		return linkedln;
	}

	public WebElement getYouTube() {
		return youTube;
	}

	public WebElement getGlossary() {
		return glossary;
	}
}
