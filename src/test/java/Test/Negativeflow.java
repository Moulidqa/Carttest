package Test;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Loginpage;
import PageObjects.ItemsAdding;
import resources.BaseClass;

public class Negativeflow extends BaseClass
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Negativeflow.class.getName());
	@BeforeTest
	public void Applaunch() throws IOException
	{
	
		driver = initializeDriver();
		log.info("Chrome is initialized successfully");
		driver.get(prop.getProperty("url"));
		log.info("Demoblaze application is launched successfully");
	}
	/*@Test()
	public void loginscenario() throws InterruptedException
	{
		
		Loginpage log = new Loginpage(driver);
		
		log.Loginclick().click();
		log.Username().sendKeys("Test90");
		log.Password().sendKeys("test90");
		log.Login().click();
		}
	
	@Test(dependsOnMethods = "loginscenario")*/
	@Test()
	public void AddingItemsintocart() throws InterruptedException
	{
		ItemsAdding add = new ItemsAdding(driver);
		Thread.sleep(2000);
		int itemsCount = driver.findElements(By.cssSelector("h4[class*='card']")).size();
		System.out.println(itemsCount);
		int e=0;
		for(int i=0;i<itemsCount;i++)
		{
			//List<WebElement> itemsList = driver.findElements(By.xpath("//h4/a"));
			add.addingItems().get(i).click();
			//add.addingItems.get(i).click();
			Thread.sleep(2000);
			add.addtoCart().click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			e++;
			if(e==2)
			{
				break;	
			}
			add.clickProductstore().click();
			Thread.sleep(2000);
			
		}
			add.gotoCart().click();
			Thread.sleep(2000);
			add.placeOrder().click();
			Loginpage log = new Loginpage(driver);
			Assert.assertEquals("Place order", log.LoginText().getText());
			
	}
	
	//NOTE:IF WE PROCEED WITH BELOW STEPS AGAIN IT WILL PURCHASE ORDER WITHOUT LOGIN TO USER AGAIN IT IS ANOTHER SECOND NEGATIVE FLOW,	
	//SO IM MAKE SURE THAT ADD ONE ASSERTION AND STOPPING SCRIPT HERE FOR CHECKING AND CONFIRMING OUR SCRIPTS.
	@Test(dataProvider="getData",dependsOnMethods = "AddingItemsintocart")
	public void Carddetails(String Name,String Country,String City,String creditcard,String Month,String Year) throws InterruptedException
	{
		
		driver.findElement(By.cssSelector("#name")).sendKeys(Name);
		driver.findElement(By.id("country")).sendKeys(Country);
		driver.findElement(By.id("city")).sendKeys(City);
		driver.findElement(By.id("card")).sendKeys(creditcard);
		driver.findElement(By.id("month")).sendKeys(Month);
		driver.findElement(By.id("year")).sendKeys(Year);
		driver.findElement(By.cssSelector("button[onclick*='purchase']")).click();
		String successtxt = driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).getText();
		System.out.println(successtxt);
		log.info(successtxt);
		if(successtxt.contains("Thank you"))
		{
			log.info("PURCHASED SUCCESSFULLY");
			
		}
		else
		{
			log.info("PURCHASED FAILED");
		}
Assert.assertEquals(successtxt, "Thank you for your purchase!");
}
	
	@AfterTest()
	public void closebrowser()
	{
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
