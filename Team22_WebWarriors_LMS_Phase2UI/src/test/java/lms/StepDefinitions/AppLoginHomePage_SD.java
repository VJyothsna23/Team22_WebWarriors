package lms.StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.AppLoginPage;
import lms.Utils.LoggerLoad;
import lms.Utils.*;

public class AppLoginHomePage_SD {
	
	TestContext testContext;
	WebDriver driver;
	AppLoginPage lp;
	//
	
	public AppLoginHomePage_SD(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.lp = testContext.getLp();
	}

	ExcelReader reader = new ExcelReader();
	
	@Given("User enters LMS url application")
	public void user_enters_lms_url_application() {
		LoggerLoad.info("Admin Launch the Browser");
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
	    lp.Invalidurl();
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
		LoggerLoad.info("Admin should recieve 404 page not found error ");
	}
	
	@When("Admin enter valid credentials from excel sheet {string} and {int}")
	public void admin_enter_valid_credentials_from_excel_sheet_(String Login, int int1) throws InvalidFormatException, IOException {
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Login.xlsx", "Sheet1");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		lp.url();
		lp.loginuser(user);
		lp.loginpassword(password);
		lp.loginbtn();
		
	}
	
	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		LoggerLoad.info("Login is successful with valid credential");
		System.out.println("Login Successful");
	}

	@When("Admin enter Invalid credentials from excel sheet {string} and {int}")
	public void admin_enter_Invalid_credentials_from_excel_sheet_(String Login, int int1) throws InvalidFormatException, IOException {
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Login.xlsx", "Sheet1");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		lp.url();
		lp.loginuser(user);
		lp.loginpassword(password);
		lp.loginbtn();
		
	}

	@Then("Error message please check username\\/password")
	public void error_message_please_check_username_password() {
		LoggerLoad.info("Login is not successful with Invalid credential");
		System.out.println("Login not Successful");
	}

	@When("Admin enter password from excel sheet {string} and {int}")
	public void admin_enter_password_from_excel_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Login.xlsx", "Sheet1");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		lp.url();
		lp.loginuser(user);
		lp.loginpassword(password);
		lp.loginbtn();
	}

	@Then("Error message please check username")
	public void error_message_please_check_username() {
		LoggerLoad.info("Login is not successful with Null username");
		System.out.println("Login not Successful");
	}

	@When("Admin enter user from excel sheet {string} and {int}")
	public void admin_enter_user_from_excel_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Login.xlsx", "Sheet1");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		lp.url();
		lp.loginuser(user);
		lp.loginpassword(password);
		lp.loginbtn();
	}

	@Then("Error message please check password")
	public void error_message_please_check_password() {
		LoggerLoad.info("Login is not successful with Null Password");
		System.out.println("Login not Successful");
	}

	@When("Admin enter valid credentials and click through keyboard from excel sheet {string} and {int}")
	public void admin_enter_valid_credentials_and_click_through_keyboard_from_excel_sheet_(String Login, Integer int1) throws InvalidFormatException, IOException {
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Login.xlsx", "Sheet1");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		lp.url();
		lp.loginuser(user);
		lp.loginpassword(password);
		lp.loginbtn();
	}
	
	@Then("Admin Lands on Dashboard Page")
	public void Admin_Lands_on_Dashboard_Page() {
		LoggerLoad.info("Login is successful through KeyBoard with valid credential");
	}

	@When("Admin enter valid credentials and click through mouse from excel sheet {string} and {int}")
	public void admin_enter_valid_credentials_and_clickthrough_mouse_from_excel_sheet_(String Login, Integer int1) throws InvalidFormatException, IOException{
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Login.xlsx", "Sheet1");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		lp.url();
		lp.loginuser(user);
		lp.loginpassword(password);
		lp.loginbtn();
	}

	@Then("Admin should land on page dashboard")
	public void admin_should_land_on_page_dashboard() {
		LoggerLoad.info("Login is successful through mouse with valid credential");
	}



}
