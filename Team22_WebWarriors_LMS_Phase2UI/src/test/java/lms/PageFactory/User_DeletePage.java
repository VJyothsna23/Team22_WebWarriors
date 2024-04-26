package lms.PageFactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;

public class User_DeletePage {
	
	public static WebDriver driver;
	
	//Login Page
		@FindBy(id = "username") public  WebElement userLP;
		@FindBy(id = "password") public  WebElement passwordLP;
		@FindBy(id = "login") public  WebElement loginButton;
	
	@FindBy(id = "user") public WebElement eleUser;
	@FindBy(className = "box") public WebElement eleManageUser;
	
	@FindBy(xpath = "(//span[@class='p-button-icon pi pi-trash'])[2]")public WebElement eleDeleteUser;
	@FindBy(xpath = "//span[text()='Confirm']") public WebElement eleConfirm;
	
	@FindBy(xpath = "//span[text()='Yes']") public WebElement eleYes;
	@FindBy(xpath = "//div[@role='alert']") public WebElement eleSuccess;
	
	@FindBy(xpath = "//span[text()='No']") public WebElement eleNo;
	
	@FindBy(xpath = "(//span[text()='Confirm']//following::div//button)[1]") public WebElement eleCloseIcon;
	
	public User_DeletePage(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void test() {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
		userLP.sendKeys(ConfigReader.readPropertiesFile("username"));
		passwordLP.sendKeys(ConfigReader.readPropertiesFile("password"));
		loginButton.click();
	}

	public void clickUser() {
		eleUser.click();
	}
	
	public String verifyManageUserPage() {
		String cardTitle = eleManageUser.getText();
		return cardTitle;
	}
	
	public void clickDelete() {
		eleDeleteUser.click();
	}	
	
	public String isConfirm() {
		String eleActualValue = eleConfirm.getText();
		return eleActualValue;
	}
	
	public void isAlertYes() throws InterruptedException {
		Thread.sleep(2000);
        eleYes.click();
	}
	
	public String successAlert() {
		String text = eleSuccess.getText().replaceAll("\\n", " ").trim();
		System.out.println(text);
		return text;
	}
	
	public void isAlertNo() throws InterruptedException {
		Thread.sleep(2000);
        eleNo.click();
        isDisplayed(eleConfirm);
   	}
	
	public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	public void isAlertClosed() {
		eleCloseIcon.click();
	}
	
}
