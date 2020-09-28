package com.publisher.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.publisher.pageobjects.ContactUsPageObject;
import com.publisher.pageobjects.HomePageObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ContactUsSteps extends Utility{


	@And("^I click on Contact Us Header in home page$")
	public void iClickOnContactUsHeaderInHomePage() throws Throwable {
		Thread.sleep(5000);
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
			HomePageObject.homePageObject(driver).getContactUsHeaderDe().click();
			}else if(this.driver.getCurrentUrl().contains("es-es")) {
				HomePageObject.homePageObject(driver).getContactUsHeaderes().click();
				}else if(this.driver.getCurrentUrl().contains("fr-fr")) {
					HomePageObject.homePageObject(driver).getContactUsHeaderFR().click();
					}else {
					ContactUsPageObject.contactUsPageObject(driver).getContactUsHeader().click();
			}
	}
	
	@And("^I click on Contact Us Header in home page for selected distributor$")
    public void iClickOnContactUsHeaderInHomePageForSelectedDistributor() throws Throwable {
		Thread.sleep(5000);
		 if (!getConfigValue().getProperty("distributor_view").isEmpty()) {
				
			 if(driver.getCurrentUrl().contains("zh-cn") && (!getConfigValue().getProperty("distributor_view").equalsIgnoreCase("1"))) {
				 String targetelementurl = ContactUsPageObject.contactUsPageObject(driver).getContactUsHeader().getAttribute("href");
			    	String fullurl=driver.getCurrentUrl();
				    String baseUrl[]= fullurl.split("com");
					String rUrl=baseUrl[0]+"com"+targetelementurl;
					driver.get(rUrl);
					Thread.sleep(3000);
					}
				else{
					System.out.println("ContactUs link does not exist");
					}
			    	
				
			} else {
				System.out.println("distributorView is not configured");
			}	
    }

	@And("^I verify the available tabs and section$")
	public void iVerifyTheAvailableTabsAndSection() throws Throwable {

		List<WebElement> contactUsTab = driver.findElements(By.xpath("//*[contains(@class,'list-tabs')]//*[@class='nav-item']"));
		System.out.println("The Total No of available Tabs in Contact Us:" + contactUsTab.size());

		for (int i = 0; i < contactUsTab.size(); i++) {
			contactUsTab = driver.findElements(By.xpath("//*[contains(@class,'list-tabs')]//*[@class='nav-item']"));
			String title = contactUsTab.get(i).getText().trim();
			System.out.println("The Contact Us Tab Title:" + title);

			contactUsTab.get(i).click();
			Thread.sleep(5000);

		}

		
	}

	@Then("^I verify the default highlighted tab and section$")
	public void iVerifyTheDefaultHighlightedTabAndSection() throws Throwable {

		List<WebElement> defaultTab = driver.findElements(
				By.xpath("//*[contains(@class,'list-tabs')]//*[@class='nav-item']//*[@class='nav-link active']"));

		for (int i = 0; i < defaultTab.size(); i++) {
			defaultTab = driver.findElements(
					By.xpath("//*[contains(@class,'list-tabs')]//*[@class='nav-item']//*[@class='nav-link active']"));
			String title = defaultTab.get(i).getText();
			System.out.println("The Default Highlighted Tab :" + title);

		}

	}
	
	@Then("^I verify the Contact Us Form has Unique Fields for DDA / ADA Compliance$")
	public void i_verify_the_Contact_Us_Form_has_Unique_Fields_for_DDA_ADA_Compliance() throws Throwable {
		Thread.sleep(4000);
		if(driver.getCurrentUrl().contains("de-de")){
			driver.findElement(By.xpath("//a[contains(text(),'Generelle Anfragen')]")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesField("firstName").getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesLastName().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompany().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesJobTitle().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquirieEmail().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getcontactFormMessages().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getSubmitButtonGeneralEnquirie().getAttribute("aria-label")!=null);
		}else
		if( driver.getCurrentUrl().contains("en-au")) {
			driver.findElement(By.xpath("//a[contains(text(),'General Enquiries')]")).click();
			driver.findElement(By.xpath("//*[contains(@class,'general-enquiries')]//a/span[text()='Contact us']")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesFields("fromEmail1").getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesFields("inputName").getAttribute("aria-label")!=null);
			
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesMessage().getAttribute("aria-label")!=null);
			
		}else {		
			driver.findElement(By.xpath("//a[contains(text(),'General Enquiries')]")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesField("firstName").getAttribute("aria-label").contains("Please enter your first name"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesLastName().getAttribute("aria-label").contains("Please enter your last name"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompany().getAttribute("aria-label").contains("Please enter your company name"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesJobTitle().getAttribute("aria-label").contains("Please enter your job title"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquirieEmail().getAttribute("aria-label").contains("Please enter your email"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getcontactFormMessages().getAttribute("aria-label").contains("Please enter your message"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getSubmitButtonGeneralEnquirie().getAttribute("aria-label").contains("Submit"));
		}
	}

	@Then("^I verify the General Enquiries component contains a WAI-ARIA attribute for DDA / ADA Compliance$")
	public void i_verify_the_General_Enquiries_component_contains_a_WAI_ARIA_attribute_for_DDA_ADA_Compliance() throws Throwable {
		Thread.sleep(4000);
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")){
			driver.findElement(By.xpath("//a[contains(text(),'Generelle Anfragen')]")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesField("firstName").getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesLastName().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompany().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesJobTitle().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquirieEmail().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getcontactFormMessages().getAttribute("aria-label")!=null);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getSubmitButtonGeneralEnquirie().getAttribute("aria-label")!=null);
		}else if( driver.getCurrentUrl().contains("en-au")) {
			//driver.findElement(By.xpath("//a[contains(text(),'General Enquiries')]")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//*[contains(@class,'general-enquiries')]//a/span[text()='Contact us']")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesFields("sender-email").getAttribute("aria-label").contains("Please enter your email"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesFields("sender-name").getAttribute("aria-label").contains("Please enter your name"));
			
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesMessage().getAttribute("aria-label").contains("Please enter your message"));
			
		}else {		
			driver.findElement(By.xpath("//a[contains(text(),'General Enquiries')]")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesField("firstName").getAttribute("aria-label").contains("Please enter your first name"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesLastName().getAttribute("aria-label").contains("Please enter your last name"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompany().getAttribute("aria-label").contains("Please enter your company name"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesJobTitle().getAttribute("aria-label").contains("Please enter your job title"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquirieEmail().getAttribute("aria-label").contains("Please enter your email"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getcontactFormMessages().getAttribute("aria-label").contains("Please enter your message"));
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getSubmitButtonGeneralEnquirie().getAttribute("aria-label").contains("Submit"));
		}
	}
	@Then("^I verify the General Enquiries fields are present or not$")
	public void iVerifyTheGeneralEnquiriesFieldsArePresentOrNot() throws Throwable {
		Thread.sleep(4000);
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")){
			driver.findElement(By.xpath("//a[contains(text(),'Generelle Anfragen')]")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesField("firstName").isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesLastName().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompany().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompanyType().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesJobTitle().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquirieEmail().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getcontactFormMessages().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getSubmitButtonGeneralEnquirie().isDisplayed());
		}else
		if( driver.getCurrentUrl().contains("en-au")) {
			driver.findElement(By.xpath("//a[contains(text(),'General Enquiries')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[contains(@class,'general-enquiries')]//a/span[text()='Contact us']")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesFields("sender-email").isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesFields("sender-name").isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesFields("subject").isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesMessage().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getSubmitButtonGeneralEnquiries().isDisplayed());
		}else if(this.driver.getCurrentUrl().contains("fr-fr")){
			this.driver.findElement(By.xpath("//a[contains(text(),'Demandes d’ordre général')]")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesField("firstName").isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesLastName().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompany().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompanyType().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesJobTitle().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquirieEmail().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getcontactFormMessages().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getSubmitButtonGeneralEnquirie().isDisplayed());
		}else {		
			driver.findElement(By.xpath("//a[contains(text(),'General Enquiries')]")).click();
			Thread.sleep(3000);
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesField("firstName").isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesLastName().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompany().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompanyType().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesJobTitle().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquirieEmail().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getcontactFormMessages().isDisplayed());
			assertTrue(ContactUsPageObject.contactUsPageObject(driver).getSubmitButtonGeneralEnquirie().isDisplayed());
		}
	}

	@And("^I click on Submit button$")
	public void iClickOnSubmitButton() throws Throwable {
		if (!driver.getCurrentUrl().contains("en-au")) {
			ContactUsPageObject.contactUsPageObject(driver).getSubmitButtonGeneralEnquirie().click();
		}	
	}

	@Then("^I verify the dropdown values in Company Type$")
	public void iVerifyTheDropdownValuesInCompanyType() throws Throwable {
		if (!driver.getCurrentUrl().contains("en-au")) {
			String[] exp = { "Broker / Dealer", "Custodian / Clearing Firm", "Investment Consultant", "Investment Manager",
				"Pensions", "Retail / Private Bank", "Other" };
			WebElement dropdown = driver.findElement(By.id("companyType"));
			Select select = new Select(dropdown);

			List<WebElement> options = select.getOptions();
			for (WebElement we : options) {
				boolean match = false;
				for (int i = 0; i < exp.length; i++) {
					if (we.getText().equals(exp[i])) {
						match = true;
					}
				}
			}
		}
	}

	@And("^I Enter \"(.*)\" in the First Name General Enquiries field$")
	public void iEnterFirstName(String firstName) throws Throwable {

		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesField("firstName").sendKeys(firstName);
		Thread.sleep(3000);

	}

	@And("^I Enter \"(.*)\" in the Last Name field$")
	public void iEnterLastName(String LastName) throws Throwable {

		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesLastName().clear();
		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesLastName().sendKeys(LastName);
		Thread.sleep(3000);

	}

	@And("^I Enter \"([^\"]*)\" in the company field$")
	public void iEnterCompanyName(String Company) throws Throwable {

		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompany().clear();
		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesCompany().sendKeys(Company);
		Thread.sleep(3000);

	}

	@And("^I Select Company Type as Investment Manager$")
	public void iSelectCompnayType() throws Throwable {
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
			Select dropdown = new Select(driver.findElement(By.id("companyType")));
			dropdown.selectByVisibleText("Anlageberater");
			Thread.sleep(3000);
		}else if(driver.getCurrentUrl().contains("fr-fr")) {
			Select dropdown = new Select(driver.findElement(By.id("companyType")));
			dropdown.selectByVisibleText("Conseiller en investissement");
			Thread.sleep(3000);
		}else {
		Select dropdown = new Select(driver.findElement(By.id("companyType")));
		dropdown.selectByVisibleText("Investment Manager");
		Thread.sleep(3000);
		}
	}

	@And("^I Enter \"([^\"]*)\" in the Job title field$")
	public void iEnterJobTitle(String TestEngineer) throws Throwable {

		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesJobTitle().clear();
		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesJobTitle().sendKeys(TestEngineer);
		Thread.sleep(3000);

	}

	@And("^I Enter \"(.*)\" in the email field$")
	public void iEnterEmail(String emailId) throws Throwable {
		if (driver.getCurrentUrl().contains("en-au")) {
		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesEmail().clear();
		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesEmail().sendKeys(emailId);
		Thread.sleep(3000);
		}	else {
			ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquirieEmail().clear();
			ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquirieEmail().sendKeys(emailId);
			Thread.sleep(3000);
		}
	}

	@And("^I Enter \"([^\"]*)\" in the message field$")
	public void iEnterMessage(String message) throws Throwable {
		if (driver.getCurrentUrl().contains("en-au")) {
		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesMessage().clear();
		ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesMessage().sendKeys(message);
		Thread.sleep(3000);
		}	else {
			ContactUsPageObject.contactUsPageObject(driver).getcontactFormMessages().clear();
			ContactUsPageObject.contactUsPageObject(driver).getcontactFormMessages().sendKeys(message);
			Thread.sleep(3000);
		
		}
	}

	@Then("^I verify the Alert message \"([^\"]*)\" on \"([^\"]*)\" field$")
	public void iVerifyTheAlertMessageUK(String message, String fieldId) throws Throwable {
		if (driver.getCurrentUrl().contains("en-au")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement field = ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesFields("sender-email");
			Boolean is_valid = (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
			String uiMessage = (String) js.executeScript("return arguments[0].validationMessage;", field);
			System.out.println("The Required alert Message Is :" + uiMessage);

			assertEquals(message, uiMessage);
		}	else {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement field = ContactUsPageObject.contactUsPageObject(driver).getGeneralEnquiriesField(fieldId);
		Boolean is_valid = (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
		String uiMessage = (String) js.executeScript("return arguments[0].validationMessage;", field);
		System.out.println("The Required alert Message Is :" + uiMessage);

		assertEquals(message, uiMessage);
		}
	}

	@And("^I verify the broken links for ContactUs page$")
	public void iVerifyTheBrokenLinksForContactusPage() throws Throwable {

		BrokenLinksVerificationSteps contactUsBrokenlinkValidation = new BrokenLinksVerificationSteps();
		contactUsBrokenlinkValidation.verifyBrokenLinks(driver);

	}

	@And("^I verify the broken Images for ContactUs$")
	public void iVerifyTheBrokenImageForContactusPage() throws Throwable {

		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);		
		

	}
	
	 @Then("^I verify the broken links for ContactUs page for selected distributor$")
	    public void iVerifyTheBrokenLinksForContactUsPageForSelectedDistributor() throws Throwable {
		 if (!getConfigValue().getProperty("distributor_view").isEmpty()) {
			 BrokenLinksVerificationSteps contactUsBrokenlinkValidation = new BrokenLinksVerificationSteps();
			 String distributorViewVal= getConfigValue().getProperty("distributor_view");
				
				switch (Integer.parseInt(distributorViewVal)) {
	            case 1:  System.out.println("No contact us for first distributor");
	                     break;
	            case 2:  contactUsBrokenlinkValidation.verifyBrokenLinks(driver);
	                     break;
	            case 3:  contactUsBrokenlinkValidation.verifyBrokenLinks(driver);
	                     break;
	            case 4:  contactUsBrokenlinkValidation.verifyBrokenLinks(driver);
	                     break;
	            case 5: contactUsBrokenlinkValidation.verifyBrokenLinks(driver);
	                     break;
	            case 6:  contactUsBrokenlinkValidation.verifyBrokenLinks(driver);
	                     break;			           
	            default: distributorViewVal = "Invalid selection";
	            System.out.println("distributorView is not configured");
	                     break;
	        }	
			} else {
				System.out.println("distributorView is not configured");
			}	

	    }
	
	 @Then("^I verify the broken Images for ContactUs for selected distributor$")
	    public void iVerifyTheBrokenImagesForContactUsForSelectedDistributor() throws Throwable {
		 if (!getConfigValue().getProperty("distributor_view").isEmpty()) {
			 BrokenImageSteps brokenImages = new BrokenImageSteps();
			 		String distributorViewVal= getConfigValue().getProperty("distributor_view");
				
				switch (Integer.parseInt(distributorViewVal)) {
	            case 1:  System.out.println("No contact us for first distributor");
	                     break;
	            case 2:  brokenImages.verifyBrokenImages(driver);
	                     break;
	            case 3:  brokenImages.verifyBrokenImages(driver);
	                     break;
	            case 4:  brokenImages.verifyBrokenImages(driver);
	                     break;
	            case 5: brokenImages.verifyBrokenImages(driver);
	                     break;
	            case 6:  brokenImages.verifyBrokenImages(driver);
	                     break;			           
	            default: distributorViewVal = "Invalid selection";
	            System.out.println("distributorView is not configured");
	                     break;
	        }	
			} else {
				System.out.println("distributorView is not configured");
			}	
	    }

}