package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage 
{
	WebDriver driver;
	public SearchResultsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[3]/div/label")
	private WebElement validProduct;
	
	@FindBy(xpath="//*[@id=\"content\"]/p[2]")
	private WebElement invalidProduct;
	
	
	
	
	
	public String getDisplayStatusOfValidProduct()
	{
		return validProduct.getText();
	}
	
	public String getDisplayStatusOfInvalidProduct()
	{
		return invalidProduct.getText();
	}
}
