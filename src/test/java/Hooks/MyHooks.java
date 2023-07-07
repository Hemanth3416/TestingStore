package Hooks;
 
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import Factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class MyHooks 
{
	WebDriver driver;
	@Before
	public void setup() throws Throwable
	{
		Properties prop = ConfigReader.intializeProperties();
		driver = driverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
}
