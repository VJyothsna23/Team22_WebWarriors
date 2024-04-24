package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Batch_DeletePage {
 	
	//Delete Batch
	@FindBy(xpath = "//h1[text()='Are you sure you want to delete ?']") public  WebElement DeleteBatchConfirmationText;
	@FindBy(xpath = "//button[text()='No']") public  WebElement NoButtonDeleteBatch;
	@FindBy(xpath = "//button[text()='Yes']") public  WebElement YesButtonDeleteBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement closeButtonDeleteBatch;
	@FindBy(xpath = "//h1[text()='Successful batch Deleted']") public  WebElement successfulTextDeleteBatch;
	
	//Delete Batches
	@FindBy(xpath = "//h1[text()='Are you sure you want to delete the selected batches?']") public  WebElement DeleteBatchesConfirmationText;
	@FindBy(xpath = "//button[text()='No']") public  WebElement NoButtonDeleteBatches;
	@FindBy(xpath = "//button[text()='Yes']") public  WebElement YesButtonDeleteBatches;
	@FindBy(xpath = "//button[text()='']") public  WebElement closeButtonDeleteBatches;
	@FindBy(xpath = "//h1[text()='Successful batches Deleted']") public  WebElement successfulTextDeleteBatches;
	
	public Batch_DeletePage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
