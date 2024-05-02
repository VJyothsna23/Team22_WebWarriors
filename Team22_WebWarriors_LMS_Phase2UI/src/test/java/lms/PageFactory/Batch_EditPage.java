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

public class Batch_EditPage {
	
	public WebDriver driver;
	Batch_AddPage BAP;
	Program_EditPage PEP;
	
	@FindBy(xpath = "//tbody//tr[1]//td[7]//button[1]") public  WebElement editBatchButton;
	@FindBy(xpath = "//span[text()='Batch Details']") public  WebElement BatchDetailsText;
	@FindBy(xpath = "//input[@id='ACTIVE']/../../..") public  WebElement activeButton;
	@FindBy(xpath = "//input[@id='INACTIVE']/../../..") public  WebElement inactiveButton;
	
	@FindBy(xpath = "//tbody//tr[1]//td[2]") public  WebElement batchNameColumnValue;
	@FindBy(xpath = "//tbody//tr[1]//td[3]") public  WebElement batchDescColumnValue;
	@FindBy(xpath = "//tbody//tr[1]//td[4]") public  WebElement batchStatusColumnValue;
	@FindBy(xpath = "//tbody//tr[1]//td[5]") public  WebElement batchClassesValue;
	@FindBy(xpath = "//tbody//tr[1]//td[6]") public  WebElement progNameValue;
	@FindBy(xpath = "//small[text()='This field should start with an alphabet and min 2 character.']") public  WebElement batchDescInvalidError;
	@FindBy(xpath = "//small[text()='Batch Description is required.']") public  WebElement batchDescEmptyError;
	@FindBy(xpath = "//small[text()='Number of classes is required.']") public  WebElement batchClassesError;
	
	public Batch_EditPage(WebDriver driver){
		
		this.driver = driver;
        PageFactory.initElements(driver, this);
        BAP = new Batch_AddPage(driver);
        PEP = new Program_EditPage(driver);
    }
	
	public void clickBatchButton() {
		BAP.batchButton.click();
	}
	
	public void createBatchForEdit() throws InterruptedException {	
		BAP.addNewBatchButton.click();
		String batchname = dynamicGenerator.generatebatchNameForEdit();
		BAP.batchName.sendKeys(batchname);
		Env_Var.batchName = batchname ;
		Thread.sleep(1000);
		BAP.batchDesc.sendKeys("team22");
		BAP.programNameDropdownButton.click();
		Thread.sleep(1000);
		BAP.programNameDDOption.click();
		Thread.sleep(1000);
		BAP.activeButton.click();
		BAP.batchNoOfClasses.sendKeys("15");
		BAP.saveButton.click();
		Thread.sleep(1000);
	}
	
	public void editBatchDetailsWindow() throws InterruptedException {
		PEP.search(ConfigReader.readPropertiesFile("editBatchName"));
		Thread.sleep(1000);		
		editBatchButton.click();
		Thread.sleep(1000);
		LoggerLoad.info("**************Admin is on the Edit Batch Details Window");
	}
	
	public String getBatchDetailsText() {
		String text = BatchDetailsText.getText();
		return text;
	}
	
	public void editBatchDetails() throws InterruptedException {
		BAP.batchDesc.clear();
		BAP.batchDesc.sendKeys("Team22");
		activeButton.click();
		BAP.batchNoOfClasses.clear();
		BAP.batchNoOfClasses.sendKeys("20");
		Thread.sleep(1000);
		BAP.saveButton.click();
	}
	
	public void editBatchDetailsInvalid() throws InterruptedException {
		BAP.batchDesc.clear();
		BAP.batchDesc.sendKeys("@#$%^&*");
		Thread.sleep(1000);
		BAP.saveButton.click();
	}
	
	public void emptyBatchDesc() throws InterruptedException {
		BAP.batchDesc.clear();
		Thread.sleep(1000);
		BAP.saveButton.click();
	}
	
	public void emptyBatchClasses() throws InterruptedException {
		BAP.batchNoOfClasses.clear();
		System.out.println("Updated Number of Classes are:"+ BAP.batchNoOfClasses.getText());
		BAP.batchNoOfClasses.click();
		Thread.sleep(3000);
		BAP.saveButton.click();
	}
	
	public String getBatchDescErrorMessage() {
		String value = batchDescInvalidError.getText();
		System.out.println("Actual Error appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Error appeared on the screen is: " + value);
		return value;
	}
	
	public String getBatchClassesErrorMessage() {
		String value = batchClassesError.getText();
		System.out.println("Actual Error appeared on the screen is: " + value);
		LoggerLoad.info("**************Actual Error appeared on the screen is: " + value);
		return value;
	}
}
