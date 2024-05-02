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

public class User_AssignStaffPage {

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

	@FindBy(xpath = "//button[@label='Assign Staff']")
	public WebElement eleAssignStaff;

	@FindBy(xpath = "//span[@id='pr_id_6-label']")
	public WebElement eleAssignStaffPopUpTitle;
	@FindBy(xpath = "//div[@role='dialog']//button[@type='button']")
	public WebElement eleCloseButton;
	@FindBy(xpath = "//button[@label='Cancel']")
	public WebElement eleCancel;
	@FindBy(xpath = "//button[@label='Save']")
	public WebElement eleSave;

	@FindBy(id = "roleId")
	public WebElement eleRoleId;
	@FindBy(xpath = "//span[text()='Select Email Id']")
	public WebElement eleEmailId;
	@FindBy(id = "skillName")
	public WebElement eleSkill;
	@FindBy(id = "programName")
	public WebElement eleprogramName;
	@FindBy(id = "batchName")
	public WebElement elebatchName;

	@FindBy(xpath = "//p-dropdown[@id='userId']//div[@role='button']")
	public WebElement eleEmailIdDropDown;
	@FindBy(xpath = "//p-dropdown[@id='programName']//div[@role='button']")
	public WebElement eleProgramDropDown;
	@FindBy(xpath = "//p-multiselect[@id='batchName']")
	public WebElement eleBatchNameDropDown;

	@FindBy(xpath = "//div[text()=' Active ']")
	public WebElement eleActive;
	@FindBy(xpath = "//div[text()=' Inactive ']")
	public WebElement eleInActive;

	@FindAll({ @FindBy(xpath = "//div[@style='color: red;']") })
	public List<WebElement> eleAllErrormsg;
	
	@FindBy(xpath="(//li[@role='option'])[1]") public WebElement eleValidEmail;
	@FindBy(xpath ="//span[text()='JavaSelenium234567']") public WebElement eleProgramOption;
	@FindBy(xpath = "//ul[@role='listbox']//div[@class='p-checkbox-box']") public WebElement eleBatchCheckBox;
	
	@FindBy(xpath ="//p-radiobutton[@id='userStatus']") public WebElement eleActiveRadio;
	@FindBy(xpath ="//div[@style='color: red;']") public WebElement eleError;
	
	@SuppressWarnings("static-access")
	public User_AssignStaffPage(WebDriver driver) {
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

	public void clickAssignStaff() {
		eleAssignStaff.click();
	}

	public void verifyAssignStaffPopUpAndButtons() {
		String popUpTitle = null;
		try {
			popUpTitle = eleAssignStaffPopUpTitle.getText();
			System.out.println(popUpTitle);
			Thread.sleep(1000);
			//assertEquals(popUpTitle, "Assign User");
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
			assertEquals(attribute, "R02");
			eleEmailId.isEnabled();
			eleSkill.isEnabled();
			eleprogramName.isEnabled();
			elebatchName.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validate_drop_down() {

		eleEmailIdDropDown.isEnabled();
		eleProgramDropDown.isEnabled();
		eleBatchNameDropDown.isEnabled();
	}

	public void validate_radio_Button() {
		eleActive.isEnabled();
		eleInActive.isEnabled();
	}

	public void validate_without_data() {
        eleSave.click();
		List<String> actualList = new ArrayList<String>();
		String a[] = new String[] { "Email Id is required.", "Program Name is required.",
				"Batch Name is required.", "Status is required." };
		List<String> expectedlist = Arrays.asList(a);
		for (WebElement ele : eleAllErrormsg) {
			String text = ele.getText();
			actualList.add(text);
			//System.out.println(text);
		}
		assertEquals(actualList, expectedlist);
	}
	
	public void verifyEmailErrorMsg() {
		eleSkill.sendKeys("skill");
		eleprogramName.click();
		eleProgramOption.click();
		elebatchName.click();
		eleBatchCheckBox.click();
		elebatchName.click();
		eleActiveRadio.click();
		eleSave.click();
		assertEquals(eleError.getText(),"Email Id is required.");
	}
	
	public void verifyBatchErrorMsg() {
		eleEmailId.click();
		eleValidEmail.click();
		eleSkill.sendKeys("skill");
		eleprogramName.click();
		eleProgramOption.click();
		eleActiveRadio.click();
		eleSave.click();
	}
	
	public void validData() {
		eleEmailId.click();
		eleValidEmail.click();
		eleSkill.sendKeys("skill");
		eleprogramName.click();
		eleProgramOption.click();
		elebatchName.click();
		eleBatchCheckBox.click();
		elebatchName.click();
		eleActiveRadio.click();
		eleSave.click();
	}

}
