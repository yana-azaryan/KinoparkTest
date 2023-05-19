package pages;

import constants.locators.KinoparkHomePageLocators;
import org.openqa.selenium.*;

public class BasePage {
    private WebDriver driver;
    private By search = By.className(KinoparkHomePageLocators.SEARCH_BUTTON_CLASSNAME);
    private By searchInput = By.className(KinoparkHomePageLocators.SEARCH_INPUT_CLASSNAME);
    private By contactUs = By.xpath(KinoparkHomePageLocators.CONTACT_US_XPATH);
    private By giftCard = By.xpath(KinoparkHomePageLocators.GIFT_CARD_PAGE_XPATH);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearch() {
        driver.findElement(search).click();
    }

    public void clickContactUs() {
        driver.findElement(contactUs).click();
    }

    public void clickGiftCard() {
        driver.findElement(giftCard).click();
    }

    public void fillSearch(String key) {
        driver.findElement(searchInput).sendKeys(key + Keys.RETURN);
    }

    public void searchItem(String key) {
        clickSearch();
        fillSearch(key);
    }
}

