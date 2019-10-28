package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductdetalisPage;
import pages.ReviewPage;
import pages.SearchPage;
import pages.UserloginPage;

public class AddProductReviewTestCase extends TestBase {

	private String productname = "Apple MacBook Pro 13-inch";

	HomePage Home;
	UserloginPage loginpage;
	SearchPage search ;
	ProductdetalisPage ProductDetalis;
	ReviewPage ReviewObject ;


	// first check the user login or no
	@Test(priority = 1 ,alwaysRun=true)
	public void UserCanloginSuccessfully()
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
	@Test(priority=2)
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
	@Test(priority =3)
	public void AddProductReviewReview()
	{
		ProductDetalis = new ProductdetalisPage(driver);
		ProductDetalis.OpenAddReviewForm();
		ReviewObject = new ReviewPage(driver);
		ReviewObject.SubmitContact("good product", "Les options sont uniquement pour les 12-17 ans, uniquement pour la période mentionnée, uniquement pour le package All Inclusive");
		try{
			Assert.assertTrue(ReviewObject.SuccesMessage.getText().equalsIgnoreCase("Product review is successfully added."));
		} catch(Exception e)
		{
			System.out.println("error message is : "+ e);
		}
	}
	
	//user will log out
	
	@Test(priority = 4)
	public void UserLogOut()
	{
		Home.UserLogOut();
	}


}