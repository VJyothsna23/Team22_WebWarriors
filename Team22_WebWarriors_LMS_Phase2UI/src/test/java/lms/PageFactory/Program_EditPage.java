package lms.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms.Utils.ConfigReader;
import lms.Utils.Env_Var;
import lms.Utils.LoggerLoad;
import lms.Utils.dynamicGenerator;

public class Program_EditPage {
	
	public WebDriver driver;
	
	//Login Page
	@FindBy(id = "username") public  WebElement userLP;
	@FindBy(id = "password") public  WebElement passwordLP;
	@FindBy(id = "login") public  WebElement loginButton;
	
	//Dashboard Page
	@FindBy(id = "program") public  WebElement programButton;
	
	//Manage Program Page
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']") public  WebElement doubleRightArrow;
	@FindBy(id = "filterGlobal") public  WebElement searchbar;
	@FindBy(id = "new") public  WebElement addNewProgramButton;
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

	//Pagination
	@FindBy(xpath = "//tbody/tr/td[1]") public List<WebElement> checkBoxes;
//	@FindBy(xpath = "//button[@class='p-paginator-next p-paginator-element p-link p-ripple']") public  WebElement nextPageButton;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']") public  WebElement nextPageButton;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']/..") public  WebElement nextPageButtonDisabled;
	@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-double-right']") public  WebElement doubleRightButton;
	@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-double-left']") public  WebElement doubleLeftButton;
	@FindBy(xpath = "//button[@class = 'p-paginator-page p-paginator-element p-link p-highlight p-ripple ng-star-inserted']") public  WebElement lastPage;
	
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
		searchbar.clear();
		searchbar.sendKeys(input);
	}
	
	public void clickEditProgram() {	
		editProgramButton.click();
	}
	
	public void onDashBoardPage() {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
		login();
	}
	
	public void clickProgramButton() {
		programButton.click();
	}
	
	public void editProgramDetailsWindow() throws InterruptedException {
		search(ConfigReader.readPropertiesFile("ProgramName"));
		Thread.sleep(1000);		
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
		programName.sendKeys("WebMachine");		
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
		Thread.sleep(1000);	
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		programDesc.clear();
		programDesc.sendKeys(value);		
	}
	
	public void editProgramDetails() throws InterruptedException {
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		programName.clear();
		programName.sendKeys(Env_Var.programNameEdit.get(0));
		programDesc.clear();
		programDesc.sendKeys("Team22");		
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
	
	public String getSuccessMessageText() throws InterruptedException {
		Thread.sleep(1000);	
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
	}
	
	public void createProgramForEdit() throws InterruptedException {
		addNewProgramButton.click();
		String progName = dynamicGenerator.generateProgramNameForEdit();
		programName.sendKeys(progName);
		Env_Var.programNameEdit.add(progName);
		System.out.println("Progrm names created so far are: "+ Env_Var.programNameEdit);
		programDesc.sendKeys("Team22");
		activeButton.click();
		saveButton.click();
		Thread.sleep(1000);
	}
	
	public void goToNextPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    wait.until(ExpectedConditions.elementToBeClickable(nextPageButton)).click();
    }
	
	public int totalPagesCount() throws InterruptedException {
		int totalPages;
		doubleRightButton.click();
		String totalPagesText = lastPage.getText();
		totalPages = Integer.parseInt(totalPagesText);
		doubleLeftButton.click();
		Env_Var.totalNoOfPages = totalPages;
		System.out.println("Total numner of pages are: "+ totalPages);
		return totalPages;
    }
	
	public int collectAllCheckBoxes(int totalpages) throws InterruptedException {
		int counter = 1;
		List<WebElement> checkboxes = new ArrayList<>();
		checkboxes.addAll(checkBoxes);
		while ( counter < totalpages) {
	            goToNextPage();
//	            Thread.sleep(1000);
	            checkboxes.addAll(checkBoxes);
	            counter++;
	     }
		System.out.println("Total number of checkboxes are: " + checkboxes.size());
		return checkboxes.size();
	}
	
}
