package com.publisher.pageobjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactUsPageObject {

	static ContactUsPageObject ContactUs;
	private WebDriver driver;

	private ContactUsPageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static ContactUsPageObject contactUsPageObject(WebDriver driver) throws IOException {
		ContactUs=null;
		ContactUs=new ContactUsPageObject(driver);
			return ContactUs; 
	}

	@FindBy(xpath = "//*[contains(@href,'contact-us.html')]")
	private WebElement contactUsHeader;

	public WebElement getContactUsHeader() {
		return contactUsHeader;

	}

	@FindBy(xpath = "//*[contains(@href,'@href,'#iiwkw_0')]")
	private WebElement officeLocationAndAddress;

	public WebElement getOfficeLocationAndAddress() {
		return officeLocationAndAddress;

	}

	@FindBy(xpath = "//*[contains(@href,'#iiwkw_1')]")
	private WebElement generalEnquiriesContactUs;

	public WebElement getGeneralEnquiriesContactUs() {
		return generalEnquiriesContactUs;
	}

	@FindBy(xpath = "//div[@class='formFieldArea']//*[@type='submit']")
	private WebElement submitButtonGeneralEnquiries;

	public WebElement getSubmitButtonGeneralEnquiries() {
		return submitButtonGeneralEnquiries;
	}
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement submitButtonGeneralEnquirie;

	public WebElement getSubmitButtonGeneralEnquirie() {
		return submitButtonGeneralEnquirie;
	}

	@FindBy(xpath = "//*[contains(@href,'#iiwkw_2')]")
	private WebElement salesContactsContactUs;

	public WebElement getSalesContactsContactUs() {
		return salesContactsContactUs;
	}

	@FindBy(xpath = "//*[contains(@href,'#iiwkw_3')]")
	private WebElement clientServicesContactUs;

	public WebElement getClientServicesContactUs() {
		return clientServicesContactUs;
	}

	@FindBy(xpath = "//*[contains(@href,'#iiwkw_4')]")
	private WebElement marketingAndPressContactsContactUs;

	public WebElement getMarketingAndPressContactsContactUs() {
		return marketingAndPressContactsContactUs;
	}

	public WebElement getGeneralEnquiriesFields(String fieldId) {
		return this.driver.findElement(By.xpath("//div[@class='formFieldArea']//*[@id='" + fieldId + "']"));
	}
	public WebElement getGeneralEnquiriesField(String fieldId) {
		return this.driver.findElement(By.xpath("//*[@id='" + fieldId + "']"));
	}
	
	@FindBy(xpath = "//div[@class='formFieldArea']//*[@id='message']")
	private WebElement generalEnquiriesMessage;

	public WebElement getGeneralEnquiriesMessage() {
		return generalEnquiriesMessage;

	}
	@FindBy(xpath = "//div[@class='formFieldArea']//*[@id='sender-email']")
	private WebElement generalEnquiriesEmail;

	public WebElement getGeneralEnquiriesEmail() {
		return generalEnquiriesEmail;
	}
	
	
	@FindBy(xpath = "//*[@id='lastName']")
	private WebElement generalEnquiriesLastName;
	
	public WebElement getGeneralEnquiriesLastName() {
		return generalEnquiriesLastName;
	}

	@FindBy(xpath = "//*[@id='company']")
	private WebElement generalEnquiriesCompany;

	public WebElement getGeneralEnquiriesCompany() {
		return generalEnquiriesCompany;
	}

	@FindBy(xpath = "//*[@id='companyType']")
	private WebElement generalEnquiriesCompanyType;

	public WebElement getGeneralEnquiriesCompanyType() {
		return generalEnquiriesCompanyType;
	}
	
	@FindBy(xpath = "//*[@id='email']")
	private WebElement generalEnquirieEmail;

	public WebElement getGeneralEnquirieEmail() {
		return generalEnquirieEmail;
	}
	
	

	@FindBy(xpath = "//*[@id='message']")
	private WebElement generalEnquiriesMessages;

	public WebElement getGeneralEnquiriesMessages() {
		return generalEnquiriesMessages;

	}
	
	@FindBy(xpath = "//*[@id='messageContactUs']")
	private WebElement contactFormMessages;

	public WebElement getcontactFormMessages() {
		return contactFormMessages;

	}

	@FindBy(xpath = "//*[@id='jobTitle']")
	private WebElement generalEnquiriesJobTitle;

	public WebElement getGeneralEnquiriesJobTitle() {
		return generalEnquiriesJobTitle;

	}

	@FindBy(xpath = "//*[@id=\"contactUs\"]/div/span")
	private WebElement generalEnquiriesConfirmationMessage;

	public WebElement getGeneralEnquiriesConfirmationMessage() {
		return generalEnquiriesConfirmationMessage;

	}

}
