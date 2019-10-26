package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductdetalisPage extends PageBase{

	public ProductdetalisPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="//h1[@itemprop='name']")
	public WebElement DetalisProductName ;

	@FindBy (xpath="//input[@value='Email a friend']")
	private WebElement EmailFriendButtton ;
	
	@FindBy (xpath="//span[@itemprop='price']")
	public WebElement ProductPrice ;
	
	

	public void OpenEmailFriendForm()
	{
		ClickButtons(EmailFriendButtton);
	}


}
