package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.AppLoginPage;
import lms.Utils.*;
import net.sourceforge.tess4j.TesseractException;


public class AppLogin_SD {
	TestContext testContext;
	WebDriver driver;
	AppLoginPage lp;
	
	public AppLogin_SD(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.lp = testContext.getLp();
			}

@Given("User enters LMS application url")
public void user_enters_lms_application_url() {
	LoggerLoad.info("Admin Launch the Browser");
}

@When("Admin gives the correct LMS portal URL")
public void admin_gives_the_correct_lms_portal_url() {
    lp.url();
}

@Then("Admin should land on the home page")
public void admin_should_land_on_the_home_page() {
	LoggerLoad.info("Admin is on Home Page");
}

@Then("HTTP response >= {int}. then the link is broken")
public void http_response_then_the_link_is_broken(Integer int1) {
    lp.broken_links();
}

@Then("Admin should see correct spellings in all fields")
public void admin_should_see_correct_spellings_in_all_fields() throws Exception {
    lp.spellCheck();
}

@Then("Admin should see logo on the left  side")
public void admin_should_see_logo_on_the_left_side() {
    lp.logoaligned();
}

@Then("Admin should see  LMS - Learning Management System")
public void admin_should_see_lms_learning_management_system() throws TesseractException {
    lp.verifyApllicationTitle();
}

@Then("Admin should see company name below the app name")
public void admin_should_see_company_name_below_the_app_name() throws TesseractException {
    lp.verifyCompanyName();
}

@Then("Admin should see {string}")
public void admin_should_see(String string) {
    lp.verifyPleaseLoginTitle();
}



}
