package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="My Account")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]")
	private WebElement logInOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	private WebElement SearchButton;
	
	public void clickOnMyAccount()
	{
		myAccountDropMenu.click();
	}
	public LoginPage selectLoginOption()
	{
		logInOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption()
	{
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterValidProductSearchBox(String validProductTxt)
	{
		searchBoxField.sendKeys(validProductTxt);
	}
	
	public SearchResultsPage clickOnSearchButton()
	{
		SearchButton.click();
		return new SearchResultsPage(driver);
	}
	
}
