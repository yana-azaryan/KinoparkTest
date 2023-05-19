package pages;

import constants.locators.KinoparkSearchPageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private By eventsTab = By.xpath(KinoparkSearchPageLocators.EVENTS_BUTTON_XPATH);
    private By resultsMovieTitle = By.className(KinoparkSearchPageLocators.RESULTS_MOVIE_TITLE_CLASSNAME);
    private By resultsEventTitle = By.className(KinoparkSearchPageLocators.RESULT_EVENT_TITLE_CLASSNAME);
    private By emptyResult = By.className(KinoparkSearchPageLocators.RESULTS_EMPTY_CLASSNAME);

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnEventsTab() {
        driver.findElement(eventsTab).click();
    }

    public List getSearchResults() {

        return driver.findElements(resultsMovieTitle);
    }

    public List getEventSearchResults() {
        clickOnEventsTab();

        return driver.findElements(resultsEventTitle);
    }

    public String getNoResult() {

        return driver.findElement(emptyResult).getText();
    }

    public String getNoResultEvents() {
        clickOnEventsTab();

        return driver.findElement(emptyResult).getText();
    }
}
