package lms.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonMethods {

	public static boolean validator(String actual, String expected) {

		if(actual.equalsIgnoreCase(expected)) {
			return true;
		}
		else {
			return false;
		}

	}

	public static List<String> printTextForWebElements(List<WebElement> options) {

		List<String> texts = new ArrayList<String>();

		int i=0;
		for(WebElement option: options) {
			texts.add(i,option.getText());
			i++;
		}

		System.out.println("The number of items in the list are: "+ texts.size());
		return texts;
	}

	public static List<String> getSortedList(List<String> originalList){
		System.out.println("original List Before sorting is"+ originalList);
		List<String> sortedList = new ArrayList<>(originalList);
		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Sorted List After sorting is"+ sortedList);

		return sortedList;
	}

	public static List<String> getSortedListDescending(List<String> originalList){
		System.out.println("original List Before sorting is"+ originalList);
		List<String> sortedList = new ArrayList<>(originalList);
		Collections.sort(originalList, (s1, s2) -> s2.compareToIgnoreCase(s1));
		System.out.println("Sorted List After sorting is"+ sortedList);

		return sortedList;
	}

	public static List<String> getSortedphonenumberlist(List<String> originalList){ 
		System.out.println("Original List Before sorting: " + originalList);       
		Collections.sort(originalList, (s1, s2) -> {
		long num1 = Long.parseLong(s1); 
		long num2 = Long.parseLong(s2); 
		return Long.compare(num1, num2);
		});    
		System.out.println("Sorted List After sorting: " + originalList);       
		return originalList;   
	}



//	public static List<String> getSortedListDescendingphone(List<String> originalList) {
//        System.out.println("Original List Before sorting: " + originalList);
//        // Sort the list of number strings in descending order numerically
//        Collections.sort(originalList, Comparator.comparingLong(Long::parseLong).reversed());
//        System.out.println("Sorted List After sorting in Descending Order: " + originalList);
//        return originalList;
//    }












public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));

}

public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));

}

public static String getActiveElementAttribute(WebDriver driver) {
	WebElement activeElement = driver.switchTo().activeElement();
	String message = activeElement.getAttribute("validationMessage");
	System.out.println("Actual message appeared on the screen is: " + message);
	return message;
}

public static void actionsClick(WebElement element, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.moveToElement(element).perform();
	actions.click().perform();
}

public static void actionsSendKeys(WebDriver driver,WebElement element, String input ) {
	Actions actions = new Actions(driver);
	actions.sendKeys(element, input).perform();

}


}
