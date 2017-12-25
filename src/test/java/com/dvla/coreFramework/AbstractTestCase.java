package com.dvla.coreFramework;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.dvla.configuration.Context;
import com.dvla.pageObjects.LandingPage;
import com.dvla.coreFramework.WebDriverFactory;


@ContextConfiguration(classes = Context.class, initializers = ConfigFileApplicationContextInitializer.class)
public abstract class AbstractTestCase {
	
	protected WebDriver driver;
	
	
	@Value("${testChallengeUrl}")
	private String testChallengeUrl;
	
	public void printUrl(){
		System.out.println(testChallengeUrl);
	}
	
	
	@Autowired
	protected RestTemplate restTemplate;
	
	public void printRestTemplate(){
		System.out.println(restTemplate);
	}
	
	
	@Autowired
	private WebDriverFactory webDriverFactory;
	
	public void printWebDriverFactory(){
		System.out.println(webDriverFactory);
	}
	
	
	public String navigateToTestChallengeUrl(){
		return testChallengeUrl;
	}
	
	protected LandingPage goToHomePage() {

		driver = webDriverFactory.initializeWebDriver();
		driver.get(navigateToTestChallengeUrl());
		System.out.println(driver.getTitle());
		
	return new LandingPage(driver);
	}
}
