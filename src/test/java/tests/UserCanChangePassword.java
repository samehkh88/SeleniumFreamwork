package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserloginPage;

public class UserCanChangePassword extends TestBase{

	HomePage Home;
	UserloginPage loginpage;

	@Test(alwaysRun=true)
	public void UserCanChangePasswordSuccessfully()
	{
		try{
			Home = new HomePage(driver);

			if (Home.loginLink.isDisplayed())
			{
				Home.OpenLoginPage();
				loginpage = new UserloginPage(driver);
				loginpage.UserCanLogin("sam1@yahoo.com", "Test@123");
				Home.OpenMyAccount();

			}
			else if(Home.logOutLink.isDisplayed())
			{
				Home.OpenMyAccount();
			}
		}catch(Exception e)
		{
			System.out.println("the error message is :" + e);
		}
	}
}
