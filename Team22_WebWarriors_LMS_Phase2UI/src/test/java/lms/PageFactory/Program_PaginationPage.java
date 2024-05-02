package lms.PageFactory;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import lms.Utils.commonMethods;

public class Program_PaginationPage {
	
	public WebDriver driver;
	Program_ManagePage PMP;

	@FindBy(xpath="//span//button[@type='button']") public List<WebElement> pages;
	@FindBy(xpath="//button[@class = 'p-paginator-page p-paginator-element p-link p-highlight p-ripple ng-star-inserted']") public WebElement lastpage;
	@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-double-right']") public  WebElement doubleRightButton;

	public Program_PaginationPage(WebDriver driver){
		
		this.driver=driver;
        PageFactory.initElements(driver, this);
        PMP=new Program_ManagePage(driver);
    }
	
	
	public Boolean pages(int page) throws InterruptedException {
		Boolean total=false;
		if(totalPagesCount()>=page) {
			total=true;
		}
		return total;
	}
	
	public int totalPagesCount() throws InterruptedException {
		int totalPages;
		commonMethods.waitForElementToBeClickable(driver, doubleRightButton);
		//doubleRightButton.click();
		Thread.sleep(1000);
		String totalPagesText = lastpage.getText();
		totalPages = Integer.parseInt(totalPagesText);
//		doubleLeftButton.click();
//		totalNoOfPages = totalPages;
		System.out.println("Total numner of pages are: "+ totalPages);
		return totalPages;
    }
	
	
	public void firstNextPreviousLast(String icons) throws InterruptedException {
		Thread.sleep(2000);
		switch (icons.trim().toLowerCase()) {
		case "first":
			commonMethods.actionsClick(PMP.doubleLeftButton, driver);
			break;
		case "next":
		     commonMethods.actionsClick(PMP.nextPageButton, driver);
			break;
		case "last":
		commonMethods.actionsClick(doubleRightButton, driver);
			break;
		case "previous":
		commonMethods.actionsClick(PMP.LeftButton, driver);
			break;
		
		}
		
	}
	
	
	
	public boolean isFirstNextPreviousLastIconEnabled(String iconName) {
		boolean iconpresent = false;
		switch (iconName.trim().toLowerCase()) {
		case "first":
			iconpresent=PMP.doubleLeftButton.isEnabled();
			//flag = util.isElementEnabled(firstPageIcon);
			break;
		case "next":
			iconpresent=PMP.nextPageButton.isEnabled();
			//flag = util.isElementEnabled(nextPageIcon);
			break;
		case "last":
			iconpresent=PMP.doubleRightButton.isEnabled();
			//flag = util.isElementEnabled(lastPageIcon);
			break;
		case "previous":
			iconpresent=PMP.LeftButton.isEnabled();
			//flag = util.isElementEnabled(previousPageIcon);
			break;
		}
		return iconpresent;
	}

	
	public void navigateToPageNumber(int pageNum) {
		for(WebElement eachpage : pages) {
			if(eachpage.getText().contains(Integer.toString(pageNum))) {
				eachpage.click();
			}
		}
	}
	
	public Boolean isPageHighlighted(int pageNum) {
		String pagenum =Integer.toString(pageNum);
		System.out.println(pagenum);
		for(WebElement eachpage : pages) {
        
		if((eachpage.getAttribute("class").contains("p-highlight"))&&(eachpage.getText().equals(pagenum)))
		{
			return true;
		}
		
		 }
		return false;
	}
	
	
}

