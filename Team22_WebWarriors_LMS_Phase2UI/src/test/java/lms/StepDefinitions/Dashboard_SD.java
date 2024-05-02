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

public class Dashboard_SD {
	
	TestContext testContext;
	WebDriver driver;
	DashBoardPage dbp;
	
	public Dashboard_SD(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.dbp = testContext.getDbp();
	}
	
	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
	    dbp.url();
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() throws InvalidFormatException, IOException {
	    dbp.validcredentials();
	    dbp.loginbtn();
	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {
	    dbp.Header();
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
	    dbp.ResponseTime(int1);
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
	    dbp.broken_links();
	}

	@Then("Admin should see LMS -Learning Management System  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
	    dbp.title("LMS - Learning Management System");
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() throws Exception {
	    dbp.spellCheckNavBar();
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() throws Exception {
	    dbp.spellCheckTitle();
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() {
		dbp.listOfModules();
	   dbp.validateProgramModule();
	}

	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() {
	   dbp.validateBatchModule();
	}

	@Then("Admin should see user in the  3rd place")
	public void admin_should_see_user_in_the_3rd_place() {
	    dbp.validateUserModule();
	}

	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() {
	    dbp.validatelogout();
	}


}
