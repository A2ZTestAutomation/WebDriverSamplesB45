package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WinPopupTest {
  @Test
  public void newWindowTest() {
	  WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stqatools.com/demo/Windows.php");
		String parentWin = driver.getWindowHandle();
		System.out.println("Parent Win : " + parentWin);
		
		WebElement tabBtn = driver.findElement(By.xpath("//button[contains(text(), 'new Tab')]"));
		tabBtn.click();
		System.out.println("Page Title : " + driver.getTitle());
		Set<String> tabs = driver.getWindowHandles();
		System.out.println("Number of windows ... " + tabs.size());
		
		for(String child:tabs) {
			System.out.println("Windows ... " + child);
			if(!child.equalsIgnoreCase(parentWin)) {
				driver.switchTo().window(child);
				System.out.println("Child Win title ... "+driver.getTitle());
			}
		}
		driver.close();
		driver.switchTo().window(parentWin);
		System.out.println("Parent Page Title : " + driver.getTitle());
		driver.findElement(By.xpath("//button[contains(text(), 'new Window')]")).click();
		Set<String> wins = driver.getWindowHandles();
		System.out.println("Number of windows ... " + wins.size());
		for(String win:wins) {
			System.out.println("Windows ... " + win);
			if(!win.equalsIgnoreCase(parentWin)) {
				driver.switchTo().window(win);
				System.out.println(" Win title ... "+driver.getTitle());
			}
		}
//		driver.close();
		driver.quit();
		
  }
}
