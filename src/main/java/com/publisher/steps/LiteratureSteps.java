package com.publisher.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.publisher.pageobjects.LiteraturePageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class LiteratureSteps extends Utility{

	BrokenLinksVerificationSteps brokenLinkObject = new BrokenLinksVerificationSteps();


	@And("^I click Literature header$")
	public void iClickLiteratureHeader() throws Throwable {

		Thread.sleep(5000);
		if(driver.getCurrentUrl().contains("de-de")) {
			LiteraturePageObject.literaturePageObject(driver).getLiteratureHeaderDe().click();
			Thread.sleep(3000);
			String actualTitle = driver.getTitle();
			String expectedTitle = "Literatur";
			assertEquals(expectedTitle, actualTitle);
		}else {
			LiteraturePageObject.literaturePageObject(driver).getliteratureHeader().click();
		Thread.sleep(3000);
		//this.robustDriver.visibleElement(this.literaturepageobject.getregulatoryDocument());
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Literature";
		assertTrue(actualTitle.contains(expectedTitle));
		}
	}

	@Then("^I verify the broken links for Literature page$")
	public void iVerifyTheBrokenLinksForLiteraturePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

}
