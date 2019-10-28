package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountAddresses extends PageBase{

	public MyAccountAddresses(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@value='Add new']")
	WebElement AddNewAddress ;
	
	@FindBy(id = "Address_FirstName")
	private WebElement AddressF_name ;
	
	@FindBy(id = "Address_LastName")
	private WebElement AddressL_name ;
	
	@FindBy(id = "Address_City")
	private WebElement Address_City ;
	
	@FindBy(id = "Address_Address1")
	private WebElement Address_Address1 ;
	
	@FindBy(id = "Address_Email")
	private WebElement Address_email ;
	
	@FindBy(id = "Address_ZipPostalCode")
	private WebElement Address_PostalCode ;
	
	@FindBy(id = "Address_CountryId")
	private WebElement Address_Country ;
	
	@FindBy(id = "Address_PhoneNumber")
	private WebElement Address_PhoneNumber ;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement SubmitButton ;
	
	
	
	public void ClickAddNewAddress() 
	{
		ClickButtons(AddNewAddress);
	}
	
	public void CreateNewAddress(String Fname , String Lname , String Email , String city ,String Address1 , String country , String code ,String phone )
	{
		SendValue(AddressF_name, Fname);
		SendValue(AddressL_name, Lname);
		SendValue(Address_email, Email);
		SendValue(Address_City, city);
		SelectFromDrobDown(Address_Country, country);
		SendValue(Address_Address1, Address1);
		SendValue(Address_PhoneNumber, phone);
		SendValue(Address_PostalCode, code);
		ClickButtons(SubmitButton);
		
		
		
	}

}

