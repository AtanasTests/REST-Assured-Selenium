package ui.userarea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.WaitTool;

import static utils.Browser.driver;

public class OrderDetail {

    /**
     * The verifyOrderDetailPage method checks if the text of a specific web element on a web page matches an expected value,
     * and if not, it asserts a failure with a provided message.
     * It ensures the element is visible before retrieving its text and performing the comparison.
     * @param expectedText the validation message you would expect to appear
     * @param messageOnFailure the message that will appear if the test failed
     */
    public static void verifyOrderDetailPage(String expectedText, String messageOnFailure) {
        WebElement text = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[1]/div/h2[2]"));
        WaitTool.wait.until(ExpectedConditions.visibilityOf(text));
        String webElementText = text.getText();

        System.out.println("Text of web element is " + webElementText + "| Text should be " + expectedText);

        Assert.assertTrue(text.getText().equals(expectedText), messageOnFailure);
    }

    /**
     * This method locates a web element on a webpage and simulates a click on it.
     * Specifically, it finds and clicks a link or button that is expected to initiate the download of a label.
     */
    public static void downloadLabel() {
        WebElement labeldownload = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[1]/div/h2[1]/a"));
        labeldownload.click();
    }
}
