package com.publisher.steps;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.publisher.pageobjects.AboutUsPageObject;

//import com.cucumber.listener.Reporter;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AboutUsSteps extends Utility{
	BrokenLinksVerificationSteps brokenLinkObject = new BrokenLinksVerificationSteps();

	@And("^I click on About us in home page$")
	public void iClickOnAboutUsInHomePage() throws Throwable {
		
		Thread.sleep(3000);
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
			//this.robustdriver.visibleElementWait(AboutUsPageObject.aboutUsPageObject().getAboutUsHeader());
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", AboutUsPageObject.aboutUsPageObject(driver).getAboutUsHeaderGermany());
			AboutUsPageObject.aboutUsPageObject(driver).getAboutUsHeaderGermany().click();
		
			Thread.sleep(3000);
			String actualTitle = driver.getTitle();
			String expectedTitle = "Über uns";
			assertEquals(expectedTitle, actualTitle);
			}
		else if(driver.getCurrentUrl().contains("zh-cn") && (getConfigValue().getProperty("distributor_view")=="1")) {
			//this.robustdriver.visibleElementWait(AboutUsPageObject.aboutUsPageObject().getAboutUsHeader());
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", AboutUsPageObject.aboutUsPageObject(driver).getaboutUsHeaderCH());
			AboutUsPageObject.aboutUsPageObject(driver).getaboutUsHeaderCH().click();
		
			Thread.sleep(3000);
			String actualTitle = driver.getTitle();
			String expectedTitle = "关于美盛";
			assertEquals(expectedTitle, actualTitle);
			}
		else if(driver.getCurrentUrl().contains("fr-fr")) {
			//this.robustDriver.visibleElementWait(this.aboutuspageobject.getAboutUsHeader());
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", AboutUsPageObject.aboutUsPageObject(driver).getAboutUsHeaderFR());
			AboutUsPageObject.aboutUsPageObject(driver).getAboutUsHeaderFR().click();
		
			Thread.sleep(3000);
			String actualTitle = driver.getTitle();
			String expectedTitle = "Notre société";
			assertEquals(expectedTitle, actualTitle);
			}
		else if(driver.getCurrentUrl().contains("zh-cn") && (getConfigValue().getProperty("distributor_view")!="1")) {
			System.out.println("AboutUs link does not exist");
			}else{
		//this.robustdriver.visibleElementWait(AboutUsPageObject.aboutUsPageObject().getAboutUsHeader());
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", AboutUsPageObject.aboutUsPageObject(driver).getAboutUsHeader());
		AboutUsPageObject.aboutUsPageObject(driver).getAboutUsHeader().click();
	
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "About Us";
		assertEquals(expectedTitle, actualTitle);
		}
		
	}
	
	@And("^I click on About us sticky header in home page$")
	public void iClickOnAboutUsStickyInHomePage() throws Throwable {
		Thread.sleep(3000);
		//this.robustdriver.visibleElementWait(AboutUsPageObject.aboutUsPageObject().getAboutUsHeader());
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", AboutUsPageObject.aboutUsPageObject().getAboutUsHeader());
		AboutUsPageObject.aboutUsPageObject(driver).getAboutUsHeaderAA().click();
	
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "About Us";
		assertEquals(expectedTitle, actualTitle);
	}	
	

	@And("^I click on Leadership$")
	public void iClickOnLeadership() throws Throwable {
		Thread.sleep(5000);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
			AboutUsPageObject.aboutUsPageObject(driver).getAboutUsPeopleDe().click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(AboutUsPageObject.aboutUsPageObject(driver).getLeadershipSullivan()));

			String actualTitle = driver.getTitle();
			String expectedTitle = "Unser Vorstand";
			assertEquals(expectedTitle, actualTitle);
		}else if (driver.getCurrentUrl().contains("en-au") || driver.getCurrentUrl().contains("en-sg")) {
			AboutUsPageObject.aboutUsPageObject(driver).getAboutUsPeopleAU().click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(AboutUsPageObject.aboutUsPageObject(driver).getLeadershipSullivan()));

			String actualTitle = driver.getTitle();
			String expectedTitle = "Our People";
			assertEquals(expectedTitle, actualTitle);
			
		}else if(driver.getCurrentUrl().contains("en-lu") || driver.getCurrentUrl().contains("en-aa")){
			AboutUsPageObject.aboutUsPageObject(driver).getAboutUsPeopleLU().click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(AboutUsPageObject.aboutUsPageObject(driver).getLeadershipSullivan()));

			String actualTitle = driver.getTitle();
			String expectedTitle = "Our People";
			assertEquals(expectedTitle, actualTitle);
		}else {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",AboutUsPageObject.aboutUsPageObject(driver).getAboutUsPeople());
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", AboutUsPageObject.aboutUsPageObject(driver).getAboutUsPeople());
			//AboutUsPageObject.aboutUsPageObject().getAboutUsPeople().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(AboutUsPageObject.aboutUsPageObject(driver).getLeadershipSullivan()));

		String actualTitle = driver.getTitle();
		String expectedTitle = "Our People";
		assertEquals(expectedTitle, actualTitle);
		}
	}

	@Then("^I verify Leadership Image Lists$")
	public void iVerifyLeadershipImageLists() throws Throwable {
        Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.xpath("//*[@data-interaction-location='card']//div[@class='card-title']"));
		System.out.println("The Total no of Leadership lists:" + links.size());

		for (int i = 0; i < links.size(); i++) {
			links = driver.findElements(By.xpath("//*[@data-interaction-location='card']//div[@class='card-title']"));
			String title = links.get(i).getText().trim();
			System.out.println("The Actual title:" + title);
			links.get(i).click();
			Thread.sleep(10000);

			String pageTitle = driver.getTitle().trim();
			System.out.println("The Expected Title :" + pageTitle);
			assertTrue(title.contains(pageTitle)||pageTitle.contains(title));

			driver.navigate().back();
			Thread.sleep(7000);
		}
	}

	@And("^I verify the broken links for Leadership page$")
	public void iVerifyTheBrokenLinksForLeadershipPage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@And("^I verify the broken Images for Leadership page$")
	public void iValidateBrokenImageInBrandywineAffiliatePage() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}
	
	 @Then("^I verify the broken links for AboutUs page$")
	    public void iVerifyTheBrokenLinksForAboutUsPage() throws Throwable {
		 BrokenLinksVerificationSteps aboutUsBrokenLinksValidation = new BrokenLinksVerificationSteps();
		 aboutUsBrokenLinksValidation.verifyBrokenLinks(driver);
	    }
	
	 @Then("^I verify the broken Images for AboutUs page$")
	    public void iVerifyTheBrokenImagesForAboutUsPage() throws Throwable {
		 BrokenImageSteps brokenImages = new BrokenImageSteps();
			brokenImages.verifyBrokenImages(driver);
	    }

	@And("^I click on Our Affiliates$")
	public void iClickOnOurAffiliates() throws Throwable {
		Thread.sleep(3000);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		String expectedTitle = null;
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
			wait.until(ExpectedConditions.visibilityOf(AboutUsPageObject.aboutUsPageObject(driver).getAboutUsAffiliateDe()));
			AboutUsPageObject.aboutUsPageObject(driver).getAboutUsAffiliateDe().click();

			String actualTitle = driver.getTitle();
				expectedTitle = "Tochtergesellschaften";
			assertEquals(expectedTitle, actualTitle);
			

		}else {
			wait.until(ExpectedConditions.visibilityOf(AboutUsPageObject.aboutUsPageObject(driver).getAboutUsAffiliate()));
		AboutUsPageObject.aboutUsPageObject(driver).getAboutUsAffiliate().click();

		String actualTitle = driver.getTitle();
		if (driver.getCurrentUrl().contains("en-au")) {
			expectedTitle = "Our Affiliates";
		}else {
			expectedTitle = "Our Affiliates";
		}
		assertEquals(expectedTitle, actualTitle);
		}
	}

	@Then("^I verify Affiliates Grids$")
	public void iVerifyAffiliatesGrids() throws Throwable {

		List<WebElement> links = driver.findElements(By.xpath("//*[@data-interaction-location='card']//div[@class='card-title']"));
		System.out.println("The Total no of Affiliates Grids:" + links.size());
        int length = links.size();
		for (int i = 0; i < length; i++) {
			
			links = driver
					.findElements(By.xpath("//*[@data-interaction-location='card']//div[@class='card-title']"));
			Thread.sleep(3000);
			System.out.println("i =:" + i + " size: " + links.size());
			String title = links.get(i).getText().trim().toLowerCase();
			System.out.println("The Actual Affiliate title:" + title);
			links.get(i).click();
			Thread.sleep(10000);

			String pageTitle = driver.getTitle().trim().toLowerCase();
			System.out.println("The Expected Title :" + pageTitle);
			try {
			assertTrue(title.contains(pageTitle) || pageTitle.contains(title));
			}catch(AssertionError ae) {
				assertTrue(title.contains("rare-infrastruktur") || title.contains("rare infrastructure"));
			}

			driver.navigate().back();
			Thread.sleep(8000);
		
		}
	}

	@And("^I verify the broken links for Affiliates$")
	public void iVerifyTheBrokenLinksForAffiliates() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@And("^I verify the broken Images for Affiliates$")
	public void iVerifyTheBrokenImagesForAffiliates() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}

	@And("^I click Annual Report$")
	public void iClickAnnualReport() throws Throwable {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		if (!driver.getCurrentUrl().contains("en-sg")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOf(AboutUsPageObject.aboutUsPageObject(driver).getAboutUsReport()));
			AboutUsPageObject.aboutUsPageObject(driver).getAboutUsReport().click();
			String actualTitle = driver.getTitle();
			System.out.println("actualTitle: "+ actualTitle);
			String expectedTitle = "Annual Report 2019";
			assertTrue(actualTitle.contains(expectedTitle));
		}
	}

	@Then("^I verify the broken links for Annual Reports$")
	public void iVerifyTheBrokenLinksForAnnualReports() throws Throwable {
		if (!driver.getCurrentUrl().contains("en-sg")) {
			BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
			affiliateBrokenLinksValidation.verifyBrokenLinks(driver);
		}
	}

	@And("^I verify the broken Images for Annual Reports$")
	public void iVerifyTheBrokenImagesForAnnualReports() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}

	@And("^I click on Market Insight in About Us page$")
	public void iClickOnMarketInsight() throws Throwable {

		if (driver.getCurrentUrl().contains("en-gb")) {
			AboutUsPageObject.aboutUsPageObject(driver).getAboutUsMarketInsight().click();
			Thread.sleep(5000);
			String actualTitle = driver.getTitle();
			String expectedTitle = "Market Insights";
			assertEquals(expectedTitle, actualTitle);

		}
	}
	
	@Then("^I click on Who We Are tile from About Us page$")
	public void iClickOnWhoWeAreInAboutUs() throws Throwable {
		AboutUsPageObject.aboutUsPageObject(driver).getWhoWeAreAUAboutUs().click();
		Thread.sleep(5000);
	}

	@Then("^I click on AU Leadership Team from About Us page$")
	public void iClickOnAULeadershipTeamInAboutUs() throws Throwable {
		AboutUsPageObject.aboutUsPageObject(driver).getAULeadershipTeamAboutUs().click();
		Thread.sleep(5000);
	}

	@Then("^I verify Leadership Image Lists for Australia Team$")
	public void iVerifyLeadershipImageListForAuTeams() throws Throwable {
		List<WebElement> links = driver.findElements(By.xpath("//*[@data-interaction-location='card']//div[@class='card-title']"));
		System.out.println("The Total no of Leadership lists:" + links.size());

		for (int i = 0; i < links.size(); i++) {
			links = driver.findElements(By.xpath("//*[@data-interaction-location='card']//div[@class='card-title']"));
			String title = links.get(i).getText().trim();
			System.out.println("The Actual title:" + title);
			links.get(i).click();
			Thread.sleep(5000);

			String pageTitle = driver.getTitle().trim();
			System.out.println("The Expected Title :" + pageTitle);
			if (title.contains("Rino Lupo")) {
				assertTrue(pageTitle.contains("Rino Lupo"));
			} else if (title.contains("Brea McAdie")) {
				assertTrue(pageTitle.contains("Brea"));
			} else if (title.contains("Katrina Densley")) {
				assertTrue(pageTitle.contains("Katrina"));
			} else {
				assertTrue(pageTitle.contains(title));
			}
			driver.navigate().back();
			Thread.sleep(5000);
		}
	}

	@Then("^I verify Key Facts section is present in About Us page$")
	public void iVerifyKeyFactsInAboutUsPage() throws Throwable {
	   assertTrue(AboutUsPageObject.aboutUsPageObject(driver).getKeyFactsAboutUsAU().isDisplayed());
	}
}