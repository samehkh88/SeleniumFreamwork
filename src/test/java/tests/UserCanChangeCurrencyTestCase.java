package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ProductdetalisPage;
import pages.SearchPage;
import pages.UserloginPage;

public class UserCanChangeCurrencyTestCase extends TestBase {

	private String productname = "Apple MacBook Pro 13-inch";

	HomePage Home;
	UserloginPage loginpage;
	SearchPage search ;
	ProductdetalisPage ProductDetalis;
	EmailPage EmailToFriend ;



	// search for the product
	@Test(priority = 1)
	public void UserCanSearchForProductSuccessfully()
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
	@Test(priority=2)
	public void UserChangeCurrency()
	{
		ProductDetalis = new ProductdetalisPage(driver);
		Home = new HomePage(driver);
		Home.ChangeCurrancy("Euro");
		
		try{
			Assert.assertTrue(ProductDetalis.ProductPrice.getText().equalsIgnoreCase("Ђ1548.00"));
		} catch(Exception e)
		{
			System.out.println("error message is : "+ e);
		}
	}

}