package pages;

import constants.locators.KinoparkGiftCardPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftCardPage {
    private WebDriver driver;
    private By orderButton = By.className(KinoparkGiftCardPageLocators.ORDER_BUTTON_CLASSNAME);

    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToOrder() {
        driver.findElement(orderButton).click();
    }
}
