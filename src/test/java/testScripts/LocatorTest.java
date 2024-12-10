package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LocatorTest {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
  @Test
  public void loginTest() {
	  	driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button.radius")).click();
	 
  }
}
