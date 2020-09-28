package com.publisher.steps;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



//import com.cucumber.listener.Reporter;


public class BrokenImageSteps extends Utility{
	
	public void verifyBrokenImages(WebDriver driver) throws IOException {
				

		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		ArrayList<String> src = new ArrayList<String>();
		for (int i = 0; i < imagesList.size(); i++) {
			src.add(imagesList.get(i).getAttribute("src"));
		}
		for (int i = 0; i < src.size(); i++) {
			try {
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(src.get(i));
				HttpResponse response = client.execute(request);
				if (response.getStatusLine().getStatusCode() == 200) {
					System.out.println("Image Not Broken:" + src.get(i).toString());

				} else {
					boolean Level2 = secondLevelValidation(src.get(i));
					if (Level2) {

						System.out.println("Image Not Broken:" + src.get(i).toString());
					} else {
						System.out.println("Image Broken" + src.get(i).toString());
					}
				}
			} catch (ClientProtocolException e) {
				System.out.println("Error URL" + src.get(i));
				System.out.println("ClientProtocolException" + e);
			} catch (IOException e) {
				System.out.println("Error URL" + src.get(i));
				System.out.println("IOException" + e);
			}
			catch (NullPointerException e) {
				System.out.println("Error URL" + src.get(i));
				System.out.println("NullPointerException" + e);
			}
		}

	}

	public boolean secondLevelValidation(String imgURL) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get(imgURL);
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@src='" + imgURL + "']"))));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
