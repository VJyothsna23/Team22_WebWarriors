package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_AddPage {

	@FindBy(xpath = "//h1[text()='Preparing for the Interviews']") public  WebElement homePageText;
	@FindBy(xpath = "//button[text()='Get Started']") public  WebElement getStartedButtonHP;
	@FindBy(linkText = "Data Structures") public  WebElement dsDropDown;
	@FindBy(xpath = "//a[@class='dropdown-item']") public  List<WebElement> dsDropDownOptions;
	@FindBy(xpath = "//a[text()=' Register ']") public  WebElement registerLink;
	@FindBy(xpath = "//a[text()='Sign in']") public  WebElement signInLink;
	@FindBy(xpath = "//input[@value='Register']") public  WebElement registerButton;
	@FindBy(xpath = "//*[@class='card-title']") public  List<WebElement> dsModuleTitles;
	@FindBy(xpath = "//h5[text()='Data Structures-Introduction']/../a[text()='Get Started']") public  WebElement getStartedButton_DSIntroductionModule;
	@FindBy(xpath = "//div[@class='alert alert-primary']") public  WebElement notLoggedInAlert;
	@FindBy(linkText = "Register!") public  WebElement pleaseRegisterMessageLink;
	@FindBy(name = "username") public WebElement username;
	@FindBy(name = "password") public WebElement password;

	public User_AddPage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
