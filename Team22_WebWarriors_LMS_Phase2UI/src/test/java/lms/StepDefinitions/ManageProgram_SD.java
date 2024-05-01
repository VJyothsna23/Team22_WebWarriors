package lms.StepDefinitions;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Program_ManagePage;
import lms.Utils.commonMethods;

import static org.testng.Assert.*;

public class ManageProgram_SD {

	TestContext testContext;
	WebDriver driver;
	Program_ManagePage pm;
	
	public ManageProgram_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.pm = testContext.getPm();
	}
	
	//login 
	@Given("Admin logins into the application and is on the dashboard page")
	public void admin_logins_into_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	   pm.dashboard_page_login();
	   assertTrue(commonMethods.validator(pm.dashboard_page(),"LMS"));
	}
	

	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_on_the_navigation_bar() {
		pm.clickprogram();
	}

	//vaildate url
	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String partialurlText) {
	   Assert.assertTrue(pm.manageprogramurl().contains(partialurlText));//this is failing
	}

	//manageprogramtext
	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String manageprog) {
		assertTrue(commonMethods.validator(pm.manageprmtext(),manageprog));
	}

	//pagination validation
	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
		assertTrue(pm.paginationcontrol());
		//Assert.assertTrue("Showing" + x +);
	}

	//total row msg validation
	@Then("Admin should see the footer as {string}.")
	public void admin_should_see_the_footer_as(String string) {
	    Assert.assertTrue(pm.footerdisplay());
	   
	}

	//delete button validation
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
	    Assert.assertFalse(pm.deletebutton());
	}

	//addnewprgm validation
	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
		assertTrue(commonMethods.validator(pm.addnewprgm(),"A New Program"));
	}
	
	//
	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer tablerowsize) {
		assertEquals(pm.rowsize(), tablerowsize);
	}

	@Then("Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
	    
		pm.validateHeaders();
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	    pm.checkSortIcon();
		
	}

	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() throws InterruptedException {
		pm.collectAllCheckBoxes(pm.totalPagesCount());
		for (WebElement checkbox : pm.checkBoxes) {
	           Assert.assertTrue(checkbox.isDisplayed());
	        }
	}

	@Then("Admin should see the Edit buttons on each row of the data table")
	public void admin_should_see_the_edit_buttons_on_each_row_of_the_data_table() throws InterruptedException {
		pm.collectAllEditButtons(pm.totalPagesCount());
		for (WebElement editbutton : pm.editProgramButton) {
	           Assert.assertTrue(editbutton.isDisplayed());
		}
	
	}
	
	@Then("Admin should see the Delete buttons on each row of the data table")
	public void admin_should_see_the_delete_buttons_on_each_row_of_the_data_table() throws InterruptedException {
		pm.collectAllDeleteButtons(pm.totalPagesCount());
		for (WebElement deletebutton : pm.eachrowdeleteProgramsButton) {
	           Assert.assertTrue(deletebutton.isDisplayed());
	        }
	}
	

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String search) {
		assertTrue(commonMethods.validator(pm.searchTextBox(),search)); 	
		
	}
//Navigation to other pages
	
	@Given("Admin logins into the application and is on the manage program pages")
	public void admin_logins_into_the_application_and_is_on_the_manage_program_page_for_navigating_other_pages() {
	    pm.dashboard_page_login();
	    pm.clickprogram();
	}
	
	@When("Admin clicks on {string} link on Manage Program page")
	public void admin_clicks_on_link_on_manage_program_page(String page) throws InterruptedException {
	    switch(page) {
	    case "Batch":
	    	pm.batchPage();
	    	break;
	    case "User":
	    	pm.userPage();
	    	break;
	    case "Logout":
	    	pm.logoutPage();
	    	break;
	    }
	}


	@Then("Admin is re-directed to {string} page")
	public void admin_is_re_directed_to_page(String page) {
		
		String corrpages =page.trim().toLowerCase();
		   switch(corrpages) {
		    case "Batch":
		    	Assert.assertTrue(pm.manageprogramurl().contains(corrpages));
		    	break;
		    case "User":
		    	Assert.assertTrue(pm.manageprogramurl().contains(corrpages));;
		    	break;
		    case "Logout":
		    	Assert.assertTrue(pm.manageprogramurl().contains("/login"));
		    	break;
		    }
	}

}


