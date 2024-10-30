package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorTest {
	WebDriver driver;
  @Test
  public void loginTest() {
	  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/login");
//		driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		
		
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//		driver.findElement(By.className("radius")).click();
//		driver.findElement(By.className("fa fa-2x fa-sign-in")).click();
//		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		driver.findElement(By.cssSelector("button.radius")).click();
		
//		driver.findElement(By.linkText("Elemental Selenium")).click();
		driver.findElement(By.partialLinkText("Elemental")).click();
		
		
	 
  }
}
