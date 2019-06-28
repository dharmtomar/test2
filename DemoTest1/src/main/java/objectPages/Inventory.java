package objectPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utills.CommonMethods;

public class Inventory extends CommonMethods {

	public WebDriver odriver;
	public Inventory(WebDriver odriver) {
		this.odriver=odriver;
	}
	public void inventory() throws IOException {
		custom_click(odriver, By.xpath(getlocvalue("inventory")), 15);
	}
}
