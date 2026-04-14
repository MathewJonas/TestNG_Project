package swaglabs_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{
	
	
	@Test (priority = 0)
	public void LoginSuccessTest() {
		
		WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("secret_sauce");
		WebElement login = driver.findElement(By.xpath("//input[@name='login-button']"));
		login.click();
		
	}
	
	@Test (priority = 1)

	public void LoginFailureTest() {
		
		WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("secret_Jonas");
		WebElement login = driver.findElement(By.xpath("//input[@name='login-button']"));
		login.click();
		
	}
}
