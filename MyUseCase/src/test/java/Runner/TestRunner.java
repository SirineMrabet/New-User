package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
/**
 * Created by smrabet on 08/12/17.
 */
@CucumberOptions(plugin = { "html:target/cucumber-html-report", "json:target/cucumber.json" },
        features = {"src/test/java/Features"},
        strict = true,
        monochrome = true,
        glue = "Steps",
        tags = {"@stable"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
}