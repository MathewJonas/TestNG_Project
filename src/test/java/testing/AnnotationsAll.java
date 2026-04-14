package testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsAll{
		
		
		@Test(enabled = false)

		public void Test1() {
			System.out.println("Executed test case1");
		}
		
		@Test
		public void Test2() {
			System.out.println("Executed test case2");
			
		}
		

	}



