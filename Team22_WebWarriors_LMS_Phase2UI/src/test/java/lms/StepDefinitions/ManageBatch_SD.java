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
	
//	@Given("User logs in to the LMS application as Admin and clicks on Batch link from the header")
//	public void user_logs_in_to_the_lms_application_as_admin_and_clicks_on_batch_link_from_the_header() {
//		bm.clickbatch();
//	}
//
//	@Then("Admin should be able to see the LMS text displayed on the header inside Manage Batch Page")
//	public void admin_should_be_able_to_see_the_lms_text_displayed_on_the_header_inside_manage_batch_page() {
//		System.out.println(bm.HeaderVaidation());
//	    assertTrue(commonMethods.validator(bm.HeaderVaidation(),"LMS - Learning Management System"));
//	}
//
//	@When("Admin clicks on {string} from the header inside the Manage Batch Page")
//	public void admin_clicks_on_from_the_header_inside_the_manage_batch_page(String pageLink) {
//		String nagPages=pageLink.trim().toLowerCase();
//		switch(nagPages) {
//		case "program" :
//			bm.clickprog();
//			break;
//		case "batch" :
//			bm.clikbatch();
//			break;
//		case "user" :
//			bm.clickuser();
//			break;
//		case "logout" :
//			bm.clickLogout();
//			break;
//		}
//	}
//
//	@Then("Admin should be redirected to the {string}")
//	public void admin_should_be_redirected_to_the(String pages) {
//		String nagPages=pages.trim().toLowerCase();
//		switch(nagPages) {
//		case "program" :
//			
//			assertTrue(bm.validatePage().contains(nagPages));
//			break;
//		case "batch" :
//			assertTrue(bm.validatePage().contains(nagPages));
//			break;
//		case "user" :
//			assertTrue(bm.validatePage().contains(nagPages));
//			break;
//		case "logout" :
//			assertTrue(bm.validatePage().contains(nagPages));
//			break;
//		}
//	}
//	
//	@When("Admin clicks  {string} from the header inside the Manage Batch Page")
//	public void admin_clicks_from_the_header_inside_the_manage_batch_page(String button) {
//		String batchButtons=button.trim().toLowerCase();
//		switch(batchButtons) {
//		case "addbatchdetails" :
//			bm.addNewBatch();
//			break;
//		case "editbatchdetails" :
//			bm.editBatch();
//			break;
//		case "deleteconfirmation" :
//			bm.deleteBatch();
//			break;
//		}
//	}
//
//	@Then("Admin should be redirected to the {string} in batch page")
//	public void admin_should_be_redirected_to_the_in_batch_page(String window) {
//		String batchButtons=window.trim().toLowerCase();
//		switch(batchButtons) {
//		case "" :
//			Assert.assertTrue(bm.validateAdd().contains("batch"));
//			break;
//		case "editbatch" :
//			Assert.assertTrue(bm.validateEdit().contains("batch"));
//			break;
//		case "deletebatch" :
//			Assert.assertTrue(bm.validateDelete().contains("batch"));
//			break;
//		}
//	}
//
//	@Then("Admin should see the data table on Manage Batch page With following {string}")
//	public void admin_should_see_the_data_table_on_manage_batch_page_with_following(String string) {
//	   
//	}
//
//	@Then("Admin should see the following {string} of data table in Manage Batch page for all the records")
//	public void admin_should_see_the_following_of_data_table_in_manage_batch_page_for_all_the_records(String string) {
//	    
//	}
//
//	@When("Admin searches with an existing {string} value in the search bar inside the Manage Batch Page")
//	public void admin_searches_with_an_existing_value_in_the_search_bar_inside_the_manage_batch_page(String string) {
//	    
//	}
//
//	@Then("Admin should be able to see the corresponding entry displayed")
//	public void admin_should_be_able_to_see_the_corresponding_entry_displayed() {
//	    
//	}
//
//	@When("Admin searches with Non existing value in the search bar inside the Manage Batch Page")
//	public void admin_searches_with_non_existing_value_in_the_search_bar_inside_the_manage_batch_page() {
//		String invalidvalue="plmokn";
//	    bm.searchValidation(invalidvalue);
//	}
//
//	@Then("Admin should be able to see the error message")
//	public void admin_should_be_able_to_see_the_error_message() {
//		assertTrue(commonMethods.validator(bm.searchErrorMsg(),"Showing 0 to 0 of 0 entries"));
//	}
//
//	@When("Admin searches with existing value from unsupported columns in the search bar inside the Manage Batch Page")
//	public void admin_searches_with_existing_value_from_unsupported_columns_in_the_search_bar_inside_the_manage_batch_page() {
//	   String progName=	"Vase";
//	   bm.searchValidation(progName);
//	}
//
//	@When("Admin selects the checkboxes corresponding to more than one Batch Name and clicks on Delete Batches button")
//	public void admin_selects_the_checkboxes_corresponding_to_more_than_one_batch_name_and_clicks_on_delete_batches_button() {
//	    bm.deleteMultiple();
//	}
//
//	@Then("Admin should be able to see the Delete Confirmation window")
//	public void admin_should_be_able_to_see_the_delete_confirmation_window() {
//	    
//	}
//
//	@When("Admin selects the checkbox corresponding to one Batch Name and clicks on Delete Batches button")
//	public void admin_selects_the_checkbox_corresponding_to_one_batch_name_and_clicks_on_delete_batches_button() {
//	    
//	}
//
//	@Then("Admin should be able to see the disabled Delete Batches button when none of the checkboxes are selected")
//	public void admin_should_be_able_to_see_the_disabled_delete_batches_button_when_none_of_the_checkboxes_are_selected() {
//	    
//	}
//
//	@When("Admin selects the checkbox next to the Batch Name in the data table header")
//	public void admin_selects_the_checkbox_next_to_the_batch_name_in_the_data_table_header() {
//	    
//	}
//
//	@Then("Admin should be able to select all the batches at once")
//	public void admin_should_be_able_to_select_all_the_batches_at_once() {
//	    
//	}
//
//	@Then("Admin should be able to see the text {string} below the table in the Manage Batch Page.")
//	public void admin_should_be_able_to_see_the_text_below_the_table_in_the_manage_batch_page(String string) {
//	    
//	}
//
//	@Then("Admin should be able to see the text {string} in the Manage Batch Page footer")
//	public void admin_should_be_able_to_see_the_text_in_the_manage_batch_page_footer(String string) {
//	    
//	}
//
//	@When("Admin click on Batch name column header to sort")
//	public void admin_click_on_batch_name_column_header_to_sort() {
//	    
//	}
//
//	@Then("Admin should see data table sorted in descending order")
//	public void admin_should_see_data_table_sorted_in_descending_order() {
//	    
//	}
//
//	@When("Admin double clicks on Batch name column header to sort")
//	public void admin_double_clicks_on_batch_name_column_header_to_sort() {
//	    
//	}
//
//	@Then("Admin should see data table sorted in ascending order")
//	public void admin_should_see_data_table_sorted_in_ascending_order() {
//	    
//	}

/////////////////////////////
	
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
