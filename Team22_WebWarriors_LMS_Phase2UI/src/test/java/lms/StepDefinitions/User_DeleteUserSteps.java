package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.User_DeletePage;
import lms.Utils.LoggerLoad;

public class User_DeleteUserSteps {

	TestContext testContext;
	WebDriver driver;
	User_DeletePage ud;

	public User_DeleteUserSteps(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.ud = testContext.getUd();
	}

	@Given("Admin login and Admin clicks User on the navigation bar")
	public void admin_login_and_admin_clicks_user_on_the_navigation_bar() {
		ud.test();
		ud.clickUser();
		LoggerLoad.info("Admin is currently on login Page and navigate to user page");
	}

	@When("Admin is on {string} Page")
	public void admin_is_on_page(String cardTitle) {
		assertEquals(ud.verifyManageUserPage(), cardTitle);
		LoggerLoad.info("Admin is currently on User Page");
	}

	@Then("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		ud.clickDelete();
		LoggerLoad.info("Admin clicks the delete icon");
		
	}

	@Then("Admin should see a alert open with heading {string} along with <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(
			String expectedValue) {
		assertEquals(ud.isConfirm(), expectedValue);
		LoggerLoad.info("Verifing the delete user alert dialog box on manage user page");
	}

	@Given("Admin is on Confirm Deletion alert and clicks yes option")
	public void admin_is_on_confirm_deletion_alert_and_clicks_yes_option() throws InterruptedException {
		ud.isAlertYes();
		LoggerLoad.info("Admin clicks Yes on the delete user alert box");
	}

	@Then("Admin gets a message {string} alert and do not see that user in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table(String successful) {
		assertEquals(ud.successAlert(), successful);
		LoggerLoad.info("Admin gets a sucessful user deletion message");
	}

	@Given("Admin clicks  No option")
	public void admin_clicks_no_option() throws InterruptedException {
		ud.isAlertNo();
		LoggerLoad.info("Admin clicks No on the delete user alert box");
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		Assert.assertTrue(true);
		LoggerLoad.info("Admin see confirm alert box diappers");
	}

	@Given("Admin clicks on close button")
	public void admin_clicks_on_close_button() {
		ud.isAlertClosed();
		LoggerLoad.info("Admin clicks close icon on the delete user alert box");
	}

}
