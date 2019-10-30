package tests;


import org.testng.annotations.Test;

import data.LoadPropertise;
import pages.HomePage;
import pages.UserRegisterPage;

public class UserRegisterWith_DTT_PropertiseTestCase extends TestBase {

	HomePage Home;
	UserRegisterPage RegisterPage;
	String fn = LoadPropertise.user.getProperty("firstName");
	String Ln = LoadPropertise.user.getProperty("lastName");
	String Day = LoadPropertise.user.getProperty("Day");
	String month = LoadPropertise.user.getProperty("month");
	String email = LoadPropertise.user.getProperty("email");
	String password = LoadPropertise.user.getProperty("password");


	@Test
	public void UserCanReguisterSuccessfully()
	{
		Home = new HomePage(driver);
		Home.OpenRegisterPage();

		RegisterPage = new UserRegisterPage(driver);
		RegisterPage.UserRegister( fn ,  Ln ,  Day ,  month ,  email ,  password ,  password );
		RegisterPage.AssertRegister();
		//user will log out
		Home.UserLogOut();
	}
}
