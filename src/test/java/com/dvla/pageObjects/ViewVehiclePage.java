package com.dvla.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.dvla.coreFramework.AbstractWebPage;

public class ViewVehiclePage extends AbstractWebPage {
	
	@FindBy(how = How.CSS, using = ".reg-mark")
	private WebElement RegistrationNumberHeading;
	
	@FindBy(how = How.CSS, using = ".isValid h2")
	private WebElement hasValidTax;
	
	@FindBy(how = How.CSS, using = ".isValid h2")
	private WebElement hasValidMot;
	
	@FindBy(how = How.CSS, using = ".column-two-thirds ul li:nth-of-type(1) span")
	private WebElement vehicleSummary;
	
	@FindBy(how = How.CSS, using = ".column-two-thirds ul li:nth-of-type(1) strong")
	private WebElement vehicleName;
	
	@FindBy(how = How.LINK_TEXT, using = "Search for another vehicle")
	private WebElement anotherSearch;

	
	public ViewVehiclePage(WebDriver driver) {
		super(driver);
	}
	
	public LandingPage verifyRegNoTaxMot(String VehicleRegistration, String Make){
		Assert.assertTrue(RegistrationNumberHeading.getText().contains(VehicleRegistration));
		Assert.assertTrue(hasValidTax.getText().contains(" Taxed"));
		Assert.assertTrue(vehicleSummary.getText().contains("Vehicle make"));
		Assert.assertTrue(vehicleName.getText().contains(Make));
		anotherSearch.click();
		return new LandingPage(driver);
	}
}
