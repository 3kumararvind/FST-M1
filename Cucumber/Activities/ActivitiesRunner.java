package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//003E4N744//IdeaProjects//FST_Cucumber2//src//test//java//features",
        glue = {"stepDefinitions"},
        tags = "@activity7",
        plugin= {
                "html:src/reports/HTML_Report.html",
               "json:src/reports/JSON_Report.json",
                "junit:src/reports/XML_Report.xml"
        },
        monochrome = true
)
public class ActivitiesRunner {

    //empty
}
