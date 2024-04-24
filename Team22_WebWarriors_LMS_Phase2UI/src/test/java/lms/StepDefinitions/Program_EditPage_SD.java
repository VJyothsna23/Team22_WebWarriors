package lms.StepDefinitions;

import java.util.List;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.DriverFactory.TestContext;
import lms.PageFactory.Program_EditPage;

import static org.testng.Assert.*;

public class Program_EditPage_SD{

	TestContext testContext;
	WebDriver driver;
	Program_EditPage pe;
	
	public Program_EditPage_SD(TestContext testContext) { 
		this.testContext = testContext;
		this.driver = testContext.getDriver();
		this.pe = testContext.getPe();
	}
	
	

}


