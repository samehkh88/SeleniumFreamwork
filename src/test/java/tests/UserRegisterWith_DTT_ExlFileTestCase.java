package tests;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegisterPage;

public class UserRegisterWith_DTT_ExlFileTestCase extends TestBase{

	HomePage Home;
	UserRegisterPage RegisterPage;


	


	@Test(dataProvider="registerdata")
	public void UserCanReguisterSuccessfully(String Fname , String Lname , String day , String month , String Mail , String pass , String Cpass )
	{
		Home = new HomePage(driver);
		Home.OpenRegisterPage();

		RegisterPage = new UserRegisterPage(driver);
		RegisterPage.UserRegister( Fname ,  Lname ,  day ,  month ,  Mail ,  pass ,  Cpass );
		RegisterPage.AssertRegister();
		//user will log out
		Home.UserLogOut();
	}
}
