package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GooglePageSearchTest {
	WebDriver driver;
	
//	@BeforeMethod
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	}
//  @Test(priority=1)
	@Test(alwaysRun = true, dependsOnMethods ={"seleniumSearchTest"})
  public void javaSearchTest() throws InterruptedException {
	  driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();
		Thread.sleep(2000);
		Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());
  }
//  @Test(enabled = false)
//  @Test(priority=2)
  @Test
  public void seleniumSearchTest() throws InterruptedException {
	  driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium Tutorial");
		searchBox.submit();
		Thread.sleep(2000);
		Assert.assertEquals("Selenium Tutorial - Google Search Page", driver.getTitle());
  }
  
  @Test
  public void appiumSearchTest() {
	  driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Appium Tutorial");
		searchBox.submit();
		Assert.assertEquals("Appium Tutorial - Google Search", driver.getTitle());
  }
  

  public void cucumberSearchTest() {
	  driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Cucumber Tutorial");
		searchBox.submit();
		Assert.assertEquals("Cucumber Tutorial - Google Search", driver.getTitle());
  }
  
  
  

//    @AfterMethod
  @AfterTest
  public void tearDown() {
	  driver.close();
  }
  
  
}
