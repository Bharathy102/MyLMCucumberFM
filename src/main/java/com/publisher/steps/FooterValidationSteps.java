package com.publisher.steps;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.publisher.pageobjects.FooterPageObject;
import cucumber.api.java.en.Then;

public class FooterValidationSteps extends Utility{
	

	@Then("^I verify country footer is present or not$")
	public void iVerifyCountryFooterIsPresentOrNot() throws Throwable {

		assertTrue(FooterPageObject.footerPageObject(driver).getCountryFooter().isDisplayed());

	}

	@Then("^I verify the available footer links$")
	public void iVerifyTheAvailableFooterLinks() throws Throwable {

		List<WebElement> footerlinks = driver.findElements(By.xpath("//*[@class='navbar-nav footer-nav']//li//a"));
		System.out.println("The Total no of footers:" + footerlinks.size());

		for (int i = 0; i < footerlinks.size(); i++) {
			footerlinks = driver.findElements(By.xpath("//*[@class='navbar-nav footer-nav']//li//a"));
			String title = footerlinks.get(i).getText().trim().toLowerCase();
			System.out.println("The Actual footer title:" + title);

			footerlinks.get(i).click();
			Thread.sleep(5000);

			String pageTitle = driver.getTitle().trim().toLowerCase();
			System.out.println("The Expected footer Title :" + pageTitle);
			assertTrue(pageTitle.contains(pageTitle));

			driver.navigate().back();
			Thread.sleep(5000);

		}

	}

	@Then("^I verify copyrights footer validation$")
	public void iVerifyCopyrightsFooterValidation() throws Throwable {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertTrue(FooterPageObject.footerPageObject(driver).getCopyRights().isDisplayed());
		String copyRight = FooterPageObject.footerPageObject(driver).getCopyRights().getText();
		System.out.println("The Actual copyright String:" + copyRight);

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);
		System.out.println("Current Year is : " + now.get(Calendar.YEAR));

		assertTrue(copyRight.contains(String.format("%d", currentYear)));
		// DDA LMG-1837
		String colortext = FooterPageObject.footerPageObject(driver).getCopyRights().getCssValue("color");
		assertTrue(colortext.contains("rgba(255, 255, 255, 1)"));
	}

	@Then("^I verify twitter footer link validation$")
	public void iVerifyTermsOfTwitterFooterLinkValidation() throws Throwable {

		if (driver.getCurrentUrl().contains("en-gb") || driver.getCurrentUrl().contains("en-au")) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			assertTrue(FooterPageObject.footerPageObject(driver).getTwitter().isDisplayed());

		}
	}

	@Then("^I verify linkedln footer link validation$")
	public void iVerifyTermsOfLinkedlnFooterLinkValidation() throws Throwable {

		if (driver.getCurrentUrl().contains("en-gb")) {
			assertTrue(FooterPageObject.footerPageObject(driver).getLinkedln().isDisplayed());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	}

	@Then("^I verify youtube footer link validation$")
	public void iVerifyTermsOfYoutubeFooterLinkValidation() throws Throwable {

		if (driver.getCurrentUrl().contains("en-gb")) {
			assertTrue(FooterPageObject.footerPageObject(driver).getYouTube().isDisplayed());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	}

	@Then("^I verify the broken links for footer page$")
	public void iVerifyTheBrokenLinksForPrivacyPolicy() throws Throwable {

		BrokenLinksVerificationSteps footerPageBrokenLinksVerfication = new BrokenLinksVerificationSteps();
		footerPageBrokenLinksVerfication.verifyBrokenLinks(driver);

	}
}
