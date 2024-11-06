package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActionsTest {
	@Test
	public void mouseActionsTest() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
//		options.setAcceptInsecureCerts(true);

//		options.addArguments("--blink-settings=imagesEnabled=false");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		Actions actions = new Actions(driver);

		driver.get("https://demo.opencart.com/");

		Thread.sleep(2000);
		WebElement srcBox = driver.findElement(By.name("search"));

//		actions.contextClick(srcBox).perform();

		WebElement menu = driver.findElement(
						By.xpath("//ul[@class='nav navbar-nav']//descendant::a[text()='Components']")); 
		actions.moveToElement(menu).perform();
		
//		
		//Method 1
//		  WebElement menuitem = driver.findElement(
//		  By.xpath("//ul[@class='list-unstyled']//a[contains(text(), 'Monitors (2)')]"));
//		  
////		  actions.click(menuitem).perform();
//		  
//		  actions.moveToElement(menu).click(menuitem).build().perform();
		  
		//Method 2
		//To get all menuitems under Components 
//		//ul.nav.navbar-nav > li:nth-child(3) ul.list-unstyled > li
		
		List<WebElement> items =  driver.findElements(
				By.cssSelector("ul.nav.navbar-nav > li:nth-child(3) ul.list-unstyled > li"));
		
		int numItems = items.size();
		for(int i = 0; i < items.size(); i++ ) {
			WebElement item = items.get(i);
			if(item.getText().equalsIgnoreCase("Monitors (2)")) {
				item.click();
				break;
			}
		}
		  
//		  actions.scrollToElement(
//				  driver.findElement(By.xpath("//a[contains(text(), 'Terms & Conditions')]")))
//		  			.perform();
		 
	}
}
