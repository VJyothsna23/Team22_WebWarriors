package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.User_DeleteMultiplePage;

public class User_DeleteMultipleUserSteps {

	TestContext testContext;
	WebDriver driver;
	User_DeleteMultiplePage delMultipleUser;

	public User_DeleteMultipleUserSteps(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.delMultipleUser = testContext.getUdm();
	}

	@Then("Admin clicks any checkbox in the data table in DeleteMultiple")
	public void admin_clicks_any_checkbox_in_the_data_table_in_DeleteMultiple() {
		delMultipleUser.clickCheckBox();
	}

	@And("Admin should see common delete option enabled under header Manage User")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_user() {
		delMultipleUser.verifyCommonDel();
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		delMultipleUser.clickCommonDelButton();
	}

	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() throws InterruptedException {
		delMultipleUser.isAlertYes();
	}

	@Then("Admin should land on Manage User page and can see the selected user is deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_deleted_from_the_data_table() {
		delMultipleUser.successAlert();
	}

	@When("Admin clicks <No> button on the alert")
	public void admin_clicks_no_button_on_the_alert() throws InterruptedException {
		delMultipleUser.isAlertNo();
	}

	@Then("Admin should land on Manage User page and can see the selected user is not deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_not_deleted_from_the_data_table() {
		delMultipleUser.verifyUserIsNotDel();
	}

	@Given("Admin clicks delete button under header after selecting multiple checkboxes in the data table")
	public void admin_clicks_delete_button_under_header_after_selecting_multiple_checkboxes_in_the_data_table() {
		delMultipleUser.clickMulCheckBox();
	}

	@Then("Admin should land on Manage User page and can see the selected users are deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_deleted_from_the_data_table()
			throws InterruptedException {
		delMultipleUser.successAlert();
	}

	@Then("Admin should land on Manage User page and can see the selected users are not deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_not_deleted_from_the_data_table() {
		delMultipleUser.clickMulCheckBox();
	}

}
