package com.publisher.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.publisher.steps.CommonMethods;


public class HomePageObject{

	static HomePageObject home;
	private WebDriver driver;

	private HomePageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static HomePageObject homePageObject(WebDriver driver) throws IOException {
		home=null;
		home=new HomePageObject(driver);
			return home; 
	}
	
	@FindBy(xpath = "//img[contains(@class,'brand-logo')]")
	
	private WebElement homePageLogo;
	@FindBy(xpath = "(//*[contains(@href,'products.html') or contains(@href, 'fund-information.html')])[1]")
	
	private WebElement productsHeader;
	
	@FindBy(xpath = "(//*[contains(@href,'produkte.html')])[1]")
	
	private WebElement productsHeaderDe;
	
	@FindBy(xpath = "//*[contains(@href,'perspectives.html')]")
	
	private WebElement persPectviesHeader;
	@FindBy(xpath = "//a[contains(@href,'Perspectives.html') or contains(@href,'perspectives.html')]")
	
	private WebElement persPectvieHeader;
	@FindBy(xpath = "//*[contains(@href,'literature.html') or contains(@href, 'product-overview.html')]")
	
	private WebElement literatureHeader;
	@FindBy(xpath = "//*[contains(@href,'about-us.html') or contains(@href,'about-us0.html') or contains(@href,'about-us1.html') and contains(@class,'nav-link')]")
	
	private WebElement aboutUsHeader;
	@FindBy(xpath = "//*[contains(@href,'contact-us.html')]")
	
	private WebElement contactUsHeader;
	
	@FindBy(xpath = "//*[contains(@href,'ueber-uns.html')]")
	private WebElement aboutUsHeaderde;
	
	@FindBy(xpath="//*[@aria-label=\"Select Language\"]")
	private WebElement languageSelector;
	
	@FindBy(xpath="//*[@aria-label=\"Select Role\"]")
	private WebElement roleSelector;
	
	public WebElement getLanguageSelector() {
		
		return CommonMethods.visibleElement(languageSelector);
	}
	public WebElement getRoleSelector() {
		
		return CommonMethods.visibleElement(roleSelector);
	}
	public WebElement getAboutUsHeaderde() {
		return aboutUsHeaderde;
	}
	
	@FindBy(xpath = "//*[contains(@href,'dokumente.html')]")
	private WebElement literatureHeaderDe;
	
	public WebElement getLiteratureHeaderDe() {
		return literatureHeaderDe;
	}
	
	@FindBy(xpath = "//*[contains(@href,'kontakt.html')]")
	
	private WebElement contactUsHeaderDe;
	
	public WebElement getContactUsHeaderDe() {
		return contactUsHeaderDe;
	}
	
	@FindBy(xpath = "//*[@id='desktopSearch']")
	private WebElement globalSearchIcon;
	@FindBy(xpath = "//*[@id='navbarLocale']")
	private WebElement countryDropDownIcon;
	@FindBy(xpath = "//*[@id='watchlistNav']")
	private WebElement watchListIcon;
	@FindBy(id = "userIdentification")
	private WebElement userIdentification;
	
	public WebElement getUserIdentification() {
		return userIdentification;
	}
	public WebElement getHomeLogo() throws Exception {
		return CommonMethods.clickableElementWait(homePageLogo);
    }
	public WebElement getProductsHeader() throws Exception {
		return CommonMethods.clickableElementWait(productsHeader);
	}
	
	public WebElement getProductsHeaderch() throws Exception {
		return productsHeader;
	}
	
	public WebElement getProductsHeaderDe() throws Exception {
		return CommonMethods.clickableElementWait(productsHeaderDe);
	}
	
	public WebElement getPersPectiveHeader() throws Exception {
		return persPectvieHeader;
	}
	public WebElement getPersPectiveHeaderAU() throws Exception {
		return persPectviesHeader;
	}
	public WebElement getLiteratureHeader() {
		return literatureHeader;
	}
	public WebElement getAboutUsHeader() throws Exception {
		return CommonMethods.clickableElementWait(aboutUsHeader);
	}
	
	public WebElement getContactUsHeader() throws Exception {
		return CommonMethods.clickableElementWait(contactUsHeader);
	}
	public WebElement getGlobalSearchIcon() throws Exception {
		return CommonMethods.clickableElementWait(globalSearchIcon);
	}
	public WebElement getCountryDroDownIcon() throws Exception {
		return CommonMethods.clickableElementWait(countryDropDownIcon);
	}
	public WebElement getWatchListIcon() throws Exception {
		return CommonMethods.clickableElementWait(watchListIcon);
	}
	public WebElement getFirstRoleButton(String userRole) throws Exception {
		return CommonMethods.clickableElementWait(
				this.getUserIdentification().findElement(By.xpath("//a[@data-interaction-location=\"User Type\"]["+userRole+"]")));
	}
	
	@FindBy(xpath = "//*[contains(@href,'/news-updates.html')]")
	private WebElement newsAndUpdatesHeader;
	
	public WebElement getNewsHeaderAU() throws Exception {
		return newsAndUpdatesHeader;
	}
	
	@FindBy(xpath = "//*[contains(@href,'/invest-with-us.html')]")
	private WebElement InvestWithUsHeader;
	
	public WebElement getInvestWithUpdatesAU() throws Exception {
		return InvestWithUsHeader;
	}
	
	@FindBy(xpath = "//div[@id='global-nav']/select/option")
	private List<WebElement> roleSelectorMenuAU;
	
	public List<WebElement> getRoleSelectorMenuAU() throws Exception {
		return roleSelectorMenuAU;
	}
	
	@FindBy(xpath = "//div[@id='global-nav']")
	private WebElement globalNav;
	
	public WebElement getGlobalNav() throws Exception {
		return globalNav;
	}
	
	@FindBy(xpath = "//div[@id='global-nav']/select")
	private WebElement globalNavMenu;
	
	public WebElement getGlobalNavMenuAU() throws Exception {
		return globalNavMenu;
	}
	
	@FindBy(xpath = "//a[contains(@href,'product-overview.html')]")
	private WebElement productsHeaderSG;

	public WebElement getProductsHeaderSG() throws Exception {
		return productsHeaderSG;
	}	
	
	@FindBy(xpath = "//*[contains(@href,'/press.html')]")
	private WebElement pressRoomHeader;
	
	public WebElement getPressRoomHeader() throws Exception {
		return pressRoomHeader;
	}
	
	@FindBy(xpath = "//*[contains(@href,'presseraum.html')]")
	private WebElement pressRoomHeaderDe;
	
	public WebElement getPressRoomHeaderDe() {
		return pressRoomHeaderDe;
	}
	
	@FindBy(xpath = "//a[contains(@href,'nous-contacter')]")
	
	private WebElement contactUsHeaderFR;

	public WebElement getContactUsHeaderFR() {
		return contactUsHeaderFR;
	}
	
	@FindBy(xpath = "//*[contains(@href,'contacto.html')]")
	
	private WebElement contactUsHeaderes;
	
	public WebElement getContactUsHeaderes() {
		return contactUsHeaderes;
	}
	
	@FindBy(xpath = "(//*[contains(@href,'nos-fonds')])[1]")
	private WebElement productsHeaderFR;
	
	public WebElement getProductsHeaderFR() {
		return productsHeaderFR;
	}
}
