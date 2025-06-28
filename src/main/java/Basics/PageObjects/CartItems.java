package Basics.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import Basics.Common.CommonClass;

public class CartItems extends CommonClass {
	
	     WebDriver driver; 
	    public CartItems(WebDriver driver) { 
		  super(driver);
	      this.driver=driver; 
	      PageFactory.initElements(driver, this); 
	      }
	  
	    By by=By.cssSelector(".ta-results");
	    By by1=By.xpath("//li[@class='totalRow']/button");
	    
	    @FindBy(xpath="//div[@class='cartSection']/child::h3")
	    List<WebElement> cItems;
	    
	    @FindBy(xpath="//input[@placeholder='Select Country']")
	    WebElement selectCountry;
	    
	    @FindBy(css=".ta-item:nth-child(3)")
	    WebElement getCountry;
	    
	    @FindBy(xpath="//li[@class='totalRow']/button")
	    WebElement placeOrd;
	    
	    public Boolean matchingItems(String itemName) {
	    	 List<WebElement> cartItesms=cItems;
	    	 Boolean match=cartItesms.stream().anyMatch(item->item.getText().
	    			  equalsIgnoreCase(itemName)); 
	    	 return match;
	    }
	    public void cartItemsAdded(String country) {
	    
	     Actions a=new Actions(driver);
		 a.sendKeys(selectCountry, country).build().perform();
		 waitVisibilityOfElement(by);
		 getCountry.click();
	    }
	    public void placeorder() {
	    	waitVisibilityOfElement(by1);
	    	placeOrd.click();
	    }
	   
	    
	   
		 
		
}
