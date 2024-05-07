package tests.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTest {
    @BeforeClass
    public static void browserSetup() {
        Browser.setup();
    }

    @AfterClass
    public static void browserTearDown() {
        Browser.tearDown();
    }
}
