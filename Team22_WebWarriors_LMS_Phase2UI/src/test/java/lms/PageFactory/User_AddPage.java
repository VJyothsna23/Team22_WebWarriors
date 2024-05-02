package lms.PageFactory;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.Utils.ConfigReader;
import lms.Utils.commonMethods;

public class User_AddPage {
	
	static WebDriver driver;
   JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(id = "username") public  WebElement userLP;
	@FindBy(id = "password") public  WebElement passwordLP;
	@FindBy(id = "login") public  WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='User']") public  WebElement user;
	
	
	@FindBy(xpath ="//button[@label='Add New User']") public  WebElement addNewUser;
	
	@FindBy(xpath ="//tbody/tr/td[3]") public  List<WebElement>  Usernamlist;
	
	
	@FindBy(xpath = "//input[@data-placeholder='First name']") public static WebElement firstname;  //m
	@FindBy(xpath = "//input[@data-placeholder='Middle name']") public static WebElement middlename;
	@FindBy(xpath = "//input[@data-placeholder='Last name']") public static WebElement lastname;    //m
	@FindBy(xpath = "//input[@data-placeholder='Location']") public static WebElement location;         //m
	@FindBy(xpath = "//input[@data-placeholder='Phone no']") public static WebElement phonenumber;  //m
	@FindBy(xpath = "//input[@data-placeholder='LinkedIn Url']") public  static WebElement linkedInrul;
	@FindBy(xpath = "//input[@data-placeholder='Email address']") public static WebElement email;
	@FindBy(xpath = "//input[@data-placeholder='Under Graduate']") public static WebElement undergraduate;
	@FindBy(xpath = "//input[@data-placeholder='Post Graduate']") public  static WebElement postgraduate;
	@FindBy(xpath = "//input[@data-placeholder='Time Zone']") public static WebElement timezone;
	@FindBy(xpath = "//input[@data-placeholder='User Comments']") public static WebElement usercomments;
	
	@FindBy(xpath = "//span[text()='Cancel']") public  WebElement cancelbutton;
	@FindBy(xpath = "//span[text()='Submit']") public  WebElement submitbutton;
	@FindBy(xpath="/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[1]/div/button/span") public  WebElement closebutton;
	
	//display purpose
	@FindBy(xpath = "//label[text()='User Role']") public  WebElement userrole;                   //m
	@FindBy(xpath = "//label[text()='User Role Status']") public  WebElement userrolestatus;     //m   
	@FindBy(xpath = "//label[text()='User Visa Status']") public  WebElement uservisastatus;     //m  
	
	//for tag purpose
	@FindBy(xpath = "//*[@id='roleId']")   public  WebElement selectroledd;
    @FindBy(xpath = "//*[@id='userRoleStatus']")   public  WebElement selectrolestatusdd;
	@FindBy(xpath = "//*[@id='userVisaStatus']")   public  WebElement selectvisastatusdd;
	
	
	//dropdownbutton
	@FindBy(xpath = "//*[@id='roleId']/div/div[2]") public WebElement selectroledropdown;
	@FindBy(xpath = "//div[@role='button']/span[@class='p-dropdown-trigger-icon ng-tns-c101-23 pi pi-chevron-down']") public WebElement selectrolestatusdropdown;
	@FindBy(xpath = "//div[@role='button']/span[@class='p-dropdown-trigger-icon ng-tns-c101-24 pi pi-chevron-down']") public WebElement selectvisastatusdropdown;
	
	
	//list of dropdown elements
	@FindBy(xpath = "//*[@id='roleId']/div/div[3]/div/ul/p-dropdownitem/li") public List<WebElement> selectrole;
	@FindBy(xpath = "//*[@id='userRoleStatus']/div/div[3]/div/ul/p-dropdownitem/li") public List<WebElement> selectrolestatus;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem/li") public List<WebElement> selectvisastatus;
	

	
	@FindBy(xpath = "(//li[@role='option']//span)[1]") public WebElement selectR01;	
	@FindBy(xpath = "(//li[@role='option']//span)[2]") public WebElement selectR02;
	@FindBy(xpath = "//*[@id='userRoleStatus']/div/span") public WebElement selectActive;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[3]/li") public WebElement selectGCEAD;
	
	//*[@id="userVisaStatus"]/div/div[3]/div/ul/p-dropdownitem[3]/li
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]") public WebElement paginationtext;
	@FindBy(xpath ="//*[@id='filterGlobal']") public  WebElement searchbox;
	
	@FindBy(xpath ="//mat-error") public  List<WebElement> errors;
	

	
	public User_AddPage(WebDriver driver){
		this.driver=driver;
        PageFactory.initElements(driver, this);
      }
	
	
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

		//clicks user in dashboard page
		public void clickUser() {
		commonMethods.actionsClick (user,driver);
	     }
	
	
	     public void addnewuser() {
	    	 commonMethods.actionsClick(addNewUser, driver);
	     }
	     
	
		public void checkallfields() {
		
		System.out.println("firstname is displayed  " + firstname.isDisplayed());
		System.out.println("middlename is displayed "+ middlename.isDisplayed());
		System.out.println("lastname is displayed"+ lastname.isDisplayed());
		System.out.println("location is displayed "+ location.isDisplayed());
		
		System.out.println("phonenumberis displayed "+ phonenumber.isDisplayed());
		System.out.println("linkedin is displayed "+ linkedInrul.isDisplayed());
		System.out.println("email is displayed "+ email.isDisplayed());
		
		System.out.println("undergraduate "+ undergraduate.isDisplayed());
		System.out.println("postgraduate"+postgraduate.isDisplayed());
		
		
		System.out.println("timezone  is displayed"+ timezone.isDisplayed());
		System.out.println("usercomments  is displayed"+usercomments.isDisplayed());
		
		System.out.println("cancelbutton is displayed "+ cancelbutton.isDisplayed());
		System.out.println("submitbutton  is displayed"+submitbutton.isDisplayed());
		
		
		System.out.println("userrole is displayed "+ userrole.isDisplayed());
		System.out.println("userrolestatus is displayed "+userrolestatus.isDisplayed());
		System.out.println("uservisastatus  is displayed "+uservisastatus.isDisplayed());
		
		}
		
		
		public void checktextboxordropdown() {
			
		 WebElement[] inputfields = new WebElement[] {firstname,middlename,lastname,location,phonenumber,
			                                      linkedInrul,email,undergraduate,postgraduate,
				                                      timezone,usercomments,
				                                      selectroledd,selectrolestatusdd,selectvisastatusdd};
			
			for (WebElement webElement : inputfields) {
				  
				 if(webElement.getTagName().contains("input")) {
				   System.out.println(webElement+ " is textbox");
			    }else if (webElement.getTagName().contains("dropdown")) {
			    	 System.out.println(webElement + " is dropdown");
			    }
			
		   }
	     }
	
	
	 public void adminenterdetails_scenarioutline(String Firstname, String Middlename, String Lastname, String Location , String Phonenumber, String LinkedInUrl, String Email, String Undergraduate, String Postgraduate, String Timezone, String Usercomments, String Userrole, String Userrolestatus, String UServisastatus) throws InterruptedException {
		    
	    String newwindow= driver.getWindowHandle();
		 driver.switchTo().window(newwindow);
		 
		        firstname.sendKeys(Firstname);
	            middlename.sendKeys(Middlename);
	            lastname.sendKeys(Lastname);
	            location.sendKeys(Location);
	            phonenumber.sendKeys(Phonenumber);
	            linkedInrul.sendKeys(LinkedInUrl);
	            email.sendKeys(Email);
	            undergraduate.sendKeys(Undergraduate);
	            postgraduate.sendKeys(Postgraduate);
	            timezone.sendKeys(Timezone);
	            usercomments.sendKeys(Usercomments);
	            
	            
	        selectroledropdown.click();
	       	      
	        for (WebElement roles : selectrole) {
				    if(roles.getText().equalsIgnoreCase(Userrole)) {
	            	roles.click();
	            	Thread.sleep(2000);
          	}
          	
	        }
         
          selectrolestatusdropdown.click();
          Thread.sleep(1000);
          	
          	 for (WebElement rolesstatus : selectrolestatus) {
				    if(rolesstatus.getText().equalsIgnoreCase(Userrolestatus)) {
				    	rolesstatus.click();
	            	Thread.sleep(2000);
       	    }
				    
          	 }	    
			selectvisastatusdropdown.click();	 
			Thread.sleep(1000);
			
			for (WebElement rolesvisastatus : selectvisastatus) {
			    if(rolesvisastatus.getText().equalsIgnoreCase( UServisastatus)) {
			    	rolesvisastatus.click();
            	Thread.sleep(2000);
   	        }  
			
		      }
            
             submitbutton.click();
	          
	       }
	 
	 
	  public void userentersdetailandclickcloseicon() throws InterruptedException {
		firstname.sendKeys("neeya");
		lastname.sendKeys("naana");
		
		Thread.sleep(1000);
		closebutton.click();
		
		Thread.sleep(1000);
	  }
	 
	 public void userentersdetailandclickcancelbutton() throws InterruptedException {
			
			Thread.sleep(1000);
			cancelbutton.click();
			Thread.sleep(1000);
		
	   }

	 	 
	 public void adminentersallfields() throws InterruptedException {
		 
		 String newwindow= driver.getWindowHandle();
		 driver.switchTo().window(newwindow);
		 
		        firstname.sendKeys("Abraham");
	            middlename.sendKeys("great");
	            lastname.sendKeys("Lincoln");
	            location.sendKeys("Delaware");
	            phonenumber.sendKeys("1234567890");
	            linkedInrul.sendKeys("linkedin.com/Abraham");
	            email.sendKeys("ablin@yahoo.com");
	            undergraduate.sendKeys("BE");
	            postgraduate.sendKeys("ME");
	            timezone.sendKeys("EST");
	            usercomments.sendKeys("good");
	            
	            selectroledropdown.click();
	            Thread.sleep(3000);
	            selectR01.click();
	            Thread.sleep(1000);
	            
	            
	           	selectroledropdown.click();
	            Thread.sleep(3000);
	            selectActive.click();
	            Thread.sleep(1000);
	            
	            selectrolestatusdropdown.click();
	            Thread.sleep(3000);
	            selectGCEAD.click();
	            Thread.sleep(1000);
	            
	            
	            Thread.sleep(1000);
	            submitbutton.click();

		     }

	 
	 public void userskipsvaluesinmandatoryfields() throws InterruptedException {
		 
		 middlename.sendKeys("great");
		 linkedInrul.sendKeys("linkedin.com/Abraham");
		 email.sendKeys("ablin@yahoo.com");
         undergraduate.sendKeys("BE");
         postgraduate.sendKeys("ME");
         timezone.sendKeys("EST");
         usercomments.sendKeys("good");
         Thread.sleep(1000);
         submitbutton.click();
		 
	   }
	 
	 
	  public void userentersinvalidvalues() throws InterruptedException {
		  
		  firstname.sendKeys("A#3538");
          middlename.sendKeys("6490928");
          lastname.sendKeys("573892");
          location.sendKeys("D#g303");
          phonenumber.sendKeys("1234567890@arw1");
          linkedInrul.sendKeys("linkedin.Abraham");
          email.sendKeys("ablin@yahoo");
          undergraduate.sendKeys("B46E");
          postgraduate.sendKeys("ME575");
          timezone.sendKeys("ES3262T");
          usercomments.sendKeys("go1311od");
          
          Thread.sleep(1000);
          submitbutton.click();
		  
		  }
	 
	 
	    public void userentersnodata() throws InterruptedException
	    {
	    	firstname.sendKeys("");
	          middlename.sendKeys("");
	          lastname.sendKeys("");
	          location.sendKeys("");
	          phonenumber.sendKeys("");
	          linkedInrul.sendKeys("");
	          email.sendKeys("");
	          undergraduate.sendKeys("");
	          postgraduate.sendKeys("");
	          timezone.sendKeys("");
	          usercomments.sendKeys("");
	          
	          Thread.sleep(1000);
	          submitbutton.click();
	    }
	 
	 
	 
//	 @Then("Admin gets message User added Successfully")
//	 public void admin_gets_message_user_added_successfully() {
//	    
//	 }
	 
	 
	 
		 
}