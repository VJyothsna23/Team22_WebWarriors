package lms.PageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;

public class User_DeleteMultiplePage {

	public static WebDriver driver;
	String userID;

	// Login Page
	@FindBy(id = "username")
	public WebElement userLP;
	@FindBy(id = "password")
	public WebElement passwordLP;
	@FindBy(id = "login")
	public WebElement loginButton;

	@FindBy(id = "user")
	public WebElement eleUser;

	@FindBy(xpath = "(//div[@role='checkbox'])[2]")
	public WebElement eleCheckbox;
	@FindBy(xpath = "(//tbody//td)[2]")
	public WebElement eleUSerID;

	@FindBy(xpath = "//div[@class='box']//div")
	public WebElement eleCommonDel;
	@FindBy(xpath = "//span[text()='Yes']")
	public WebElement eleYes;
	@FindBy(xpath = "//div[@role='alert']")
	public WebElement eleSuccess;
	@FindBy(xpath = "//span[text()='No']")
	public WebElement eleNo;
	@FindBy(xpath = "//div[@class='p-checkbox-box p-component']")
	public List<WebElement> eleMulCheckBox;

	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']")
	public WebElement eleTableData;

	@SuppressWarnings("static-access")
	public User_DeleteMultiplePage(WebDriver driver) {
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

	public String clickCheckBox() {
		eleCheckbox.click();
		userID = eleUSerID.getText();
		return userID;
	}

	public void verifyCommonDel() {
		try {
			eleCommonDel.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickCommonDelButton() {
		eleCommonDel.click();
	}

	public void isAlertYes() throws InterruptedException {
		Thread.sleep(2000);
		eleYes.click();
	}

	public String successAlert() {
		String text = eleSuccess.getText().replaceAll("\\n", " ").trim();
		return text;
	}

	public void isAlertNo() throws InterruptedException {
		Thread.sleep(2000);
		eleNo.click();
	}

	@SuppressWarnings("unlikely-arg-type")
	public void verifyUserIsNotDel() {
		try {
			userID.equals(eleUSerID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickMulCheckBox() {
		List<String> tableDataList = new ArrayList<String>();
		for (WebElement ele : eleMulCheckBox) {
			String getText = eleTableData.getText();
			tableDataList.add(getText);
			ele.click();
		}
	}

}
