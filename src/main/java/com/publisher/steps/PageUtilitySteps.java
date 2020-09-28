package com.publisher.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PageUtilitySteps extends Utility{

	
	@And("^I Navigate back to previous screen$")
	public void INavigateBackToPreviousScreen() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	@And("^I Scroll down the page$")
	public void IScrollDownThePage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3500)");
		Thread.sleep(5000);
	}
	
	@And("^I Scroll down the page until \"([^\"]*)\" is visible$")
	public void IScrollDownThePageElementVisible(String text) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[text()='"+text+"']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor)driver).executeScript("scroll(0, -50);");
		Thread.sleep(5000);
	}
	
    @Then("^I scroll to top of page$")
    public void iScrollToTop() {
        ((JavascriptExecutor)driver).executeScript("scroll(0, -250);");
    }	
}
