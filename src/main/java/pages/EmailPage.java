package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id= "FriendEmail")
	private WebElement FriendEmail;
	
	@FindBy(id= "YourEmailAddress")
	private WebElement YourEmailAddress;

	@FindBy(id= "PersonalMessage")
	private WebElement PersonalMessage;
	
	@FindBy(xpath= "//input[@name='send-email']")
	private WebElement SubmitButton;
	
	@FindBy(xpath = "//a[@class='product']")
	public WebElement productname ;
	
	@FindBy(xpath = "//div[@class='result']")
	public WebElement SuccesMessage ;
	
	public void SubmitContact (String FriendMail , String Youremail , String message)
	{
		SendValue(FriendEmail, FriendMail);
		Clear(YourEmailAddress);
		SendValue(YourEmailAddress, Youremail);
		SendValue(PersonalMessage, message);
		ClickButtons(SubmitButton);
	}
}
