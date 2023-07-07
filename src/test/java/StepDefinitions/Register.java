

package StepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import DataGenerators.Generators;
import Factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;

public class Register extends Generators
{
	
	WebDriver driver;
	private HomePage homepage;
	private RegisterPage registerpage;
	private AccountSuccessPage accountsuccesspage;
	@Given("User Navigates to Register Account Page")
	public void user_navigates_to_register_account_page() throws Exception 
	{
		driver = driverFactory.getDriver();   
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();    //Searching for My account and clicked
		Thread.sleep(3000);
		registerpage = homepage.selectRegisterOption();
		//driver.findElement(By.linkText("Register")).click();    //and click on the register option
		Thread.sleep(1000);
	}

	@When("User Enters the Details into the below Fields")
	public void user_enters_the_details_into_the_below_fields(DataTable dataTable) throws Exception 
	{
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
	//	registerpage =new RegisterPage(driver);
		
		registerpage.enterFirstName(dataMap.get("firstname"));
	//	driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));   //searching for first name field box and send the first name from feature file
		Thread.sleep(2000);
		registerpage.enterLastName(dataMap.get("lastname"));
	//	driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));    //searching for last name field box and send the last name from feature file
		Thread.sleep(2000);
		registerpage.enterEmailAddress(dataMap.get("email"));
	//	driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));      //searching for email field box and send the email from feature file
		Thread.sleep(2000);
		registerpage.enterTelephoneNum(dataMap.get("telephone"));
	//	driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));     //searching for telephone field box and send the telephone number from feature file
		Thread.sleep(2000);
		registerpage.enterPassword(dataMap.get("password"));
	//	driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));      //searching for password field box and send the password from feature file
		Thread.sleep(2000);
		registerpage.enterConfirmPassword(dataMap.get("password"));
	//	driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));      //searching for Confirm password field box and send the same password as above from feature file
		Thread.sleep(2000);
	}

	@When("User Selects the Privacy Policy")
	public void user_selects_the_privacy_policy() throws Exception 
	{
		registerpage.selectPrivacyPolicy();
	//	driver.findElement(By.name("agree")).click();     //searching the privacy policy button and clicked on it
		Thread.sleep(2000);
	}

	@When("User Clicks on Continue button")
	public void user_clicks_on_continue_button() throws Exception 
	{
		accountsuccesspage = registerpage.clickOnContinueButton();
	//	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();     //searching for Continue option and clicked on it
		Thread.sleep(3000);
	}

	@Then("User Account Successfully Created")
	public void user_account_successfully_created() throws Exception 
	{
	 //   AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
	    Assert.assertEquals("Your Account Has Been Created!",accountsuccesspage.getPageHeading()); 
	//	Assert.assertEquals("Your Account Has Been Created!",driver.findElement(By.xpath("//div[@id='content']/h1")).getText());    //Checking account created Successfully message displayed or not 
		Thread.sleep(2000);
	}

	@When("User Selects the Yes for Newsletter")
	public void user_selects_the_yes_for_newsletter() throws Exception 
	{
		registerpage.SelectYesNewsLetter();
	//	driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();    //Searching for newsletter and clicked on the "yes" button (by default clicked on "No" button)
		Thread.sleep(2000);
	}

	@Then("User getting Proper Warning Dupilicate Email")
	public void user_getting_proper_warning_dupilicate_email() throws Exception 
	{
		Assert.assertEquals("Warning: E-Mail Address is already registered!",registerpage.getDuplicateEmailWarningMessage());   //Checking whether warning message displayed or not, while entering the duplicate email
	//	Assert.assertEquals("Warning: E-Mail Address is already registered!",driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText());   //Checking whether warning message displayed or not, while entering the duplicate email
		Thread.sleep(2000);
	}

	@When("User dont Enter the Details into the Fields")
	public void user_dont_enter_the_details_into_the_fields() throws InterruptedException 
	{
		
		//registerpage =new RegisterPage(driver);
		//blank
		Thread.sleep(2000);
	}

	@Then("User getting Proper Warning Messages for Every Mandatory Fields")
	public void user_getting_proper_warning_messages_for_every_mandatory_fields() throws Exception 
	{
		//registerpage = new RegisterPage(driver);
		
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",registerpage.getPrivacyPolicyWarningMessage());         //Checking whether warning message displayed or not, while user does not Click the Privacy policy button
    //	Assert.assertEquals("Warning: You must agree to the Privacy Policy!",driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText());         //Checking whether warning message displayed or not, while user does not Click the Privacy policy button
		
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getFirstNameWarningMessage());                        //Checking whether warning message displayed or not, while user does not enter the firstname into the input field
	//	Assert.assertEquals("First Name must be between 1 and 32 characters!",driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText());                        //Checking whether warning message displayed or not, while user does not enter the firstname into the input field
		
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNameWarningMessage());                        //Checking whether warning message displayed or not, while user does not enter the lastname into the input field
	//	Assert.assertEquals("Last Name must be between 1 and 32 characters!",driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).getText());                        //Checking whether warning message displayed or not, while user does not enter the lastname into the input field
		
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailAddressWarningMessage());                          //Checking whether warning message displayed or not, while user does not enter the email into the input field
	//	Assert.assertEquals("E-Mail Address does not appear to be valid!",driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText());                          //Checking whether warning message displayed or not, while user does not enter the email into the input field
		
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarningMessage());                      //Checking whether warning message displayed or not, while user does not enter the telephone number into the input field
	//	Assert.assertEquals("Telephone must be between 3 and 32 characters!",driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText());                      //Checking whether warning message displayed or not, while user does not enter the telephone number into the input field
		
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getPaswordWarningMessage());     //Checking whether warning message displayed or not, while user does not enter the password into the input field
	//	Assert.assertEquals("Password must be between 4 and 20 characters!",driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText());     //Checking whether warning message displayed or not, while user does not enter the password into the input field
		Thread.sleep(2000);
	}

}
