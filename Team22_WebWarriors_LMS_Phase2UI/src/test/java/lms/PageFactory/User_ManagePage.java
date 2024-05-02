package lms.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import lms.Utils.ConfigReader;
import lms.Utils.commonMethods;

public class User_ManagePage {
	
	
	public static WebDriver driver;	
	 static String  nextclassname;
	 public static int totalNoOfPages;
	 static int x,y,z;
	
	@FindBy(id = "username") public  WebElement userLP;
	@FindBy(id = "password") public  WebElement passwordLP;
	@FindBy(id = "login") public  WebElement loginButton;
	
	
	
	//manageusermodule
	@FindBy(xpath = "//span[text()='User']") public  WebElement user;
	@FindBy(xpath = "//div[text()=' Manage User']") public  WebElement manageuser;
	@FindBy(xpath = "//th") public  List<WebElement> headertext;
	
	
	@FindBy(xpath = "//div[@class='box']/div[1]//button") public  WebElement deletebuttondisabled;
	@FindBy(xpath ="//button[@label='Add New User']") public  WebElement addNewUser;
	@FindBy(xpath ="//button[@label='Assign Student']") public  WebElement assignstudent;
	@FindBy(xpath ="//button[@label='Assign Staff']") public  WebElement assignstaff;
	@FindBy(xpath ="//*[@id='filterGlobal']") public  WebElement searchbox;
	@FindBy(xpath ="//tbody/tr/td[1]") public  List<WebElement> checkboxesUser;
	
	@FindBy(xpath ="//span[@class='p-button-icon pi pi-pencil']") public  List<WebElement>  editbuttons;
	@FindBy(xpath ="//td[6]//span[@class='p-button-icon pi pi-trash']") public  List<WebElement>  deletebuttons;
	
	@FindBy(xpath ="//tbody/tr/td[3]") public  List<WebElement>  Usernamlist;
	//@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']/button") public List<WebElement> paginationelement;
	//@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-right']") public  WebElement nextbutton;
	
	//FindBy(xpath ="//button[@class='p-paginator-next p-paginator-element p-link p-ripple']") public  WebElement nextbutton;
		
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']") public  WebElement paginationPM;
	@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-left']") public  WebElement LeftButton;
	@FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']") public WebElement numberpages;
	
	//	@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']/button") public List<WebElement> paginationelement;
		@FindBy(xpath = "//tr[1]//td[1]//div[@role='checkbox']") public  WebElement checkbox;
		@FindBy(xpath ="//tbody/tr") public  List<WebElement> rows;
		
	//pagination elements
		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']") public  WebElement nextPageButton;
		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']/..") public  WebElement nextPageButtonDisabled;
		@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-double-right']") public  WebElement doubleRightButton;
		@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-double-left']") public  WebElement doubleLeftButton;
		@FindBy(xpath = "//button[@class = 'p-paginator-page p-paginator-element p-link p-highlight p-ripple ng-star-inserted']") public  WebElement lastPage;
		
		

 	public User_ManagePage(WebDriver driver){
		this.driver=driver;
        PageFactory.initElements(driver, this);

    }
	
	public void login() {	
		userLP.sendKeys(ConfigReader.readPropertiesFile("username"));
		passwordLP.sendKeys(ConfigReader.readPropertiesFile("password"));
		loginButton.click();
	}

     //login
	public void dashboard_page_login() throws InterruptedException {
		String url = ConfigReader.readPropertiesFile("HomePageUrl");
		driver.get(url);
		login();
		Thread.sleep(1000);
	 }

	//clicks user in dashboard page
	public void clickUser() {
		commonMethods.actionsClick (user,driver);
	 }
	
	//checking  'user' in the url  
	public void checkurl() {
		boolean status  = driver.getCurrentUrl().contains("user");
		System.out.println(status);
	  }
	   
	   
	//check manage user in the user page   
	public void checkmangeuser() {
		  boolean status=   manageuser.isDisplayed();
		   System.out.println(status);
       }
	   
	 //validating header with column names such as  Id, Name, Location, Phone Number, Edit/Delete
	 public void validateHeaders() {
						
			List<String> expectedheader = Arrays.asList("","ID","Name","Location","Phone Number","Edit / Delete");
		
			List<String> actualheader=new ArrayList<String>();
			
		   for(WebElement Header:headertext)
			{
			String headertext=Header.getText();
			actualheader.add(headertext);
			System.out.println(Header.getText());
			}
			Assert.assertEquals(actualheader, expectedheader);
			
	   }
	
	   //checking delete button is disabled
	   public void deletedisabled() {
		   System.out.println(deletebuttondisabled.isEnabled());
		  Assert.assertFalse(deletebuttondisabled.isEnabled());   
		   }
	
	   
	   //checking add new user,assign staff ,assign student is displayed	
	   public void  checkbuttondisplay(String button ) {
	
		if(button.equals("+ Add New User")) {
			System.out.println(addNewUser.isDisplayed());
           
		}else if(button.equals("+ Assign staff")){
		
			System.out.println(assignstaff.isDisplayed());
			
			
		}else if(button.equals("+ Assign Student")){
			System.out.println(assignstudent.isDisplayed());
		
		}  
		}
	   
	  
	   //checking searchtextbox is displayed
	   public void checksearchbox() throws InterruptedException {
		   
		   System.out.println(searchbox.isDisplayed());
		   Thread.sleep(1000);
		   
	   }   

	   //Pagination 
	   public void goToNextPage() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		    wait.until(ExpectedConditions.elementToBeClickable(nextPageButton)).click();
	    }
		
		public int totalPagesCount() throws InterruptedException {
			int totalPages;
			Thread.sleep(1000);
			doubleRightButton.click();
			String totalPagesText = lastPage.getText();
			totalPages = Integer.parseInt(totalPagesText);
			doubleLeftButton.click();
			totalNoOfPages = totalPages;
			System.out.println("Total numner of pages are: "+ totalPages);
			return totalPages;
	    }
		
		//Checking checkbox is present in all rows
		public int collectAllCheckBoxes(int totalpages) throws InterruptedException {
			int counter = 1;
			List<WebElement> checkboxes = new ArrayList<>();
			checkboxes.addAll(checkboxesUser);
			Thread.sleep(1000);
			while ( counter < totalpages) {
		            goToNextPage();
		            checkboxes.addAll(checkboxesUser);
		            counter++;
		     }
			System.out.println("Total number of checkboxes are: " + checkboxes.size());
			return checkboxes.size();
		}
	   
		//checking editicon is present in all rows
		public int collectAllediticons(int totalpages) throws InterruptedException {
			int counter = 1;
			List<WebElement> editicons = new ArrayList<>();
			editicons.addAll(editbuttons);
			Thread.sleep(1000);
			while ( counter <totalpages ) {
		            goToNextPage();
		            editicons.addAll(editbuttons);
		            counter++;
		     }
			System.out.println("Total number of edit icons  are: " + editicons.size());
			return editicons.size();
		}
	   
	   
		//checking deleteicon is present in all rows
		public int collectAlldeleteicons(int totalpages) throws InterruptedException {
					int counter = 1;
					List<WebElement> deleteicons = new ArrayList<>();
					deleteicons.addAll(deletebuttons);
					Thread.sleep(1000);
					while ( counter <totalpages ) {
				            goToNextPage();
				            deleteicons.addAll(deletebuttons);
				            counter++;
				     }
					System.out.println("Total number of delete icons are: " + deleteicons.size());
					return deleteicons.size();
			}
				
					
	     
		public void searchuserinsb() throws InterruptedException {
					searchbox.sendKeys("Div");
					Thread.sleep(1000);
			}
			   
	        	
	    
		public void entersunrelatedkeywords() throws InterruptedException {
	        
			searchbox.sendKeys("ttttttttt");
			Thread.sleep(1000);
	        }
	   
		public String entries() {
			 
			
			String entries=paginationPM.getText();
			System.out.println(entries);
			
			
			String[] numbersplit = entries.split(" ");
			x=Integer.parseInt(numbersplit[1]);
			y=Integer.parseInt(numbersplit[3]);
			z=Integer.parseInt(numbersplit[5]);
			System.out.println(x);
			System.out.println(y);
			System.out.println(z);
			
			String entriestext="Showing "+x+" to "+y+" of "+z+" entries";
			return entriestext;
			
			}
		
		
		public boolean paginationcontrol() {	
			Boolean icon = null;
		if(doubleRightButton.isDisplayed()&&(doubleLeftButton.isDisplayed())&&(nextPageButton.isDisplayed())&&(LeftButton.isDisplayed())&&(numberpages.isDisplayed())) {
			icon=true;
		}
	 
		return icon;
			    
		}

	    }
	   
	   
	   
	   
	   
	   

	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	  
	   
	   
	   
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

