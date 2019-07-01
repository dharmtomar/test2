package smoke_testPages;

import java.io.IOException;

import org.testng.annotations.Test;

import smoke_objectPages.Report;

public class Report_Test extends BaseClass {

	public Report rpt;
	@Test
	public void report_Test() throws IOException {
		rpt=new Report(odriver);
		rpt.Reports();
	}
}
