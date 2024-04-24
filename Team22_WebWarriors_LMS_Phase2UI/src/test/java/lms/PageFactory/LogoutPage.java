package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	@FindBy(xpath = "") public  WebElement LMSText;
	@FindBy(xpath = "") public  WebElement NinjaImage;
	@FindBy(xpath = "") public  WebElement PleaseLoginText;
	@FindBy(name = "User") public WebElement username;
	@FindBy(name = "Password") public WebElement password;
	@FindBy(xpath = "//button[text()='Login']") public  WebElement LoginButton;	

	public LogoutPage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
