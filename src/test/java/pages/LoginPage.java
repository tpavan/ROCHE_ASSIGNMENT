package pages;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends TestConfig {

    @FindBy(using = "desktop-userIconsContainer", how = How.CLASS_NAME)
    private WebElement profileIcon;

    @FindBy(using = "desktop-linkButton", how = How.CLASS_NAME)
    private WebElement LoginBtn;

    @FindBy(using = "//input[@autocomplete='new-password']", how = How.XPATH)
    private WebElement loginMobileInpt;

    @FindBy(using = "submitBottomOption", how = How.CLASS_NAME)
    private WebElement loginContinueBtn;

    @FindBy(using = "desktop-infoEmail", how = How.CLASS_NAME)
    private WebElement desktopInfoEmail;

    @FindBy(using = "//div[@class='verificationContainer']", how = How.XPATH)
    private WebElement verifyWithOtpImg;

    @FindBy(using = "//div[@class='desktop-infoEmail']",how = How.XPATH)
    private WebElement loggedInUserMob;

    public boolean Login() {
        profileIcon.click();
        //LoginBtn.click();
        PageUtil.fluentClickWithXpath("//input[@class='desktop-linkButton']").click();
        driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("9021723001");
        loginContinueBtn.click();
        getActions().moveToElement(profileIcon).moveToElement(desktopInfoEmail).build().perform();
        return true;
    }

    public boolean LoginToApp(String mobileNo) {
        loginMobileInpt.sendKeys(mobileNo);
        loginContinueBtn.click();
        wait.until(ExpectedConditions.visibilityOf(verifyWithOtpImg)).click();
        enterOtp("");
        validateLogin(mobileNo);
        return true;
    }

    public void enterOtp(String otpValue) {
        int otpCounterValue = 0;
        char[] charArry = otpValue.toCharArray();
        for (char otpNo : charArry) {
            driver.findElement(By.xpath("//div[@class='otpContainer']/input[@data-val='" + otpCounterValue + "']")).sendKeys(String.valueOf(otpNo));
            otpCounterValue++;
        }
    }

    public boolean validateLogin(String mobileNo){
       return loggedInUserMob.getText().contains(mobileNo);
    }
}
