package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegisterPage;

public class UserRegisterTestCase extends TestBase{

	HomePage Home;
	UserRegisterPage RegisterPage;
	
	@Test
	public void UserCanReguisterSuccessfully()
	{
		Home = new HomePage(driver);
		Home.OpenRegisterPage();
		
		RegisterPage = new UserRegisterPage(driver);
		RegisterPage.UserRegister("sameh", "Khalil", "5", "March", "sam2781@yahoo.com", "Test@123", "Test@123");
		RegisterPage.AssertRegister();
		
		//user will log out
		Home.UserLogOut();
	}
}
