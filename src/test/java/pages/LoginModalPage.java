package pages;

import constants.locators.KinoparkLogInModalLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginModalPage {
    private WebDriver driver;
    private By signInWithPhone = By.className(KinoparkLogInModalLocators.SIGN_IN_WITH_PHONE_CLASSNAME);
    private By phoneNumberField = By.xpath(KinoparkLogInModalLocators.PHONE_NUMBER_INPUT_XPATH);
    private By passwordField = By.xpath(KinoparkLogInModalLocators.PASSWORD_INPUT_XPATH);
    private By logInButton = By.className(KinoparkLogInModalLocators.LOG_IN_BUTTON_CLASSNAME);
    private By logInPopup = By.className(KinoparkLogInModalLocators.LOG_IN_MODAL_CLASSNAME);

    public LoginModalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogInButton () {
        driver.findElement(logInButton).click();
    }

    public WebElement getLoginModal() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(logInPopup));

        return driver.findElement(logInPopup);
    }

    public void fillPhoneNumber(String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField));
        driver.findElement(phoneNumberField).sendKeys(phone);
    }

    public void fillPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void signInWithPhone() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(signInWithPhone));

        driver.findElement(signInWithPhone).click();
    }

    public void logInToAccount(String phone, String password) {
        signInWithPhone();
        fillPhoneNumber(phone);
        fillPassword(password);
        clickLogInButton();
    }
}
