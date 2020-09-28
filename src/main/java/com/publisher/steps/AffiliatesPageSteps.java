package com.publisher.steps;

import static org.junit.Assert.assertTrue;
import com.publisher.pageobjects.AffiliatesPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AffiliatesPageSteps extends Utility {

	BrokenLinksVerificationSteps brokenLinkObject = new BrokenLinksVerificationSteps();

	@And("^I click on Brandywine affiliate in home page$")
	public void iClickOnBrandywineAffiliateInHomePage() throws Throwable {
		AffiliatesPageObject.affiliatesPageObject(driver).getBrandywineLogo().click();		
	}

	@Then("^I verify the Brandywine logo$")
	public void iVerifyTheBrandywineLogo() throws Throwable {

		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getBrandywineGlobalPageLogo().isDisplayed());

	}
	
	
	@Then("^I click on browser back button$")
	public void iClickOnBrowserBackButton() throws Throwable {
		driver.navigate().back();
		Thread.sleep(5000);
	}

	@Then("^I verify the broken links in Brandywine Affiliate page$")
	public void iVerifyTheBrokenLinksInBrandywineAffiliatePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@Then("^I validate broken Image in Brandywine affiliate page$")
	public void iValidateBrokenImageInBrandywineAffiliatePage() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}

	@And("^I click on Clarion Partners affiliate in home page$")
	public void iClickOnClarionPartnersAffiliateInHomePage() throws Throwable {
		Thread.sleep(5000);
		CommonMethods.visibleElementWait(AffiliatesPageObject.affiliatesPageObject(driver).getClarionPartnersLogo());
		AffiliatesPageObject.affiliatesPageObject(driver).getClarionPartnersLogo().click();
		Thread.sleep(5000);

	}

	@Then("^I verify the Clarion Partners logo$")
	public void iVerifyTheClarionPartnersLogo() throws Throwable {
		Thread.sleep(5000);
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getClarionPartnersPageLogo().isDisplayed());

	}

	@Then("^I verify the broken links in Clarion Partners Affiliate page$")
	public void iVerifyTheBrokenLinksInClarionPartnersAffiliatePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@Then("^I verify broken Image in Clarion Partners page$")
	public void iVerifyBrokenImageInClarionPartnersPage() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}

	@And("^I click on ClearBridge Investment affiliate in home page$")
	public void iClickOnClearbridgeInvestmentAffiliateInHomePage() throws Throwable {
        
		AffiliatesPageObject.affiliatesPageObject(driver).getClearBridgeInvestmentLogo().click();
		CommonMethods.visibleElementWait(AffiliatesPageObject.affiliatesPageObject(driver).getClearBridgeInvestmentPageLogo());

	}

	@Then("^I verify the ClearBridge Investment logo$")
	public void iVerifyTheClearbridgeInvestmentLogo() throws Throwable {
		Thread.sleep(5000);
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getClearBridgeInvestmentPageLogo().isDisplayed());

	}

	@Then("^I verify the broken links in ClearBridge Investment Affiliate page$")
	public void iVerifyTheBrokenLinksInClearbridgeInvestmentAffiliatePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@Then("^I validate broken Image in ClearBridge Investment page$")
	public void iValidateBrokenImageInClearBridgeInvestmentPage() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}

	@And("^I click EnTrust Permal affiliate in home page$")
	public void iClickEntrustPermalAffiliateInHomePage() throws Throwable {

		CommonMethods.visibleElementWait(AffiliatesPageObject.affiliatesPageObject(driver).getEntrustPermalLogo());
		AffiliatesPageObject.affiliatesPageObject(driver).getEntrustPermalLogo().click();
		CommonMethods.visibleElementWait(AffiliatesPageObject.affiliatesPageObject(driver).getEnTrustPermalPageLogo());

	}

	@Then("^I verify the EnTrust Permal logo$")
	public void iVerifyTheEntrustPermalLogo() throws Throwable {
		Thread.sleep(5000);
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getEnTrustPermalPageLogo().isDisplayed());

	}

	@Then("^I verify the broken links in EnTrust Permal Affiliate page$")
	public void iVerifyTheBrokenLinksInEntrustPermalAffiliatePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@Then("^I validate broken Image in EnTrust Permal page$")
	public void iValidateBrokenImageInEnTrustPermalPage() throws Throwable {
		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);
	}

	@And("^I click Martin Currie affiliate in home page$")
	public void iClickMartinCurrieAffiliateInHomePage() throws Throwable {
		CommonMethods.visibleElementWait(AffiliatesPageObject.affiliatesPageObject(driver).getEnMartinCurrieLogo());
		AffiliatesPageObject.affiliatesPageObject(driver).getEnMartinCurrieLogo().click();
		Thread.sleep(5000);
		//this.robustDriver.visibleElementWait(AffiliatesPageObject.affiliatesPageObject(driver).getMartinCurriePageLogo());
	}

	@Then("^I verify Martin Currie logo$")
	public void iVerifyMartinCurrieLogo() throws Throwable {
		Thread.sleep(5000);
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getMartinCurriePageLogo().isDisplayed());

	}

	@Then("^I verify the broken links in Martin Currie Affiliate page$")
	public void iVerifyTheBrokenLinksInMartinCurrieAffiliatePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@Then("^I validate broken Image in Martin Currie page$")
	public void iValidateBrokenImageInMartinCurriePage() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}

	@And("^I click QS Investors affiliate in home page$")
	public void iClickOnVerifyTheQsInvestorsAffiliateInHomePage() throws Throwable {

		AffiliatesPageObject.affiliatesPageObject(driver).getQsInvestorsLogo().click();
		CommonMethods.visibleElementWait(AffiliatesPageObject.affiliatesPageObject(driver).getQsInvestorsPageLogo());

	}

	@Then("^I verify the QS Investors logo$")
	public void iVerifyTheQsInvestorsLogo() throws Throwable {

		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getQsInvestorsPageLogo().isDisplayed());

	}

	@Then("^I verify the broken links in QS Investors Affiliate page$")
	public void iVerifyTheBrokenLinksInQsInvestorsAffiliatePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@Then("^I validate broken Image in QS Investors page$")
	public void iValidateBrokenImageInQSInvestorsPage() throws Throwable {

		BrokenImageSteps brokenImagesQS = new BrokenImageSteps();
		brokenImagesQS.verifyBrokenImages(driver);

	}

	@And("^I click RARE affiliate in home page$")
	public void iClickRareAffiliateInHomePage() throws Throwable {
		Thread.sleep(5000);
		AffiliatesPageObject.affiliatesPageObject(driver).getRareInfrastructureLogo().click();
				
	}

	@Then("^I verify RARE logo$")
	public void iVerifyRareLogo() throws Throwable {
		Thread.sleep(5000);
		if (driver.getCurrentUrl().contains("en-cy")) {
			assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRareInfrastructurePageLogoCY().isDisplayed());
		} else if (driver.getCurrentUrl().contains("en-no")) {
			assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRareInfrastructurePageLogoCY().isDisplayed());
		} else if (driver.getCurrentUrl().contains("en-gr")) {
			assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRareInfrastructurePageLogoCY().isDisplayed());
		}else if (driver.getCurrentUrl().contains("en-mt")) {
			assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRareInfrastructurePageLogoCY().isDisplayed());
		}else if (driver.getCurrentUrl().contains("en-nl")) {
			assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRareInfrastructurePageLogoCY().isDisplayed());
		}else if (driver.getCurrentUrl().contains("en-lu") || driver.getCurrentUrl().contains("en-dk")) {
			assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRareInfrastructurePageLogoCY().isDisplayed());
		}else {
			assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRarePageLogo().isDisplayed());
		}
	}

	@Then("^I verify the broken links in RARE Affiliate page$")
	public void iVerifyTheBrokenLinksInRareAffiliatePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@Then("^I validate broken Image in RARE page$")
	public void iValidateBrokenImageInRarePage() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}

	@And("^I click Royce Associates affiliate in home page$")
	public void iClickRoyceAssociatesAffiliateInHomePage() throws Throwable {
		
		CommonMethods.visibleElementWait(AffiliatesPageObject.affiliatesPageObject(driver).getRoyceandAssociatesLogo());
		AffiliatesPageObject.affiliatesPageObject(driver).getRoyceandAssociatesLogo().click();
		CommonMethods.visibleElement(AffiliatesPageObject.affiliatesPageObject(driver).getRoyceandAssociatesPageLogo());

	}

	@Then("^I verify Royce Associates logo$")
	public void iVerifyRoyceAssociatesLogo() throws Throwable {
		Thread.sleep(5000);
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getRoyceandAssociatesPageLogo().isDisplayed());

	}

	@Then("^I verify the broken links in Royce Associates Affiliate page$")
	public void iVerifyTheBrokenLinksInRoyceAssociatesAffiliatePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@Then("^I validate broken Image in Royce Associates page$")
	public void iValidateBrokenImageInRoyceAssociatesPage() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}

	@And("^I click Western Asset affiliate in home page$")
	public void iClickWesternAssetAffiliateInHomePage() throws Throwable {
        
		AffiliatesPageObject.affiliatesPageObject(driver).getWesternAssetLogo().click();
		CommonMethods.visibleElementWait(AffiliatesPageObject.affiliatesPageObject(driver).getWesternAssetPageLogo());

	}

	@Then("^I verify Western Asset logo$")
	public void iVerifyWesternAssetLogo() throws Throwable {
		Thread.sleep(5000);
		assertTrue(AffiliatesPageObject.affiliatesPageObject(driver).getWesternAssetPageLogo().isDisplayed());

	}

	@Then("^I verify the broken links in Western Asset Affiliate page$")
	public void iVerifyTheBrokenLinksInWesternAssetAffiliatePage() throws Throwable {

		BrokenLinksVerificationSteps affiliateBrokenLinksValidation = new BrokenLinksVerificationSteps();
		affiliateBrokenLinksValidation.verifyBrokenLinks(driver);

	}

	@Then("^I validate broken Image in Western Asset page$")
	public void iValidateBrokenImageInWesternAssetPage() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);

	}

}
