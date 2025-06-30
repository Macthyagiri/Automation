package Basics.Shopping;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basics.Common.BaseTest;
import Basics.Common.CommonClass;
import Basics.PageObjects.AddItemToCart;
import Basics.PageObjects.GetProduct;
import Basics.PageObjects.LandinPage;
import Basics.TestComponents.Retry;
import Basics.PageObjects.CartItems;
import org.testng.ITestResult;


public class LoginValidationTest extends BaseTest{

	

	/*
	 * public AddToCart(WebDriver driver) { super(driver); // TODO Auto-generated
	 * constructor stub }
	 */
    @Test(retryAnalyzer=Retry.class)
	public void loginValidationTest() throws IOException {
		String userid="",password="Test@1034";
		GetProduct getProdustList=landinPage.loginApplication(userid, password);
		String emailR=driver.findElement(By.xpath("//div[@class='invalid-feedback']/child::div")).getText();
		AssertJUnit.assertEquals(emailR, "Email is required");
		}
    
    
}
