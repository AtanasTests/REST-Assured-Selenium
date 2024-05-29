package ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class Locators {

    public Locators() {

        PageFactory.initElements(Browser.driver, this);
    }
    //Login
    @FindBy(xpath = "//*[@id=\"cookies-notification\"]/div")
    public static WebElement cookies;
    @FindBy(xpath = "//*[@id=\"UserName\"]")
    public static WebElement email;
    @FindBy(xpath = "//*[@id=\"Password\"]")
    public static WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    public static WebElement loginbutton;

    //Logout
    @FindBy(xpath = "//div[@class='logo-text']")
    public static WebElement headerLogo;
    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li/a/i")
    public static WebElement userdropdown;
    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li/ul/li[3]/a")
    public static WebElement userlogout;

    //HomePage
    @FindBy(xpath = "//span[normalize-space()='Return Orders']")
    public static WebElement goToReturnOrders;


    //Return Orders page

    @FindBy(xpath = "//button[@id='search-button']")
    public static WebElement searchbutton; //click
    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[1]/div[2]/div/div/div[2]/table/tbody/tr/td[6]/a")
    public static WebElement randomorderassert;     //assert get text = randomNumber
    @FindBy(id = "spin")
    public static WebElement spinner;     //assert get text = randomNumber

    //order detail page

    @FindBy(xpath = "//a[normalize-space()='Download label']")//order detail page
    public static WebElement orderassert;        //  assert get text = randomNumber


}

