package lms.StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;

import lms.PageFactory.User_SortPage;

public class User_Sort_SD {
	
	TestContext testContext;
	WebDriver driver;
    User_SortPage us;
	
	public User_Sort_SD (TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.us = testContext.getUp();
	}	

	@Given("Admin logins into the application and clicks User from the navigationbar")
	public void admin_logins_into_the_application_and_clicks_user_from_the_navigationbar() throws InterruptedException {
		us.dashboard_page_login();
		Thread.sleep(1000);
		us.clickUser();
		
	}

	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() throws InterruptedException {
		us.dashboard_page_login();
		Thread.sleep(1000);
		us.clickUser();
		
	}
	
	@When("Admin clicks on ID sort icon")
	public void admin_clicks_on_id_sort_icon() throws InterruptedException {
	    us.IdSortAsecending();
	   
	}

	@Then("Admin should see User details are sorted by Id in ascendingorder")
	public void admin_should_see_user_details_are_sorted_by_id_in_ascendingorder() {
	   
		    List<String> originalList = us.getOriginalList("Id");
		    List<String> sortedList = us.getSortedList(originalList);
			assertTrue(originalList.equals(sortedList));
		
	}

	@When("Admin clicks on ID sort icon again")
	public void admin_clicks_on_id_sort_icon_again() throws InterruptedException {
	    us.IdSortDesecending();
	    
	}

	@Then("Admin should see User details  are sorted by Id  in descendingorder")
	public void admin_should_see_user_details_are_sorted_by_id_in_descendingorder() {
		List<String> originalList = us.getOriginalList("Id");
	    List<String> sortedList = us.getSortedListDescend(originalList);
		assertTrue(originalList.equals(sortedList)); 
		
	}

	@When("Admin clicks on name sort icon")
	public void admin_clicks_on_name_sort_icon() {
	    us.NameSortAsecending();
	}

	@Then("Admin should see User details are sorted by name in ascendingorder")
	public void admin_should_see_user_details_are_sorted_by_name_in_ascendingorder() {
		 List<String> originalList = us.getOriginalList("Name");
		    List<String> sortedList = us.getSortedList(originalList);
			assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks on name sort icon again")
	public void admin_clicks_on_name_sort_icon_again() throws InterruptedException {
	    us.NameSortDesecending();
	}

	@Then("Admin should see User details  are sorted by name  in descendingorder")
	public void admin_should_see_user_details_are_sorted_by_name_in_descendingorder() {
		List<String> originalList = us.getOriginalList("Name");
	    List<String> sortedList = us.getSortedListDescend(originalList);
		assertTrue(originalList.equals(sortedList)); 
	}

	@When("Admin clicks on Location sort icon")
	public void admin_clicks_on_location_sort_icon() {
	   us.locationSortAsecending();
	}

	@Then("Admin should see User details are sorted by Location in ascendingorder")
	public void admin_should_see_user_details_are_sorted_by_location_in_ascendingorder() {
		 List<String> originalList = us.getOriginalList("Location");
		    List<String> sortedList = us.getSortedList(originalList);
			assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks on Location sort icon again")
	public void admin_clicks_on_location_sort_icon_again() throws InterruptedException {
	  us.locationSortDesecending();
	}

	@Then("Admin should see User details  are sorted by Location  in descendingorder")
	public void admin_should_see_user_details_are_sorted_by_location_in_descendingorder() {
		List<String> originalList = us.getOriginalList("Location");
	    List<String> sortedList = us.getSortedListDescend(originalList);
		assertTrue(originalList.equals(sortedList)); 
	}

	@When("Admin clicks on Phone number sort icon")
	public void admin_clicks_on_phone_number_sort_icon() {
	   us.phnumSortAsecending();
	}

	@Then("Admin should see User details are sorted by Phone number in ascendingorder")
	public void admin_should_see_user_details_are_sorted_by_phone_number_in_ascendingorder() {
		    List<String> originalList = us.getOriginalList("Phone Number");
		    List<String> sortedList = us.getSortedListphone(originalList);
			assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks on phone number sort icon again")
	public void admin_clicks_on_phone_number_sort_icon_again() throws InterruptedException {
	   us.phnumSortDesecending();
	}
	@Then("Admin should see User details  are sorted by Phone number  in descendingorder")
	public void admin_should_see_user_details_are_sorted_by_phone_number_in_descendingorder() {
		List<String> originalList = us.getOriginalList("Phone Number");
	    List<String> sortedList = us.getSortedListDescend(originalList);
		assertTrue(originalList.equals(sortedList)); 
	}

}

	
	
	
	
	
	
	
	
	
	
	

