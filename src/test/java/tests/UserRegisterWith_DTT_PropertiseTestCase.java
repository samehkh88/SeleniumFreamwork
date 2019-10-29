package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegisterPage;

public class UserRegisterWith_DTT_PropertiseTestCase extends TestBase{

	HomePage Home;
	UserRegisterPage RegisterPage;


	@DataProvider(name="registerdata")
	public static Object[][] UserData()
	{

		return new Object[][] 
				{
			{"marian","magdy","10" ,"April" ,"jack@yahoo.com" ,"123456789" ,"123456789"}
			,
			{"meena","antoun","20" ,"April" ,"meena@yahoo.com" ,"123456789" ,"123456789"}
				};


	}


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
