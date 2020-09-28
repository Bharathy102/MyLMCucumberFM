package com.publisher.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SpeedBumpPage {
	
	private WebDriver driver;
	static SpeedBumpPage sbp;
	
	public SpeedBumpPage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	 public synchronized static SpeedBumpPage speedBumpPage(WebDriver driver) throws IOException {
		 sbp=null;
		 sbp=new SpeedBumpPage(driver); 
		 return sbp;
	 }

    protected String contentPath;
    protected String pageTitle;

    @FindBy(id = "userIdentification")
    private WebElement userIdentification;

    @FindBy(id = "cookiePolicy")
    private WebElement cookiePolicy;

    @FindBy(id = "termsConditions")
    private WebElement termsConditions;
    
    @FindBy(xpath = "//img[contains(@src,'logo-legg-mason.svg')]")
    private WebElement lmlogo;

    @FindBy(xpath = "//*[contains(@href,'/en-gb/individual-investor/products.html')]")
    private WebElement productheader;
    
    @FindBy(xpath = "//*[contains(@href,'/en-gb/individual-investor/Perspectives.html')]")
    private WebElement marketinsightheader;
    
    @FindBy(xpath = "//*[contains(@href,'/en-gb/individual-investor/literature.html')]")
    private WebElement literatureheader;
    
    @FindBy(xpath = "//*[contains(@href,'/en-gb/individual-investor/contact-us.html')]")
    private WebElement contactusheader;
    
    @FindBy(xpath = "//*[contains(@href,'/en-gb/individual-investor/about-us.html')]")
    private WebElement aboutusheader;
    
    @FindBy(xpath = "//*[@id='desktopSearchTrigger']")
    private WebElement globalsearchicon;
    
    @FindBy(xpath = "//*[@id='navbarLocale']")
    private WebElement countrydropdownicon;
    
    @FindBy(xpath = "//*[contains(@class,'ico-watchlist')]")
    private WebElement watchlisticon;
    
    @FindBy(xpath = "/html/body/footer/div/div[2]/ul[1]/li[1]/span")
    private WebElement countryfooter;
    
    @FindBy(xpath = "//*[contains(@href,'/en-gb/individual-investor/privacy-policy.html')]")
    private WebElement privacypolicyfooter;
    
    @FindBy(xpath = "//*[contains(@href,'/en-gb/individual-investor/cookie-policy.html')]")
    private WebElement cookiepolicyfooter;
    
    @FindBy(xpath = "//*[contains(@href,'/en-gb/individual-investor/terms-and-conditions.html')]")
    private WebElement termsandconditionfooter;
        
    @FindBy(xpath = "//*[contains(@href,'/en-gb/treating-customers-fairly.html')]")
    private WebElement treatingcustomerfairly;
    
    @FindBy(xpath = "//*[contains(@href,'/en-gb/stewardship-policy.html')]")
    private WebElement stewardshipolicy;
    
    @FindBy(xpath = "//*[contains(@href,'modern-slavery-statement.pdf')]")
    private WebElement modernslaverystatement;
    
    @FindBy(xpath = "//*[contains(@href,'/content/dam/legg-mason/documents/en/regulatory-documents/letters-and-notices/terms-of-business-platform-users.pdf')]")
    private WebElement termsofbusiness;
    
    @FindBy(xpath = "//*[contains(@href,'https://twitter.com/leggmason')]")
    private WebElement twitterfooter;
    
    @FindBy(xpath = "//*[contains(@href,'http://www.linkedin.com/company/leggmason')]")
    private WebElement linkedinfooter;
    
    @FindBy(xpath = "//*[contains(@href,'http://www.youtube.com/user/leggmason')]")
    private WebElement youtubefooter;
        
   
    public String getContentPath() {
        return contentPath;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public WebElement getUserIdentification() {
        return userIdentification;
    }

    public WebElement getCookiePolicy() {
        return cookiePolicy;
    }

    public WebElement getTermsConditions() {
        return termsConditions;
    }

    @FindBy(xpath = "//div[@id='global-nav']//select[@id='role-selector']")
   	private WebElement distributorSelectMenu;
   	
       public WebElement distributorSelectMenu() {
           return distributorSelectMenu;
       }
       
    public WebElement getFirstRoleButton(String userRole) throws Exception {
    	WebDriverWait wait= new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(
        this.getUserIdentification().findElement(By.xpath("//a[@data-interaction-location=\"User Type\"]["+userRole+"]"))));
    }

    public WebElement getUserRole(String userRole) throws Exception {
        return this.getUserIdentification().findElement(By.xpath("//a[@data-interaction-location=\"User Type\"]["+userRole+"]"));
    }
    public WebElement getOptInButton() throws  Exception {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(
        this.getCookiePolicy().findElement(By.xpath("//a[@class='btn btn-speedbump cookie-type ico-checkmark-alt']"))));
    }

    public WebElement getAcceptButton() throws Exception {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(
        this.getTermsConditions().findElement(By.xpath("//a[@class='btn btn-speedbump terms-type ico-checkmark-alt']"))));
    }
    
    
    
    public WebElement getlmlogoheader() {return lmlogo;}       
         
    public WebElement getproductheader() {return productheader;}
        
    public WebElement getmarketinsightheader() {return marketinsightheader;}
    
    public WebElement getliteratureheader() {return literatureheader;}
    
    public WebElement getcontactusheader() {return contactusheader;}
    
    public WebElement getaboutusheader() {return aboutusheader;}
    
    public WebElement getglobalsearchicon() {return globalsearchicon;}
    
    public WebElement getcountrydropdownicon() {return countrydropdownicon;}
    
    public WebElement getWatchListIcon() {return watchlisticon;}
 
    public WebElement getcountryfooter() {return countryfooter;}
    
    public WebElement getprivacypolicyfooter() {return privacypolicyfooter;}
    
    public WebElement getcookiepolicyfooter() {return cookiepolicyfooter;}
    
    public WebElement gettermsandconditionfooter() {return termsandconditionfooter;}
    
    public WebElement gettreatingcustomerfairly() {return treatingcustomerfairly;}
    
    public WebElement getstewardshipolicy() {return stewardshipolicy;}
    
    public WebElement getmodernslaverystatement() {return modernslaverystatement;}
    
    public WebElement gettermsofbusiness() {return termsofbusiness;}
    
    public WebElement gettwitterfooter() {return twitterfooter;}
    
    public WebElement getlinkedinfooter() {return linkedinfooter;}
    
    public WebElement getyoutubefootern() {return youtubefooter;}
      
}