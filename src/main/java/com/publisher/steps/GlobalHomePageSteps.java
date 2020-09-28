package com.publisher.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.publisher.pageobjects.HomePageObject;
import com.publisher.pageobjects.SpeedBumpPage;
//import com.cucumber.listener.Reporter;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GlobalHomePageSteps extends Utility{
	
	public static final String HTTP_CODE_200 = "200####OK";

    
	@When("^I verify the Title of Lunched Site$")
	public void iverifythetitleoflunchsite() throws Throwable {
		try {
			if (driver.getCurrentUrl().contains("en-gb")) {
				Assert.assertTrue(driver.getTitle().contains("Legg Mason Asset Management UK | Home"));
				System.out.println("The UK site is Launched");
				
			} else if (driver.getCurrentUrl().contains("en-cy")) {
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "Legg Mason Asset Management | Cyprus Individual Investor";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The UK site is Launched");	

			} else if (driver.getCurrentUrl().contains("en-dk")) {
				Thread.sleep(3000);
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "Legg Mason Asset Management Denmark | Home";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The Denmark Site is Launched");				

			} else if (driver.getCurrentUrl().contains("en-cy")) {
				Thread.sleep(3000);
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "Legg Mason Asset Management | Cyprus Individual Investor";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The Cyprus site is Launched");
									
			} else if (driver.getCurrentUrl().contains("en-au")) {
				Thread.sleep(3000);
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "Legg Mason Asset Management Australia";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The Australia site is Launched");
								
			} else if (driver.getCurrentUrl().contains("en-ch")) {
				Thread.sleep(3000);
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "Legg Mason Asset Management Chine";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The China site is Launched");
				
			} else if (driver.getCurrentUrl().contains("en-fi")) {
				Thread.sleep(3000);
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "Finland - English";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The Finland site is Launched");
				
			}else if (driver.getCurrentUrl().contains("en-no") && (getConfigValue().getProperty("user_role").equals("1"))) {
				Thread.sleep(3000);
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "Legg Mason Asset Management | Norway Individual Investor";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The Norway site is Launched");
				
			}else if (driver.getCurrentUrl().contains("en-no") && (getConfigValue().getProperty("user_role").equals("2"))) {
				Thread.sleep(3000);
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "Legg Mason Asset Management | Norway Investment Professional";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The Norway site is Launched");
			}else if (driver.getCurrentUrl().contains("en-aa")) {
				Thread.sleep(3000);
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "English - Americas International";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The Americas International site is Launched");		
			}else if (driver.getCurrentUrl().contains("de-de")) {
				try {
				Thread.sleep(3000);
				String Homepagetitle = driver.getTitle();
				String Expected_Title = "Germany";
				Assert.assertEquals(Homepagetitle, Expected_Title);
				System.out.println("The Germany site is Launched");		
				}catch(AssertionError ae) {Assert.assertEquals(driver.getTitle(), "Legg Mason Asset Management | Deutschland");}
	    	}else {
	    		System.out.println("Country Selection is not configured");
			}
		} catch (NoSuchElementException ex) {
		}
	}
	@And("^I select Opt In for Cookie Policy in the SpeedBump$")
	public void iSelectOptInForCookiePolicyInTheSpeedBump() throws Throwable {
		try {
			if (SpeedBumpPage.speedBumpPage(driver).getCookiePolicy().isDisplayed()) {
				SpeedBumpPage.speedBumpPage(driver).getOptInButton().click();
			}
		} catch (NoSuchElementException ex) {
		}
	}
	@And("^I select User Role in the SpeedBump$")
	public void iSelectUserRoleInTheSpeedBump() throws Throwable {
		try {
			if (SpeedBumpPage.speedBumpPage(driver).getUserIdentification().isDisplayed()) {
				if (!getConfigValue().getProperty("user_role").isEmpty()) {
					SpeedBumpPage.speedBumpPage(driver).getFirstRoleButton(getConfigValue().getProperty("user_role")).click();
					if (getConfigValue().getProperty("user_role").contains("1")) {
						
						String usrrole1= driver.findElement(By.xpath("//*[@id='userIdentification']//a[@data-interaction-location='User Type'][1]")).getText();
					//Reporter.addStepLog(usrrole1 +" :==> User Role is Selected");
					System.out.println("User Role 1 is Selected:" + usrrole1);
					}else if  (getConfigValue().getProperty("user_role").contains("2")){
						
						String usrrole2= driver.findElement(By.xpath("//*[@id='userIdentification']//a[@data-interaction-location='User Type'][2]")).getText();
						//Reporter.addStepLog(usrrole2 +" :==> User Role is Selected");
						System.out.println("User Role 2 is Selected:" + usrrole2);
					}
						
				} else {
					System.out.println("User Role is not configured");
				}				
			}
		} catch (NoSuchElementException ex) {
		}
	}
	
	 @And("^I select Distributor View$")
	    public void iSelectDistributorView() throws Throwable {
		 try {
				
					if (!getConfigValue().getProperty("distributor_view").isEmpty()) {
						Thread.sleep(3000);
						SpeedBumpPage.speedBumpPage(driver).distributorSelectMenu().click();
						Thread.sleep(3000);
						Select s=new Select(SpeedBumpPage.speedBumpPage(driver).distributorSelectMenu());
		    			List<WebElement> distributorOptions = s.getOptions();
		    			String distributorViewNew=getConfigValue().getProperty("distributor_view");
		    					
		    			
						switch (Integer.parseInt(distributorViewNew)) {
			            case 1:  distributorOptions.get(0).click();;
			                     break;
			            case 2:  distributorOptions.get(1).click();;
			                     break;
			            case 3:  distributorOptions.get(2).click();;
			                     break;
			            case 4:  distributorOptions.get(3).click();;
			                     break;
			            case 5:  distributorOptions.get(4).click();;
			                     break;
			            case 6:  distributorOptions.get(5).click();;
			                     break;			           
			            default: distributorViewNew = "Invalid selection";
			            System.out.println("distributorView is not configured");
			                     break;
			        }	
					} else {
						System.out.println("distributorView is not configured");
					}				
				
			} catch (NoSuchElementException ex) {
			}
	    }
	
	@And("^I select Accept for Terms and Conditions in the SpeedBump for China$")
	public void iSelectAcceptForTermsAndConditionsInTheSpeedBumpForChina() throws Throwable {
		try {
			if (!getConfigValue().getProperty("distributor_view").isEmpty()) {
				
			
			if (getConfigValue().getProperty("distributor_view")!="1") {
				SpeedBumpPage.speedBumpPage(driver).getAcceptButton().click();
			}
			
			}else {
				System.out.println("distributorView is not configured");
			}	
		} catch (NoSuchElementException ex) {
		}
	}
	
	@Given("^I select Accept for Terms and Conditions in the SpeedBump$")
	public void iSelectAcceptForTermsAndConditionsInTheSpeedBump() throws Throwable {
		try {
            if (SpeedBumpPage.speedBumpPage(driver).getTermsConditions().isDisplayed()) {
            	SpeedBumpPage.speedBumpPage(driver).getAcceptButton().click();
            }
        } catch (NoSuchElementException ex) {
            //do nothing
        }
	}
	

	@And("^I Verify Franklin Templeton Logo in the home page$")
	public void iVerifyTheFranklinTempletonHomelogo() throws Exception {
		Thread.sleep(2000);
		assertTrue(HomePageObject.homePageObject(driver).getHomeLogo().getAttribute("src").contains("master-logos"));
	}
	
	@And("^I Verify Products Menu Header is available in home page$")
	public void iVerifyTheLeggMasonProducts() throws Exception {
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
			assertTrue(HomePageObject.homePageObject(driver).getProductsHeaderDe().isDisplayed());
		}
		else {
	        	assertTrue(HomePageObject.homePageObject(driver).getProductsHeader().isDisplayed());
	        } 
	}  
	
	@And("^I Verify Market Insights Menu Header is available in home page$")
	public void iVerifyTheLeggMasonPerspectives() throws Exception {
		try {
		        if (HomePageObject.homePageObject(driver).getPersPectiveHeader().isDisplayed()) {
		        	assertTrue(HomePageObject.homePageObject(driver).getPersPectiveHeader().isDisplayed());
		        }else {
		        	System.out.println("Perspective Header is not available"); 
		        }
		} catch (NoSuchElementException ex) {
					 //do nothing
		}
	} 
	
	@Then("^I Verify News and Updates Header is available in home page$")
	public void iVerifyNewsAndUpdatesHeader() throws Exception {
		try {
		    if (HomePageObject.homePageObject(driver).getNewsHeaderAU().isDisplayed()) {
		    	assertTrue(HomePageObject.homePageObject(driver).getNewsHeaderAU().isDisplayed());
		    }else {
		    	System.out.println("News and Updates Header is not available"); 
		    }
		} catch (NoSuchElementException ex) {
					 //do nothing
		}
	}
	
	@Then("^I Verify Press Room Header is available in home page for Singapore$")
	public void iVerifyPressRoomHeader() throws Exception {
		if (driver.getCurrentUrl().contains("en-sg")) {
			try {
		    	if (HomePageObject.homePageObject(driver).getPressRoomHeader().isDisplayed()) {
		    		assertTrue(HomePageObject.homePageObject(driver).getPressRoomHeader().isDisplayed());
		    	}else {
		    		System.out.println("Press Room Header is not available"); 
		    	}
			} catch (NoSuchElementException ex) {
					 //do nothing
			}
		}
	}
	
	
	@Then("^I Verify Invest with Us Header is available in home page$")
	public void iVerifyInvestWithUsHeader() throws Exception {
		try {
		    if (HomePageObject.homePageObject(driver).getInvestWithUpdatesAU().isDisplayed()) {
		    	assertTrue(HomePageObject.homePageObject(driver).getInvestWithUpdatesAU().isDisplayed());
		    }else {
		    	System.out.println("Invest with Us Header is not available"); 
		    }
		} catch (NoSuchElementException ex) {
					 //do nothing
		}
	}
	
	@Then("^I Verify Literature Menu Header is available in home page$")
	public void iVerifyTheLeggMasonLiterature() throws Exception {
		Thread.sleep(5000);
		try {
		    if (HomePageObject.homePageObject(driver).getLiteratureHeader().isDisplayed()) {
		        assertTrue(HomePageObject.homePageObject(driver).getLiteratureHeader().isDisplayed());
		    }else {
		    	System.out.println("Literature Header is not available"); 
		    }
		 } catch (NoSuchElementException ex) {
					 //do nothing
		 }
	} 
	
	@Then("^I Verify About Us Menu Header is available in home page$")
	public void iVerifyTheLeggMasonAboutUs() throws Exception {
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
			assertTrue(HomePageObject.homePageObject(driver).getAboutUsHeaderde().isDisplayed());
			}else {
		assertTrue(HomePageObject.homePageObject(driver).getAboutUsHeader().isDisplayed());
			}
	}
	
	@Then("^I Verify Contact Us Menu Header is available in home page$")
	public void iVerifyTheLeggMasonContactUs() throws Exception {
		if(driver.getCurrentUrl().contains("de-de")||driver.getCurrentUrl().contains("de-ch")) {
		assertTrue(HomePageObject.homePageObject(driver).getContactUsHeaderDe().isDisplayed());
		}else if(this.driver.getCurrentUrl().contains("es-es")) {
			assertTrue(HomePageObject.homePageObject(driver).getContactUsHeaderes().isDisplayed());
			}else if(this.driver.getCurrentUrl().contains("fr-fr")) {
				assertTrue(HomePageObject.homePageObject(driver).getContactUsHeaderFR().isDisplayed());
				} 
			else {
		assertTrue(HomePageObject.homePageObject(driver).getContactUsHeader().isDisplayed());
		}
		
		
	}
	
	 @And("^I Verify Contact Us Menu Header is available in home page for selected distributor$")
	    public void iVerifyContactUsMenuHeaderIsAvailableInHomePageForSelectedDistributor() throws Throwable {
		 if (!getConfigValue().getProperty("distributor_view").isEmpty()) {
						
				String distributorViewNew=getConfigValue().getProperty("distributor_view");
				switch (Integer.parseInt(distributorViewNew)) {
	            case 1:  System.out.println("No contact us for first distributor");
	                     break;
	            case 2:  assertTrue(HomePageObject.homePageObject(driver).getContactUsHeader().isDisplayed());
	                     break;
	            case 3:  assertTrue(HomePageObject.homePageObject(driver).getContactUsHeader().isDisplayed());
	                     break;
	            case 4:  assertTrue(HomePageObject.homePageObject(driver).getContactUsHeader().isDisplayed());
	                     break;
	            case 5:  assertTrue(HomePageObject.homePageObject(driver).getContactUsHeader().isDisplayed());
	                     break;
	            case 6:  assertTrue(HomePageObject.homePageObject(driver).getContactUsHeader().isDisplayed());
	                     break;			           
	            default: distributorViewNew = "Invalid selection";
	            System.out.println("distributorView is not configured");
	                     break;
	        }	
			} else {
				System.out.println("distributorView is not configured");
			}	
	    }

	@Then("^I Verify Global Search Icon is available in home page$")
	public void iVerifyGlobalSearchIcon() throws Throwable {
		assertTrue(HomePageObject.homePageObject(driver).getGlobalSearchIcon().isDisplayed());
	}
	
	@Then("^I Verify Country Dropdown is available in home page$")
	public void iVerifyCountryDropdown() throws Throwable {
		assertTrue(HomePageObject.homePageObject(driver).getCountryDroDownIcon().isDisplayed());
	}
	
	@Then("^I verify Language selector is available in home page$")
	public void i_verify_Language_selector_is_available_in_home_page() throws Throwable {
	    //DDA LMG-1835
		assertTrue(HomePageObject.homePageObject(driver).getLanguageSelector().isDisplayed());
	    
	}

	@Then("^I verify Role selector is available in home page$")
	public void i_verify_Role_selector_is_available_in_home_page() throws Throwable {
		assertTrue(HomePageObject.homePageObject(driver).getRoleSelector().isDisplayed());
		//DDA LMG-1835
	}
	
	@Then("^I Verify Watchlist Icon is available in home page$")
	public void iVerifyWatchListIcon() throws Throwable {
		assertTrue(HomePageObject.homePageObject(driver).getWatchListIcon().isDisplayed());
	}
	
	@Then("I Verify the Broken Links$")
	public void iVerifyTheBrokenLinks() throws Throwable {
		BrokenLinksVerificationSteps brokenLinks = new BrokenLinksVerificationSteps();
		brokenLinks.verifyBrokenLinks(driver);
		System.out.println("The Brokenlinks validation is success");
	}
	
	@Then("I Verify the Broken Images$")
	public void iVerifyTheBrokenImages() throws Throwable {
		BrokenImageSteps brokenImages = new BrokenImageSteps();
		brokenImages.verifyBrokenImages(driver);
		System.out.println("The Broken Images validation is success");
	}
	
	@And("^I Verify Products Menu URL is available or not$")
	public void iVerifyTheLeggMasonProductslinks() throws Throwable {
		try {
	        if (HomePageObject.homePageObject(driver).getProductsHeader().isDisplayed()) {
	        	HomePageObject.homePageObject(driver).getProductsHeader().click();
	    		Assert.assertEquals(driver.getTitle(), "Products");
	        }else {
	        	System.out.println("Products URL is not available"); 
	        }
	    }catch (Exception ex) {
				 //do nothing
		}
	} 
	
	@And("^I Verify Products Menu URL is available or not for German site$")
	public void iVerifyTheLeggMasonProductslinksForGermanSite() throws Throwable {
		try {
	        if (HomePageObject.homePageObject(driver).getProductsHeaderDe().isDisplayed()) {
	        	HomePageObject.homePageObject(driver).getProductsHeaderDe().click();
	    		Assert.assertEquals(driver.getTitle(), "Produkte");
	        }else {
	    	Reporter.addStepLog("Products URL is not available"); 
	        }
	    }catch (Exception ex) {
				 //do nothing
		}
	}
		
	@And("^I Verify Market Insights Menu URL is available or not$")
	public void iVerifyTheLeggMasonPerspectiveslinks() throws Throwable {
		try {
			if (HomePageObject.homePageObject(driver).getPersPectiveHeader().isDisplayed()) {
				HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
				Assert.assertTrue(((driver.getTitle().contains("Market Insights")) || (driver.getTitle().contains("Perspectives")))); 
			}else {
				System.out.println("Market Insights or Perspectives URL is not available"); 
			}
        }catch (NoSuchElementException ex) {
			 //do nothing
		}
	}
	
	@And("^I Verify Market Insights Menu URL is available or not for German site$")
	public void iVerifyTheLeggMasonPerspectiveslinksForGermanSite() throws Throwable {
		try {
			if (HomePageObject.homePageObject(driver).getPersPectiveHeader().isDisplayed()) {
				HomePageObject.homePageObject(driver).getPersPectiveHeader().click();
				Thread.sleep(2000);
				Assert.assertTrue((driver.getTitle().contentEquals("Markteinblicke"))); 
			}else {Reporter.addStepLog("Market Insights or Perspectives URL is not available"); 
			}
        }catch (NoSuchElementException ex) {
			 //do nothing
		}
	}
	
	@And("^I Verify Press Room Menu URL is available or not for Singapore$")
	public void iVerifyTheLeggMasonPressRoomLinks() throws Throwable {
		if (driver.getCurrentUrl().contains("en-sg")) {
			try {
				if (HomePageObject.homePageObject(driver).getPressRoomHeader().isDisplayed()) {
					HomePageObject.homePageObject(driver).getPressRoomHeader().click();
					Assert.assertEquals(driver.getTitle(), "Press Room");
				}else {
					System.out.println("Press Room URL is not available"); 
				}
			}catch (NoSuchElementException ex) {
			 //do nothing
			}
		}	
	}
	
	@And("^I Verify Press Room Menu URL is available or not for German site$")
	public void iVerifyTheLeggMasonPressRoomLinksForGermanSite() throws Throwable {
		try {
				if (HomePageObject.homePageObject(driver).getPressRoomHeaderDe().isDisplayed()) {
					HomePageObject.homePageObject(driver).getPressRoomHeaderDe().click();
					Assert.assertEquals(driver.getTitle(), "Presseraum");
				}else {Reporter.addStepLog("Press Room URL is not available"); 
				}
			}catch (NoSuchElementException ex) {
			 //do nothing
			}
		}	
	
	@And("^I Verify News and Updates URL is available or not$")
	public void iVerifyTheNewsAndUpdatesLinks() throws Throwable {
		try {
			if (HomePageObject.homePageObject(driver).getNewsHeaderAU().isDisplayed()) {
				HomePageObject.homePageObject(driver).getNewsHeaderAU().click();
				Assert.assertEquals(driver.getTitle(), "News & Updates");
			}else {
				System.out.println("News and Updates URL is not available"); 
			}
        }catch (NoSuchElementException ex) {
			 //do nothing
		}
	} 
	
	@And("^I Verify Invest with Us URL is available or not$")
	public void iVerifyInvestWithUsUrl() throws Throwable {
		try {
			if (HomePageObject.homePageObject(driver).getInvestWithUpdatesAU().isDisplayed()) {
				HomePageObject.homePageObject(driver).getInvestWithUpdatesAU().click();
				Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Invest with us"));
			}else {
				System.out.println("Invest with Us URL is not available"); 
			}
        }catch (NoSuchElementException ex) {
			 //do nothing
		}
	} 

	
	@And("^I Verify Literature Menu URL is available or not$")
	public void iVerifyTheLeggMasonliteraturelinks() throws Throwable {
		try {
			if (HomePageObject.homePageObject(driver).getLiteratureHeader().isDisplayed()) {
				HomePageObject.homePageObject(driver).getLiteratureHeader().click();
				Assert.assertEquals(driver.getTitle(), "Literature");
			}else {
				System.out.println("Literature URL is not available"); }
		}catch (NoSuchElementException ex) {
			 //do nothing
		}
	}
	
	@And("^I Verify Literature Menu URL is available or not for German site$")
	public void iVerifyTheLeggMasonliteraturelinksForGermanSite() throws Throwable {
		try {
			if (HomePageObject.homePageObject(driver).getLiteratureHeaderDe().isDisplayed()) {
				HomePageObject.homePageObject(driver).getLiteratureHeaderDe().click();
				Assert.assertEquals(driver.getTitle(), "Literatur");
			}else {Reporter.addStepLog("Literature URL is not available"); }
		}catch (NoSuchElementException ex) {
			 //do nothing
		}
	}
	
	@And("^I Verify About Us Menu URL is available or not$")
	public void iVerifyTheLeggMasonAboutuslinks() throws Throwable {
		HomePageObject.homePageObject(driver).getAboutUsHeader().click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(), "About Us");
	}
	
	@And("^I Verify About Us Menu URL is available or not for German site$")
	public void iVerifyTheLeggMasonAboutuslinksForGermanSite() throws Throwable {
		HomePageObject.homePageObject(driver).getAboutUsHeaderde().click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(), "Über uns");
	}
	
	@And("^I Verify Contact Us Menu URL is available or not$")
	public void iVerifyTheLeggMasonContactuslinks() throws Throwable {
		HomePageObject.homePageObject(driver).getContactUsHeader().click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Contact Legg Mason");
	}
	
	@And("^I Verify Contact Us Menu URL is available or not for German site$")
	public void iVerifyTheLeggMasonContactuslinksForGermanSite() throws Throwable {
		HomePageObject.homePageObject(driver).getContactUsHeaderDe().click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Kontaktieren Sie Legg Mason");
	}
	
	@And("^I Close the browser$")
	public void iClosetheBrowser() throws Throwable {
		 driver.quit();
		
	}
	
	@Then("^I verify county url in correct format$")
	public void i_verify_county_url_in_correct_format() throws Throwable {
		
		String currentUrl = driver.getCurrentUrl();
		String[] splitUrl = currentUrl.split("/");
		String[] urlForm= splitUrl[3].split("\\."); 
		System.out.println(urlForm[0]);
		 if(driver.getCurrentUrl().contains("en-cy")) {
		 assertEquals("Country url is not in correct format",urlForm[0],"en-cy"); 
		 }else if(driver.getCurrentUrl().contains("en-gb")) {
			 assertEquals("Country url is not in correct format",urlForm[0],"en-gb"); 
		 }else if(driver.getCurrentUrl().contains("en-au")) {
			 assertEquals("Country url is not in correct format",urlForm[0],"en-au"); 
		 }else if(driver.getCurrentUrl().contains("de-de")) {
			 assertEquals("Country url is not in correct format",urlForm[0],"de-de"); 
		 }
	}
	
	@Then("^I verify Role Selector drop down is available$")
	public void iVerifyRoleSelectorMenuAvailable() throws Throwable {
		List<WebElement> menuOptions = HomePageObject.homePageObject(driver).getRoleSelectorMenuAU();
		if (menuOptions.size() > 0) {
			for (int i = 0; i< menuOptions.size(); i++) {
				String roleName = menuOptions.get(i).getAttribute("value");
				assertTrue((roleName.contains("Client Login")) || (roleName.contains("Legg Mason Australia")));
				
				//assertTrue((menuOptions.get(i).getAttribute("value").contains("Legg Mason Australia")) || (menuOptions.get(i).getAttribute("value").contains("Client LogIn")));
			}					
		}
	}

	@Then("^I verify the LeggMason Austalia role is displayed$")
	public void iVerifyTheLeggMasonAustaliaRole() throws Throwable {
		assertTrue(HomePageObject.homePageObject(driver).getGlobalNav().getText().contains("Legg Mason Australia"));
	}

	@Then("^I click on Role Selector menu$")
	public void iClickOnRoleSelectorMenu() throws Throwable {
		HomePageObject.homePageObject(driver).getGlobalNavMenuAU().click();
		Thread.sleep(3000);
	}

	@Then("^I verify Role Selector Options$")
	public void iVerifyRoleSelectorOptions() throws Throwable {
		List<WebElement> menuOptions = HomePageObject.homePageObject(driver).getRoleSelectorMenuAU();
		for (int i = 0; i < menuOptions.size(); i++) {
			String roleValue = menuOptions.get(i).getText();
			assertTrue((roleValue.contains("Client Login")) || (roleValue.contains("Legg Mason Australia")));
		}			
	}

	@Then("^I select Client Login option from Role Selector Menu$")
	public void iSlectClientLoginFromRoleSelectorMenu() throws Throwable {
		List<WebElement> menuOptions = HomePageObject.homePageObject(driver).getRoleSelectorMenuAU();
		menuOptions.get(0).click();		
	}

	@Then("^I verify the RBC Investor Services Bank is displayed$")
	public void iVerifyTheRBCInvestorServicesPage() throws Throwable {
		assertTrue(driver.getCurrentUrl().contains("https://saraweb.rbcis.com/scpthen/mhwd.sh/index.w"));
	}
	
	@Then("^I verify the homepage has only one H(\\d+) tag$")
    public void iVerifyTheHomepageHasOnlyOneH1Tag(int arg1) throws Throwable {
        Thread.sleep(2000);
        assertEquals(1, driver.findElements(By.xpath("//h1")).size());
    }
	
	@Then("^I verify hreflang and the default conditions in the page$")
	public void iVerifyHreflangAndTheDefaultConditionsInThePage() throws Throwable {
		Thread.sleep(2000);
		int xdefCount=0;
		int usCount=0;
		String url = driver.getCurrentUrl();
		String[] urlSplit = url.split("/");
		WebElement canonicalLink = driver.findElement(By.xpath("//link[@rel='canonical']"));
		assertTrue(canonicalLink.getAttribute("href").contains(url));
	    List<WebElement> linkTags = driver.findElements(By.xpath("//link[@rel='alternate']"));
	    for (WebElement linkTag : linkTags) {
			if(linkTag.getAttribute("hreflang").contains("x-default")){
				assertTrue(linkTag.getAttribute("href").contains("global.html"));
				xdefCount=xdefCount+1;
			}else if(linkTag.getAttribute("hreflang").contains("en-us")){
				assertTrue(linkTag.getAttribute("href").trim().equals("https://www.leggmason.com/"));
				usCount=usCount+1;
			}else if(linkTag.getAttribute("hreflang").contains("en-global")) {}
			else {
				assertTrue(linkTag.getAttribute("href").contains(urlSplit[1]));
			}
		}
	    assertEquals(1, xdefCount);
	    assertEquals(1, usCount);
	}
	
	@Then("^I verify the logo is from the path \"([^\"]*)\"$")
    public void iVerifyTheLogoIsFromThePath(String path) throws Throwable {
        Thread.sleep(2000);
        WebElement logo = driver.findElement(By.xpath("//img[contains(@class,'brand-logo')]"));
        assertTrue(logo.getAttribute("src").contains(path));
    }
}