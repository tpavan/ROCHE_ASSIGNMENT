package flows;

import config.TestConfig;
import pages.CartPage;
import pages.LoginPage;
import pages.SearchProductPage;

public class SearchProductFlows extends TestConfig {

    private SearchProductPage searchProductPage = initPageWebElement(SearchProductPage.class);
    private LoginPage loginPage = initPageWebElement(LoginPage.class);
    private CartPage cartPage = initPageWebElement(CartPage.class);


    public void searchProductAndAddIntoWishList(String productToSearch) {
        searchProduct(productToSearch);
        addProductIntoWishList("2221510");
        if(driver.getCurrentUrl().contains("login?")){
            completeSignUp("");
        }
    }

    public void addProductFromWishListToCart(){
        cartPage.addItemToCart();
        cartPage.navigateToCart();
        cartPage.processCheckOut();
    }

    public boolean addProductIntoCart(){
        return cartPage.addProductToCart();
    }

    public void searchProduct(String productToSearch) {
        searchProductPage.searchProduct(productToSearch);
    }

    public void addProductIntoWishList(String productId) {
        searchProductPage.searchProductAndAddToWishList(productId);
    }

    public void addProductIntoWishListFromProductDtlsPage(String productId) {
        searchProductPage.searchProductAndAddToWishListFromProductDtlsPage(productId);
    }

    public void completeSignUp(String mobileNo){
        loginPage.LoginToApp(mobileNo);
    }

}
