package pages;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "small-searchterms")
	WebElement SearchBox;

	@FindBy(xpath = "//ul[@id='ui-id-1']/li/a")
	java.util.List<WebElement> ProductSearchList1;


	@FindBy(xpath = "//input[@value='Search']")
	WebElement SearchButton;

	@FindBy(xpath="//h2[@class='product-title']/a")
	WebElement productlink ;
	



	public void Searchforprodct(String searchValue) 
	{
		SendValue(SearchBox, searchValue);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ClickButtons(SearchButton);
		ClickButtons(productlink);

	}

	public void SearchforprodctAutoComplete(String searchValue , String ExpectedProduct) 
	{
		SendValue(SearchBox, searchValue);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int x = ProductSearchList1.size();

		for(int i = 0 ; i < x ; i ++)
		{
			if(ProductSearchList1.get(i).getText().contentEquals(ExpectedProduct))

			{
				ProductSearchList1.get(i).click();
			}
		}

	}


}
