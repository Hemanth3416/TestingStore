package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		         features="src\\test\\resources\\FeaturesFile",
		         glue= {"StepDefinitions","Hooks"},
		         plugin={"pretty","html:target/CucumberReports/CucumberReport.html"},
                 tags="@register"
             //    dryRun=false,
              //   monochrome=false
		        )
public class MyRunner 
{

}