package Basics.Shopping;

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
import org.testng.annotations.Test;

import Basics.Common.BaseTest;
import Basics.Common.CommonClass;
import Basics.PageObjects.AddItemToCart;
import Basics.PageObjects.GetProduct;
import Basics.PageObjects.LandinPage;
import Basics.PageObjects.CartItems;



public class AddToCartValidation extends BaseTest{

	

	/*
	 * public AddToCart(WebDriver driver) { super(driver); // TODO Auto-generated
	 * constructor stub }
	 */
    @Test
	public void addToCartValidation() throws IOException {
		String userid="testtestt6809@gmail.com",password="Test@1034";
		String itemName1="ZARA COAT 3";
		String itemName2="ADIDAS ORIGINAL";
		String country="India";
       
	    GetProduct getProdustList=landinPage.loginApplication(userid, password);
		AddItemToCart additem=getProdustList.addItemToCart(itemName1);
		CartItems cartitems=additem.addItem();
        Boolean match=cartitems.matchingItems(itemName1);
	    Assert.assertTrue(match);	
	}

}
