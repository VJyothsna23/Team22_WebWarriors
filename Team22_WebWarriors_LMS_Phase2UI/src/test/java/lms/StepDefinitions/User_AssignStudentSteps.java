package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.User_AssignStudentPage;

public class User_AssignStudentSteps {

	TestContext testContext;
	WebDriver driver;
	User_AssignStudentPage uas;

	public User_AssignStudentSteps(TestContext testContext) {
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.uas = testContext.getUas();
	}

	@Then("Admin clicks on {string} button")
	public void admin_clicks_on_button(String string) {
		uas.clickAssignStudent();
		
	}
	

	@Given("Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
          uas.verifyAssignStudentPopUpAndButtons();  
	}

	@Given("Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r03_and_other_fields_student_email_id_program_name_batch_name_and_status_with_respective_input_boxes() {
          uas.validate_input_fields();
	}

	@Given("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name")
	public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name() throws Exception {
          uas.validate_drop_down();
	}

	@Given("Admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status()  {
          uas.validate_radio_Button();
	}

	@When("Admin clicks {string} button without entering any data")
	public void admin_clicks_button_without_entering_any_data(String string) {
          uas.eleSave.click();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		uas.validate_without_data();
	}


	@Then("Admin gets a Error message alert as {string}")
	public void admin_gets_a_error_message_alert_as(String string) {

	}

	@When("Admin clicks {string} button without selecting program")
	public void admin_clicks_button_without_selecting_program(String string) {

	}

	@When("Admin clicks {string} button without selecting batch")
	public void admin_clicks_button_without_selecting_batch(String string) {

	}

	@When("Admin clicks Cancel\\/Close\\(X) Icon on Assign Student form")
	public void admin_clicks_cancel_close_x_icon_on_assign_student_form() {

	}

	@Then("Assign Student popup window should be closed without saving")
	public void assign_student_popup_window_should_be_closed_without_saving() {

	}

	@When("Enter all the required fields with valid values and click Save button")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button() {

	}

	@Then("Admin gets a message {string} alert")
	public void admin_gets_a_message_alert(String string) {

	}

	@When("Admin clicks <Cancel> button")
	public void admin_clicks_cancel_button() {
         uas.eleCancel.click();
	}

	@Then("Admin can see the Assign Student popup disappears without assigning")
	public void admin_can_see_the_assign_student_popup_disappears_without_assigning() { 
         assertEquals(uas.eleManageUser.getText(),"Manage User");
	}
	

}
