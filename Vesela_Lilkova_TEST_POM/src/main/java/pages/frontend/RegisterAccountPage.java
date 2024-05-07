package pages.frontend;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utils.WaitTool;

public class RegisterAccountPage extends BasePage {

    private static final By FIRST_NAME_INPUT_FIELD = By.id("input-firstname");

    private static final By LAST_NAME_INPUT_FIELD = By.id("input-lastname");

    private static final By EMAIL_INPUT_FIELD = By.id("input-email");

    private static final By TELEPHONE_INPUT_FIELD = By.id("input-telephone");

    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");

    private static final By PASSWORD_CONFIRM_INPUT_FIELD = By.id("input-confirm");

    private static final By PRIVACY_POLICY_CHECKBOX = By.cssSelector("#content input[type=checkbox]:nth-child(2)");

    private static final By CONTINUE_BUTTON = By.cssSelector(".btn.btn-primary");

    private static final By REGISTRATION_CONFIRMATION_MESSAGE = By.cssSelector("#content > h1");

    public static void registerNewUser(String firstName, String lastName, WebDriver driver, String telephone, String password, String passwordConfirm){
        RegisterAccountPage.writeInFirstNameInputField(firstName);
        RegisterAccountPage.writeInLastNameInputField(lastName);
        RegisterAccountPage.writeInEmailInputField(driver);
        RegisterAccountPage.writeInTelephoneInputField(telephone);
        RegisterAccountPage.writeInPasswordInputField(password);
        RegisterAccountPage.writeInPasswordConfirmInputField(passwordConfirm);
        RegisterAccountPage.selectPrivacyPolicyCheckbox();
        RegisterAccountPage.clickContinueButton();
    }

    public static void writeInFirstNameInputField(String firstName) {
        WaitTool.waitForElementVisibility(FIRST_NAME_INPUT_FIELD, 10);
        writeTextInWebElement(FIRST_NAME_INPUT_FIELD, firstName);
    }

    public static void writeInLastNameInputField(String lastName) {
        writeTextInWebElement(LAST_NAME_INPUT_FIELD, lastName);
    }

    public static String writeInEmailInputField(WebDriver driver) {
        String emailPrefix = RandomStringUtils.randomAlphabetic(7);
        String emailSuffix = RandomStringUtils.randomAlphabetic(5);
        String emailAddress = emailPrefix + "@" + emailSuffix + ".com";
        writeTextInWebElement(EMAIL_INPUT_FIELD, emailAddress);
        return emailAddress;
    }

    public static void writeInTelephoneInputField(String telephone) {
        writeTextInWebElement(TELEPHONE_INPUT_FIELD, telephone);
    }

    public static void writeInPasswordInputField(String password) {
        writeTextInWebElement(PASSWORD_INPUT_FIELD, password);
    }

    public static void writeInPasswordConfirmInputField(String passwordConfirm) {
        writeTextInWebElement(PASSWORD_CONFIRM_INPUT_FIELD, passwordConfirm);
    }

    public static void selectPrivacyPolicyCheckbox(){
        clickOnWebElementByLocator(PRIVACY_POLICY_CHECKBOX);
    }

    public static void clickContinueButton(){
        clickOnWebElementByLocator(CONTINUE_BUTTON);
    }

    public static String getRegistrationConfirmationMessageText(){
        WaitTool.waitForElementVisibility(REGISTRATION_CONFIRMATION_MESSAGE, 10);
        return driver.findElement(REGISTRATION_CONFIRMATION_MESSAGE).getText();
    }

}
