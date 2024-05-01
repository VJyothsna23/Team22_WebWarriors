package lms.PageFactory;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms.Utils.ConfigReader;
import lms.Utils.commonMethods;

public class Program_ManagePage {
	
	public static WebDriver driver;
	public static String next;
	//int count =0;
	public static int totalNoOfPages;
	public static int x;
	public static int y;
	public static int z;
	
	//Navigating to other links
	@FindBy(xpath = "//span[text()='Program']") public  WebElement programLinkPM;
	
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']") public  WebElement LMSTextPM;
	@FindBy(xpath = "//div[text()=' Manage Program']") public  WebElement manageProgramText;
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']") public  WebElement paginationtextPM;
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']") public  WebElement paginationPM;
	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']") public  WebElement totalProgramsTextPM;
	@FindBy(xpath = "//span[text()='A New Program']") public  WebElement addNewProgramButton;
	@FindBy(xpath = "//div/button/span[@class='p-button-icon pi pi-trash']") public  WebElement deleteProgramButton;
	@FindBy(xpath="//tbody//tr") public List<WebElement> rowsinTable;
	@FindBy(xpath="//tr/th") public List<WebElement> colheaders;
	@FindBy(tagName="th") public WebElement headernames;
	
	@FindBy(xpath = "//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']") public WebElement sortIcon;
	@FindBy(xpath = "//tbody/tr/td[1]") public List<WebElement> checkBoxes;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-pencil']") public List<WebElement> editProgramButton;
	@FindBy(xpath = "//td//span[@class='p-button-icon pi pi-trash']") public  List<WebElement> eachrowdeleteProgramsButton;
	@FindBy(xpath = "//input[@id='filterGlobal']") public  WebElement searchBarPM;
	
	@FindBy(id = "username") public  WebElement userLP;
	@FindBy(id = "password") public  WebElement passwordLP;
	@FindBy(id = "login") public  WebElement loginButton;
	
	
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']") public  WebElement nextPageButton;
	@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-double-right']") public  WebElement doubleRightButton;
	@FindBy(xpath = "//button[@class = 'p-paginator-page p-paginator-element p-link p-highlight p-ripple ng-star-inserted']") public  WebElement lastPage;
	@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-double-left']") public  WebElement doubleLeftButton;
	@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-left']") public  WebElement LeftButton;
	@FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']") public WebElement numberpages;
	

	//navigating pages
	@FindBy(xpath = "//span[@class='mat-button-wrapper']") public List<WebElement> pages;
	@FindBy(xpath = "//button[@id='batch']") public WebElement batchpage;
	@FindBy(xpath = "//button[@id='user']") public WebElement userpage;
	@FindBy(xpath = "//button[@id='logout']") public WebElement logoutpage;

	public Program_ManagePage(WebDriver driver){
		
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
	
	public String dashboard_page() {
		String title=driver.getTitle();
		return title;	
	}
	
	public void clickprogram() {
		commonMethods.actionsClick(programLinkPM,driver);
	}
	
	public String manageprogramurl() {
		String mp_url=driver.getCurrentUrl();
		return mp_url;
	}
	
	public String manageprmtext() {
		String mngprgm=manageProgramText.getText();
		return mngprgm;
	}
	
	
//	String text=driver.findElement(totalPrograms).getText();
//	System.out.println(text);
//	int total_Programs=Integer.parseInt(text.substring(text.indexOf("are")+4,text.indexOf("programs")-1));
	
	public String entries() {

	
	String entries=paginationPM.getText();
	System.out.println(entries);
	String totalrows=(totalProgramsTextPM.getText()).replaceAll("[^0-9]","");
	
	String[] numbersplit = entries.split(" ");
	x=Integer.parseInt(numbersplit[1]);
	y=Integer.parseInt(numbersplit[3]);
	z=Integer.parseInt(totalrows);
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
	
	public Boolean footerdisplay() {
		Boolean foot=totalProgramsTextPM.isDisplayed();
		return foot;
	}
	
	public Boolean deletebutton() {
	Boolean del=deleteProgramButton.isEnabled();
	return del;
	}
	
	
	public String addnewprgm() {
		String newprgm=addNewProgramButton.getText();
		return newprgm;
	}
	
	public int rowsize() {
		int rowsize=rowsinTable.size();
		return rowsize;
	}
	
	public void validateHeaders() {
		
		
		List<String> expheader = Arrays.asList("","Program Name","Program Description","Program Status","Edit / Delete");
		List<String> actualheader=new ArrayList<String>();
		for(WebElement Header:colheaders)
		{
		String headertext=Header.getText();
		actualheader.add(headertext);
		
		}
		assertEquals(actualheader, expheader);
		
	}
	public void goToNextPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    wait.until(ExpectedConditions.elementToBeClickable(nextPageButton)).click();
    }
	
	public int totalPagesCount() throws InterruptedException {
		int totalPages;
		commonMethods.waitForElementToBeClickable(driver, doubleRightButton);
		doubleRightButton.click();
		String totalPagesText = lastPage.getText();
		totalPages = Integer.parseInt(totalPagesText);
		doubleLeftButton.click();
		totalNoOfPages = totalPages;
		System.out.println("Total numner of pages are: "+ totalPages);
		return totalPages;
    }
	
	public int collectAllCheckBoxes(int totalpages) throws InterruptedException {
		int counter = 1;
		List<WebElement> checkboxes = new ArrayList<>();
		checkboxes.addAll(checkBoxes);
		while ( counter < totalpages) {
	            goToNextPage();
//	            Thread.sleep(1000);
	            checkboxes.addAll(checkBoxes);
	            counter++;
	     }
		System.out.println("Total number of checkboxes are: " + checkboxes.size());
		return checkboxes.size();
	}
	
	
	public int collectAllEditButtons(int totalpages) throws InterruptedException {
		int counter = 1;
		List<WebElement> editbuttons = new ArrayList<>();
		editbuttons.addAll(editProgramButton);
		while ( counter < totalpages) {
	            goToNextPage();
//	            Thread.sleep(1000);
	            editbuttons.addAll(editProgramButton);
	            counter++;
	     }
		System.out.println("Total number of editbuttons are: " + editbuttons.size());
		return editbuttons.size();
	}
	
	public int collectAllDeleteButtons(int totalpages) throws InterruptedException {
		int counter = 1;
		List<WebElement> delbuttons = new ArrayList<>();
		delbuttons.addAll(eachrowdeleteProgramsButton);
		while ( counter < totalpages) {
	            goToNextPage();
//	            Thread.sleep(1000);
	            delbuttons.addAll(eachrowdeleteProgramsButton);
	            counter++;
	     }
		System.out.println("Total number of deletebuttons are: " + delbuttons.size());
		return delbuttons.size();
	}

    public String searchTextBox() {
    	
    	String search=searchBarPM.getAttribute("placeholder");
    	System.out.println(search);
    	
		return null;
    	
    }
    
    
    
    public void checkSortIcon() {
    	int col1=0;
    	int col4=4;
    	for (int i = 0; i < colheaders.size(); i++) {
            
    	if((sortIcon.isDisplayed() && (i == col1 || i == col4))) {
    		 System.out.println("Sort icon is not present for column " + (i + 1));

    	}else{
            System.out.println("Sort icon is present for column " + (i + 1));
        }
    }
    }
    
    
    //navigating through pages
   
    
    public void batchPage() {
    	commonMethods.actionsClick(batchpage, driver);
    }
    
    public void userPage() {
    	commonMethods.actionsClick(userpage, driver);
    	userpage.click();
    }
    
    public void logoutPage() {
    	commonMethods.actionsClick(logoutpage, driver);
    }
    
}

