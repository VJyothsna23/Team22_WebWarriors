package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;
import lms.Utils.Env_Var;
import lms.Utils.LoggerLoad;
import lms.Utils.dynamicGenerator;

public class Batch_AddPage {
	
	public WebDriver driver;
	Program_EditPage PEP;

		//Dashboard Page
		@FindBy(id = "batch") public  WebElement batchButton;	
		
		//Manage Batch Page
		@FindBy(id = "filterGlobal") public  WebElement searchbar;
		@FindBy(id = "new") public  WebElement addNewBatchButton;
		
		//Add Batch Details Window	
		@FindBy(xpath = "//span[text()='Batch Details']") public  WebElement batchDetailsText;
		@FindBy(id = "batchName") public  WebElement batchName;
		@FindBy(id = "batchDescription") public  WebElement batchDesc;
		@FindBy(xpath = "//div[@role='button']/span") public  WebElement programNameDropdownButton;
		@FindBy(xpath = "//ul[@role='listbox']/p-dropdownitem[1]") public  WebElement programNameDDOption;
		@FindBy(id = "batchNoOfClasses") public  WebElement batchNoOfClasses;
		@FindBy(id = "batchStatus") public  WebElement batchStatus;		
		@FindBy(xpath = "//input[@id='ACTIVE']/../..") public  WebElement activeButton;
		@FindBy(xpath = "//input[@id='Inactive']/../../..") public  WebElement inactiveButton;
		@FindBy(xpath = "//span[text()='Save']") public  WebElement saveButton;		
		
		@FindBy(xpath = "//tbody//tr[1]//td[2]") public  WebElement batchNameColumnValue;
		@FindBy(xpath = "//tbody//tr[1]//td[3]") public  WebElement batchDescColumnValue;
		@FindBy(xpath = "//tbody//tr[1]//td[4]") public  WebElement batchStatusColumnValue;
		@FindBy(xpath = "//tbody//tr[1]//td[5]") public  WebElement batchNoOfClassesColumnValue;
		@FindBy(xpath = "//tbody//tr[1]//td[6]") public  WebElement programNameColumnValue;
		@FindBy(id = "text-danger") public  WebElement batchInvalidInputErrorMessage;
		@FindBy(xpath = "//small[text()='Batch Name is required. ']") public  WebElement batchNameEmptyError;
		@FindBy(xpath = "//small[text()='Program Name is required.']") public  WebElement progNameEmptyError;
		@FindBy(xpath = "//small[text()='Status is required.']") public  WebElement StatusEmptyError;
		@FindBy(xpath = "//small[text()='Number of classes is required.']") public  WebElement batchClassesEmptyError;
		
	public Batch_AddPage(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
        PEP = new Program_EditPage(driver);
    }
	
	public void addBatchDetailsWindow() {
		batchButton.click();
		addNewBatchButton.click();
	}
	 
	public void createBatch() throws InterruptedException {	
		String batchname = dynamicGenerator.generatebatchNameForAdd();
		batchName.sendKeys(batchname);
		Env_Var.batchName = batchname ;
		batchDesc.sendKeys("team22");
		programNameDropdownButton.click();
		Thread.sleep(1000);
		programNameDDOption.click();
		Thread.sleep(1000);
		activeButton.click();
		batchNoOfClasses.sendKeys("10");
		saveButton.click();
		Thread.sleep(1000);
	}
	
	public void createBatchWithoutDesc() throws InterruptedException {	
		batchName.sendKeys(dynamicGenerator.generatebatchNameForAdd());
		programNameDropdownButton.click();
		Thread.sleep(1000);
		programNameDDOption.click();
		Thread.sleep(1000);
		activeButton.click();
		batchNoOfClasses.sendKeys("10");
		saveButton.click();
		Thread.sleep(1000);
	}
	
	public String searchForCreatedProgram() throws InterruptedException {
		PEP.search(Env_Var.batchName);
		Thread.sleep(1000);		
		String createdBatchName = batchNameColumnValue.getText();
		return createdBatchName;
	}
	
	public void addBatchName(String value) throws InterruptedException {

		batchName.sendKeys(value);		
	}
	
	public void addBatchDesc(String value) throws InterruptedException {		

		batchDesc.sendKeys(value);		
	}
	
	public void addBatchNoOfClasses(String value) throws InterruptedException {

		batchNoOfClasses.sendKeys(value);		
	}
	
	public String getAddBatchErrorMessage() {
		String value = batchInvalidInputErrorMessage.getText();
		System.out.println("Actual Error appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Error appeared on the screen is: " + value);
		return value;
	}
	
	public void createBatchWithoutMandatoryFields() throws InterruptedException {	
		batchDesc.sendKeys("team22");
		saveButton.click();
		Thread.sleep(2000);
	}
	
	public String getEmptyBatchNameError() {
		String value = batchNameEmptyError.getText();
		System.out.println("Actual Error appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Error appeared on the screen is: " + value);
		return value;
	}
	
	public String getEmptyProgNameError() {
		String value = progNameEmptyError.getText();
		System.out.println("Actual Error appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Error appeared on the screen is: " + value);
		return value;
	}
	
	public String getEmptyStatusError() {
		String value = StatusEmptyError.getText();
		System.out.println("Actual Error appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Error appeared on the screen is: " + value);
		return value;
	}
	
	public String getEmptyClassesError() {
		String value = batchClassesEmptyError.getText();
		System.out.println("Actual Error appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Error appeared on the screen is: " + value);
		return value;
	}
	
}
