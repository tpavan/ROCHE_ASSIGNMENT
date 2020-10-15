package tests;

import domain.Product;
import flows.FlowsInit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchProduct implements FlowsInit {

    private static final Logger LOGGER = LogManager.getLogger(SearchProduct.class.getName());

    private Product product;

    @Test(description = "Search the product and add it into Cart")
    public void searchProductAndAdditIntoCart(){
        LOGGER.info("Test: Search the product and add it into Cart");
        searchProductFlows.searchProductAndAddIntoWishList("Tshirts For Men");
        searchProductFlows.addProductFromWishListToCart();
    }

    @Test(description = "Search the product and add it into Cart")
    public void searchProductAndAdditIntoCartDtlsPage(){
        LOGGER.info("Test Start: Search the product and add it into Cart");
        product = Product.setProduct();
        searchProductFlows.searchProduct(product.getProductCategory());
        searchProductFlows.addProductIntoWishListFromProductDtlsPage(product.getProductNumber());
        searchProductFlows.addProductFromWishListToCart();
    }

    @Test(description = "Validate that added product can be removed from wishlist")
    public void validateProductCanBeRemovedFromWishList(){
        LOGGER.info("Test Start:Validate that added product can be removed from wishlist");
        product = Product.setProduct();
        searchProductFlows.searchProduct(product.getProductCategory());
        searchProductFlows.addProductIntoWishListFromProductDtlsPage(product.getProductNumber());
        searchProductFlows.addProductFromWishListToCart();
    }

    @Test(description = "Validate that product can be directly able to add into Cart")
    public void validateProductCanBeAddedToBagDirectly(){
        LOGGER.info("Test Start:Validate that product can be directly able to add into Cart");
        product = Product.setProduct();
        searchProductFlows.searchProduct(product.getProductCategory());
        searchProductFlows.addProductIntoWishListFromProductDtlsPage(product.getProductNumber());
        Assert.assertTrue(searchProductFlows.addProductIntoCart(),"Failed to add product into Cart");
    }
}
