package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.Locators;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Browser {

    public static WebDriver driver;

    /**
     * This method initializes a new ChromeDriver instance,
     * maximizes the window, and creates a Locators object,
     * presumably to handle web element locators in the test automation framework.
     */
    public static void open() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Locators locators = new Locators();

    }


    /**
     * Quits the process of the opened browser
     */
    public static void quit() {
        driver.quit();
    }

    /**
     * This method captures a screenshot of a specific WebElement on a web page.
     * It takes the WebElement as input, extracts its location and size,
     * captures a screenshot of the entire page,
     * and then crops the screenshot to only include the specified WebElement.
     * Finally, it saves the cropped screenshot as a PNG file and returns it.
     */
    public static File captureElementBitmap(WebElement element) throws Exception {
        WrapsDriver wrapsDriver = (WrapsDriver) element;
        File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(screen);
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        java.awt.Rectangle rect = new java.awt.Rectangle(width, height);
        Point p = element.getLocation();
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        ImageIO.write(dest, "png", screen);
        return screen;
    }

    /**
     * This method captures a screenshot of the current browser window
     * if the driver supports it and saves the screenshot to a specified directory with a timestamped filename,
     * logging success or failure accordingly.
     * If the driver cannot take screenshots, it logs a message indicating this limitation.
     */
    public static void getScreenshot() {
        if (driver != null) {
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot screenshotTakingDriver = (TakesScreenshot) driver;
                try {
                    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    String fileName = "C:\\Users\\User\\testpic\\screenshot_error" + timestamp + ".png";
                    File scrFile = screenshotTakingDriver.getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scrFile, new File(fileName));
                    Logger.generalLog("Screenshot saved with name: " + fileName);
                } catch (IOException e) {
                    Logger.generalLog("Unable to take screenshot" + e);
                }
            } else {
                Logger.generalLog("Driver '{}' can't take screenshots so skipping it." + driver.getClass());
            }
        }
    }
}
