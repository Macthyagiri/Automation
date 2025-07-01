package Basics.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basics.Common.CommonClass;

public class PageOrderHistory extends CommonClass {
	
	WebDriver driver;
	public PageOrderHistory(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderButton;
	
	@FindBy (xpath="//tr[@class='ng-star-inserted']//td[2]")
	List<WebElement> orderList;
	
	
	
	By locator=By.xpath("//button[@routerlink='/dashboard/myorders']");
	public WebElement goToOrders(String productName) {
		waitVisibilityOfElement(locator);
		orderButton.click();
		 WebElement productid=orderList.stream().filter(product->
		  product.getText().contains(productName)).findFirst().orElse(null);
		 return productid;
	}
	

}
