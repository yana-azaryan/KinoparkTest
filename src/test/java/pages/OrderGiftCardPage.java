package pages;

import constants.locators.KinoparkOrderGiftCardPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderGiftCardPage {
    private WebDriver driver;
    private By nextButton = By.xpath(KinoparkOrderGiftCardPageLocators.GIFT_CARD_NEXT_XPATH);
    private By giftCardDesign = By.cssSelector(KinoparkOrderGiftCardPageLocators.GIFT_CARD_DESIGN_CSS_SELECTOR);
    private By termsAndConditions = By.className(KinoparkOrderGiftCardPageLocators.TERMS_AND_CONDITIONS_CLASSNAME);
    private By firstName = By.xpath(KinoparkOrderGiftCardPageLocators.FIRST_NAME_INPUT_XPATH);
    private By lastName = By.xpath(KinoparkOrderGiftCardPageLocators.LAST_NAME_INPUT_XPATH);
    private By emailAddress = By.xpath(KinoparkOrderGiftCardPageLocators.EMAIL_INPUT_XPATH);
    private By day = By.xpath(KinoparkOrderGiftCardPageLocators.DAY_INPUT_XPATH);
    private By month = By.xpath(KinoparkOrderGiftCardPageLocators.MONTH_INPUT_XPATH);
    private By year = By.xpath(KinoparkOrderGiftCardPageLocators.YEAR_INPUT_XPATH);
    private By genderSelectField = By.className(KinoparkOrderGiftCardPageLocators.GENDER_SELECT_FIELD_CLASSNAME);
    private By female = By.xpath(KinoparkOrderGiftCardPageLocators.FEMALE_FIELD_XPATH);
    private By male = By.xpath(KinoparkOrderGiftCardPageLocators.MALE_FIELD_XPATH);
    private By recipientName = By.xpath(KinoparkOrderGiftCardPageLocators.RECIPIENT_FULL_NAME_INPUT_XPATH);
    private By recipientLastName = By.xpath(KinoparkOrderGiftCardPageLocators.RECIPIENT_LAST_NAME_INPUT_XPATH);
    private By recipientEmail = By.xpath(KinoparkOrderGiftCardPageLocators.RECIPIENT_EMAIL_INPUT_XPATH);
    private By mobileNumber = By.xpath(KinoparkOrderGiftCardPageLocators.MOBILE_INPUT_XPATH);
    private By message = By.xpath(KinoparkOrderGiftCardPageLocators.MESSAGE_INPUT_XPATH);
    private By amount = By.xpath(KinoparkOrderGiftCardPageLocators.AMOUNT_INPUT_XPATH);
    private By errorMessage = By.cssSelector(KinoparkOrderGiftCardPageLocators.ERROR_FIELD_CSS_SELECTOR);
    private By selectErrorMessage = By.cssSelector(KinoparkOrderGiftCardPageLocators.ERROR_SELECT_FIELD_CSS_SELECTOR);

    public OrderGiftCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNextButton() {
        return driver.findElement(nextButton);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public WebElement getSelectErrorMessage() {
        return driver.findElement(selectErrorMessage);
    }

    public WebElement getDayInput() {
        return driver.findElement(day);
    }

    public WebElement getMonthInput() {
        return driver.findElement(month);
    }

    public WebElement getYearInput() {
        return driver.findElement(year);
    }

    public WebElement getAmountField() {
        return driver.findElement(amount);
    }

    public WebElement getRecipientName() {
        return driver.findElement(recipientName);
    }

    public WebElement getRecipientLastName() {
        return driver.findElement(recipientLastName);
    }

    public String getGender() {
        return driver.findElement(genderSelectField).getText();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickToSelectGender() {
        driver.findElement(genderSelectField).click();
    }

    public void clickToSelectMale() {
        driver.findElement(male).click();
    }

    public void clickToSelectFemale() {
        driver.findElement(female).click();
    }

    public void selectGiftCardDesign() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(giftCardDesign));

        driver.findElement(giftCardDesign).click();
    }

    public void agreeToTermsAndConditions() {
        driver.findElement(termsAndConditions).click();
    }

    public void fillFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
    }

    public void fillLastName(String surname) {
        driver.findElement(lastName).sendKeys(surname);
    }
    public void fillEmail(String email) {
        driver.findElement(emailAddress).sendKeys(email);
    }

    public void fillBirthDate(String dayInput, String monthInput, String yearInput) {
        driver.findElement(day).sendKeys(dayInput);
        driver.findElement(month).sendKeys(monthInput);
        driver.findElement(year).sendKeys(yearInput);
    }

    public void selectGender(String gender) {
        if (!gender.equals("")) {
            clickToSelectGender();
            if (gender == "male") {
                clickToSelectMale();
            } else {
                clickToSelectFemale();
            }
        }
    }

    public void fillRecipientFirstName(String nameRecipient) {
        driver.findElement(recipientName).sendKeys(nameRecipient);
    }

    public void fillRecipientLastName(String surnameRecipient) {
        driver.findElement(recipientLastName).sendKeys(surnameRecipient);
    }
    public void fillRecipientEmail(String emailRecipient) {
        driver.findElement(recipientEmail).sendKeys(emailRecipient);
    }

    public void fillRecipientMobileNumber(String number) {
        driver.findElement(mobileNumber).sendKeys(number);
    }

    public void fillMessage(String messageInput) {
        driver.findElement(message).sendKeys(messageInput);
    }

    public void fillAmount(String amountInput) {
        driver.findElement(amount).sendKeys(amountInput);
    }


    public void fillGiftCardForm(String name, String surname, String email, String dayInput, String monthInput, String yearInput,
                                 String gender, String nameRecipient, String surnameRecipient, String emailRecipient, String number,
                                 String messageInput, String amountInput) {
        fillFirstName(name);
        fillLastName(surname);
        fillEmail(email);
        fillBirthDate(dayInput, monthInput, yearInput);
        selectGender(gender);
        fillRecipientFirstName(nameRecipient);
        fillRecipientLastName(surnameRecipient);
        fillRecipientEmail(emailRecipient);
        fillRecipientMobileNumber(number);
        fillMessage(messageInput);
        fillAmount(amountInput);
        clickNextButton();
    }

    public void openLoginModal() {
        selectGiftCardDesign();
        agreeToTermsAndConditions();

        clickNextButton();
    }
}
