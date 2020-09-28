package com.publisher.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CntryDrpDwnPageObject {

	protected String contentPath;
	protected String pageTitle;

	// New Code for country DropDOwn :
	static CntryDrpDwnPageObject countryNew;
	private WebDriver driver;

	private CntryDrpDwnPageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static CntryDrpDwnPageObject cntryDrpDwnPageObject(WebDriver driver) throws IOException {
		countryNew=null;
		countryNew=new CntryDrpDwnPageObject(driver);
			return countryNew; 
	}

	
	
	
	
@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Americas International - English')]")
private WebElement americasInternationalEnglishLinkText;

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Americas International - Englisch')]")
private WebElement americasInternationalEnglishLinkTextDe;

public WebElement getAmericasInternationalEnglishLinkTextDe() {
	return americasInternationalEnglishLinkTextDe;
}


@FindBy(xpath = "(//img[contains(@src,'usa.svg')])[1]")
private WebElement americaIcon;
public WebElement getAmericanInternationalLinkText() {
	return americasInternationalEnglishLinkText;
}
public WebElement getAmericaIcon() {
	return americaIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Australia - English')]")
private WebElement ausEngLinkText;

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Australien - Englisch')]")
private WebElement ausEngLinkTextDe;

public WebElement getAusEngLinkTextDe() {
	return ausEngLinkTextDe;
}

@FindBy(xpath = "//img[contains(@src,'australia.svg')]")
private WebElement ausIcon;
public WebElement getAusLinkText() {
	return ausEngLinkText;
}

public WebElement getAusIcon() {
	return ausIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Austria - German')]")
private WebElement osterreichLinkText;

@FindBy(xpath = "//img[contains(@alt,'Deutsch')]")
private WebElement osterreichIcon;
public WebElement getOsterreichLinkText() {
	return osterreichLinkText;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Österreich - Deutsch')]")
private WebElement osterreichLinkTextDe;

public WebElement getOsterreichLinkTextDe() {
	return osterreichLinkTextDe;
}

public WebElement getOsterreichIcon() {
	return osterreichIcon;
}


@FindBy(xpath = "//*[contains(text(),' Nederlands')]")
private WebElement belgieNederlandsLinkText;
@FindBy(xpath = "//img[contains(@alt,'Dutch')]")
private WebElement belgieNederlandsIcon;

public WebElement getBelgieNederlandsLinkText() {
	return belgieNederlandsLinkText;
}
public WebElement getBelgieNederlandsIcon() {
	return belgieNederlandsIcon;
}
@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Belgium - French')]")
private WebElement belgiefranciesLinkText;
@FindBy(xpath = "//img[contains(@alt,'Français')]")
private WebElement belgieFranciesIcon;
public WebElement getBelgiefranciesLinkText() {
	return belgiefranciesLinkText;
}
public WebElement getBelgieFranciesIcon() {
	return belgieFranciesIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Belgien - Französisch')]")
private WebElement belgiefranciesLinkTextDe;

public WebElement getBelgiefranciesLinkTextDe() {
	return belgiefranciesLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' China - Chinese')]")
private WebElement chinaChineseLinkText;

@FindBy(xpath = "//img[contains(@src,'china.svg')]")
private WebElement chinaIcon;
public WebElement getChinaLinkText() {
	return chinaChineseLinkText;
}

public WebElement getChinaIcon() {
	return chinaIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'China - Chinesisch')]")
private WebElement chinaChineseLinkTextDe;

public WebElement getChinaChineseLinkTextDe() {
	return chinaChineseLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Cyprus - English')]")
private WebElement cyorusEnglishLinkText;

@FindBy(xpath = "//img[contains(@src,'cyprus.svg')]")
private WebElement cyprusIcon;
public WebElement getCyprusEngLinkText() {
	return cyorusEnglishLinkText;
}

public WebElement getCyprusIcon() {
	return cyprusIcon;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Zypern - Englisch')]")
private WebElement cyorusEnglishLinkTextDe;

public WebElement getCyorusEnglishLinkTextDe() {
	return cyorusEnglishLinkTextDe;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Denmark - English')]")
private WebElement denmarkEnglishLinkText;
@FindBy(xpath = "//img[contains(@src,'denmark.svg')]")
private WebElement denmarkIcon;
public WebElement getDenmarkEngLinkText() {
	return denmarkEnglishLinkText;
}

public WebElement getDenmarkIcon() {
	return denmarkIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Dänemark - Englisch')]")
private WebElement denmarkEnglishLinkTextDe;

public WebElement getDenmarkEnglishLinkTextDe() {
	return denmarkEnglishLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Finland - English')]")
private WebElement finlandLinkText;
@FindBy(xpath = "//img[contains(@src,'finland.svg')]")
private WebElement finengIcon;
public WebElement getFinlandEngLinkText() {
	return finlandLinkText;
}

public WebElement getFinEngIcon() {
	return finengIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Finnland - Englisch')]")
private WebElement finlandLinkEngTextDe;

public WebElement getFinlandEngLinkTextDe() {
	return finlandLinkEngTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Finnland - Finnisch')]")
private WebElement finlandLinkFinTextDe;

public WebElement getFinlandLinkFinTextDe() {
	return finlandLinkFinTextDe;
}


@FindBy(xpath = "//*[contains(text(),' Suomi - Suomi')]")
private WebElement suomiLinkText;
@FindBy(xpath = "//img[contains(@src,'finland.svg')]")
private WebElement suomiIcon;
public WebElement getSuomiLinkText() {
	return suomiLinkText;
}

public WebElement getSuomiIcon() {
	return suomiIcon;
}
@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' France - French')]")
private WebElement francefranceLinkText;
@FindBy(xpath = "//img[contains(@src,'france.svg')]")
private WebElement franceIcon;

public WebElement getFranceFrenchLinkText() {
	return francefranceLinkText;
}

public WebElement getFranceIcon() {
	return franceIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Frankreich - Französisch')]")
private WebElement francefranceLinkTextDe;

public WebElement getFrancefranceLinkTextDe() {
	return francefranceLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Germany - German')]")
private WebElement deutschLandLinkText;
@FindBy(xpath = "//img[contains(@src,'germany.svg')]")
private WebElement deutschlandIcon;

public WebElement getDeutschlandLinkText() {
	return deutschLandLinkText;
}

public WebElement getDeutschlandIcon() {
	return deutschlandIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Deutschland - Deutsch')]")
private WebElement deutschLandLinkTextDe;

public WebElement getDeutschLandLinkTextDe() {
	return deutschLandLinkTextDe;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Greece - English')]")
private WebElement greeceEnglishLinkText;

@FindBy(xpath = "//img[contains(@src,'greece.svg')]")
private WebElement greeceIcon;


public WebElement getGreeceEnglishLinkText() {
	return greeceEnglishLinkText;
}

public WebElement getGreeceIcon() {
	return greeceIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Griechenland - Englisch')]")
private WebElement greeceEnglishLinkTextDe;

public WebElement getGreeceEnglishLinkTextDe() {
	return greeceEnglishLinkTextDe;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Hong Kong - Chinese')]")
private WebElement hongkongchinseLinkText;

@FindBy(xpath = "//img[contains(@src,'hong-kong.svg')]")
private WebElement hkchinaIcon;

public WebElement getHongkongchinseLinkText() {
	return hongkongchinseLinkText;
}

public WebElement getHkchinaIcon() {
	return hkchinaIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Hongkong - Chinesisch')]")
private WebElement hongkongchinseLinkTextDe;

public WebElement getHongkongchinseLinkTextDe() {
	return hongkongchinseLinkTextDe;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Hong Kong - English')]")
private WebElement hongKongEnglishLinkText;

@FindBy(xpath = "//img[contains(@src,'hong-kong.svg')]")
private WebElement hkengIcon;

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Hongkong - Englisch')]")
private WebElement hongKongEnglishLinkTextDe;

public WebElement getHongKongEnglishLinkTextDe() {
	return hongKongEnglishLinkTextDe;
}

public WebElement getHongKongEnglishLinkText() {
	return hongKongEnglishLinkText;
}

public WebElement getHkengIcon() {
	return hkengIcon;
}
@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Iceland - English')]")
private WebElement icelandEnglishLinkText;

@FindBy(xpath = "//img[contains(@src,'iceland.svg')]")
private WebElement icelandIcon;



public WebElement getIcelandEnglishLinkText() {
	return icelandEnglishLinkText;
}

public WebElement getIcelandIcon() {
	return icelandIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Island - Englisch')]")
private WebElement icelandEnglishLinkTextDe;

public WebElement getIcelandEnglishLinkTextDe() {
	return icelandEnglishLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Italy - Italian')]")
private WebElement italitLinkText;

@FindBy(xpath = "//img[contains(@src,'italy.svg')]")
private WebElement italyIcon;
public WebElement getItalytLinkText() {
	return italitLinkText;

}

public WebElement getItalyIcon() {
	return italyIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Ireland - English')]")
private WebElement ireEngLinkTextDe;

public WebElement getIreEngLinkTextDe() {
	return ireEngLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Italien - Italienisch')]")
private WebElement italitLinkTextDe;

public WebElement getItalitLinkTextDe() {
	return italitLinkTextDe;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Japan - Japanese')]")
private WebElement japaneaseLinkText;
@FindBy(xpath = "//img[contains(@src,'japan.svg')]")
private WebElement japanIcon;


public WebElement getJpLinkText() {
	return japaneaseLinkText;
}

public WebElement getJapanIcon() {
	return japanIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Japan - Japanisch')]")
private WebElement japaneaseLinkTextDe;

public WebElement getJapaneaseLinkTextDe() {
	return japaneaseLinkTextDe;
}
@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Luxembourg - English')]")
private WebElement luxeEngLinkText;
@FindBy(xpath = "//img[contains(@src,'luxembourg.svg')]")
private WebElement luxIcon;
public WebElement getLuxengLinkText() {
	return luxeEngLinkText;
}

public WebElement getLuxIcon() {
	return luxIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Luxemburg - Englisch')]")
private WebElement luxeEngLinkTextDe;

public WebElement getLuxeEngLinkTextDe() {
	return luxeEngLinkTextDe;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Malta - English')]")
private WebElement maltaEngLinkText;
@FindBy(xpath = "//img[contains(@src,'malta.svg')]")
private WebElement maltaIcon;

public WebElement getMaltaEngLinkText() {
	return maltaEngLinkText;
}

public WebElement getMaltaIcon() {
	return maltaIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Malta - Englisch')]")
private WebElement maltaEngLinkTextDe;

public WebElement getMaltaEngLinkTextDe() {
	return maltaEngLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Netherlands - English')]")
private WebElement NetherEnglishLinkText;

@FindBy(xpath = "//img[contains(@src,'netherlands.svg')]")
private WebElement netherlandsEngIcon;


public WebElement getNetherlandsEngLinkText() {
	return NetherEnglishLinkText;
}

public WebElement getNetherlandsIcon() {
	return netherlandsEngIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Niederlande - Englisch')]")
private WebElement NetherEnglishLinkTextDe;

public WebElement getNetherEnglishLinkTextDe() {
	return NetherEnglishLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Netherlands - Dutch')]")
private WebElement netherlandnederLinkText;
@FindBy(xpath = "//img[contains(@src,'netherlands.svg')]")
private WebElement netherlandsIcon;

public WebElement getnetherlandnederLinkText() {
	return netherlandnederLinkText;
}

public WebElement getnetherlandsIcon() {
	return netherlandsIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Niederlande - Niederländisch')]")
private WebElement netherlandnederLinkTextDe;

public WebElement getNetherlandnederLinkTextDe() {
	return netherlandnederLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Norway - English')]")
private WebElement norwayEnglishLinkText;
@FindBy(xpath = "//img[contains(@src,'norway.svg')]")
private WebElement norwayIcon;

public WebElement getNorwayEnglishLinkText() {
	return norwayEnglishLinkText;
}

public WebElement getNorwayIcon() {
	return norwayIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Nordics - English')]")
private WebElement norwayEnglishLinkTextDe;

public WebElement getNorwayEnglishLinkTextDe() {
	return norwayEnglishLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Norwegen - Englisch')]")
private WebElement norwegenEnglishLinkTextDe;

public WebElement getNorwegenEnglishLinkTextDe() {
	return norwegenEnglishLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Portugal - Portuguese')]")
private WebElement portugalLinkText;
@FindBy(xpath = "//img[contains(@src,'portugal.svg')]")
private WebElement portugalIcon;

public WebElement getPortualengLinkText() {
	return portugalLinkText;
}

public WebElement getPortugalIcon() {
	return portugalIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Portugal - Portugiesisch')]")
private WebElement portugalLinkTextDe;

public WebElement getPortugalLinkTextDe() {
	return portugalLinkTextDe;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Singapore - English')]")
private WebElement singaporeEnglishLinkText;

@FindBy(xpath = "//img[contains(@src,'singapore.svg')]")
private WebElement singIcon;
public WebElement getSingengLinkText() {
	return singaporeEnglishLinkText;
}

public WebElement getSingIcon() {
	return singIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Singapur - Englisch')]")
private WebElement singaporeEnglishLinkTextDe;

public WebElement getSingaporeEnglishLinkTextDe() {
	return singaporeEnglishLinkTextDe;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Spain - Spanish')]")
private WebElement espanaLinkText;

@FindBy(xpath = "//img[contains(@src,'spain.svg')]")
private WebElement espainIcon;


public WebElement getEspainspLinkText() {
	return espanaLinkText;
}

public WebElement getEspainIcon() {
	return espainIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Spanien - Spanisch')]")
private WebElement espanaLinkTextDe;

public WebElement getEspanaLinkTextDe() {
	return espanaLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Sweden - English')]")
private WebElement swedenEngLinkText;

@FindBy(xpath = "//img[contains(@src,'sweden.svg')]")
private WebElement swedenIcon;


public WebElement getSwedenengLinkText() {
	return swedenEngLinkText;
}

public WebElement getSwedenIcon() {
	return swedenIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Schweden - Englisch')]")
private WebElement swedenEngLinkTextDe;

public WebElement getSwedenEngLinkTextDe() {
	return swedenEngLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Switzerland - French')]")
private WebElement susaeFranceLinkText;
@FindBy(xpath = "//img[contains(@src,'switzerland.svg')]")
private WebElement susaeFranceIcon;
public WebElement getSusaeFranceLinkText() {
	return susaeFranceLinkText;
}

public WebElement getSusaeFranceIcon() {
	return susaeFranceIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Schweiz - Französisch')]")
private WebElement susaeFranceLinkTextDe;

public WebElement getSusaeFranceLinkTextDe() {
	return susaeFranceLinkTextDe;
}


@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Switzerland - German')]")
private WebElement schweizLinkText;

@FindBy(xpath = "//img[contains(@src,'switzerland.svg')]")
private WebElement schweizLinkTextIcon;
public WebElement getSchweizLinkText() {
	return schweizLinkText;
}

public WebElement getSchweizLinkTextIcon() {
	return schweizLinkTextIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Schweiz - Deutsch')]")
private WebElement schweizLinkTextDe;

public WebElement getSchweizLinkTextDe() {
	return schweizLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' Taiwan - Chinese')]")
private WebElement taiwanchaineseLinkText;
@FindBy(xpath = "//img[contains(@src,'taiwan.svg')]")
private WebElement taiwanchaineseIcon;
public WebElement getTaiwanchaineseLinkText() {
	return taiwanchaineseLinkText;
}

public WebElement getTaiwanchaineseIcon() {
	return taiwanchaineseIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Taiwan - Chinesisch')]")
private WebElement taiwanchaineseLinkTextDe;

public WebElement getTaiwanchaineseLinkTextDe() {
	return taiwanchaineseLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' United Kingdom')]")
private WebElement ukEnglishLinkText;
@FindBy(xpath = "//img[contains(@src,'united_kingdom.svg')]")
private WebElement ukEnglishIcon;
public WebElement getUKEnglishLinkText() {
	return ukEnglishLinkText;
}

public WebElement getUKEnglishIcon() {
	return ukEnglishIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'Großbritannien')]")
private WebElement ukEnglishLinkTextDe;

public WebElement getUkEnglishLinkTextDe() {
	return ukEnglishLinkTextDe;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,' US - English') or contains(., 'United States - English')]")
private WebElement usEnglishLinkText;
@FindBy(xpath = "//img[contains(@src,'usa.svg')]")
private WebElement usIcon;
public WebElement getUsengLinkText() {
	return usEnglishLinkText;
}

public WebElement getUsIcon() {
	return usIcon;
}

@FindBy(xpath = "//*[@id='localeDropdown']//a[contains(.,'USA')]")
private WebElement usEnglishLinkTextDe;

public WebElement getUsEnglishLinkTextDe() {
	return usEnglishLinkTextDe;
}
}
