package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Batch_AddPage {

	@FindBy(xpath = "//h1[text()='']") public  WebElement nameFieldAddBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement descriptionFieldAddBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement programNameDropDownFieldAddBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement programNameDropDownArrowAddBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement programNameDropDowncancelAddBatch;
	@FindBy(xpath = "//h1[text()='']") public  List<WebElement> programNamesListAddBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement StatusFieldAddBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement statusActiveButtonAddBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement statusInactiveButtonAddBatch;
	@FindBy(xpath = "//h1[text()='']") public  WebElement numberOfClassesFieldAddBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement cancelButtonAddBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement saveButtonAddBatch;
	@FindBy(xpath = "//button[text()='']") public  WebElement closeButtonAddBatch;
	@FindBy(xpath = "//h1[text()='Successful Batch Created Successfully']") public  WebElement successfulTextAddBatch;
	
	public Batch_AddPage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
