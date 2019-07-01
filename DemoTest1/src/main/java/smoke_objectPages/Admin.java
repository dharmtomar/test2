package smoke_objectPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utills.CommonMethods;

public class Admin extends CommonMethods{

	public WebDriver odriver;
	public Admin(WebDriver odriver) {
		this.odriver=odriver;
	}
	public void admin() throws IOException {
		custom_click(odriver, By.xpath(getlocvalue("admin")), 15);
		System.out.println("Admin section");
	}
}
