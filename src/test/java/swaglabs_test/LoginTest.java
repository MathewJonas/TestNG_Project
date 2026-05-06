package swaglabs_test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import swaglabs_pages.LoginPage;

public class LoginTest extends BaseClass {

	// int rowNum = 1;

	@Test(priority = 0)
	public void LoginSuccessTest() {
		LoginPage lp = new LoginPage();
		lp.loginFunction("problem_user", "secret_sauce");

		WebElement productTitle = driver.findElement(By.xpath("//span[@class='title']"));
		Assert.assertEquals(productTitle.getText(), "Products");

	}

	@Test(priority = 1)

	public void LoginFailureTest() {
		LoginPage lp = new LoginPage();
		lp.loginFunction("problem_user", "secret_Jonas");

		WebElement errorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(errorMsg.getText(),
				"Epic sadface: Username and password do not match any user in this service");

	}

	@Test
	public void lockedOut() {
		LoginPage lp = new LoginPage();
		lp.loginFunction("locked_out_user", "secret_sauce");

		WebElement locked = driver
				.findElement(By.xpath("//*[text()='Epic sadface: Sorry, this user has been locked out.']"));
		Assert.assertEquals(locked.getText(), "Epic sadface: Sorry, this user has been locked out.");
	}
		
		@Test
		public void LoginFailurefromExcel() {
			String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
			String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
			
			LoginPage lp = new LoginPage();
			lp.loginFunction(UserNameVal, PasswordVal);
			
			WebElement ErrorMsg = driver.findElement(By.xpath("//div[@id='error_msg']"));
			Assert.assertEquals(ErrorMsg.getText(), "Epic sadface: Username and password do not match any user in this service");
			
			//sheet.getRow(rowNum).createCell(2).setCellValue("DONE");
	}
		@Test
		public void LoginFailureTestFromProperties() throws IOException {

			FileReader reader = new FileReader("data.properties");
			Properties prop = new Properties();
			prop.load(reader);
			
			String UserNameVal = prop.getProperty("username");
			String PasswordVal = prop.getProperty("password");

			LoginPage lp = new LoginPage();
			lp.loginFunction(UserNameVal, PasswordVal);

			WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
			Assert.assertEquals(ErrorMsg.getText(),"Epic sadface: Username and password do not match any user in this service");

			//sheet.getRow(1).createCell(2).setCellValue("Completed");

		}

}
