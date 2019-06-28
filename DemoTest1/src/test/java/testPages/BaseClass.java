package testPages;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import utills.CommonMethods;

public class BaseClass extends CommonMethods {

	@BeforeSuite
	public void setup() throws IOException {
		Initialization();
	}
	/*@Test
	public void test() {
		System.out.println("its just for test");
	}*/
}
