package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Batch_AddPage;
import lms.PageFactory.Program_DeletePage;
import lms.PageFactory.Program_EditPage;
import lms.Utils.ConfigReader;
import lms.Utils.Env_Var;
import lms.Utils.commonMethods;

import static org.testng.Assert.*;

public class BatchAdd_SD{

	TestContext testContext;
	WebDriver driver;
	Batch_AddPage ba;
	
	public BatchAdd_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.ba = testContext.getBa();
	}
	
	@When("Admin is on Manage Batch page after clicking Batch on the navigation bar")
	public void admin_is_on_manage_batch_page_after_clicking_batch_on_the_navigation_bar() {
	    ba.addBatchDetailsWindow();
	}
	
	@Then("Admin should be able to see the {string} for Add Batch as {string}")
	public void admin_should_be_able_to_see_the_for_add_batch_as(String string, String string2) {
		if(string.equalsIgnoreCase("Name")){
			ba.batchName.isDisplayed();
			Assert.assertEquals(commonMethods.getattribute(ba.batchName,"type"),"text");
		}else if(string.equalsIgnoreCase("Description")){
			ba.batchDesc.isDisplayed();
			Assert.assertEquals(commonMethods.getattribute(ba.batchDesc,"type"),"text");
		}else if(string.equalsIgnoreCase("Program Name")){
			ba.programNameDropdownButton.isDisplayed();
			Assert.assertTrue(commonMethods.getattribute(ba.programNameDropdownButton,"class").contains("dropdown"));
		}else if(string.equalsIgnoreCase("Status")){
			ba.batchStatus.isDisplayed();
			Assert.assertEquals(commonMethods.getElementTagName(ba.batchStatus),"p-radiobutton");
		}else{
			ba.batchNoOfClasses.isDisplayed();
			Assert.assertEquals(commonMethods.getElementTagName(ba.batchNoOfClasses),"input");
		}
	}

	@When("Admin enters all the fields except description with valid values and clicks save for Add Batch")
	public void admin_enters_all_the_fields_except_description_with_valid_values_and_clicks_save_for_add_batch() throws InterruptedException {
	    ba.createBatchWithoutDesc();
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() throws InterruptedException {
	    assertEquals(ba.searchForCreatedProgram(),Env_Var.batchName);
	}
	
	@When("Admin enters valid data in all the fields and clicks save button for Add Batch")
	public void admin_enters_valid_data_in_all_the_fields_and_clicks_save_button_for_add_batch() throws InterruptedException {
	    ba.createBatch();
	}
	
	@When("Admin enters {string} for the field while creating a Batch")
	public void admin_enters_for_the_field_while_creating_a_batch(String string) throws InterruptedException {
		if(string.equals("Numeric values")) {
			ba.addBatchName("2345678");
			ba.addBatchDesc("2345678");
		}else {
			ba.addBatchName("#$%^&*");
			ba.addBatchDesc("#$%^&*");
		}
	}

	@Then("Admin should see the error message for Add Batch")
	public void admin_should_see_the_error_message_for_add_batch() {
		String expectedError = "This field should start with an alphabet and min 2 character.";
		assertTrue(ba.getAddBatchErrorMessage().contains(expectedError));
	}

	@When("Admin leaves empty values for the Mandatory fields while creating a Batch")
	public void admin_leaves_empty_values_for_the_Mandatory_fields_while_creating_a_batch() throws InterruptedException {
			ba.createBatchWithoutMandatoryFields();
	}

	@Then("Admin should see the error messages for Add Batch")
	public void admin_should_see_the_error_messages_for_add_batch() {
		assertTrue(ba.getEmptyBatchNameError().contains("Batch Name is required."));
		assertTrue(ba.getEmptyProgNameError().contains("Program Name is required."));
		assertTrue(ba.getEmptyStatusError().contains("Status is required."));
		assertTrue(ba.getEmptyClassesError().contains("Number of classes is required."));
	}
	

}


