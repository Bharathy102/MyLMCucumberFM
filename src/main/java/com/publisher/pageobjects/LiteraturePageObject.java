package com.publisher.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LiteraturePageObject {

	protected String contentPath;
	protected String pageTitle;
	
	private static LiteraturePageObject literature;
	private WebDriver driver;
	
	private LiteraturePageObject(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static LiteraturePageObject literaturePageObject(WebDriver driver) throws IOException {
		literature=null;
		literature=new LiteraturePageObject(driver);
		return literature; 
	}

	@FindBy(xpath = "//*[contains(@href,'literature.html') or contains(@href, 'product-overview')]")
	private WebElement literatureHeader;
	
	@FindBy(xpath = "//*[contains(@href,'dokumente.html')]")
	private WebElement literatureHeaderDe;
	
	public WebElement getLiteratureHeaderDe() {
		return literatureHeaderDe;
	}

	@FindBy(xpath = "//*[contains(@class,'text-dark-blue')]")
	private WebElement regulatoryDocument;

	public WebElement getliteratureHeader() {
		return literatureHeader;

	}

	public WebElement getregulatoryDocument() {
		return regulatoryDocument;

	}

}
