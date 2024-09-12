package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//003E4N744//IdeaProjects//FST_Cucumber2//src//test//java//features",
        glue = {"stepDefinitions"},
        tags = "@activity7",
        plugin = {"json: target/cucumber-reports/json-report.json"},
        monochrome = true
)
public class ActivitiesRunner {

    //empty
}
