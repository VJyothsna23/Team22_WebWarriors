package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Program_DeletePage;
import lms.PageFactory.Program_EditPage;
import lms.Utils.ConfigReader;
import lms.Utils.Env_Var;
import lms.Utils.commonMethods;

import static org.testng.Assert.*;

public class ProgramDelete_SD{

	TestContext testContext;
	WebDriver driver;
	Program_DeletePage pd;
	
	public ProgramDelete_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.pd = testContext.getPd();
	}
	
	@When("Admin clicks Delete program button on the data table for any row")
	public void admin_clicks_delete_program_button_on_the_data_table_for_any_row() throws InterruptedException {
		pd.createProgramForDelete();
		pd.deleteConfirmPopup();
	}

	@Then("Admin should see an alert open with heading {string} along with <YES> and <NO> button for program deletion")
	public void admin_should_see_an_alert_open_with_heading_along_with_yes_and_no_button_for_program_deletion(String string) throws InterruptedException {
		assertTrue(commonMethods.validator(pd.getText("Confirm"),"Confirm"));
		assertTrue(pd.YesButton.isDisplayed());
		assertTrue(pd.NoButton.isDisplayed());
	}
	
	@Then("Admin should see a message {string} for program deletion")
	public void admin_should_see_a_message_for_program_deletion(String string) throws InterruptedException {
		String expectedText = "Are you sure you want to delete " +pd.getText("delProgName")+ "?";
		assertTrue(commonMethods.validator(pd.getText("AreYouSure"),expectedText));
	}

	@When("Admin clicks <NO> button on the alert after clicking on Delete program button")
	public void admin_clicks_no_button_on_the_alert_after_clicking_on_delete_program_button() throws InterruptedException {
		pd.deleteConfirmPopup();
		pd.clickNoButton();
	}

	@Then("Admin can see the deletion alert disappears without deleting program")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting_program() throws InterruptedException {
		assertTrue((pd.getText("delProgName").contains("Del")));
	}
	
	@When("Admin clicks Cancel or Close Icon on Deletion alert after clicking on Delete program button")
	public void admin_clicks_cancel_close_x_icon_on_deletion_alert_after_clicking_on_delete_program_button() throws InterruptedException {
		pd.deleteConfirmPopup();
		pd.clickCancelButton();
	}
	
	@When("Admin clicks <YES> button on the alert after clicking on Delete program button")
	public void admin_clicks_yes_button_on_the_alert_after_clicking_on_delete_program_button() throws InterruptedException {
		pd.deleteConfirmPopup();
		pd.clickYesButton();
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) throws InterruptedException {
		assertTrue(commonMethods.validator(pd.getSuccessDeleteMessageText(),"Successful Program Deleted"));
		pd.searchdeletedProgram1();
		assertTrue((pd.ShowingZeroText).getText().equals("Showing 0 to 0 of 0 entries"));
	}
	
	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() throws InterruptedException {
		pd.selectOneCheckbox();     
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() throws InterruptedException {
	     assertTrue((pd.deleteMultipleProgramsButton).isEnabled());
	}

	@When("Admin clicks <NO> button on the alert after selecting Single checkbox")
	public void admin_clicks_no_button_on_the_alert_after_selecting_single_checkbox() throws InterruptedException {
		pd.selectNoOneCheckbox();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() throws InterruptedException {
	     pd.searchdeletedProgram1();
	     assertTrue((pd.deleteprogramName1).isDisplayed());
	}
	
	@When("Admin clicks <NO> button on the alert after selecting multiple checkboxes")
	public void admin_clicks_no_button_on_the_alert_after_selecting_multiple_checkboxes() throws InterruptedException {
		pd.selectNoMultipleCheckboxes();
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() throws InterruptedException {
		pd.searchdeletedProgram();
	    assertTrue((pd.deleteprogramName1).isDisplayed());
	    assertTrue((pd.deleteprogramName2).isDisplayed());
	}

	@When("Admin clicks <YES> button on the alert after selecting Single checkbox")
	public void admin_clicks_yes_button_on_the_alert_after_selecting_single_checkbox() throws InterruptedException {
		pd.selectYesOneCheckbox();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() throws InterruptedException {
		assertTrue(commonMethods.validator(pd.getSuccessProgramsDeleteMessageText(),"Successful Programs Deleted"));
		pd.searchdeletedProgram1();
	    assertTrue((pd.ShowingZeroText).getText().equals("Showing 0 to 0 of 0 entries"));
	    Env_Var.programNameDel.remove(0);
	}
	
	@When("Admin clicks <YES> button on the alert after selecting multiple checkboxes")
	public void admin_clicks_yes_button_on_the_alert_after_selecting_multiple_checkboxes() throws InterruptedException {
		pd.selectYesMultipleCheckboxes();
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() throws InterruptedException {
		assertTrue(commonMethods.validator(pd.getSuccessProgramsDeleteMessageText(),"Successful Programs Deleted"));
		pd.searchdeletedProgram1();
	    assertTrue((pd.ShowingZeroText).getText().equals("Showing 0 to 0 of 0 entries"));
	    pd.searchdeletedProgram2();
	    assertTrue((pd.ShowingZeroText).getText().equals("Showing 0 to 0 of 0 entries"));

	}

}


