package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.ContactPage;

public class ContactUsTest extends BaseTest {
    @Test
    // Test case is checking the Contact Us form when no data is provided
    public void ContactUsTestNoDataFilled() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();

        softAssert.assertFalse(contactPage.getSendButton().isEnabled());
    }

    @Test
    // Test case is checking the Contact Us form when no email provided
    public void ContactUsTestMissingEmailField() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("yana", "avatar", "", "When is Avatar");

        softAssert.assertFalse(contactPage.getSendButton().isEnabled());
    }

    @Test
    // Test case is checking the Contact Us form when email is too short
    public void ContactUsTestInvalidEmailField() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("yana", "avatar", "ya", "When is Avatar");

        softAssert.assertFalse(contactPage.getSendButton().isEnabled());
    }

    @Test
    // Test case is checking the Contact Us form when email configuration is incorrect
    public void ContactUsTestEmailConfigurationFailure() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("yana", "avatar", "yana.azaryan", "When is Avatar");

        softAssert.assertTrue(contactPage.getEmailError().isDisplayed());
    }

    @Test
    // Test case is checking the Contact Us form when no name is provided
    public void ContactUsTestMissingNameField() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("", "avatar", "yana.azaryan@mail.ru", "When is Avatar");

        softAssert.assertFalse(contactPage.getSendButton().isEnabled());
    }

    @Test
    // Test case is checking the Contact Us form when name is too short
    public void ContactUsTestInvalidNameField() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("ya", "avatar", "yana.azaryan@mail.ru", "When is Avatar");

        softAssert.assertFalse(contactPage.getSendButton().isEnabled());
    }

    @Test
    // Test case is checking the Contact Us form when no subject is provided
    public void ContactUsTestMissingSubjectField() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("yana", "", "yana.azaryan@mail.ru", "When is Avatar");

        softAssert.assertFalse(contactPage.getSendButton().isEnabled());
    }

    @Test
    // Test case is checking the Contact Us form when subject is too short
    public void ContactUsTestInvalidSubjectField() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("yana", "av", "yana.azaryan@mail.ru", "When is Avatar");

        softAssert.assertFalse(contactPage.getSendButton().isEnabled());
    }


    @Test
    // Test case is checking the Contact Us form when no message is provided
    public void ContactUsTestMissingMessageField() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("yana", "avatar", "yana.azaryan@mail.ru", "");

        softAssert.assertFalse(contactPage.getSendButton().isEnabled());
    }

    @Test
    // Test case is checking the Contact Us form when message is too short
    public void ContactUsTestInvalidMessageField() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("yana", "avatar", "yana.azaryan@mail.ru", "Wh");

        softAssert.assertFalse(contactPage.getSendButton().isEnabled());
    }

    @Test
    // Test case is checking that the Contact Us form is filled successfully
    public void ContactUsTestValidFormInput() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.clickContactUs();
        contactPage.fillContactUsFormFailure("yana", "avatar", "yana.azaryan@mail.ru", "When is Avatar");

        softAssert.assertTrue(contactPage.getSendButton().isEnabled());
    }
}
