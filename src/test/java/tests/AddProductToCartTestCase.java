package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductdetalisPage;
import pages.ReviewPage;
import pages.SearchPage;


public class AddProductToCartTestCase extends TestBase {

	private String productname = "Build your own computer";

	HomePage Home;
	SearchPage search ;
	ProductdetalisPage ProductDetalis;
	ReviewPage ReviewObject ;

	// search for the product
	@Test(priority =1)
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
	@Test(priority =2)
	public void AddProductToCart()
	{
		ProductDetalis = new ProductdetalisPage(driver);
		ProductDetalis.SelectHdd();
		ProductDetalis.SendQYT("2");
		ProductDetalis.AddTOCart();
		
		try{
			Assert.assertTrue(ProductDetalis.Successmessage.getText().equalsIgnoreCase("The product has been added to your shopping cart"));
		} catch(Exception e)
		{
			System.out.println("error message is : "+ e);
		}
		
		ProductDetalis.CloseSuccessMessage();
	}

}