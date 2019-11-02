package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class UserRegisterPage extends PageBase{

	public UserRegisterPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@value='M']")
	private WebElement Gender;

	@FindBy(id = "FirstName")
	private WebElement FirstName;

	@FindBy(id = "LastName")
	private WebElement LastName;

	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	private WebElement DayofBirth;

	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	private WebElement MonthofBirth;

	@FindBy(id = "Email")
	private WebElement Email;

	@FindBy(id = "Password")
	private WebElement Password;

	@FindBy(id = "ConfirmPassword")
	private WebElement ConfirmPassword;

	@FindBy(id = "register-button")
	private WebElement RegisterButton;

	@FindBy(className="result")
	WebElement Result;


	public void UserRegister(String fname , String Lname ,String day , String month , String email , String pass , String Confirmpass  )
	{

		ClickButtons(Gender);
		SendValue(FirstName, fname);
		SendValue(LastName, Lname);

		SelectFromDrobDown(DayofBirth, day);
		SelectFromDrobDown(MonthofBirth, month);

		SendValue(Email, email);
		SendValue(Password, pass);
		SendValue(ConfirmPassword, Confirmpass);
		ClickButtons(RegisterButton);
	}

	public void UserRegister2(String fname , String Lname , String month , String email , String pass , String Confirmpass  )
	{

		ClickButtons(Gender);
		SendValue(FirstName, fname);
		SendValue(LastName, Lname);
		SelectFromDrobDown(MonthofBirth, month);

		SendValue(Email, email);
		SendValue(Password, pass);
		SendValue(ConfirmPassword, Confirmpass);
		ClickButtons(RegisterButton);
	}

	
	public void AssertRegister()
	{
		Assert.assertEquals("Your registration completed", Result.getText());
	}

}
