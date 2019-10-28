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
	
	public void ClickAddNewAddress() 
	{
		ClickButtons(AddNewAddress);
	}

}

