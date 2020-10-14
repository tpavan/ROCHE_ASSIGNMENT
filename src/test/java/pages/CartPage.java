package pages;

import config.TestConfig;
import domain.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends TestConfig {

    @FindBy(using = "//a[@class='desktop-cart']", how = How.XPATH)
    public WebElement cartIcon;

    @FindBy(using = "//button[@class='inlinebuttonV2-base-actionButton itemContainer-base-inlineButton removeButton']", how = How.XPATH)
    public WebElement removeBtn;

    @FindBy(using = "//div[@class='button-base-button  ']", how = How.XPATH)
    public WebElement buyNowBtn;

    @FindBy(using = "earlyCheckout", how = How.ID)
    public WebElement earlyChekoutOpt;

    @FindBy(using = "//span[@class='priorityCheckoutModal-base-bold']", how = How.XPATH)
    public WebElement earlyAccessFeesCheckBox;

    @FindBy(using = "//button[@class='priorityCheckoutModal-base-confirm']", how = How.XPATH)
    public WebElement confirmBtn;

    @FindBy(using = "//div[@class='button-base-button  ']/..", how = How.XPATH)
    public WebElement placeOrderBtn;

    @FindBy(using = "name", how = How.ID)
    public WebElement addresNameInpt;

    @FindBy(using = "mobile", how = How.ID)
    public WebElement addressMobileNoBtn;

    @FindBy(using = "pincode", how = How.ID)
    public WebElement addrssPinInpt;

    @FindBy(using = "streetAddress", how = How.ID)
    public WebElement addressHouseNoInpt;

    @FindBy(using = "locality", how = How.ID)
    public WebElement addressLocalityInpt;

    @FindBy(using = "//span[@class='addressFormUI-base-defaultAddress']", how = How.XPATH)
    public WebElement defaultAddressCheckBox;

    @FindBy(using = "//div[@class='button-base-button addressFormUI-base-saveBtn ']", how = How.XPATH)
    public WebElement addAddressBtn;

    @FindBy(using = "//div[@class='addressList-base-titleContainer']/..//div[3]", how = How.XPATH)
    public WebElement addressContainerLabel;

    @FindBy(using = "placeOrderButton", how = How.ID)
    public WebElement contiuneBtn;

    @FindBy(using = "//div[@class='paymentDesktop-base-pModeHeading']", how = How.XPATH)
    public WebElement paymentScreenLabl;

    @FindBy(using = "//a[@class='desktop-wishlist']", how = How.XPATH)
    public WebElement wishListIcon;

    @FindBy( using ="//span[@class='index-heading']", how = How.XPATH )
    public WebElement myWishListLabel;

    @FindBy (using = "//a[@class='itemcard-moveToBag itemcard-boldFont']", how = How.XPATH)
    public WebElement moveToBagBtn;

    @FindBy (using = "//div[@class='sizeselect-done']", how = How.XPATH)
    public WebElement doneSelectionBtn;

    @FindBy (using = "//*[@class='pdp-flex pdp-column pdp-center pdp-align-start']", how = How.XPATH)
    public WebElement addProductToCartBtn;

    @FindBy (using = "//*[@class='pdp-flex pdp-column pdp-center pdp-align-start']/span[1]", how = How.XPATH)
    public WebElement gotToBagBtn;



    public void navigateToWishList() {
        wishListIcon.click();
        wait.until(ExpectedConditions.elementToBeClickable(removeBtn));
    }

    public void addItemToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(moveToBagBtn)).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//button[@class='sizeselect-big sizeselect-sizeButton']/b"));
        for(WebElement element : elementList){
            if(element.getText().equalsIgnoreCase("S")){
                element.click();
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(doneSelectionBtn)).click();
    }

    public void navigateToCart() {
        cartIcon.click();
        wait.until(ExpectedConditions.visibilityOf(myWishListLabel));
    }

    public boolean processCheckOut(){
        checkOut();
        fillAddressDetails(new Address());
        contiuneBtn.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentScreenLabl));
        return true;
    }

    public void checkOut() {
        wait.until(ExpectedConditions.elementToBeClickable(buyNowBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(earlyChekoutOpt)).click();
        wait.until(ExpectedConditions.elementToBeClickable(earlyAccessFeesCheckBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public void fillAddressDetails(Address address) {
        wait.until(ExpectedConditions.elementToBeClickable(addresNameInpt)).sendKeys(address.getCustomerName());
        wait.until(ExpectedConditions.elementToBeClickable(addressMobileNoBtn)).sendKeys(address.getCustomerMobileNo());
        wait.until(ExpectedConditions.elementToBeClickable(addrssPinInpt)).sendKeys(address.getCustomerPin());
        wait.until(ExpectedConditions.elementToBeClickable(addressHouseNoInpt)).sendKeys(address.getCustomerAddress());
        wait.until(ExpectedConditions.elementToBeClickable(addressLocalityInpt)).sendKeys(address.getCustomerLocacity());
        wait.until(ExpectedConditions.elementToBeClickable(defaultAddressCheckBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addAddressBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(addressContainerLabel));
    }

    public boolean addProductToCart(){
        addProductToCartBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(gotToBagBtn)).click();
        return driver.getCurrentUrl().contains("cart");
    }

}
