package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTestCase extends TestBase{

	HomePage home ;
	ContactUsPage contactPage ;
	Faker fakerdata = new Faker();
	String Fname = fakerdata.name().fullName();
	String email = fakerdata.internet().emailAddress();
	String message = "Once your new prototype is ready for a first demo, you usually need some data to present. If you already have a solid data source this should be no problem, but what about the opposite case? How to simply create meaningful random data for your Java application?" ;
/*
	@DataProvider(name="contactdata")
	public static Object[][] userdata()
	{
		return new Object[][]
				{
			{"meena Antoun","mena@yahoo.com","hello this is my first task and i learn a lot"}
				};
	}
*/
	@Test
	public void UserCanContactUs()
	{
		home = new HomePage(driver);
		contactPage = new ContactUsPage(driver);
		home.OpenContactpage();
		contactPage.SubmitContact(Fname , email , message);
		Assert.assertTrue(contactPage.SuccesMessage.getText().equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));

	}

}
