package objectPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utills.CommonMethods;

public class Report extends CommonMethods {

	public WebDriver odriver;
	public Report(WebDriver odriver) {
		this.odriver=odriver;
	}
	public void Reports()throws IOException {
		custom_click(odriver, By.xpath(getlocvalue("report")), 15);
	}
}
