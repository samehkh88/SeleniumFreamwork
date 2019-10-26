package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver ;
	protected JavascriptExecutor js ;

	// create constructor
	public PageBase (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	protected void ClickButtons(WebElement button)
	{
		button.click();
	}

	protected void SendValue (WebElement field , String value)
	{
		field.sendKeys(value);
	}

	protected void SelectFromDrobDown(WebElement field , String value)
	{
		Select sel = new Select(field);
		sel.selectByVisibleText(value);
	}
	
	public void Clear(WebElement field)
	{
		field.clear();
	}
	public void Scroll()
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,2000)");
	}


}
