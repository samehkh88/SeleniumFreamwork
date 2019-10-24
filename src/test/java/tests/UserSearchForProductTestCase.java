package tests;


import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserloginPage;

public class UserSearchForProductTestCase extends TestBase{

	HomePage Home;
	UserloginPage loginpage;
	
	@Test
	public void UserCanSearchForProductSuccessfully()
	{
		Home = new HomePage(driver);
		
        Home.Searchforprodct("mac");
	}
}
