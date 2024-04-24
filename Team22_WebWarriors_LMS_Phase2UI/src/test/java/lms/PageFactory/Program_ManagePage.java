package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program_ManagePage {

	@FindBy(xpath = "//h1[text()='LMS-Learning Management System']") public  WebElement LMSTextPM;
	@FindBy(xpath = "//a[text()=' Program ']") public  WebElement programLinkPM;
	@FindBy(xpath = "//a[text()=' Batch ']") public  WebElement batchLinkPM;
	@FindBy(xpath = "//a[text()=' User ']") public  WebElement userLinkPM;
	@FindBy(xpath = "//a[text()=' Logout ']") public  WebElement logoutLinkPM;
	@FindBy(xpath = "//h1[text()='Manage Program']") public  WebElement manageProgramText;
	@FindBy(xpath = "//button[text()='Delete Programs']") public  WebElement deleteProgramsButton;
	@FindBy(xpath = "//a[text()=' Search ']") public  WebElement searchBarPM;
	@FindBy(xpath = "//button[text()='A New Program']") public  WebElement addNewProgramButton;
	@FindBy(xpath = "//h1[text()='Program Name']") public  WebElement programNameText;
	@FindBy(xpath = "//h1[text()='Program Description']") public  WebElement programDescriptionText;
	@FindBy(xpath = "//h1[text()='Program Status']") public  WebElement programStatusText;
	@FindBy(xpath = "//h1[text()='EditDelete']") public  WebElement EditDeleteTextPM;
	@FindBy(xpath = "//button[text()='']") public  WebElement checkboxHeaderPM;
	@FindBy(xpath = "//button[text()='']") public  WebElement checkboxProgramNameEntry;
	@FindBy(xpath = "//button[text()='sort Up Arrow']") public  WebElement sortUpArrowPM;
	@FindBy(xpath = "//button[text()='sort Down Arrow']") public  WebElement sortDownArrowPM;
	@FindBy(xpath = "//button[text()='edit Program']") public  WebElement editProgramButton;
	@FindBy(xpath = "//button[text()='delete Program']") public  WebElement deleteProgramButton;	
	@FindBy(xpath = "//h1[text()='In total there are number programs.']") public  WebElement totalProgramsTextPM;
	
	//Elements that appear after clicking the Manage Program Page Elements:
	@FindBy(xpath = "//h1[text()='Program Details']") public  WebElement programDetailsTextAddProgram;
	@FindBy(xpath = "//h1[text()='Program Details']") public  WebElement programDetailsTextEditProgram;
	@FindBy(xpath = "//h1[text()='Confirm']") public  WebElement confirmTextDeleteProgram;
	@FindBy(xpath = "//h1[text()='Confirm']") public  WebElement confirmTextDeletePrograms;

	public Program_ManagePage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
