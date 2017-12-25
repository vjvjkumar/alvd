package com.dvla.stepDefinitions;

import com.dvla.coreFramework.AbstractTestCase;
import com.dvla.pageObjects.ConfirmVehiclePage;
import com.dvla.pageObjects.LandingPage;
import com.dvla.pageObjects.VehicleEnqPage;
import com.dvla.pageObjects.ViewVehiclePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DvlaVehicleInformationTest extends AbstractTestCase {
	
	private LandingPage landingPage;
	private VehicleEnqPage vehicleEnqPage;
	private ConfirmVehiclePage confirmVehiclePage;
	private ViewVehiclePage viewVehiclePage;
	
	@Given("^the user navigates to Landing Page$")
	public void the_user_navigates_to_Landing_Page() throws Throwable {
	    landingPage = goToHomePage();
	    vehicleEnqPage = landingPage.startNow();
	}
	
	@When("^the user provides the valid \"([^\"]*)\" details$")
	public void the_user_provides_the_valid_details(String vehicleRegistration) throws Throwable {
		confirmVehiclePage = vehicleEnqPage.enterVehicleRegNumber(vehicleRegistration);  
	}

	@Then("^the user verifies the car \"([^\"]*)\", \"([^\"]*)\" and configuration$")
	public void the_user_verifies_the_car_and_configuration(String vehicleRegistration, String make) throws Throwable {
		viewVehiclePage = confirmVehiclePage.isVehRegNoCorrect(vehicleRegistration, make);
		landingPage = viewVehiclePage.verifyRegNoTaxMot(vehicleRegistration, make);
	}

	@Then("^the user quits the browser windows$")
	public void the_user_quits_the_browser_windows() throws Throwable {
	    landingPage.closeBrowser();
	}

}
