package pages.frontend;

import org.openqa.selenium.By;
import pages.base.BasePage;

public class Homepage extends BasePage {

    private static final By MY_ACCOUNT_MENU = By.cssSelector("#top-links > ul > li.dropdown > a");

    private static final By REGISTER_OPTION = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a");

    private static final String HOMEPAGE_URL = "http://shop.pragmatic.bg";

    public static void goToHomepage() {
        driver.get(HOMEPAGE_URL);
    }

    public static void goToRegistrationPage() {
        Homepage.selectMyAccountMenu();
        Homepage.selectRegisterOption();
    }

    public static void selectMyAccountMenu() {
        clickOnWebElementByLocator(MY_ACCOUNT_MENU);
    }

    public static void selectRegisterOption() {
        clickOnWebElementByLocator(REGISTER_OPTION);
    }

}
