package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.UserRegisterPage;

public class UserRegisterWith_DTT_CSVTestCase extends TestBase{

	// comment dont forget to add dependency open CSV


	HomePage Home;
	UserRegisterPage RegisterPage;
	CSVReader reader ;

	@Test
	public void UserCanReguisterSuccessfully() throws CsvValidationException, IOException
	{
		//get the path for the CSV
		String CSVpath = System.getProperty("user.dir")+"\\data\\Data - register.csv" ;
		try {
			reader = new CSVReader(new FileReader(CSVpath));
		} catch (FileNotFoundException e) {
			System.out.println("There is a error in csv file " + e.getMessage());
		}
		String[] csvCell ; 
		while((csvCell = reader.readNext()) != null) 
		{
			String firstname = csvCell[0]; 
			String lastName = csvCell[1];
			String month = csvCell[2]; 
			String email = csvCell[3]; 
			String password = csvCell[4]; 
			String Cpassword = csvCell[5]; 
			
		Home = new HomePage(driver);
		Home.OpenRegisterPage();

		RegisterPage = new UserRegisterPage(driver);
		RegisterPage.UserRegister2(firstname, lastName, month, email, password, Cpassword);
		RegisterPage.AssertRegister();

		//user will log out
		Home.UserLogOut();
	}
}
}