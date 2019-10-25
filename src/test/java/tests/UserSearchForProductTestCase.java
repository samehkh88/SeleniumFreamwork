package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductdetalisPage;
import pages.SearchPage;

public class UserSearchForProductTestCase extends TestBase{

	private String productname = "Apple MacBook Pro 13-inch";


	SearchPage search ;
	ProductdetalisPage ProductDetalis;

	@Test
	public void UserCanSearchForProductSuccessfully()
	{
		search = new SearchPage(driver);
		search.Searchforprodct(productname);
		ProductDetalis = new ProductdetalisPage(driver);
		Assert.assertEquals(ProductDetalis.DetalisProductName.getText().toLowerCase(), productname.toLowerCase());
	}
}
