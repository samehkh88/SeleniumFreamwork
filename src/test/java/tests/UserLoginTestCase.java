package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserloginPage;

public class UserLoginTestCase extends TestBase{

	HomePage Home;
	UserloginPage loginpage;
	
	@Test
	public void UserCanloginSuccessfully()
	{
		Home = new HomePage(driver);
		Home.OpenLoginPage();
		
		loginpage = new UserloginPage(driver);
		loginpage.UserCanLogin("sam2111@yahoo.com", "Test@123");
		assertEquals("Log out", Home.logOutLink.getText());
		
		//user will log out
		Home.UserLogOut();
	}
}
