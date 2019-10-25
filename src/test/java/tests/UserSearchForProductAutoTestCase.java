package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductdetalisPage;
import pages.SearchPage;

public class UserSearchForProductAutoTestCase extends TestBase{

	private String productnameAutoComplete = "Flower Girl Bracelet";


	SearchPage search ;
	ProductdetalisPage ProductDetalis;

	@Test
	public void UserCanSearchForProductAutoCompleteSuccessfully()
	{
		search = new SearchPage(driver);
		search.SearchforprodctAutoComplete("ele", "Flower Girl Bracelet");
		ProductDetalis = new ProductdetalisPage(driver);
		Assert.assertEquals(ProductDetalis.DetalisProductName.getText().toLowerCase(), productnameAutoComplete.toLowerCase());
	}
}
