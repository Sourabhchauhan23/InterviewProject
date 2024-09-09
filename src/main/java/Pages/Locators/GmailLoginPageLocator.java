package Pages.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPageLocator {

    @FindBy(xpath ="//a[normalize-space()='Sign in']")
    public static WebElement signInButton;

    @FindBy(xpath="//input[@id='identifierId']")
    public static WebElement usernameInputField;

    @FindBy(xpath="//span[normalize-space()='Next']")
    public static WebElement nextButton;

    @FindBy(xpath="//input[@name='Passwd']")
    public static WebElement passwordInputField;

    @FindBy(xpath="//span[normalize-space()='Not now']")
    public static WebElement notNowButton;


}
