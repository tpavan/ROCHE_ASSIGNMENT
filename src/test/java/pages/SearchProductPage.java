package pages;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchProductPage extends TestConfig {

    @FindBy(using = "desktop-searchBar", how = How.CLASS_NAME)
    public WebElement searchProductInpt;

    @FindBy(using = "//p[@class='size-buttons-unified-size']", how = How.XPATH)
    public WebElement selectProductSize;

    @FindBy(using = "//*[@id='sizeButtonsContainer']/../div[3]/div/div[2]", how = How.XPATH)
    public WebElement wishListBtn;

    @FindBy(using = "//span[@class='myntraweb-sprite pdp-whiteWishlistIcon sprites-whiteWishlist pdp-flex pdp-center ']/../span[2]", how = How.XPATH)
    public WebElement wishListedLabl;

    @FindBy(using = "//a[@class='desktop-wishlist']", how = How.XPATH)
    public WebElement wishListIcon;

    @FindBy(using = "//*[@*='index-headingDiv']/span", how = How.XPATH)
    public WebElement wishListCountLabl;

    @FindBy(using = "//*[@*='itemcard-moveToBag itemcard-boldFont']", how = How.XPATH)
    public WebElement moveToBagBtn;

    @FindBy(using = "//*[@*='sizeselect-done']", how = How.XPATH)
    public WebElement doneBtn;

    @FindBy(using = "wishlistEmpty-heading", how = How.CLASS_NAME)
    public WebElement wishListEmotyLable;


    public void searchProduct(String productCategory) {
        searchProductInpt.sendKeys(productCategory);
        searchProductInpt.sendKeys(Keys.ENTER);
    }

    public void searchProductAndAddToWishList(String productID) {
        getActions()
                .moveToElement(getDriver()
                        .findElement(By.xpath("//li/a[contains(@href,'" + productID + "')]/div[2]")))
                .click()
                .moveToElement(driver.findElement(By.xpath("//li/a[contains(@href,'" + productID + "')]/div[2]/../../div[@class='product-actions ']/span")))
                .click()
                .build()
                .perform();
    }

    public void searchProductAndAddToWishListFromProductDtlsPage(String productID) {
        getDriver().findElement(By.xpath("//li/a[contains(@href,'" + productID + "')]/div[2]")).click();
        selectProductSize("S");
        addProductToWishListFromProductDetailsPage();
        navigateToWishListPageFromProductDetailsPage();
        addProductToCartPageFromWishList();
    }

    public void selectProductSize(String productSize) {
        List<WebElement> elementList = getDriver().findElements(By.xpath("//p[@class='size-buttons-unified-size']"));

        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase("S")) {
                element.click();
            }
        }
    }

    public boolean addProductToWishListFromProductDetailsPage() {
       // wishListBtn.click();
        JSClick(wishListBtn);
        return wishListedLabl.getText().equalsIgnoreCase("WISHLISTED");
    }

    public boolean navigateToWishListPageFromProductDetailsPage() {
        wishListIcon.click();
        return wishListCountLabl.getText().equalsIgnoreCase("My Wishlist ");
    }

    public void addProductToCartPageFromWishList() {
        moveToBagBtn.click();
        wait.until(ExpectedConditions.visibilityOf(doneBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(wishListEmotyLable));
    }
}
