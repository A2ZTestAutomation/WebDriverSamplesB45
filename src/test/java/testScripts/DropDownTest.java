package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownTest {
  @Test
  public void selectOptions() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(" https://www.stqatools.com/demo/Multiselect.php");
			Thread.sleep(2000);
			
			Select dateSel = new Select(driver.findElement(
					By.cssSelector("select.date_s")));
			dateSel.selectByVisibleText("1983");
			
			Select nameSel = new Select(driver.findElement(
					By.cssSelector("select.name_s")));
			nameSel.selectByIndex(0);
			nameSel.selectByValue("Jonas");
			nameSel.selectByVisibleText("Gustaf");
			nameSel.getAllSelectedOptions();
			
	 
		  
  }
}
