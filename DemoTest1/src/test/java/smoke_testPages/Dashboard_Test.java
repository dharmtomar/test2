package smoke_testPages;

import java.io.IOException;

import org.testng.annotations.Test;

import smoke_objectPages.Dashboard;

public class Dashboard_Test extends BaseClass{

	public Dashboard dsb;
	@Test
	public void clickdashboard() throws IOException{
	dsb=new Dashboard();
	dsb.dashboardopen();
	

}
}
