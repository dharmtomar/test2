package testPages;

import java.io.IOException;

import org.testng.annotations.Test;

import objectPages.Admin;

public class Admin_Test extends BaseClass{

	public Admin adm;
	@Test
	public void adminclick() throws IOException {
		adm=new Admin(odriver);
		adm.admin();
		
	}
}
