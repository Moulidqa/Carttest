package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;


public class BaseClass 
{

	public WebDriver driver;
	
	public 	Properties prop;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	public String excelFileName;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		prop = new Properties();
		
		FileInputStream file = new FileInputStream("C:\\Users\\Moulitrellis\\TestMavenProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(file);
		
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		log.info(browserName);
		log.info(url);
		
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Moulitrellis\\Downloads\\chromedriver88\\chromedriver.exe");
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--Headless");*/
			driver = new ChromeDriver();
			
		}
		
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Moulitrellis\\Desktop\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		return driver;
		
	}
	


	/*public void Takescreenshot(String result,WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("D://test//"+result+"Screenshot.png"));
		
	}*/
	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[1][6];
		//0th row
		data[0][0]="Mouli";
		//1st row
		data[0][1]="India";
		data[0][2]="Bangalore";
		data[0][3]= "4811 1111 1111 1114";
		data[0][4]= "Dec-24";
		data[0][5]= "2028";
		
		return data;			
	}
	
	}
	

