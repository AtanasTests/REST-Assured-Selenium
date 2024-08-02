package ui.userarea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.WaitTool;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static ui.Locators.*;
import static ui.Locators.randomorderassert;
import static utils.Browser.driver;

public class ReturnOrder {

    /**
     * The verifyReturnOrderPage method navigates to the return orders page by simulating a click action,
     * then verifies that the title of the return orders page matches an expected title.
     * If the titles do not match, it throws an assertion error with a provided failure message and prints both the expected and actual titles.
     * @param expectedPageName the validation message you would expect to appear
     * @param messageOnFailure the message that will appear if the test failed
     */
    public static void verifyReturnOrderPage(String expectedPageName, String messageOnFailure) {

        goToReturnOrders.click();


        WebElement returnOrder = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[1]/form[1]/div[1]/h1"));
        String returnOrderPage = returnOrder.getText();

        Assert.assertTrue(returnOrderPage.equals(expectedPageName), messageOnFailure);

        System.out.println("Text of the expected element: " + expectedPageName);
        System.out.println("Text of the userText info element: " + returnOrderPage);

    }

    /**
     * This method searches for an order by inputting a provided order number (randomNumber) into a web element
     * identified by the ID "SearchModel_OrderNumber", waits for the element to become visible,
     * and then clicks the search button to execute the search
     */
    public static void searchOrder(String randomNumber) {

        WebElement findReturn = driver.findElement(By.id("SearchModel_OrderNumber"));
        WaitTool.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchModel_OrderNumber")));
        findReturn.click();
        findReturn.sendKeys(randomNumber);
        searchbutton.click();

    }

    /**
     * This method waits for a loading spinner to disappear and a specific element to become clickable,
     * then clicks the element, waits for a new window to open,
     * and switches to that new window to navigate to the order details page.
     */
    public static void goToOrderDetailsPage() {

        WaitTool.wait.until(ExpectedConditions.invisibilityOf(spinner));
        WaitTool.wait.until(ExpectedConditions.elementToBeClickable(randomorderassert));
        try{

            String originalWindow = driver.getWindowHandle();
            randomorderassert.click();
            WaitTool.wait.until(numberOfWindowsToBe(2));

            for (String windowHandle : driver.getWindowHandles()) {
                if(!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

        }catch (Exception e){};

    }
}
