package core;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;
import utils.Logger;

public class BaseTest {

    /**
     *
     The @BeforeMethod annotation in a test class indicates that the setup method should be run before each test method.
     The setup method itself calls Browser.open(),
     presumably to initialize or open a browser instance before executing the test.
     */
    @BeforeMethod
    public void setup() {
        Browser.open();
    }

    /**
     *
     The @AfterMethod annotated method tearDown runs after each test method in a test class.
     regardless of the test result, it quits the browser.
     * @param result If the test fails, it logs a failure message and takes a screenshot;
     */
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Logger.generalLog("Test failed, taking a screenshot!");
            Browser.getScreenshot();
        }
        Browser.quit();
    }
}
