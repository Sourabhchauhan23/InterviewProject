package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failedrerun.txt",
        glue = {"StepDefinition"}
)
public class RetryRunner extends AbstractTestNGCucumberTests {
}
