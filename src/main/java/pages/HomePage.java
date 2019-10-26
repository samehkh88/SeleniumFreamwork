package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[contains(@class,'ico-register')]")
	WebElement RegisterLink;

	@FindBy(xpath = "//a[contains(@class,'ico-login')]")
	public WebElement loginLink;

	@FindBy(xpath = "//a[contains(@class,'ico-logout')]")
	public WebElement logOutLink;

	@FindBy(xpath = "//a[contains(@class,'ico-account')]")
	public WebElement MyAccountLink;

	@FindBy(linkText = "Contact us")
	public WebElement ContactUsPage ;

	@FindBy(id ="customerCurrency")
	WebElement currancy ;


	public void OpenRegisterPage()
	{
		ClickButtons(RegisterLink);
	}

	public void OpenLoginPage()
	{
		ClickButtons(loginLink);
	}

	public void UserLogOut()
	{
		ClickButtons(logOutLink);
	}

	public void OpenMyAccount()
	{
		ClickButtons(MyAccountLink);
	}

	public void OpenContactpage()
	{
		Scroll();
		ClickButtons(ContactUsPage);
	}

	public void ChangeCurrancy(String Currencyvalue)
	{

		SelectFromDrobDown(currancy, Currencyvalue);
	}


}
