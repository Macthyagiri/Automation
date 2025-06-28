package Basics.Shopping;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import Basics.PageObjects.CartItems;



public class SubmitOrderTest extends BaseTest{

	

	/*
	 * public AddToCart(WebDriver driver) { super(driver); // TODO Auto-generated
	 * constructor stub }
	 */
    @Test(dataProvider="getData",groups={"purchase"})
	public void flipCart(HashMap< String, String > input) throws IOException {
		
		String itemName2="";
		String country="India";
       
		
		
		GetProduct getProdustList=landinPage.loginApplication(input.get("email"), input.get("password"));
		AddItemToCart additem=getProdustList.addItemToCart(input.get("product"));
		CartItems cartitems=additem.addItem();
	   Boolean match=cartitems.matchingItems(input.get("product"));
	    Assert.assertTrue(match);
	    cartitems.placeorder();
		cartitems.cartItemsAdded(country);
			/* driver.findElement(By.xpath("//input[@placeholder='Select Country']")).
			 * sendKeys("India");
			 * driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
			 */
//		 JavascriptExecutor js=(JavascriptExecutor) driver;
//		 js.executeScript("window.scrollBy(0,350)", "");
		// Thread.sleep(5000);
		     WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			 // wait.until(ExpectedConditions.elementToBeClickable(By.
			 // xpath("//a[contains(text(),'Place Order ')]"))).click();
			//  wait.until(ExpectedConditions.elementToBeClickable(By.
			 // xpath("//a[contains(text(),'Place Order ')]"))).click();
			  //driver.findElement(By.xpath("//a[contains(text(),'Place Order ')]")).click( ); 
			//  String orderId=driver.findElement(By.xpath("//tr[@class='ng-star-inserted']")).
			//  getText(); System.out.println(orderId);
		
	}
    @DataProvider 
    public Object[][] getData() throws IOException {
    	
    	List<HashMap<String, String>> data=getJsonData(System.getProperty("user.dir")+"//src//test//java//Basics//data//purchase.json");
    	
		/*
		 * HashMap<String,String> map1=new HashMap<String,String>(); map1.put("email",
		 * "testtestt6809@gmail.com"); map1.put("password", "Test@1034");
		 * map1.put("product", "ZARA COAT 3");
		 */
    	return new Object[][] {{data.get(0)},{data.get(1)}};
   	// return new Object[][] {{"testtestt6809@gmail.com","Test@1034","ZARA COAT 3"},{"testtestt6809@gmail.com","Test@1034","ADIDAS ORIGINAL"}};
    }
    

}
