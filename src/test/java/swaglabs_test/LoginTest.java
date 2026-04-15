package swaglabs_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import swaglabs_pages.LoginPage;

public class LoginTest extends BaseClass {

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
}
