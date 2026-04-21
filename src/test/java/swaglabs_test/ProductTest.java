package swaglabs_test;

import org.testng.annotations.Test;

import swaglabs_pages.LoginPage;
import swaglabs_pages.ProductPages;

public class ProductTest extends BaseClass{
	
	@Test
	public void AddtoCartTest() {
		
		LoginPage lp = new LoginPage();
		lp.loginFunction("standard_user", "secret_sauce");
		
		ProductPages pp = new ProductPages();
		pp.AddToCart("Sauce Labs Bolt T-Shirt");
		
	}
	
}
