package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program_EditPage {
	
	//Login Page
	@FindBy(id = "username") public  WebElement userLP;
	@FindBy(id = "password") public  WebElement passwordLP;
	@FindBy(id = "login") public  WebElement loginButton;
	
	//Dashboard Page
	@FindBy(id = "program") public  WebElement programButton;
	
	//Manage Program Page
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']") public  WebElement doubleRightArrow;
	@FindBy(xpath = "//tbody//tr[2]//td[5]//button[1]") public  WebElement editProgramButton;
	
	//Edit Program Details Window	
	@FindBy(id = "pr_id_2-label") public  WebElement programDetailsText;
	@FindBy(id = "programName") public  WebElement programNameText;
	@FindBy(id = "programDescription") public  WebElement programDescText;
	@FindBy(xpath = "//input[@id='Active']") public  WebElement activeButton;
	@FindBy(xpath = "//input[@id='Inactive']") public  WebElement inactiveButton;
	@FindBy(id = "saveProgram") public  WebElement saveButton;
	@FindBy(xpath = "//span[text()='Cancel']/..") public  WebElement cancelButton;
	@FindBy(xpath = "//div[@class='p-dialog-header-icons ng-tns-c132-8']") public  WebElement closeButton;
	
//	@FindBy(xpath = "//h1[text()='Successful Batch edited Successfully']") public  WebElement successfulTextEditProgram;


	public Program_EditPage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
	
	
}
