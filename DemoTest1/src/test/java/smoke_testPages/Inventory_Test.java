package smoke_testPages;

import java.io.IOException;

import org.testng.annotations.Test;

import smoke_objectPages.Inventory;

public class Inventory_Test extends BaseClass{

	public Inventory inv;
	@Test
	public void inventorytest() throws IOException {
		inv=new Inventory(odriver);
		inv.inventory();
	}
}
