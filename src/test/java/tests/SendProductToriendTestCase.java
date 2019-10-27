package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ProductdetalisPage;
import pages.SearchPage;
import pages.UserloginPage;

public class SendProductToriendTestCase extends TestBase {

	private String productname = "Apple MacBook Pro 13-inch";

	HomePage Home;
	UserloginPage loginpage;
	SearchPage search ;
	ProductdetalisPage ProductDetalis;
	EmailPage EmailToFriend ;


	// first check the user login or no
	@Test(alwaysRun=true)
	public void A_UserCanloginSuccessfully()
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




	// search for the product
	@Test
	public void B_UserCanSearchForProductSuccessfully()
	{
		search = new SearchPage(driver);
		search.Searchforprodct(productname);
		ProductDetalis = new ProductdetalisPage(driver);
		try{
			Assert.assertEquals(ProductDetalis.DetalisProductName.getText().toLowerCase(), productname.toLowerCase());
		} catch(Exception e)
		{
			System.out.println("error message is : "+ e);
		}

	}

	//click send to friend
	@Test
	public void C_sendToFriend()
	{
		ProductDetalis = new ProductdetalisPage(driver);
		ProductDetalis.OpenEmailFriendForm();
		EmailToFriend = new EmailPage(driver);
		EmailToFriend.SubmitContact("hero_88_2006@yahoo.com", "sameh@yahoo.com", "hello please check this product for me");
		try{
			Assert.assertTrue(EmailToFriend.SuccesMessage.getText().equalsIgnoreCase("Your message has been sent."));
		} catch(Exception e)
		{
			System.out.println("error message is : "+ e);
		}
	}
	
	//user will log out
	
	@Test
	public void D_UserLogOut()
	{
		Home.UserLogOut();
	}


}