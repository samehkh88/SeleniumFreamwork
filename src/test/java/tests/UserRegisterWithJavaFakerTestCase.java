package tests;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.UserRegisterPage;

public class UserRegisterWithJavaFakerTestCase extends TestBase{

	HomePage Home;
	UserRegisterPage RegisterPage;
	Faker fakerdata = new Faker();
	String Fname = fakerdata.name().firstName();
	String Lname = fakerdata.name().lastName();
	String email = fakerdata.internet().emailAddress();
	String pass = fakerdata.internet().password(6, 9);
	
	@Test
	public void UserCanReguisterSuccessfully()
	{
		Home = new HomePage(driver);
		Home.OpenRegisterPage();
		
		RegisterPage = new UserRegisterPage(driver);
		RegisterPage.UserRegister(Fname, Lname, "20", "March", email, pass, pass);
		RegisterPage.AssertRegister();
		
		//user will log out
		Home.UserLogOut();
	}
}
