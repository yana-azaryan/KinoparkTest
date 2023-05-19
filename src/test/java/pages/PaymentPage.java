package pages;

import constants.locators.KinoparkPaymentPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    private WebDriver driver;
    private By paymentPage = By.className(KinoparkPaymentPageLocators.PAYMENT_PAGE_CLASSNAME);

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPaymentPage() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(paymentPage));

        return driver.findElement(paymentPage);
    }
}

