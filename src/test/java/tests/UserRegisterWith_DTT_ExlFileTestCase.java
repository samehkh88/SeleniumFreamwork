package tests;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.Exlreader;
import pages.HomePage;
import pages.UserRegisterPage;

public class UserRegisterWith_DTT_ExlFileTestCase extends TestBase{

	HomePage Home;
	UserRegisterPage RegisterPage;

	@DataProvider(name="registerdata")
	public static Object[][] UserData() throws IOException
	{
		//read data from exl
		Exlreader reader = new Exlreader();
		return reader.GetExlData(0 , 6);

	}



	@Test(dataProvider="registerdata")
	public void UserCanReguisterSuccessfully(String Fname , String Lname , String month , String Mail , String pass , String Cpass )
	{
		Home = new HomePage(driver);
		Home.OpenRegisterPage();

		RegisterPage = new UserRegisterPage(driver);
		RegisterPage.UserRegister2( Fname ,  Lname ,  month ,  Mail ,  pass ,  Cpass );
		RegisterPage.AssertRegister();
		//user will log out
		Home.UserLogOut();
	}
}
