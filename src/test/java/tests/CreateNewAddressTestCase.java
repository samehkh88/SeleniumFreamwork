package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyAccountAddresses;
import pages.MyAccountPage;
import pages.ProductdetalisPage;
import pages.ReviewPage;
import pages.SearchPage;
import pages.UserloginPage;

public class CreateNewAddressTestCase extends TestBase {
	

	HomePage Home ;
	UserloginPage loginpage;
	SearchPage search ;
	ProductdetalisPage ProductDetalis;
	ReviewPage ReviewObject ;
	
	MyAccountPage Myaccount ;
	MyAccountAddresses AccountAddress ;

	// first check the user login or no
	@Test(priority =1 ,alwaysRun=true)
	public void UserCanloginSuccessfully()
	{

		Home = new HomePage(driver);
		Home.OpenLoginPage();
		loginpage = new UserloginPage(driver);
		loginpage.UserCanLogin("sam2111@yahoo.com", "Test@123");
		try{
			assertEquals("Log out", Home.logOutLink.getText());
		} catch(Exception e)
		{
			System.out.println("error message is : "+ e);
		}
	}
	
	
	@Test(priority =2)
	public void YourAccount()
	{
		Myaccount = new MyAccountPage(driver);
		AccountAddress = new MyAccountAddresses(driver);
		Home.OpenMyAccount();
		Myaccount.OpenMyAddress();
		AccountAddress.ClickAddNewAddress();
	}


}
