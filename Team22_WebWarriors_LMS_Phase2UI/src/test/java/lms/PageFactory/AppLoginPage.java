package lms.PageFactory;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellChecker;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Iterator;
import lms.Utils.ConfigReader;
import lms.Utils.LoggerLoad;

import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;
import java.io.IOException;
import static org.testng.Assert.assertTrue;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Tesseract;

public class AppLoginPage  {
	
	WebDriver driver;
	String LinkURL = "";
	 HttpURLConnection huc = null;
    int respCode = 200;

	 @FindBy (xpath  = "//button[@id='login']") WebElement loginbtn ;
	 @FindBy (xpath  = "//p[text()='Please login to LMS application']") WebElement SignInContent ;	
     @FindBy (xpath  = "//div[@class='image-container']") WebElement logo;
	 @FindBy (id  = "username") WebElement userlogin;
	 @FindBy (id  = "password") WebElement passwordlogin;
	 @FindBy (xpath  = "//span[text()='User']") WebElement usertext;
	 @FindBy (xpath  = "//span[text()='Password']") WebElement passwordtext;
	 @FindBy (xpath  = "//span[text()=' *'][@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']") WebElement userastrik;
	 @FindBy (xpath  = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted'][text()=' *']") WebElement passwordastrik;
	 
	 
	public AppLoginPage(WebDriver driver){
		this.driver= driver;
        PageFactory.initElements(driver, this);

    }
	
	public void url() {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
	}
	
	public void Invalidurl() {
		String Invalidurl = ConfigReader.readPropertiesFile("InvalidHomePageUrl");
		driver.get(Invalidurl);
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
	
	public void verifyLogo() {

		boolean logoPresent = logo.isDisplayed();
		Assert.assertEquals(logoPresent, "LMS");		
	}

	public void logoaligned () {
		
		int winHeight = driver.manage().window().getSize().getHeight();     //dimension of browser window
		int winWidth = driver.manage().window().getSize().getWidth();       //dimension of browser window
		
		int xPos = logo.getLocation().getX();
		int yPos = logo.getLocation().getY();
		int eleHeight = logo.getSize().getHeight();
		int eleWidth = logo.getSize().getWidth();
		
		System.out.println("winHeight" + winHeight);
		System.out.println("winWidth" + winWidth);
		System.out.println("xPos" + xPos);
		System.out.println("yPos" + yPos);
		System.out.println("eleHeight" + eleHeight);
		System.out.println("eleWidth" + eleWidth);
		System.out.println("(((xPos + eleWidth) <= winWidth/2) && (yPos + eleHeight) <= winHeight/2)" + (((xPos + eleWidth) <= winWidth/2) && (yPos + eleHeight) <= winHeight/2));
		
		Assert.assertTrue((((xPos + eleWidth) <= winWidth/2) && (yPos + eleHeight) <= winHeight/2), "Logo is in the upper left quadrant");

	}
	
	public String spellCheck() throws Exception { // Extract text content from the web page
		 String PageTexts = driver.findElement(By.tagName("body")).getText(); // Create a SpellChecker instance SpellDictionary dictionary = null;
		 SpellDictionaryHashMap dictionary= new SpellDictionaryHashMap();
//		 try {  dictionary = new SpellDictionaryHashMap(); } 
//	 catch (IOException e) 
//	 {
//		 // TODO Auto-generated catch block e.printStackTrace(); 
//		 } 
		 SpellChecker spellChecker = new SpellChecker(dictionary); // Tokenize the web page text into words 
		 String[] words = StringUtils.split(PageTexts);
		 StringBuffer misSpelledWords = null; // Check the spelling of each word
		 for (String word : words) {
		 if (!spellChecker.isCorrect(word)) 
		 { if (misSpelledWords == null) 
		 { misSpelledWords = new StringBuffer();
		 }
		 misSpelledWords.append(word); 
		 misSpelledWords.append(","); // System.out.println("Misspelled word: " + word); }
		 }
		 if (misSpelledWords != null) { return misSpelledWords.toString(); }
		 return null;
		 }
		return null;
	}
	public void verifyApllicationTitle() throws TesseractException {
		String Title = " LMS - Learning Management System";
		File imageFile=new File ("C:\\Users\\priya\\git\\Team22_WebWarriors\\Team22_WebWarriors_LMS_Phase2UI\\src\\test\\resources\\images\\Login_Screenshot.png");
		ITesseract image = new Tesseract();
		String imageText = image.doOCR(imageFile);
		System.out.println(imageText);
		String lines[]= imageText.split("\\r?\\n");                              //Extract lines
		String AppTitle=lines[0].replaceAll("[^a-zA-Z\\s\\-]" ,"");               //remove all special characters
		System.out.println("Line[0]" + AppTitle);
		try {
		Assert.assertEquals(AppTitle,Title );
		}
		catch (Exception e) {
			String message = e.getMessage();
		}
		
		
	}

	public void verifyCompanyName() throws TesseractException {
		String CompanyName = " NumpyNinja";
		File imageFile=new File ("C:\\Users\\priya\\git\\Team22_WebWarriors\\Team22_WebWarriors_LMS_Phase2UI\\src\\test\\resources\\images\\Login_Screenshot.png");
		ITesseract image = new Tesseract();
		String imageText = image.doOCR(imageFile);
		System.out.println(imageText);
		String lines[]= imageText.split("\\r?\\n");
		String compName=lines[1].replaceAll("[^a-zA-Z\\s\\-]" ,"");
		System.out.println("Line[1]" + compName);
		
		try {
			Assert.assertEquals(CompanyName, compName);
			}
			catch (Exception e) {
				String message = e.getMessage();
			}
	}

	public void verifyPleaseLoginTitle() {
		String signinText = SignInContent.getText();
		String pleaselogin = "Please login to LMS application";
		//Assert.(signinText, "Please login to LMS application");
		Assert.assertEquals(signinText,pleaselogin);
	}
	
	public void textcheck(int a) {
		List<WebElement> textfields = driver.findElements(By.id("username or password "));
		int size = textfields.size();
		if(size==a) {
			LoggerLoad.info("2 text feilds are present");
		}
		else {
			LoggerLoad.info("text feilds are not 2");
		}
	}
	
	public void usertext(String string) {
	  	  String expectedmsg = string;
			String actualmsg = usertext.getText();
			Assert.assertEquals(expectedmsg,actualmsg);
			 System.out.println(actualmsg);
	    }
	
	public void astrikuser(String string) {
  	  String expectedmsg = string;
		String actualmsg = userastrik.getText();
		Assert.assertEquals(expectedmsg,actualmsg);
		 System.out.println(actualmsg);
    }
    
	    
	 public void passwordtext(String string) {
	  	  String expectedmsg = string;
			String actualmsg = passwordtext.getText();
			Assert.assertEquals(expectedmsg,actualmsg);
			 System.out.println(actualmsg);
	    }

	 public void astrikpassword(String string) {
   	  String expectedmsg = string;
 		String actualmsg = passwordastrik.getText();
 		Assert.assertEquals(expectedmsg,actualmsg);
 		 System.out.println(actualmsg);
     }
	 
	 public void centreloginbtn() {
		 int winHeight = driver.manage().window().getSize().getHeight();     //dimension of browser window
		 int winWidth = driver.manage().window().getSize().getWidth();       //dimension of browser window
		 int xPos = loginbtn.getLocation().getX();
			int yPos = loginbtn.getLocation().getY();
		 
		 Dimension dimuser = loginbtn.getSize();
         
        int heightuser= dimuser.height;
        int widthuser=dimuser.width;
        System.out.println("Winheight"+winHeight);
        System.out.println("winWidth"+winWidth);
        System.out.println("heightuser"+heightuser);
        System.out.println("widthuser"+widthuser);
        System.out.println("xPos"+xPos);
        System.out.println("yPos"+yPos);
        
        if (xPos>700 & xPos<800 & yPos>400 & yPos<600  ) {
       	LoggerLoad.info("Login button in the centre");
        }  
     }
	 
		public void loginbtncheck() {
			if(loginbtn.isDisplayed()) 
			{
			    System.out.println("Login button is Displayed");
			}
			else
			    System.out.println("Show more is not there");
		}

		public void usercolor() {
	    	  String color = usertext.getCssValue("color");
	    	  String hex = Color.fromString(color).asHex();
	    	  
	    	  if (hex=="#808080" ) {
	    		  LoggerLoad.info("User String is in grey color");
	    	  }
	    	  else {
	    		  LoggerLoad.info("User String is not in grey color");
	    	  }
	      }
	      
	      public void passwordcolor() {
	    	  String color = passwordtext.getCssValue("color");
	    	  String hex = Color.fromString(color).asHex();
	    	  
	    	  if (hex=="#808080" ) {
	    		  LoggerLoad.info("User String is in grey color");
	    	  }
	    	  else {
	    		  LoggerLoad.info("User String is not in grey color");
	    	  }
	      }
	      
	      public void loginuser(String user) {
	    	  userlogin.sendKeys(user);
	      }
	      
	      public void loginpassword(String password) {
	      }
	      
	      public void loginbtn() {
	    	  loginbtn.click();
	      }
}
