package lms.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;
import lms.Utils.LoggerLoad;

public class Program_EditPage {
	
	public static WebDriver driver;
	
	//Login Page
	@FindBy(id = "username") public  WebElement userLP;
	@FindBy(id = "password") public  WebElement passwordLP;
	@FindBy(id = "login") public  WebElement loginButton;
	
	//Dashboard Page
	@FindBy(id = "program") public  WebElement programButton;
	
	//Manage Program Page
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']") public  WebElement doubleRightArrow;
	@FindBy(id = "filterGlobal") public  WebElement searchbar;
	@FindBy(xpath = "//tbody//tr[1]//td[5]//button[1]") public  WebElement editProgramButton;
	@FindBy(xpath = "//tbody//tr[1]//td[2]") public  WebElement programNameColumnValue;
	@FindBy(xpath = "//tbody//tr[1]//td[3]") public  WebElement programDescColumnValue;
	@FindBy(xpath = "//tbody//tr[1]//td[4]") public  WebElement programStatusColumnValue;
	
	//Edit Program Details Window	
	@FindBy(id = "pr_id_2-label") public  WebElement programDetailsText;
	@FindBy(id = "programName") public  WebElement programName;
	@FindBy(id = "programDescription") public  WebElement programDesc;
	@FindBy(xpath = "//input[@id='Active']/../../..") public  WebElement activeButton;
	@FindBy(xpath = "//input[@id='Inactive']/../../..") public  WebElement inactiveButton;
	@FindBy(id = "saveProgram") public  WebElement saveButton;
	@FindBy(xpath = "//span[text()='Cancel']/..") public  WebElement cancelButton;
	@FindBy(xpath = "//div[@class='p-dialog-header-icons ng-tns-c132-8']") public  WebElement closeButton;
	@FindBy(xpath = "//*[@class='p-invalid ng-star-inserted']") public  WebElement editProgramErrorMessage;	

	
	@FindBy(xpath = "//div[@class='p-toast-summary ng-tns-c90-5']") public  WebElement successMessage;
	@FindBy(xpath = "//div[@class='p-toast-detail ng-tns-c90-5']") public  WebElement programUpdatedMessage;

	public Program_EditPage(WebDriver driver){
		
		this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void login() {	
		userLP.sendKeys(ConfigReader.readPropertiesFile("username"));
		passwordLP.sendKeys(ConfigReader.readPropertiesFile("password"));
		loginButton.click();
		LoggerLoad.info("**************Admin is logged in successfully");
	}
	
	public void search(String input) {
		searchbar.sendKeys(input);
	}
	
	public void clickEditProgram() {	
		editProgramButton.click();
	}
	
	public void editProgramDetailsWindow() throws InterruptedException {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
		login();
		programButton.click();
		search(ConfigReader.readPropertiesFile("ProgramName"));
		Thread.sleep(1000);		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		clickEditProgram();
		Thread.sleep(1000);
		LoggerLoad.info("**************Admin is on the Edit Program Details Window");
	}
	
	public String getProgramDetailsText() {
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		String text = programDetailsText.getText();
		return text;
	}
	
	public void editProgramName() throws InterruptedException {
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		programName.clear();
		programName.sendKeys("WEBMachine");
		
	}
	
	public void editProgramName(String value) throws InterruptedException {
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		programName.clear();
		programName.sendKeys(value);
		
	}
	
	public void editProgramDesc() throws InterruptedException {		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		programDesc.clear();
		programDesc.sendKeys("team22");
		
	}
	
	public void editProgramDesc(String value) throws InterruptedException {
		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		programDesc.clear();
		programDesc.sendKeys(value);
		
	}
	
	public void editProgramDetails() throws InterruptedException {
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		programName.clear();
		programName.sendKeys("WEB");
		programDesc.clear();
		programDesc.sendKeys("Team22");
//		activeButton.click();
		
	}
	
	public void clickActiveButton() {
		activeButton.click();
	}
	
	public void clickSave() {
		saveButton.click();
	}
	
	public void clickCancel() {
		cancelButton.click();
	}
	
	public String getSuccessMessageText() {
		String message1 = successMessage.getText();
		String message2 = programUpdatedMessage.getText();
		String message = message1+ " " + message2;
		System.out.println("Actual message appeared on the screen is: " + message);
		LoggerLoad.info("**************Actual Success message appeared on the screen is: " + message);
		return message;
	}
	
	public String getProgramNameColumnText() {
		String value = programNameColumnValue.getText();
		System.out.println("Actual Program Name appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Program Name appeared on the screen is: " + value);
		return value;
	}
	
	public String getProgramDescColumnText() {
		String value = programDescColumnValue.getText();
		System.out.println("Actual Program Description appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Program Description appeared on the screen is: " + value);
		return value;
	}
	
	public String getProgramStatusColumnText() {
		String value = programStatusColumnValue.getText();
		System.out.println("Actual Program Status appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Program Status appeared on the screen is: " + value);
		return value;
	}
	
	public String getEditProgramErrorMessage() {
		String value = editProgramErrorMessage.getText();
		System.out.println("Actual Error appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Error appeared on the screen is: " + value);
		return value;
	}
	
	
	public void editProgramStatus() throws InterruptedException {
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		inactiveButton.click();
		activeButton.click();
		// Changing it back to Active immediately because 
		//otherwise, the program is getting deleted immediately once it turns to Inactive status
		
	}
	
	
}
