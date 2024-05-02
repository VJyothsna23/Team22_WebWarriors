package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.User_ManagePage;

public class User_Manage_SD {
	
	TestContext testContext;
	WebDriver driver;
	User_ManagePage um;
	
	public User_Manage_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.um = testContext.getUm();
	}	


	
	@Given("Admin logins into the application")
	public void admin_logins_into_the_application() throws InterruptedException {
		um.dashboard_page_login();
		
	 	}

	@When("Admin clicks User from navigation bar")
	public void admin_clicks_user_from_navigation_bar() throws InterruptedException {
		um.clickUser();
		
	}

	@Then("Admin should see the Manage User in the URL")
	public void admin_should_see_the_manage_user_in_the_url() {
		 //um.checkurl();
		 Assert.assertTrue(driver.getCurrentUrl().contains("user"));
	}
	
	@Then("Admin should see a heading with text Manage user on the page")
	public void admin_should_see_a_heading_with_text_manage_user_on_the_page() {
		//um.checkmangeuser();
		Assert.assertTrue(um.manageuser.isDisplayed());
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table in the user page")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_in_the_user_page(String string) throws InterruptedException {
	   Thread.sleep(2000);
		um.entries();
	  Assert.assertTrue(um.paginationcontrol());    
	    
		
	}
	

	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_column_names_id_name_location_phone_number_edit_delete() {
	    um.validateHeaders();
	}
	


	@Then("Admin should see a Delete button on the top left hand side as Disabled in the user page")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled_in_the_user_page() {
		 Assert.assertFalse(um.deletebuttondisabled.isEnabled()); 
	}


	@Then("Admin should be able to see the {string} button above the data table in the user page")
	public void admin_should_be_able_to_see_the_button_above_the_data_table_in_the_user_page(String button) {
	 um.checkbuttondisplay(button);
	}

	@Then("Admin should be able to see the search text box above the data table in the user page")
	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table_in_the_user_page() {
		Assert.assertTrue(um.searchbox.isDisplayed());
	}

	@Then("Admin should see five  records displayed on the data table")
	public void admin_should_see_two_records_displayed_on_the_data_table() {
		 Assert.assertEquals(5, um.rows.size());
	}
	
	
	@Then("Each row in the data table should have a checkbox in the user page")
	public void each_row_in_the_data_table_should_have_a_checkbox_in_the_user_page() throws InterruptedException {
	   
		um.collectAllCheckBoxes(um.totalPagesCount());
		 for (WebElement checkbox : um.checkboxesUser) {
	           Assert.assertTrue(checkbox.isDisplayed());
	        }
		
	}
	@Then("Each row in the data table should have a edit icon that is enabled in the user page")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled_in_the_user_page() throws InterruptedException {
		
		um.collectAllediticons(um.totalPagesCount());
		 for (WebElement editicon : um.editbuttons) {
	           Assert.assertTrue(editicon.isEnabled());
	        }
	}

	@Then("Each row in the data table should have a delete icon that is enabled in the user page")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled_in_the_user_page() throws InterruptedException {
		um.collectAlldeleteicons(um.totalPagesCount());
		 for (WebElement deleteicon : um.deletebuttons) {
	           Assert.assertTrue(deleteicon.isEnabled());
	        }
	}
	
	@When("Admin enters user name into search box.")
	public void admin_enters_user_name_into_search_box() throws InterruptedException {
	    um.searchuserinsb();
		
	}

	
	@Then("Admin should see user displayed with the entered name")
	public void admin_should_see_user_displayed_with_the_entered_name() {
		 for (WebElement unamelist : um.Usernamlist) {
			 System.out.println(um.Usernamlist);
	           Assert.assertTrue (unamelist.getText().contains("Div"));
	        }
	}

	@When("Admin enters the keywords not present in the data table on the Search box")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box() throws InterruptedException {
	   
		um.entersunrelatedkeywords();
	}

	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() {
	
		 Assert.assertEquals(0, um.rows.size());
		
	}
	
	
	
	
	
	
	
	
	
	
}
