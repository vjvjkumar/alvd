package com.dvla.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.dvla.coreFramework.AbstractWebPage;

public class VehicleEnqPage extends AbstractWebPage {
	
	@FindBy(how = How.CSS, using = "#Vrm")
	private WebElement inputVrm;
	
	@FindBy(how = How.CSS, using = ".button")
	private WebElement submit;
	
	public VehicleEnqPage(WebDriver driver) {
		super(driver);
	}

	public ConfirmVehiclePage enterVehicleRegNumber(String VehicleRegNo){
		inputVrm.sendKeys(VehicleRegNo);
		submit.click();
		return new ConfirmVehiclePage(driver);
	}
}
