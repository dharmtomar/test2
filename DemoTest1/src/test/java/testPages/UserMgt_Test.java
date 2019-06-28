package testPages;

import java.io.IOException;

import org.testng.annotations.Test;

import objectPages.UserManagement;

public class UserMgt_Test extends BaseClass {

	public UserManagement umt;
	@Test
	public void usermgt_Test() throws IOException {
		umt=new UserManagement(odriver);
		umt.usermgt();
				
	}
}
