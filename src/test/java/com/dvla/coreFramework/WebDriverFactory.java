package com.dvla.coreFramework;

import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import com.dvla.configuration.Context;

@ContextConfiguration(classes = Context.class)
public class WebDriverFactory {
	
	@Value("${runMode}")
	private String runMode;
		
	public WebDriver initializeWebDriver() {
		
		WebDriver driver = null;
		String operaChromiumDriver = "/Users/vijaykumar/Documents/workspace/dvla/operadriver";
		String ChromeDriver = "src\\resources\\chromedriver.exe\\";
		String FirefoxGeckoDriver = "/Users/vijaykumar/Documents/workspace/dvla/geckodriver";
		String PhantomJSDriver = "/Users/vijaykumar/Documents/workspace/dvla/phantomjs";
		
		switch (runMode) 
		{
			case "Opera":
				System.setProperty("webdriver.opera.driver", operaChromiumDriver);
				driver = new OperaDriver();
				break;
		
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", ChromeDriver);
				driver = new ChromeDriver();
				break;
		
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", FirefoxGeckoDriver);
				driver = new FirefoxDriver();
				break;
		
			case "PhantomJS":
				System.setProperty("webdriver.phantomjs.driver", PhantomJSDriver);
				driver = new PhantomJSDriver();
				break;
		
			default	: throw new InvalidParameterException(runMode + "is not a valid parameter - RunMode environment variable is not set!");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
