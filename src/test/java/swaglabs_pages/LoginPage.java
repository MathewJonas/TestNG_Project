package swaglabs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import swaglabs_test.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver;
	
	
	
 public void loginFunction(String userNameVal, String passwordVal) {
	 WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
		username.sendKeys(userNameVal);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordVal);
		WebElement login = driver.findElement(By.xpath("//input[@name='login-button']"));
		login.click();
	
}
}
