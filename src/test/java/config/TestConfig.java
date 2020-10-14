package config;

import exception.SuiteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertiesUtil;

import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @TestConfig will mange suite lavel configuration
 */
public class TestConfig {
    public static String browserValue = "firefox";
    public static String appDir = System.getProperty("user.dir");
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Select select;
    public static Actions actions;
    public static Wait<WebDriver> fluentWait;
    public static String parentWindow;

    @BeforeSuite
    public void loadData() {
        PropertiesUtil.loadProperties("app.properties");
    }

    @BeforeSuite
    public void suiteSetup() {
        try {
            configureBrowserDriver("test", "firefox");
        } catch (SuiteException e) {
            e.fillInStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @AfterSuite
    public void suiteTearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public void configureBrowserDriver(String envName, String browserName) throws SuiteException {

        if (System.getProperty("browserValue") != null) {
            browserName = System.getProperty("browserValue");
        }

        if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", appDir + "/drivers/geckodriver");
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", appDir + "/drivers/chromedriver_mac_64");
            driver = new ChromeDriver();
        } else {
            throw new SuiteException(browserName.concat("browser is not able to configure in environment"));
        }

        initFluentWait();
        initAction();
        launchApp();
    }

    public void launchApp() {
        driver.get(PropertiesUtil.getPropertyInsts().getProperty("appURL"));
    }

    public void initAction(){
        actions = new Actions(driver);
    }

    public static String getAppDir() {
        return appDir;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Actions getActions() {
        return actions;
    }

    public <T> T initPageWebElement(Class<T> T){
        return PageFactory.initElements(driver,T);
    }

    public void initFluentWait(){
        fluentWait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofSeconds(5))
                .withMessage("Not able to access element")
                .withTimeout(Duration.ofSeconds(50));
    }

    public void switchToNewlyOpenWindow(){
        parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();

        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public void switchToParentWindow(){
        driver.switchTo().window(parentWindow);
    }

    public void JSClick(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public Properties loadProperty(){
        return PropertiesUtil.loadProperties(appDir.concat("app.properties"));
    }
}
