package Utilities;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumDriver {
    private static SeleniumDriver seleniumDriver;
    private static WebDriver driver;
    private static WebDriverWait wait;

    SeleniumDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void setUpDriver(){
        if(seleniumDriver == null){
            seleniumDriver = new SeleniumDriver();
        }
    }

    public static void navigateTo(String website){
        driver.navigate().to(website);
        String DomainName = ((JavascriptExecutor)driver).executeScript("return document.domain;").toString();
        String title = ((JavascriptExecutor)driver).executeScript("return document.title;").toString();
        String URL = ((JavascriptExecutor)driver).executeScript("return document.URL;").toString();
        System.out.println("DomainName - "+ DomainName);
        System.out.println("URL - "+ URL);
        System.out.println("title - "+ title);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void tearDown(){
        driver.close();
        driver.quit();
    }

    public static void customWait(WebElement webElement, int seconds){
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void customWait(WebElement webElement, int pollingInterval, int timeOut) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(pollingInterval))
                .withTimeout(Duration.ofSeconds(timeOut))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        System.out.println("Element is visible now");
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
