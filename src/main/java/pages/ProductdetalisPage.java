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

	@FindBy (linkText = "Add your review")
	private WebElement addReview ;

	@FindBy(id="product_attribute_3_6")
	private WebElement OptionHDD;

	@FindBy(id="addtocart_1_EnteredQuantity")
	private WebElement QYTField;

	@FindBy(id="add-to-cart-button-1")
	private WebElement AddToCartButton;
	
	@FindBy(xpath="//p[@class='content']")
	public WebElement Successmessage;
	

	@FindBy (id = "add-to-wishlist-button-1")
	private WebElement AddToWishList ;
	
	@FindBy(xpath="//span[@class='close']")
	public WebElement SuccessmessageClosse;
	


	public void OpenEmailFriendForm()
	{
		ClickButtons(EmailFriendButtton);
	}

	public void OpenAddReviewForm()
	{
		ClickButtons(addReview);
	}
	
	public void AddToWishList()
	{
		ClickButtons(AddToWishList);
	}



	public void SelectHdd()
	{
		ClickButtons(OptionHDD);
	}

	public void SendQYT(String QytValue)
	{
		Clear(QYTField);
		SendValue(QYTField, QytValue);
	}

	public void AddTOCart()
	{
		ClickButtons(AddToCartButton);
	}
	
	public void CloseSuccessMessage()
	{
		ClickButtons(SuccessmessageClosse);
	}
}
