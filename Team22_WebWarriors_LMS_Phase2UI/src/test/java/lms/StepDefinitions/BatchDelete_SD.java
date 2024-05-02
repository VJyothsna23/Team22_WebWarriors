package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Batch_DeletePage;
import lms.PageFactory.Program_DeletePage;
import lms.PageFactory.Program_EditPage;
import lms.Utils.ConfigReader;
import lms.Utils.Env_Var;
import lms.Utils.commonMethods;

import static org.testng.Assert.*;

public class BatchDelete_SD{

	TestContext testContext;
	WebDriver driver;
	Batch_DeletePage bd;
	
	public BatchDelete_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.bd = testContext.getBd();
	}
	
	@When("Admin clicks Delete batch icon on the data table for any row")
	public void admin_clicks_delete_batch_icon_on_the_data_table_for_any_row() throws InterruptedException {
		bd.createBatchForDelete();
		bd.deleteConfirmPopup();
	}

	@Then("Admin should see an alert open with heading {string} along with <YES> and <NO> option for batch deletion")
	public void admin_should_see_an_alert_open_with_heading_along_with_yes_and_no_option_for_batch_deletion(String string) {
		assertTrue(commonMethods.validator(bd.getConfirmText(),"Confirm"));
		assertTrue(bd.YesButton.isDisplayed());
		assertTrue(bd.NoButton.isDisplayed());
	}

	@When("Admin clicks <NO> option on the alert after clicking on Delete batch icon")
	public void admin_clicks_no_option_on_the_alert_after_clicking_on_delete_batch_icon() throws InterruptedException {
		bd.deleteConfirmPopup();
		bd.clickNoButton();
		bd.searchdeletedBatch1();
	}

	@Then("Admin should see that the Batch is still listed in data table")
	public void admin_should_see_that_the_batch_is_still_listed_in_data_table() {
		assertTrue((bd.deletebatchName1).isDisplayed());
	}
	
	@When("Admin clicks <YES> option on the alert after clicking on Delete batch icon")
	public void admin_clicks_yes_option_on_the_alert_after_clicking_on_delete_batch_icon() throws InterruptedException {
		bd.deleteConfirmPopup();
		bd.clickYesButton();
	}

	@Then("Admin gets a message {string} alert and able to see that batch is deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_batch_is_deleted_in_the_data_table(String string) throws InterruptedException {
		assertTrue(commonMethods.validator(bd.getSuccessDeleteMessageText(),"Successful batch Deleted"));
		bd.searchdeletedBatch1();
	    assertTrue((bd.ShowingZeroText).getText().equals("Showing 0 to 0 of 0 entries"));
	    Env_Var.bName.remove(0);
	}

	@When("None of the checkboxes in data table are selected in manage Batch Page")
	public void none_of_the_checkboxes_in_data_table_are_selected_in_manage_batch_page() {
	   System.out.println("None of the check boxes are selected");
	}

	@Then("Admin should see that the delete icon under the Manage Batch header is disabled")
	public void admin_should_see_that_the_delete_icon_under_the_manage_batch_header_is_disabled() {
		assertFalse((bd.deleteMultipleBatchesButton).isEnabled());
	}

	@When("Admin clicks <YES> button on the alert after selecting Single checkbox for a batch row")
	public void admin_clicks_yes_button_on_the_alert_after_selecting_single_checkbox_for_a_batch_row() throws InterruptedException {
		bd.selectYesOneCheckbox();
	}

	@Then("Admin should see the selected Batch is deleted from the data table")
	public void admin_should_see_the_selected_batch_is_deleted_from_the_data_table() throws InterruptedException {
		assertTrue(commonMethods.validator(bd.getSuccessBatchesDeleteMessageText(),"Successful Batches Deleted"));
		bd.searchdeletedBatch1();
	    assertTrue((bd.ShowingZeroText).getText().equals("Showing 0 to 0 of 0 entries"));
	}

	@When("Admin clicks <YES> button on the alert after selecting multiple checkboxes for batches")
	public void admin_clicks_yes_button_on_the_alert_after_selecting_multiple_checkboxes_for_batches() throws InterruptedException {
		bd.selectYesMultipleCheckboxes();
	}

	@Then("Admin should see the selected Batches deleted from the data table")
	public void admin_should_see_the_selected_batches_deleted_from_the_data_table() throws InterruptedException {
		assertTrue(commonMethods.validator(bd.getSuccessBatchesDeleteMessageText(),"Successful Batches Deleted"));
		bd.searchdeletedBatch1();
	    assertTrue((bd.ShowingZeroText).getText().equals("Showing 0 to 0 of 0 entries"));
	    bd.searchdeletedBatch2();
	    assertTrue((bd.ShowingZeroText).getText().equals("Showing 0 to 0 of 0 entries"));
	}

}


