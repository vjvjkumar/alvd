package com.dvla.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.dvla.coreFramework.AbstractWebPage;

public class LandingPage extends AbstractWebPage{
	
	@FindBy(how = How.LINK_TEXT, using = "Start now")
	private WebElement clickToProceed;

	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	public VehicleEnqPage startNow(){
		clickToProceed.click();
		return new VehicleEnqPage(driver);
	}
	
	public void closeBrowser(){
		driver.quit();
	}
}
