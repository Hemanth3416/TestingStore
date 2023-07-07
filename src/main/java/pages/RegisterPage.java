package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name="agree")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	private WebElement selectContinueButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	private WebElement yesToNewsLetter;
	
	@FindBy(xpath="//*[@id=\"account-register\"]/div[1]")
	private WebElement duplicateEmailWarningMessage;
	
	@FindBy(xpath="//*[@id=\"account-register\"]/div[1]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[2]/div/div")
	private WebElement firstNameFieldWarningMessage;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[3]/div/div")
	private WebElement lastNameFieldWarningMessage;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[4]/div/div")
	private WebElement emailAddressFieldWarningMessage;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[5]/div/div")
	private WebElement telephoneFieldWarningMessage;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
	private WebElement paswordFieldWarningMessage;
	
	
	
	
	
	public void enterFirstName(String firstname)
	{
		firstNameField.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		lastNameField.sendKeys(lastname);
	}
	
	public void enterEmailAddress(String email)
	{
		emailAddressField.sendKeys(email);
	}
	
	public void enterTelephoneNum(String telephone)
	{
		telephoneField.sendKeys(telephone);
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String password)
	{
		confirmPasswordField.sendKeys(password);
	}
	
	public void selectPrivacyPolicy()
	{
		privacyPolicy.click();
	}
	
	public AccountSuccessPage clickOnContinueButton()
	{
		selectContinueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void SelectYesNewsLetter()
	{
		yesToNewsLetter.click();
	}
	
	public String getDuplicateEmailWarningMessage()
	{
		return duplicateEmailWarningMessage.getText();
	}
	
	public String getPrivacyPolicyWarningMessage()
	{
		return privacyPolicyWarningMessage.getText();
	}
	
	public String getFirstNameWarningMessage()
	{
		return firstNameFieldWarningMessage.getText();
	}
	
	public String getLastNameWarningMessage()
	{
		return lastNameFieldWarningMessage.getText();
	}
	
	public String getEmailAddressWarningMessage()
	{
		return emailAddressFieldWarningMessage.getText();
	}
	
	public String getTelephoneWarningMessage()
	{
		return telephoneFieldWarningMessage.getText();
	}
	
	public String getPaswordWarningMessage()
	{
		return paswordFieldWarningMessage.getText();
	}
	
}
