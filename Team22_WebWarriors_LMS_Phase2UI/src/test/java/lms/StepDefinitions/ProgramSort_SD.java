package lms.StepDefinitions;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Program_EditPage;
import lms.PageFactory.Program_SortPage;
import lms.Utils.ConfigReader;
import lms.Utils.commonMethods;

import static org.testng.Assert.*;

public class ProgramSort_SD{

	TestContext testContext;
	WebDriver driver;
	Program_SortPage ps;
	
	public ProgramSort_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.ps = testContext.getPs();
	}
	
	@Given("Admin is on Manage Program page after clicking Program on the navigation bar")
	public void admin_is_on_manage_program_page_after_clicking_program_on_the_navigation_bar() {
		ps.getOnManageProgramPage();
	}

	@When("Admin clicks the sort icon of program name column once")
	public void admin_clicks_the_sort_icon_of_program_name_column_once() throws InterruptedException {
	    ps.clickProgramNameSortAsecending();
	}

	@Then("The data get sorted on the table based on the program name column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {
	    List<String> originalList = ps.getOriginalList("programName");
	    List<String> sortedList = ps.getSortedList(originalList);
		assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks the sort icon of program name column twice")
	public void admin_clicks_the_sort_icon_of_program_name_column_twice() throws InterruptedException {
		ps.clickProgramNameSortDesecending();
	}

	@Then("The data get sorted on the table based on the program name column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
		List<String> originalList = ps.getOriginalList("programName");
	    List<String> sortedList = ps.getSortedListDescend(originalList);
		assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks the sort icon of program Desc column once")
	public void admin_clicks_the_sort_icon_of_program_desc_column_once() {
		ps.clickProgramDescSortAsecending();
	}

	@Then("The data get sorted on the table based on the program description column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
		List<String> originalList = ps.getOriginalList("programDescription");
	    List<String> sortedList = ps.getSortedList(originalList);
		assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks the sort icon of program Desc column twice")
	public void admin_clicks_the_sort_icon_of_program_desc_column_twice() throws InterruptedException {
		ps.clickProgramDescSortDesecending();
	}

	@Then("The data get sorted on the table based on the program description column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {
		List<String> originalList = ps.getOriginalList("programDescription");
	    List<String> sortedList = ps.getSortedListDescend(originalList);
		assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks the sort icon of program Status column once")
	public void admin_clicks_the_sort_icon_of_program_status_column_once() {
		ps.clickProgramStatusSortAsecending();
	}

	@Then("The data get sorted on the table based on the program status column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {
		List<String> originalList = ps.getOriginalList("programStatus");
	    List<String> sortedList = ps.getSortedList(originalList);
		assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks the sort icon of program Status column twice")
	public void admin_clicks_the_sort_icon_of_program_status_column_twice() throws InterruptedException {
		ps.clickProgramStatusSortDesecending();
	}

	@Then("The data get sorted on the table based on the program status column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
		List<String> originalList = ps.getOriginalList("programStatus");
	    List<String> sortedList = ps.getSortedListDescend(originalList);
		assertTrue(originalList.equals(sortedList));
	}

}


