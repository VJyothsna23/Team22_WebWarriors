package lms.PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utils.ConfigReader;
import lms.Utils.commonMethods;

public class User_EditPage {
	
	public static WebDriver driver;	

	@FindBy(id = "username") public  WebElement userLP;
	@FindBy(id = "password") public  WebElement passwordLP;
	@FindBy(id = "login") public  WebElement loginButton;
	@FindBy(xpath = "//span[text()='User']") public  WebElement user;
	@FindBy(xpath ="//*[@id='filterGlobal']") public  WebElement searchbox;
    @FindBy(xpath = "//table/tbody/tr/td[6]/div/span/button[1]") public  WebElement edituserutton;
    @FindBy(xpath = "//span[text()='User Details']") public  WebElement userdetailstext;
    @FindBy(xpath = " //div[text()='User Updated Successfully']") public  WebElement successmessage;
    @FindBy(xpath = "//div[text='Failed']") public  WebElement errormessage;
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
	@FindBy(xpath = "//*[@id='userRoleStatus']/div/div[2]") public WebElement selectrolestatusdropdown;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[2]") public WebElement selectvisastatusdropdown;
	
	
	//list of dropdown elements
	@FindBy(xpath = "//*[@id='roleId']/div/div[3]/div/ul/p-dropdownitem/li") public List<WebElement> selectrole;
	@FindBy(xpath = "//*[@id='userRoleStatus']/div/div[3]/div/ul/p-dropdownitem/li") public List<WebElement> selectrolestatus;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem/li") public List<WebElement> selectvisastatus;
	
	
	
	

	public User_EditPage(WebDriver driver){
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
	
	
		public void searchuserinsb() throws InterruptedException {
			searchbox.sendKeys("Kim");
			Thread.sleep(1000);
			
			}
		
		public void clickedituserbutton() throws InterruptedException {
			
			edituserutton.click();
			Thread.sleep(1000);
		}
	 
		
		public void updatefieldswithvaliddata() throws InterruptedException {
			searchuserinsb(); 
			clickedituserbutton();
			 String newwindow= driver.getWindowHandle();
			 driver.switchTo().window(newwindow);
			 
			 Thread.sleep(1000);
			
			firstname.clear();
			Thread.sleep(1000);
			firstname.sendKeys("christina");
			
			middlename.clear();
			Thread.sleep(1000);
			middlename.sendKeys("Jechibeth");
			
			
			lastname.clear();
			Thread.sleep(1000);
			lastname.sendKeys("lois");
			
			location.clear();
			Thread.sleep(1000);
			location.sendKeys("Australia");
			
			phonenumber.clear();
			Thread.sleep(1000);
			phonenumber.sendKeys("4569871661");
			
			Thread.sleep(1000);
			
			linkedInrul.clear();
			Thread.sleep(1000);
			linkedInrul.sendKeys("linkedin.com/fajkj");
			
			email.clear();
			Thread.sleep(1000);
			email.sendKeys("jweklr@gmail.com");
			
			undergraduate.clear();
			Thread.sleep(1000);
			undergraduate.sendKeys("BCA");
			
			postgraduate.clear();
			Thread.sleep(1000);
			postgraduate.sendKeys("MCA");
			
			timezone.clear();
			Thread.sleep(1000);
			timezone.sendKeys("IST");
			
			usercomments.clear();
			Thread.sleep(1000);
			usercomments.sendKeys("no comments");
			
			
		   submitbutton.click();
	
		  }
		
		
     public void updatefieldswithInvaliddata() throws InterruptedException {
			
    	     searchuserinsb(); 
			clickedituserbutton();
			 String newwindow= driver.getWindowHandle();
			 driver.switchTo().window(newwindow);
			 
			 Thread.sleep(1000);
			
			firstname.clear();
			Thread.sleep(1000);
			firstname.sendKeys("c475474");
			
			middlename.clear();
			Thread.sleep(1000);
			middlename.sendKeys("46464h");
			
			
			lastname.clear();
			Thread.sleep(1000);
			lastname.sendKeys("lois");
			
			location.clear();
			Thread.sleep(1000);
			location.sendKeys("Aus#4tralia");
			
			phonenumber.clear();
			Thread.sleep(1000);
			phonenumber.sendKeys("4569871661@");
			
					
			linkedInrul.clear();
			Thread.sleep(1000);
			linkedInrul.sendKeys("linkedin.com.fajkj");
			
			email.clear();
			Thread.sleep(1000);
			email.sendKeys("jwekfgddhdfhfdlr@gmail");
			
			undergraduate.clear();
			Thread.sleep(1000);
			undergraduate.sendKeys("BCr#A");
			
			postgraduate.clear();
			Thread.sleep(1000);
			postgraduate.sendKeys("MCA");
			
			timezone.clear();
			Thread.sleep(1000);
			timezone.sendKeys("IS^^T");
			
			usercomments.clear();
			Thread.sleep(1000);
			usercomments.sendKeys("no comments");
			
			email.clear();
			Thread.sleep(1000);
			email.sendKeys("jwebmbmbb@gmail.com");
			
			
		    submitbutton.click();
		    Thread.sleep(3000);;
		    
			
		 }
		
		
      public void mandatoryfields() throws InterruptedException {
    	    searchuserinsb(); 
			clickedituserbutton();
			 String newwindow= driver.getWindowHandle();
			 driver.switchTo().window(newwindow);
			 
			 Thread.sleep(1000);
    	      	  
    	    firstname.clear();
			Thread.sleep(1000);
			firstname.sendKeys("cryrtjtfjd");
			
			
			lastname.clear();
			Thread.sleep(1000);
			lastname.sendKeys("lddjfjgfjdfhdf");
			
			location.clear();
			Thread.sleep(1000);
			location.sendKeys("Aafrica");
			
			phonenumber.clear();
			Thread.sleep(1000);
			phonenumber.sendKeys("4569871661");

			email.clear();
			Thread.sleep(1000);
			email.sendKeys("jwtu45@gmail.com");
			submitbutton.click();
         }
		
		
		public void optionalfields() throws InterruptedException {
			
			searchuserinsb(); 
			clickedituserbutton();
			 String newwindow= driver.getWindowHandle();
			 driver.switchTo().window(newwindow);
			 
			 
			    middlename.clear();
				Thread.sleep(1000);
				middlename.sendKeys("Eunice");
				
			    linkedInrul.clear();
				Thread.sleep(1000);
				linkedInrul.sendKeys("linkedin.com/dfd");
				
			   undergraduate.clear();
				Thread.sleep(1000);
				undergraduate.sendKeys("ca");
				
				postgraduate.clear();
				Thread.sleep(1000);
				postgraduate.sendKeys("llb");
				
				timezone.clear();
				Thread.sleep(1000);
				timezone.sendKeys("mst");
				
				usercomments.clear();
				Thread.sleep(1000);
				usercomments.sendKeys("no  no comments");
				submitbutton.click();
				
				
				email.clear();
				Thread.sleep(1000);
				email.sendKeys("jwtu45@gmail.com");
				submitbutton.click();
		}
		
		
	public void onlyspecharornumber() throws InterruptedException {
		
		
		searchuserinsb(); 
		clickedituserbutton();
		 String newwindow= driver.getWindowHandle();
		 driver.switchTo().window(newwindow);
		 
		 Thread.sleep(1000);
		
		firstname.clear();
		Thread.sleep(1000);
		firstname.sendKeys("10937!@@#$%");
		
		middlename.clear();
		Thread.sleep(1000);
		middlename.sendKeys("*&#%@#486732");
		
		
		lastname.clear();
		Thread.sleep(1000);
		lastname.sendKeys("35871&^%#%#@");
		
		location.clear();
		Thread.sleep(1000);
		location.sendKeys("#%#&*@376873");
		
		phonenumber.clear();
		Thread.sleep(1000);
		phonenumber.sendKeys("2435&#%^@%@");
		
		Thread.sleep(1000);
		
		linkedInrul.clear();
		Thread.sleep(1000);
		linkedInrul.sendKeys("35876786^#%#@%@#");
		
		email.clear();
		Thread.sleep(1000);
		email.sendKeys("#%^&#@*#3288");
		
		undergraduate.clear();
		Thread.sleep(1000);
		undergraduate.sendKeys("#$%^#@&335");
		
		postgraduate.clear();
		Thread.sleep(1000);
		postgraduate.sendKeys("#@%&37823");
		
		timezone.clear();
		Thread.sleep(1000);
		timezone.sendKeys("#%&*32");
		
		usercomments.clear();
		Thread.sleep(1000);
		usercomments.sendKeys("$%^@&#%#77793()");
		
		submitbutton.click();

	    }
	
		
	 public void userupdatesdetailsandclickcancelbutton() throws InterruptedException {
		 
		     searchuserinsb(); 
			 clickedituserbutton();
			 String newwindow= driver.getWindowHandle();
			 driver.switchTo().window(newwindow);
			 
			 Thread.sleep(1000);
			
			firstname.clear();
			Thread.sleep(1000);
			firstname.sendKeys("hihihi");
			
			middlename.clear();
			Thread.sleep(1000);
			middlename.sendKeys("jijiji");
			
			cancelbutton.click();
		 
	  }
	 
  }
	 	
		
		
		
		
		
		
		
		
		
	
		
		
	

