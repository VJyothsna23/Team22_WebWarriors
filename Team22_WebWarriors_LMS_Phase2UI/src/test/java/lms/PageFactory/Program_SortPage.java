package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.DriverFactory.TestContext;
import lms.Utils.ConfigReader;
import lms.Utils.LoggerLoad;
import lms.Utils.commonMethods;

public class Program_SortPage {
	
	public WebDriver driver;
	Program_EditPage PEP;

	@FindBy(xpath = "//thead/tr/th[2]//i") public  WebElement programNameSortIcon;
	@FindBy(xpath = "//thead/tr/th[3]//i") public  WebElement programDescSortIcon;
	@FindBy(xpath = "//thead/tr/th[4]//i") public  WebElement programStatusSortIcon;
	@FindBy(xpath = "//tbody//td[2]") public List<WebElement> programNamesList;
	@FindBy(xpath = "//tbody//td[3]") public List<WebElement> programDescList;
	@FindBy(xpath = "//tbody//td[4]") public List<WebElement> programStatusList;

	public Program_SortPage(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
        PEP = new Program_EditPage(driver);
    }
	
	public void getOnManageProgramPage(){
		PEP.programButton.click();	
//		LoggerLoad.info("**************Admin is on the Manage Program Page");
	}
	
	public List<String> getOriginalList(String type) {
		List<String> originalList = null;
		if(type.equals("programName")) {
			originalList = commonMethods.printTextForWebElements(programNamesList);
		
		}else if(type.equals("programDescription")) {
			originalList = commonMethods.printTextForWebElements(programDescList);
		
		}else {
			originalList = commonMethods.printTextForWebElements(programStatusList);
		}
		
		return originalList;	
	}
	
	public List<String> getSortedList(List<String> originalList) {
		List<String> sortedList = commonMethods.getSortedList(originalList);
		return sortedList;
			
	}
	
	public List<String> getSortedListDescend(List<String> originalList) {
		List<String> sortedList = commonMethods.getSortedListDescending(originalList);
		return sortedList;
			
	}
	
	public void clickProgramDescSortAsecending(){
		programDescSortIcon.click();
	}
	
	public void clickProgramDescSortDesecending() throws InterruptedException {
		programDescSortIcon.click();
		Thread.sleep(1000);
		programDescSortIcon.click();
	}
	
	public void clickProgramStatusSortAsecending() {
		programStatusSortIcon.click();
	}
	
	public void clickProgramStatusSortDesecending() throws InterruptedException {
		programStatusSortIcon.click();
		Thread.sleep(1000);
		programStatusSortIcon.click();
	}
	
	public void clickProgramNameSortAsecending(){
		programNameSortIcon.click();
	}
	
	public void clickProgramNameSortDesecending() throws InterruptedException {
		programNameSortIcon.click();
		Thread.sleep(1000);
		programNameSortIcon.click();
	}
	
}
