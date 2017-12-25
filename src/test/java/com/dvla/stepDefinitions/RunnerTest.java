package com.dvla.stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty", 
				"html:target/cucumber-html-report", 
				"json:target/cucumber-json-report.json", 
				"pretty:target/cucumber-pretty.txt", 
				"usage:target/cucumber-usage.json", 
				"junit:target/cucumber-junit-report/cucumber-results.xml"},
		features={"src/test/resources/vehicleInformation.feature"},
		glue={"com/dvla/stepDefinitions"}
		)

public class RunnerTest{
}
