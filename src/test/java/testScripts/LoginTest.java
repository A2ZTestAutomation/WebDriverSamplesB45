package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginTest {
	WebDriver driver;
	Properties prop;

	@BeforeTest
	public void readProperty() throws IOException {
		String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop = new Properties();
		prop.load(fin);

	}

	@BeforeMethod
	public void setup() {

		String strBrowser = prop.getProperty("browser");
		if (strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "loginData")
	public void validLoginTest(String strUser, String strPwd) {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(readFromExcel("Username"))).sendKeys(strUser);
		driver.findElement(By.name(readFromExcel("password"))).sendKeys(strPwd);
		driver.findElement(By.cssSelector(readFromExcel("loginBtn"))).click();
		boolean isValidUser = driver.findElement(By.cssSelector(readFromExcel("successMsg"))).isDisplayed();
		Assert.assertTrue(isValidUser);

	}
	
	//user1 - name, pwd
	//user2 - name, pwd
	//user3 - name, pwd
	
	
	@DataProvider(name="loginData")
	public Object[][] getData() throws CsvValidationException, IOException{
		
		 String path = System.getProperty("user.dir") +
				  "//src//test//resources//testData//loginData.csv";
		 CSVReader reader = null;
		  try {
			reader = new CSVReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String cols[];
		  ArrayList<Object> dataList = new ArrayList<Object>();
		  while ((cols =reader.readNext()) != null){
			  System.out.println("Length of Cols .." +cols.length);
			  
			  Object[] record = {cols[0], cols[1]};
			  dataList.add(record);
		  }
		  return dataList.toArray(new Object[dataList.size()][]);
	}

	public String readFromExcel(String objName) {
		String objPath = "";
		String path = System.getProperty("user.dir") + "//src//test//resources//testData//LoginDataFile.xlsx";
		// HSSF.... -> .xls
		// XSSF.... -> .xlsx
		FileInputStream fin;
		XSSFWorkbook workbook = null;
		try {
			fin = new FileInputStream(path);
			workbook = new XSSFWorkbook(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet loginSheet = workbook.getSheet("loginPage");
		int numRows = loginSheet.getLastRowNum();
		System.out.println("Num of rows...." + numRows);
		for (int i = 1; i <= numRows; i++) {
			XSSFRow row = loginSheet.getRow(i);
			if (row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
				objPath = row.getCell(1).getStringCellValue();
			}
		}

		return objPath;
	}

}
