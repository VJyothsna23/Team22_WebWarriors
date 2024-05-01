package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;
import lms.Utils.commonMethods;

public class Program_AddPage {
	
	public static WebDriver driver;
	
	//Login Page
		@FindBy(id = "username") public  WebElement userLP;
		@FindBy(id = "password") public  WebElement passwordLP;
		@FindBy(id = "login") public  WebElement loginButton;
		
		//Dashboard Page
		@FindBy(xpath = "//span[text()='Program']") public  WebElement programLinkPM;
		
		//Program page add new program popup
		@FindBy(xpath="//button[@id='new']") public WebElement newProgramButton;
		@FindBy(xpath="//button[@label='Save']") public WebElement saveButton;
		@FindBy(xpath="//button[@label='Cancel']") public WebElement cancelButton;
		@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c132-3 pi pi-times']") public WebElement closeButton;
		@FindBy(xpath="//input[@id='programName']") public WebElement progNameTextBox;
		@FindBy(xpath="//label[@for='programName']") public WebElement progName;
		@FindBy(xpath="//input[@id='programDescription']") public WebElement progDescTextBox;
		@FindBy(xpath="//label[@for='programDescription']") public WebElement progDesc;
		@FindBy(xpath="//div//div//p-radiobutton") public List<WebElement> radioButtons;
		@FindBy(xpath="//div[@role='dialog']") public WebElement popup;
//		@FindBy(xpath="//small") public List<WebElement> rederror;
//		@FindBy(xpath="//div[@class='p-field ng-star-inserted']") WebElement errorMsg;
		@FindBy(xpath="//small[text()='Program name is required.']") public WebElement progErrorMsg;
		@FindBy(xpath="//small[text()='Description is required.']") public WebElement progDescErrorMsg;
		@FindBy(xpath="//small[@class='p-invalid ng-star-inserted']") public WebElement progErrorMsg1;
		@FindBy(xpath="//small[@class='p-invalid ng-star-inserted']") public WebElement progDescErrorMsg1;
		@FindBy(xpath="//small[text()='Status is required.']") public WebElement radioButtonErrorMsg;
		@FindBy(xpath="//input[@id='filterGlobal']") public WebElement searchButton;
		@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']") public WebElement searchValidation;
		@FindBy(xpath = "//input[@id='Active']/../../..") public  WebElement activeButton;
		@FindBy(xpath = "//input[@id='Inactive']/../../..") public  WebElement inactiveButton;
		@FindBy(xpath="//div[text()='Program Created Successfully']") public WebElement successMsg;
		

	public Program_AddPage(WebDriver driver){
		this.driver=driver;
        PageFactory.initElements(driver, this);

    }
	
	public void login() {	
		userLP.sendKeys(ConfigReader.readPropertiesFile("username"));
		passwordLP.sendKeys(ConfigReader.readPropertiesFile("password"));
		loginButton.click();
	}
	
	public void clickProgram(){
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
		login();
		commonMethods.actionsClick(programLinkPM,driver);
		commonMethods.actionsClick(newProgramButton, driver);
	}
	
	public String manageprogramurl() {
		String mp_url=driver.getCurrentUrl();
		return mp_url;
	}
	
	public void newProgram() {
		commonMethods.actionsClick(newProgramButton, driver);
	}
	
	public Boolean newProgPopUp() {
		if((cancelButton.isDisplayed())&&(saveButton.isDisplayed())&&(closeButton.isDisplayed())){
			return true;
		}
		return false;
		
	}
	
	public boolean progNameisempty() {
		
		String progName=progNameTextBox.getAttribute("value");
		
		if (progNameTextBox.isDisplayed() && progName.isEmpty()) {
			System.out.println("User Last Name field is empty");
			return true;
		} else
			return false;
	}
	
public boolean progDescisempty() {
		
		String progDesc=progDescTextBox.getAttribute("value");
		
		if (progNameTextBox.isDisplayed() && progDesc.isEmpty()) {
			System.out.println("User Last Name field is empty");
			return true;
		} else
			return false;
	}

public boolean radiobuttonisNotSel() {
	Boolean rad=null;
	for(WebElement radio:radioButtons) {
		rad=radio.isDisplayed();
	}
	return rad;
}
	

public boolean inputfield() {
	if ((progName.isDisplayed())&& (progNameTextBox.isDisplayed())&&(progDesc.isDisplayed())&&(progDescTextBox.isDisplayed()))
	{
		return true;
	}
	return false;
}

public int radioButtonSize() {
	
	int radio=radioButtons.size();
	
	return radio;
	
}

public Boolean popUpwindow() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	if(popup.isDisplayed()) {
		return true;
	}
	return false;	
}

public void clickSave() {
		commonMethods.actionsClick(saveButton, driver);
	}

public Boolean prgmNameError() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	if(progErrorMsg.isDisplayed()) {
		return true;
	}
	return false;
}

public Boolean radioError() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	if(radioButtonErrorMsg.isDisplayed()) {
		return true;
	}
	return false;
}

public Boolean prgmDescError() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	if(progDescErrorMsg.isDisplayed()) {
		return true;
	}
	return false;
}

public String getprogNameError() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	String progNameerror=progErrorMsg.getText();
	return progNameerror;
}

public String getprogDescError() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	String progDescerror=progDescErrorMsg.getText();
	return progDescerror;
}

public void enterProgname() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	progNameTextBox.sendKeys("WWW");
}

public void enterProgDesc() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	progDescTextBox.sendKeys("Team22Hackathon");
}

public void radioSelect() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	activeButton.click();
}

public void enterProgname(String value) {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	progNameTextBox.sendKeys(value);
}

public void enterProgDesc(String value) {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	progDescTextBox.sendKeys(value);
}

public String getprogNameError1() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	String progNameerror=progErrorMsg1.getText();
	return progNameerror;
}

public String getprogDescError1() {
	String wh = driver.getWindowHandle();
	driver.switchTo().window(wh);
	String progDescerror=progDescErrorMsg1.getText();
	return progDescerror;
}

public void clickCancel() {
	commonMethods.actionsClick(cancelButton, driver);
}

public void clickClose() {
	commonMethods.actionsClick(closeButton, driver);
}

public void searchforProg() throws InterruptedException {
	commonMethods.waitForElementToBeVisible(driver, searchButton);
	commonMethods.actionsSendKeys(driver, searchButton, "WWW");
	Thread.sleep(1000);
}

public String searchValidation() throws InterruptedException {
searchforProg();
commonMethods.waitForElementToBeVisible(driver, searchValidation);
String search=searchValidation.getText();
System.out.println(search);
return search;

}


public String successMsg() {
	String msg=successMsg.getText();
	System.out.println(msg);
	return msg;
}
}
	
