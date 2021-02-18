package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

public WebDriver driver;

	
	public Loginpage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	
	By loginClick = By.cssSelector("#login2");
	By uname = By.xpath("//input[@id='loginusername']");
	By pswd = By.id("loginpassword");
	By loginto = By.cssSelector("button[onclick*='log']");
	By logintext = By.id("logInModalLabel");
	
	
	


public WebElement Loginclick()
{
	return driver.findElement(loginClick);
	
}

public WebElement Username()
{
	return driver.findElement(uname);
	
}

public WebElement Password()
{
	return driver.findElement(pswd);
	
}

public WebElement Login()
{
	return driver.findElement(loginto);
	
}

public WebElement LoginText()
{
	return driver.findElement(logintext);
	
}
}

	

