package StepDefinitions;

import org.openqa.selenium.WebDriver;

import DataGenerators.Generators;
import Factory.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class Login
{	
	WebDriver driver;
	private LoginPage loginpage = new LoginPage(driver);
	private AccountPage accountpage = new AccountPage(driver);
	
	@Given("User Navigates to Login Page")
	public void user_navigates_to_login_page() throws Exception 
	{
		driver = driverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		Thread.sleep(3000);
		homepage.clickOnMyAccount();
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();     //searching for My account and clicked
		Thread.sleep(3000);
		loginpage = homepage.selectLoginOption();
		//driver.findElement(By.linkText("Login")).click();      // login option displayed and then clicked on the login button
		Thread.sleep(2000);
	}

	@When("User Enters the Valid Email {string} into Email Field")
	public void user_enters_the_valid_email_into_email_field(String emailTxt) throws Exception 
	{
		//loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(emailTxt);
		//driver.findElement(By.id("input-email")).sendKeys(emailTxt);  //searching for email field and given valid email into the field
		Thread.sleep(2000);
	}

	@When("User Enters the Valid Password {string} into Password Field")
	public void user_enters_the_valid_password_into_password_field(String passwordTxt) throws Exception    
	{
		loginpage.enterPassword(passwordTxt);
		//driver.findElement(By.id("input-password")).sendKeys(passwordTxt);    //searching for password field and given valid password into the field
		Thread.sleep(2000);
	}

	@When("User Clicks on Login button")
	public void user_clicks_on_login_button() throws Exception 
	{
		accountpage = loginpage.clickOnLogin();
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();        //searching for login button and clicked it
		Thread.sleep(3000);
	}

	@Then("User should Successfully Logged In")
	public void user_should_successfully_logged_in() throws Exception 
	{
		//accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInformationOption());
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());     // checking user enters into the account page by giving valid email and password
		Thread.sleep(2000);
	}

	@When("User Enters the Invalid Email Address into Email Field")
	public void user_enters_the_invalid_email_address_into_email_field() throws Exception    
	{
		//loginpage = new LoginPage(driver);
		//Thread.sleep(3000);
		loginpage.enterEmailAddress(Generators.emailTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(Generators.emailTimeStamp());          //searching for email field and given Invalid email into the field
		Thread.sleep(3000);
	}

	@When("User Enters the Invalid Password into Password Field")
	public void user_enters_the_invalid_password_into_password_field() throws Exception 
	{
		loginpage.enterPassword(Generators.passwordTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(Generators.passwordTimeStamp());      //searching for password field and given Invalid password into the field
		Thread.sleep(3000);
	}

	@Then("User should get a Proper Warning Message about Credentials Mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() throws Exception 
	{
		Assert.assertTrue(loginpage.warningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		//Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText());    // checking for Warning message while entering the invalid details
		Thread.sleep(3000);
	}

	@When("User dont Enter the Valid Email into Email Field")
	public void user_dont_enter_the_valid_email_into_email_field() throws Exception 
	{
		//loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress("");
		//driver.findElement(By.id("input-email")).sendKeys("");     //searching for email field and not given any input (empty) into the field
		Thread.sleep(1000);
	}

	@When("User dont Enter the Valid Password into Password Field")
	public void user_dont_enter_the_valid_password_into_password_field() throws Exception 
	{
		loginpage.enterPassword("");
		//driver.findElement(By.id("input-password")).sendKeys("");      //searching for password field and not given any input (empty) into the field
		Thread.sleep(1000);
	}
	
}

