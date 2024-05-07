import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterNewUser {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://shop.pragmatic.bg");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRegisterNewCustomer(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAccountMenu = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a"));
        myAccountMenu.click();
        WebElement registerOption = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a"));
        registerOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        WebElement firstNameInputField = driver.findElement(By.id("input-firstname"));
        firstNameInputField.sendKeys("Pesho");
        WebElement lastNameInputField = driver.findElement(By.id("input-lastname"));
        lastNameInputField.sendKeys("Petrov");
        String emailPrefix = RandomStringUtils.randomAlphabetic(7);
        String emailSuffix = RandomStringUtils.randomAlphabetic(5);
        String emailAddress = emailPrefix + "@" + emailSuffix + ".com";
        WebElement emailInputField = driver.findElement(By.id("input-email"));
        emailInputField.sendKeys(emailAddress);
        WebElement telephoneInputField = driver.findElement(By.id("input-telephone"));
        telephoneInputField.sendKeys("0888123456");
        WebElement passwordInputField = driver.findElement(By.id("input-password"));
        passwordInputField.sendKeys("parola123!");
        WebElement passwordConfirmInputField = driver.findElement(By.id("input-confirm"));
        passwordConfirmInputField.sendKeys("parola123!");
        WebElement privacyPolicyCheckbox = driver.findElement(By.cssSelector("#content input[type=checkbox]:nth-child(2)"));
        privacyPolicyCheckbox.click();
        WebElement continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        continueButton.click();
        WebElement registrationConfirmationMessage = driver.findElement(By.cssSelector("#content > h1"));
        String displayedMessageText = registrationConfirmationMessage.getText();
        Assert.assertEquals(displayedMessageText, "Your Account Has Been Created!");
    }
}