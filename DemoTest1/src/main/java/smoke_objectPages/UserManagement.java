package smoke_objectPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utills.CommonMethods;

public class UserManagement extends CommonMethods{

	public WebDriver odriver;
	public UserManagement(WebDriver odriver) {
		this.odriver=odriver;
	}
	public void usermgt()throws IOException {
		custom_click(odriver, By.xpath(getlocvalue("usermgt")), 15);
	}
}
