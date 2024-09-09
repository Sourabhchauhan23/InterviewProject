package StepDefinition;

import Pages.Actions.GmailHomePageAction;
import Pages.Actions.GmailLoginPageAction;
import Pages.Actions.GmailSentEmailPageAction;
import Utilities.SeleniumDriver;
import Utilities.URLs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.ITestContext;

public class ComposeEmail {

    GmailLoginPageAction gmailLoginPageAction = new GmailLoginPageAction();
    GmailHomePageAction gmailHomePageAction = new GmailHomePageAction();
    GmailSentEmailPageAction gmailSentEmailPageAction = new GmailSentEmailPageAction();

    @Given("User has login in {string}.")
    public void LoginGmail(String website){
        SeleniumDriver.navigateTo(URLs.Google.getURL());
        SeleniumDriver.navigateTo(URLs.GMAIL.getURL());
        gmailLoginPageAction.loginGmail();
    }

    @When("User click on compose button.")
    public void userClickOnComposeButton() {
        gmailHomePageAction.openNewEmailWindow();
    }

    @Then("Verify new Email compose window is present.")
    public void verifyNewEmailComposeWindowIsPresent() {
        gmailHomePageAction.isNewMessageWindowPresent();
    }

    @When("User drafts and send an Email to {string}.")
    public void userDraftsAndSendAnEmail(String recipientEmailId) {
        gmailHomePageAction.openNewEmailWindow();
//        gmailHomePageAction.isNewMessageWindowPresent();
        gmailHomePageAction.addRecipients(recipientEmailId);
        gmailHomePageAction.addSubject("Incubyte");
        gmailHomePageAction.addBody("QA test for Incubyte");
        gmailHomePageAction.sendEmail();
    }

    @Then("Verify Email is sent successfully.")
    public void verifyEmailIsSentSuccessfully() {
        gmailHomePageAction.openSentEmail();
        String emailReciepient=gmailSentEmailPageAction.verifyEmailSent();
        Assert.assertEquals(emailReciepient,"sourabhchauhan23@gmail.com");
    }

    @When("User drafts Email without any Recipient EmailId.")
    public void userDraftsEmailWithAnyRecipientEmailId() {
        gmailHomePageAction.openNewEmailWindow();
        gmailHomePageAction.addSubject("Incubyte");
        gmailHomePageAction.addBody("QA test for Incubyte");
    }

    @Then("Verify error when user click on Send button.")
    public void verifyErrorWhenUserClickOnSendButton() {
        gmailHomePageAction.sendEmail();
        gmailHomePageAction.verifyError();
        gmailHomePageAction.closeAlert();

    }
}
