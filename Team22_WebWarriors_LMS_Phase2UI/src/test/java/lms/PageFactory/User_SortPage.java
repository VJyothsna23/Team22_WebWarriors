package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;
import lms.Utils.commonMethods;

public class User_SortPage {
	
	public static WebDriver driver;	
	//login elements
	@FindBy(id = "username") public  WebElement userLP;
	@FindBy(id = "password") public  WebElement passwordLP;
	@FindBy(id = "login") public  WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='User']") public  WebElement user;
	
	
	@FindBy(xpath = "//thead/tr/th[2]//i") public  WebElement IDSortIcon;
	@FindBy(xpath = "//thead/tr/th[3]//i") public  WebElement NameSortIcon;
	@FindBy(xpath = "//thead/tr/th[4]//i") public  WebElement LocationSortIcon;
	@FindBy(xpath = "//thead/tr/th[5]//i") public  WebElement phonenumberSortIcon;
	
	
	@FindBy(xpath = "//tbody//td[2]") public List<WebElement> IdList;
	@FindBy(xpath = "//tbody//td[3]") public List<WebElement> NameList;
	@FindBy(xpath = "//tbody//td[4]") public List<WebElement> LocationList;
	@FindBy(xpath = "//tbody//td[5]") public List<WebElement> PhonenumberList;
	
	


	
	
	public void login() {	
		userLP.sendKeys(ConfigReader.readPropertiesFile("username"));
		passwordLP.sendKeys(ConfigReader.readPropertiesFile("password"));
		loginButton.click();
	}

    //login
	public void dashboard_page_login() {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
		login();
	}
	
	public void clickUser() {
		commonMethods.actionsClick (user,driver);
	     }
	
	
	public User_SortPage(WebDriver driver){
		this.driver=driver;
        PageFactory.initElements(driver, this);

      }
	
	
	public List<String> getOriginalList(String type) {
		List<String> originalList = null;
		if(type.equals("Id")) {
			originalList = commonMethods.printTextForWebElements(IdList);
		
		}else if(type.equals("Name")) {
			originalList = commonMethods.printTextForWebElements(NameList);
		
		}else if(type.equals("Location")) {
			originalList = commonMethods.printTextForWebElements(LocationList);
			
		}else if(type.equals("Phone Number")) {
			originalList = commonMethods.printTextForWebElements(PhonenumberList);
		}
		
		return originalList;	
	}
	
	
		
	public List<String> getSortedList(List<String> originalList) {
		List<String> sortedList = commonMethods.getSortedList(originalList);
		return sortedList;
			
	}
	
	
	public List<String> getSortedListphone(List<String> originalList) {
		List<String> sortedList = commonMethods.getSortedphonenumberlist(originalList);
		return sortedList;
			
	}
	
	
	public List<String> getSortedListDescend(List<String> originalList) {
		List<String> sortedList = commonMethods.getSortedListDescending(originalList);
		return sortedList;
			
	}
	
	public void IdSortAsecending(){
		IDSortIcon.click();
	}
	
	public void IdSortDesecending() throws InterruptedException {
//		IDSortIcon.click();
		Thread.sleep(2000);
		IDSortIcon.click();
	}
	
	public void NameSortAsecending() {
		NameSortIcon.click();
	}
	
	public void NameSortDesecending() throws InterruptedException {
		//NameSortIcon.click();
		Thread.sleep(2000);
		NameSortIcon.click();
	}
	
	public void locationSortAsecending() {
		LocationSortIcon.click();
	}
	
	public void locationSortDesecending() throws InterruptedException {
		//LocationSortIcon.click();
		Thread.sleep(2000);
		LocationSortIcon.click();
	}
	
	public void phnumSortAsecending(){
		phonenumberSortIcon.click();
	}
	
	public void phnumSortDesecending() throws InterruptedException {
		//phonenumberSortIcon.click();
		Thread.sleep(2000);
		phonenumberSortIcon.click();
	}
	
	
	
	
  
  
}

		
		
	
	

	
	
	
	
	
	
    
