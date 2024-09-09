package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\Features", glue = "StepDefinition", plugin = "rerun:target/failedrerun.txt")
public class Runner extends AbstractTestNGCucumberTests {
}
