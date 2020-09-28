package com.publisher.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import com.cucumber.listener.Reporter;

import com.publisher.pageobjects.CntryDrpDwnPageObject;
import com.publisher.pageobjects.CountryDropDownPageObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;

public class CountryDropDownValidationSteps extends Utility {

	public static final String HTTP_CODE_200 = "200####OK";


	@Then("^I verify Country dropdown icon is present or not$")
	public void iVerifyCountryDropdownIconIsPresentOrNot() throws Throwable {

		Thread.sleep(5000);
		assertTrue(CountryDropDownPageObject.countryDropDownPageObject(driver).getCountryIcon().isDisplayed());

	}
	
	@Then("^I verify the country link has underline when mouse hover$")
	public void i_verify_the_country_link_has_underline_when_mouse_hover() throws Throwable {
		//DDA LMG-1845
		String currentUrl = this.driver.getCurrentUrl();
		String[] splitUrl = currentUrl.split("/");
		String[] urlForm= splitUrl[3].split("\\."); 
		String curlForm=urlForm[0];
		System.out.println(curlForm);
		/* below line code has to be enabled if country dropdown not displayed already
		//CountryDropDownPageObject.countryDropDownPageObject(driver).getCountryIcon().click();
		//Thread.sleep(5000);
		*/
		Actions movetocountrylink=new Actions(this.driver);
		WebElement countryLink=this.driver.findElement(By.xpath("//*[@id=\"localeDropdown\"]/div[2]//a[contains(@href,'"+curlForm+"')]"));
		movetocountrylink.moveToElement(countryLink).build().perform();
		System.out.println(countryLink.getCssValue("text-decoration"));
		Thread.sleep(2000);
		if (countryLink.getCssValue("text-decoration").contains("underline")) {
			
			System.out.println("Underline is available");
			assertTrue(countryLink.getCssValue("text-decoration").contains("underline"));
			assertTrue(countryLink.getCssValue("color").contains("rgba(54, 54, 54, 1)"));
		}else {
			System.out.println("Underline is not available"); 
		}
	}

	@Then("^I verify the list of countries available in country dropdown menu list$")
	public void iVerifyTheListOfCountriesAvailableInCountryDropdownMenuList() throws Throwable {
		
		CountryDropDownPageObject.countryDropDownPageObject(driver).getCountryIcon().click();
		Thread.sleep(5000);
		CommonMethods.visibleElement(CountryDropDownPageObject.countryDropDownPageObject(driver).getAmericanInternationalLinkText());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getAmericanInternationalLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getAmericaIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getAusLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getAusIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getOsterreichLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getOsterreichIcon().isDisplayed());
		//assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getBelgieNederlandsLinkText().isDisplayed());
		//assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getBelgieNederlandsIcon().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getBelgiefranciesLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getBelgieFranciesIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getChinaLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getChinaIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getCyprusEngLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getCyprusIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getDenmarkEngLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getDenmarkIcon().isDisplayed());
		
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getFinlandEngLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getFinEngIcon().isDisplayed());
		//assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSuomiLinkText().isDisplayed());
		//assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSuomiIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getFranceFrenchLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getFranceIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getDeutschlandLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getDeutschlandIcon().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getGreeceEnglishLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getGreeceIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getHongkongchinseLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getHkchinaIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getHongKongEnglishLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getHkengIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getIcelandEnglishLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getIcelandIcon().isDisplayed());
		
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getItalytLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getItalyIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getJpLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getJapanIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getLuxengLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getLuxIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getMaltaEngLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getMaltaIcon().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNetherlandsEngLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNetherlandsIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getnetherlandnederLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getnetherlandsIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNorwayEnglishLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNorwayIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getPortualengLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getPortugalIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSingengLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSingIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getEspainspLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getEspainIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSwedenengLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSwedenIcon().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSusaeFranceLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSusaeFranceIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSchweizLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSchweizLinkTextIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getTaiwanchaineseLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getTaiwanchaineseIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getUKEnglishLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getUKEnglishIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getUsengLinkText().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getUsIcon().isDisplayed());
		

	}
	
	@Then("^I verify the list of counries link has underline when hover$")
	public void i_verify_the_list_of_counries_link_has_underline_when_hover() throws Throwable {
		CountryDropDownPageObject.countryDropDownPageObject(driver).getCountryIcon().click();
		Thread.sleep(5000);
		CommonMethods.visibleElement(CountryDropDownPageObject.countryDropDownPageObject(driver).getAmericanInternationalLinkText());
		Actions movetocountrylink=new Actions(this.driver);
		
		movetocountrylink.moveToElement(this.driver.findElement(By.xpath("//*[@id=\"localeDropdown\"]/div[2]/div/ul/li[1]/a"))).build().perform();
		//Thread.sleep(2000);
		if (CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getUKEnglishLinkText().getCssValue("text-decoration").equalsIgnoreCase("underline")) {
		//	assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getAmericanInternationalLinkText().getCssValue("text-decoration").equalsIgnoreCase("underline"));
			System.out.println("Underline is available");
		}else {
			System.out.println("Underline is not available"); 
		}
		
	}
	
	@Then("^I verify the list of countries available in country dropdown menu list for German site$")
	public void iVerifyTheListOfCountriesAvailableInCountryDropdownMenuListForGermanSite() throws Throwable {

		CountryDropDownPageObject.countryDropDownPageObject(driver).getCountryIcon().click();
		Thread.sleep(5000);
		//this.robustDriver.visibleElement(CountryDropDownPageObject.countryDropDownPageObject(driver).getAmericanInternationalLinkText());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getAmericasInternationalEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getAmericaIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getAusEngLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getAusIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getOsterreichLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getOsterreichIcon().isDisplayed());
		//assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getBelgieNederlandsLinkText().isDisplayed());
		//assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getBelgieNederlandsIcon().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getBelgiefranciesLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getBelgieFranciesIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getChinaChineseLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getChinaIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getCyorusEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getCyprusIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getDenmarkEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getDenmarkIcon().isDisplayed());
		
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getFinlandEngLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getFinEngIcon().isDisplayed());
		//assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSuomiLinkText().isDisplayed());
		//assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSuomiIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getFinlandLinkFinTextDe().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getFrancefranceLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getFranceIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getDeutschLandLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getDeutschlandIcon().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getGreeceEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getGreeceIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getHongkongchinseLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getHkchinaIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getHongKongEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getHkengIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getIcelandEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getIcelandIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getIreEngLinkTextDe().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getItalitLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getItalyIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getJapaneaseLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getJapanIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getLuxeEngLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getLuxIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getMaltaEngLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getMaltaIcon().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNetherEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNetherlandsIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNetherlandnederLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getnetherlandsIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNorwayEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNorwayIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getNorwegenEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getPortugalLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getPortugalIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSingaporeEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSingIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getEspanaLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getEspainIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSwedenEngLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSwedenIcon().isDisplayed());
		
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSusaeFranceLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSusaeFranceIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSchweizLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getSchweizLinkTextIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getTaiwanchaineseLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getTaiwanchaineseIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getUkEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getUKEnglishIcon().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getUsEnglishLinkTextDe().isDisplayed());
		assertTrue(CntryDrpDwnPageObject.cntryDrpDwnPageObject(driver).getUsIcon().isDisplayed());
		

	}
	
	

	@Then("^I verify the broken links for Country Dropdown$")
	public void iVerifyTheBrokenLinksForAmericanInternational() throws Throwable {

		BrokenLinksVerificationSteps footerPageBrokenLinksVerfication = new BrokenLinksVerificationSteps();
		footerPageBrokenLinksVerfication.verifyBrokenLinks(driver);

	}
}
