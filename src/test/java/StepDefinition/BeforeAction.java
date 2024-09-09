package StepDefinition;


import Utilities.SeleniumDriver;
import io.cucumber.java.Before;
import org.testng.annotations.BeforeSuite;

public class BeforeAction {
    @Before
    public static void setUp() {
        //ExtentCucumberFormatter.initiateExtentCucumberFormatter();
        System.out.println("Before");
        SeleniumDriver.setUpDriver();
    }
}
