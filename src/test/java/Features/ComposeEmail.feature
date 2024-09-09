#Test Ccompose functionality of Gmail

  Feature: Compose Email
    Background:
      Given User has login in "Gmail".

    Scenario: Open new Email compose window
      When User click on compose button.
      Then Verify new Email compose window is present.


    Scenario: Successful sending Email
      When User drafts and send an Email to "sourabhchauhan23@gmail.com".
      Then Verify Email is sent successfully.

    Scenario: Failed while sending Email
      When User drafts Email without any Recipient EmailId.
      Then Verify error when user click on Send button.