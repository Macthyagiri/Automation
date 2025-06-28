package Basics.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basics.Common.CommonClass;

public class LandinPage extends CommonClass {
	
	  WebDriver driver; 
	  public LandinPage(WebDriver driver) { 
		  super(driver);
	      this.driver=driver; 
	      PageFactory.initElements(driver, this); 
	      }
	  
	  
	  //WebElement userId=driver.findElement(By.id("userEmail"));
	  
	  @FindBy(id="userEmail") 
	  WebElement userId;
	  
	  @FindBy(id="userPassword") 
	  WebElement password1;
	  
	  @FindBy(id="login") 
	  WebElement Logsubmit;
	  public void goTo() {
			driver.get("https://rahulshettyacademy.com/client");
		}
	  
	  public GetProduct loginApplication(String userMail,String password) {
	  
	  userId.sendKeys(userMail); 
	  password1.sendKeys(password); 
	  Logsubmit.click(); 
	  GetProduct getProdustList=new GetProduct(driver);
	  return getProdustList;
}
	
	
	
	
}
