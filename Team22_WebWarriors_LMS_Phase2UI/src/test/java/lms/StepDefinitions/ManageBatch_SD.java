package lms.StepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Batch_ManagePage;
import lms.PageFactory.Program_ManagePage;
import lms.Utils.commonMethods;

public class ManageBatch_SD {

	TestContext testContext;
	WebDriver driver;
	Batch_ManagePage bm;
	Program_ManagePage pm;
	
	public ManageBatch_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.bm = testContext.getBm();
		this.pm = testContext.getPm();
	}

	
	@Given("User logs in to the LMS application as Admin")
	public void user_logs_in_to_the_lms_application_as_admin() {
		bm.clickbatch();
	}

	@When("Admin clicks on Batch link from the header")
	public void admin_clicks_on_batch_link_from_the_header() {
	    bm.clikbatch();
	}

	@Then("Admin should see URL with {string} when in batch page")
	public void admin_should_see_url_with_when_in_batch_page(String string) {
		assertTrue(bm.validatePage().contains("batch"));
	}

	@Then("Admin should be able to see the {string} in the header")
	public void admin_should_be_able_to_see_the_in_the_header(String string) {
		assertTrue(commonMethods.validator(bm.HeaderVaidation(), "Manage Batch"));
	}

	@Then("Admin should see the pagination controls under the data table in batch page")
	public void admin_should_see_the_pagination_controls_under_the_data_table_in_batch_page() {
	  // assertTrue();
	    assertTrue(pm.paginationcontrol());
	}

	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, Edit, Delete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
	    assertTrue(bm.headerTextValidation());
	}

	@Then("Admin should be able to see the Delete icon button that is disabled")
	public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() {
	    assertTrue(bm.topDelete());
	}

	@Then("Admin should be able to see the {string} button in batch page")
	public void admin_should_be_able_to_see_the_button_in_batch_page(String string) {
		
		assertTrue(bm.addNewBatchButton());
	}

	@Then("Admin should be able to see Each row in the data table should have a checkbox")
	public void admin_should_be_able_to_see_each_row_in_the_data_table_should_have_a_checkbox() throws InterruptedException {
		pm.collectAllCheckBoxes(pm.totalPagesCount());
		for (WebElement checkbox : pm.checkBoxes) {
	           Assert.assertTrue(checkbox.isDisplayed());
	        }
	}

	@Then("Admin should be able to see Each row in the data table should have a edit icon that is enabled")
	public void admin_should_be_able_to_see_each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() throws InterruptedException {
		pm.collectAllEditButtons(pm.totalPagesCount());
		for (WebElement editbutton : pm.editProgramButton) {
	           Assert.assertTrue(editbutton.isDisplayed());
		}
	}

	@Then("Admin should be able to see Each row in the data table should have a delete icon that is enabled")
	public void admin_should_be_able_to_see_each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() throws InterruptedException {
		pm.collectAllDeleteButtons(pm.totalPagesCount());
		for (WebElement deletebutton : pm.eachrowdeleteProgramsButton) {
	           Assert.assertTrue(deletebutton.isDisplayed());
	        }
	}

	@When("Admin clicks {string} button batch page")
	public void admin_clicks_button_batch_page(String string) {
	    bm.addNewBatch();
	}

	@Then("Admin should be able to see a new pop up with Batch details")
	public void admin_should_be_able_to_see_a_new_pop_up_with_batch_details() {
		assertTrue(bm.addNewBatchButton());
	}

}

