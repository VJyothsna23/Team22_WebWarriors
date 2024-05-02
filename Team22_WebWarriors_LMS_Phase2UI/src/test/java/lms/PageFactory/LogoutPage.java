package lms.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;
import lms.Utils.ExcelReader;

public class LogoutPage {

	WebDriver driver;
	ExcelReader reader = new ExcelReader();
	
	@FindBy (xpath  = "//input[@id='username']") WebElement userlogin;
	@FindBy (xpath  = "//input[@id='password']") WebElement passwordlogin;
	@FindBy(xpath = "//button[@id='login']") public  WebElement loginbtn;
	@FindBy (xpath  = "//span[text()='Logout']") WebElement logout;

	public LogoutPage(WebDriver driver){
		this.driver= driver;
        PageFactory.initElements(driver, this);

    }
	
	public void url() {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
	}
	
	public void validcredentials() throws InvalidFormatException, IOException {
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Login.xlsx", "Sheet1");
		String user=testData.get(0).get("User");
		String password=testData.get(0).get("Password");
		userlogin.sendKeys(user);
		passwordlogin.sendKeys(password);
	}
	
	public void loginbtn() {
	  	  loginbtn.click();
	    }
	public void logoutbtn() {
		logout.click();
	    }
}
