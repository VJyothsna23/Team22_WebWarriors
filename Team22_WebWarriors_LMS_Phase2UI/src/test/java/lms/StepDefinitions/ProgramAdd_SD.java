package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Program_AddPage;
import lms.Utils.commonMethods;
import lms.Utils.dynamicGenerator;

public class ProgramAdd_SD {

	TestContext testContext;
	WebDriver driver;
	Program_AddPage pa;

	public ProgramAdd_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.pa = testContext.getPa();
	}


	@Given("Admin logins into the application and is on the manage program page")
	public void admin_logins_into_the_application_and_is_on_the_manage_program_page() {
		pa.clickProgram();
		pa.manageprogramurl();
	}

	@When("Admin clicks <A New Program> button")
	public void admin_clicks_a_new_program_button() {
		pa.newProgram();
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {

		Assert.assertTrue(pa.newProgPopUp());
		Assert.assertTrue(pa.progNameisempty());
		Assert.assertTrue(pa.progDescisempty());
		Assert.assertTrue(pa.radiobuttonisNotSel());
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
		Assert.assertTrue(pa.inputfield());
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
		assertEquals(pa.radioButtonSize(), 2);
	}

	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {
		Assert.assertTrue(pa.popUpwindow());
	}

	@When("Admin clicks <Save>button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
		pa.clickSave();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		Assert.assertTrue(pa.prgmNameError());
		Assert.assertTrue(pa.prgmDescError());
		Assert.assertTrue(pa.radioError());
	}

	@When("Admin enters only<Program Name> in text box and clicks Save button")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
		pa.enterProgname();
		pa.clickSave();
	}

	@Then("Admin gets a message alert {string}")
	public void admin_gets_a_message_alert(String string) {
		assertTrue(commonMethods.validator(pa.getprogDescError(),"Description is required."));
	}

	@When("Admin enters only<Program description> in text box and clicks Save button")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() throws InterruptedException {
		pa.enterProgDesc();
		Thread.sleep(2000);
		pa.clickSave();
	}

	@Then("Admin gets a message alert {string} in program name field")
	public void admin_gets_a_message_alert_in_program_name_field(String string) {
		assertTrue(commonMethods.validator(pa.getprogNameError(),"Program name is required."));

	}

	@When("Admin selects only Status and clicks Save button")
	public void admin_selects_only_status_and_clicks_save_button() throws InterruptedException {
		pa.radioSelect();
		Thread.sleep(2000);
		pa.clickSave();

	}
	@Then("Admin gets a message alert {string} in program desc and prog name field")
	public void admin_gets_a_message_alert_in_program_desc_and_prog_name_field(String string) {
		assertTrue(commonMethods.validator(pa.getprogNameError(),"Program name is required."));
		assertTrue(commonMethods.validator(pa.getprogDescError(),"Description is required."));
	}

	@When("Admin enters {string} for the {string} for Add Program")
	public void admin_enters_for_the_for_add_program(String string, String string2) {
		if(string.equalsIgnoreCase("Numeric values")&& (string2.equalsIgnoreCase("Name"))) {
			pa.enterProgname("2345678");
		}else if(string.equalsIgnoreCase("Special Characters")&& (string2.equalsIgnoreCase("Name"))) {
			pa.enterProgname("#$%^&*");
		}else if(string.equalsIgnoreCase("Numeric values")&& (string2.equalsIgnoreCase("Description"))) {
			pa.enterProgDesc("2345678");
		}else if(string.equalsIgnoreCase("Special Characters")&& (string2.equalsIgnoreCase("Description"))) {
			pa.enterProgDesc("#$%^&*");
		}	 
	}

	@Then("Admin gets a Error message alert near the text {string} for Add Program")
	public void admin_gets_a_error_message_alert_near_the_text_for_add_program(String string) {
		String expectedError = "This field should start with an alphabet, no special char and min 2 char.";
		String expectedError1 = "This field should start with an alphabet and min 2 char.";
		if(pa.getprogNameError1().contains(expectedError)) {
			assertTrue(pa.getprogNameError1().contains(expectedError));}
		else
			assertTrue(pa.getprogDescError1().contains(expectedError1));
	}


	@When("Admin clicks Cancel or Close Icon on Program Details form in add program")
	public void admin_clicks_cancel_close_x_icon_on_program_details_form_in_add_program() {
		pa.enterProgname();
		pa.enterProgDesc();
		pa.clickClose();
	}


	@When("Enter valid ProgramName and ProgramDescription ,status and click Save button in add program")
	public void enter_valid_ProgramName_status_and_click_save_button_in_add_program() {
		pa.enterProgname(dynamicGenerator.generateProgNameForAdd());
		pa.enterProgDesc("Team22");
		pa.radioSelect();
		pa.clickSave();
	}

	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) {
		assertTrue(commonMethods.validator(pa.successMsg(), "Program Created Successfully"));
	}

	@When("Admin clicks <Cancel>button")
	public void admin_clicks_cancel_button() {
		pa.enterProgname();
		pa.enterProgDesc();
		pa.clickCancel();
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() throws InterruptedException {
		assertTrue(commonMethods.validator(pa.searchValidation(),"Showing 0 to 0 of 0 entries"));
	}

}

