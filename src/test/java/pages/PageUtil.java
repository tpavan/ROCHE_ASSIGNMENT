package pages;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Function;

public class PageUtil extends TestConfig {
    private static WebDriver drivers = driver;

    public static WebElement fluentClickWithXpath(String xpath) {
        return fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(xpath));
            }
        });
    }

    public static void acceptPoupWindow(){
        drivers.switchTo().alert().accept();
    }

    public static void rejectPupWindow(){
        drivers.switchTo().alert().accept();
    }

}
