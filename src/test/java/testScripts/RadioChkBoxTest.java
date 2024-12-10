package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioChkBoxTest {
  @Test
  public void selectRadioTest() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
//		driver.findElement(By.id("gender-radio-1")).click();
//		Thread.sleep(10000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		boolean isSel = driver.findElement(
				By.xpath("(//input[@type='checkbox'])[2]")).isSelected();
		if(isSel) {
			driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		}
		
		
  }
}
