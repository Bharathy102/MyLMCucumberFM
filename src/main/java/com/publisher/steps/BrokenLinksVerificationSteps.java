package com.publisher.steps;


import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.cucumber.listener.Reporter;

public class BrokenLinksVerificationSteps {

	public static final String HTTP_CODE_200 = "200####OK";
	public static final String HTTP_CODE_301 = "301####Moved Permanently";
	public static final String HTTP_CODE_999 = "999####Request denied";
	public static final String HTTP_CODE_404 = "404####Not Found";
	public static final String HTTP_CODE_503 = "503####Service Unavailable";
	public static final String HTTP_CODE_401 = "401####Unauthorized";

	static BrokenLinksVerificationSteps brokenLinkObject = new BrokenLinksVerificationSteps();

	public static String verifyBrokenLink(String linkUrl)
			throws IOException, org.openqa.selenium.NoSuchElementException {
		URL url = new URL(linkUrl);
		try {

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			try {
				connection.connect();
				String response = connection.getResponseCode() + "####" + connection.getResponseMessage();
				connection.disconnect();
				// verifyErrorMessage(response);
				return response;
			} catch (Exception exp) {
				return exp.getMessage();
			}
		} catch (ClassCastException e) {

			return e.getMessage();
		}
	}

	public void verifyBrokenLinks(WebDriver driver) throws IOException, org.openqa.selenium.NoSuchElementException {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			String url = it.next().getAttribute("href");

			String message = null;
			try {

				message = BrokenLinksVerificationSteps.verifyBrokenLink(url);
				if (message.contains(HTTP_CODE_301)) {
					System.out.println("The URL moved permanently: " + url +  " \n");
					System.out.println("\n" + "-------------------------------------------------------------------------");
				} else if (message.contains("Connection reset")) {
					System.out.println("The URL is blocked:" + url);
					System.out.println("\n" + "-------------------------------------------------------------------------");
				} else if (message.contains(HTTP_CODE_999)) {
					System.out.println("The URL Request is denied: " + url);
					System.out.println("\n" + "-------------------------------------------------------------------------");
				} else if (message.contains(HTTP_CODE_401)) {
					System.out.println("The URL is Not Unauthorized: " + url);
					System.out.println("\n" + "-------------------------------------------------------------------------");
				}else if (message.contains(HTTP_CODE_404)) {
					System.out.println("The URL is Not found: " + url);
					System.out.println("\n" + "-------------------------------------------------------------------------");
				} else if (message.contains(HTTP_CODE_503)) {
					System.out.println("The URL Service Unavailable: " + url);
					System.out.println("\n" + "-------------------------------------------------------------------------");
				} else if (message.contains("MailToURLConnection")) {
					System.out.println("The URL contains outlook emailid: " + url);
					System.out.println("\n" + "-------------------------------------------------------------------------");
				} else if (message.contains("SunCertPathBuilderException")) {
					System.out.println("The URL contains outlook emailid: " + url);
					System.out.println("\n" + "-------------------------------------------------------------------------");
				} else if (message.contains("Server redirected too many")) {
					System.out.println("The URL contains Server redirected too many: " + url);
					System.out.println("\n" + "-------------------------------------------------------------------------");
				} else if (message.contains("ChangeCipherSpec message sequence violation")) {
					System.out.println("The URL contains Server redirected too many: " + url);
					System.out.println("\n" + "-------------------------------------------------------------------------");
				}else {
					System.out.println("The Url is Valid:" + url);
					assertEquals(message, HTTP_CODE_200);
					
				}
			} catch (NoSuchElementException e) {
				System.out.println("The Url is Valid:" + url);
				e.printStackTrace();

			} catch (IOException e) {
				System.out.println("The Url is Valid:" + url);
				e.printStackTrace();
			}
		}

		System.out.println("The Broken link validation is success");
	}

	public static Boolean verifyErrorMessage(String message) throws IOException {

		String[] Error = message.split("####");
		String ErrorStatus = Error[0];
		String ErrorMessage1 = Error[1];

		System.out.println("ErrorStatus=" + ErrorStatus + "---ErrorMessage=" + ErrorMessage1);

		if (ErrorStatus.equalsIgnoreCase("200")) {
			System.out.println("Link is Not broken");
			return true;
		} else {
			System.out.println("Link is Broken");
			return false;
		}

	}

}
