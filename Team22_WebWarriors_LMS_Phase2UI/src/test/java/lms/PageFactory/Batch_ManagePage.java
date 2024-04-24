package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Batch_ManagePage {

	@FindBy(xpath = "//h1[text()='LMS-Learning Management System']") public  WebElement LMSTextBM;
	@FindBy(xpath = "//a[text()=' Program ']") public  WebElement programLinkBM;
	@FindBy(xpath = "//a[text()=' Batch ']") public  WebElement batchLinkBM;
	@FindBy(xpath = "//a[text()=' User ']") public  WebElement userLinkBM;
	@FindBy(xpath = "//a[text()=' Logout ']") public  WebElement logoutLinkBM;
	@FindBy(xpath = "//h1[text()='Manage Batch']") public  WebElement manageBatchText;
	@FindBy(xpath = "//button[text()='Delete Programs']") public  WebElement deleteBatchesButton;
	@FindBy(xpath = "//a[text()=' Search ']") public  WebElement searchBarBM;
	@FindBy(xpath = "//button[text()='A New Batch']") public  WebElement addNewBatchButton;
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
	@FindBy(xpath = "//button[text()='edit Batch']") public  WebElement editBatchButton;
	@FindBy(xpath = "//button[text()='delete Batch']") public  WebElement deleteBatchButton;		
	@FindBy(xpath = "//h1[text()='In total there are number matches.']") public  WebElement totalBatchesText;
	
	//Elements that appear after clicking the Manage Batch Page Elements:
	@FindBy(xpath = "//h1[text()='Batch Details']") public  WebElement batchDetailsTextAddProgram;
	@FindBy(xpath = "//h1[text()='Batch Details']") public  WebElement batchDetailsTextEditProgram;
	@FindBy(xpath = "//h1[text()='Confirm']") public  WebElement confirmTextDeleteBatch;
	@FindBy(xpath = "//h1[text()='Confirm']") public  WebElement confirmTextDeleteBatches;

	public Batch_ManagePage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
