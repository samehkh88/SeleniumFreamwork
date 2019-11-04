package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ShopingCart;
import pages.HomePage;
import pages.ProductdetalisPage;
import pages.SearchPage;
import pages.UserRegisterPage;

public class CheckOutTestCase extends TestBase{


	HomePage Home;
	UserRegisterPage RegisterPage;
	SearchPage search ;
	ProductdetalisPage ProductDetalis;
	ShopingCart shopcart ;
	private String productname = "Apple MacBook Pro 13-inch";
	Faker fakerdata = new Faker();
	String Fname = fakerdata.name().firstName();
	String Lname = fakerdata.name().lastName();
	String email = fakerdata.internet().emailAddress();
	String pass = fakerdata.internet().password(6, 9);

	//User Register


	@Test(alwaysRun=true , priority =1)
	public void UserCanReguisterSuccessfully()
	{
		Home = new HomePage(driver);
		Home.OpenRegisterPage();

		RegisterPage = new UserRegisterPage(driver);
		RegisterPage.UserRegister(Fname, Lname, "20", "March", email, pass, pass);
		RegisterPage.AssertRegister();
	}
	
	//Search for product
	@Test(priority=2)
	public void UserCanSearchForProductSuccessfully()
	{
		search = new SearchPage(driver);
		search.Searchforprodct(productname);
		ProductDetalis = new ProductdetalisPage(driver);
		Assert.assertEquals(ProductDetalis.DetalisProductName.getText().toLowerCase(), productname.toLowerCase());
	}
	
	//add to cart
	@Test(priority=3)
	public void AddProductToCart() throws InterruptedException
	{
		ProductDetalis = new ProductdetalisPage(driver);
		Thread.sleep(5000);
		ProductDetalis.AddTOCart();
		Thread.sleep(3000);
		try{
			Assert.assertTrue(ProductDetalis.Successmessage.getText().equalsIgnoreCase("The product has been added to your shopping cart"));
		} catch(Exception e)
		{
			System.out.println("error message is : "+ e);
		}
		
		ProductDetalis.CloseSuccessMessage();
	}
	//checkout
	@Test(priority=4)
	public void UserCanGoToCheckoutSuccessfully() 
	{
		shopcart = new ShopingCart(driver);
		shopcart.GoToShopingCart();
		shopcart.AgreeToTerms();
		Assert.assertTrue(shopcart.total.getText().equalsIgnoreCase("$3,600.00"));
		shopcart.GoToCheckout();
		
	}
	//logout


}
