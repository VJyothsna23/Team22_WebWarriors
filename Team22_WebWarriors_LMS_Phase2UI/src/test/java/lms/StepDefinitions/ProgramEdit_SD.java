package lms.StepDefinitions;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Program_EditPage;
import lms.Utils.ConfigReader;
import lms.Utils.commonMethods;

import static org.testng.Assert.*;

public class ProgramEdit_SD{

	TestContext testContext;
	WebDriver driver;
	Program_EditPage pe;
	
	public ProgramEdit_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.pe = testContext.getPe();
	}
	
	@Given("Admin is on Manage Program page and clicks on Edit button corresponding to a Progarm")
	public void admin_is_on_manage_program_page_and_clicks_on_edit_button_corresponding_to_a_progarm() throws InterruptedException {
		pe.editProgramDetailsWindow();
	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {
		assertTrue(commonMethods.validator(pe.getProgramDetailsText(),"Program Details"));
		
	}

	@When("Admin edits the Program Name column and clicks save button")
	public void admin_edits_the_program_name_column_and_clicks_save_button() throws InterruptedException {
	    pe.editProgramName();
	    pe.clickSave();
	}

	@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) {
		assertTrue(commonMethods.validator(pe.getSuccessMessageText(),"Successful Program Updated"));
		assertTrue(commonMethods.validator(pe.getProgramNameColumnText(),"WEBMachine"));

	}

	@When("Admin edits the Program Description column and clicks save button")
	public void admin_edits_the_program_description_column_and_clicks_save_button() throws InterruptedException {
		pe.editProgramDesc();
	    pe.clickSave();
	}

	@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {
		assertTrue(commonMethods.validator(pe.getSuccessMessageText(),"Successful Program Updated"));
		assertTrue(commonMethods.validator(pe.getProgramDescColumnText(),"team22"));
	}

	@When("Admin changes the Program Status and clicks save button")
	public void admin_changes_the_program_status_and_clicks_save_button() throws InterruptedException {
	    pe.editProgramStatus();
	    pe.clickSave();
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {
		assertTrue(commonMethods.validator(pe.getSuccessMessageText(),"Successful Program Updated"));
		assertTrue(commonMethods.validator(pe.getProgramStatusColumnText(),"Active"));
		
	}

	@When("Admin enters {string} for the {string}")
	public void admin_enters_for_the(String string, String string2) throws InterruptedException {
		if(string.equalsIgnoreCase("Numeric values")&& (string2.equalsIgnoreCase("Name"))) {
			pe.editProgramName("2345678");
		}else if(string.equalsIgnoreCase("Special Characters")&& (string2.equalsIgnoreCase("Name"))) {
			pe.editProgramName("#$%^&*");
		}else if(string.equalsIgnoreCase("Numeric values")&& (string2.equalsIgnoreCase("Description"))) {
			pe.editProgramDesc("2345678");
		}else if(string.equalsIgnoreCase("Special Characters")&& (string2.equalsIgnoreCase("Description"))) {
			pe.editProgramDesc("#$%^&*");
		}	    
	}

	@Then("Admin gets a Error message alert near the text {string} for Edit Program")
	public void admin_gets_a_error_message_alert_near_the_text_for_edit_program(String string) {
		String expectedError = "This field should start with an alphabet";
		assertTrue(pe.getEditProgramErrorMessage().contains(expectedError));
	}

	@When("Admin clicks Cancel button on edit program popup")
	public void admin_clicks_cancel_button_on_edit_program_popup() throws InterruptedException {
		pe.editProgramDesc();
	    pe.clickCancel();
	}

	@Then("Admin can see the Edit Program details popup disappear and can see nothing changed for particular program")
	public void admin_can_see_the_edit_program_details_popup_disappear_and_can_see_nothing_changed_for_particular_program() {
		assertTrue(commonMethods.validator(pe.getProgramDescColumnText(),"Team22"));
	}

	@When("Admin clicks Save button on edit program popup")
	public void admin_clicks_save_button_on_edit_program_popup() throws InterruptedException {
		pe.editProgramDetails();
	    pe.clickSave();
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) {
		assertTrue(commonMethods.validator(pe.getSuccessMessageText(),"Successful Program Updated"));
		assertTrue(commonMethods.validator(pe.getProgramNameColumnText(),"WEB"));
		assertTrue(commonMethods.validator(pe.getProgramDescColumnText(),"Team22"));
		assertTrue(commonMethods.validator(pe.getProgramStatusColumnText(),"Active"));
	}

}


