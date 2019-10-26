package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id= "FullName")
	private WebElement YourName;
	
	@FindBy(id= "Email")
	private WebElement Email;

	@FindBy(id= "Enquiry")
	private WebElement Message;
	
	@FindBy(xpath= "//input[@name='send-email']")
	private WebElement SubmitButton;
	
	@FindBy(xpath = "//div[@class='result']")
	public WebElement SuccesMessage ;
	
	public void SubmitContact (String name , String email , String message)
	{
		SendValue(YourName, name);
		Clear(Email);
		SendValue(Email, email);
		SendValue(Message, message);
		ClickButtons(SubmitButton);
	}
	


}
