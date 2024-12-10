package testScripts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.devtools.v124.network.model.Headers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeMethod
	public void setup(){
		driver = new ChromeDriver();
		
		devTools = driver.getDevTools();
		devTools.createSession(driver.getWindowHandle());
	}
	
	@Test
	public void deviceModeTest() {
		  Map deviceMetrics = new HashMap() {{
			  put("width", 600);
			  put("height", 900);
			  put("deviceScaleFactor", 50);
			  put("mobile", true);
		  }};
		  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		  driver.get("https://www.selenium.dev/");
	  }
	
	 @Test
	  public void geoLocationTest() {
			 
		  Map deviceMetrics = new HashMap() {{
				put("latitude", 27.664827);
				put("longitude", -81.515755);
				put("accuracy", 100);
			}};
		  driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceMetrics);
		 driver.get("https://oldnavy.gap.com/stores");
	  }
	 
	
}
