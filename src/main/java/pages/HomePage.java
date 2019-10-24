package pages;

import java.util.concurrent.TimeUnit;

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
	
	@FindBy(id = "small-searchterms")
	 WebElement SearchBox;
	
	@FindBy(id = "ui-id-1")
	 WebElement ProductSearchList;
	
	
	@FindBy(xpath = "//input[@value='Search']")
	 WebElement SearchButton;
	
	
	
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
	
	public void Searchforprodct(String searchValue) 
	{
		SendValue(SearchBox, searchValue);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SelectFromDrobDown(ProductSearchList, searchValue);
		ClickButtons(SearchButton);
	}
}
