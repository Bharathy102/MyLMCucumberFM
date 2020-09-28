package com.publisher.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.publisher.steps.CommonMethods;


public class FiltersPage {
	
	static FiltersPage filters;
	private WebDriver driver;
	
	private FiltersPage(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public synchronized static FiltersPage filtersPage(WebDriver driver) throws IOException {
		filters=null;
		filters=new FiltersPage(driver);
			return filters; 
	}

	
	@FindBy(xpath = "//*[@id='closeFilter']")
	private WebElement filterCloseButton;
	
    public WebElement getFilterCloseButton() {
        return CommonMethods.clickableElement(filterCloseButton);
    }

	@FindBy(xpath = "//*[@class='number-bubble']")
	private WebElement filterBubbleCount;
	
    public WebElement getFilterBubbleCount() {
        return CommonMethods.clickableElement(filterBubbleCount);
    }

	@FindBy(xpath = "//*[@class='clear-filter']")
	private WebElement clearFilterButton;
	
    public WebElement getClearFilterButton() {
        return CommonMethods.clickableElement(clearFilterButton);
    }

	@FindBy(xpath = "//*[@class='filter-selections']")
	private List<WebElement> filterSelectionTiles;
	
    public List<WebElement> getSelectionChips() {
        return filterSelectionTiles;
    }
    
	@FindBy(xpath = "//*[@class='asset-class-fields']")
	private WebElement assetClassFilter;
	
    public WebElement getAssetClassFilter() {
        return CommonMethods.clickableElement(assetClassFilter);
    }

	@FindBy(xpath = "//*[@class=\"inner expanded\"]//*[@class=\"column-wrap\"]")
	private WebElement filterSectionDisplay;
	
	
    public WebElement getSssetCheckBox() {
        return CommonMethods.clickableElement(clearFilterButton);
    }

	@FindBy(xpath = "//*[@class=\"asset-class-fields\"]//*[@class=\"custom-control custom-checkbox\"][1]")
	private WebElement assetCheckBox;
	
	
    public WebElement getAssetCheckBox() {
        return this.driver.findElement(By.xpath("//*[@class='asset-class-fields']//*[@class='custom-control custom-checkbox'][1]"));
    }

	@FindBy(xpath = "//*[@class=\"asset-class-fields\"]//*[@class=\"custom-control custom-checkbox\"][2]")
	private WebElement equityCheckBox;
	
	
    public WebElement getEquityCheckBox() {
        return CommonMethods.clickableElement(equityCheckBox);
    }

	@FindBy(xpath = "//*[@class=\"asset-class-fields\"]//*[@class=\"custom-control custom-checkbox\"][3]")
	private WebElement fixedIncomeCheckBox;
	
	
    public WebElement getFixedIncomeCheckBox() {
        return CommonMethods.clickableElement(fixedIncomeCheckBox);
    }

	@FindBy(xpath = "//*[@class=\"number-bubble\"]")
	private WebElement filterNumberBubble;	
	
    public WebElement getFilterNumberBubble() {
        return filterNumberBubble;
    }   
    
	@FindBy(xpath = "//*[@class='asset-class-fields']//*[@class='custom-control custom-checkbox'][1]")
	private WebElement assetFilterCheckBox;
		
    public WebElement getAssetFilterCheckBox() {
        return CommonMethods.clickableElement(assetFilterCheckBox);
    }  
    
	@FindBy(xpath = "//*[@class='share-classes-fields']//*[@class='custom-control custom-checkbox'][1]")
	private WebElement shareFilterCheckBox;
		
    public WebElement getShareFilterCheckBox() {
        return CommonMethods.clickableElement(shareFilterCheckBox);
    }
    
	@FindBy(xpath = "//*[@class='share-classes-fields']//*[@class='custom-control custom-checkbox'][1]//span[@class='custom-control-description']")
	private WebElement selectedShareFilters;
		
    public WebElement getSelectedShareFilters() {
        return selectedShareFilters;
    }
    
	@FindBy(xpath = "//*[@class='product-type-fields']//*[@class='custom-control custom-checkbox'][1]")
	private WebElement vehicleFilterCheckBox;
		
    public WebElement getVehicleTypeCheckBox() {
        return CommonMethods.clickableElement(vehicleFilterCheckBox);
    }
    public List <WebElement> getVehicleTypeOptions() {
        return this.driver.findElements(By.xpath("//*[@class='product-type-fields']//span[@class='custom-control-description']"));
    }
    
	@FindBy(xpath = "//*[@class='affiliate-fields']//*[@class='custom-control custom-checkbox'][1]")
	private WebElement invManagerCheckbox;
		
    public WebElement getInvManagerCheckbox() {
        return CommonMethods.clickableElement(invManagerCheckbox);
    }
    
	@FindBy(xpath = "//*[@class='currency-fields']//*[@class='custom-control custom-checkbox'][1]")
	private WebElement currencyFilterCheckBox;
		
    public WebElement getCurrencyFilterCheckBox() {
        return CommonMethods.clickableElement(currencyFilterCheckBox);
    }

    public WebElement getCurrencyFilterCheckBoxDe(String filerName) {
        return this.driver.findElement(By.xpath("//*[@class='currency-fields']//*[@data-interaction-detail='"+filerName+"']/parent::label[@class='custom-control custom-checkbox']"));
    }
    
	@FindBy(xpath = "//*[@class='checkbox-group distribution-type']//*[@class='custom-control custom-checkbox'][1]")
	private WebElement distTypeFilterCheckbox;
		
    public WebElement getDistTypeFilterCheckbox() {
        return CommonMethods.clickableElement(distTypeFilterCheckbox);
    }
		
    public WebElement getCheckboxFilterType(String filterType, String filterName) {
        //return this.driver.driver.findElement(By.xpath("//*[@class='"+filterType+"']//input[@data-name='"+filterName+"']//following-sibling::span[1]"));
        return this.driver.findElement(By.xpath("//*[@class='"+filterType+"']//input[@data-name='"+filterName+"']//parent::label"));
    }
    
	@FindBy(xpath = "//*[@class='checkbox-group domiciles']//*[@class='custom-control custom-checkbox'][1]")
	private WebElement domicileFilterCheckbox;
		
    public WebElement getDomicileCheckBox() {
        return CommonMethods.clickableElement(domicileFilterCheckbox);
    }
    
  	@FindBy(xpath = "//*[@class='checkbox-group domiciles']//*[@class='custom-control custom-checkbox'][1]//span[2]")
	private WebElement domicileFilterName;
		
    public WebElement getDomicileFilterName() {
        return domicileFilterName;
    }
    
	@FindBy(xpath = " //*[@class='dataTables_empty']")
	private WebElement noResultsHeader;
		
    public WebElement getNoResultsHeader() {
        return noResultsHeader;
    }  
    
    public WebElement getFilterChkBxFromFilterType(String filterType, String filterName) {
  		return this.driver.findElement(By.xpath("//*[@class='checkbox-group']/legend[contains(.,'"+filterType+"')]/parent::fieldset/div//span[text()='"+filterName+"']"));
  	}
 
    public WebElement getFirstFilterChbxFromFilterType(String filterType) {
    	return this.driver.findElement(By.xpath("//*[contains(@class,'"+filterType+"')]//*[@class='custom-control custom-checkbox'][1]"));
    }
}
