package Basics.Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Basics.PageObjects.LandinPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandinPage landinPage;
	public WebDriver browse() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("D://Coding//SeleniumDemo//src//main//java//Basics//PageObjects//Resource//GetProperties.properties");
		prop.load(file);
		String browserName = System.getProperty("browser") != null
		        ? System.getProperty("browser").toLowerCase()
		        : prop.getProperty("browser").toLowerCase();

		    System.out.println("Browser selected: " + browserName);

		    if (browserName.contains("chrome")) {
		        ChromeOptions options = new ChromeOptions();
		        WebDriverManager.chromedriver().setup();

		        if (browserName.contains("headless")) {
		            options.addArguments("headless");
		        }

		        driver = new ChromeDriver(options);
		        driver.manage().window().setSize(new Dimension(1440, 900));
		    } else if (browserName.contains("edge")) {
		        WebDriverManager.edgedriver().setup();
		        driver = new EdgeDriver();
		    } else {
		        throw new RuntimeException("Unsupported browser: " + browserName);
		    }

		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    return driver;
		}
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		//read json to string
		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		
		//String to HashMap dependency JackSon Databin
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new 
				TypeReference<List<HashMap<String,String>>>(){});
			return data;
		}
    public void getScreenShot(String testcaseName,WebDriver driver) throws IOException {
	  TakesScreenshot ts=(TakesScreenshot) driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  File file=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
	  FileUtils.copyFile(source, file);
}

	@BeforeMethod(alwaysRun=true)
	public LandinPage launchApp() throws IOException {
		driver=browse();
		landinPage=new LandinPage(driver);
		landinPage.goTo();
		return landinPage; 
	}
	@AfterMethod(alwaysRun=true)
	public void closeDriver() {
		//driver.findElement(By.cssSelector(".btnn")).click();
		driver.close();
	}
}
