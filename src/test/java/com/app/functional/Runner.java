package com.app.functional;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\HP\\eclipse-workspace\\Develop\\new\\new\\oct"
		+ "\\API_Cucumber\\src\\test\\java\\com\\app\\functional",
		glue = "com.app.functional",
		dryRun = false,
		tags = "@Gettmethod",
		plugin = {
				"pretty",
		        "html:target/cucumber-reports.html",
		        "json:target/cucumber.json",
		        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  	
		})
public class Runner {

}
