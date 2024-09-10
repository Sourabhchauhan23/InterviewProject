package Pages.Actions;

import Pages.Locators.GmailHomePageLocator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.util.Properties;

import static Pages.Locators.GmailHomePageLocator.*;
import static Utilities.SeleniumDriver.customWait;
import static Utilities.SeleniumDriver.getDriver;

public class GmailHomePageAction {

    GmailHomePageLocator gmailHomePageLocator;
    Properties properties = new Properties();
    FileInputStream fileInputStream;

    public GmailHomePageAction(){
        gmailHomePageLocator = new GmailHomePageLocator();
        AjaxElementLocatorFactory ajaxElementLocatorFactory =new AjaxElementLocatorFactory(getDriver(), 5 );
        PageFactory.initElements(ajaxElementLocatorFactory, this.gmailHomePageLocator);
        try {
            fileInputStream = new FileInputStream("C:\\Users\\Sourabh\\IdeaProjects\\Interview\\src\\main\\resources\\Config.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void openNewEmailWindow(){
        customWait(composeButton,5);
        composeButton.click();
    }

    public void isNewMessageWindowPresent(){
        try{
            customWait(newMessageWindow, 10);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("New Message window is visible");
    }

    public void addRecipients(String recipientsEmailId){
        Actions actions = new Actions(getDriver());
        customWait(emailRecipientsInputField,5);
        actions.moveToElement(emailRecipientsInputField).click().sendKeys(recipientsEmailId);
        actions.keyDown(Keys.ENTER).build().perform();

    }

    public void addSubject(String emailSubject){
        Actions actions = new Actions(getDriver());
        customWait(emailSubjectInputField,5);
        actions.moveToElement(emailSubjectInputField).click().sendKeys(emailSubject).build().perform();
    }

    public void addBody(String emailBody){
        Actions actions = new Actions(getDriver());
        customWait(emailBodyInputField,5);
        actions.moveToElement(emailBodyInputField).click().sendKeys(emailBody).build().perform();
    }

    public void sendEmail(){
        customWait(sendButton,5);
        sendButton.click();
    }

    public void openSentEmail(){
        customWait(sentEmailFolder,5);
        sentEmailFolder.click();
    }

    public void verifyError(){
        Assert.assertTrue(alertMsg.isEnabled());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeAlert(){
        closeAlertMsg.click();
    }


}
