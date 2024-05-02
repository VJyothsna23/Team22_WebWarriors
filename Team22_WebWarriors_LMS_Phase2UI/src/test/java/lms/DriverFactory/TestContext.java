package lms.DriverFactory;

import java.time.Duration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import lms.Utils.ConfigReader;
import lms.PageFactory.*;

public class TestContext {

	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	WebDriver driver;
	
	AppLoginPage lp;
	LogoutPage lop;
	DashBoardPage dbp;
	
	Program_ManagePage pm;
	Program_PaginationPage pp;
	Program_AddPage pa;
	Program_EditPage pe;
	Program_DeletePage pd;
	Program_SortPage ps;
	
	Batch_ManagePage bm;
	Batch_AddPage ba;
	Batch_EditPage be;
	Batch_DeletePage bd;
	
	
	User_AddPage ua;
	User_EditPage ue;
	User_DeletePage ud;
	User_AssignStudentPage uas;
	User_AssignStaffPage uastf;
	
	public void setDriver(WebDriver driver) {
		String browser = ConfigReader.readPropertiesFile("browser");
		System.out.println("The browser value from properties file is: "+ browser);
		
		if (browser.equalsIgnoreCase("Chrome")){
			ChromeOptions co = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			
	//		co.addArguments("--headless");
			co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(co);
			threadLocalDriver.set(driver);
		}

		else if(browser.equalsIgnoreCase("Edge")){
			EdgeOptions eo = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			
//			eo.addArguments("--headless");
			driver = new EdgeDriver(eo);
			threadLocalDriver.set(driver);
		}

		else if(browser.equalsIgnoreCase("FireFox")) {
			
			FirefoxOptions fo = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			
//			fo.addArguments("--headless");
			driver = new FirefoxDriver(fo);
			threadLocalDriver.set(driver);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	public AppLoginPage getLp() {
		return lp;
	}
	
	public LogoutPage getLop() {
		return lop;
	}

	public DashBoardPage getDbp() {
		return dbp;
	}

	public Program_SortPage getPs() {
		return ps;
	}

	public Program_ManagePage getPm() {
		return pm;
	}

	public Program_PaginationPage getPp() {
		return pp;
	}

	public Program_AddPage getPa() {
		return pa;
	}

	public Program_EditPage getPe() {
		return pe;
	}

	public Program_DeletePage getPd() {
		return pd;
	}

	public Batch_ManagePage getBm() {
		return bm;
	}

	public Batch_AddPage getBa() {
		return ba;
	}

	public Batch_EditPage getBe() {
		return be;
	}

	public Batch_DeletePage getBd() {
		return bd;
	}

	

	public User_AddPage getUa() {
		return ua;
	}

	public User_EditPage getUe() {
		return ue;
	}

	public User_DeletePage getUd() {
		return ud;
	}

	public User_AssignStudentPage getUas() {
		return uas;
	}

	public User_AssignStaffPage getUastf() {
		return uastf;
	}


	public void initializePageObjects(WebDriver driver) {
		
		this.lp = new AppLoginPage(driver);
		this.lop = new LogoutPage(driver);
		this.dbp = new DashBoardPage(driver);
		
		this.pm = new Program_ManagePage(driver);
		this.pp = new Program_PaginationPage(driver);
		this.pa = new Program_AddPage(driver);
		this.pe = new Program_EditPage(driver);
		this.pd = new Program_DeletePage(driver);
		this.ps = new Program_SortPage(driver);
		
		this.bm = new Batch_ManagePage(driver);
		this.ba = new Batch_AddPage(driver);
		this.be = new Batch_EditPage(driver);
		this.bd = new Batch_DeletePage(driver);
		
		
		this.ua = new User_AddPage(driver);
		this.ue = new User_EditPage(driver);
		this.ud = new User_DeletePage(driver);
		this.uas = new User_AssignStudentPage(driver);
		this.uastf = new User_AssignStaffPage(driver);
		
		
	}
	
}