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
import lms.PageFactory.Program_PaginationPage;
import lms.Utils.commonMethods;

import static org.testng.Assert.*;

import lms.DriverFactory.TestContext;
import lms.PageFactory.Program_ManagePage;

public class ProgramPagination_SD {
	

	TestContext testContext;
	WebDriver driver;
	Program_PaginationPage pp;
	Program_ManagePage pm;
	
	
	public ProgramPagination_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.pp = testContext.getPp();
		this.pm = testContext.getPm();
	}

	@Given("Manage program data table consists of more than {int} pages")
	public void manage_program_data_table_consists_of_more_than_pages(Integer pages) throws InterruptedException {
	    pp.pages(pages);
	}

	@Then("Admin should be able to see {string} and {string} icons to be enabled")
	public void admin_should_be_able_to_see_and_icons_to_be_enabled(String next, String last) {
		System.out.println(pp.isFirstNextPreviousLastIconEnabled(next));
		Assert.assertTrue(pp.isFirstNextPreviousLastIconEnabled(next));
	}

	@When("Admin clicks {string} icon")
	public void admin_clicks_icon(String iconlink) throws InterruptedException {
		String icon = iconlink.trim().toLowerCase();

		if(icon.equals("last")) {
			pp.firstNextPreviousLast("last");
		}
		else if(icon.equals("next")) {
			pp.firstNextPreviousLast("next");
		}
		else if(icon.equals("previous")) {
			pp.firstNextPreviousLast("previous");
		}
		else if(icon.equals("first")) {
			pp.firstNextPreviousLast("first");	
		}
	}

	@Then("Admin is navigated to Page {int}")
	public void admin_is_navigated_to_page(Integer pageNum) {
	    pp.isPageHighlighted(pageNum);
	}

	@Then("Admin is navigated to Last page with {string} page link disabled")
	public void admin_is_navigated_to_last_page_with_page_link_disabled(String icon) throws InterruptedException {
	   Assert.assertTrue(pp.isPageHighlighted(pp.totalPagesCount()));//if page is highlighted
	   String nexticon = icon.trim().toLowerCase();

		if(nexticon.equals("next")) {
			pp.isFirstNextPreviousLastIconEnabled("next");
		}
	   
	}

	@When("Admin navigates to page {int}")
	public void admin_navigates_to_page(Integer int1) {
	    pp.navigateToPageNumber(int1);
	}

	@When("Admin navigates to Page {int} clicks on {string} icon")
	public void admin_navigates_to_page_clicks_on_icon(Integer page, String icon) throws InterruptedException {
		 pp.navigateToPageNumber(page);
		 pp.firstNextPreviousLast(icon);
	}
	
	@When("Admin is on the Last page and clicks first icon")
	public void admin_is_on_the_last_page_and_clicks_first_icon() throws InterruptedException {
	    pp.firstNextPreviousLast("last");
	    Thread.sleep(1000);
	    pp.firstNextPreviousLast("first");
	    Thread.sleep(1000);
	}

	@Then("Admin is navigated to First page with {string} page link disabled")
	public void admin_is_navigated_to_first_page_with_page_link_disabled(String icon) throws InterruptedException {
		 Assert.assertTrue(pp.isPageHighlighted(1));//if page is highlighted
		   
		 
//		 String nexticon = icon.trim().toLowerCase();
//
//			if(nexticon.equals("previous")) {
//				pp.isFirstNextPreviousLastIconEnabled("previous");
//			}
	}

}