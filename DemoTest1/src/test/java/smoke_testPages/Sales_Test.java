package smoke_testPages;

import java.io.IOException;

import org.testng.annotations.Test;

import smoke_objectPages.Sales;

public class Sales_Test extends BaseClass {

	public Sales sl;
	@Test
	public void salesclick() throws IOException {
		sl=new Sales(odriver);
		sl.sales();
	}
}
