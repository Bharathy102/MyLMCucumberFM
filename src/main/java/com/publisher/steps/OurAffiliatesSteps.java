package com.publisher.steps;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.JavascriptExecutor;
import com.publisher.pageobjects.AffiliatesPageObject;
import cucumber.api.java.en.Then;

public class OurAffiliatesSteps extends Utility{
	

	@Then("^I verify all the affiliates are present or not$")
	public void iVerifyAllTheAffiliatesArePresentorNot() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3500)");
		Thread.sleep(5000);

		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getBrandywineLogo().isDisplayed());
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getClarionPartnersLogo().isDisplayed());
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getClearBridgeInvestmentLogo().isDisplayed());
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getEntrustPermalLogo().isDisplayed());
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getEnMartinCurrieLogo().isDisplayed());
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getQsInvestorsLogo().isDisplayed());
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRareInfrastructureLogo().isDisplayed());
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRoyceandAssociatesLogo().isDisplayed());
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getWesternAssetLogo().isDisplayed());

		}

}
