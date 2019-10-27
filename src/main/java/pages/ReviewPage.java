package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends PageBase{

	public ReviewPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id= "AddProductReview_Title")
	private WebElement Reviewtitle;
	
	@FindBy(id= "AddProductReview_ReviewText")
	private WebElement Reviewtext;

	@FindBy(id= "addproductrating_4")
	private WebElement ReviewGood;
	
	@FindBy(xpath= "//input[@name='add-review']")
	private WebElement SubmitReview;
	
	@FindBy(xpath = "//div[@class='result']")
	public WebElement SuccesMessage ;
	
	
	
	public void SubmitContact (String title , String message)
	{
		SendValue(Reviewtitle, title);
		SendValue(Reviewtext, message);
		ClickButtons(ReviewGood);
		ClickButtons(SubmitReview);
	}
}
