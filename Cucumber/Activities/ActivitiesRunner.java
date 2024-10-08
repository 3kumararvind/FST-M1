package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"stepDefinitions"},
        tags = "@activity4",
        plugin= {
                "html:src/reports/HTML_Report",
                "json:src/reports/JSON_Report",
                "junit:src/reports/XML_Report"
        },
        monochrome = true
)
public class ActivitiesRunner {

    //empty
}
