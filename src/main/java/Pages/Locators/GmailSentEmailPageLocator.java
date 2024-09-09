package Pages.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailSentEmailPageLocator {

    @FindBy(xpath = "//table[@role='grid']/tbody")
    public static List<WebElement> sentEmailTables;

}
