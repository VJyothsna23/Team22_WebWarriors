package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.User_AddPage;
import lms.Utils.commonMethods;

public class User_Add_SD {
	
	

	TestContext testContext;
	WebDriver driver;
	User_AddPage ua;
	
//	User_AddPage uap ;
	
	
	public User_Add_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.ua = testContext.getUa();
	}
	
	

	@Given("Admin is on Add new user page")
	public void admin_is_on_add_new_user_page() throws InterruptedException {
		 ua.dashboard_page_login();
	       Thread.sleep(1000);
		   ua.clickUser();
		   Thread.sleep(1000);
		   ua.addnewuser();
		   Thread.sleep(1000);
	}
	
	
	@Then("Admin should see pop up open for user details with First Name,Middle name, Last Name,Location,phone, email, linkedin url, User Role, Role status,visa status,Undergraduate, postgraduate,time zone,user comments and user fields along with Cancel,Submit and close buttons")
	public void admin_should_see_pop_up_open_for_user_details_with_first_name_middle_name_last_name_location_phone_email_linkedin_url_user_role_role_status_visa_status_undergraduate_postgraduate_time_zone_user_comments_and_user_fields_along_with_cancel_submit_and_close_buttons() {
	    
		ua.checkallfields();
	}

	
	@Then("Admin should see  text boxes for the fields First Name, Middle name, Last Name, Location, phone, email,linkedin url, Undergraduate, postgraduate,time zone ,user comments and drop downs for the fields User Role, Role status, visa status on user details pop up")
	public void admin_should_see_text_boxes_for_the_fields_first_name_middle_name_last_name_location_phone_email_linkedin_url_undergraduate_postgraduate_time_zone_user_comments_and_drop_downs_for_the_fields_user_role_role_status_visa_status_on_user_details_pop_up() {
	 
		ua.checktextboxordropdown();
		
	}

	@When("Admin enters mandatory fields in the form and clicks on submit button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_submit_button() throws InterruptedException {
	    ua.adminentersallfields();
	}

	@Then("Admin gets message User added Successfully")
	public void admin_gets_message_user_added_successfully() {
	    System.out.println("User added successfully");
	}

	@When("Admin skips to add value in mandatory field")
	public void admin_skips_to_add_value_in_mandatory_field() throws InterruptedException {
	    ua.userskipsvaluesinmandatoryfields();
	}

	
	@When("Admin enters invalid data in all of the  fields in the form and clicks on submit button")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_submit_button() throws InterruptedException {
	    ua.userentersinvalidvalues();
		
	}

	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() throws InterruptedException {
	   ua.userentersnodata();
	  }
	
	@Then("Admin gets error message and user is not created")
    public void admin_gets_error_message_and_user_is_not_created() {
	 for (WebElement errormessage : ua.errors) {
           Assert.assertTrue(errormessage.getText().contains("required"));
       }
      }

//  	@When("Admin enters {string}, {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
//	    public void admin_enters(String Firstname, String Middlename, String Lastname, String Location , String Phonenumber, String LinkedInUrl, String Email, String Undergraduate, String Postgraduate, String Timezone, String Usercomments, String Userrole, String Userrolestatus, String UServisastatus) throws InterruptedException {
//	        
//       ua.adminenterdetails(Firstname, Middlename, Lastname, Location, Phonenumber, LinkedInUrl, Email, Undergraduate, Postgraduate, Timezone, Usercomments, Userrole, Userrolestatus, UServisastatus);
//		
//       }
	
	
	@When("Admin clicks Close Icon on User Details form")
	public void admin_clicks_close_icon_on_user_details_form() throws InterruptedException {
	    ua.userentersdetailandclickcloseicon();
	}

	@When("Admin clicks Cancel button on User Details form")
	public void admin_clicks_cancel_button_on_user_details_form() throws InterruptedException {
	   ua.userentersdetailandclickcancelbutton();
	}
	

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() throws InterruptedException {
		ua.searchbox.sendKeys("neeya");
		commonMethods.waitForElementToBeVisible(driver, ua.paginationtext);
		Thread.sleep(1000);
		Assert.assertEquals(ua.paginationtext.getText(), "Showing 0 to 0 of 0 entries");
		
		 }
	}


	
	
	
	


