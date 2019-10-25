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
}
