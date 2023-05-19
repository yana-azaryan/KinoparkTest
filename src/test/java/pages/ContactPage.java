package pages;

import constants.locators.KinoparkContactUsPageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    private WebDriver driver;
    private By emailError =  By.xpath(KinoparkContactUsPageLocators.EMAIL_ERROR_MESSAGE_XPATH);
    private By contactName = By.xpath(KinoparkContactUsPageLocators.CONTACT_NAME_XPATH);
    private By contactSubject = By.xpath(KinoparkContactUsPageLocators.CONTACT_SUBJECT_XPATH);
    private By contactEmail = By.xpath(KinoparkContactUsPageLocators.CONTACT_EMAIL_XPATH);
    private By contactMessage = By.xpath(KinoparkContactUsPageLocators.CONTACT_MESSAGE_XPATH);
    private By contactFormSubmit = By.xpath(KinoparkContactUsPageLocators.CONTACT_FORM_SUBMIT_XPATH);

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailError() {
        return driver.findElement(emailError);
    }

    public WebElement getSendButton() {
        return driver.findElement(contactFormSubmit);
    }

    public void clickSend() {
        driver.findElement(contactFormSubmit).click();
    }

    public void fillName(String name) {
        driver.findElement(contactName).sendKeys(name);
    }

    public void fillSubject(String subject) {
        driver.findElement(contactSubject).sendKeys(subject);
    }

    public void fillEmail(String email) {
        driver.findElement(contactEmail).sendKeys(email);
    }

    public void fillMessage(String message) {
        driver.findElement(contactMessage).sendKeys(message);
    }

    public void fillContactUsForm (String name, String subject, String email, String message) {
        fillName(name);
        fillSubject(subject);
        fillEmail(email);
        fillMessage(message);
    }

    public void fillContactUsFormFailure (String name, String subject, String email, String message) {
        fillContactUsForm(name, subject, email, message);
        clickSend();
    }
}
