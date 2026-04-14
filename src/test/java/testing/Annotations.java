package testing;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeTest(alwaysRun = true)
	public void Test3()
	{
		System.out.println("Executed before test");
		
	}
	
	@AfterTest
	public void Test4() {
		System.out.println("Inside after test");	
		
	}

	
	@Test
	public void Test1() {
		System.out.println("Executed test case1");
		
	}
	@Test
	public void Test2() {
		System.out.println("Executed test case2");
		
	}

}
