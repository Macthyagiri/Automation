package Basics.Shopping;

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

import Basics.PageObjects.LandinPage;



public class Login {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client");
		
		
		driver.findElement(By.id("userEmail")).sendKeys("testtestt6809@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@1034");
		driver.findElement(By.id("login")).click();
	
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-sm-10")));
		//driver.findElement(By.xpath("//div[@class='card-body']/h5/b[contains(text(), 'ZARA COAT 3')]")).click();
		List<WebElement> items=driver.findElements(By.cssSelector(".col-sm-10"));
		WebElement product=items.stream().filter(item -> item.findElement(By.cssSelector("b"))
				.getText().equalsIgnoreCase("ADIDAS ORIGINAL")).findFirst().orElse(null);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
		  "#toast-container")));
		 // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		  driver.findElement(By.cssSelector("[routerlink*=\"cart\"]")).click();
		  
		  List<WebElement> cartItesms=driver.findElements(By.xpath("(//div[@class='cartSection']/child::h3)"));
		  
			/*
			 * Boolean match=cartItesms.stream().anyMatch(item->item.getText().
			 * equalsIgnoreCase("ZARA COAT 3")); Assert.assertTrue(match);
			 */
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='totalRow']/button")));
			driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
			/* driver.findElement(By.xpath("//input[@placeholder='Select Country']")).
			 * sendKeys("India");
			 * driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
			 */
		 
		 Actions a=new Actions(driver);
		 a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		 driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
		 Thread.sleep(10000);
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(1081,627)", "");
		 driver.findElement(By.xpath("//div[@class='actions']/a")).click();
		 String orderId=driver.findElement(By.xpath("//tr[@class='ng-star-inserted']")).getText();
		 System.out.println(orderId);
		
		
		
		
	}

}
