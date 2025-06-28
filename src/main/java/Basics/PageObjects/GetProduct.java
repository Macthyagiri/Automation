package Basics.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basics.Common.CommonClass;

public class GetProduct extends CommonClass {

	WebDriver driver;
	public GetProduct(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".col-sm-10")
	List<WebElement> items;
 
	By by=By.cssSelector(".col-sm-10");
	public List<WebElement> getProductList() {
		waitVisibilityOfElement(by);
		return items;
			}
	public WebElement selectItem(String itemName) {
		WebElement product=getProductList().stream().filter(item -> item.findElement(By.cssSelector("b"))
				.getText().equalsIgnoreCase(itemName)).findFirst().orElse(null);
		return product;
	}
	public AddItemToCart addItemToCart(String itemName) {
		selectItem(itemName).findElement(By.cssSelector(".card-body button:last-of-type")).click();
		AddItemToCart additem=new AddItemToCart(driver);
		return additem;
	}
		
	
}
