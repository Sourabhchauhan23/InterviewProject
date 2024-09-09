package StepDefinition;

import Utilities.SeleniumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class AfterAction {

    @After
    public static void afterTest(Scenario scenario) {

        WebDriver driver= SeleniumDriver.getDriver();
        System.out.println(scenario.isFailed());
        if (scenario.isFailed()) {
            try {
                File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("C:\\Users\\Sourabh\\IdeaProjects\\Interview\\src\\test\\resources\\Screenshots"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterAll
    public static void after_all(){
        SeleniumDriver.tearDown();
    }
}
