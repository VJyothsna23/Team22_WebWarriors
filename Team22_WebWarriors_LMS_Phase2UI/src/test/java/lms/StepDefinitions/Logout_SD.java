package lms.StepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.DashBoardPage;
import lms.PageFactory.LogoutPage;

public class Logout_SD {
	
	TestContext testContext;
	WebDriver driver;
	LogoutPage lop;
	
	public Logout_SD(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.lop = testContext.getLop();
	}
	
	
	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() throws InvalidFormatException, IOException {
	    lop.url();
	    lop.validcredentials();
	    lop.loginbtn();
	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
	    
	    lop.logoutbtn();
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
	   
	}



}
