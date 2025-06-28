package Basics.Common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonClass {
	
	WebDriver driver;
	public CommonClass(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void waitVisibilityOfElement(By locator) {
		 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public void waitInvisibilityOfLocator(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

}
