package tests;

import base.BaseTest;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.SearchPage;
import constants.data.SearchData;

import java.util.List;

public class SearchTest extends BaseTest {
    @Test
    // Test case is checking that the movie search was performed successfully
    public void SearchTestSuccessful() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.searchItem(SearchData.SEARCH_INPUT_MOVIE);
        List<RemoteWebElement> searchResults = searchPage.getSearchResults();

        for (RemoteWebElement str : searchResults) {
            softAssert.assertTrue(str.getText().contains(SearchData.SEARCH_INPUT_MOVIE));
        }
    }

    @Test
    // Test case is checking that the blog and event search was performed successfully
    public void SearchEventsTestSuccessful() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.searchItem(SearchData.SEARCH_INPUT_EVENTS);

        List<RemoteWebElement> searchResults = searchPage.getEventSearchResults();

        for (RemoteWebElement str : searchResults) {
            softAssert.assertTrue(str.getText().contains(SearchData.SEARCH_INPUT_EVENTS));
        }
    }

    @Test
    // Test case is checking that the movie search performs correctly when there is no such movie
    public void SearchTestNoResults() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.searchItem(SearchData.NO_RESULT);

        softAssert.assertTrue(searchPage.getNoResult().contains(SearchData.NO_RESULT));
    }

    @Test
    // Test case is checking that the blog and event search performs correctly when there is no such event or blog
    public void SearchEventsTestNoResults() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.searchItem(SearchData.NO_RESULT);

        softAssert.assertTrue(searchPage.getNoResultEvents().contains(SearchData.NO_RESULT));
    }
}
