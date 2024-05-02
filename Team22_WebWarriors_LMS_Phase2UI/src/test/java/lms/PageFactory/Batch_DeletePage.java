package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.DriverFactory.TestContext;
import lms.Utils.ConfigReader;
import lms.Utils.Env_Var;
import lms.Utils.LoggerLoad;
import lms.Utils.dynamicGenerator;

public class Batch_DeletePage {
	
	public WebDriver driver;
	Batch_AddPage BAP;
	Program_EditPage PEP;
 	
	@FindBy(xpath = "//tbody//tr[1]//td[7]//span[@class='p-button-icon pi pi-trash']") public  WebElement deleteBatchButton;
	@FindBy(xpath = "//tbody//tr[1]//td[2]") public  WebElement deletebatchName1;
	@FindBy(xpath = "//tbody//tr[2]//td[2]") public  WebElement deletedbatchName2;
	@FindBy(xpath = "//span[text()='Confirm']") public  WebElement confirmText;
	@FindBy(xpath = "//span[@class='p-confirm-dialog-message ng-tns-c133-4']") public  WebElement areYouSureText;
	@FindBy(xpath = "//span[text()='Yes']") public  WebElement YesButton;
	@FindBy(xpath = "//span[text()='No']") public  WebElement NoButton;
	@FindBy(xpath = "//button[@class='ng-tns-c133-4 p-dialog-header-icon p-dialog-header-close p-link ng-star-inserted']") public  WebElement cancelButton;
	@FindBy(xpath = "//div[text()='Successful']") public  WebElement successMessage;
	@FindBy(xpath = "//div[text()='batch Deleted']") public  WebElement batchDeletedMessage;
	@FindBy(xpath = "//div[text()='Batches Deleted']") public  WebElement batchesDeletedMessage;
	@FindBy(xpath = "//div[@class='p-toast-message-text ng-tns-c90-16 ng-star-inserted']") public  WebElement successBatchDeletedMessage;
	
	@FindBy(xpath = "//tbody//tr[1]//td[1]/p-tablecheckbox") public  WebElement firstCheckbox;
	@FindBy(xpath = "//tbody//tr[2]//td[1]/p-tablecheckbox") public  WebElement secondCheckbox;
	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']") public  WebElement deleteMultipleBatchesButton;
	@FindBy(xpath = "//span[text()='Showing 0 to 0 of 0 entries']") public  WebElement ShowingZeroText;
	
	public Batch_DeletePage(WebDriver driver){
		
		this.driver = driver;
        PageFactory.initElements(driver, this);
        BAP = new Batch_AddPage(driver); 
        PEP = new Program_EditPage(driver);
    }
	
	public void createBatchForDelete() throws InterruptedException {
		BAP.addNewBatchButton.click();
		String batchname = dynamicGenerator.generatebatchNameForDelete();
		BAP.batchName.sendKeys(batchname);
		Env_Var.bName.add(batchname);
		Thread.sleep(1000);
		BAP.batchDesc.sendKeys("team22");
		BAP.programNameDropdownButton.click();
		Thread.sleep(1000);
		BAP.programNameDDOption.click();
		Thread.sleep(1000);
		BAP.activeButton.click();
		BAP.batchNoOfClasses.sendKeys("10");
		BAP.saveButton.click();
		Thread.sleep(1000);
	}
	
	public void deleteConfirmPopup() throws InterruptedException {
		PEP.search(ConfigReader.readPropertiesFile("DelBatchName"));
		Thread.sleep(1000);		
		deleteBatchButton.click();
		Thread.sleep(1000);
		LoggerLoad.info("**************Admin is on the Delete Batch confirmation popup");
	}
	
	public String getConfirmText() {
		String text;
		text = confirmText.getText();
		return text;
	}
	
	public void clickYesButton() {
		YesButton.click();
	}
	
	public void clickNoButton() {
		NoButton.click();
	}
	
	public String getsuccessText() {
		String message = successBatchDeletedMessage.getText();
		System.out.println("Actual message appeared on the screen is: " + message);
		return message;
	}
	
	public void searchdeletedBatch1() throws InterruptedException {
		PEP.search(Env_Var.bName.get(0));
		Thread.sleep(1000);				
	}
	
	public void searchdeletedBatch2() throws InterruptedException {
		PEP.search(Env_Var.bName.get(1));
		Thread.sleep(1000);				
	}
	
	public String getSuccessDeleteMessageText() {
		String message1 = successMessage.getText();
		String message2 = batchDeletedMessage.getText();
		String message = message1+ " " + message2;
		System.out.println("Actual message appeared on the screen is: " + message);
		LoggerLoad.info("**************Actual Success message appeared on the screen is: " + message);
		return message;
	}
	
	public String getSuccessBatchesDeleteMessageText() {
		String message1 = successMessage.getText();
		String message2 = batchesDeletedMessage.getText();
		String message = message1+ " " + message2;
		System.out.println("Actual message appeared on the screen is: " + message);
		LoggerLoad.info("**************Actual Success message appeared on the screen is: " + message);
		return message;
	}
	
	public void selectOneCheckbox() throws InterruptedException {
		PEP.search(ConfigReader.readPropertiesFile("DelBatchName"));
		Thread.sleep(1000);
		firstCheckbox.click();
	}
	
	public void selectTwoCheckboxes() throws InterruptedException {
		createBatchForDelete();
		selectOneCheckbox();
//		Thread.sleep(1000);
		secondCheckbox.click();
	}
	
	public void selectYesOneCheckbox() throws InterruptedException {
		createBatchForDelete();
		selectOneCheckbox();
		deleteMultipleBatchesButton.click();
		Thread.sleep(1000);
		YesButton.click();
	}
	
	public void selectYesMultipleCheckboxes() throws InterruptedException {
		selectTwoCheckboxes();
		Thread.sleep(1000);
		deleteMultipleBatchesButton.click();
		YesButton.click();
		Thread.sleep(1000);
	}
	
}
