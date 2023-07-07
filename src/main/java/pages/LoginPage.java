package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	private WebElement loginOption;
	
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailTxt)
	{
		emailField.sendKeys(emailTxt);
	}
	public void enterPassword(String passwordTxt) 
	{
		passwordField.sendKeys(passwordTxt);
	}
	public AccountPage clickOnLogin() 
	{
		loginOption.click();
		return new AccountPage(driver);
	}
	public String warningMessageText()
	{
		return warningMessage.getText();
	}
}
