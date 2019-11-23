package tests;

import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadPropertise;
import helper.Helper;

public class TestBaseGrid {

	// funcation related to saucelab

	public static  final String Username = LoadPropertise.Sauceuser.getProperty("Username");
	public static final  String Accesskey = LoadPropertise.Sauceuser.getProperty("Accesskey");
	public static final String SourceUrl = "https://" + Username+":"+Accesskey
			+LoadPropertise.Sauceuser.getProperty("SauceLabUrl");


	public static String BaseURL ="https://demo.nopcommerce.com/";
	protected ThreadLocal<RemoteWebDriver> driverGrid = null;

	@BeforeClass
	@Parameters(value = { "browserName" })
	public void startGrid(@Optional("chrome") String browser) throws Exception {



		driverGrid = new ThreadLocal<>();

		DesiredCapabilities caps = new DesiredCapabilities();
		System.out.println("Test::" + browser);
		caps.setCapability("browserName", browser);
		
		//selenium grid local
		//driverGrid.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		
		//selnium run with saucelab
		driverGrid.set(new RemoteWebDriver(new URL(SourceUrl), caps));
		getdriver().navigate().to(BaseURL);
	}

	public WebDriver getdriver()
	{
		return driverGrid.get();

	}

	//take screenshot when test case fail
	@AfterMethod
	public void failtestcase(ITestResult result) throws InterruptedException
	{
		if (ITestResult.FAILURE == result.getStatus()) {
			// Take a screenshot when TC failed and add it in the the Screenshots Folder
			Thread.sleep(500);
			Helper.TakeScreenShot(getdriver(), result.getName().concat("TC Failed"));
			Thread.sleep(500);
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
		}
		// Take a screenshot when TC Passed and add it in the the Screenshots Folder
		else if (ITestResult.SUCCESS == result.getStatus()) {
			Thread.sleep(500);
			Helper.TakeScreenShot(getdriver(), result.getName().concat("TC Passed"));
			Thread.sleep(500);
			System.out.println("Passed!");
			System.out.println("Taking Screenshot....");
		}
	}

	@AfterClass
	public void exitDriver() {
		getdriver().quit();
		driverGrid.remove();
	}

}