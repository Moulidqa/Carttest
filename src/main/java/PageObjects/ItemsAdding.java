package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsAdding {

public WebDriver driver;

	
	public ItemsAdding(WebDriver driver)
	{
		this.driver= driver;
	}
	
	
	By addItems = By.xpath("//h4/a");
	By addingCart = By.cssSelector("a[onclick*='addToCart']");
	By goCart = By.id("cartur");
	By home = By.cssSelector("li[class='nav-item active']");
	By clickProdstore = By.cssSelector("a[class*='navbar']");
	By placeOrders = By.cssSelector("button[class*='btn btn-success']");
	By placeordertext = By.id("orderModalLabel");
	By totalPrice = By.id("totalp");
	


public List<WebElement> addingItems()
{
	return driver.findElements(addItems);
	
}

public WebElement addtoCart()
{
	return driver.findElement(addingCart);
	
}
public WebElement gotoCart()
{
	return driver.findElement(goCart);
	
}

public WebElement clickHome()
{
	return driver.findElement(home);
	
}
public WebElement clickProductstore()
{
	return driver.findElement(clickProdstore);
	
}
public WebElement placeOrder()
{
	return driver.findElement(placeOrders);
	
}
public WebElement totalPrice()
{
	return driver.findElement(totalPrice);
	
}
public WebElement Placeorderbox()
{
	return driver.findElement(placeordertext);
	
}
}

	

