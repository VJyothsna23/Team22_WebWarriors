package lms.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import lms.Utils.dynamicGenerator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lms.Utils.*;
import lms.Utils.ConfigReader;
import lms.Utils.ExcelReader;

public class Batch_DeletePage {
 	
	WebDriver driver;
	ExcelReader reader = new ExcelReader();
	Batch_DeletePage bd;
	
	@FindBy (xpath  = "//input[@id='username']") WebElement userlogin;
	@FindBy (xpath  = "//input[@id='password']") WebElement passwordlogin;
	@FindBy(xpath = "//button[@id='login']") public  WebElement loginbtn;
	@FindBy(xpath = "//span[text()='Batch']") public  WebElement batchbtn;
	@FindBy(id = "new") public  WebElement addNewBatchButton;
	@FindBy(id = "batchName") public  WebElement batchName;
	@FindBy(id = "batchDescription") public  WebElement batchDesc;
	@FindBy(xpath = "//div[@role='button']/span") public  WebElement programNameDropdownButton;
	@FindBy(xpath = "//ul[@role='listbox']/p-dropdownitem[1]") public  WebElement programNameDDOption;
	@FindBy(id = "batchNoOfClasses") public  WebElement batchNoOfClasses;
	@FindBy(id = "batchStatus") public  WebElement batchStatus;
	@FindBy(xpath = "//input[@id='ACTIVE']/../..") public  WebElement activeButton;
	@FindBy(xpath = "//input[@id='Inactive']/../../..") public  WebElement inactiveButton;
	@FindBy(xpath = "//span[text()='Save']") public  WebElement saveButton;
	@FindBy(xpath = "//span[text()='Confirm']") public  WebElement confirmText;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-trash']") public  WebElement deleteBatchButton;
	@FindBy(xpath = "//span[@class='p-confirm-dialog-message ng-tns-c133-123']") public  WebElement areYouSureText;
	

	
	public Batch_DeletePage(WebDriver driver){
		this.driver= driver;
        PageFactory.initElements(driver, this);
       bd= new Batch_DeletePage (driver);
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
	
	public void batchbtn() {
	  	  batchbtn.click();
	  	//addNewBatchButton.click();
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
	
	public void clickDeleteBatch() {
		deleteBatchButton.click();
	}
	
//	public void deleteConfirmPopupBatch() throws InterruptedException {
//		bd.search(ConfigReader.readPropertiesFile("DelProgramName"));
//		Thread.sleep(1000);		
//		clickDeleteBatch();
//		Thread.sleep(1000);
//		LoggerLoad.info("**************Admin is on the Delete Batch confirmation popup");
//	}
//	
//	public String getText(String ele) {
//		String text;
//		if(ele.equals("Confirm")){
//			text = confirmText.getText();
//		}else if(ele.equals("AreYouSure")){
//			text = areYouSureText.getText();
//		}else {
//			text = deleteprogramName1.getText();
//			this.deleteBatchButton = text;
//		}	
//		return text;
//	}
}
