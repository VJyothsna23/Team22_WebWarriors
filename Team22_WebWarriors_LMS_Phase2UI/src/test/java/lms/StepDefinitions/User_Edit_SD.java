package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.User_EditPage;

public class User_Edit_SD {
	

	TestContext testContext;
	WebDriver driver;
	User_EditPage ue;

	
	public User_Edit_SD (TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.ue = testContext.getUe();
	
	 }
		
		
	@Given("Admin is on Manage User page in EditUSer Module")
	public void admin_is_on_manage_user_page_in_edit_u_ser_module() throws InterruptedException {
		 ue.dashboard_page_login();
		  Thread.sleep(1000);
		  ue.clickUser();
	 }

	
	
	@When("Admin clicks on the edit icon in userpage")
	public void admin_clicks_on_the_edit_icon_in_userpage() throws InterruptedException {
		  ue.searchuserinsb();
		  Thread.sleep(1000);
		  ue.clickedituserbutton();
	 }

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() {
	Assert.assertTrue(ue.userdetailstext.isDisplayed());  
		
	  }
	
	@When("Update the fields with valid data and click submit in userpage")
	public void update_the_fields_with_valid_data_and_click_submit_in_userpage() throws InterruptedException {
		 ue.updatefieldswithvaliddata();
	 }
	
	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String actmsg) {
	   
		Assert.assertEquals(actmsg, ue.successmessage.getText());
		
	 }

	@When("Update the fields with invalid values and click submit in userpage")
	public void update_the_fields_with_invalid_values_and_click_submit_in_userpage() throws InterruptedException {
	    ue.updatefieldswithInvaliddata();
	 }

	@Then("Admin should get Error message")
	public void admin_should_get_error_message() {
	   String actmsg="Failed";
	   String expmsg=ue.errormessage.getText();
	  // Assert.assertEquals(actmsg, expmsg);
	   Assert.assertTrue(actmsg.contains(expmsg));
		
	 }

	@When("Update the mandatory fields with valid values and click submit in userpage")
	public void update_the_mandatory_fields_with_valid_values_and_click_submit_in_userpage() throws InterruptedException {
	    ue.mandatoryfields();
	 }

	@When("Update the optional fields with valid values and click submit in userpage")
	public void update_the_optional_fields_with_valid_values_and_click_submit_in_userpage() throws InterruptedException {
	    ue.optionalfields();
	 }


       @When("Admin enters only numbers or special char in the text fields in userpage")
       public void admin_enters_only_numbers_or_special_char_in_the_text_fields_in_userpage() throws InterruptedException {
	    
		ue.onlyspecharornumber();
	 }

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() throws InterruptedException {
	    ue.userupdatesdetailsandclickcancelbutton();
		
	}

	@Then("Admin can see the User details popup disappears and can see nothing changed for particular User")
	public void admin_can_see_the_user_details_popup_disappears_and_can_see_nothing_changed_for_particular_user() {
	   
		for (WebElement uenamelist : ue.Usernamlist) {
	        if(	uenamelist.equals("Kim")) {
	        	ue.edituserutton.click();
	        	Assert.assertFalse((ue.firstname.getText()).equals("Kim"));
	        	
	        	
	        }
	 		
		}
		
	}	
	
}
