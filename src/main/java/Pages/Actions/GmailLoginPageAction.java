package Pages.Actions;

import Pages.Locators.GmailLoginPageLocator;
import Utilities.SeleniumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import static Pages.Locators.GmailLoginPageLocator.*;
import static Utilities.SeleniumDriver.customWait;
import static Utilities.SeleniumDriver.getDriver;

public class GmailLoginPageAction {

    GmailLoginPageLocator gmailLoginPageLocator;
    Properties properties = new Properties();
    FileInputStream fileInputStream;

    public GmailLoginPageAction(){
        gmailLoginPageLocator = new GmailLoginPageLocator();
        AjaxElementLocatorFactory ajaxElementLocatorFactory =new AjaxElementLocatorFactory(getDriver(), 5 );
        PageFactory.initElements(ajaxElementLocatorFactory, this.gmailLoginPageLocator);
        try {
            fileInputStream = new FileInputStream("C:\\Users\\Sourabh\\IdeaProjects\\Interview\\src\\main\\resources\\Config.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loginGmail(){

        String title = ((JavascriptExecutor)getDriver()).executeScript("return document.title;").toString();
        System.out.println("title - "+ title);
        if(title.contains("Inbox")) {

        } else{

            signInButton.click();
            customWait(usernameInputField, 10);
            usernameInputField.sendKeys(properties.getProperty("Gmail.username"));
            nextButton.click();
            customWait(passwordInputField, 10);
            passwordInputField.sendKeys(properties.getProperty("Gmail.password"));
            nextButton.click();

        }

    }


}
