package Basics.Shopping;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basics.Common.BaseTest;
import Basics.PageObjects.LandinPage;
import Basics.PageObjects.PageOrderHistory;

public class OrderHistory extends BaseTest {

	

	@Test(dataProvider="getData")
	public void getOrderHistory(HashMap<String, String> input) throws InterruptedException, IOException {
	
		//String productName="ADIDAS ORIGINAL";
		landinPage.loginApplication(input.get("email"),input.get("password"));
		PageOrderHistory orderList=new PageOrderHistory(driver);
		WebElement productid=orderList.goToOrders(input.get("product"));	
		String orderid=productid.findElement(By.xpath("//tbody/tr/th")).getText();
		Assert.assertEquals(orderid,input.get("orderid"));

	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJsonData("D:\\CI-CD\\SeleniumDemo\\src\\test\\java\\Basics\\data\\orderDetails.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}

			/*
			 * List<WebElement> listOfProducts =
			 * driver.findElements(By.xpath("//tbody/tr/td[2]"));
			 * System.out.println(listOfProducts.size()); if (listOfProducts.size() == 0) {
			 * System.out.println(" No products found — Check your XPath or wait time."); }
			 * else { for (int i = 0; i < listOfProducts.size(); i++) { String s =
			 * listOfProducts.get(i).getText(); System.out.println("Product Name: " + s); }
			 * }
			 */
			/*
			 * List<WebElement> lp =
			 * driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//th"));
			 * Thread.sleep(2000); for (WebElement web : lp) {
			 * System.out.println(web.getText()); }
			 * 
			 * Thread.sleep(2000); List<WebElement> nam =
			 * driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[2]"));
			 * Thread.sleep(2000); for (WebElement names : nam) {
			 * System.out.println(names.getText()); }
			 * 
			 * 
			 * Map<String, String> mp = new HashMap<>();
			 * 
			 * for (int i=0; i<lp.size() && i<nam.size(); i++) { String key =
			 * lp.get(i).getText().trim(); String value = nam.get(i).getText().trim();
			 * //System.out.println("key" + key+ ", value" + value); mp.put(key, value); }
			 * 
			 * for(Map.Entry<String, String> entry :mp.entrySet() ) {
			 * System.out.println("order "+" " + entry.getKey() + "prod "+" " +
			 * entry.getValue()); }
			 */
			
			//tr[@class='ng-star-inserted']//th
		
	

}
