package testing;

import org.testng.annotations.Test;

public class Annotations2 extends BaseClass{
	@Test(groups= {"sanity"})


	public void test3() {
		System.out.println("Executed test case3");
	}
	@Test
	public void test4() {
		
	System.out.println("Executed test case4");
		
	}

}
