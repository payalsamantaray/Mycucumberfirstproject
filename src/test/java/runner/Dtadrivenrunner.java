package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Datadriven.feature",
        glue = "stepdefinitions",

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },
        monochrome = true
)
public class Dtadrivenrunner {

}
