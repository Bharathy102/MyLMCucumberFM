package com.publisher.steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.publisher.pageobjects.SpeedBumpPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CommonMethods extends Utility{
	private static final Integer CLICKABLE_ELEMENT_WAIT_SEC = 5;

	@Given("^I launch the publisher site$")
	public void iLaunchThePublisherSite() throws Throwable {
		browserSelection();
	}
	

	@And("^I wait for the complete page load$")
	public void iWaitForTheCompletePageLoad() throws Throwable {
		//waitForDocumentLoad();
        //waitForAjaxLoad();
        //waitForDocumentLoad();
		checkPageLoaded();
	}
	
	@And("^I refresh the page$")
    public void iRefreshThePage() throws InterruptedException {
        driver.navigate().refresh();
        waitForDocumentLoad();
        waitForAjaxLoad();
        ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        Thread.sleep(3000);
    }
	
	private void checkPageLoaded() throws InterruptedException {
		for(int i=0; i<=20; i++) {
			Thread.sleep(1000);
			String state = ((JavascriptExecutor)driver).executeScript("return document.readyState").toString();
			if(state.equals("complete")) {
				break;
			}
		}
	}
    
	private void waitForAjaxLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
        return driver.findElements(By.cssSelector(".waiting, .tb-loading")).size() == 0;}});
    }
	
	private void waitForDocumentLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");}});
    } 
	
	public static WebElement clickableElementWait(WebElement element) throws InterruptedException {
        Thread.sleep(CLICKABLE_ELEMENT_WAIT_SEC * 1000);
        WebDriverWait wait= new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
	public static WebElement visibleElementWait(WebElement element) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
	
	 public static WebElement visibleElement(WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, 20);
	     return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	 public static WebElement clickableElement(WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, 20);
	     return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	 
	 @After
	 public void tearDown(Scenario scenario) throws IOException {
	    if(scenario.isFailed()) {
	    	byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	   		scenario.embed(screenshot, "image/png");
	   		scenario.write("Test Page: "+"<a href="+driver.getCurrentUrl()+">Link</a>");
	   	}
	    driver.quit();
	    	
	 }


}
