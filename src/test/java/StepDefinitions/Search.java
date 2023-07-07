package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Factory.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search 
{
	WebDriver driver;
	private HomePage homepage;
	private SearchResultsPage searchresultspage;
	@Given("User Opens the Application")
	public void user_opens_the_application() throws Exception 
	{
		driver = driverFactory.getDriver();
    //		driver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[1]")).click();     //finding home button and clicked on it
		Thread.sleep(2000);
	}

	@When("User Enters Valid Product {string} into Search Box Field")
	public void user_enters_valid_product_into_search_box_field(String validProductTxt) throws Exception 
	{
	    homepage = new HomePage(driver);
		homepage.enterValidProductSearchBox(validProductTxt);
	//	driver.findElement(By.name("search")).sendKeys(validProductTxt);       //searching for Search box and entering the valid product details
		Thread.sleep(2000);
	}

	@When("User Clicks on the Search button")
	public void user_clicks_on_the_search_button() throws Exception 
	{
		searchresultspage = homepage.clickOnSearchButton();
	//	driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();        // searching for browse button and clicked it
		Thread.sleep(2000);
	}

	@Then("User Should get Valid Product Displayed in Search Results")
	public void user_should_get_valid_product_displayed_in_search_results() throws Exception 
	{
	//	searchresultspage = new SearchResultsPage(driver);
		Assert.assertEquals("Sort By:", searchresultspage.getDisplayStatusOfValidProduct());     //Checking whether valid product displayed or not
	//	Assert.assertEquals("Sort By:", driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/label")).getText());     //Checking whether valid product displayed or not
		Thread.sleep(2000);
	}

	@When("User Enters Invalid Product {string} into Search Box Field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductTxt) throws Exception 
	{
		homepage = new HomePage(driver);
		homepage.enterValidProductSearchBox(invalidProductTxt);
	//	driver.findElement(By.name("search")).sendKeys(invalidProductTxt);    //searching for search box and entering the invalid product name
		Thread.sleep(2000);
	}

	@Then("User Should get Message about no Product Matching")
	public void user_should_get_message_about_no_product_matching() throws Exception 
	{
	//	searchresultspage =new SearchResultsPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.", searchresultspage.getDisplayStatusOfInvalidProduct());     //Checking whether no product Matching message displayed or not
	//	Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText());     //Checking whether no product Matching message displayed or not
		Thread.sleep(2000);
	}

	@When("User dont Enter any Product Name into Search Box Field")
	public void user_dont_enter_any_product_name_into_search_box_field() throws Exception 
	{
		homepage = new HomePage(driver);
//		Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText());    //Checking whether no product Matching message displayed or not
		Thread.sleep(2000);
	}
}
