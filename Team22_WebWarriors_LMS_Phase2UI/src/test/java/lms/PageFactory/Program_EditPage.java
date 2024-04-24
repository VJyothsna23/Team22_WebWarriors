package lms.PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program_EditPage {


	public Program_EditPage(WebDriver driver){
		
        PageFactory.initElements(driver, this);

    }
	
}
