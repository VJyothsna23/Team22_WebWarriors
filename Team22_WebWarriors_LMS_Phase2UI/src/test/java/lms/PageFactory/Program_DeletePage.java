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

public class Program_DeletePage {

	public WebDriver driver;
	Program_EditPage PEP;
	public String deletedProgramName;
	
	@FindBy(xpath = "//tbody//tr[1]//td[5]//button[2]") public  WebElement deleteProgramButton;
	@FindBy(xpath = "//tbody//tr[1]//td[2]") public  WebElement deleteprogramName1;
	@FindBy(xpath = "//tbody//tr[2]//td[2]") public  WebElement deleteprogramName2;
	@FindBy(xpath = "//span[text()='Confirm']") public  WebElement confirmText;
	@FindBy(xpath = "//span[@class='p-confirm-dialog-message ng-tns-c133-4']") public  WebElement areYouSureText;
	@FindBy(xpath = "//span[text()='Yes']") public  WebElement YesButton;
	@FindBy(xpath = "//span[text()='No']") public  WebElement NoButton;
	@FindBy(xpath = "//button[@class='ng-tns-c133-4 p-dialog-header-icon p-dialog-header-close p-link ng-star-inserted']") public  WebElement cancelButton;
	@FindBy(xpath = "//div[text()='Successful']") public  WebElement successMessage;
	@FindBy(xpath = "//div[text()='Program Deleted']") public  WebElement programDeletedMessage;
	@FindBy(xpath = "//div[text()='Programs Deleted']") public  WebElement programsDeletedMessage;
	
	@FindBy(xpath = "//tbody//tr[1]//td[1]/p-tablecheckbox") public  WebElement firstCheckbox;
	@FindBy(xpath = "//tbody//tr[2]//td[1]/p-tablecheckbox") public  WebElement secondCheckbox;
	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']") public  WebElement deleteMultipleProgramsButton;
	@FindBy(xpath = "//span[text()='Showing 0 to 0 of 0 entries']") public  WebElement ShowingZeroText;
	
	public Program_DeletePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		PEP = new Program_EditPage(driver);
	}

	public void clickDeleteProgram() {
		deleteProgramButton.click();
	}

	public void deleteConfirmPopup() throws InterruptedException {
		PEP.search(ConfigReader.readPropertiesFile("DelProgramName"));
		Thread.sleep(1000);		
		clickDeleteProgram();
		Thread.sleep(1000);
		LoggerLoad.info("**************Admin is on the Delete Program confirmation popup");
	}

	public String getText(String ele) {
		String text;
		if(ele.equals("Confirm")){
			text = confirmText.getText();
		}else if(ele.equals("AreYouSure")){
			text = areYouSureText.getText();
		}else {
			text = deleteprogramName1.getText();
			this.deletedProgramName = text;
		}	
		return text;
	}

	public String getareYouSureText() {
		String text = areYouSureText.getText();
		return text;
	}

	public void clickNoButton() {
		NoButton.click();
	}

	public void clickYesButton() {
		YesButton.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}
	
	public String getSuccessDeleteMessageText() {
		String message1 = successMessage.getText();
		String message2 = programDeletedMessage.getText();
		String message = message1+ " " + message2;
		System.out.println("Actual message appeared on the screen is: " + message);
		LoggerLoad.info("**************Actual Success message appeared on the screen is: " + message);
		return message;
	}
	
	public String getSuccessProgramsDeleteMessageText() {
		String message1 = successMessage.getText();
		String message2 = programsDeletedMessage.getText();
		String message = message1+ " " + message2;
		System.out.println("Actual message appeared on the screen is: " + message);
		LoggerLoad.info("**************Actual Success message appeared on the screen is: " + message);
		return message;
	}
	
	public void searchdeletedProgram() throws InterruptedException {
		
		PEP.search(ConfigReader.readPropertiesFile("DelProgramName"));
		System.out.println("Program name which is trying to be deleted is: "+ deleteprogramName1.getText() );
		Thread.sleep(1000);				
//		LoggerLoad.info("**************Admin is on the Delete Program confirmation popup");
	}
	
	public void searchdeletedProgram1() throws InterruptedException {
		PEP.search(Env_Var.programNameDel.get(0));
		System.out.println("Program name which is trying to be deleted is: "+ Env_Var.programNameDel.get(0) );
		Thread.sleep(1000);				
//		LoggerLoad.info("**************Admin is on the Delete Program confirmation popup");
	}
	
	public void searchdeletedProgram2() throws InterruptedException {
		PEP.search(Env_Var.programNameDel.get(1));
		System.out.println("Program name which is trying to be deleted is: "+ Env_Var.programNameDel );
		Thread.sleep(1000);				
//		LoggerLoad.info("**************Admin is on the Delete Program confirmation popup");
	}
	
	public void selectOneCheckbox() throws InterruptedException {
		PEP.search(ConfigReader.readPropertiesFile("DelProgramName"));
		Thread.sleep(1000);
		firstCheckbox.click();
	}
	
	public void selectTwoCheckboxesNo() throws InterruptedException {
		selectOneCheckbox();
//		Thread.sleep(1000);
		secondCheckbox.click();
	}
	
	public void selectTwoCheckboxes() throws InterruptedException {
		createProgramForDelete();
//		Thread.sleep(1000);
		createProgramForDelete();
		selectOneCheckbox();
//		Thread.sleep(1000);
		secondCheckbox.click();
	}
	
	public void selectNoOneCheckbox() throws InterruptedException {
		selectOneCheckbox();
		Thread.sleep(1000);
		deleteMultipleProgramsButton.click();
		NoButton.click();
	}
	
	public void selectYesOneCheckbox() throws InterruptedException {
		selectOneCheckbox();
		deleteMultipleProgramsButton.click();
		Thread.sleep(1000);
		YesButton.click();
	}
	
	public void selectNoMultipleCheckboxes() throws InterruptedException {
		selectTwoCheckboxesNo();
		Thread.sleep(1000);
		deleteMultipleProgramsButton.click();
		Thread.sleep(1000);
		NoButton.click();
	}
	
	public void selectYesMultipleCheckboxes() throws InterruptedException {
		selectTwoCheckboxes();
		Thread.sleep(1000);
		deleteMultipleProgramsButton.click();
		YesButton.click();
		Thread.sleep(1000);
	}
	
	public void createProgramForDelete() throws InterruptedException {
		PEP.addNewProgramButton.click();
		String progName = dynamicGenerator.generateProgramNameForDelete();
		PEP.programName.sendKeys(progName);
		Env_Var.programNameDel.add(progName);
		System.out.println("Progrma names created so far are: "+ Env_Var.programNameDel);
		PEP.programDesc.sendKeys("Team22");
		PEP.activeButton.click();
		PEP.saveButton.click();
		Thread.sleep(1000);
	}
	
	public void getOnMPPageCreateProgramForDelete() throws InterruptedException {
		PEP.programButton.click();
		createProgramForDelete();
	}
	
	public void refreshPage() throws InterruptedException {
		driver.navigate().refresh();
		PEP.login();
	}
	
//	public void dataCleanup() throws InterruptedException {
//		Thread.sleep(2000);
//		PEP.search(Env_Var.programNameDel);
//		Thread.sleep(2000);
//		deleteProgramButton.click();
//		YesButton.click();
//	}

}
