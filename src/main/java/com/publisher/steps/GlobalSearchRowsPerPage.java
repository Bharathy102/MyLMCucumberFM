package com.publisher.steps;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.publisher.pageobjects.SearchPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class GlobalSearchRowsPerPage extends Utility {

	private static final String CLASS = "class";
	private static final String DISABLED = "disabled";
	public static final String ACTIVE = "active";


	@And("^I type \"([^\"]*)\" in the Search input box$")
	public void iTypeInSearchInputBox(String term) throws Throwable {
		SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys(term);
	}
	
	@And("^I type ISIN Value in the Search input box$")
	public void iTypeISINSEDOLInSearchInputBox() throws Throwable {
		if (driver.getCurrentUrl().contains("en-gb")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00BDR6ZM86");
			Thread.sleep(3000);
		}
		else if (driver.getCurrentUrl().contains("en-au")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("AU60SSB00439");
			Thread.sleep(3000);
		}
		else if (driver.getCurrentUrl().contains("en-fi")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00BMMV5V01");
			Thread.sleep(3000);
		}
		else if (driver.getCurrentUrl().contains("en-nl")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00BXRTLD08");
			Thread.sleep(3000);
		}
		else if (driver.getCurrentUrl().contains("en-dk")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00BF3ZD858");
			Thread.sleep(3000);
		}
		else if (driver.getCurrentUrl().contains("en-no")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00BXRTL637");
			Thread.sleep(3000);
		}	
		else if (driver.getCurrentUrl().contains("en-lu")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00BSBN5Q47");
			Thread.sleep(3000);	
		}
		else if (driver.getCurrentUrl().contains("en-se")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00BF3ZD858");
			Thread.sleep(3000);
		} else if (driver.getCurrentUrl().contains("en-sg")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00B59BT671");
			Thread.sleep(3000);	
		} else if (driver.getCurrentUrl().contains("en-aa")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00BMMV5V01");
			Thread.sleep(3000);		
		} else if (driver.getCurrentUrl().contains("de-de")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().clear();
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("IE00BXRTL850");
			Thread.sleep(3000);
		} else {
			 System.out.println("ISIN Value is not configured for the given country");
		}		
	}
	
	@And("^I type SEDOL Value in the Search input box$")
	public void iTypeSEDOLInSearchInputBox() throws Throwable {
		if (driver.getCurrentUrl().contains("en-gb")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BDR6ZM8");
			Thread.sleep(3000);
		}if (driver.getCurrentUrl().contains("en-au")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BQR8RM9");
		}
		else if (driver.getCurrentUrl().contains("en-fi")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BMMV5V0");
			Thread.sleep(3000);
		}
		else if (driver.getCurrentUrl().contains("en-nl")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BXRTLD0");
			Thread.sleep(3000);
		}
		else if (driver.getCurrentUrl().contains("en-dk")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BF3ZD85");
			Thread.sleep(3000);
		}
		else if (driver.getCurrentUrl().contains("en-no")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BXRTL63");
			Thread.sleep(3000);
		}	
		else if (driver.getCurrentUrl().contains("en-lu")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BXRTL63");
			Thread.sleep(3000);
		}	
		else if (driver.getCurrentUrl().contains("en-se")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BF3ZD85");
			Thread.sleep(3000);	
		}else if (driver.getCurrentUrl().contains("en-sg")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("B59BT67");
			Thread.sleep(3000);		
		}else if (driver.getCurrentUrl().contains("en-aa")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BMMV5V0");
			Thread.sleep(3000);		
		}else if (driver.getCurrentUrl().contains("de-de")) {
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().clear();
			SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys("BXRTL85");
			Thread.sleep(3000);
		}
		else {
			System.out.println("SEDOL Value is not configured for the given country");
		}		
	}
	
	@And("^I press the Enter key on the Search component$")
	public void iPressTheEnterKeyOnTheSearchComponent() throws Throwable {
		SearchPageObject.searchPageObject(driver).getGlobalsearchinput().sendKeys(Keys.ENTER);
	}

	@And("^I set the Search Rows per page dropdown to \"([^\"]*)\"$")
	public void ISetTheRowsPerPageDropdownTo(String pageSize) throws Throwable {
		List<WebElement> paginationOptions = SearchPageObject.searchPageObject(driver).getSearchPaginationOptions();
		WebElement option = paginationOptions.stream().filter(o -> o.getText().equals(pageSize))
				.collect(Collectors.toList()).get(0);
		option.click();
	}

}
