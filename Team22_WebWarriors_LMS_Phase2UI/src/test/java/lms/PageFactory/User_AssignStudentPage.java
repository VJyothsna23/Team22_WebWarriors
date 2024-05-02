package lms.PageFactory;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;

public class User_AssignStudentPage {

	public static WebDriver driver;

	// Login Page
	@FindBy(id = "username")
	public WebElement userLP;
	@FindBy(id = "password")
	public WebElement passwordLP;
	@FindBy(id = "login")
	public WebElement loginButton;

	@FindBy(id = "user")
	public WebElement eleUser;
	@FindBy(className = "box")
	public WebElement eleManageUser;

	@FindBy(xpath = "//button[@label='Assign Student']")
	public WebElement eleAssignStudent;

	@FindBy(xpath = "//span[@id='pr_id_7-label']")
	public WebElement eleAssignStudentPopUpTitle;
	@FindBy(xpath = "//div[@role='dialog']//button[@type='button']")
	public WebElement eleCloseButton;
	@FindBy(xpath = "//button[@label='Cancel']")
	public WebElement eleCancel;
	@FindBy(xpath = "//button[@label='Save']")
	public WebElement eleSave;

	@FindBy(id = "roleId")
	public WebElement eleRoleId;
	@FindBy(xpath = "//span[text()='Select Email ID']")
	public WebElement eleEmailId;
	@FindBy(id = "programName")
	public WebElement eleprogramName;
	@FindBy(id = "batchName")
	public WebElement elebatchName;

	@FindBy(xpath = "//p-dropdown[@id='userId']//div[@role='button']")
	public WebElement eleEmailIdDropDown;
	@FindBy(xpath = "//p-dropdown[@id='programName']//div[@role='button']")
	public WebElement eleProgramDropDown;
	@FindBy(xpath = "//p-dropdown[@id='batchName']//div[@role='button']")
	public WebElement eleBatchNameDropDown;

	@FindBy(xpath = "//div[text()=' Active ']")
	public WebElement eleActive;
	@FindBy(xpath = "//div[text()=' Inactive ']")
	public WebElement eleInActive;

	@FindAll({ @FindBy(xpath = "//div[@style='color: red;']") })
	public List<WebElement> eleErrormsg;

	@SuppressWarnings("static-access")
	public User_AssignStudentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void test() {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
		userLP.sendKeys(ConfigReader.readPropertiesFile("username"));
		passwordLP.sendKeys(ConfigReader.readPropertiesFile("password"));
		loginButton.click();
	}

	public void clickUser() {
		eleUser.click();
	}

	public String verifyManageUserPage() {
		String cardTitle = eleManageUser.getText();
		return cardTitle;
	}

	public void clickAssignStudent() {
		eleAssignStudent.click();
	}

	public void verifyAssignStudentPopUpAndButtons() {
		String popUpTitle = null;
		try {
			popUpTitle = eleAssignStudentPopUpTitle.getText();
			System.out.println(popUpTitle);
			assertEquals(popUpTitle, "Assign Student");
			eleCloseButton.isEnabled();
			eleCancel.isEnabled();
			eleSave.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validate_input_fields() {
		try {
			String attribute = eleRoleId.getAttribute("value");
			assertEquals(attribute, "R03");
			eleEmailId.isEnabled();
			eleprogramName.isEnabled();
			elebatchName.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validate_drop_down() throws Exception {

		eleEmailIdDropDown.isEnabled();
		/*
		 * try { eleProgramDropDown.isEnabled(); 
		 * eleBatchNameDropDown.isEnabled(); }
		 * catch (NoSuchElementException e) {
		 * 
		 * }
		 */
	}

	public void validate_radio_Button() {
		eleActive.isEnabled();
		eleInActive.isEnabled();
	}

	public void validate_without_data() {

		List<String> actualList = new ArrayList<String>();
		String a[] = new String[] { "User Email Id is required.", "Program Name is required.",
				"Batch Name is required.", "Status is required." };
		List<String> expectedlist = Arrays.asList(a);
		for (WebElement ele : eleErrormsg) {
			String text = ele.getText();
			actualList.add(text);
		}
		assertEquals(actualList, expectedlist);
	}

}
