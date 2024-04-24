package lms.Hooks;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lms.DriverFactory.TestContext;

public class Hooks {

	TestContext testContext;
	static WebDriver driver;
	
	public Hooks(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@Before
	public void setUp1(){
		testContext.setDriver(driver);
		driver = testContext.getDriver();
		testContext.initializePageObjects(driver);				
	}
	
	@After 
	public void tearDown(Scenario scenario) {
		
//		To take a screenshot if there is any failed scenario. 
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));//Allure report screenshot
			scenario.attach(screenshot, "image/png", "image");//Extent report screenshot
		}
		
		testContext.getDriver().quit();
	}

}


