package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lms.DriverFactory.TestContext;
import lms.PageFactory.User_AssignStaffPage;

public class User_AssignStaffSteps {

	TestContext testContext;
	WebDriver driver;
	User_AssignStaffPage uastf;

	public User_AssignStaffSteps(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.uastf = testContext.getUastf();
	}

	@Then("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
		uastf.clickAssignStaff();
	}

	@Given("Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_staff_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		uastf.verifyAssignStaffPopUpAndButtons();
	}

	@Given("Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r02_and_other_fields_student_email_id_skill_program_name_batch_name_and_status_with_respective_input_boxes() {
		//uastf.validate_input_fields();
	}

	@Given("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name in Assign Staff")
	public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name_in_assign_staff() {
		//uastf.validate_drop_down();
	}

	@Given("Admin should see two radio button for Status in Assign Staff")
	public void admin_should_see_two_radio_button_for_status_in_assign_staff() {
		//uastf.validate_radio_Button();
	}

	@Given("Admin gets a Error message alert for Assign Staff")
	public void admin_gets_a_error_message_alert_for_assign_staff() {
		uastf.validate_without_data();
	}

	@Then("Admin gets a Error message alert as {string} in Assign Staff")
	public void admin_gets_a_error_message_alert_as_in_assign_staff(String string) {
		uastf.verifyEmailErrorMsg();
	}

	@Then("Assign Staff popup window should be closed without saving")
	public void assign_staff_popup_window_should_be_closed_without_saving() {
		uastf.eleCloseButton.click();
	}

	@Then("Admin gets a Error message alert as Batch is required in Assign Staff")
	public void admin_gets_a_error_message_alert_as_batch_is_required_in_assign_staff() {
	     uastf.verifyBatchErrorMsg();
	}

	@Then("Admin gets a message {string} alert in Assign Staff")
	public void admin_gets_a_message_alert_in_assign_staff(String string) {
		uastf.validData();
	}

	@Then("Admin can see the Assign Staff popup disappears without assigning")
	public void admin_can_see_the_assign_staff_popup_disappears_without_assigning() {
		uastf.eleCancel.click();
	}

}
