package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue = {"step_definition"},
        plugin = {"pretty","summary", "html:target/TargetReports/reports.html"}

)
public class TestRunner {
}
