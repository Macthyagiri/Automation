package Basics.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basics.Common.CommonClass;

public class AddItemToCart extends CommonClass {
	
	WebDriver driver;
	
	public AddItemToCart(WebDriver driver) {
		
		super( driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css="[routerlink*='cart']")
	WebElement clickOnCart;
	
	By locator=By.cssSelector("#toast-container");
	
	public CartItems addItem() {
		waitInvisibilityOfLocator(locator);
		clickOnCart.click();
		CartItems cartitems=new CartItems(driver);
		return cartitems;
	}

}
