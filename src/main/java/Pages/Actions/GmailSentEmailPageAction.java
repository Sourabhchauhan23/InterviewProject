package Pages.Actions;

import Pages.Locators.GmailSentEmailPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static Pages.Locators.GmailSentEmailPageLocator.sentEmailTables;
import static Utilities.SeleniumDriver.getDriver;

public class GmailSentEmailPageAction {

    GmailSentEmailPageLocator gmailSentEmailPageLocator;

    public GmailSentEmailPageAction(){
        gmailSentEmailPageLocator = new GmailSentEmailPageLocator();
        AjaxElementLocatorFactory ajaxElementLocatorFactory =new AjaxElementLocatorFactory(getDriver(), 5 );
        PageFactory.initElements(ajaxElementLocatorFactory, this.gmailSentEmailPageLocator);
    }

    public String verifyEmailSent(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement sentEmailTable = sentEmailTables.get(1);
        String recipientEMail = sentEmailTable.findElement(By.xpath("./tr[1]/td[4]/div/span")).getAttribute("email");
        return recipientEMail;
    }


}
