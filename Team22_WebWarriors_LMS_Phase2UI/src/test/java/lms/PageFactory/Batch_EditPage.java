package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Batch_EditPage {

	@FindBy(xpath = "//h1[text()='']") public  WebElement nameFieldEditBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement descriptionFieldEditBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement programNameDropDownFieldEditBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement programNameDropDownArrowEditBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement programNameDropDowncancelEditBatch;
	@FindBy(xpath = "//h1[text()='']") public  List<WebElement> programNamesListEditBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement StatusFieldEditBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement statusActiveButtonEditBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement statusInactiveButtonEditBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement numberOfClassesFieldEditBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement cancelButtonEditBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement saveButtonEditBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement closeButtonEditBatch;
	@FindBy(xpath = "//h1[text()='Successful Batch edited Successfully']") public  WebElement successfulTextEditBatch;

	public Batch_EditPage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
