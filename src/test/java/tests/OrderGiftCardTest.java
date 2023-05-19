package tests;

import base.BaseTest;
import constants.data.LoginData;
import constants.data.OrderGiftCardData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class OrderGiftCardTest extends BaseTest {

    // Function for successful login to be able to implement the gift card test cases
    public void successfulLogin(BasePage homePage, GiftCardPage giftCardPage, OrderGiftCardPage giftCardOrderPage, LoginModalPage loginModalPage) {
        homePage.clickGiftCard();
        giftCardPage.clickToOrder();
        giftCardOrderPage.openLoginModal();
        loginModalPage.logInToAccount(LoginData.PHONE_NUMBER, LoginData.PASSWORD);
    }
    @Test
    // Test case is checking the gift card ordering form when no data is provided
    public void GiftCardTestNoDataFilled() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);

        homePage.clickGiftCard();
        giftCardPage.clickToOrder();

        softAssert.assertFalse(giftCardOrderPage.getNextButton().isEnabled());
    }

    @Test
    // Test case is checking that login is required when design is selected and terms and conditions are accepted
    public void GiftCardLoginRequired() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        homePage.clickGiftCard();
        giftCardPage.clickToOrder();
        giftCardOrderPage.openLoginModal();

        softAssert.assertTrue(loginModalPage.getLoginModal().isDisplayed());
    }

    @Test
    // Test case is checking the gift card ordering form when no name is provided
    public void FillFormNoNameProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.FIRST_NAME_ERROR));
    }
    @Test
    // Test case is checking the gift card ordering form when name is too short
    public void FillFormInvalidNameLengthProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Ya", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.FIRST_NAME_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when no last name is provided
    public void FillFormNoLastNameProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.LAST_NAME_ERROR));
    }
    @Test
    // Test case is checking the gift card ordering form when last name is too short
    public void FillFormInvalidLastNameLengthProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Az", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.LAST_NAME_ERROR));
    }

    @Test
    public void FillFormNoEmailProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.EMAIL_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when no email provided
    public void FillFormShortEmailProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "ya", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.EMAIL_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when email is too short
    public void FillFormInvalidEmailProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.EMAIL_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when email with wrong domain is provided
    public void FillFormEmailWrongDomainProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.EMAIL_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when no day is provided
    public void FillFormNoDayProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "", "9", "2023",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getDayInput().getCssValue("border-top-color").equals("red"));
    }

    @Test
    // Test case is checking the gift card ordering form when day is above the range (1-31)
    public void FillFormDayAboveRange() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "32", "9", "2023",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getDayInput().getText().equals("3"));
    }

    @Test
    // Test case is checking the gift card ordering form when day is below the range (1-31)
    public void FillFormDayBelowRange() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "0", "9", "2023",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getDayInput().getText().isEmpty());
    }

    @Test
    // Test case is checking the gift card ordering form when no month is provided
    public void FillFormNoMonthProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "30", "", "2023",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getMonthInput().getCssValue("border-top-color").equals("red"));
    }

    @Test
    // Test case is checking the gift card ordering form when month is above the range (1-12)
    public void FillFormMonthAboveRange() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "30", "13", "2023",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getMonthInput().getText().equals("1"));
    }

    @Test
    // Test case is checking the gift card ordering form when month is below the range (1-12)
    public void FillFormMonthBelowRange() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "30", "0", "2023",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getMonthInput().getText().isEmpty());
    }

    @Test
    // Test case is checking the gift card ordering form when no year is provided
    public void FillFormNoYearProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "30", "12", "",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getYearInput().getCssValue("border-top-color").equals("red"));
    }


    @Test
    // Test case is checking the gift card ordering form when year is above the range (1-2023)
    public void FillFormYearAboveRange() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "31", "12", "2024",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getYearInput().getText().equals("202"));
    }

    @Test
    // Test case is checking the gift card ordering form when year is below the range (1-2023)
    public void FillFormYearBelowRange() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "30", "12", "0",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getYearInput().getText().isEmpty());
    }

    @Test
    // Test case is checking the gift card ordering form when no gender provided
    public void OrderGiftCardWithNoGender() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getSelectErrorMessage().isDisplayed());
    }

    @Test
    // Test case is checking the gift card ordering form when amount is not provided
    public void FillFormNoAmountProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "30", "12", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "4999");

        softAssert.assertTrue(giftCardOrderPage.getAmountField().getCssValue("color").equals("red"));
    }

    @Test
    // Test case is checking the gift card ordering form when amount is below 5000 AMD
    public void FillFormAmountBelowRange() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmailcom", "30", "12", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "4999");

        softAssert.assertTrue(giftCardOrderPage.getAmountField().getCssValue("color").equals("red"));
    }

    @Test
    // Test case is checking the gift card ordering form when recipient name is not provided
    public void FillFormNoRecipientNameProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getRecipientName().getCssValue("color").equals("red"));
    }
    @Test
    // Test case is checking the gift card ordering form when recipient name too short
    public void FillFormInvalidRecipientNameLengthProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bo", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getRecipientName().getCssValue("color").equals("red"));
    }

    @Test
    // Test case is checking the gift card ordering form when recipient last name is not provided
    public void FillFormNoRecipientLastNameProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getRecipientLastName().getCssValue("color").equals("red"));
    }
    @Test
    // Test case is checking the gift card ordering form when recipient name is too short
    public void FillFormInvalidRecipientLastNameLengthProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Ma", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getRecipientLastName().getCssValue("color").equals("red"));
    }

    @Test
    // Test case is checking the gift card ordering form when recipient email is not provided
    public void FillFormNoRecipientEmailProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.EMAIL_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when recipient name is too short
    public void FillFormShortRecipientEmailProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bo", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.EMAIL_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when recipient email is invalid
    public void FillFormInvalidRecipientEmailProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.EMAIL_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when recipient email has invalid domain
    public void FillFormRecipientEmailWrongDomainProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmailcon", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.EMAIL_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when recipient mobile number is not provided
    public void FillFormNoRecipientMobileProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.PHONE_NUMBER_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when recipient mobile number is too short
    public void FillFormShortRecipientMobileProvided() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "7722222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(giftCardOrderPage.getErrorMessage().contains(OrderGiftCardData.PHONE_NUMBER_ERROR));
    }

    @Test
    // Test case is checking the gift card ordering form when no message provided
    public void OrderGiftCardSuccessfulWithNoMessage() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "", "500000");

        softAssert.assertTrue(paymentPage.getPaymentPage().isDisplayed());
    }

    @Test
    // Test case is checking the gift card ordering form when valid input data provided
    public void OrderGiftCardSuccessful() {
        SoftAssert softAssert = new SoftAssert();
        BasePage homePage = new BasePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);
        OrderGiftCardPage giftCardOrderPage = new OrderGiftCardPage(driver);
        LoginModalPage loginModalPage = new LoginModalPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        successfulLogin(homePage, giftCardPage, giftCardOrderPage, loginModalPage);

        giftCardOrderPage.fillGiftCardForm("Yana", "Azaryan", "yana@gmail.com", "12", "06", "2001",
                "female", "Bob", "Marley", "bob@gmail.con", "77222222",
                "Gift Card for Bob", "500000");

        softAssert.assertTrue(paymentPage.getPaymentPage().isDisplayed());
    }
}
