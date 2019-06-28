package objectPages;

import java.io.IOException;

import org.openqa.selenium.By;

import utills.CommonMethods;

public class Dashboard extends CommonMethods

	{
	public Dashboard dbs;
	public void dashboardopen() throws IOException {
		
		custom_click(odriver, By.xpath(getlocvalue("dashboard")), 15);
	}

}
