package com.publisher.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.publisher.steps.Utility;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@productdetailfr"},
        features = ".",
        format = { "pretty", "html:target/Smoke-report", "json:target/smoke-report.json" },
        glue = "com.publisher.steps",
        plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        dryRun=false,
        monochrome=true)


public class TestRunner {

	@AfterClass
	public static void writeExtentReport(){
		Reporter.loadXMLConfig(Utility.getReportConfigPath());
	}
}
