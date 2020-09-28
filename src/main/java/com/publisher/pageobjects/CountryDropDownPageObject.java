package com.publisher.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountryDropDownPageObject {

	protected String contentPath;
	protected String pageTitle;
	
	static CountryDropDownPageObject country;
	private WebDriver driver;

	private CountryDropDownPageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static CountryDropDownPageObject countryDropDownPageObject(WebDriver driver) throws IOException {
		country=null;
		country=new CountryDropDownPageObject(driver);
			return country; 
	}
	

	@FindBy(xpath = "//a[@class='btn btn-speedbump cookie-type ico-checkmark-alt']")
	private WebElement OptIn;

	@FindBy(id = "userIdentification")
	private WebElement userIdentification;

	@FindBy(id = "cookiePolicy")
	private WebElement cookiePolicy;

	@FindBy(id = "termsConditions")
	private WebElement termsConditions;

	@FindBy(xpath = "//*[@id=\"navbarLocale\"]")
	private WebElement countryIcon;

	@FindBy(xpath = "//*[@id=\"localeDropdown\"]")
	private WebElement dropdownFrame;

	@FindBy(linkText = "Americas International - English")
	private WebElement americanInternationallinkext;

	@FindBy(xpath = "//img[contains(@src,'usa.svg')]")
	private WebElement americaIcon;

	@FindBy(xpath = "//*[contains(text(),' Australia')]")
	private WebElement ausLinkText;

	@FindBy(xpath = "//img[contains(@src,'australia.svg')]")
	private WebElement ausIcon;

	@FindBy(linkText = "Austria - German")
	private WebElement austriaGermanLinkText;
	
	@FindBy(xpath = "//*[contains(text(),' Österreich')]")
	private WebElement osterreichLinkText;
	@FindBy(xpath = "//img[contains(@alt,'Deutsch')]")
	private WebElement osterreichIcon;
	
	@FindBy(xpath = "//*[contains(text(),' België')]")
	private WebElement belgieNederlandsLinkText;
	@FindBy(xpath = "//img[contains(@alt,'Dutch')]")
	private WebElement belgieNederlandsIcon;
	
	@FindBy(xpath = "//*[contains(text(),' Belgique')]")
	private WebElement belgiefranciesLinkText;
	@FindBy(xpath = "//img[contains(@alt,'Français')]")
	private WebElement belgieFranciesIcon;
	
	@FindBy(xpath = "//img[contains(@src,'austria.svg')]")
	private WebElement austriaGermanIcon;

	@FindBy(linkText = "Belgium - Dutch")
	private WebElement belgiumDutchLinkText;

	@FindBy(xpath = "//img[contains(@alt,'Dutch')]")
	private WebElement belgiumdutchIcon;

	@FindBy(linkText = "Belgium - French")
	private WebElement belgiumFrenchLinkText;

	@FindBy(xpath = "//img[contains(@alt,'Dutch')]")
	private WebElement belfrenchIcon;

	@FindBy(linkText = "China - Chinese")
	private WebElement chinaLinkText;

	@FindBy(xpath = "//img[contains(@src,'china.svg')]")
	private WebElement chinaIcon;

	@FindBy(linkText = "Cyprus - English")
	private WebElement cyprusengLinkText;

	@FindBy(xpath = "//img[contains(@src,'cyprus.svg')]")
	private WebElement cyprusIcon;

	@FindBy(linkText = "Denmark - English")
	private WebElement denmarkengLinkText;

	@FindBy(xpath = "//img[contains(@src,'denmark.svg')]")
	private WebElement denmarkIcon;

	@FindBy(linkText = "Finland - English")
	private WebElement finlandengLinkText;

	@FindBy(xpath = "//img[contains(@src,'finland.svg')]")
	private WebElement finengIcon;

	@FindBy(xpath = "//*[contains(text(),' France')]")
	private WebElement francefrenchLinkText;

	@FindBy(xpath = "//img[contains(@src,'france.svg')]")
	private WebElement franceIcon;

	@FindBy(linkText = "German - German")
	private WebElement germanLinkText;

	@FindBy(xpath = "//img[contains(@src,'germany.svg')]")
	private WebElement germanIcon;

	@FindBy(linkText = "Greece - English")
	private WebElement greeceengLinkText;

	@FindBy(xpath = "//img[contains(@src,'greece.svg')]")
	private WebElement greeceIcon;

	@FindBy(linkText = "Hong Kong - Chinese")
	private WebElement hkchineseLinkText;

	@FindBy(xpath = "//*[@id=\"localeDropdown\"]/div[2]/div/ul/li[13]/a/i/img")
	private WebElement hkchinaIcon;

	@FindBy(linkText = "Hong Kong - English")
	private WebElement hkengLinkText;

	@FindBy(xpath = "//*[@id=\"localeDropdown\"]/div[2]/div/ul/li[14]/a/i/img")
	private WebElement hkengIcon;

	@FindBy(linkText = "Iceland - English")
	private WebElement iceengLinkText;

	@FindBy(xpath = "//img[contains(@src,'iceland.svg')]")
	private WebElement icelandIcon;

	@FindBy(xpath = "//*[contains(text(),' Italia')]")
	private WebElement italitLinkText;

	@FindBy(xpath = "//img[contains(@src,'italy.svg')]")
	private WebElement italyIcon;

	@FindBy(linkText = "Japan - Japanese")
	private WebElement jpLinkText;

	@FindBy(xpath = "//img[contains(@src,'japan.svg')]")
	private WebElement japanIcon;

	@FindBy(linkText = "Luxembourg - English")
	private WebElement luxengLinkText;

	@FindBy(xpath = "//img[contains(@src,'luxembourg.svg')]")
	private WebElement luxIcon;

	@FindBy(linkText = "Malta - English")
	private WebElement maltaengLinkText;

	@FindBy(xpath = "//img[contains(@src,'malta.svg')]")
	private WebElement maltaIcon;

	@FindBy(linkText = "Netherlands - English")
	private WebElement netherlandsengLinkText;

	@FindBy(xpath = "//img[contains(@src,'netherlands.svg')]")
	private WebElement netherlandsIcon;

	@FindBy(linkText = "Norway - English")
	private WebElement norwayengLinkText;

	@FindBy(xpath = "//img[contains(@src,'norway.svg')]")
	private WebElement norwayIcon;

	@FindBy(linkText = "Portugal - English")
	private WebElement portualengLinkText;

	@FindBy(xpath = "//img[contains(@src,'portugal.svg')]")
	private WebElement portugalIcon;

	@FindBy(linkText = "Singapore - English")
	private WebElement singengLinkText;

	@FindBy(xpath = "//img[contains(@src,'singapore.svg')]")
	private WebElement singIcon;

	@FindBy(linkText = "Spain - Spanish")
	private WebElement spainspLinkText;

	@FindBy(xpath = "//img[contains(@src,'spain.svg')]")
	private WebElement spainIcon;

	@FindBy(linkText = "Sweden - English")
	private WebElement swedenengLinkText;

	@FindBy(xpath = "//img[contains(@src,'sweden.svg')]")
	private WebElement swedenIcon;

	@FindBy(linkText = "Switzerland - French")
	private WebElement switzfrenchLinkText;

	@FindBy(xpath = "//*[@id=\"localeDropdown\"]/div[2]/div/ul/li[26]/a/i/img")
	private WebElement switzfrenchIcon;

	@FindBy(linkText = "Switzerland - German")
	private WebElement switzgermanLinkText;

	@FindBy(xpath = "//*[@id=\"localeDropdown\"]/div[2]/div/ul/li[27]/a/i/img")
	private WebElement switzgermanIcon;

	@FindBy(linkText = "Taiwan - Chinese")
	private WebElement taichLinkText;

	@FindBy(xpath = "//img[contains(@src,'taiwan.svg')]")
	private WebElement taiIcon;

	@FindBy(linkText = "United Kingdom - English")
	private WebElement ukengLinkText;

	@FindBy(xpath = "//*[@id=\"localeDropdown\"]/div[2]/div/ul/li[29]/a/i/img")
	private WebElement ukIcon;

	@FindBy(linkText = "US - English")
	private WebElement usengLinkText;

	@FindBy(xpath = "//img[contains(@src,'usa.svg')]")
	private WebElement usIcon;

	public WebElement getUserIdentification() {
		return userIdentification;
	}

	public WebElement getCookiePolicy() {
		return cookiePolicy;
	}

	public WebElement getTermsConditions() {
		return termsConditions;
	}

	public WebElement getCountryIcon() {
		return countryIcon;
	}

	public WebElement getDropdownFrame() {
		return dropdownFrame;
	}

	public WebElement getAmericanInternationalLinkText() {
		return americanInternationallinkext;
	}

	public WebElement getAmericaIcon() {
		return americaIcon;
	}

	public WebElement getAusLinkText() {
		return ausLinkText;
	}

	public WebElement getAusIcon() {
		return ausIcon;
	}

	public WebElement getAustriaGermanLinkText() {
		return austriaGermanLinkText;
	}

	public WebElement getAustriaGermanIcon() {
		return austriaGermanIcon;
	}

	public WebElement getBelgiumDutchLinkText() {
		return belgiumDutchLinkText;
	}

	public WebElement getBelgiumDutchIcon() {
		return belgiumdutchIcon;
	}

	public WebElement getBelgiumFrenchLinkText() {
		return belgiumFrenchLinkText;
	}

	public WebElement getBelFrenchIcon() {
		return belfrenchIcon;
	}

	public WebElement getChinaLinkText() {
		return chinaLinkText;
	}

	public WebElement getChinaIcon() {
		return chinaIcon;
	}

	public WebElement getCyprusEngLinkText() {
		return cyprusengLinkText;
	}

	public WebElement getCyprusIcon() {
		return cyprusIcon;
	}

	public WebElement getDenmarkEngLinkText() {
		return denmarkengLinkText;
	}

	public WebElement getDenmarkIcon() {
		return denmarkIcon;
	}

	public WebElement getFinlandEngLinkText() {
		return finlandengLinkText;
	}

	public WebElement getFinEngIcon() {
		return finengIcon;
	}

	public WebElement getFranceFrenchLinkText() {
		return francefrenchLinkText;
	}

	public WebElement getFranceIcon() {
		return franceIcon;
	}

	public WebElement getGermanLinkText() {
		return germanLinkText;
	}

	public WebElement getGermanIcon() {
		return germanIcon;
	}

	public WebElement getGreeceengLinkText() {
		return greeceengLinkText;
	}

	public WebElement getGreeceIcon() {
		return greeceIcon;
	}

	public WebElement getHkchineseLinkText() {
		return hkchineseLinkText;
	}

	public WebElement getHkchinaIcon() {
		return hkchinaIcon;
	}

	public WebElement getHkengLinkText() {
		return hkengLinkText;
	}

	public WebElement getHkengIcon() {
		return hkengIcon;
	}

	public WebElement getIceengLinkText() {
		return iceengLinkText;
	}

	public WebElement getIcelandIcon() {
		return icelandIcon;
	}

	public WebElement getItalytLinkText() {
		return italitLinkText;

	}

	public WebElement getItalyIcon() {
		return italyIcon;
	}

	public WebElement getJpLinkText() {
		return jpLinkText;
	}

	public WebElement getJapanIcon() {
		return japanIcon;
	}

	public WebElement getLuxengLinkText() {
		return luxengLinkText;
	}

	public WebElement getLuxIcon() {
		return luxIcon;
	}

	public WebElement getMaltaengLinkText() {
		return maltaengLinkText;
	}

	public WebElement getMaltaIcon() {
		return maltaIcon;
	}

	public WebElement getNetherlandsengLinkText() {
		return netherlandsengLinkText;
	}

	public WebElement getNetherlandsIcon() {
		return netherlandsIcon;
	}

	public WebElement getNorwayengLinkText() {
		return norwayengLinkText;
	}

	public WebElement getNorwayIcon() {
		return norwayIcon;
	}

	public WebElement getPortualengLinkText() {
		return portualengLinkText;
	}

	public WebElement getPortugalIcon() {
		return portugalIcon;
	}

	public WebElement getSingengLinkText() {
		return singengLinkText;
	}

	public WebElement getSingIcon() {
		return singIcon;
	}

	public WebElement getSpainspLinkText() {
		return spainspLinkText;
	}

	public WebElement getSpainIcon() {
		return spainIcon;
	}

	public WebElement getSwedenengLinkText() {
		return swedenengLinkText;
	}

	public WebElement getSwedenIcon() {
		return swedenIcon;
	}

	public WebElement getSwitzFrenchLinkText() {
		return switzfrenchLinkText;
	}

	public WebElement getSwitzFrenchIcon() {
		return switzfrenchIcon;
	}

	public WebElement getSwitzGermanLinkText() {
		return switzgermanLinkText;
	}

	public WebElement getSwitzGermanIcon() {
		return switzgermanIcon;
	}

	public WebElement getTaichLinkText() {
		return taichLinkText;
	}

	public WebElement getTaiIcon() {
		return taiIcon;
	}

	public WebElement getUkengLinkText() {
		return ukengLinkText;
	}

	public WebElement getUkIcon() {
		return ukIcon;
	}

	public WebElement getUsengLinkText() {
		return usengLinkText;
	}

	public WebElement getUsIcon() {
		return usIcon;
	}



}
