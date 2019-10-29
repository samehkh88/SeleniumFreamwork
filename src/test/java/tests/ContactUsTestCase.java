package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTestCase extends TestBase{

	HomePage home ;
	ContactUsPage contactPage ;

	@DataProvider(name="contactdata")
	public static Object[][] userdata()
	{
		return new Object[][]
				{
			{"meena Antoun","mena@yahoo.com","hello this is my first task and i learn a lot"}
				};
	}

	@Test(dataProvider="contactdata")
	public void UserCanContactUs(String name, String email, String message)
	{
		home = new HomePage(driver);
		contactPage = new ContactUsPage(driver);
		home.OpenContactpage();
		contactPage.SubmitContact(name , email , message);
		Assert.assertTrue(contactPage.SuccesMessage.getText().equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));

	}

}
