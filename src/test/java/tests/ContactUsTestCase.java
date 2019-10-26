package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTestCase extends TestBase{

	HomePage home ;
	ContactUsPage contactPage ;
	
	@Test
	public void UserCanContactUs()
	{
		home = new HomePage(driver);
		contactPage = new ContactUsPage(driver);
		home.OpenContactpage();
		contactPage.SubmitContact("sameh khalil", "sameh@yahoo.com", "this is big test message");
		Assert.assertTrue(contactPage.SuccesMessage.getText().equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));
		
	}
	
}
