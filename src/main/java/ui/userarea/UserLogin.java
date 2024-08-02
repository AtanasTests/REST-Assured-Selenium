package ui.userarea;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.Browser;
import utils.WaitTool;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ui.Locators.*;
import static ui.Locators.userlogout;
import static utils.Browser.driver;

public class UserLogin {

    /**
     * Invoking this method will navigate you to the user area of the project
     */

    public static void open() {

        Browser.driver.get("https://base URL/");
    }

    /**
     * With this method user will log in with valid credentials
     * then enter his email and password in the user area
     * @param userEmail existing email of the user
     * @param userPassword existing password of the user
     */
    public static void login(String userEmail, String userPassword) {

        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        cookies.click();
        loginbutton.click();

    }

    /**
     //     * Asserts that the validation message that appear on top of the user area login form
     //     * is as expected
     //     * @param expectedLoginFormValidationMessage the validation message you would expect to appear above the login form
     //     * @param messageOnFailure the message that will appear in your test reports in case of failure
     //     */
    public static void verifyUserFullName(String expectedAdminUserFullName, String messageOnFailure) {

        WaitTool.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='user-info']")));
        WebElement userInfoElement = driver.findElement(By.xpath("//span[@class='user-info']"));
        String userInfoText = userInfoElement.getText();


        Assert.assertTrue(userInfoText.equals(expectedAdminUserFullName), messageOnFailure);

        System.out.println("Text of the expected element: " + expectedAdminUserFullName);
        System.out.println("Text of the userText info element: " + userInfoText);

    }


    public static void userLogout(){

        userdropdown.click();
        userlogout.click();

        /**
         *Screenshot that User is successful Logout
         */
        try {
            TakesScreenshot ts = (TakesScreenshot) Browser.driver;
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "C:\\Users\\User\\testpic\\screenshot_" + timestamp + ".png";

            File scrFile = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * The verifyUserLogout method checks if a user has successfully logged out by waiting for a specific login form element to be visible,
     * then comparing the displayed user information text to an expected value, and asserting the result with a failure message if they do not match.
     * @param expectedAdminUserFullName
     * @param messageOnFailure
     */
    public static void verifyUserLogout(String expectedAdminUserFullName, String messageOnFailure) {


        WaitTool.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-form\"]/div/div[1]")));
        WebElement userInfoElement = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div[1]"));
        String userInfoText = userInfoElement.getText();


        Assert.assertTrue(userInfoText.equals(expectedAdminUserFullName), messageOnFailure);


    }

}
