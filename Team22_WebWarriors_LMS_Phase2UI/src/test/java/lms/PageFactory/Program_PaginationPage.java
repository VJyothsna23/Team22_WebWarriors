package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program_PaginationPage {

	@FindBy(xpath = "//h1[text()='showing entries']") public  WebElement paginationTextPP;
	@FindBy(xpath = "//button[text()='']") public  WebElement leftDoubleButtonPaginationPP;
	@FindBy(xpath = "//button[text()='']") public  WebElement leftButtonPaginationPP;
	@FindBy(xpath = "//button[text()='']") public  WebElement rightDoubleButtonPaginationPP;
	@FindBy(xpath = "//button[text()='']") public  WebElement rightButtonPaginationPP;
	@FindBy(xpath = "//button[text()='']") public  WebElement pageNumberButtonPaginationPP;	
	@FindBy(xpath = "//h1[text()='In total there are number programs.']") public  WebElement totalProgramsText;

	public Program_PaginationPage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
