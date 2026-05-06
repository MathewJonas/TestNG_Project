package swaglabs_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;

	XSSFWorkbook wbook;
	XSSFSheet sheet;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@BeforeTest
	public void SetUpExcel() throws IOException {

		FileInputStream fis = new FileInputStream("DataTest.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("DataTest");

	}

	@AfterTest
	public void CloseExcel() throws IOException {
		FileOutputStream outputStream = new FileOutputStream("output.xlsx");
		wbook.write(outputStream);
		wbook.close();
		outputStream.close();

	}

}

