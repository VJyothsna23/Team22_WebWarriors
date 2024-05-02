package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;
import lms.Utils.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.AppLoginPage;


public class AppLoginPage_SD {
	//
	
	TestContext testContext;
	WebDriver driver;
	AppLoginPage lp;
	
	public AppLoginPage_SD(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.lp = testContext.getLp();
	}

	@Given("User enter LMS application url")
	public void user_enter_lms_application_url() {
		LoggerLoad.info("Admin Launch the Browser");
	}

	@When("Admin enter the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	    lp.url();
	}
	
	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
	    lp.textcheck(2);
	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
	    lp.usertext(string);
	}

	@Then("Admin should see {string} symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text(String string) {
	    lp.astrikuser(string);
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
	    lp.passwordtext(string);
	}

	@Then("Admin should see {string} symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text(String string) {
	    lp.astrikpassword(string);
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	   // lp.centreloginbtn();
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	    lp.loginbtncheck();
	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
		lp.centreloginbtn();
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
	    lp.usercolor();
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
	    lp.passwordcolor();
	}


}
