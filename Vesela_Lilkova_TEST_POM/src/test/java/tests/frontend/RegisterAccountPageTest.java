package tests.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.frontend.Homepage;
import pages.frontend.RegisterAccountPage;
import tests.base.BaseTest;
import utils.Browser;

public class RegisterAccountPageTest extends BaseTest {

    protected static WebDriver driver;

    static {
        driver = Browser.getDriver();
    }

    @Test
    public void registerNewUserTest() {
        Homepage.goToHomepage();
        Homepage.goToRegistrationPage();
        RegisterAccountPage.registerNewUser("Petar", "Ivanov", driver, "0888123456", "parola123!", "parola123!");
        String actualRegistrationConfirmationMessageText = RegisterAccountPage.getRegistrationConfirmationMessageText();
        Assert.assertEquals(actualRegistrationConfirmationMessageText, "Your Account Has Been Created!");
    }
}
