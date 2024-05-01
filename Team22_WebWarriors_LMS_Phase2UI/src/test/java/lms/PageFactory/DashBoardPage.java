package lms.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;
import lms.Utils.LoggerLoad;
import lms.Utils.ExcelReader;

public class DashBoardPage {
	
	WebDriver driver;
	String LinkURL = "";
	 HttpURLConnection huc = null;
   int respCode = 200;
   ExcelReader reader = new ExcelReader();
   long start; 
	


	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']") public  WebElement LMSText;
	@FindBy(xpath = "//div[text()=' Manage Program']") public  WebElement header;
	@FindBy (xpath  = "//input[@id='username']") WebElement userlogin;
	@FindBy (xpath  = "//input[@id='password']") WebElement passwordlogin;
	@FindBy(xpath = "//button[@id='login']") public  WebElement loginbtn;
//	@FindBy(xpath = "//span[text()='Program']") public  WebElement programbtn;
//	@FindBy(xpath = "//span[text()='Batch']") public  WebElement batchbtn;
//	@FindBy(xpath = "//span[text()='User']") public  WebElement userbtn;
//	@FindBy(xpath = "//span[text()='Logout']") public  WebElement logoutbtn;
	//List<WebElement> allElements=driver.findElements(By.cssSelector(".mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted"));
	//List<String> all_elements_text=new ArrayList<>();
	
	public DashBoardPage(WebDriver driver){
		this.driver= driver;
        PageFactory.initElements(driver, this);

    }
	
	public void url() {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
	}
	
	public void validcredentials() throws InvalidFormatException, IOException {
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Login.xlsx", "Sheet1");
		String user=testData.get(0).get("User");
		String password=testData.get(0).get("Password");
		userlogin.sendKeys(user);
		passwordlogin.sendKeys(password);
	}
	
	public void loginbtn() {
  	  loginbtn.click();
    }

	public void ResponseTime(Integer int1) {
		//capture time after load
	long end=System.currentTimeMillis();
		//calculate time
		long pageload_time=end-start;
		
		if (pageload_time<int1) {
			LoggerLoad.info("Page Load time less than 30 miliseconds");
		}
		else
		{LoggerLoad.info("Page Load time more than 30 miliseconds");		
			
		}
	}	
	public String Header() {	
		return header.getText();
	}
	
	public void broken_links() {
		//WebElement Link = driver.findElement(By.tagName("a"));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
       Iterator<WebElement> it = links.iterator();
       
        while(it.hasNext()){
           
        	LinkURL = it.next().getAttribute("href");
           
            System.out.println(LinkURL);
		//String LinkURL = Link.getAttribute("href");
		
		if (LinkURL==null || LinkURL.isEmpty()) {
			LoggerLoad.info("URL is either not configurerd for anchor tag or it is empty");
		}
		
		try {
           huc = (HttpURLConnection)(new URL(LinkURL).openConnection());
           
           huc.setRequestMethod("HEAD");
           
            huc.connect(); 
            
            respCode = huc.getResponseCode();
           
           if(respCode >= 400){
                System.out.println(LinkURL+" is a broken link");
            }
            else{
                System.out.println(LinkURL+" is a valid link");
            }
		} catch (MalformedURLException e) {
          
           e.printStackTrace();
       } catch (IOException e) {
           
            e.printStackTrace();
       }
	}
	
	}
	
	public void title(String string) {
		String LMSText = driver.getTitle();
		Assert.assertEquals(string,LMSText);
		System.out.println(LMSText);		
		
	}
	
	
//	public void listOfModules() {
//
//		for(int i=0; i<allElements.size(); i++){
//
//			//loading text of each element in to array all_elements_text
//			all_elements_text.add(allElements.get(i).getText());
//			System.out.println(allElements.get(i).getText());
//		}
//	}
//	
//	public void validateProgramModule() {
//		for(int i=2; i<3; i++){
//			Assert.assertEquals("Program",allElements.get(i).getText() );
//		}
//	}
//	
//	public void validateBatchModule() {
//		for(int i=3; i<4; i++){
//			Assert.assertEquals("Batch",allElements.get(i).getText() );
//		}
//	}


//	public void validateUserModule() {
//		for(int i=4; i<5; i++){
//			Assert.assertEquals("User",allElements.get(i).getText() );
//		}
//	}
//	
//	public void validatelogout() {
//		for(int i=5; i<6; i++){
//			Assert.assertEquals("Logout",allElements.get(i).getText() );
//		}
//	}
	
}
