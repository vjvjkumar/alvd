package com.dvla.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.dvla.coreFramework.AbstractWebPage;

public class ConfirmVehiclePage extends AbstractWebPage {
	
	@FindBy(how = How.CSS, using = ".reg-mark")
	private WebElement RegistrationNumber;
	
	@FindBy(how = How.CSS, using = ".column-two-thirds ul li:nth-of-type(2) strong")
	private WebElement VehicleMake;
	
	@FindBy(how = How.CSS, using = "#Correct_True")
	private WebElement YesRadioButton;
	
	@FindBy(how = How.CSS, using = ".button")
	private WebElement submitandContinue;
	
	public ConfirmVehiclePage(WebDriver driver){
		super(driver);
	}
	
	public ViewVehiclePage isVehRegNoCorrect(String VehicleRegistration, String Make){
		Assert.assertTrue(RegistrationNumber.getText().contains(VehicleRegistration));
		Assert.assertTrue(VehicleMake.getText().contains(Make));
		YesRadioButton.click();
		submitandContinue.click();
		return new ViewVehiclePage(driver);
	}

}
