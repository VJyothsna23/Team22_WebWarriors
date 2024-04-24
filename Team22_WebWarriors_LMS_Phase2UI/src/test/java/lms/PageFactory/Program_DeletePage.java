package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program_DeletePage {

	

	public Program_DeletePage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
