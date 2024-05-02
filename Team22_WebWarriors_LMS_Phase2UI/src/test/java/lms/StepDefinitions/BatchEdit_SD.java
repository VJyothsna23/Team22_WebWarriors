package lms.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Batch_AddPage;
import lms.PageFactory.Batch_EditPage;
import lms.PageFactory.Program_DeletePage;
import lms.PageFactory.Program_EditPage;
import lms.Utils.ConfigReader;
import lms.Utils.Env_Var;
import lms.Utils.commonMethods;

import static org.testng.Assert.*;

public class BatchEdit_SD{

	TestContext testContext;
	WebDriver driver;
	Batch_EditPage be;
	
	public BatchEdit_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.be = testContext.getBe();
	}
	
	@When("Admin navigates to Manage Batch page")
	public void admin_navigates_to_manage_batch_page() {
	    be.clickBatchButton();
	}

	@When("Admin clicks on Edit icon corresponding to a batch")
	public void admin_clicks_on_edit_icon_corresponding_to_a_batch() throws InterruptedException {
		be.createBatchForEdit();
		be.editBatchDetailsWindow();
	}

	@Then("Admin should see a popup open for Batch details to edit")
	public void admin_should_see_a_popup_open_for_batch_details_to_edit() {
		assertTrue(commonMethods.validator(be.getBatchDetailsText(),"Batch Details"));
	}

	@When("Admin updates the fields with valid values and clicks save")
	public void admin_updates_the_fields_with_valid_values_and_clicks_save() throws InterruptedException {
		be.editBatchDetailsWindow();
		be.editBatchDetails();
	}

	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() {
		assertTrue(commonMethods.validator(be.batchDescColumnValue.getText(),"Team22"));
		assertTrue(commonMethods.validator(be.batchStatusColumnValue.getText(),"ACTIVE"));
		assertTrue(commonMethods.validator(be.batchClassesValue.getText(),"20"));
		
	}

	@When("Admin updates the batch fields with invalid values and clicks save")
	public void admin_updates_the_batch_fields_with_invalid_values_and_clicks_save() throws InterruptedException {
		be.editBatchDetailsWindow();
		be.editBatchDetailsInvalid();
	}

	@Then("Error message should appear for Edit Batch")
	public void error_message_should_appear_for_Edit_Batch() {
		String expectedError = "This field should start with an alphabet and min 2 character.";
		assertTrue(be.getBatchDescErrorMessage().contains(expectedError));
	}

	@When("Erase data from mandatory field in edit batch")
	public void erase_data_from_mandatory_field_in_edit_batch() throws InterruptedException {
		be.editBatchDetailsWindow();
		be.emptyBatchClasses();
	}
	
	@Then("Error message should appear while editing Batch")
	public void error_message_should_appear_while_editing_Batch() {
		String expectedError = "Number of classes is required.";
		assertTrue(be.getBatchClassesErrorMessage().contains(expectedError));
	}

	@When("Erase data from description field")
	public void erase_data_from_description_field() throws InterruptedException {
		be.editBatchDetailsWindow();
		be.emptyBatchDesc();
	}
	
	@Then("The updated batch description should appear on the data table")
	public void the_updated_batch_description_should_appear_on_the_data_table() {
		assertTrue(commonMethods.validator(be.batchDescColumnValue.getText(),""));
		
	}
	

}


