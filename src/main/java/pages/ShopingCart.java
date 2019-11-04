package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopingCart extends PageBase{


	public ShopingCart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(linkText="Shopping cart")
	private WebElement ShopCart;

	@FindBy(id="termsofservice")
	private WebElement AgreeLink;
	
	@FindBy(className="value-summary")
	public WebElement total;
	
	@FindBy(id="checkout")
	private WebElement Checkoutpage ;
	
	public void GoToShopingCart() 
	{
		ClickButtons(ShopCart);
	} 
	
	public void AgreeToTerms() 
	{
		ClickButtons(AgreeLink);
	}
	
	public void GoToCheckout() 
	{
		ClickButtons(Checkoutpage);
	}
}
