package com.publisher.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Utility {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream stream;
	

	public void browserSelection() throws IOException, InterruptedException {
		
		//File f= new File(System.getProperty("user.dir")+"\\src\\drivers");
		if(getConfigValue().getProperty("browser").equals("Chrome")){
			//File fi=new File(f, "chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else if(getConfigValue().getProperty("browser").equals("Edge")){
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.setCapability("InPrivate", true);
			driver=new EdgeDriver(options);
			}
		else if(getConfigValue().getProperty("browser").equals("Internet Explorer")){
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			}
		else if(getConfigValue().getProperty("browser").equals("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options =new FirefoxOptions();
			options.addArguments("-private");
			driver=new FirefoxDriver(options);
			}
		else {
			System.out.println("Invalid Browser or no broser configured in properties file");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(getConfigValue().getProperty(getConfigValue().getProperty("env")+getConfigValue().getProperty("url")));
	}
		
	public static Properties getConfigValue() throws IOException {
		File f=new File(System.getProperty("user.dir")+"\\src\\config.properties");
		stream= new FileInputStream(f);
		prop= new Properties();
		prop.load(stream);
		return prop;
	}
	
	
	    
	  public static String getReportConfigPath() {
	    	String reportConfigPath=System.getProperty("user.dir")+"\\src\\ExtentReportConfig\\extent-config.xml";
	    	return reportConfigPath;
	    }
	  
	 

}
