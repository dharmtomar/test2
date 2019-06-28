package objectPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utills.CommonMethods;

public class Sales extends CommonMethods {

	public WebDriver odriver;
	public Sales(WebDriver odriver) {
		this.odriver=odriver;
	}
	public void sales() throws IOException {
		custom_click(odriver, By.xpath(getlocvalue("sales")), 15);
	}
}
