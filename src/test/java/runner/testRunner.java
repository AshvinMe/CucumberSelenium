package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        //glue = {"src/test/java/stepDefinitions","src/test/java/utils"},
        glue = {"stepDefinitions"},
        plugin = {"pretty","html:target/cucumber-html-report", "json:cucumber.json"}
)
public class testRunner {
}
