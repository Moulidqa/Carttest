

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PIM {

public WebDriver driver;

	
	public PIM(WebDriver driver)
	{
		this.driver= driver;
	}
	
	
	By pim = By.cssSelector("li[class*='level1 pim']");
	By addemp = By.cssSelector("a[href*='addEmployee']");
	
	


public WebElement PIM()
{
	return driver.findElement(pim);
	
}

public WebElement Addemployee()
{
	return driver.findElement(addemp);
	
}

}

	

