package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;
import lms.Utils.commonMethods;

public class Batch_ManagePage {
	
	public static WebDriver driver;
	public static String next;
	
	@FindBy(xpath = "//button[@id='batch']") public  WebElement batchLinkBM;
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']") public  WebElement LMSValidation;
	@FindBy(xpath = "//button[@id='program']") public  WebElement programLinkBM;
	@FindBy(xpath = "//button[@id='user']") public  WebElement userLinkBM;
	@FindBy(xpath = "//button[@id='logout']") public  WebElement logoutLinkBM;
	@FindBy(xpath = "//button[@id='new']") public  WebElement addNewBatchButton;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-pencil']") public  WebElement editBatchButton;
	@FindBy(xpath = "//td//span[@class='p-button-icon pi pi-trash']") public  WebElement deleteBatchButton;	
	@FindBy(xpath = "//div[@role='dialog']") public  WebElement addNewBatchPage;
	@FindBy(xpath = "//span[@class='p-dialog-title ng-tns-c133-88 ng-star-inserted']") public  WebElement deleteButtonPage;
	@FindBy(xpath = "//thead//tr//th") public List<WebElement> colHeaders;
	@FindBy(xpath = "//input[@id='filterGlobal']") public  WebElement searchBarBM;
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']") public  WebElement searchBarErrorBM;
	@FindBy(xpath = "//span[@class='p-checkbox-icon']") public WebElement checkboxBM;
	@FindBy(xpath = "//div/button[@icon='pi pi-trash']") public  WebElement topdeleteBatchButton;	
	
	
	
	

	@FindBy(xpath = "//h1[text()='Manage Batch']") public  WebElement manageBatchText;
	@FindBy(xpath = "//button[text()='Delete Programs']") public  WebElement deleteBatchesButton;

	
	@FindBy(xpath = "//h1[text()='Batch Name']") public  WebElement BatchNameText;
	@FindBy(xpath = "//h1[text()='Batch Description']") public  WebElement BatchDescriptionText;
	@FindBy(xpath = "//h1[text()='Batch Status']") public  WebElement BatchStatusText;
	@FindBy(xpath = "//h1[text()='No of Classes']") public  WebElement noOfClassesText;
	@FindBy(xpath = "//h1[text()='Program Name']") public  WebElement programNameTextBM;
	@FindBy(xpath = "//h1[text()='EditDelete']") public  WebElement EditDeleteTextBM;
	@FindBy(xpath = "//button[text()='']") public  WebElement checkboxHeaderBM;
	@FindBy(xpath = "//button[text()='']") public  WebElement checkboxBatchNameEntry;
	@FindBy(xpath = "//button[text()='sort Up Arrow']") public  WebElement sortUpArrowBM;
	@FindBy(xpath = "//button[text()='sort Down Arrow']") public  WebElement sortDownArrowBM;
		
	@FindBy(xpath = "//h1[text()='In total there are number matches.']") public  WebElement totalBatchesText;
	
	//Elements that appear after clicking the Manage Batch Page Elements:
	@FindBy(xpath = "//h1[text()='Batch Details']") public  WebElement batchDetailsTextAddProgram;
	@FindBy(xpath = "//h1[text()='Batch Details']") public  WebElement batchDetailsTextEditProgram;
	@FindBy(xpath = "//h1[text()='Confirm']") public  WebElement confirmTextDeleteBatch;
	@FindBy(xpath = "//h1[text()='Confirm']") public  WebElement confirmTextDeleteBatches;
	
	@FindBy(id = "username") public  WebElement userLP;
	@FindBy(id = "password") public  WebElement passwordLP;
	@FindBy(id = "login") public  WebElement loginButton;

	public Batch_ManagePage(WebDriver driver){
		
		this.driver=driver;
        PageFactory.initElements(driver, this);

    }
	
	public void login() {	
		userLP.sendKeys(ConfigReader.readPropertiesFile("username"));
		passwordLP.sendKeys(ConfigReader.readPropertiesFile("password"));
		loginButton.click();
	}
	
	public void clickbatch() {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
		login();
		commonMethods.actionsClick(batchLinkBM,driver);
	}
	
	public String HeaderVaidation() {
		String header=LMSValidation.getText();
		return header;
	}
	
	public String validatePage() {
		String url=driver.getCurrentUrl();
		System.out.println(url);
		return url;
		
	}
	
	public void clickprog() {
		commonMethods.actionsClick(programLinkBM, driver);
	}
	
	public void clickuser() {
		commonMethods.actionsClick(userLinkBM, driver);
	}
	public void clikbatch() {
		commonMethods.actionsClick(batchLinkBM,driver);
	}
	public void clickLogout() {
		commonMethods.actionsClick(logoutLinkBM, driver);
	}
	
	public void addNewBatch() {
		commonMethods.actionsClick(addNewBatchButton, driver);
	}
	
	public void editBatch() {
		commonMethods.actionsClick(editBatchButton, driver);
	}
	public void deleteBatch() {
		commonMethods.actionsClick(deleteBatchButton, driver);
	}
	
	public String validateAdd() {
		String add=addNewBatchPage.getText();
		return add;
	}
	
	public String validateEdit() {
		String edit=addNewBatchPage.getText();
		return edit;
	}
	
	public String validateDelete() {
		String del=deleteButtonPage.getText();
		return del;
	}
	
	public void validateHeaders() {
		for(WebElement col:colHeaders) {
			String headerName=col.getText();
			
		}
	}
	
	public void searchValidation(String invalidvalue) {
		commonMethods.actionsSendKeys(driver, searchBarBM,invalidvalue);
	}
	
	public String searchErrorMsg() {
		String errmsg=searchBarErrorBM.getText();
		return errmsg;
	}
	
	public void deleteMultiple() {
		commonMethods.actionsClick(checkboxBM, driver);
		commonMethods.actionsClick(topdeleteBatchButton, driver);
	}
}
