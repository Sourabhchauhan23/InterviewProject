package Pages.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailHomePageLocator {

    @FindBy(xpath="//div[contains(text(),'Compose')]")
    public static WebElement composeButton;

    @FindBy(className = "AD")
    public static WebElement newMessageWindow;

    @FindBy(name = "to")
    public static WebElement emailRecipientsInputField;

    @FindBy(name = "subjectbox")
    public static WebElement emailSubjectInputField;

    @FindBy(xpath = "//div[@aria-label='Message Body']")
    public static WebElement emailBodyInputField;

    @FindBy(xpath = "//div[@role='button' and text()='Send']")
    public static WebElement sendButton;

    @FindBy(xpath = "//a[@aria-label='Sent']")
    public static WebElement sentEmailFolder;

    @FindBy(xpath = "//body")
    public static WebElement shadowHost;

    @FindBy(xpath = "//div[@jscontroller='dGzwdb']")
    public static WebElement shadowRoot;


    @FindBy(xpath = "//div[@role='alertdialog']/div[1][contains(text(),'Please specify at least one recipient.')]")
    public static WebElement alertMsg;

    @FindBy(xpath = "//div[@role='alertdialog']/div[2]/div/button")
    public static WebElement closeAlertMsg;

}
