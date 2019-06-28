package utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utills.CommonMethods;

public class CommonMethods {

	static Properties locators;
	static Properties testdata;
	static File configfile;
	static FileInputStream filestream;
	public static WebDriver odriver;
	
	public void Initialization() throws IOException
	{
		selectbrowser (getdatavalue("Browser"));
		odriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		odriver.manage().window().maximize();
		odriver.get(getdatavalue("BaseURL"));
		//selectURL(getdatavalue("Baseurl"));
		loginEZBOT();
		//verifytitle(getdatavalue("titleval"));
		//checktitleHomepage();
	}
	
	public void selectbrowser(String browsername) {
 		if (browsername.equalsIgnoreCase("chrome")) 
 		{
 			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
 			odriver = new ChromeDriver();
 		}   else if(browsername.equals("firefox"))
 		{
 			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "/Drivers/firefox.exe");
 			odriver = new FirefoxDriver();
 		}
 	}
	
	public boolean checktitleHomepage()throws IOException{
		boolean boolval=element_exist_check(By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/span"),odriver);
		if(boolval==true) {
			Assert.assertTrue(true, "title found");
			return true;
		}
		else{
			Assert.assertTrue(false, "title not found");
			return false;
		}
	}
	public void verifytitle(String webtitle) {
		String actual = odriver.getTitle();
		String expected = webtitle;
		Assert.assertEquals(actual, expected);
	}
	public void closeBrowser() {
		odriver.close();
	}
	
	public void loginEZBOT() throws IOException {
		odriver.findElement(By.name(getlocvalue("loginid"))).sendKeys(getdatavalue("LoginID"));
		odriver.findElement(By.name(getlocvalue("password"))).sendKeys(getdatavalue("Password"));
		odriver.findElement(By.xpath(getlocvalue("Submit"))).click();
		odriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void loadproperties(String datatype)throws IOException{
		if(datatype.equalsIgnoreCase("Loc")) {
			locators=new Properties();
			configfile=new File(System.getProperty("user.dir")+"/src/main/java/config/locators.properties");
			//configfile=new File("configurations/Locators.properties");
			filestream=new FileInputStream(configfile);
			locators.load(filestream);
		}
		else if(datatype.equalsIgnoreCase("Data")){
			testdata=new Properties();
			configfile=new File(System.getProperty("user.dir")+"/src/main/java/config/testdata.properties");
			filestream=new FileInputStream(configfile);
			testdata.load(filestream);
		}
			
			
	}
	//this method is for passing the key and getting locator value
			public static String getlocvalue(String key) throws IOException {
				loadproperties("Loc");
				String path=locators.getProperty(key);
				return path;	
			}
		//this method is for passing the key and getting test data value
			public static String getdatavalue(String key) throws IOException {
				loadproperties("Data");
				String path=testdata.getProperty(key);
				return path;	
			}
	public boolean element_exist_check(By by,WebDriver odriver) {
		Integer sizeofele=odriver.findElements(by).size();
		if(sizeofele==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void custom_click(WebDriver odriver,By by,int wait) {
		explicit_wait(odriver,by,wait);
		odriver.findElement(by).click();
	}
	public static void explicit_wait(WebDriver odriver,By by,int wait) {
		WebDriverWait wait2=new WebDriverWait(odriver, wait);
		wait2.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public static void enter_text(WebDriver odriver,By by,String text,int wait) {
		explicit_wait(odriver, by, wait);
		odriver.findElement(by).sendKeys(text);
	}
	public void LogoutERP() throws IOException 
	{
 		 odriver.findElement(By.xpath(getlocvalue("Logoutbutton"))).click();
 		 odriver.findElement(By.xpath(getlocvalue("Logoutclick"))).click();
	 	 odriver.manage().timeouts().implicitlyWait(35,TimeUnit.SECONDS);
	 	odriver.close();
	}
	
	public void takescreenshot() throws IOException {
		File srcfile=new File("Screenshots/"+timestamp()+".png");
		File screen=((TakesScreenshot) odriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, srcfile);
	}
	public static String timestamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
}
